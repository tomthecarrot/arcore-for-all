package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class zzbgd
  implements Api.ApiOptions.Optional
{
  public static final zzbgd zzcqC = new zza().zzWc();
  private final boolean zzalK;
  private final String zzalL;
  private final boolean zzamD;
  private final String zzamE;
  private final boolean zzcqD;
  private final boolean zzcqE;
  private final Long zzcqF;
  private final Long zzcqG;
  
  private zzbgd(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2)
  {
    this.zzcqD = paramBoolean1;
    this.zzalK = paramBoolean2;
    this.zzalL = paramString1;
    this.zzamD = paramBoolean3;
    this.zzcqE = paramBoolean4;
    this.zzamE = paramString2;
    this.zzcqF = paramLong1;
    this.zzcqG = paramLong2;
  }
  
  public String getServerClientId()
  {
    return this.zzalL;
  }
  
  public boolean isIdTokenRequested()
  {
    return this.zzalK;
  }
  
  public boolean zzVY()
  {
    return this.zzcqD;
  }
  
  public boolean zzVZ()
  {
    return this.zzcqE;
  }
  
  @Nullable
  public Long zzWa()
  {
    return this.zzcqF;
  }
  
  @Nullable
  public Long zzWb()
  {
    return this.zzcqG;
  }
  
  public boolean zzqJ()
  {
    return this.zzamD;
  }
  
  @Nullable
  public String zzqK()
  {
    return this.zzamE;
  }
  
  public static final class zza
  {
    public zzbgd zzWc()
    {
      return new zzbgd(false, false, null, false, null, false, null, null, null);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */