package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private static final long[] ZERO_CUMULATIVE_COUNTS = { 0L };
  private final transient long[] cumulativeCounts;
  private final transient RegularImmutableSortedSet<E> elementSet;
  private final transient int length;
  private final transient int offset;
  
  RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> paramRegularImmutableSortedSet, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.elementSet = paramRegularImmutableSortedSet;
    this.cumulativeCounts = paramArrayOfLong;
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  RegularImmutableSortedMultiset(Comparator<? super E> paramComparator)
  {
    this.elementSet = ImmutableSortedSet.emptySet(paramComparator);
    this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
    this.offset = 0;
    this.length = 0;
  }
  
  private int getCount(int paramInt)
  {
    return (int)(this.cumulativeCounts[(this.offset + paramInt + 1)] - this.cumulativeCounts[(this.offset + paramInt)]);
  }
  
  public int count(@Nullable Object paramObject)
  {
    int i = this.elementSet.indexOf(paramObject);
    if (i >= 0) {
      return getCount(i);
    }
    return 0;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return this.elementSet;
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return getEntry(0);
  }
  
  Multiset.Entry<E> getEntry(int paramInt)
  {
    return Multisets.immutableEntry(this.elementSet.asList().get(paramInt), getCount(paramInt));
  }
  
  ImmutableSortedMultiset<E> getSubMultiset(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, this.length);
    Object localObject;
    if (paramInt1 == paramInt2) {
      localObject = emptyMultiset(comparator());
    }
    do
    {
      return (ImmutableSortedMultiset<E>)localObject;
      if (paramInt1 != 0) {
        break;
      }
      localObject = this;
    } while (paramInt2 == this.length);
    return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(paramInt1, paramInt2), this.cumulativeCounts, this.offset + paramInt1, paramInt2 - paramInt1);
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = this.elementSet;
    if (Preconditions.checkNotNull(paramBoundType) == BoundType.CLOSED) {}
    for (boolean bool = true;; bool = false) {
      return getSubMultiset(0, localRegularImmutableSortedSet.headIndex(paramE, bool));
    }
  }
  
  boolean isPartialView()
  {
    return (this.offset > 0) || (this.length < this.cumulativeCounts.length - 1);
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return getEntry(this.length - 1);
  }
  
  public int size()
  {
    return Ints.saturatedCast(this.cumulativeCounts[(this.offset + this.length)] - this.cumulativeCounts[this.offset]);
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = this.elementSet;
    if (Preconditions.checkNotNull(paramBoundType) == BoundType.CLOSED) {}
    for (boolean bool = true;; bool = false) {
      return getSubMultiset(localRegularImmutableSortedSet.tailIndex(paramE, bool), this.length);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */