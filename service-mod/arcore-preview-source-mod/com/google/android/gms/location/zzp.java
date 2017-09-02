package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzp
  implements Parcelable.Creator<LocationRequest>
{
  static void zza(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramLocationRequest.mPriority);
    zzc.zza(paramParcel, 2, paramLocationRequest.zzbDR);
    zzc.zza(paramParcel, 3, paramLocationRequest.zzbDS);
    zzc.zza(paramParcel, 4, paramLocationRequest.zzbmG);
    zzc.zza(paramParcel, 5, paramLocationRequest.zzbDr);
    zzc.zzc(paramParcel, 6, paramLocationRequest.zzbDT);
    zzc.zza(paramParcel, 7, paramLocationRequest.zzbDU);
    zzc.zza(paramParcel, 8, paramLocationRequest.zzbDV);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public LocationRequest zzjP(Parcel paramParcel)
  {
    int k = zzb.zzdA(paramParcel);
    int j = 102;
    long l4 = 3600000L;
    long l3 = 600000L;
    boolean bool = false;
    long l2 = Long.MAX_VALUE;
    int i = Integer.MAX_VALUE;
    float f = 0.0F;
    long l1 = 0L;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        j = zzb.zzg(paramParcel, m);
        break;
      case 2: 
        l4 = zzb.zzi(paramParcel, m);
        break;
      case 3: 
        l3 = zzb.zzi(paramParcel, m);
        break;
      case 4: 
        bool = zzb.zzc(paramParcel, m);
        break;
      case 5: 
        l2 = zzb.zzi(paramParcel, m);
        break;
      case 6: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 7: 
        f = zzb.zzl(paramParcel, m);
        break;
      case 8: 
        l1 = zzb.zzi(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new LocationRequest(j, l4, l3, bool, l2, i, f, l1);
  }
  
  public LocationRequest[] zznX(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */