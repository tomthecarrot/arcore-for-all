package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;

public final class zzf
{
  private static final String[] zzaUF = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzaUG = null;
  private static boolean zzaUH = false;
  private static int zzaUI = -1;
  private static int zzaUJ = 0;
  
  private static boolean zzAL()
  {
    return false;
  }
  
  public static boolean zza(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      zzac.zzC(paramContext);
      zzac.zzC(paramThrowable);
      return false;
    }
    catch (Exception paramContext)
    {
      try
      {
        bool = zzAL();
        if (bool) {
          throw paramContext;
        }
      }
      catch (Exception paramThrowable)
      {
        for (;;)
        {
          Log.e("CrashUtils", "Error determining which process we're running in!", paramThrowable);
          boolean bool = false;
        }
        Log.e("CrashUtils", "Error adding exception to DropBox!", paramContext);
      }
    }
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */