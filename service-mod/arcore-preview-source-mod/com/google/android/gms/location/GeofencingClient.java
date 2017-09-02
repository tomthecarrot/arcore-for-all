package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class GeofencingClient
  extends zzd<Api.ApiOptions.NoOptions>
{
  public GeofencingClient(@NonNull Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new zzym());
  }
  
  public GeofencingClient(@NonNull Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new zzym());
  }
  
  @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
  public Task<Void> addGeofences(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    return zzab.zzb(LocationServices.GeofencingApi.addGeofences(asGoogleApiClient(), paramGeofencingRequest, paramPendingIntent));
  }
  
  public Task<Void> removeGeofences(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(LocationServices.GeofencingApi.removeGeofences(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Void> removeGeofences(List<String> paramList)
  {
    return zzab.zzb(LocationServices.GeofencingApi.removeGeofences(asGoogleApiClient(), paramList));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/GeofencingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */