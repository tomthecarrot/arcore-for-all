package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzai
  implements Parcelable.Creator<zzah>
{
  static void zza(zzah paramzzah, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzah.mVersionCode);
    zzc.zzc(paramParcel, 2, paramzzah.zzAe());
    zzc.zzc(paramParcel, 3, paramzzah.zzAf());
    zzc.zza(paramParcel, 4, paramzzah.zzAg(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzah zzdx(Parcel paramParcel)
  {
    int k = 0;
    int m = zzb.zzdA(paramParcel);
    Scope[] arrayOfScope = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, n, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzah(i, j, k, arrayOfScope);
  }
  
  public zzah[] zzge(int paramInt)
  {
    return new zzah[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */