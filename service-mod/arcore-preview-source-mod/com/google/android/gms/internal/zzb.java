package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public abstract interface zzb
{
  public abstract void initialize();
  
  public abstract zza zza(String paramString);
  
  public abstract void zza(String paramString, zza paramzza);
  
  public static class zza
  {
    public byte[] data;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf = Collections.emptyMap();
    
    public boolean zza()
    {
      return this.zzd < System.currentTimeMillis();
    }
    
    public boolean zzb()
    {
      return this.zze < System.currentTimeMillis();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */