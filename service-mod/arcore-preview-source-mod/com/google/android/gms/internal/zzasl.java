package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.reporting.OptInRequest;
import com.google.android.gms.location.reporting.OptInResult;
import com.google.android.gms.location.reporting.ReportingState;
import com.google.android.gms.location.reporting.UploadRequest;
import com.google.android.gms.location.reporting.UploadRequestResult;

public class zzasl
  extends zzl<zzasj>
{
  public zzasl(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 22, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  int zza(Account paramAccount, PlaceReport paramPlaceReport)
    throws RemoteException
  {
    zzzv();
    return ((zzasj)zzzw()).zza(paramAccount, paramPlaceReport);
  }
  
  int zza(OptInRequest paramOptInRequest)
    throws RemoteException
  {
    zzzv();
    return OptInResult.sanitize(((zzasj)zzzw()).zza(paramOptInRequest));
  }
  
  UploadRequestResult zza(UploadRequest paramUploadRequest)
    throws RemoteException
  {
    zzzv();
    if (paramUploadRequest.getAccount() == null) {
      throw new IllegalArgumentException();
    }
    return ((zzasj)zzzw()).zza(paramUploadRequest);
  }
  
  int zzag(long paramLong)
    throws RemoteException
  {
    zzzv();
    return ((zzasj)zzzw()).zzaf(paramLong);
  }
  
  protected String zzeJ()
  {
    return "com.google.android.gms.location.reporting.service.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.location.reporting.internal.IReportingService";
  }
  
  protected zzasj zzfG(IBinder paramIBinder)
  {
    return zzasj.zza.zzfF(paramIBinder);
  }
  
  ReportingState zzg(Account paramAccount)
    throws RemoteException
  {
    zzzv();
    return ((zzasj)zzzw()).zzg(paramAccount);
  }
  
  int zzh(Account paramAccount)
    throws RemoteException
  {
    zzzv();
    return OptInResult.sanitize(((zzasj)zzzw()).zzh(paramAccount));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzasl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */