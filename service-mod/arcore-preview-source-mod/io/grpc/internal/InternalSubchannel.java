package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.ForOverride;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Status;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InternalSubchannel
  implements WithLogId
{
  private static final Logger log = Logger.getLogger(InternalSubchannel.class.getName());
  @Nullable
  private volatile ManagedClientTransport activeTransport;
  private final EquivalentAddressGroup addressGroup;
  private final String authority;
  private final BackoffPolicy.Provider backoffPolicyProvider;
  private final Callback callback;
  private final ChannelExecutor channelExecutor;
  @GuardedBy("lock")
  private final Stopwatch connectingTimer;
  private final InUseStateAggregator<ConnectionClientTransport> inUseStateAggregator = new InUseStateAggregator()
  {
    void handleInUse()
    {
      InternalSubchannel.this.callback.onInUse(InternalSubchannel.this);
    }
    
    void handleNotInUse()
    {
      InternalSubchannel.this.callback.onNotInUse(InternalSubchannel.this);
    }
  };
  private final Object lock = new Object();
  private final LogId logId = LogId.allocate(getClass().getName());
  @GuardedBy("lock")
  private int nextAddressIndex;
  @Nullable
  @GuardedBy("lock")
  private ConnectionClientTransport pendingTransport;
  @GuardedBy("lock")
  private BackoffPolicy reconnectPolicy;
  @Nullable
  @GuardedBy("lock")
  private ScheduledFuture<?> reconnectTask;
  private final ScheduledExecutorService scheduledExecutor;
  @GuardedBy("lock")
  private ConnectivityStateInfo state = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);
  private final ClientTransportFactory transportFactory;
  @GuardedBy("lock")
  private final Collection<ConnectionClientTransport> transports = new ArrayList();
  private final String userAgent;
  
  InternalSubchannel(EquivalentAddressGroup paramEquivalentAddressGroup, String paramString1, String paramString2, BackoffPolicy.Provider paramProvider, ClientTransportFactory paramClientTransportFactory, ScheduledExecutorService paramScheduledExecutorService, Supplier<Stopwatch> paramSupplier, ChannelExecutor paramChannelExecutor, Callback paramCallback)
  {
    this.addressGroup = ((EquivalentAddressGroup)Preconditions.checkNotNull(paramEquivalentAddressGroup, "addressGroup"));
    this.authority = paramString1;
    this.userAgent = paramString2;
    this.backoffPolicyProvider = paramProvider;
    this.transportFactory = paramClientTransportFactory;
    this.scheduledExecutor = paramScheduledExecutorService;
    this.connectingTimer = ((Stopwatch)paramSupplier.get());
    this.channelExecutor = paramChannelExecutor;
    this.callback = paramCallback;
  }
  
  @GuardedBy("lock")
  private void cancelReconnectTask()
  {
    if (this.reconnectTask != null)
    {
      this.reconnectTask.cancel(false);
      this.reconnectTask = null;
    }
  }
  
  @GuardedBy("lock")
  private void gotoNonErrorState(ConnectivityState paramConnectivityState)
  {
    gotoState(ConnectivityStateInfo.forNonError(paramConnectivityState));
  }
  
  @GuardedBy("lock")
  private void gotoState(final ConnectivityStateInfo paramConnectivityStateInfo)
  {
    if (this.state.getState() != paramConnectivityStateInfo.getState()) {
      if (this.state.getState() == ConnectivityState.SHUTDOWN) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Cannot transition out of SHUTDOWN to " + paramConnectivityStateInfo);
      this.state = paramConnectivityStateInfo;
      this.channelExecutor.executeLater(new Runnable()
      {
        public void run()
        {
          InternalSubchannel.this.callback.onStateChange(InternalSubchannel.this, paramConnectivityStateInfo);
        }
      });
      return;
    }
  }
  
  @GuardedBy("lock")
  private void handleTermination()
  {
    this.channelExecutor.executeLater(new Runnable()
    {
      public void run()
      {
        InternalSubchannel.this.callback.onTerminated(InternalSubchannel.this);
      }
    });
  }
  
  private void handleTransportInUseState(final ConnectionClientTransport paramConnectionClientTransport, final boolean paramBoolean)
  {
    this.channelExecutor.executeLater(new Runnable()
    {
      public void run()
      {
        InternalSubchannel.this.inUseStateAggregator.updateObjectInUse(paramConnectionClientTransport, paramBoolean);
      }
    }).drain();
  }
  
  @GuardedBy("lock")
  private void scheduleBackoff(Status paramStatus)
  {
    boolean bool = true;
    gotoState(ConnectivityStateInfo.forTransientFailure(paramStatus));
    if (this.reconnectPolicy == null) {
      this.reconnectPolicy = this.backoffPolicyProvider.get();
    }
    long l = this.reconnectPolicy.nextBackoffMillis() - this.connectingTimer.elapsed(TimeUnit.MILLISECONDS);
    if (log.isLoggable(Level.FINE)) {
      log.log(Level.FINE, "[{0}] Scheduling backoff for {1} ms", new Object[] { this.logId, Long.valueOf(l) });
    }
    if (this.reconnectTask == null) {}
    for (;;)
    {
      Preconditions.checkState(bool, "previous reconnectTask is not done");
      this.reconnectTask = this.scheduledExecutor.schedule(new LogExceptionRunnable(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   4: invokestatic 26	io/grpc/internal/InternalSubchannel:access$100	(Lio/grpc/internal/InternalSubchannel;)Ljava/lang/Object;
          //   7: astore_1
          //   8: aload_1
          //   9: monitorenter
          //   10: aload_0
          //   11: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   14: aconst_null
          //   15: invokestatic 30	io/grpc/internal/InternalSubchannel:access$202	(Lio/grpc/internal/InternalSubchannel;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
          //   18: pop
          //   19: aload_0
          //   20: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   23: invokestatic 34	io/grpc/internal/InternalSubchannel:access$300	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/ConnectivityStateInfo;
          //   26: invokevirtual 40	io/grpc/ConnectivityStateInfo:getState	()Lio/grpc/ConnectivityState;
          //   29: getstatic 46	io/grpc/ConnectivityState:SHUTDOWN	Lio/grpc/ConnectivityState;
          //   32: if_acmpne +16 -> 48
          //   35: aload_1
          //   36: monitorexit
          //   37: aload_0
          //   38: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   41: invokestatic 50	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
          //   44: invokevirtual 55	io/grpc/internal/ChannelExecutor:drain	()V
          //   47: return
          //   48: aload_0
          //   49: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   52: getstatic 58	io/grpc/ConnectivityState:CONNECTING	Lio/grpc/ConnectivityState;
          //   55: invokestatic 62	io/grpc/internal/InternalSubchannel:access$400	(Lio/grpc/internal/InternalSubchannel;Lio/grpc/ConnectivityState;)V
          //   58: aload_0
          //   59: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   62: invokestatic 65	io/grpc/internal/InternalSubchannel:access$500	(Lio/grpc/internal/InternalSubchannel;)V
          //   65: aload_1
          //   66: monitorexit
          //   67: aload_0
          //   68: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   71: invokestatic 50	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
          //   74: invokevirtual 55	io/grpc/internal/ChannelExecutor:drain	()V
          //   77: return
          //   78: astore_2
          //   79: aload_1
          //   80: monitorexit
          //   81: aload_2
          //   82: athrow
          //   83: astore_1
          //   84: invokestatic 69	io/grpc/internal/InternalSubchannel:access$600	()Ljava/util/logging/Logger;
          //   87: getstatic 75	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
          //   90: ldc 77
          //   92: aload_1
          //   93: invokevirtual 83	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
          //   96: aload_0
          //   97: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   100: invokestatic 50	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
          //   103: invokevirtual 55	io/grpc/internal/ChannelExecutor:drain	()V
          //   106: return
          //   107: astore_1
          //   108: aload_0
          //   109: getfield 15	io/grpc/internal/InternalSubchannel$1EndOfCurrentBackoff:this$0	Lio/grpc/internal/InternalSubchannel;
          //   112: invokestatic 50	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
          //   115: invokevirtual 55	io/grpc/internal/ChannelExecutor:drain	()V
          //   118: aload_1
          //   119: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	120	0	this	1EndOfCurrentBackoff
          //   83	10	1	localThrowable	Throwable
          //   107	12	1	localObject2	Object
          //   78	4	2	localObject3	Object
          // Exception table:
          //   from	to	target	type
          //   10	37	78	finally
          //   48	67	78	finally
          //   79	81	78	finally
          //   0	10	83	java/lang/Throwable
          //   81	83	83	java/lang/Throwable
          //   0	10	107	finally
          //   81	83	107	finally
          //   84	96	107	finally
        }
      }), l, TimeUnit.MILLISECONDS);
      return;
      bool = false;
    }
  }
  
  @GuardedBy("lock")
  private void startNewTransport()
  {
    if (this.reconnectTask == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Should have no reconnectTask scheduled");
      if (this.nextAddressIndex == 0) {
        this.connectingTimer.reset().start();
      }
      Object localObject2 = this.addressGroup.getAddresses();
      int i = this.nextAddressIndex;
      this.nextAddressIndex = (i + 1);
      Object localObject1 = (SocketAddress)((List)localObject2).get(i);
      if (this.nextAddressIndex >= ((List)localObject2).size()) {
        this.nextAddressIndex = 0;
      }
      localObject2 = this.transportFactory.newClientTransport((SocketAddress)localObject1, this.authority, this.userAgent);
      if (log.isLoggable(Level.FINE)) {
        log.log(Level.FINE, "[{0}] Created {1} for {2}", new Object[] { this.logId, ((ConnectionClientTransport)localObject2).getLogId(), localObject1 });
      }
      this.pendingTransport = ((ConnectionClientTransport)localObject2);
      this.transports.add(localObject2);
      localObject1 = ((ConnectionClientTransport)localObject2).start(new TransportListener((ConnectionClientTransport)localObject2, (SocketAddress)localObject1));
      if (localObject1 != null) {
        this.channelExecutor.executeLater((Runnable)localObject1);
      }
      return;
    }
  }
  
  EquivalentAddressGroup getAddressGroup()
  {
    return this.addressGroup;
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  /* Error */
  @com.google.common.annotations.VisibleForTesting
  ConnectivityState getState()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	io/grpc/internal/InternalSubchannel:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 128	io/grpc/internal/InternalSubchannel:state	Lio/grpc/ConnectivityStateInfo;
    //   11: invokevirtual 249	io/grpc/ConnectivityStateInfo:getState	()Lio/grpc/ConnectivityState;
    //   14: astore_2
    //   15: aload_1
    //   16: monitorexit
    //   17: aload_0
    //   18: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   21: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   24: aload_2
    //   25: areturn
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   36: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	InternalSubchannel
    //   31	9	1	localObject2	Object
    //   14	11	2	localConnectivityState	ConnectivityState
    //   26	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	26	finally
    //   27	29	26	finally
    //   0	7	31	finally
    //   29	31	31	finally
  }
  
  /* Error */
  @Nullable
  ClientTransport obtainActiveTransport()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 183	io/grpc/internal/InternalSubchannel:activeTransport	Lio/grpc/internal/ManagedClientTransport;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: getfield 104	io/grpc/internal/InternalSubchannel:lock	Ljava/lang/Object;
    //   15: astore_1
    //   16: aload_1
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 183	io/grpc/internal/InternalSubchannel:activeTransport	Lio/grpc/internal/ManagedClientTransport;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +14 -> 38
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   33: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   36: aload_2
    //   37: areturn
    //   38: aload_0
    //   39: getfield 128	io/grpc/internal/InternalSubchannel:state	Lio/grpc/ConnectivityStateInfo;
    //   42: invokevirtual 249	io/grpc/ConnectivityStateInfo:getState	()Lio/grpc/ConnectivityState;
    //   45: getstatic 120	io/grpc/ConnectivityState:IDLE	Lio/grpc/ConnectivityState;
    //   48: if_acmpne +14 -> 62
    //   51: aload_0
    //   52: getstatic 404	io/grpc/ConnectivityState:CONNECTING	Lio/grpc/ConnectivityState;
    //   55: invokespecial 221	io/grpc/internal/InternalSubchannel:gotoNonErrorState	(Lio/grpc/ConnectivityState;)V
    //   58: aload_0
    //   59: invokespecial 225	io/grpc/internal/InternalSubchannel:startNewTransport	()V
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_0
    //   65: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   68: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   83: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	InternalSubchannel
    //   78	9	1	localObject2	Object
    //   22	15	2	localManagedClientTransport	ManagedClientTransport
    //   73	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	73	finally
    //   27	29	73	finally
    //   38	62	73	finally
    //   62	64	73	finally
    //   74	76	73	finally
    //   11	18	78	finally
    //   76	78	78	finally
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	io/grpc/internal/InternalSubchannel:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 128	io/grpc/internal/InternalSubchannel:state	Lio/grpc/ConnectivityStateInfo;
    //   11: invokevirtual 249	io/grpc/ConnectivityStateInfo:getState	()Lio/grpc/ConnectivityState;
    //   14: getstatic 252	io/grpc/ConnectivityState:SHUTDOWN	Lio/grpc/ConnectivityState;
    //   17: if_acmpne +13 -> 30
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   26: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   29: return
    //   30: aload_0
    //   31: getstatic 252	io/grpc/ConnectivityState:SHUTDOWN	Lio/grpc/ConnectivityState;
    //   34: invokespecial 221	io/grpc/internal/InternalSubchannel:gotoNonErrorState	(Lio/grpc/ConnectivityState;)V
    //   37: aload_0
    //   38: getfield 183	io/grpc/internal/InternalSubchannel:activeTransport	Lio/grpc/internal/ManagedClientTransport;
    //   41: astore_2
    //   42: aload_0
    //   43: getfield 189	io/grpc/internal/InternalSubchannel:pendingTransport	Lio/grpc/internal/ConnectionClientTransport;
    //   46: astore_3
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 183	io/grpc/internal/InternalSubchannel:activeTransport	Lio/grpc/internal/ManagedClientTransport;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 189	io/grpc/internal/InternalSubchannel:pendingTransport	Lio/grpc/internal/ConnectionClientTransport;
    //   57: aload_0
    //   58: getfield 109	io/grpc/internal/InternalSubchannel:transports	Ljava/util/Collection;
    //   61: invokeinterface 410 1 0
    //   66: ifeq +35 -> 101
    //   69: aload_0
    //   70: invokespecial 209	io/grpc/internal/InternalSubchannel:handleTermination	()V
    //   73: getstatic 85	io/grpc/internal/InternalSubchannel:log	Ljava/util/logging/Logger;
    //   76: getstatic 317	java/util/logging/Level:FINE	Ljava/util/logging/Level;
    //   79: invokevirtual 321	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   82: ifeq +19 -> 101
    //   85: getstatic 85	io/grpc/internal/InternalSubchannel:log	Ljava/util/logging/Logger;
    //   88: getstatic 317	java/util/logging/Level:FINE	Ljava/util/logging/Level;
    //   91: ldc_w 412
    //   94: aload_0
    //   95: getfield 102	io/grpc/internal/InternalSubchannel:logId	Lio/grpc/internal/LogId;
    //   98: invokevirtual 415	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Object;)V
    //   101: aload_0
    //   102: invokespecial 417	io/grpc/internal/InternalSubchannel:cancelReconnectTask	()V
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   111: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 421 1 0
    //   124: aload_3
    //   125: ifnull -96 -> 29
    //   128: aload_3
    //   129: invokeinterface 422 1 0
    //   134: return
    //   135: astore_2
    //   136: aload_1
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 161	io/grpc/internal/InternalSubchannel:channelExecutor	Lio/grpc/internal/ChannelExecutor;
    //   145: invokevirtual 286	io/grpc/internal/ChannelExecutor:drain	()V
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	InternalSubchannel
    //   140	9	1	localObject2	Object
    //   41	78	2	localManagedClientTransport	ManagedClientTransport
    //   135	4	2	localObject3	Object
    //   46	83	3	localConnectionClientTransport	ConnectionClientTransport
    // Exception table:
    //   from	to	target	type
    //   7	22	135	finally
    //   30	101	135	finally
    //   101	107	135	finally
    //   136	138	135	finally
    //   0	7	140	finally
    //   138	140	140	finally
  }
  
  void shutdownNow(Status paramStatus)
  {
    shutdown();
    try
    {
      synchronized (this.lock)
      {
        ArrayList localArrayList = new ArrayList(this.transports);
        this.channelExecutor.drain();
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((ManagedClientTransport)((Iterator)???).next()).shutdownNow(paramStatus);
        }
      }
      return;
    }
    finally
    {
      this.channelExecutor.drain();
    }
  }
  
  static abstract class Callback
  {
    @ForOverride
    void onInUse(InternalSubchannel paramInternalSubchannel) {}
    
    @ForOverride
    void onNotInUse(InternalSubchannel paramInternalSubchannel) {}
    
    @ForOverride
    void onStateChange(InternalSubchannel paramInternalSubchannel, ConnectivityStateInfo paramConnectivityStateInfo) {}
    
    @ForOverride
    void onTerminated(InternalSubchannel paramInternalSubchannel) {}
  }
  
  private class TransportListener
    implements ManagedClientTransport.Listener
  {
    final SocketAddress address;
    final ConnectionClientTransport transport;
    
    TransportListener(ConnectionClientTransport paramConnectionClientTransport, SocketAddress paramSocketAddress)
    {
      this.transport = paramConnectionClientTransport;
      this.address = paramSocketAddress;
    }
    
    public void transportInUse(boolean paramBoolean)
    {
      InternalSubchannel.this.handleTransportInUseState(this.transport, paramBoolean);
    }
    
    /* Error */
    public void transportReady()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: invokestatic 38	io/grpc/internal/InternalSubchannel:access$600	()Ljava/util/logging/Logger;
      //   5: getstatic 44	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   8: invokevirtual 50	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
      //   11: ifeq +47 -> 58
      //   14: invokestatic 38	io/grpc/internal/InternalSubchannel:access$600	()Ljava/util/logging/Logger;
      //   17: getstatic 44	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   20: ldc 52
      //   22: iconst_3
      //   23: anewarray 4	java/lang/Object
      //   26: dup
      //   27: iconst_0
      //   28: aload_0
      //   29: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   32: invokestatic 56	io/grpc/internal/InternalSubchannel:access$900	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/LogId;
      //   35: aastore
      //   36: dup
      //   37: iconst_1
      //   38: aload_0
      //   39: getfield 24	io/grpc/internal/InternalSubchannel$TransportListener:transport	Lio/grpc/internal/ConnectionClientTransport;
      //   42: invokeinterface 62 1 0
      //   47: aastore
      //   48: dup
      //   49: iconst_2
      //   50: aload_0
      //   51: getfield 26	io/grpc/internal/InternalSubchannel$TransportListener:address	Ljava/net/SocketAddress;
      //   54: aastore
      //   55: invokevirtual 66	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: aload_0
      //   59: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   62: invokestatic 70	io/grpc/internal/InternalSubchannel:access$100	(Lio/grpc/internal/InternalSubchannel;)Ljava/lang/Object;
      //   65: astore_2
      //   66: aload_2
      //   67: monitorenter
      //   68: aload_0
      //   69: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   72: invokestatic 74	io/grpc/internal/InternalSubchannel:access$300	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/ConnectivityStateInfo;
      //   75: invokevirtual 80	io/grpc/ConnectivityStateInfo:getState	()Lio/grpc/ConnectivityState;
      //   78: astore_3
      //   79: aload_0
      //   80: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   83: aconst_null
      //   84: invokestatic 84	io/grpc/internal/InternalSubchannel:access$1002	(Lio/grpc/internal/InternalSubchannel;Lio/grpc/internal/BackoffPolicy;)Lio/grpc/internal/BackoffPolicy;
      //   87: pop
      //   88: aload_0
      //   89: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   92: iconst_0
      //   93: invokestatic 88	io/grpc/internal/InternalSubchannel:access$1102	(Lio/grpc/internal/InternalSubchannel;I)I
      //   96: pop
      //   97: aload_3
      //   98: getstatic 94	io/grpc/ConnectivityState:SHUTDOWN	Lio/grpc/ConnectivityState;
      //   101: if_acmpne +53 -> 154
      //   104: aload_0
      //   105: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   108: invokestatic 98	io/grpc/internal/InternalSubchannel:access$1200	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ManagedClientTransport;
      //   111: ifnonnull +38 -> 149
      //   114: iload_1
      //   115: ldc 100
      //   117: invokestatic 106	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
      //   120: aload_2
      //   121: monitorexit
      //   122: aload_0
      //   123: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   126: invokestatic 110	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
      //   129: invokevirtual 115	io/grpc/internal/ChannelExecutor:drain	()V
      //   132: aload_3
      //   133: getstatic 94	io/grpc/ConnectivityState:SHUTDOWN	Lio/grpc/ConnectivityState;
      //   136: if_acmpne +12 -> 148
      //   139: aload_0
      //   140: getfield 24	io/grpc/internal/InternalSubchannel$TransportListener:transport	Lio/grpc/internal/ConnectionClientTransport;
      //   143: invokeinterface 118 1 0
      //   148: return
      //   149: iconst_0
      //   150: istore_1
      //   151: goto -37 -> 114
      //   154: aload_0
      //   155: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   158: invokestatic 122	io/grpc/internal/InternalSubchannel:access$1300	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ConnectionClientTransport;
      //   161: aload_0
      //   162: getfield 24	io/grpc/internal/InternalSubchannel$TransportListener:transport	Lio/grpc/internal/ConnectionClientTransport;
      //   165: if_acmpne -45 -> 120
      //   168: aload_0
      //   169: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   172: getstatic 125	io/grpc/ConnectivityState:READY	Lio/grpc/ConnectivityState;
      //   175: invokestatic 129	io/grpc/internal/InternalSubchannel:access$400	(Lio/grpc/internal/InternalSubchannel;Lio/grpc/ConnectivityState;)V
      //   178: aload_0
      //   179: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   182: aload_0
      //   183: getfield 24	io/grpc/internal/InternalSubchannel$TransportListener:transport	Lio/grpc/internal/ConnectionClientTransport;
      //   186: invokestatic 133	io/grpc/internal/InternalSubchannel:access$1202	(Lio/grpc/internal/InternalSubchannel;Lio/grpc/internal/ManagedClientTransport;)Lio/grpc/internal/ManagedClientTransport;
      //   189: pop
      //   190: aload_0
      //   191: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   194: aconst_null
      //   195: invokestatic 137	io/grpc/internal/InternalSubchannel:access$1302	(Lio/grpc/internal/InternalSubchannel;Lio/grpc/internal/ConnectionClientTransport;)Lio/grpc/internal/ConnectionClientTransport;
      //   198: pop
      //   199: goto -79 -> 120
      //   202: astore_3
      //   203: aload_2
      //   204: monitorexit
      //   205: aload_3
      //   206: athrow
      //   207: astore_2
      //   208: aload_0
      //   209: getfield 19	io/grpc/internal/InternalSubchannel$TransportListener:this$0	Lio/grpc/internal/InternalSubchannel;
      //   212: invokestatic 110	io/grpc/internal/InternalSubchannel:access$700	(Lio/grpc/internal/InternalSubchannel;)Lio/grpc/internal/ChannelExecutor;
      //   215: invokevirtual 115	io/grpc/internal/ChannelExecutor:drain	()V
      //   218: aload_2
      //   219: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	220	0	this	TransportListener
      //   1	150	1	bool	boolean
      //   207	12	2	localObject2	Object
      //   78	55	3	localConnectivityState	ConnectivityState
      //   202	4	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   68	114	202	finally
      //   114	120	202	finally
      //   120	122	202	finally
      //   154	199	202	finally
      //   203	205	202	finally
      //   58	68	207	finally
      //   205	207	207	finally
    }
    
    public void transportShutdown(Status paramStatus)
    {
      boolean bool = true;
      if (InternalSubchannel.log.isLoggable(Level.FINE)) {
        InternalSubchannel.log.log(Level.FINE, "[{0}] {1} for {2} is being shutdown with status {3}", new Object[] { InternalSubchannel.this.logId, this.transport.getLogId(), this.address, paramStatus });
      }
      for (;;)
      {
        try
        {
          synchronized (InternalSubchannel.this.lock)
          {
            if (InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN) {
              return;
            }
            if (InternalSubchannel.this.activeTransport == this.transport)
            {
              InternalSubchannel.this.gotoNonErrorState(ConnectivityState.IDLE);
              InternalSubchannel.access$1202(InternalSubchannel.this, null);
              return;
            }
            if (InternalSubchannel.this.pendingTransport != this.transport) {
              continue;
            }
            if (InternalSubchannel.this.state.getState() == ConnectivityState.CONNECTING)
            {
              Preconditions.checkState(bool, "Expected state is CONNECTING, actual state is %s", new Object[] { InternalSubchannel.this.state.getState() });
              if (InternalSubchannel.this.nextAddressIndex != 0) {
                break label244;
              }
              InternalSubchannel.this.scheduleBackoff(paramStatus);
            }
          }
          bool = false;
        }
        finally
        {
          InternalSubchannel.this.channelExecutor.drain();
        }
        continue;
        label244:
        InternalSubchannel.this.startNewTransport();
      }
    }
    
    public void transportTerminated()
    {
      boolean bool = true;
      if (InternalSubchannel.log.isLoggable(Level.FINE)) {
        InternalSubchannel.log.log(Level.FINE, "[{0}] {1} for {2} is terminated", new Object[] { InternalSubchannel.this.logId, this.transport.getLogId(), this.address });
      }
      InternalSubchannel.this.handleTransportInUseState(this.transport, false);
      for (;;)
      {
        try
        {
          synchronized (InternalSubchannel.this.lock)
          {
            InternalSubchannel.this.transports.remove(this.transport);
            if ((InternalSubchannel.this.state.getState() == ConnectivityState.SHUTDOWN) && (InternalSubchannel.this.transports.isEmpty()))
            {
              if (InternalSubchannel.log.isLoggable(Level.FINE)) {
                InternalSubchannel.log.log(Level.FINE, "[{0}] Terminated in transportTerminated()", InternalSubchannel.this.logId);
              }
              InternalSubchannel.this.handleTermination();
            }
            InternalSubchannel.this.channelExecutor.drain();
            if (InternalSubchannel.this.activeTransport != this.transport)
            {
              Preconditions.checkState(bool, "activeTransport still points to this transport. Seems transportShutdown() was not called.");
              return;
            }
          }
          bool = false;
        }
        finally
        {
          InternalSubchannel.this.channelExecutor.drain();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/InternalSubchannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */