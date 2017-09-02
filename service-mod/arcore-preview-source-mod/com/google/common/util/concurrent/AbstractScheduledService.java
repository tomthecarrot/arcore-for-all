package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractScheduledService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
  private final AbstractService delegate = new ServiceDelegate(null);
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor)
  {
    this.delegate.addListener(paramListener, paramExecutor);
  }
  
  public final void awaitRunning()
  {
    this.delegate.awaitRunning();
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.delegate.awaitRunning(paramLong, paramTimeUnit);
  }
  
  public final void awaitTerminated()
  {
    this.delegate.awaitTerminated();
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.delegate.awaitTerminated(paramLong, paramTimeUnit);
  }
  
  protected ScheduledExecutorService executor()
  {
    final ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), paramAnonymousRunnable);
      }
    });
    addListener(new Service.Listener()
    {
      public void failed(Service.State paramAnonymousState, Throwable paramAnonymousThrowable)
      {
        localScheduledExecutorService.shutdown();
      }
      
      public void terminated(Service.State paramAnonymousState)
      {
        localScheduledExecutorService.shutdown();
      }
    }, MoreExecutors.directExecutor());
    return localScheduledExecutorService;
  }
  
  public final Throwable failureCause()
  {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void runOneIteration()
    throws Exception;
  
  protected abstract Scheduler scheduler();
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
  
  protected void shutDown()
    throws Exception
  {}
  
  public final Service startAsync()
  {
    this.delegate.startAsync();
    return this;
  }
  
  protected void startUp()
    throws Exception
  {}
  
  public final Service.State state()
  {
    return this.delegate.state();
  }
  
  public final Service stopAsync()
  {
    this.delegate.stopAsync();
    return this;
  }
  
  public String toString()
  {
    return serviceName() + " [" + state() + "]";
  }
  
  @Beta
  public static abstract class CustomScheduler
    extends AbstractScheduledService.Scheduler
  {
    public CustomScheduler()
    {
      super();
    }
    
    protected abstract Schedule getNextSchedule()
      throws Exception;
    
    final Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable)
    {
      paramAbstractService = new ReschedulableCallable(paramAbstractService, paramScheduledExecutorService, paramRunnable);
      paramAbstractService.reschedule();
      return paramAbstractService;
    }
    
    private class ReschedulableCallable
      extends ForwardingFuture<Void>
      implements Callable<Void>
    {
      @GuardedBy("lock")
      private Future<Void> currentFuture;
      private final ScheduledExecutorService executor;
      private final ReentrantLock lock = new ReentrantLock();
      private final AbstractService service;
      private final Runnable wrappedRunnable;
      
      ReschedulableCallable(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable)
      {
        this.wrappedRunnable = paramRunnable;
        this.executor = paramScheduledExecutorService;
        this.service = paramAbstractService;
      }
      
      public Void call()
        throws Exception
      {
        this.wrappedRunnable.run();
        reschedule();
        return null;
      }
      
      public boolean cancel(boolean paramBoolean)
      {
        this.lock.lock();
        try
        {
          paramBoolean = this.currentFuture.cancel(paramBoolean);
          return paramBoolean;
        }
        finally
        {
          this.lock.unlock();
        }
      }
      
      protected Future<Void> delegate()
      {
        throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
      }
      
      public boolean isCancelled()
      {
        this.lock.lock();
        try
        {
          boolean bool = this.currentFuture.isCancelled();
          return bool;
        }
        finally
        {
          this.lock.unlock();
        }
      }
      
      public void reschedule()
      {
        for (;;)
        {
          try
          {
            localSchedule = AbstractScheduledService.CustomScheduler.this.getNextSchedule();
            localThrowable1 = null;
            this.lock.lock();
          }
          catch (Throwable localThrowable2)
          {
            AbstractScheduledService.CustomScheduler.Schedule localSchedule;
            Throwable localThrowable1;
            this.service.notifyFailed(localThrowable2);
            return;
          }
          try
          {
            if ((this.currentFuture == null) || (!this.currentFuture.isCancelled())) {
              this.currentFuture = this.executor.schedule(this, AbstractScheduledService.CustomScheduler.Schedule.access$800(localSchedule), AbstractScheduledService.CustomScheduler.Schedule.access$900(localSchedule));
            }
          }
          catch (Throwable localThrowable3)
          {
            this.lock.unlock();
          }
          finally
          {
            this.lock.unlock();
          }
        }
        if (localThrowable1 != null) {
          this.service.notifyFailed(localThrowable1);
        }
      }
    }
    
    @Beta
    protected static final class Schedule
    {
      private final long delay;
      private final TimeUnit unit;
      
      public Schedule(long paramLong, TimeUnit paramTimeUnit)
      {
        this.delay = paramLong;
        this.unit = ((TimeUnit)Preconditions.checkNotNull(paramTimeUnit));
      }
    }
  }
  
  public static abstract class Scheduler
  {
    public static Scheduler newFixedDelaySchedule(long paramLong1, long paramLong2, final TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      if (paramLong2 > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "delay must be > 0, found %s", new Object[] { Long.valueOf(paramLong2) });
        new Scheduler(paramLong1)
        {
          public Future<?> schedule(AbstractService paramAnonymousAbstractService, ScheduledExecutorService paramAnonymousScheduledExecutorService, Runnable paramAnonymousRunnable)
          {
            return paramAnonymousScheduledExecutorService.scheduleWithFixedDelay(paramAnonymousRunnable, this.val$initialDelay, paramTimeUnit, this.val$unit);
          }
        };
      }
    }
    
    public static Scheduler newFixedRateSchedule(long paramLong1, long paramLong2, final TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      if (paramLong2 > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "period must be > 0, found %s", new Object[] { Long.valueOf(paramLong2) });
        new Scheduler(paramLong1)
        {
          public Future<?> schedule(AbstractService paramAnonymousAbstractService, ScheduledExecutorService paramAnonymousScheduledExecutorService, Runnable paramAnonymousRunnable)
          {
            return paramAnonymousScheduledExecutorService.scheduleAtFixedRate(paramAnonymousRunnable, this.val$initialDelay, paramTimeUnit, this.val$unit);
          }
        };
      }
    }
    
    abstract Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable);
  }
  
  private final class ServiceDelegate
    extends AbstractService
  {
    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock = new ReentrantLock();
    private volatile Future<?> runningTask;
    private final Runnable task = new Task();
    
    private ServiceDelegate() {}
    
    protected final void doStart()
    {
      this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier()
      {
        public String get()
        {
          return AbstractScheduledService.this.serviceName() + " " + AbstractScheduledService.ServiceDelegate.this.state();
        }
      });
      this.executorService.execute(new Runnable()
      {
        public void run()
        {
          AbstractScheduledService.ServiceDelegate.this.lock.lock();
          try
          {
            AbstractScheduledService.this.startUp();
            AbstractScheduledService.ServiceDelegate.access$302(AbstractScheduledService.ServiceDelegate.this, AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, AbstractScheduledService.ServiceDelegate.this.executorService, AbstractScheduledService.ServiceDelegate.this.task));
            AbstractScheduledService.ServiceDelegate.this.notifyStarted();
            return;
          }
          catch (Throwable localThrowable)
          {
            AbstractScheduledService.ServiceDelegate.this.notifyFailed(localThrowable);
            if (AbstractScheduledService.ServiceDelegate.this.runningTask != null) {
              AbstractScheduledService.ServiceDelegate.this.runningTask.cancel(false);
            }
            return;
          }
          finally
          {
            AbstractScheduledService.ServiceDelegate.this.lock.unlock();
          }
        }
      });
    }
    
    protected final void doStop()
    {
      this.runningTask.cancel(false);
      this.executorService.execute(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   4: invokestatic 30	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:access$200	(Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;)Ljava/util/concurrent/locks/ReentrantLock;
          //   7: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:lock	()V
          //   10: aload_0
          //   11: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   14: invokevirtual 39	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:state	()Lcom/google/common/util/concurrent/Service$State;
          //   17: astore_1
          //   18: getstatic 45	com/google/common/util/concurrent/Service$State:STOPPING	Lcom/google/common/util/concurrent/Service$State;
          //   21: astore_2
          //   22: aload_1
          //   23: aload_2
          //   24: if_acmpeq +14 -> 38
          //   27: aload_0
          //   28: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   31: invokestatic 30	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:access$200	(Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;)Ljava/util/concurrent/locks/ReentrantLock;
          //   34: invokevirtual 48	java/util/concurrent/locks/ReentrantLock:unlock	()V
          //   37: return
          //   38: aload_0
          //   39: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   42: getfield 52	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:this$0	Lcom/google/common/util/concurrent/AbstractScheduledService;
          //   45: invokevirtual 55	com/google/common/util/concurrent/AbstractScheduledService:shutDown	()V
          //   48: aload_0
          //   49: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   52: invokestatic 30	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:access$200	(Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;)Ljava/util/concurrent/locks/ReentrantLock;
          //   55: invokevirtual 48	java/util/concurrent/locks/ReentrantLock:unlock	()V
          //   58: aload_0
          //   59: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   62: invokevirtual 58	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:notifyStopped	()V
          //   65: return
          //   66: astore_1
          //   67: aload_0
          //   68: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   71: aload_1
          //   72: invokevirtual 62	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:notifyFailed	(Ljava/lang/Throwable;)V
          //   75: return
          //   76: astore_1
          //   77: aload_0
          //   78: getfield 20	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate$3:this$1	Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;
          //   81: invokestatic 30	com/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate:access$200	(Lcom/google/common/util/concurrent/AbstractScheduledService$ServiceDelegate;)Ljava/util/concurrent/locks/ReentrantLock;
          //   84: invokevirtual 48	java/util/concurrent/locks/ReentrantLock:unlock	()V
          //   87: aload_1
          //   88: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	89	0	this	3
          //   17	6	1	localState1	Service.State
          //   66	6	1	localThrowable	Throwable
          //   76	12	1	localObject	Object
          //   21	3	2	localState2	Service.State
          // Exception table:
          //   from	to	target	type
          //   0	10	66	java/lang/Throwable
          //   27	37	66	java/lang/Throwable
          //   48	65	66	java/lang/Throwable
          //   77	89	66	java/lang/Throwable
          //   10	22	76	finally
          //   38	48	76	finally
        }
      });
    }
    
    public String toString()
    {
      return AbstractScheduledService.this.toString();
    }
    
    class Task
      implements Runnable
    {
      Task() {}
      
      public void run()
      {
        AbstractScheduledService.ServiceDelegate.this.lock.lock();
        try
        {
          boolean bool = AbstractScheduledService.ServiceDelegate.this.runningTask.isCancelled();
          if (bool) {
            return;
          }
          AbstractScheduledService.this.runOneIteration();
          return;
        }
        catch (Throwable localThrowable)
        {
          try
          {
            AbstractScheduledService.this.shutDown();
            AbstractScheduledService.ServiceDelegate.this.notifyFailed(localThrowable);
            AbstractScheduledService.ServiceDelegate.this.runningTask.cancel(false);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", localException);
            }
          }
        }
        finally
        {
          AbstractScheduledService.ServiceDelegate.this.lock.unlock();
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AbstractScheduledService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */