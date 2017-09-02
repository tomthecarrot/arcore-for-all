package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract interface Constraint<E>
{
  public abstract E checkElement(E paramE);
  
  public abstract String toString();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Constraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */