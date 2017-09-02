package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class PairwiseEquivalence<T>
  extends Equivalence<Iterable<T>>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  final Equivalence<? super T> elementEquivalence;
  
  PairwiseEquivalence(Equivalence<? super T> paramEquivalence)
  {
    this.elementEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
  }
  
  protected boolean doEquivalent(Iterable<T> paramIterable1, Iterable<T> paramIterable2)
  {
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    do
    {
      if ((!paramIterable1.hasNext()) || (!paramIterable2.hasNext())) {
        break;
      }
    } while (this.elementEquivalence.equivalent(paramIterable1.next(), paramIterable2.next()));
    while ((paramIterable1.hasNext()) || (paramIterable2.hasNext())) {
      return false;
    }
    return true;
  }
  
  protected int doHash(Iterable<T> paramIterable)
  {
    int i = 78721;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      i = i * 24943 + this.elementEquivalence.hash(localObject);
    }
    return i;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof PairwiseEquivalence))
    {
      paramObject = (PairwiseEquivalence)paramObject;
      return this.elementEquivalence.equals(((PairwiseEquivalence)paramObject).elementEquivalence);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.elementEquivalence.hashCode() ^ 0x46A3EB07;
  }
  
  public String toString()
  {
    return this.elementEquivalence + ".pairwise()";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/PairwiseEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */