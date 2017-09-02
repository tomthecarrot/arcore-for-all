package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;

public class zzasn
{
  public static Looper zzLc()
  {
    if (Looper.myLooper() != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      return Looper.myLooper();
    }
  }
  
  public static Looper zzc(@Nullable Looper paramLooper)
  {
    if (paramLooper != null) {
      return paramLooper;
    }
    return zzLc();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzasn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */