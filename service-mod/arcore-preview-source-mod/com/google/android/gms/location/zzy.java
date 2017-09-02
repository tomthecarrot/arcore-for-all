package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzy
  implements Parcelable.Creator<WifiScan>
{
  static void zza(WifiScan paramWifiScan, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramWifiScan.getElapsedRealtimeMs());
    zzc.zza(paramParcel, 2, paramWifiScan.zzbEp, false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public WifiScan zzjX(Parcel paramParcel)
  {
    int i = zzb.zzdA(paramParcel);
    long l = 0L;
    long[] arrayOfLong = WifiScan.zzbEn;
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
        break;
      case 2: 
        arrayOfLong = zzb.zzx(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new WifiScan(l, arrayOfLong);
  }
  
  public WifiScan[] zzoi(int paramInt)
  {
    return new WifiScan[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */