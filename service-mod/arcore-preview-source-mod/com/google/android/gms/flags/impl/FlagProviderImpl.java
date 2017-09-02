package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzaqv.zza;

@DynamiteApi
public class FlagProviderImpl
  extends zzaqv.zza
{
  private SharedPreferences zzBv;
  private boolean zzus = false;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!this.zzus) {
      return paramBoolean;
    }
    return zza.zza.zza(this.zzBv, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.zzus) {
      return paramInt1;
    }
    return zza.zzb.zza(this.zzBv, paramString, Integer.valueOf(paramInt1)).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!this.zzus) {
      return paramLong;
    }
    return zza.zzc.zza(this.zzBv, paramString, Long.valueOf(paramLong)).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!this.zzus) {
      return paramString2;
    }
    return zza.zzd.zza(this.zzBv, paramString1, paramString2);
  }
  
  public void init(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (Context)zzd.zzI(paramIObjectWrapper);
    if (this.zzus) {
      return;
    }
    try
    {
      this.zzBv = zzb.zzn(paramIObjectWrapper.createPackageContext("com.google.android.gms", 0));
      this.zzus = true;
      return;
    }
    catch (PackageManager.NameNotFoundException paramIObjectWrapper) {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/flags/impl/FlagProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */