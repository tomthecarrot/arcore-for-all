package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzbgm
  implements Parcelable.Creator<zzbgl>
{
  static void zza(zzbgl paramzzbgl, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzbgl.mVersionCode);
    zzc.zza(paramParcel, 2, paramzzbgl.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 3, paramzzbgl.zzWf(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzzbgl.getServerClientId(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzbgl zzqz(Parcel paramParcel)
  {
    String str = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      Object localObject3;
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zzb.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Account)zzb.zza(paramParcel, k, Account.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Scope[])zzb.zzb(paramParcel, k, Scope.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        str = zzb.zzq(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzbgl(i, (Account)localObject1, (Scope[])localObject2, str);
  }
  
  public zzbgl[] zzvH(int paramInt)
  {
    return new zzbgl[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */