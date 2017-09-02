package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzk
  implements Parcelable.Creator<zzj>
{
  static void zza(zzj paramzzj, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramzzj.version);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 2, paramzzj.zzaRN);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 3, paramzzj.zzaRO);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramzzj.zzaRP, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramzzj.zzaRQ, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, paramzzj.zzaRR, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, paramzzj.zzaRS, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, paramzzj.zzaRT, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 10, paramzzj.zzaRU, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, i);
  }
  
  public zzj zzdu(Parcel paramParcel)
  {
    int i = 0;
    com.google.android.gms.common.zzc[] arrayOfzzc = null;
    int m = zzb.zzdA(paramParcel);
    Account localAccount = null;
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(n))
      {
      case 9: 
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 2: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        str = zzb.zzq(paramParcel, n);
        break;
      case 5: 
        localIBinder = zzb.zzr(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])zzb.zzb(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = zzb.zzs(paramParcel, n);
        break;
      case 8: 
        localAccount = (Account)zzb.zza(paramParcel, n, Account.CREATOR);
        break;
      case 10: 
        arrayOfzzc = (com.google.android.gms.common.zzc[])zzb.zzb(paramParcel, n, com.google.android.gms.common.zzc.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzj(k, j, i, str, localIBinder, arrayOfScope, localBundle, localAccount, arrayOfzzc);
  }
  
  public zzj[] zzfY(int paramInt)
  {
    return new zzj[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */