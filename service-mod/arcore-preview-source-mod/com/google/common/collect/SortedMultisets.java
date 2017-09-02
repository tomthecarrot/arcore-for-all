package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class SortedMultisets
{
  private static <E> E getElementOrNull(@Nullable Multiset.Entry<E> paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return (E)paramEntry.getElement();
  }
  
  private static <E> E getElementOrThrow(Multiset.Entry<E> paramEntry)
  {
    if (paramEntry == null) {
      throw new NoSuchElementException();
    }
    return (E)paramEntry.getElement();
  }
  
  static class ElementSet<E>
    extends Multisets.ElementSet<E>
    implements SortedSet<E>
  {
    @Weak
    private final SortedMultiset<E> multiset;
    
    ElementSet(SortedMultiset<E> paramSortedMultiset)
    {
      this.multiset = paramSortedMultiset;
    }
    
    public Comparator<? super E> comparator()
    {
      return multiset().comparator();
    }
    
    public E first()
    {
      return (E)SortedMultisets.getElementOrThrow(multiset().firstEntry());
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return multiset().headMultiset(paramE, BoundType.OPEN).elementSet();
    }
    
    public E last()
    {
      return (E)SortedMultisets.getElementOrThrow(multiset().lastEntry());
    }
    
    final SortedMultiset<E> multiset()
    {
      return this.multiset;
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return multiset().subMultiset(paramE1, BoundType.CLOSED, paramE2, BoundType.OPEN).elementSet();
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return multiset().tailMultiset(paramE, BoundType.CLOSED).elementSet();
    }
  }
  
  @GwtIncompatible("Navigable")
  static class NavigableElementSet<E>
    extends SortedMultisets.ElementSet<E>
    implements NavigableSet<E>
  {
    NavigableElementSet(SortedMultiset<E> paramSortedMultiset)
    {
      super();
    }
    
    public E ceiling(E paramE)
    {
      return (E)SortedMultisets.getElementOrNull(multiset().tailMultiset(paramE, BoundType.CLOSED).firstEntry());
    }
    
    public Iterator<E> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<E> descendingSet()
    {
      return new NavigableElementSet(multiset().descendingMultiset());
    }
    
    public E floor(E paramE)
    {
      return (E)SortedMultisets.getElementOrNull(multiset().headMultiset(paramE, BoundType.CLOSED).lastEntry());
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return new NavigableElementSet(multiset().headMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
    
    public E higher(E paramE)
    {
      return (E)SortedMultisets.getElementOrNull(multiset().tailMultiset(paramE, BoundType.OPEN).firstEntry());
    }
    
    public E lower(E paramE)
    {
      return (E)SortedMultisets.getElementOrNull(multiset().headMultiset(paramE, BoundType.OPEN).lastEntry());
    }
    
    public E pollFirst()
    {
      return (E)SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
    }
    
    public E pollLast()
    {
      return (E)SortedMultisets.getElementOrNull(multiset().pollLastEntry());
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return new NavigableElementSet(multiset().subMultiset(paramE1, BoundType.forBoolean(paramBoolean1), paramE2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return new NavigableElementSet(multiset().tailMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/SortedMultisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */