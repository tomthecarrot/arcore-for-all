package com.google.common.collect;

import javax.annotation.Nullable;

final class DescendingImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private final transient ImmutableSortedMultiset<E> forward;
  
  DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> paramImmutableSortedMultiset)
  {
    this.forward = paramImmutableSortedMultiset;
  }
  
  public int count(@Nullable Object paramObject)
  {
    return this.forward.count(paramObject);
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    return this.forward;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return this.forward.elementSet().descendingSet();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return this.forward.lastEntry();
  }
  
  Multiset.Entry<E> getEntry(int paramInt)
  {
    return (Multiset.Entry)this.forward.entrySet().asList().reverse().get(paramInt);
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return this.forward.tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  boolean isPartialView()
  {
    return this.forward.isPartialView();
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return this.forward.firstEntry();
  }
  
  public int size()
  {
    return this.forward.size();
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return this.forward.headMultiset(paramE, paramBoundType).descendingMultiset();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/DescendingImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */