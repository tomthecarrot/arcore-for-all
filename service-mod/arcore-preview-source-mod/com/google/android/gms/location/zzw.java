package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzw
  implements Parcelable.Creator<zzv>
{
  static void zza(zzv paramzzv, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzb(paramParcel, 1, paramzzv.zzKm(), false);
    zzc.zza(paramParcel, 2, paramzzv.getPendingIntent(), paramInt, false);
    zzc.zza(paramParcel, 3, paramzzv.getTag(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzv zzjV(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = zzb.zzdA(paramParcel);
    String str = "";
    Object localObject1 = null;
    if (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      Object localObject3;
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = zzb.zzF(paramParcel, j);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (PendingIntent)zzb.zza(paramParcel, j, PendingIntent.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        str = zzb.zzq(paramParcel, j);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zzv((List)localObject1, (PendingIntent)localObject2, str);
  }
  
  public zzv[] zzof(int paramInt)
  {
    return new zzv[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */