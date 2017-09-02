package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzq
{
  public static final int zzaSr = 23 - " PII_LOG".length();
  private static final String zzaSs = null;
  private final String zzaSt;
  private final String zzaSu;
  
  public zzq(String paramString)
  {
    this(paramString, null);
  }
  
  public zzq(String paramString1, String paramString2)
  {
    zzac.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      this.zzaSt = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      this.zzaSu = null;
      return;
    }
    this.zzaSu = paramString2;
  }
  
  private String zzdb(String paramString)
  {
    if (this.zzaSu == null) {
      return paramString;
    }
    return this.zzaSu.concat(paramString);
  }
  
  public void zzL(String paramString1, String paramString2)
  {
    if (zzga(3)) {
      Log.d(paramString1, zzdb(paramString2));
    }
  }
  
  public void zzM(String paramString1, String paramString2)
  {
    if (zzga(4)) {
      Log.i(paramString1, zzdb(paramString2));
    }
  }
  
  public void zzN(String paramString1, String paramString2)
  {
    if (zzga(5)) {
      Log.w(paramString1, zzdb(paramString2));
    }
  }
  
  public void zzO(String paramString1, String paramString2)
  {
    if (zzga(6)) {
      Log.e(paramString1, zzdb(paramString2));
    }
  }
  
  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzga(4)) {
      Log.i(paramString1, zzdb(paramString2), paramThrowable);
    }
  }
  
  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzga(5)) {
      Log.w(paramString1, zzdb(paramString2), paramThrowable);
    }
  }
  
  public void zzd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzga(6)) {
      Log.e(paramString1, zzdb(paramString2), paramThrowable);
    }
  }
  
  public void zze(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzga(7))
    {
      Log.e(paramString1, zzdb(paramString2), paramThrowable);
      Log.wtf(paramString1, zzdb(paramString2), paramThrowable);
    }
  }
  
  public boolean zzga(int paramInt)
  {
    return Log.isLoggable(this.zzaSt, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */