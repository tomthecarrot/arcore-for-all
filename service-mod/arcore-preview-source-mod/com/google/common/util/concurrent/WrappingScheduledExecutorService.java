package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

abstract class WrappingScheduledExecutorService
  extends WrappingExecutorService
  implements ScheduledExecutorService
{
  final ScheduledExecutorService delegate;
  
  protected WrappingScheduledExecutorService(ScheduledExecutorService paramScheduledExecutorService)
  {
    super(paramScheduledExecutorService);
    this.delegate = paramScheduledExecutorService;
  }
  
  public final ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.schedule(wrapTask(paramRunnable), paramLong, paramTimeUnit);
  }
  
  public final <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.schedule(wrapTask(paramCallable), paramLong, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.delegate.scheduleAtFixedRate(wrapTask(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.delegate.scheduleWithFixedDelay(wrapTask(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/WrappingScheduledExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */