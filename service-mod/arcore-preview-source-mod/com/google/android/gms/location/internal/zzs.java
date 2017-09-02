package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzs
  implements Parcelable.Creator<NlpTestingRequest>
{
  static void zza(NlpTestingRequest paramNlpTestingRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramNlpTestingRequest.getTriggers());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public NlpTestingRequest zzkc(Parcel paramParcel)
  {
    int i = zzb.zzdA(paramParcel);
    long l = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        l = zzb.zzi(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new NlpTestingRequest(l);
  }
  
  public NlpTestingRequest[] zzoo(int paramInt)
  {
    return new NlpTestingRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */