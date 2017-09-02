package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzt
  implements Parcelable.Creator<LocationSettingsResult>
{
  static void zza(LocationSettingsResult paramLocationSettingsResult, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramLocationSettingsResult.getStatus(), paramInt, false);
    zzc.zza(paramParcel, 2, paramLocationSettingsResult.getLocationSettingsStates(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public LocationSettingsResult zzjT(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = zzb.zzdA(paramParcel);
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
        localObject3 = (Status)zzb.zza(paramParcel, j, Status.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (LocationSettingsStates)zzb.zza(paramParcel, j, LocationSettingsStates.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new LocationSettingsResult((Status)localObject1, (LocationSettingsStates)localObject2);
  }
  
  public LocationSettingsResult[] zzob(int paramInt)
  {
    return new LocationSettingsResult[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */