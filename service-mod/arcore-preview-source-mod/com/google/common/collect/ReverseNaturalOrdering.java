package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable=true)
final class ReverseNaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
  private static final long serialVersionUID = 0L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    Preconditions.checkNotNull(paramComparable1);
    if (paramComparable1 == paramComparable2) {
      return 0;
    }
    return paramComparable2.compareTo(paramComparable1);
  }
  
  public <E extends Comparable> E max(E paramE1, E paramE2)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramE1, paramE2);
  }
  
  public <E extends Comparable> E max(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public <E extends Comparable> E max(Iterable<E> paramIterable)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramIterable);
  }
  
  public <E extends Comparable> E max(Iterator<E> paramIterator)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramIterator);
  }
  
  public <E extends Comparable> E min(E paramE1, E paramE2)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramE1, paramE2);
  }
  
  public <E extends Comparable> E min(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public <E extends Comparable> E min(Iterable<E> paramIterable)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramIterable);
  }
  
  public <E extends Comparable> E min(Iterator<E> paramIterator)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramIterator);
  }
  
  public <S extends Comparable> Ordering<S> reverse()
  {
    return Ordering.natural();
  }
  
  public String toString()
  {
    return "Ordering.natural().reverse()";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ReverseNaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */