package com.google.android.gms.clearcut.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzl;

public class zzc
  extends zzl<zzh>
{
  public zzc(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 40, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void zza(zzg paramzzg)
    throws RemoteException
  {
    ((zzh)zzzw()).zza(paramzzg);
  }
  
  public void zza(zzg paramzzg, LogEventParcelable paramLogEventParcelable)
    throws RemoteException
  {
    ((zzh)zzzw()).zza(paramzzg, paramLogEventParcelable);
  }
  
  public void zzb(zzg paramzzg)
    throws RemoteException
  {
    ((zzh)zzzw()).zzb(paramzzg);
  }
  
  public void zzc(zzg paramzzg)
    throws RemoteException
  {
    ((zzh)zzzw()).zzc(paramzzg);
  }
  
  protected zzh zzcS(IBinder paramIBinder)
  {
    return zzh.zza.zzcW(paramIBinder);
  }
  
  public void zzd(zzg paramzzg)
    throws RemoteException
  {
    ((zzh)zzzw()).zzd(paramzzg);
  }
  
  protected String zzeJ()
  {
    return "com.google.android.gms.clearcut.service.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */