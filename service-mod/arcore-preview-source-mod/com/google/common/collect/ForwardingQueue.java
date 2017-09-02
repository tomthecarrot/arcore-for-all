package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue<E>
  extends ForwardingCollection<E>
  implements Queue<E>
{
  protected abstract Queue<E> delegate();
  
  public E element()
  {
    return (E)delegate().element();
  }
  
  public boolean offer(E paramE)
  {
    return delegate().offer(paramE);
  }
  
  public E peek()
  {
    return (E)delegate().peek();
  }
  
  public E poll()
  {
    return (E)delegate().poll();
  }
  
  public E remove()
  {
    return (E)delegate().remove();
  }
  
  protected boolean standardOffer(E paramE)
  {
    try
    {
      boolean bool = add(paramE);
      return bool;
    }
    catch (IllegalStateException paramE) {}
    return false;
  }
  
  protected E standardPeek()
  {
    try
    {
      Object localObject = element();
      return (E)localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
  
  protected E standardPoll()
  {
    try
    {
      Object localObject = remove();
      return (E)localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */