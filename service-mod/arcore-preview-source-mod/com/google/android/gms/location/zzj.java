package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.location.internal.zzt;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<GeofencingRequest>
{
  static void zza(GeofencingRequest paramGeofencingRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramGeofencingRequest.zzKi(), false);
    zzc.zzc(paramParcel, 2, paramGeofencingRequest.getInitialTrigger());
    zzc.zza(paramParcel, 3, paramGeofencingRequest.getTag(), false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public GeofencingRequest zzjL(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    String str = "";
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zzb.zzc(paramParcel, k, zzt.CREATOR);
        break;
      case 2: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 3: 
        str = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GeofencingRequest(localArrayList, i, str);
  }
  
  public GeofencingRequest[] zznR(int paramInt)
  {
    return new GeofencingRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */