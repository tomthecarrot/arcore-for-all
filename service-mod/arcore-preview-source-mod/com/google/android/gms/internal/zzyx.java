package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzg;

public final class zzyx<O extends Api.ApiOptions>
  extends zzd<O>
{
  private final Api.zza<? extends zzbgc, zzbgd> zzaKT;
  private final Api.zze zzaMn;
  private final zzyu zzaMo;
  private final zzg zzaMp;
  
  public zzyx(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper, @NonNull Api.zze paramzze, @NonNull zzyu paramzzyu, zzg paramzzg, Api.zza<? extends zzbgc, zzbgd> paramzza)
  {
    super(paramContext, paramApi, paramLooper);
    this.zzaMn = paramzze;
    this.zzaMo = paramzzyu;
    this.zzaMp = paramzzg;
    this.zzaKT = paramzza;
    this.zzaKC.zzb(this);
  }
  
  public Api.zze buildApiClient(Looper paramLooper, zzzl.zza<O> paramzza)
  {
    this.zzaMo.zza(paramzza);
    return this.zzaMn;
  }
  
  public zzaai createSignInCoordinator(Context paramContext, Handler paramHandler)
  {
    return new zzaai(paramContext, paramHandler, this.zzaMp, this.zzaKT);
  }
  
  public Api.zze zzxG()
  {
    return this.zzaMn;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */