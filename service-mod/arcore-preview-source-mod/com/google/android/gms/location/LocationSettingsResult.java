package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class LocationSettingsResult
  extends zza
  implements Result
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzt();
  private final Status zzaiT;
  private final LocationSettingsStates zzbEf;
  
  public LocationSettingsResult(Status paramStatus)
  {
    this(paramStatus, null);
  }
  
  public LocationSettingsResult(Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    this.zzaiT = paramStatus;
    this.zzbEf = paramLocationSettingsStates;
  }
  
  public LocationSettingsStates getLocationSettingsStates()
  {
    return this.zzbEf;
  }
  
  public Status getStatus()
  {
    return this.zzaiT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationSettingsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */