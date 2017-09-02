package com.google.common.collect;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingDeque<E>
  extends ForwardingDeque<E>
  implements BlockingDeque<E>
{
  protected abstract BlockingDeque<E> delegate();
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return delegate().drainTo(paramCollection);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    return delegate().drainTo(paramCollection, paramInt);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offer(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offerFirst(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offerLast(paramE, paramLong, paramTimeUnit);
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return (E)delegate().poll(paramLong, paramTimeUnit);
  }
  
  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return (E)delegate().pollFirst(paramLong, paramTimeUnit);
  }
  
  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return (E)delegate().pollLast(paramLong, paramTimeUnit);
  }
  
  public void put(E paramE)
    throws InterruptedException
  {
    delegate().put(paramE);
  }
  
  public void putFirst(E paramE)
    throws InterruptedException
  {
    delegate().putFirst(paramE);
  }
  
  public void putLast(E paramE)
    throws InterruptedException
  {
    delegate().putLast(paramE);
  }
  
  public int remainingCapacity()
  {
    return delegate().remainingCapacity();
  }
  
  public E take()
    throws InterruptedException
  {
    return (E)delegate().take();
  }
  
  public E takeFirst()
    throws InterruptedException
  {
    return (E)delegate().takeFirst();
  }
  
  public E takeLast()
    throws InterruptedException
  {
    return (E)delegate().takeLast();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */