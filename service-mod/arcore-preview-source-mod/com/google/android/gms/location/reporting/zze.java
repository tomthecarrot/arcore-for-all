package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<UploadRequestResult>
{
  static void zza(UploadRequestResult paramUploadRequestResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 2, paramUploadRequestResult.getResultCode());
    zzc.zza(paramParcel, 3, paramUploadRequestResult.getRequestId());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public UploadRequestResult zzkH(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    long l = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 3: 
        l = zzb.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new UploadRequestResult(i, l);
  }
  
  public UploadRequestResult[] zzpa(int paramInt)
  {
    return new UploadRequestResult[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */