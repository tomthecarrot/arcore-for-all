package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzq
  implements Parcelable.Creator<LocationResult>
{
  static void zza(LocationResult paramLocationResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramLocationResult.getLocations(), false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public LocationResult zzjQ(Parcel paramParcel)
  {
    int i = zzb.zzdA(paramParcel);
    Object localObject = LocationResult.zzbDW;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        localObject = zzb.zzc(paramParcel, j, Location.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new LocationResult((List)localObject);
  }
  
  public LocationResult[] zznY(int paramInt)
  {
    return new LocationResult[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */