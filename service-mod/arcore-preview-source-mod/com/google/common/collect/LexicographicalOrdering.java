package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class LexicographicalOrdering<T>
  extends Ordering<Iterable<T>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super T> elementOrder;
  
  LexicographicalOrdering(Comparator<? super T> paramComparator)
  {
    this.elementOrder = paramComparator;
  }
  
  public int compare(Iterable<T> paramIterable1, Iterable<T> paramIterable2)
  {
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    while (paramIterable1.hasNext())
    {
      if (!paramIterable2.hasNext()) {
        return 1;
      }
      int i = this.elementOrder.compare(paramIterable1.next(), paramIterable2.next());
      if (i != 0) {
        return i;
      }
    }
    if (paramIterable2.hasNext()) {
      return -1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof LexicographicalOrdering))
    {
      paramObject = (LexicographicalOrdering)paramObject;
      return this.elementOrder.equals(((LexicographicalOrdering)paramObject).elementOrder);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.elementOrder.hashCode() ^ 0x7BB78CF5;
  }
  
  public String toString()
  {
    return this.elementOrder + ".lexicographical()";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/LexicographicalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */