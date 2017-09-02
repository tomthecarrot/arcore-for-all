package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzo
  implements Parcelable.Creator<LocationAvailability>
{
  static void zza(LocationAvailability paramLocationAvailability, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramLocationAvailability.zzbDN);
    zzc.zzc(paramParcel, 2, paramLocationAvailability.zzbDO);
    zzc.zza(paramParcel, 3, paramLocationAvailability.zzbDP);
    zzc.zzc(paramParcel, 4, paramLocationAvailability.zzbDQ);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public LocationAvailability zzjO(Parcel paramParcel)
  {
    int i = 1;
    int m = zzb.zzdA(paramParcel);
    int k = 1000;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        l = zzb.zzi(paramParcel, n);
        break;
      case 4: 
        k = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new LocationAvailability(k, j, i, l);
  }
  
  public LocationAvailability[] zznU(int paramInt)
  {
    return new LocationAvailability[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */