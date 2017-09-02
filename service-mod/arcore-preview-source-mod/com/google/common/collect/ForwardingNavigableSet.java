package com.google.common.collect;

import com.google.common.annotations.Beta;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet<E>
  extends ForwardingSortedSet<E>
  implements NavigableSet<E>
{
  public E ceiling(E paramE)
  {
    return (E)delegate().ceiling(paramE);
  }
  
  protected abstract NavigableSet<E> delegate();
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public NavigableSet<E> descendingSet()
  {
    return delegate().descendingSet();
  }
  
  public E floor(E paramE)
  {
    return (E)delegate().floor(paramE);
  }
  
  public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return delegate().headSet(paramE, paramBoolean);
  }
  
  public E higher(E paramE)
  {
    return (E)delegate().higher(paramE);
  }
  
  public E lower(E paramE)
  {
    return (E)delegate().lower(paramE);
  }
  
  public E pollFirst()
  {
    return (E)delegate().pollFirst();
  }
  
  public E pollLast()
  {
    return (E)delegate().pollLast();
  }
  
  protected E standardCeiling(E paramE)
  {
    return (E)Iterators.getNext(tailSet(paramE, true).iterator(), null);
  }
  
  protected E standardFirst()
  {
    return (E)iterator().next();
  }
  
  protected E standardFloor(E paramE)
  {
    return (E)Iterators.getNext(headSet(paramE, true).descendingIterator(), null);
  }
  
  protected SortedSet<E> standardHeadSet(E paramE)
  {
    return headSet(paramE, false);
  }
  
  protected E standardHigher(E paramE)
  {
    return (E)Iterators.getNext(tailSet(paramE, false).iterator(), null);
  }
  
  protected E standardLast()
  {
    return (E)descendingIterator().next();
  }
  
  protected E standardLower(E paramE)
  {
    return (E)Iterators.getNext(headSet(paramE, false).descendingIterator(), null);
  }
  
  protected E standardPollFirst()
  {
    return (E)Iterators.pollNext(iterator());
  }
  
  protected E standardPollLast()
  {
    return (E)Iterators.pollNext(descendingIterator());
  }
  
  @Beta
  protected NavigableSet<E> standardSubSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return tailSet(paramE1, paramBoolean1).headSet(paramE2, paramBoolean2);
  }
  
  protected SortedSet<E> standardSubSet(E paramE1, E paramE2)
  {
    return subSet(paramE1, true, paramE2, false);
  }
  
  protected SortedSet<E> standardTailSet(E paramE)
  {
    return tailSet(paramE, true);
  }
  
  public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return delegate().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return delegate().tailSet(paramE, paramBoolean);
  }
  
  @Beta
  protected class StandardDescendingSet
    extends Sets.DescendingSet<E>
  {
    public StandardDescendingSet()
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingNavigableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */