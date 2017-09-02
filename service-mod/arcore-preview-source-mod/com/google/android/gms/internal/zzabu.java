package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzabu
  implements Parcelable.Creator<zzabs.zza>
{
  static void zza(zzabs.zza paramzza, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzza.versionCode);
    zzc.zza(paramParcel, 2, paramzza.stringValue, false);
    zzc.zzc(paramParcel, 3, paramzza.zzaTr);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public zzabs.zza zzdH(Parcel paramParcel)
  {
    int j = 0;
    int k = zzb.zzdA(paramParcel);
    String str = null;
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
        str = zzb.zzq(paramParcel, m);
        break;
      case 3: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new zzabs.zza(i, str, j);
  }
  
  public zzabs.zza[] zzgo(int paramInt)
  {
    return new zzabs.zza[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */