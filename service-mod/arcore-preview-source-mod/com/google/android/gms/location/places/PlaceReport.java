package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzac;

public class PlaceReport
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzi();
  public static final String SOURCE_INFERRED_GEOFENCING = "inferredGeofencing";
  public static final String SOURCE_INFERRED_RADIO_SIGNALS = "inferredRadioSignals";
  public static final String SOURCE_INFERRED_REVERSE_GEOCODING = "inferredReverseGeocoding";
  public static final String SOURCE_INFERRED_SNAPPED_TO_ROAD = "inferredSnappedToRoad";
  public static final String SOURCE_UNKNOWN = "unknown";
  public static final String SOURCE_USER_REPORTED = "userReported";
  private final String mTag;
  final int mVersionCode;
  private final String zzacE;
  private final String zzbFH;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzbFH = paramString1;
    this.mTag = paramString2;
    this.zzacE = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return create(paramString1, paramString2, "unknown");
  }
  
  public static PlaceReport create(String paramString1, String paramString2, String paramString3)
  {
    zzac.zzC(paramString1);
    zzac.zzdc(paramString2);
    zzac.zzdc(paramString3);
    zzac.zzb(zzeV(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  private static boolean zzeV(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzaa.equal(this.zzbFH, ((PlaceReport)paramObject).zzbFH)) || (!zzaa.equal(this.mTag, ((PlaceReport)paramObject).mTag)) || (!zzaa.equal(this.zzacE, ((PlaceReport)paramObject).zzacE)));
    return true;
  }
  
  public String getPlaceId()
  {
    return this.zzbFH;
  }
  
  public String getSource()
  {
    return this.zzacE;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzbFH, this.mTag, this.zzacE });
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzB(this);
    localzza.zzh("placeId", this.zzbFH);
    localzza.zzh("tag", this.mTag);
    if (!"unknown".equals(this.zzacE)) {
      localzza.zzh("source", this.zzacE);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/places/PlaceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */