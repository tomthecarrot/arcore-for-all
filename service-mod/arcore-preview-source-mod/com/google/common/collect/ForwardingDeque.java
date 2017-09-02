package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

public abstract class ForwardingDeque<E>
  extends ForwardingQueue<E>
  implements Deque<E>
{
  public void addFirst(E paramE)
  {
    delegate().addFirst(paramE);
  }
  
  public void addLast(E paramE)
  {
    delegate().addLast(paramE);
  }
  
  protected abstract Deque<E> delegate();
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public E getFirst()
  {
    return (E)delegate().getFirst();
  }
  
  public E getLast()
  {
    return (E)delegate().getLast();
  }
  
  public boolean offerFirst(E paramE)
  {
    return delegate().offerFirst(paramE);
  }
  
  public boolean offerLast(E paramE)
  {
    return delegate().offerLast(paramE);
  }
  
  public E peekFirst()
  {
    return (E)delegate().peekFirst();
  }
  
  public E peekLast()
  {
    return (E)delegate().peekLast();
  }
  
  public E pollFirst()
  {
    return (E)delegate().pollFirst();
  }
  
  public E pollLast()
  {
    return (E)delegate().pollLast();
  }
  
  public E pop()
  {
    return (E)delegate().pop();
  }
  
  public void push(E paramE)
  {
    delegate().push(paramE);
  }
  
  public E removeFirst()
  {
    return (E)delegate().removeFirst();
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    return delegate().removeFirstOccurrence(paramObject);
  }
  
  public E removeLast()
  {
    return (E)delegate().removeLast();
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    return delegate().removeLastOccurrence(paramObject);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */