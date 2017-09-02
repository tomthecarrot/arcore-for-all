package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzbpg
  implements Result
{
  private final zza zzcBB;
  
  public zzbpg(zza paramzza)
  {
    this.zzcBB = paramzza;
  }
  
  public Status getStatus()
  {
    return this.zzcBB.getStatus();
  }
  
  public zza zzaao()
  {
    return this.zzcBB;
  }
  
  public static class zza
  {
    private final Status zzaiT;
    private final byte[] zzcAv;
    private final long zzcAw;
    private final zza zzcBC;
    private final zzbpa zzcBD;
    private final zzbph.zzc zzcBE;
    
    public zza(Status paramStatus, zzbpa paramzzbpa, zza paramzza)
    {
      this(paramStatus, paramzzbpa, null, null, paramzza, 0L);
    }
    
    public zza(Status paramStatus, zzbpa paramzzbpa, byte[] paramArrayOfByte, zzbph.zzc paramzzc, zza paramzza, long paramLong)
    {
      this.zzaiT = paramStatus;
      this.zzcBD = paramzzbpa;
      this.zzcAv = paramArrayOfByte;
      this.zzcBE = paramzzc;
      this.zzcBC = paramzza;
      this.zzcAw = paramLong;
    }
    
    public byte[] getRawData()
    {
      return this.zzcAv;
    }
    
    public Status getStatus()
    {
      return this.zzaiT;
    }
    
    public long zzZI()
    {
      return this.zzcAw;
    }
    
    public zza zzaap()
    {
      return this.zzcBC;
    }
    
    public zzbpa zzaaq()
    {
      return this.zzcBD;
    }
    
    public zzbph.zzc zzaar()
    {
      return this.zzcBE;
    }
    
    public static enum zza
    {
      private zza() {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */