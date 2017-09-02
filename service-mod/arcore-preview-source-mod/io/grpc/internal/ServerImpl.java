package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.Attributes;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Context.CancellableContext;
import io.grpc.Context.CancellationListener;
import io.grpc.Contexts;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCallHandler;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class ServerImpl
  extends Server
  implements WithLogId
{
  private static final ServerStreamListener NOOP_LISTENER = new NoopListener(null);
  private final CompressorRegistry compressorRegistry;
  private final DecompressorRegistry decompressorRegistry;
  private Executor executor;
  private final ObjectPool<? extends Executor> executorPool;
  private final HandlerRegistry fallbackRegistry;
  private final Object lock = new Object();
  private final LogId logId = LogId.allocate(getClass().getName());
  private final InternalHandlerRegistry registry;
  private final Context rootContext;
  @GuardedBy("lock")
  private boolean serverShutdownCallbackInvoked;
  @GuardedBy("lock")
  private boolean shutdown;
  @GuardedBy("lock")
  private Status shutdownNowStatus;
  @GuardedBy("lock")
  private boolean started;
  private final StatsContextFactory statsFactory;
  private final Supplier<Stopwatch> stopwatchSupplier;
  @GuardedBy("lock")
  private boolean terminated;
  private ScheduledExecutorService timeoutService;
  private final ObjectPool<ScheduledExecutorService> timeoutServicePool;
  private final List<ServerTransportFilter> transportFilters;
  private final InternalServer transportServer;
  @GuardedBy("lock")
  private boolean transportServerTerminated;
  @GuardedBy("lock")
  private final Collection<ServerTransport> transports = new HashSet();
  
  ServerImpl(ObjectPool<? extends Executor> paramObjectPool, ObjectPool<ScheduledExecutorService> paramObjectPool1, InternalHandlerRegistry paramInternalHandlerRegistry, HandlerRegistry paramHandlerRegistry, InternalServer paramInternalServer, Context paramContext, DecompressorRegistry paramDecompressorRegistry, CompressorRegistry paramCompressorRegistry, List<ServerTransportFilter> paramList, StatsContextFactory paramStatsContextFactory, Supplier<Stopwatch> paramSupplier)
  {
    this.executorPool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool, "executorPool"));
    this.timeoutServicePool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool1, "timeoutServicePool"));
    this.registry = ((InternalHandlerRegistry)Preconditions.checkNotNull(paramInternalHandlerRegistry, "registry"));
    this.fallbackRegistry = ((HandlerRegistry)Preconditions.checkNotNull(paramHandlerRegistry, "fallbackRegistry"));
    this.transportServer = ((InternalServer)Preconditions.checkNotNull(paramInternalServer, "transportServer"));
    this.rootContext = ((Context)Preconditions.checkNotNull(paramContext, "rootContext")).fork();
    this.decompressorRegistry = paramDecompressorRegistry;
    this.compressorRegistry = paramCompressorRegistry;
    this.transportFilters = Collections.unmodifiableList(new ArrayList(paramList));
    this.statsFactory = ((StatsContextFactory)Preconditions.checkNotNull(paramStatsContextFactory, "statsFactory"));
    this.stopwatchSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier, "stopwatchSupplier"));
  }
  
  private void checkForTermination()
  {
    synchronized (this.lock)
    {
      if ((!this.shutdown) || (!this.transports.isEmpty()) || (!this.transportServerTerminated)) {
        break label121;
      }
      if (this.terminated) {
        throw new AssertionError("Server already terminated");
      }
    }
    this.terminated = true;
    if (this.timeoutService != null) {
      this.timeoutService = ((ScheduledExecutorService)this.timeoutServicePool.returnObject(this.timeoutService));
    }
    if (this.executor != null) {
      this.executor = ((Executor)this.executorPool.returnObject(this.executor));
    }
    this.lock.notifyAll();
    label121:
  }
  
  private void transportClosed(ServerTransport paramServerTransport)
  {
    synchronized (this.lock)
    {
      if (!this.transports.remove(paramServerTransport)) {
        throw new AssertionError("Transport already removed");
      }
    }
    checkForTermination();
  }
  
  public void awaitTermination()
    throws InterruptedException
  {
    synchronized (this.lock)
    {
      if (!this.terminated) {
        this.lock.wait();
      }
    }
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    synchronized (this.lock)
    {
      paramLong = paramTimeUnit.toNanos(paramLong);
      long l1 = System.nanoTime();
      if (!this.terminated)
      {
        long l2 = l1 + paramLong - System.nanoTime();
        if (l2 > 0L) {
          TimeUnit.NANOSECONDS.timedWait(this.lock, l2);
        }
      }
    }
    boolean bool = this.terminated;
    return bool;
  }
  
  public List<ServerServiceDefinition> getImmutableServices()
  {
    return this.registry.getServices();
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  public List<ServerServiceDefinition> getMutableServices()
  {
    return Collections.unmodifiableList(this.fallbackRegistry.getServices());
  }
  
  public int getPort()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        Preconditions.checkState(this.started, "Not started");
        if (!this.terminated)
        {
          bool = true;
          Preconditions.checkState(bool, "Already terminated");
          int i = this.transportServer.getPort();
          return i;
        }
      }
      boolean bool = false;
    }
  }
  
  public List<ServerServiceDefinition> getServices()
  {
    List localList1 = this.fallbackRegistry.getServices();
    if (localList1.isEmpty()) {
      return this.registry.getServices();
    }
    List localList2 = this.registry.getServices();
    ArrayList localArrayList = new ArrayList(localList2.size() + localList1.size());
    localArrayList.addAll(localList2);
    localArrayList.addAll(localList1);
    return Collections.unmodifiableList(localArrayList);
  }
  
  public boolean isShutdown()
  {
    synchronized (this.lock)
    {
      boolean bool = this.shutdown;
      return bool;
    }
  }
  
  public boolean isTerminated()
  {
    synchronized (this.lock)
    {
      boolean bool = this.terminated;
      return bool;
    }
  }
  
  public ServerImpl shutdown()
  {
    synchronized (this.lock)
    {
      if (this.shutdown) {
        return this;
      }
      this.shutdown = true;
      boolean bool = this.started;
      if (!bool)
      {
        this.transportServerTerminated = true;
        checkForTermination();
      }
      if (bool)
      {
        this.transportServer.shutdown();
        return this;
      }
    }
    return this;
  }
  
  public ServerImpl shutdownNow()
  {
    shutdown();
    Status localStatus = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
    synchronized (this.lock)
    {
      if (this.shutdownNowStatus != null) {
        return this;
      }
      this.shutdownNowStatus = localStatus;
      ArrayList localArrayList = new ArrayList(this.transports);
      boolean bool = this.serverShutdownCallbackInvoked;
      if (bool)
      {
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((ServerTransport)((Iterator)???).next()).shutdownNow(localStatus);
        }
      }
    }
    return this;
  }
  
  public ServerImpl start()
    throws IOException
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.lock)
      {
        if (!this.started)
        {
          bool1 = true;
          Preconditions.checkState(bool1, "Already started");
          if (this.shutdown) {
            break label124;
          }
          bool1 = bool2;
          Preconditions.checkState(bool1, "Shutting down");
          this.transportServer.start(new ServerListenerImpl(null));
          this.timeoutService = ((ScheduledExecutorService)Preconditions.checkNotNull(this.timeoutServicePool.getObject(), "timeoutService"));
          this.executor = ((Executor)Preconditions.checkNotNull(this.executorPool.getObject(), "executor"));
          this.started = true;
          return this;
        }
      }
      boolean bool1 = false;
      continue;
      label124:
      bool1 = false;
    }
  }
  
  @VisibleForTesting
  static class JumpToApplicationThreadServerStreamListener
    implements ServerStreamListener
  {
    private final Executor callExecutor;
    private final Context.CancellableContext context;
    private ServerStreamListener listener;
    private final ServerStream stream;
    
    public JumpToApplicationThreadServerStreamListener(Executor paramExecutor, ServerStream paramServerStream, Context.CancellableContext paramCancellableContext)
    {
      this.callExecutor = paramExecutor;
      this.stream = paramServerStream;
      this.context = paramCancellableContext;
    }
    
    private ServerStreamListener getListener()
    {
      if (this.listener == null) {
        throw new IllegalStateException("listener unset");
      }
      return this.listener;
    }
    
    private void internalClose(Status paramStatus, Metadata paramMetadata)
    {
      this.stream.close(paramStatus, paramMetadata);
    }
    
    public void closed(final Status paramStatus)
    {
      this.callExecutor.execute(new ContextRunnable(this.context)
      {
        public void runInContext()
        {
          try
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().closed(paramStatus);
            return;
          }
          finally
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.context.cancel(paramStatus.getCause());
          }
        }
      });
    }
    
    public void halfClosed()
    {
      this.callExecutor.execute(new ContextRunnable(this.context)
      {
        public void runInContext()
        {
          try
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localRuntimeException), new Metadata());
            throw localRuntimeException;
          }
          catch (Error localError)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localError), new Metadata());
            throw localError;
          }
        }
      });
    }
    
    public void messageRead(final InputStream paramInputStream)
    {
      this.callExecutor.execute(new ContextRunnable(this.context)
      {
        public void runInContext()
        {
          try
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().messageRead(paramInputStream);
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localRuntimeException), new Metadata());
            throw localRuntimeException;
          }
          catch (Error localError)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localError), new Metadata());
            throw localError;
          }
        }
      });
    }
    
    public void onReady()
    {
      this.callExecutor.execute(new ContextRunnable(this.context)
      {
        public void runInContext()
        {
          try
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localRuntimeException), new Metadata());
            throw localRuntimeException;
          }
          catch (Error localError)
          {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(localError), new Metadata());
            throw localError;
          }
        }
      });
    }
    
    @VisibleForTesting
    void setListener(ServerStreamListener paramServerStreamListener)
    {
      Preconditions.checkNotNull(paramServerStreamListener, "listener must not be null");
      if (this.listener == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Listener already set");
        this.listener = paramServerStreamListener;
        return;
      }
    }
  }
  
  private static class NoopListener
    implements ServerStreamListener
  {
    public void closed(Status paramStatus) {}
    
    public void halfClosed() {}
    
    public void messageRead(InputStream paramInputStream)
    {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        throw new RuntimeException(paramInputStream);
      }
    }
    
    public void onReady() {}
  }
  
  private class ServerListenerImpl
    implements ServerListener
  {
    private ServerListenerImpl() {}
    
    public void serverShutdown()
    {
      for (;;)
      {
        Object localObject4;
        synchronized (ServerImpl.this.lock)
        {
          localObject4 = new ArrayList(ServerImpl.this.transports);
          Status localStatus1 = ServerImpl.this.shutdownNowStatus;
          ServerImpl.access$502(ServerImpl.this, true);
          ??? = ((ArrayList)localObject4).iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject4 = (ServerTransport)((Iterator)???).next();
          if (localStatus1 == null) {
            ((ServerTransport)localObject4).shutdown();
          }
        }
        ((ServerTransport)localObject4).shutdownNow(localStatus2);
      }
      synchronized (ServerImpl.this.lock)
      {
        ServerImpl.access$602(ServerImpl.this, true);
        ServerImpl.this.checkForTermination();
        return;
      }
    }
    
    public ServerTransportListener transportCreated(ServerTransport paramServerTransport)
    {
      synchronized (ServerImpl.this.lock)
      {
        ServerImpl.this.transports.add(paramServerTransport);
        return new ServerImpl.ServerTransportListenerImpl(ServerImpl.this, paramServerTransport);
      }
    }
  }
  
  private class ServerTransportListenerImpl
    implements ServerTransportListener
  {
    private Attributes attributes;
    private final ServerTransport transport;
    
    public ServerTransportListenerImpl(ServerTransport paramServerTransport)
    {
      this.transport = paramServerTransport;
    }
    
    private Context.CancellableContext createContext(final ServerStream paramServerStream, Metadata paramMetadata)
    {
      paramMetadata = (Long)paramMetadata.get(GrpcUtil.TIMEOUT_KEY);
      Context localContext = ServerImpl.this.rootContext;
      if (paramMetadata == null) {
        return localContext.withCancellation();
      }
      paramMetadata = localContext.withDeadlineAfter(paramMetadata.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.timeoutService);
      paramMetadata.addListener(new Context.CancellationListener()
      {
        public void cancelled(Context paramAnonymousContext)
        {
          paramAnonymousContext = Contexts.statusFromCancelled(paramAnonymousContext);
          if (Status.DEADLINE_EXCEEDED.getCode().equals(paramAnonymousContext.getCode())) {
            paramServerStream.cancel(paramAnonymousContext);
          }
        }
      }, MoreExecutors.directExecutor());
      return paramMetadata;
    }
    
    private <ReqT, RespT> ServerStreamListener startCall(ServerStream paramServerStream, String paramString, ServerMethodDefinition<ReqT, RespT> paramServerMethodDefinition, Metadata paramMetadata, Context.CancellableContext paramCancellableContext)
    {
      paramServerStream = new ServerCallImpl(paramServerStream, paramServerMethodDefinition.getMethodDescriptor(), paramMetadata, paramCancellableContext, paramServerStream.statsTraceContext(), ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry);
      paramServerMethodDefinition = paramServerMethodDefinition.getServerCallHandler().startCall(paramServerStream, paramMetadata);
      if (paramServerMethodDefinition == null) {
        throw new NullPointerException("startCall() returned a null listener for method " + paramString);
      }
      return paramServerStream.newServerStreamListener(paramServerMethodDefinition);
    }
    
    public StatsTraceContext methodDetermined(String paramString, Metadata paramMetadata)
    {
      return StatsTraceContext.newServerContext(paramString, ServerImpl.this.statsFactory, paramMetadata, ServerImpl.this.stopwatchSupplier);
    }
    
    public void streamCreated(final ServerStream paramServerStream, final String paramString, final Metadata paramMetadata)
    {
      final StatsTraceContext localStatsTraceContext = (StatsTraceContext)Preconditions.checkNotNull(paramServerStream.statsTraceContext(), "statsTraceCtx not present from stream");
      final Context.CancellableContext localCancellableContext = createContext(paramServerStream, paramMetadata);
      if (ServerImpl.this.executor == MoreExecutors.directExecutor()) {}
      for (Object localObject = new SerializeReentrantCallsDirectExecutor();; localObject = new SerializingExecutor(ServerImpl.this.executor))
      {
        final ServerImpl.JumpToApplicationThreadServerStreamListener localJumpToApplicationThreadServerStreamListener = new ServerImpl.JumpToApplicationThreadServerStreamListener((Executor)localObject, paramServerStream, localCancellableContext);
        paramServerStream.setListener(localJumpToApplicationThreadServerStreamListener);
        ((Executor)localObject).execute(new ContextRunnable(localCancellableContext)
        {
          /* Error */
          public void runInContext()
          {
            // Byte code:
            //   0: invokestatic 56	io/grpc/internal/ServerImpl:access$1300	()Lio/grpc/internal/ServerStreamListener;
            //   3: astore_3
            //   4: aload_0
            //   5: getfield 30	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:this$1	Lio/grpc/internal/ServerImpl$ServerTransportListenerImpl;
            //   8: getfield 60	io/grpc/internal/ServerImpl$ServerTransportListenerImpl:this$0	Lio/grpc/internal/ServerImpl;
            //   11: invokestatic 64	io/grpc/internal/ServerImpl:access$1400	(Lio/grpc/internal/ServerImpl;)Lio/grpc/internal/InternalHandlerRegistry;
            //   14: aload_0
            //   15: getfield 32	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$methodName	Ljava/lang/String;
            //   18: invokevirtual 70	io/grpc/internal/InternalHandlerRegistry:lookupMethod	(Ljava/lang/String;)Lio/grpc/ServerMethodDefinition;
            //   21: astore_2
            //   22: aload_2
            //   23: astore_1
            //   24: aload_2
            //   25: ifnonnull +30 -> 55
            //   28: aload_0
            //   29: getfield 30	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:this$1	Lio/grpc/internal/ServerImpl$ServerTransportListenerImpl;
            //   32: getfield 60	io/grpc/internal/ServerImpl$ServerTransportListenerImpl:this$0	Lio/grpc/internal/ServerImpl;
            //   35: invokestatic 74	io/grpc/internal/ServerImpl:access$1500	(Lio/grpc/internal/ServerImpl;)Lio/grpc/HandlerRegistry;
            //   38: aload_0
            //   39: getfield 32	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$methodName	Ljava/lang/String;
            //   42: aload_0
            //   43: getfield 34	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$stream	Lio/grpc/internal/ServerStream;
            //   46: invokeinterface 80 1 0
            //   51: invokevirtual 85	io/grpc/HandlerRegistry:lookupMethod	(Ljava/lang/String;Ljava/lang/String;)Lio/grpc/ServerMethodDefinition;
            //   54: astore_1
            //   55: aload_1
            //   56: ifnonnull +75 -> 131
            //   59: getstatic 91	io/grpc/Status:UNIMPLEMENTED	Lio/grpc/Status;
            //   62: new 93	java/lang/StringBuilder
            //   65: dup
            //   66: invokespecial 95	java/lang/StringBuilder:<init>	()V
            //   69: ldc 97
            //   71: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   74: aload_0
            //   75: getfield 32	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$methodName	Ljava/lang/String;
            //   78: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   81: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   84: invokevirtual 108	io/grpc/Status:withDescription	(Ljava/lang/String;)Lio/grpc/Status;
            //   87: astore_1
            //   88: aload_0
            //   89: getfield 34	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$stream	Lio/grpc/internal/ServerStream;
            //   92: aload_1
            //   93: new 110	io/grpc/Metadata
            //   96: dup
            //   97: invokespecial 111	io/grpc/Metadata:<init>	()V
            //   100: invokeinterface 115 3 0
            //   105: aload_0
            //   106: getfield 36	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$statsTraceCtx	Lio/grpc/internal/StatsTraceContext;
            //   109: aload_1
            //   110: invokevirtual 121	io/grpc/internal/StatsTraceContext:callEnded	(Lio/grpc/Status;)V
            //   113: aload_0
            //   114: getfield 38	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$context	Lio/grpc/Context$CancellableContext;
            //   117: aconst_null
            //   118: invokevirtual 127	io/grpc/Context$CancellableContext:cancel	(Ljava/lang/Throwable;)Z
            //   121: pop
            //   122: aload_0
            //   123: getfield 42	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$jumpListener	Lio/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener;
            //   126: aload_3
            //   127: invokevirtual 133	io/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener:setListener	(Lio/grpc/internal/ServerStreamListener;)V
            //   130: return
            //   131: aload_0
            //   132: getfield 30	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:this$1	Lio/grpc/internal/ServerImpl$ServerTransportListenerImpl;
            //   135: aload_0
            //   136: getfield 34	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$stream	Lio/grpc/internal/ServerStream;
            //   139: aload_0
            //   140: getfield 32	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$methodName	Ljava/lang/String;
            //   143: aload_1
            //   144: aload_0
            //   145: getfield 40	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$headers	Lio/grpc/Metadata;
            //   148: aload_0
            //   149: getfield 38	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$context	Lio/grpc/Context$CancellableContext;
            //   152: invokestatic 137	io/grpc/internal/ServerImpl$ServerTransportListenerImpl:access$1600	(Lio/grpc/internal/ServerImpl$ServerTransportListenerImpl;Lio/grpc/internal/ServerStream;Ljava/lang/String;Lio/grpc/ServerMethodDefinition;Lio/grpc/Metadata;Lio/grpc/Context$CancellableContext;)Lio/grpc/internal/ServerStreamListener;
            //   155: astore_1
            //   156: aload_0
            //   157: getfield 42	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$jumpListener	Lio/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener;
            //   160: aload_1
            //   161: invokevirtual 133	io/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener:setListener	(Lio/grpc/internal/ServerStreamListener;)V
            //   164: return
            //   165: astore_1
            //   166: aload_0
            //   167: getfield 34	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$stream	Lio/grpc/internal/ServerStream;
            //   170: aload_1
            //   171: invokestatic 141	io/grpc/Status:fromThrowable	(Ljava/lang/Throwable;)Lio/grpc/Status;
            //   174: new 110	io/grpc/Metadata
            //   177: dup
            //   178: invokespecial 111	io/grpc/Metadata:<init>	()V
            //   181: invokeinterface 115 3 0
            //   186: aload_0
            //   187: getfield 38	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$context	Lio/grpc/Context$CancellableContext;
            //   190: aconst_null
            //   191: invokevirtual 127	io/grpc/Context$CancellableContext:cancel	(Ljava/lang/Throwable;)Z
            //   194: pop
            //   195: aload_1
            //   196: athrow
            //   197: astore_1
            //   198: aload_0
            //   199: getfield 42	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$jumpListener	Lio/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener;
            //   202: aload_3
            //   203: invokevirtual 133	io/grpc/internal/ServerImpl$JumpToApplicationThreadServerStreamListener:setListener	(Lio/grpc/internal/ServerStreamListener;)V
            //   206: aload_1
            //   207: athrow
            //   208: astore_1
            //   209: aload_0
            //   210: getfield 34	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$stream	Lio/grpc/internal/ServerStream;
            //   213: aload_1
            //   214: invokestatic 141	io/grpc/Status:fromThrowable	(Ljava/lang/Throwable;)Lio/grpc/Status;
            //   217: new 110	io/grpc/Metadata
            //   220: dup
            //   221: invokespecial 111	io/grpc/Metadata:<init>	()V
            //   224: invokeinterface 115 3 0
            //   229: aload_0
            //   230: getfield 38	io/grpc/internal/ServerImpl$ServerTransportListenerImpl$1:val$context	Lio/grpc/Context$CancellableContext;
            //   233: aconst_null
            //   234: invokevirtual 127	io/grpc/Context$CancellableContext:cancel	(Ljava/lang/Throwable;)Z
            //   237: pop
            //   238: aload_1
            //   239: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	240	0	this	1
            //   23	138	1	localObject1	Object
            //   165	31	1	localRuntimeException	RuntimeException
            //   197	10	1	localObject2	Object
            //   208	31	1	localError	Error
            //   21	4	2	localServerMethodDefinition	ServerMethodDefinition
            //   3	200	3	localServerStreamListener	ServerStreamListener
            // Exception table:
            //   from	to	target	type
            //   4	22	165	java/lang/RuntimeException
            //   28	55	165	java/lang/RuntimeException
            //   59	122	165	java/lang/RuntimeException
            //   131	156	165	java/lang/RuntimeException
            //   4	22	197	finally
            //   28	55	197	finally
            //   59	122	197	finally
            //   131	156	197	finally
            //   166	197	197	finally
            //   209	240	197	finally
            //   4	22	208	java/lang/Error
            //   28	55	208	java/lang/Error
            //   59	122	208	java/lang/Error
            //   131	156	208	java/lang/Error
          }
        });
        return;
      }
    }
    
    public Attributes transportReady(Attributes paramAttributes)
    {
      Iterator localIterator = ServerImpl.this.transportFilters.iterator();
      while (localIterator.hasNext())
      {
        ServerTransportFilter localServerTransportFilter = (ServerTransportFilter)localIterator.next();
        paramAttributes = (Attributes)Preconditions.checkNotNull(localServerTransportFilter.transportReady(paramAttributes), "Filter %s returned null", new Object[] { localServerTransportFilter });
      }
      this.attributes = paramAttributes;
      return paramAttributes;
    }
    
    public void transportTerminated()
    {
      Iterator localIterator = ServerImpl.this.transportFilters.iterator();
      while (localIterator.hasNext()) {
        ((ServerTransportFilter)localIterator.next()).transportTerminated(this.attributes);
      }
      ServerImpl.this.transportClosed(this.transport);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */