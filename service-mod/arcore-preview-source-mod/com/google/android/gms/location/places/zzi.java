package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzi
  implements Parcelable.Creator<PlaceReport>
{
  static void zza(PlaceReport paramPlaceReport, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramPlaceReport.mVersionCode);
    zzc.zza(paramParcel, 2, paramPlaceReport.getPlaceId(), false);
    zzc.zza(paramParcel, 3, paramPlaceReport.getTag(), false);
    zzc.zza(paramParcel, 4, paramPlaceReport.getSource(), false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public PlaceReport zzkl(Parcel paramParcel)
  {
    String str3 = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str1 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        str3 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceReport(i, str1, str2, str3);
  }
  
  public PlaceReport[] zzoA(int paramInt)
  {
    return new PlaceReport[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/places/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */