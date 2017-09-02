package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzk
  implements Parcelable.Creator<GestureEvent>
{
  static void zza(GestureEvent paramGestureEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramGestureEvent.getType());
    zzc.zza(paramParcel, 2, paramGestureEvent.getTimeMillis());
    zzc.zza(paramParcel, 3, paramGestureEvent.getElapsedRealtimeMillis());
    zzc.zzc(paramParcel, 4, paramGestureEvent.getCount());
    zzc.zza(paramParcel, 5, paramGestureEvent.isStart());
    zzc.zza(paramParcel, 6, paramGestureEvent.isEnd());
    zzc.zzK(paramParcel, paramInt);
  }
  
  public GestureEvent zzjM(Parcel paramParcel)
  {
    long l1 = 0L;
    boolean bool1 = false;
    int k = zzb.zzdA(paramParcel);
    boolean bool2 = false;
    int i = 0;
    long l2 = 0L;
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
        l2 = zzb.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zzb.zzi(paramParcel, m);
        break;
      case 4: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 5: 
        bool2 = zzb.zzc(paramParcel, m);
        break;
      case 6: 
        bool1 = zzb.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GestureEvent(j, l2, l1, i, bool2, bool1);
  }
  
  public GestureEvent[] zznS(int paramInt)
  {
    return new GestureEvent[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */