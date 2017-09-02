package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaao;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.location.internal.zzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class ActivityRecognitionClient
  extends zzd<Api.ApiOptions.NoOptions>
{
  public ActivityRecognitionClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new zzym());
  }
  
  public ActivityRecognitionClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new zzym());
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<ActivityRecognitionResult> getLastActivity()
  {
    doRead(new zzaao()
    {
      protected void zza(zzn paramAnonymouszzn, TaskCompletionSource<ActivityRecognitionResult> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymousTaskCompletionSource.setResult(paramAnonymouszzn.zzKr());
      }
    });
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> removeFloorChangeUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.removeFloorChangeUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> removeGestureUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.removeGestureUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> removeSleepSegmentUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.removeSleepSegmentUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(asGoogleApiClient(), paramLong, paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> requestFloorChangeUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.requestFloorChangeUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> requestGestureUpdates(GestureRequest paramGestureRequest, PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.requestGestureUpdates(asGoogleApiClient(), paramGestureRequest, paramPendingIntent));
  }
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public Task<Void> requestSleepSegmentUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(ActivityRecognition.ActivityRecognitionApi.requestSleepSegmentUpdates(asGoogleApiClient(), paramPendingIntent));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/ActivityRecognitionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */