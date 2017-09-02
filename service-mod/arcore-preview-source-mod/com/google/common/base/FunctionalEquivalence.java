package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class FunctionalEquivalence<F, T>
  extends Equivalence<F>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Function<F, ? extends T> function;
  private final Equivalence<T> resultEquivalence;
  
  FunctionalEquivalence(Function<F, ? extends T> paramFunction, Equivalence<T> paramEquivalence)
  {
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    this.resultEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
  }
  
  protected boolean doEquivalent(F paramF1, F paramF2)
  {
    return this.resultEquivalence.equivalent(this.function.apply(paramF1), this.function.apply(paramF2));
  }
  
  protected int doHash(F paramF)
  {
    return this.resultEquivalence.hash(this.function.apply(paramF));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof FunctionalEquivalence)) {
        break;
      }
      paramObject = (FunctionalEquivalence)paramObject;
    } while ((this.function.equals(((FunctionalEquivalence)paramObject).function)) && (this.resultEquivalence.equals(((FunctionalEquivalence)paramObject).resultEquivalence)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.function, this.resultEquivalence });
  }
  
  public String toString()
  {
    return this.resultEquivalence + ".onResultOf(" + this.function + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/FunctionalEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */