package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract interface LongAddable
{
  public abstract void add(long paramLong);
  
  public abstract void increment();
  
  public abstract long sum();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/LongAddable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */