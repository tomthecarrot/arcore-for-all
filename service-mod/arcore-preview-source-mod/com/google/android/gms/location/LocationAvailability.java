package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class LocationAvailability
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzo();
  public static final int STATUS_INVALID_SCAN = 4;
  @Deprecated
  public static final int STATUS_IN_PROGRESS = 8;
  public static final int STATUS_LOCATION_DISABLED_IN_SETTINGS = 7;
  public static final int STATUS_NO_INFO_IN_DATABASE = 3;
  public static final int STATUS_SCANS_DISABLED_IN_SETTINGS = 6;
  public static final int STATUS_TIMED_OUT_ON_SCAN = 2;
  public static final int STATUS_UNABLE_TO_QUERY_DATABASE = 5;
  public static final int STATUS_UNKNOWN = 1;
  int zzbDN;
  int zzbDO;
  long zzbDP;
  int zzbDQ;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.zzbDQ = paramInt1;
    this.zzbDN = paramInt2;
    this.zzbDO = paramInt3;
    this.zzbDP = paramLong;
  }
  
  public static LocationAvailability create(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return new LocationAvailability(paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public static LocationAvailability extractLocationAvailability(Intent paramIntent)
  {
    if (!hasLocationAvailability(paramIntent)) {
      return null;
    }
    return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public static boolean hasLocationAvailability(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationAvailability)) {}
    do
    {
      return false;
      paramObject = (LocationAvailability)paramObject;
    } while ((this.zzbDQ != ((LocationAvailability)paramObject).zzbDQ) || (this.zzbDN != ((LocationAvailability)paramObject).zzbDN) || (this.zzbDO != ((LocationAvailability)paramObject).zzbDO) || (this.zzbDP != ((LocationAvailability)paramObject).zzbDP));
    return true;
  }
  
  public int getCellStatus()
  {
    return this.zzbDN;
  }
  
  public long getElapsedRealtimeNs()
  {
    return this.zzbDP;
  }
  
  public int getWifiStatus()
  {
    return this.zzbDO;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzbDQ), Integer.valueOf(this.zzbDN), Integer.valueOf(this.zzbDO), Long.valueOf(this.zzbDP) });
  }
  
  public boolean isLocationAvailable()
  {
    return this.zzbDQ < 1000;
  }
  
  public String toString()
  {
    boolean bool = isLocationAvailable();
    return 48 + "LocationAvailability[isLocationAvailable: " + bool + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NetworkLocationStatusCode {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */