package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzh
  implements Parcelable.Creator<DetectedActivity>
{
  static void zza(DetectedActivity paramDetectedActivity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramDetectedActivity.zzbDi);
    zzc.zzc(paramParcel, 2, paramDetectedActivity.zzbDj);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public DetectedActivity zzjJ(Parcel paramParcel)
  {
    int j = 0;
    int k = zzb.zzdA(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new DetectedActivity(i, j);
  }
  
  public DetectedActivity[] zznO(int paramInt)
  {
    return new DetectedActivity[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */