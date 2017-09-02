package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.clearcut.internal.zza;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public final class BootCount
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("BootCount.API", zzaiG, zzaiF);
  public static final Api.zzf<zza> zzaiF = new Api.zzf();
  public static final Api.zza<zza, Api.ApiOptions.NoOptions> zzaiG = new Api.zza()
  {
    public zza zzk(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zza(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static BootCountClient getInstance(Context paramContext)
  {
    return new BootCountClient(paramContext);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/BootCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */