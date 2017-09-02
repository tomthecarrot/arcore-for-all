package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
  private final Service delegate = new AbstractService()
  {
    protected final void doStart()
    {
      MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new Supplier()
      {
        public String get()
        {
          return AbstractExecutionThreadService.this.serviceName();
        }
      }).execute(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   4: getfield 29	com/google/common/util/concurrent/AbstractExecutionThreadService$1:this$0	Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
          //   7: invokevirtual 34	com/google/common/util/concurrent/AbstractExecutionThreadService:startUp	()V
          //   10: aload_0
          //   11: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   14: invokevirtual 37	com/google/common/util/concurrent/AbstractExecutionThreadService$1:notifyStarted	()V
          //   17: aload_0
          //   18: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   21: invokevirtual 41	com/google/common/util/concurrent/AbstractExecutionThreadService$1:isRunning	()Z
          //   24: istore_1
          //   25: iload_1
          //   26: ifeq +13 -> 39
          //   29: aload_0
          //   30: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   33: getfield 29	com/google/common/util/concurrent/AbstractExecutionThreadService$1:this$0	Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
          //   36: invokevirtual 43	com/google/common/util/concurrent/AbstractExecutionThreadService:run	()V
          //   39: aload_0
          //   40: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   43: getfield 29	com/google/common/util/concurrent/AbstractExecutionThreadService$1:this$0	Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
          //   46: invokevirtual 46	com/google/common/util/concurrent/AbstractExecutionThreadService:shutDown	()V
          //   49: aload_0
          //   50: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   53: invokevirtual 49	com/google/common/util/concurrent/AbstractExecutionThreadService$1:notifyStopped	()V
          //   56: return
          //   57: astore_2
          //   58: aload_0
          //   59: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   62: getfield 29	com/google/common/util/concurrent/AbstractExecutionThreadService$1:this$0	Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
          //   65: invokevirtual 46	com/google/common/util/concurrent/AbstractExecutionThreadService:shutDown	()V
          //   68: aload_0
          //   69: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   72: aload_2
          //   73: invokevirtual 53	com/google/common/util/concurrent/AbstractExecutionThreadService$1:notifyFailed	(Ljava/lang/Throwable;)V
          //   76: return
          //   77: astore_2
          //   78: aload_0
          //   79: getfield 17	com/google/common/util/concurrent/AbstractExecutionThreadService$1$2:this$1	Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
          //   82: aload_2
          //   83: invokevirtual 53	com/google/common/util/concurrent/AbstractExecutionThreadService$1:notifyFailed	(Ljava/lang/Throwable;)V
          //   86: return
          //   87: astore_3
          //   88: invokestatic 57	com/google/common/util/concurrent/AbstractExecutionThreadService:access$000	()Ljava/util/logging/Logger;
          //   91: getstatic 63	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
          //   94: ldc 65
          //   96: aload_3
          //   97: invokevirtual 71	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
          //   100: goto -32 -> 68
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	103	0	this	2
          //   24	2	1	bool	boolean
          //   57	16	2	localThrowable1	Throwable
          //   77	6	2	localThrowable2	Throwable
          //   87	10	3	localException	Exception
          // Exception table:
          //   from	to	target	type
          //   29	39	57	java/lang/Throwable
          //   0	25	77	java/lang/Throwable
          //   39	56	77	java/lang/Throwable
          //   58	68	77	java/lang/Throwable
          //   68	76	77	java/lang/Throwable
          //   88	100	77	java/lang/Throwable
          //   58	68	87	java/lang/Exception
        }
      });
    }
    
    protected void doStop()
    {
      AbstractExecutionThreadService.this.triggerShutdown();
    }
    
    public String toString()
    {
      return AbstractExecutionThreadService.this.toString();
    }
  };
  
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
  
  protected Executor executor()
  {
    new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), paramAnonymousRunnable).start();
      }
    };
  }
  
  public final Throwable failureCause()
  {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void run()
    throws Exception;
  
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
  
  protected void triggerShutdown() {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AbstractExecutionThreadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */