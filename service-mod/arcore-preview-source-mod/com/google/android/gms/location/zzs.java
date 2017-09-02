package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzs
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramLocationSettingsRequest.zzGa(), false);
    zzc.zza(paramParcel, 2, paramLocationSettingsRequest.zzKj());
    zzc.zza(paramParcel, 3, paramLocationSettingsRequest.zzKk());
    zzc.zza(paramParcel, 5, paramLocationSettingsRequest.zzKl(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public LocationSettingsRequest zzjS(Parcel paramParcel)
  {
    LocationSettingsConfiguration localLocationSettingsConfiguration = null;
    boolean bool2 = false;
    int i = zzb.zzdA(paramParcel);
    boolean bool1 = false;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      case 4: 
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        localArrayList = zzb.zzc(paramParcel, j, LocationRequest.CREATOR);
        break;
      case 2: 
        bool1 = zzb.zzc(paramParcel, j);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, j);
        break;
      case 5: 
        localLocationSettingsConfiguration = (LocationSettingsConfiguration)zzb.zza(paramParcel, j, LocationSettingsConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new LocationSettingsRequest(localArrayList, bool1, bool2, localLocationSettingsConfiguration);
  }
  
  public LocationSettingsRequest[] zzoa(int paramInt)
  {
    return new LocationSettingsRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */