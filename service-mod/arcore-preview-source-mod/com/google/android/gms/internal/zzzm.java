package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzd;

public class zzzm<O extends Api.ApiOptions>
  extends zzzd
{
  private final zzd<O> zzaOn;
  
  public zzzm(zzd<O> paramzzd)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zzaOn = paramzzd;
  }
  
  public Context getContext()
  {
    return this.zzaOn.getApplicationContext();
  }
  
  public Looper getLooper()
  {
    return this.zzaOn.getLooper();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    return this.zzaOn.doRead(paramT);
  }
  
  public void zza(zzaaq paramzzaaq) {}
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    return this.zzaOn.doWrite(paramT);
  }
  
  public void zzb(zzaaq paramzzaaq) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */