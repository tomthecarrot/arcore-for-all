package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables
{
  public static <E> Comparator<? super E> comparator(SortedSet<E> paramSortedSet)
  {
    Comparator localComparator = paramSortedSet.comparator();
    paramSortedSet = localComparator;
    if (localComparator == null) {
      paramSortedSet = Ordering.natural();
    }
    return paramSortedSet;
  }
  
  public static boolean hasSameComparator(Comparator<?> paramComparator, Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof SortedSet)) {}
    for (paramIterable = comparator((SortedSet)paramIterable);; paramIterable = ((SortedIterable)paramIterable).comparator())
    {
      return paramComparator.equals(paramIterable);
      if (!(paramIterable instanceof SortedIterable)) {
        break;
      }
    }
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/SortedIterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */