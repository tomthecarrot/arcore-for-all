package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzag
  implements Parcelable.Creator<zzaf>
{
  static void zza(zzaf paramzzaf, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzaf.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzaf.zzaRb, false);
    zzc.zza(paramParcel, 3, paramzzaf.zzAb(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzzaf.zzAc());
    zzc.zza(paramParcel, 5, paramzzaf.zzAd());
    zzc.zzK(paramParcel, i);
  }
  
  public zzaf zzdw(Parcel paramParcel)
  {
    ConnectionResult localConnectionResult = null;
    boolean bool1 = false;
    int j = zzb.zzdA(paramParcel);
    boolean bool2 = false;
    IBinder localIBinder = null;
    int i = 0;
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
        localIBinder = zzb.zzr(paramParcel, k);
        break;
      case 3: 
        localConnectionResult = (ConnectionResult)zzb.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4: 
        bool2 = zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzaf(i, localIBinder, localConnectionResult, bool2, bool1);
  }
  
  public zzaf[] zzgd(int paramInt)
  {
    return new zzaf[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */