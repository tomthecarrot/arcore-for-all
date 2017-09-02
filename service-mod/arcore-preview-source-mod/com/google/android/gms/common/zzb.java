package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<ConnectionResult>
{
  static void zza(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramConnectionResult.mVersionCode);
    zzc.zzc(paramParcel, 2, paramConnectionResult.getErrorCode());
    zzc.zza(paramParcel, 3, paramConnectionResult.getResolution(), paramInt, false);
    zzc.zza(paramParcel, 4, paramConnectionResult.getErrorMessage(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public ConnectionResult zzdk(Parcel paramParcel)
  {
    String str = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    PendingIntent localPendingIntent = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzgg(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localPendingIntent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, PendingIntent.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ConnectionResult(i, j, localPendingIntent, str);
  }
  
  public ConnectionResult[] zzfz(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */