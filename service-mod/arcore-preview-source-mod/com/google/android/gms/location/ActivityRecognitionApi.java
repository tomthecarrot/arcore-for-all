package com.google.android.gms.location;

import android.app.PendingIntent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface ActivityRecognitionApi
{
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract ActivityRecognitionResult getLastActivity(GoogleApiClient paramGoogleApiClient);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> removeFloorChangeUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> removeGestureUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> removeSleepSegmentUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> requestFloorChangeUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> requestGestureUpdates(GoogleApiClient paramGoogleApiClient, GestureRequest paramGestureRequest, PendingIntent paramPendingIntent);
  
  @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
  public abstract PendingResult<Status> requestSleepSegmentUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/ActivityRecognitionApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */