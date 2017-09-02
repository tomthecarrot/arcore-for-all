package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzabr
  implements Parcelable.Creator<zzabq>
{
  static void zza(zzabq paramzzabq, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzabq.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzabq.zzAl(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzabq zzdF(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    zzabs localzzabs = null;
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
        localzzabs = (zzabs)zzb.zza(paramParcel, k, zzabs.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzabq(i, localzzabs);
  }
  
  public zzabq[] zzgm(int paramInt)
  {
    return new zzabq[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */