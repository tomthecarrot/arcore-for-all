package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzd
  implements Parcelable.Creator<UploadRequest>
{
  static void zza(UploadRequest paramUploadRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 2, paramUploadRequest.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 3, paramUploadRequest.getReason(), false);
    zzc.zza(paramParcel, 4, paramUploadRequest.getDurationMillis());
    zzc.zza(paramParcel, 5, paramUploadRequest.getMovingLatencyMillis());
    zzc.zza(paramParcel, 6, paramUploadRequest.getStationaryLatencyMillis());
    zzc.zza(paramParcel, 7, paramUploadRequest.getAppSpecificKey(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public UploadRequest zzkG(Parcel paramParcel)
  {
    long l1 = 0L;
    String str1 = null;
    int i = zzb.zzdA(paramParcel);
    long l2 = 0L;
    long l3 = 0L;
    String str2 = null;
    Account localAccount = null;
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
        str2 = zzb.zzq(paramParcel, j);
        break;
      case 4: 
        l3 = zzb.zzi(paramParcel, j);
        break;
      case 5: 
        l2 = zzb.zzi(paramParcel, j);
        break;
      case 6: 
        l1 = zzb.zzi(paramParcel, j);
        break;
      case 7: 
        str1 = zzb.zzq(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new UploadRequest(localAccount, str2, l3, l2, l1, str1);
  }
  
  public UploadRequest[] zzoZ(int paramInt)
  {
    return new UploadRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */