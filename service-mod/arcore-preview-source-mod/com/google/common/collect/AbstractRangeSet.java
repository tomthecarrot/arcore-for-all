package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

abstract class AbstractRangeSet<C extends Comparable>
  implements RangeSet<C>
{
  public void add(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public void addAll(RangeSet<C> paramRangeSet)
  {
    paramRangeSet = paramRangeSet.asRanges().iterator();
    while (paramRangeSet.hasNext()) {
      add((Range)paramRangeSet.next());
    }
  }
  
  public void clear()
  {
    remove(Range.all());
  }
  
  public boolean contains(C paramC)
  {
    return rangeContaining(paramC) != null;
  }
  
  public abstract boolean encloses(Range<C> paramRange);
  
  public boolean enclosesAll(RangeSet<C> paramRangeSet)
  {
    paramRangeSet = paramRangeSet.asRanges().iterator();
    while (paramRangeSet.hasNext()) {
      if (!encloses((Range)paramRangeSet.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof RangeSet))
    {
      paramObject = (RangeSet)paramObject;
      return asRanges().equals(((RangeSet)paramObject).asRanges());
    }
    return false;
  }
  
  public final int hashCode()
  {
    return asRanges().hashCode();
  }
  
  public boolean isEmpty()
  {
    return asRanges().isEmpty();
  }
  
  public abstract Range<C> rangeContaining(C paramC);
  
  public void remove(Range<C> paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public void removeAll(RangeSet<C> paramRangeSet)
  {
    paramRangeSet = paramRangeSet.asRanges().iterator();
    while (paramRangeSet.hasNext()) {
      remove((Range)paramRangeSet.next());
    }
  }
  
  public final String toString()
  {
    return asRanges().toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */