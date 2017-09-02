package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.tasks.Task;

public class SettingsClient
  extends zzd<Api.ApiOptions.NoOptions>
{
  public SettingsClient(@NonNull Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new zzym());
  }
  
  public SettingsClient(@NonNull Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new zzym());
  }
  
  public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest paramLocationSettingsRequest)
  {
    return zzab.zza(LocationServices.SettingsApi.checkLocationSettings(asGoogleApiClient(), paramLocationSettingsRequest), new LocationSettingsResponse());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/SettingsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */