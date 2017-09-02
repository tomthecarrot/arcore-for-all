package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<zzd>
{
  static void zza(zzd paramzzd, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzd.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzd.zzaRb, false);
    zzc.zza(paramParcel, 3, paramzzd.zzaRc, paramInt, false);
    zzc.zza(paramParcel, 4, paramzzd.zzaRd, false);
    zzc.zza(paramParcel, 5, paramzzd.zzaRe, false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzd zzds(Parcel paramParcel)
  {
    Integer localInteger1 = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    Integer localInteger2 = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
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
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, k, Scope.CREATOR);
        break;
      case 4: 
        localInteger2 = zzb.zzh(paramParcel, k);
        break;
      case 5: 
        localInteger1 = zzb.zzh(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzd(i, localIBinder, arrayOfScope, localInteger2, localInteger1);
  }
  
  public zzd[] zzfV(int paramInt)
  {
    return new zzd[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */