package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzabj
  extends zzl<zzabl>
{
  public zzabj(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzabl zzdm(IBinder paramIBinder)
  {
    return zzabl.zza.zzdo(paramIBinder);
  }
  
  public String zzeJ()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */