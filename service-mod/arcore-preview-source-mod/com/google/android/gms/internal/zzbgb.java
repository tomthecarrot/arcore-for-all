package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;

public final class zzbgb
{
  public static final Api<zzbgd> API = new Api("SignIn.API", zzaiG, zzaiF);
  public static final Api<zza> zzaYz = new Api("SignIn.INTERNAL_API", zzcqA, zzcqz);
  public static final Api.zzf<zzbgn> zzaiF = new Api.zzf();
  public static final Api.zza<zzbgn, zzbgd> zzaiG;
  public static final Scope zzamy;
  public static final Scope zzamz;
  static final Api.zza<zzbgn, zza> zzcqA;
  public static final Api.zzf<zzbgn> zzcqz = new Api.zzf();
  
  static
  {
    zzaiG = new Api.zza()
    {
      public zzbgn zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, zzbgd paramAnonymouszzbgd, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymouszzbgd == null) {
          paramAnonymouszzbgd = zzbgd.zzcqC;
        }
        for (;;)
        {
          return new zzbgn(paramAnonymousContext, paramAnonymousLooper, true, paramAnonymouszzg, paramAnonymouszzbgd, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
        }
      }
    };
    zzcqA = new Api.zza()
    {
      public zzbgn zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, zzbgb.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new zzbgn(paramAnonymousContext, paramAnonymousLooper, false, paramAnonymouszzg, paramAnonymouszza.zzVW(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
    zzamy = new Scope("profile");
    zzamz = new Scope("email");
  }
  
  public static class zza
    implements Api.ApiOptions.HasOptions
  {
    private final Bundle zzcqB;
    
    public Bundle zzVW()
    {
      return this.zzcqB;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */