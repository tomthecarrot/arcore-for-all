package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzbgi
  implements Parcelable.Creator<zzbgh>
{
  static void zza(zzbgh paramzzbgh, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbgh.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzbgh.zzcqJ);
    zzc.zzc(paramParcel, 3, paramzzbgh.zzcqK, false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public zzbgh zzqy(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zzb.zzdA(paramParcel);
    ArrayList localArrayList = null;
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
        bool = zzb.zzc(paramParcel, k);
        break;
      case 3: 
        localArrayList = zzb.zzc(paramParcel, k, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbgh(i, bool, localArrayList);
  }
  
  public zzbgh[] zzvF(int paramInt)
  {
    return new zzbgh[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */