package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zzae
{
  private static volatile Logger zzafk;
  
  static
  {
    setLogger(new zzt());
  }
  
  public static Logger getLogger()
  {
    return zzafk;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzafk = paramLogger;
  }
  
  public static void v(String paramString)
  {
    Object localObject = zzaf.zzpv();
    if (localObject != null) {
      ((zzaf)localObject).zzbr(paramString);
    }
    for (;;)
    {
      localObject = zzafk;
      if (localObject != null) {
        ((Logger)localObject).verbose(paramString);
      }
      return;
      if (zzao(0)) {
        Log.v((String)G.loggingTag.get(), paramString);
      }
    }
  }
  
  public static void w(String paramString)
  {
    Object localObject = zzaf.zzpv();
    if (localObject != null) {
      ((zzaf)localObject).zzbu(paramString);
    }
    for (;;)
    {
      localObject = zzafk;
      if (localObject != null) {
        ((Logger)localObject).warn(paramString);
      }
      return;
      if (zzao(2)) {
        Log.w((String)G.loggingTag.get(), paramString);
      }
    }
  }
  
  public static boolean zzao(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() <= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void zzf(String paramString, Object paramObject)
  {
    zzaf localzzaf = zzaf.zzpv();
    if (localzzaf != null) {
      localzzaf.zze(paramString, paramObject);
    }
    while (!zzao(3))
    {
      paramObject = zzafk;
      if (paramObject != null) {
        ((Logger)paramObject).error(paramString);
      }
      return;
    }
    if (paramObject != null) {
      paramObject = String.valueOf(paramObject);
    }
    for (paramObject = String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + ":" + (String)paramObject;; paramObject = paramString)
    {
      Log.e((String)G.loggingTag.get(), (String)paramObject);
      break;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */