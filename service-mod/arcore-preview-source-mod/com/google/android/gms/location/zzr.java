package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzr
  implements Parcelable.Creator<LocationSettingsConfiguration>
{
  static void zza(LocationSettingsConfiguration paramLocationSettingsConfiguration, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramLocationSettingsConfiguration.getJustificationText(), false);
    zzc.zza(paramParcel, 2, paramLocationSettingsConfiguration.getExperimentId(), false);
    zzc.zzc(paramParcel, 3, paramLocationSettingsConfiguration.getIllustrationId());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public LocationSettingsConfiguration zzjR(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    String str1 = "";
    String str2 = "";
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 2: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsConfiguration(str1, str2, i);
  }
  
  public LocationSettingsConfiguration[] zznZ(int paramInt)
  {
    return new LocationSettingsConfiguration[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */