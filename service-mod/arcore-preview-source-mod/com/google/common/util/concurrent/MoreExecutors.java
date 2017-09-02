package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible(emulated=true)
public final class MoreExecutors
{
  @Beta
  @GwtIncompatible("TODO")
  public static void addDelayedShutdownHook(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
    new Application().addDelayedShutdownHook(paramExecutorService, paramLong, paramTimeUnit);
  }
  
  public static Executor directExecutor()
  {
    return DirectExecutor.INSTANCE;
  }
  
  @Beta
  @GwtIncompatible("concurrency")
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return new Application().getExitingExecutorService(paramThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible("TODO")
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Application().getExitingExecutorService(paramThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  @Beta
  @GwtIncompatible("TODO")
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    return new Application().getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible("TODO")
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Application().getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  /* Error */
  static <T> T invokeAnyImpl(ListeningExecutorService paramListeningExecutorService, java.util.Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, long paramLong)
    throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 95	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokeinterface 101 1 0
    //   11: istore 5
    //   13: iload 5
    //   15: ifle +218 -> 233
    //   18: iconst_1
    //   19: istore 9
    //   21: iload 9
    //   23: invokestatic 105	com/google/common/base/Preconditions:checkArgument	(Z)V
    //   26: iload 5
    //   28: invokestatic 111	com/google/common/collect/Lists:newArrayListWithCapacity	(I)Ljava/util/ArrayList;
    //   31: astore 18
    //   33: invokestatic 117	com/google/common/collect/Queues:newLinkedBlockingQueue	()Ljava/util/concurrent/LinkedBlockingQueue;
    //   36: astore 19
    //   38: iload_2
    //   39: ifeq +200 -> 239
    //   42: invokestatic 123	java/lang/System:nanoTime	()J
    //   45: lstore 10
    //   47: aload_1
    //   48: invokeinterface 127 1 0
    //   53: astore 20
    //   55: aload 18
    //   57: aload_0
    //   58: aload 20
    //   60: invokeinterface 133 1 0
    //   65: checkcast 135	java/util/concurrent/Callable
    //   68: aload 19
    //   70: invokestatic 139	com/google/common/util/concurrent/MoreExecutors:submitAndAddQueueListener	(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
    //   73: invokeinterface 145 2 0
    //   78: pop
    //   79: iload 5
    //   81: iconst_1
    //   82: isub
    //   83: istore 8
    //   85: iconst_1
    //   86: istore 5
    //   88: aconst_null
    //   89: astore_1
    //   90: aload 19
    //   92: invokeinterface 150 1 0
    //   97: checkcast 152	java/util/concurrent/Future
    //   100: astore 17
    //   102: iload 5
    //   104: istore 6
    //   106: aload 17
    //   108: astore 16
    //   110: iload 8
    //   112: istore 7
    //   114: lload 10
    //   116: lstore 12
    //   118: lload_3
    //   119: lstore 14
    //   121: aload 17
    //   123: ifnonnull +55 -> 178
    //   126: iload 8
    //   128: ifle +117 -> 245
    //   131: iload 8
    //   133: iconst_1
    //   134: isub
    //   135: istore 7
    //   137: aload 18
    //   139: aload_0
    //   140: aload 20
    //   142: invokeinterface 133 1 0
    //   147: checkcast 135	java/util/concurrent/Callable
    //   150: aload 19
    //   152: invokestatic 139	com/google/common/util/concurrent/MoreExecutors:submitAndAddQueueListener	(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
    //   155: invokeinterface 145 2 0
    //   160: pop
    //   161: iload 5
    //   163: iconst_1
    //   164: iadd
    //   165: istore 6
    //   167: lload_3
    //   168: lstore 14
    //   170: lload 10
    //   172: lstore 12
    //   174: aload 17
    //   176: astore 16
    //   178: aload 16
    //   180: ifnull +232 -> 412
    //   183: iload 6
    //   185: iconst_1
    //   186: isub
    //   187: istore 5
    //   189: aload 16
    //   191: invokeinterface 155 1 0
    //   196: astore_1
    //   197: aload 18
    //   199: invokeinterface 156 1 0
    //   204: astore_0
    //   205: aload_0
    //   206: invokeinterface 160 1 0
    //   211: ifeq +194 -> 405
    //   214: aload_0
    //   215: invokeinterface 133 1 0
    //   220: checkcast 152	java/util/concurrent/Future
    //   223: iconst_1
    //   224: invokeinterface 164 2 0
    //   229: pop
    //   230: goto -25 -> 205
    //   233: iconst_0
    //   234: istore 9
    //   236: goto -215 -> 21
    //   239: lconst_0
    //   240: lstore 10
    //   242: goto -195 -> 47
    //   245: iload 5
    //   247: ifne +55 -> 302
    //   250: aload_1
    //   251: ifnonnull +156 -> 407
    //   254: new 85	java/util/concurrent/ExecutionException
    //   257: dup
    //   258: aconst_null
    //   259: invokespecial 167	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   262: astore_0
    //   263: aload_0
    //   264: athrow
    //   265: astore_0
    //   266: aload 18
    //   268: invokeinterface 156 1 0
    //   273: astore_1
    //   274: aload_1
    //   275: invokeinterface 160 1 0
    //   280: ifeq +123 -> 403
    //   283: aload_1
    //   284: invokeinterface 133 1 0
    //   289: checkcast 152	java/util/concurrent/Future
    //   292: iconst_1
    //   293: invokeinterface 164 2 0
    //   298: pop
    //   299: goto -25 -> 274
    //   302: iload_2
    //   303: ifeq +57 -> 360
    //   306: aload 19
    //   308: lload_3
    //   309: getstatic 173	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   312: invokeinterface 176 4 0
    //   317: checkcast 152	java/util/concurrent/Future
    //   320: astore 16
    //   322: aload 16
    //   324: ifnonnull +11 -> 335
    //   327: new 87	java/util/concurrent/TimeoutException
    //   330: dup
    //   331: invokespecial 177	java/util/concurrent/TimeoutException:<init>	()V
    //   334: athrow
    //   335: invokestatic 123	java/lang/System:nanoTime	()J
    //   338: lstore 12
    //   340: lload_3
    //   341: lload 12
    //   343: lload 10
    //   345: lsub
    //   346: lsub
    //   347: lstore 14
    //   349: iload 5
    //   351: istore 6
    //   353: iload 8
    //   355: istore 7
    //   357: goto -179 -> 178
    //   360: aload 19
    //   362: invokeinterface 180 1 0
    //   367: checkcast 152	java/util/concurrent/Future
    //   370: astore 16
    //   372: iload 5
    //   374: istore 6
    //   376: iload 8
    //   378: istore 7
    //   380: lload 10
    //   382: lstore 12
    //   384: lload_3
    //   385: lstore 14
    //   387: goto -209 -> 178
    //   390: astore_1
    //   391: new 85	java/util/concurrent/ExecutionException
    //   394: dup
    //   395: aload_1
    //   396: invokespecial 167	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   399: astore_1
    //   400: goto +24 -> 424
    //   403: aload_0
    //   404: athrow
    //   405: aload_1
    //   406: areturn
    //   407: aload_1
    //   408: astore_0
    //   409: goto -146 -> 263
    //   412: iload 6
    //   414: istore 5
    //   416: goto +8 -> 424
    //   419: astore_0
    //   420: goto -154 -> 266
    //   423: astore_1
    //   424: iload 7
    //   426: istore 8
    //   428: lload 12
    //   430: lstore 10
    //   432: lload 14
    //   434: lstore_3
    //   435: goto -345 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramListeningExecutorService	ListeningExecutorService
    //   0	438	1	paramCollection	java.util.Collection<? extends Callable<T>>
    //   0	438	2	paramBoolean	boolean
    //   0	438	3	paramLong	long
    //   11	404	5	i	int
    //   104	309	6	j	int
    //   112	313	7	k	int
    //   83	344	8	m	int
    //   19	216	9	bool	boolean
    //   45	386	10	l1	long
    //   116	313	12	l2	long
    //   119	314	14	l3	long
    //   108	263	16	localFuture1	Future
    //   100	75	17	localFuture2	Future
    //   31	236	18	localArrayList	java.util.ArrayList
    //   36	325	19	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    //   53	88	20	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   42	47	265	finally
    //   47	79	265	finally
    //   263	265	265	finally
    //   189	197	390	java/lang/RuntimeException
    //   90	102	419	finally
    //   137	161	419	finally
    //   189	197	419	finally
    //   254	263	419	finally
    //   306	322	419	finally
    //   327	335	419	finally
    //   335	340	419	finally
    //   360	372	419	finally
    //   391	400	419	finally
    //   189	197	423	java/util/concurrent/ExecutionException
  }
  
  @GwtIncompatible("TODO")
  private static boolean isAppEngine()
  {
    if (System.getProperty("com.google.appengine.runtime.environment") == null) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]);
        if (localObject != null) {
          return true;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return false;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    return false;
  }
  
  @GwtIncompatible("TODO")
  public static ListeningExecutorService listeningDecorator(ExecutorService paramExecutorService)
  {
    if ((paramExecutorService instanceof ListeningExecutorService)) {
      return (ListeningExecutorService)paramExecutorService;
    }
    if ((paramExecutorService instanceof ScheduledExecutorService)) {
      return new ScheduledListeningDecorator((ScheduledExecutorService)paramExecutorService);
    }
    return new ListeningDecorator(paramExecutorService);
  }
  
  @GwtIncompatible("TODO")
  public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService instanceof ListeningScheduledExecutorService)) {
      return (ListeningScheduledExecutorService)paramScheduledExecutorService;
    }
    return new ScheduledListeningDecorator(paramScheduledExecutorService);
  }
  
  @GwtIncompatible("TODO")
  public static ListeningExecutorService newDirectExecutorService()
  {
    return new DirectExecutorService(null);
  }
  
  @GwtIncompatible("concurrency")
  static Thread newThread(String paramString, Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramRunnable);
    paramRunnable = platformThreadFactory().newThread(paramRunnable);
    try
    {
      paramRunnable.setName(paramString);
      return paramRunnable;
    }
    catch (SecurityException paramString) {}
    return paramRunnable;
  }
  
  @Beta
  @GwtIncompatible("concurrency")
  public static ThreadFactory platformThreadFactory()
  {
    if (!isAppEngine()) {
      return Executors.defaultThreadFactory();
    }
    try
    {
      ThreadFactory localThreadFactory = (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
      return localThreadFactory;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localClassNotFoundException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw Throwables.propagate(localInvocationTargetException.getCause());
    }
  }
  
  @GwtIncompatible("concurrency")
  static Executor renamingDecorator(Executor paramExecutor, final Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramExecutor);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramExecutor;
    }
    new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        this.val$executor.execute(Callables.threadRenaming(paramAnonymousRunnable, paramSupplier));
      }
    };
  }
  
  @GwtIncompatible("concurrency")
  static ExecutorService renamingDecorator(ExecutorService paramExecutorService, final Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramExecutorService);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramExecutorService;
    }
    new WrappingExecutorService(paramExecutorService)
    {
      protected Runnable wrapTask(Runnable paramAnonymousRunnable)
      {
        return Callables.threadRenaming(paramAnonymousRunnable, paramSupplier);
      }
      
      protected <T> Callable<T> wrapTask(Callable<T> paramAnonymousCallable)
      {
        return Callables.threadRenaming(paramAnonymousCallable, paramSupplier);
      }
    };
  }
  
  @GwtIncompatible("concurrency")
  static ScheduledExecutorService renamingDecorator(ScheduledExecutorService paramScheduledExecutorService, final Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramScheduledExecutorService);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramScheduledExecutorService;
    }
    new WrappingScheduledExecutorService(paramScheduledExecutorService)
    {
      protected Runnable wrapTask(Runnable paramAnonymousRunnable)
      {
        return Callables.threadRenaming(paramAnonymousRunnable, paramSupplier);
      }
      
      protected <T> Callable<T> wrapTask(Callable<T> paramAnonymousCallable)
      {
        return Callables.threadRenaming(paramAnonymousCallable, paramSupplier);
      }
    };
  }
  
  @Deprecated
  @GwtIncompatible("TODO")
  public static ListeningExecutorService sameThreadExecutor()
  {
    return new DirectExecutorService(null);
  }
  
  @Beta
  @GwtIncompatible("concurrency")
  public static boolean shutdownAndAwaitTermination(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
    Preconditions.checkNotNull(paramTimeUnit);
    paramExecutorService.shutdown();
    try
    {
      paramLong = TimeUnit.NANOSECONDS.convert(paramLong, paramTimeUnit) / 2L;
      if (!paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS))
      {
        paramExecutorService.shutdownNow();
        paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS);
      }
      return paramExecutorService.isTerminated();
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
        paramExecutorService.shutdownNow();
      }
    }
  }
  
  @GwtIncompatible("TODO")
  private static <T> ListenableFuture<T> submitAndAddQueueListener(final ListeningExecutorService paramListeningExecutorService, Callable<T> paramCallable, BlockingQueue<Future<T>> paramBlockingQueue)
  {
    paramListeningExecutorService = paramListeningExecutorService.submit(paramCallable);
    paramListeningExecutorService.addListener(new Runnable()
    {
      public void run()
      {
        this.val$queue.add(paramListeningExecutorService);
      }
    }, directExecutor());
    return paramListeningExecutorService;
  }
  
  @GwtIncompatible("TODO")
  private static void useDaemonThreadFactory(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramThreadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(paramThreadPoolExecutor.getThreadFactory()).build());
  }
  
  @GwtIncompatible("TODO")
  @VisibleForTesting
  static class Application
  {
    final void addDelayedShutdownHook(final ExecutorService paramExecutorService, final long paramLong, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramExecutorService);
      Preconditions.checkNotNull(paramTimeUnit);
      addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + paramExecutorService, new Runnable()
      {
        public void run()
        {
          try
          {
            paramExecutorService.shutdown();
            paramExecutorService.awaitTermination(paramLong, this.val$timeUnit);
            return;
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }));
    }
    
    @VisibleForTesting
    void addShutdownHook(Thread paramThread)
    {
      Runtime.getRuntime().addShutdownHook(paramThread);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor)
    {
      return getExitingExecutorService(paramThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(paramThreadPoolExecutor);
      paramThreadPoolExecutor = Executors.unconfigurableExecutorService(paramThreadPoolExecutor);
      addDelayedShutdownHook(paramThreadPoolExecutor, paramLong, paramTimeUnit);
      return paramThreadPoolExecutor;
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
    {
      return getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(paramScheduledThreadPoolExecutor);
      paramScheduledThreadPoolExecutor = Executors.unconfigurableScheduledExecutorService(paramScheduledThreadPoolExecutor);
      addDelayedShutdownHook(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
      return paramScheduledThreadPoolExecutor;
    }
  }
  
  private static enum DirectExecutor
    implements Executor
  {
    INSTANCE;
    
    private DirectExecutor() {}
    
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
    
    public String toString()
    {
      return "MoreExecutors.directExecutor()";
    }
  }
  
  @GwtIncompatible("TODO")
  private static final class DirectExecutorService
    extends AbstractListeningExecutorService
  {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private int runningTasks = 0;
    @GuardedBy("lock")
    private boolean shutdown = false;
    
    private void endTask()
    {
      synchronized (this.lock)
      {
        int i = this.runningTasks - 1;
        this.runningTasks = i;
        if (i == 0) {
          this.lock.notifyAll();
        }
        return;
      }
    }
    
    private void startTask()
    {
      synchronized (this.lock)
      {
        if (this.shutdown) {
          throw new RejectedExecutionException("Executor already shutdown");
        }
      }
      this.runningTasks += 1;
    }
    
    public boolean awaitTermination(long paramLong, TimeUnit arg3)
      throws InterruptedException
    {
      long l1;
      long l2;
      for (paramLong = ???.toNanos(paramLong);; paramLong -= l2 - l1)
      {
        synchronized (this.lock)
        {
          if ((this.shutdown) && (this.runningTasks == 0)) {
            return true;
          }
          if (paramLong <= 0L) {
            return false;
          }
        }
        l1 = System.nanoTime();
        TimeUnit.NANOSECONDS.timedWait(this.lock, paramLong);
        l2 = System.nanoTime();
      }
    }
    
    public void execute(Runnable paramRunnable)
    {
      startTask();
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        endTask();
      }
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
      for (;;)
      {
        synchronized (this.lock)
        {
          if ((this.shutdown) && (this.runningTasks == 0))
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
    
    public void shutdown()
    {
      synchronized (this.lock)
      {
        this.shutdown = true;
        if (this.runningTasks == 0) {
          this.lock.notifyAll();
        }
        return;
      }
    }
    
    public List<Runnable> shutdownNow()
    {
      shutdown();
      return Collections.emptyList();
    }
  }
  
  @GwtIncompatible("TODO")
  private static class ListeningDecorator
    extends AbstractListeningExecutorService
  {
    private final ExecutorService delegate;
    
    ListeningDecorator(ExecutorService paramExecutorService)
    {
      this.delegate = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    }
    
    public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return this.delegate.awaitTermination(paramLong, paramTimeUnit);
    }
    
    public final void execute(Runnable paramRunnable)
    {
      this.delegate.execute(paramRunnable);
    }
    
    public final boolean isShutdown()
    {
      return this.delegate.isShutdown();
    }
    
    public final boolean isTerminated()
    {
      return this.delegate.isTerminated();
    }
    
    public final void shutdown()
    {
      this.delegate.shutdown();
    }
    
    public final List<Runnable> shutdownNow()
    {
      return this.delegate.shutdownNow();
    }
  }
  
  @GwtIncompatible("TODO")
  private static final class ScheduledListeningDecorator
    extends MoreExecutors.ListeningDecorator
    implements ListeningScheduledExecutorService
  {
    final ScheduledExecutorService delegate;
    
    ScheduledListeningDecorator(ScheduledExecutorService paramScheduledExecutorService)
    {
      super();
      this.delegate = ((ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService));
    }
    
    public ListenableScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramRunnable = TrustedListenableFutureTask.create(paramRunnable, null);
      return new ListenableScheduledTask(paramRunnable, this.delegate.schedule(paramRunnable, paramLong, paramTimeUnit));
    }
    
    public <V> ListenableScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramCallable = TrustedListenableFutureTask.create(paramCallable);
      return new ListenableScheduledTask(paramCallable, this.delegate.schedule(paramCallable, paramLong, paramTimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      paramRunnable = new NeverSuccessfulListenableFutureTask(paramRunnable);
      return new ListenableScheduledTask(paramRunnable, this.delegate.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      paramRunnable = new NeverSuccessfulListenableFutureTask(paramRunnable);
      return new ListenableScheduledTask(paramRunnable, this.delegate.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
    }
    
    private static final class ListenableScheduledTask<V>
      extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
      implements ListenableScheduledFuture<V>
    {
      private final ScheduledFuture<?> scheduledDelegate;
      
      public ListenableScheduledTask(ListenableFuture<V> paramListenableFuture, ScheduledFuture<?> paramScheduledFuture)
      {
        super();
        this.scheduledDelegate = paramScheduledFuture;
      }
      
      public boolean cancel(boolean paramBoolean)
      {
        boolean bool = super.cancel(paramBoolean);
        if (bool) {
          this.scheduledDelegate.cancel(paramBoolean);
        }
        return bool;
      }
      
      public int compareTo(Delayed paramDelayed)
      {
        return this.scheduledDelegate.compareTo(paramDelayed);
      }
      
      public long getDelay(TimeUnit paramTimeUnit)
      {
        return this.scheduledDelegate.getDelay(paramTimeUnit);
      }
    }
    
    @GwtIncompatible("TODO")
    private static final class NeverSuccessfulListenableFutureTask
      extends AbstractFuture<Void>
      implements Runnable
    {
      private final Runnable delegate;
      
      public NeverSuccessfulListenableFutureTask(Runnable paramRunnable)
      {
        this.delegate = ((Runnable)Preconditions.checkNotNull(paramRunnable));
      }
      
      public void run()
      {
        try
        {
          this.delegate.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          setException(localThrowable);
          throw Throwables.propagate(localThrowable);
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/MoreExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */