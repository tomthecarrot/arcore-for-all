package com.google.android.gms.clearcut.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zza
  extends zzl<zzf>
{
  public zza(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 124, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void zza(zze paramzze)
    throws RemoteException
  {
    ((zzf)zzzw()).zza(paramzze);
  }
  
  protected zzf zzcR(IBinder paramIBinder)
  {
    return zzf.zza.zzcU(paramIBinder);
  }
  
  protected String zzeJ()
  {
    return "com.google.android.gms.clearcut.bootcount.service.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.clearcut.internal.IBootCountService";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */