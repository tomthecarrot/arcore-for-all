package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<Deletion>
{
  static void zza(Deletion paramDeletion, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 2, paramDeletion.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 3, paramDeletion.getStartTimeMs());
    zzc.zza(paramParcel, 4, paramDeletion.getEndTimeMs());
    zzc.zza(paramParcel, 5, paramDeletion.getTimestampMs());
    zzc.zzK(paramParcel, i);
  }
  
  public Deletion zzkD(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = zzb.zzdA(paramParcel);
    Account localAccount = null;
    long l2 = 0L;
    long l3 = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        localAccount = (Account)zzb.zza(paramParcel, j, Account.CREATOR);
        break;
      case 3: 
        l3 = zzb.zzi(paramParcel, j);
        break;
      case 4: 
        l2 = zzb.zzi(paramParcel, j);
        break;
      case 5: 
        l1 = zzb.zzi(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new Deletion(localAccount, l3, l2, l1);
  }
  
  public Deletion[] zzoW(int paramInt)
  {
    return new Deletion[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */