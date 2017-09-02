package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzabz;
import com.google.android.gms.internal.zzaca;

public class zzz
{
  private static boolean zzPZ;
  private static String zzaSv;
  private static int zzaSw;
  private static Object zzuq = new Object();
  
  public static String zzbc(Context paramContext)
  {
    zzbe(paramContext);
    return zzaSv;
  }
  
  public static int zzbd(Context paramContext)
  {
    zzbe(paramContext);
    return zzaSw;
  }
  
  private static void zzbe(Context paramContext)
  {
    String str;
    synchronized (zzuq)
    {
      if (zzPZ) {
        return;
      }
      zzPZ = true;
      str = paramContext.getPackageName();
      paramContext = zzaca.zzbp(paramContext);
    }
    try
    {
      paramContext = paramContext.getApplicationInfo(str, 128).metaData;
      if (paramContext == null)
      {
        return;
        paramContext = finally;
        throw paramContext;
      }
      zzaSv = paramContext.getString("com.google.app.id");
      zzaSw = paramContext.getInt("com.google.android.gms.version");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */