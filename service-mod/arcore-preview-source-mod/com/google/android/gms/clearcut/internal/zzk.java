package com.google.android.gms.clearcut.internal;

public class zzk
{
  public static long zzf(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    return (Long.MAX_VALUE % paramLong2 + 1L + (paramLong1 & 0x7FFFFFFFFFFFFFFF) % paramLong2) % paramLong2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */