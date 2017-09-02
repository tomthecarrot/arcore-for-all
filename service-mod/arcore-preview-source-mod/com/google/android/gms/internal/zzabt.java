package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzabt
  implements Parcelable.Creator<zzabs>
{
  static void zza(zzabs paramzzabs, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzabs.mVersionCode);
    zzc.zzc(paramParcel, 2, paramzzabs.zzAn(), false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public zzabs zzdG(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zzb.zzc(paramParcel, k, zzabs.zza.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzabs(i, localArrayList);
  }
  
  public zzabs[] zzgn(int paramInt)
  {
    return new zzabs[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */