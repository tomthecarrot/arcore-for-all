package com.google.android.gms.common.util;

public abstract interface Clock
{
  public abstract long currentTimeMillis();
  
  public abstract long elapsedRealtime();
  
  public abstract long nanoTime();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */