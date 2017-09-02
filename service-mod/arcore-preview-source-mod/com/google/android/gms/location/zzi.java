package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzi
  implements Parcelable.Creator<FloorChangeEvent>
{
  static void zza(FloorChangeEvent paramFloorChangeEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramFloorChangeEvent.getType());
    zzc.zzc(paramParcel, 2, paramFloorChangeEvent.getConfidence());
    zzc.zza(paramParcel, 3, paramFloorChangeEvent.getStartTimeMillis());
    zzc.zza(paramParcel, 4, paramFloorChangeEvent.getEndTimeMillis());
    zzc.zza(paramParcel, 5, paramFloorChangeEvent.getStartElapsedRealtimeMillis());
    zzc.zza(paramParcel, 6, paramFloorChangeEvent.getEndElapsedRealtimeMillis());
    zzc.zza(paramParcel, 7, paramFloorChangeEvent.getElevationChange());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public FloorChangeEvent zzjK(Parcel paramParcel)
  {
    int i = 0;
    long l1 = 0L;
    int k = zzb.zzdA(paramParcel);
    float f = 0.0F;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    int j = 0;
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
        i = zzb.zzg(paramParcel, m);
        break;
      case 3: 
        l4 = zzb.zzi(paramParcel, m);
        break;
      case 4: 
        l3 = zzb.zzi(paramParcel, m);
        break;
      case 5: 
        l2 = zzb.zzi(paramParcel, m);
        break;
      case 6: 
        l1 = zzb.zzi(paramParcel, m);
        break;
      case 7: 
        f = zzb.zzl(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new FloorChangeEvent(j, i, l4, l3, l2, l1, f);
  }
  
  public FloorChangeEvent[] zznP(int paramInt)
  {
    return new FloorChangeEvent[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */