package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class LocationSettingsConfiguration
  extends zza
{
  public static final Parcelable.Creator<LocationSettingsConfiguration> CREATOR = new zzr();
  public static final int ILLUSTRATION_ID_MAPS = 1001;
  public static final int ILLUSTRATION_ID_SEARCH = 1002;
  private final String zzbDY;
  private final String zzbDZ;
  private final int zzbEa;
  
  LocationSettingsConfiguration(String paramString1, String paramString2, int paramInt)
  {
    this.zzbDY = paramString1;
    this.zzbDZ = paramString2;
    this.zzbEa = paramInt;
  }
  
  public static LocationSettingsConfiguration createWithIllustrationId(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      throw new IllegalArgumentException("Experiment id can not be null or empty");
    }
    return new LocationSettingsConfiguration("", paramString, paramInt);
  }
  
  public static LocationSettingsConfiguration createWithJustificationText(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().isEmpty())) {
      throw new IllegalArgumentException("Justification text can not be null or empty");
    }
    if ((paramString2 == null) || (paramString2.trim().isEmpty())) {
      throw new IllegalArgumentException("Experiment id can not be null or empty");
    }
    return new LocationSettingsConfiguration(paramString1, paramString2, 0);
  }
  
  public String getExperimentId()
  {
    return this.zzbDZ;
  }
  
  public int getIllustrationId()
  {
    return this.zzbEa;
  }
  
  public String getJustificationText()
  {
    return this.zzbDY;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IllustrationId {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationSettingsConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */