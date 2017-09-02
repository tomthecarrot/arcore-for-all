package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbgf
  implements Parcelable.Creator<zzbge>
{
  static void zza(zzbge paramzzbge, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbge.mVersionCode);
    zzc.zzc(paramParcel, 2, paramzzbge.zzWd());
    zzc.zza(paramParcel, 3, paramzzbge.zzWe(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzbge zzqx(Parcel paramParcel)
  {
    int j = 0;
    int k = zzb.zzdA(paramParcel);
    Intent localIntent = null;
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
        break;
      case 3: 
        localIntent = (Intent)zzb.zza(paramParcel, m, Intent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzbge(i, j, localIntent);
  }
  
  public zzbge[] zzvE(int paramInt)
  {
    return new zzbge[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */