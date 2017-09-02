package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzad;

public class zzbgp
  implements Parcelable.Creator<zzbgo>
{
  static void zza(zzbgo paramzzbgo, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbgo.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzbgo.zzWh(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzbgo zzqA(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    zzad localzzad = null;
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
        localzzad = (zzad)zzb.zza(paramParcel, k, zzad.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbgo(i, localzzad);
  }
  
  public zzbgo[] zzvI(int paramInt)
  {
    return new zzbgo[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */