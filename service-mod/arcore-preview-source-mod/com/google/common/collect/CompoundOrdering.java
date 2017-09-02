package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible(serializable=true)
final class CompoundOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableList<Comparator<? super T>> comparators;
  
  CompoundOrdering(Iterable<? extends Comparator<? super T>> paramIterable)
  {
    this.comparators = ImmutableList.copyOf(paramIterable);
  }
  
  CompoundOrdering(Comparator<? super T> paramComparator1, Comparator<? super T> paramComparator2)
  {
    this.comparators = ImmutableList.of(paramComparator1, paramComparator2);
  }
  
  public int compare(T paramT1, T paramT2)
  {
    int j = this.comparators.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Comparator)this.comparators.get(i)).compare(paramT1, paramT2);
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CompoundOrdering))
    {
      paramObject = (CompoundOrdering)paramObject;
      return this.comparators.equals(((CompoundOrdering)paramObject).comparators);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.comparators.hashCode();
  }
  
  public String toString()
  {
    return "Ordering.compound(" + this.comparators + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/CompoundOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */