package com.google.android.gms.location.reporting;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzasl;
import com.google.android.gms.internal.zzasm;
import com.google.android.gms.internal.zzyr.zza;

public class ReportingServices
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ReportingServices.API", zzaiG, zzaiF);
  public static Reporting ReportingApi = new zzasm();
  private static final Api.zzf<zzasl> zzaiF = new Api.zzf();
  private static final Api.zza<zzasl, Api.ApiOptions.NoOptions> zzaiG = new Api.zza()
  {
    public zzasl zzG(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzasl(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static abstract class zza<R extends Result>
    extends zzyr.zza<R, zzasl>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/ReportingServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */