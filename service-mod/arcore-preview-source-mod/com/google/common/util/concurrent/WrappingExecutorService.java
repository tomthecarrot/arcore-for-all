package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class WrappingExecutorService
  implements ExecutorService
{
  private final ExecutorService delegate;
  
  protected WrappingExecutorService(ExecutorService paramExecutorService)
  {
    this.delegate = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
  }
  
  private final <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> paramCollection)
  {
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localBuilder.add(wrapTask((Callable)paramCollection.next()));
    }
    return localBuilder.build();
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.delegate.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.delegate.execute(wrapTask(paramRunnable));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException
  {
    return this.delegate.invokeAll(wrapTasks(paramCollection));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.delegate.invokeAll(wrapTasks(paramCollection), paramLong, paramTimeUnit);
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException, ExecutionException
  {
    return (T)this.delegate.invokeAny(wrapTasks(paramCollection));
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)this.delegate.invokeAny(wrapTasks(paramCollection), paramLong, paramTimeUnit);
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
  
  public final Future<?> submit(Runnable paramRunnable)
  {
    return this.delegate.submit(wrapTask(paramRunnable));
  }
  
  public final <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return this.delegate.submit(wrapTask(paramRunnable), paramT);
  }
  
  public final <T> Future<T> submit(Callable<T> paramCallable)
  {
    return this.delegate.submit(wrapTask((Callable)Preconditions.checkNotNull(paramCallable)));
  }
  
  protected Runnable wrapTask(Runnable paramRunnable)
  {
    new Runnable()
    {
      public void run()
      {
        try
        {
          this.val$wrapped.call();
          return;
        }
        catch (Exception localException)
        {
          Throwables.propagate(localException);
        }
      }
    };
  }
  
  protected abstract <T> Callable<T> wrapTask(Callable<T> paramCallable);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/WrappingExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */