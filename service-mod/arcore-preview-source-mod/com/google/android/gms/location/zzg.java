package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<zzf>
{
  static void zza(zzf paramzzf, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramzzf.zzKg(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, paramzzf.getTag(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 3, paramzzf.zzKh(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, paramInt);
  }
  
  public zzf zzjI(Parcel paramParcel)
  {
    ArrayList localArrayList2 = null;
    int i = zzb.zzdA(paramParcel);
    String str = null;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        localArrayList1 = zzb.zzc(paramParcel, j, zzd.CREATOR);
        break;
      case 2: 
        str = zzb.zzq(paramParcel, j);
        break;
      case 3: 
        localArrayList2 = zzb.zzc(paramParcel, j, com.google.android.gms.location.internal.zzc.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzf(localArrayList1, str, localArrayList2);
  }
  
  public zzf[] zznL(int paramInt)
  {
    return new zzf[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */