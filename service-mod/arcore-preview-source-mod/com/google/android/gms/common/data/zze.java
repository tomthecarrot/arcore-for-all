package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<DataHolder>
{
  static void zza(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramDataHolder.zzzd(), false);
    zzc.zza(paramParcel, 2, paramDataHolder.zzze(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramDataHolder.getStatusCode());
    zzc.zza(paramParcel, 4, paramDataHolder.zzwW(), false);
    zzc.zzc(paramParcel, 1000, paramDataHolder.mVersionCode);
    zzc.zzK(paramParcel, i);
  }
  
  public DataHolder zzdp(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = zzb.zzdA(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
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
        arrayOfString = zzb.zzC(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])zzb.zzb(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 4: 
        localBundle = zzb.zzs(paramParcel, m);
        break;
      case 1000: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.validateContents();
    return paramParcel;
  }
  
  public DataHolder[] zzfO(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/data/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */