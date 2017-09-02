package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognition.zza;
import com.google.android.gms.location.ActivityRecognitionApi;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GestureRequest;

public class zza
  implements ActivityRecognitionApi
{
  public ActivityRecognitionResult getLastActivity(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = ActivityRecognition.zzq(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.zzKr();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzc(paramPendingIntent);
        zzb(Status.zzaLc);
      }
    });
  }
  
  public PendingResult<Status> removeFloorChangeUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzb(paramPendingIntent, this);
      }
    });
  }
  
  public PendingResult<Status> removeGestureUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return null;
  }
  
  public PendingResult<Status> removeSleepSegmentUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzd(paramPendingIntent, this);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(paramLong, this.zzbEu);
        zzb(Status.zzaLc);
      }
    });
  }
  
  public PendingResult<Status> requestFloorChangeUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(paramPendingIntent, this);
      }
    });
  }
  
  public PendingResult<Status> requestGestureUpdates(GoogleApiClient paramGoogleApiClient, GestureRequest paramGestureRequest, PendingIntent paramPendingIntent)
  {
    return null;
  }
  
  public PendingResult<Status> requestSleepSegmentUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzc(paramPendingIntent, this);
      }
    });
  }
  
  private static abstract class zza
    extends ActivityRecognition.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */