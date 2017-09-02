package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzu
  implements Parcelable.Creator<zzt>
{
  static void zza(zzt paramzzt, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramzzt.getRequestId(), false);
    zzc.zza(paramParcel, 2, paramzzt.getExpirationTime());
    zzc.zza(paramParcel, 3, paramzzt.zzKv());
    zzc.zza(paramParcel, 4, paramzzt.getLatitude());
    zzc.zza(paramParcel, 5, paramzzt.getLongitude());
    zzc.zza(paramParcel, 6, paramzzt.getRadius());
    zzc.zzc(paramParcel, 7, paramzzt.getTransitionTypes());
    zzc.zzc(paramParcel, 8, paramzzt.zzKw());
    zzc.zzc(paramParcel, 9, paramzzt.zzKx());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public zzt zzkd(Parcel paramParcel)
  {
    int m = zzb.zzdA(paramParcel);
    String str = null;
    int k = 0;
    short s = 0;
    double d2 = 0.0D;
    double d1 = 0.0D;
    float f = 0.0F;
    long l = 0L;
    int j = 0;
    int i = -1;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 1: 
        str = zzb.zzq(paramParcel, n);
        break;
      case 2: 
        l = zzb.zzi(paramParcel, n);
        break;
      case 3: 
        s = zzb.zzf(paramParcel, n);
        break;
      case 4: 
        d2 = zzb.zzn(paramParcel, n);
        break;
      case 5: 
        d1 = zzb.zzn(paramParcel, n);
        break;
      case 6: 
        f = zzb.zzl(paramParcel, n);
        break;
      case 7: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 8: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 9: 
        i = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new zzt(str, k, s, d2, d1, f, l, j, i);
  }
  
  public zzt[] zzor(int paramInt)
  {
    return new zzt[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */