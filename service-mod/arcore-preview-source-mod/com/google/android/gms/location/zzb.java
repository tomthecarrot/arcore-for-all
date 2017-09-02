package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<zza>
{
  static void zza(zza paramzza, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramzza.getIntervalMillis());
    zzc.zza(paramParcel, 2, paramzza.zzKa());
    zzc.zza(paramParcel, 3, paramzza.zzKb(), paramInt, false);
    zzc.zza(paramParcel, 4, paramzza.getTag(), false);
    zzc.zza(paramParcel, 5, paramzza.zzKc(), false);
    zzc.zza(paramParcel, 6, paramzza.zzKd());
    zzc.zza(paramParcel, 7, paramzza.getAccountName(), false);
    zzc.zza(paramParcel, 8, paramzza.zzKe());
    zzc.zzK(paramParcel, i);
  }
  
  public zza zzjF(Parcel paramParcel)
  {
    long l1 = 0L;
    boolean bool1 = false;
    String str1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    int[] arrayOfInt = null;
    String str2 = null;
    WorkSource localWorkSource = null;
    boolean bool2 = false;
    long l2 = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int j = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzgg(j))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, j);
        break;
      case 1: 
        l2 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, j);
        break;
      case 2: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, j);
        break;
      case 3: 
        localWorkSource = (WorkSource)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, j, WorkSource.CREATOR);
        break;
      case 4: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, j);
        break;
      case 5: 
        arrayOfInt = com.google.android.gms.common.internal.safeparcel.zzb.zzw(paramParcel, j);
        break;
      case 6: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, j);
        break;
      case 7: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, j);
        break;
      case 8: 
        l1 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new zza(l2, bool2, localWorkSource, str2, arrayOfInt, bool1, str1, l1);
  }
  
  public zza[] zznI(int paramInt)
  {
    return new zza[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */