package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzaf;

public class zzbgr
  implements Parcelable.Creator<zzbgq>
{
  static void zza(zzbgq paramzzbgq, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbgq.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzbgq.zzAb(), paramInt, false);
    zzc.zza(paramParcel, 3, paramzzbgq.zzWi(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzbgq zzqB(Parcel paramParcel)
  {
    zzaf localzzaf = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    ConnectionResult localConnectionResult = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zzb.zzg(paramParcel, k);
        continue;
        localConnectionResult = (ConnectionResult)zzb.zza(paramParcel, k, ConnectionResult.CREATOR);
        continue;
        localzzaf = (zzaf)zzb.zza(paramParcel, k, zzaf.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbgq(i, localConnectionResult, localzzaf);
  }
  
  public zzbgq[] zzvJ(int paramInt)
  {
    return new zzbgq[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */