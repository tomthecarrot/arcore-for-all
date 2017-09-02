package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzx
  implements Parcelable.Creator<SleepSegmentEvent>
{
  static void zza(SleepSegmentEvent paramSleepSegmentEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramSleepSegmentEvent.getStartTimeMillis());
    zzc.zza(paramParcel, 2, paramSleepSegmentEvent.getEndTimeMillis());
    zzc.zzc(paramParcel, 3, paramSleepSegmentEvent.getStatus());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public SleepSegmentEvent zzjW(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    long l2 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        l2 = zzb.zzi(paramParcel, k);
        break;
      case 2: 
        l1 = zzb.zzi(paramParcel, k);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new SleepSegmentEvent(l2, l1, i);
  }
  
  public SleepSegmentEvent[] zzog(int paramInt)
  {
    return new SleepSegmentEvent[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */