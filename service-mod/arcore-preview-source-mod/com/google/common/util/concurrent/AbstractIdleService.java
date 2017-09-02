package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract class AbstractIdleService
  implements Service
{
  private final Service delegate = new DelegateService(null);
  private final Supplier<String> threadNameSupplier = new ThreadNameSupplier(null);
  
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
        MoreExecutors.newThread((String)AbstractIdleService.this.threadNameSupplier.get(), paramAnonymousRunnable).start();
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
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
  
  protected abstract void shutDown()
    throws Exception;
  
  public final Service startAsync()
  {
    this.delegate.startAsync();
    return this;
  }
  
  protected abstract void startUp()
    throws Exception;
  
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
  
  private final class DelegateService
    extends AbstractService
  {
    private DelegateService() {}
    
    protected final void doStart()
    {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable()
      {
        public void run()
        {
          try
          {
            AbstractIdleService.this.startUp();
            AbstractIdleService.DelegateService.this.notifyStarted();
            return;
          }
          catch (Throwable localThrowable)
          {
            AbstractIdleService.DelegateService.this.notifyFailed(localThrowable);
          }
        }
      });
    }
    
    protected final void doStop()
    {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable()
      {
        public void run()
        {
          try
          {
            AbstractIdleService.this.shutDown();
            AbstractIdleService.DelegateService.this.notifyStopped();
            return;
          }
          catch (Throwable localThrowable)
          {
            AbstractIdleService.DelegateService.this.notifyFailed(localThrowable);
          }
        }
      });
    }
    
    public String toString()
    {
      return AbstractIdleService.this.toString();
    }
  }
  
  private final class ThreadNameSupplier
    implements Supplier<String>
  {
    private ThreadNameSupplier() {}
    
    public String get()
    {
      return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AbstractIdleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */