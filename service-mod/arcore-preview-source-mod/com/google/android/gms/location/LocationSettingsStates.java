package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class LocationSettingsStates
  extends zza
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzu();
  private final boolean zzbEg;
  private final boolean zzbEh;
  private final boolean zzbEi;
  private final boolean zzbEj;
  private final boolean zzbEk;
  private final boolean zzbEl;
  
  public LocationSettingsStates(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.zzbEg = paramBoolean1;
    this.zzbEh = paramBoolean2;
    this.zzbEi = paramBoolean3;
    this.zzbEj = paramBoolean4;
    this.zzbEk = paramBoolean5;
    this.zzbEl = paramBoolean6;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)zzd.zza(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public boolean isBlePresent()
  {
    return this.zzbEl;
  }
  
  public boolean isBleUsable()
  {
    return this.zzbEi;
  }
  
  public boolean isGpsPresent()
  {
    return this.zzbEj;
  }
  
  public boolean isGpsUsable()
  {
    return this.zzbEg;
  }
  
  public boolean isLocationPresent()
  {
    return (this.zzbEj) || (this.zzbEk);
  }
  
  public boolean isLocationUsable()
  {
    return (this.zzbEg) || (this.zzbEh);
  }
  
  public boolean isNetworkLocationPresent()
  {
    return this.zzbEk;
  }
  
  public boolean isNetworkLocationUsable()
  {
    return this.zzbEh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationSettingsStates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */