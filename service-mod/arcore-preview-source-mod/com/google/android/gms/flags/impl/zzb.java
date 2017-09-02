package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzaqx;
import java.util.concurrent.Callable;

public class zzb
{
  private static SharedPreferences zzbnz = null;
  
  public static SharedPreferences zzn(Context paramContext)
  {
    try
    {
      if (zzbnz == null) {
        zzbnz = (SharedPreferences)zzaqx.zzb(new Callable()
        {
          public SharedPreferences zzGA()
          {
            return zzb.this.getSharedPreferences("google_sdk_flags", 1);
          }
        });
      }
      paramContext = zzbnz;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/flags/impl/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */