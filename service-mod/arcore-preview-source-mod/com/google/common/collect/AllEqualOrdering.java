package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class AllEqualOrdering
  extends Ordering<Object>
  implements Serializable
{
  static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
  private static final long serialVersionUID = 0L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return 0;
  }
  
  public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> paramIterable)
  {
    return ImmutableList.copyOf(paramIterable);
  }
  
  public <S> Ordering<S> reverse()
  {
    return this;
  }
  
  public <E> List<E> sortedCopy(Iterable<E> paramIterable)
  {
    return Lists.newArrayList(paramIterable);
  }
  
  public String toString()
  {
    return "Ordering.allEqual()";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AllEqualOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */