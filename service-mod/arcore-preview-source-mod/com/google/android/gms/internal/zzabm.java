package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzq;

public class zzabm
{
  private final String mTag;
  private final zzq zzaSP;
  private final String zzaSu;
  private final int zzaeL;
  
  private zzabm(String paramString1, String paramString2)
  {
    this.zzaSu = paramString2;
    this.mTag = paramString1;
    this.zzaSP = new zzq(paramString1);
    this.zzaeL = getLogLevel();
  }
  
  public zzabm(String paramString, String... paramVarArgs)
  {
    this(paramString, zzd(paramVarArgs));
  }
  
  private int getLogLevel()
  {
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i))) {
      i += 1;
    }
    return i;
  }
  
  private static String zzd(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    localStringBuilder.append(']').append(' ');
    return localStringBuilder.toString();
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return this.zzaSu.concat(str);
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public void zza(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.e(this.mTag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void zza(String paramString, Object... paramVarArgs)
  {
    if (zzao(2)) {
      Log.v(this.mTag, format(paramString, paramVarArgs));
    }
  }
  
  public boolean zzao(int paramInt)
  {
    return this.zzaeL <= paramInt;
  }
  
  public void zzb(String paramString, Object... paramVarArgs)
  {
    if (zzao(3)) {
      Log.d(this.mTag, format(paramString, paramVarArgs));
    }
  }
  
  public void zze(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, format(paramString, paramVarArgs));
  }
  
  public void zzf(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, format(paramString, paramVarArgs));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */