package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ForwardingFuture<V>
  extends ForwardingObject
  implements Future<V>
{
  public boolean cancel(boolean paramBoolean)
  {
    return delegate().cancel(paramBoolean);
  }
  
  protected abstract Future<V> delegate();
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    return (V)delegate().get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (V)delegate().get(paramLong, paramTimeUnit);
  }
  
  public boolean isCancelled()
  {
    return delegate().isCancelled();
  }
  
  public boolean isDone()
  {
    return delegate().isDone();
  }
  
  public static abstract class SimpleForwardingFuture<V>
    extends ForwardingFuture<V>
  {
    private final Future<V> delegate;
    
    protected SimpleForwardingFuture(Future<V> paramFuture)
    {
      this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
    }
    
    protected final Future<V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/ForwardingFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */