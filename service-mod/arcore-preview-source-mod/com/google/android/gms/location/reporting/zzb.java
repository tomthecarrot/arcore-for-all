package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<OptInRequest>
{
  static void zza(OptInRequest paramOptInRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 2, paramOptInRequest.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 3, paramOptInRequest.getTag(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public OptInRequest zzkE(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    Object localObject1 = null;
    if (paramParcel.dataPosition() < i)
    {
      int j = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzgg(j))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, j);
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
        localObject3 = (Account)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, j, Account.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, j);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new OptInRequest((Account)localObject1, (String)localObject2);
  }
  
  public OptInRequest[] zzoX(int paramInt)
  {
    return new OptInRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */