package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzp
  implements Parcelable.Creator<zzo>
{
  static void zza(zzo paramzzo, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 1, paramzzo.zzbmE, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 5, paramzzo.zzbDe, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 6, paramzzo.mTag, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 7, paramzzo.zzbER);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, paramzzo.zzbES);
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, i);
  }
  
  public zzo zzka(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int i = zzb.zzdA(paramParcel);
    Object localObject = zzo.zzbEQ;
    boolean bool2 = false;
    LocationRequest localLocationRequest = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        localLocationRequest = (LocationRequest)zzb.zza(paramParcel, j, LocationRequest.CREATOR);
        break;
      case 5: 
        localObject = zzb.zzc(paramParcel, j, zzc.CREATOR);
        break;
      case 6: 
        str = zzb.zzq(paramParcel, j);
        break;
      case 7: 
        bool2 = zzb.zzc(paramParcel, j);
        break;
      case 8: 
        bool1 = zzb.zzc(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzo(localLocationRequest, (List)localObject, str, bool2, bool1);
  }
  
  public zzo[] zzom(int paramInt)
  {
    return new zzo[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */