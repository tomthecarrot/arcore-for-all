package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Beta
@GwtCompatible(emulated=true)
public abstract class ContiguousSet<C extends Comparable>
  extends ImmutableSortedSet<C>
{
  final DiscreteDomain<C> domain;
  
  ContiguousSet(DiscreteDomain<C> paramDiscreteDomain)
  {
    super(Ordering.natural());
    this.domain = paramDiscreteDomain;
  }
  
  @Deprecated
  public static <E> ImmutableSortedSet.Builder<E> builder()
  {
    throw new UnsupportedOperationException();
  }
  
  public static <C extends Comparable> ContiguousSet<C> create(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain)
  {
    Preconditions.checkNotNull(paramRange);
    Preconditions.checkNotNull(paramDiscreteDomain);
    Object localObject2 = paramRange;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (!paramRange.hasLowerBound()) {
          localObject1 = ((Range)localObject2).intersection(Range.atLeast(paramDiscreteDomain.minValue()));
        }
        localObject2 = localObject1;
        if (!paramRange.hasUpperBound()) {
          localObject2 = ((Range)localObject1).intersection(Range.atMost(paramDiscreteDomain.maxValue()));
        }
        if ((((Range)localObject2).isEmpty()) || (Range.compareOrThrow(paramRange.lowerBound.leastValueAbove(paramDiscreteDomain), paramRange.upperBound.greatestValueBelow(paramDiscreteDomain)) > 0))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          return new EmptyContiguousSet(paramDiscreteDomain);
        }
      }
      catch (NoSuchElementException paramRange)
      {
        throw new IllegalArgumentException(paramRange);
      }
      int i = 0;
    }
    return new RegularContiguousSet((Range)localObject2, paramDiscreteDomain);
  }
  
  public ContiguousSet<C> headSet(C paramC)
  {
    return headSetImpl((Comparable)Preconditions.checkNotNull(paramC), false);
  }
  
  @GwtIncompatible("NavigableSet")
  public ContiguousSet<C> headSet(C paramC, boolean paramBoolean)
  {
    return headSetImpl((Comparable)Preconditions.checkNotNull(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean);
  
  public abstract ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet);
  
  public abstract Range<C> range();
  
  public abstract Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2);
  
  public ContiguousSet<C> subSet(C paramC1, C paramC2)
  {
    Preconditions.checkNotNull(paramC1);
    Preconditions.checkNotNull(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return subSetImpl(paramC1, true, paramC2, false);
    }
  }
  
  @GwtIncompatible("NavigableSet")
  public ContiguousSet<C> subSet(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramC1);
    Preconditions.checkNotNull(paramC2);
    if (comparator().compare(paramC1, paramC2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return subSetImpl(paramC1, paramBoolean1, paramC2, paramBoolean2);
    }
  }
  
  abstract ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2);
  
  public ContiguousSet<C> tailSet(C paramC)
  {
    return tailSetImpl((Comparable)Preconditions.checkNotNull(paramC), true);
  }
  
  @GwtIncompatible("NavigableSet")
  public ContiguousSet<C> tailSet(C paramC, boolean paramBoolean)
  {
    return tailSetImpl((Comparable)Preconditions.checkNotNull(paramC), paramBoolean);
  }
  
  abstract ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean);
  
  public String toString()
  {
    return range().toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ContiguousSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */