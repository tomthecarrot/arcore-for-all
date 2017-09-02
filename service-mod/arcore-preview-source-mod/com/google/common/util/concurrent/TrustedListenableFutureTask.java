package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
class TrustedListenableFutureTask<V>
  extends AbstractFuture.TrustedFuture<V>
  implements RunnableFuture<V>
{
  private TrustedListenableFutureTask<V>.TrustedFutureInterruptibleTask task;
  
  TrustedListenableFutureTask(Callable<V> paramCallable)
  {
    this.task = new TrustedFutureInterruptibleTask(paramCallable);
  }
  
  static <V> TrustedListenableFutureTask<V> create(Runnable paramRunnable, @Nullable V paramV)
  {
    return new TrustedListenableFutureTask(Executors.callable(paramRunnable, paramV));
  }
  
  static <V> TrustedListenableFutureTask<V> create(Callable<V> paramCallable)
  {
    return new TrustedListenableFutureTask(paramCallable);
  }
  
  final void done()
  {
    super.done();
    this.task = null;
  }
  
  @GwtIncompatible("Interruption not supported")
  protected final void interruptTask()
  {
    TrustedFutureInterruptibleTask localTrustedFutureInterruptibleTask = this.task;
    if (localTrustedFutureInterruptibleTask != null) {
      localTrustedFutureInterruptibleTask.interruptTask();
    }
  }
  
  public void run()
  {
    TrustedFutureInterruptibleTask localTrustedFutureInterruptibleTask = this.task;
    if (localTrustedFutureInterruptibleTask != null) {
      localTrustedFutureInterruptibleTask.run();
    }
  }
  
  private final class TrustedFutureInterruptibleTask
    extends InterruptibleTask
  {
    private final Callable<V> callable;
    
    TrustedFutureInterruptibleTask()
    {
      Object localObject;
      this.callable = ((Callable)Preconditions.checkNotNull(localObject));
    }
    
    void runInterruptibly()
    {
      if (!TrustedListenableFutureTask.this.isDone()) {}
      try
      {
        TrustedListenableFutureTask.this.set(this.callable.call());
        return;
      }
      catch (Throwable localThrowable)
      {
        TrustedListenableFutureTask.this.setException(localThrowable);
      }
    }
    
    boolean wasInterrupted()
    {
      return TrustedListenableFutureTask.this.wasInterrupted();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/TrustedListenableFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */