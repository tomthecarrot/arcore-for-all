package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzaa;

public final class zzyn<O extends Api.ApiOptions>
{
  private final Api<O> zzaHI;
  private final O zzaKy;
  private final boolean zzaLp;
  private final int zzaLq;
  
  private zzyn(Api<O> paramApi)
  {
    this.zzaLp = true;
    this.zzaHI = paramApi;
    this.zzaKy = null;
    this.zzaLq = System.identityHashCode(this);
  }
  
  private zzyn(Api<O> paramApi, O paramO)
  {
    this.zzaLp = false;
    this.zzaHI = paramApi;
    this.zzaKy = paramO;
    this.zzaLq = zzaa.hashCode(new Object[] { this.zzaHI, this.zzaKy });
  }
  
  public static <O extends Api.ApiOptions> zzyn<O> zza(Api<O> paramApi, O paramO)
  {
    return new zzyn(paramApi, paramO);
  }
  
  public static <O extends Api.ApiOptions> zzyn<O> zzb(Api<O> paramApi)
  {
    return new zzyn(paramApi);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzyn)) {
        return false;
      }
      paramObject = (zzyn)paramObject;
    } while ((!this.zzaLp) && (!((zzyn)paramObject).zzaLp) && (zzaa.equal(this.zzaHI, ((zzyn)paramObject).zzaHI)) && (zzaa.equal(this.zzaKy, ((zzyn)paramObject).zzaKy)));
    return false;
  }
  
  public int hashCode()
  {
    return this.zzaLq;
  }
  
  public String zzxi()
  {
    return this.zzaHI.getName();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */