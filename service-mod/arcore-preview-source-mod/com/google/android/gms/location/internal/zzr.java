package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzr
  implements Parcelable.Creator<zzq>
{
  static void zza(zzq paramzzq, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramzzq.zzbET);
    zzc.zza(paramParcel, 2, paramzzq.zzbEU, paramInt, false);
    zzc.zza(paramParcel, 3, paramzzq.zzKs(), false);
    zzc.zza(paramParcel, 4, paramzzq.mPendingIntent, paramInt, false);
    zzc.zza(paramParcel, 5, paramzzq.zzKt(), false);
    zzc.zza(paramParcel, 6, paramzzq.zzKu(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public zzq zzkb(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zzb.zzdA(paramParcel);
    int i = 1;
    IBinder localIBinder2 = null;
    PendingIntent localPendingIntent = null;
    IBinder localIBinder3 = null;
    zzo localzzo = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        localzzo = (zzo)zzb.zza(paramParcel, k, zzo.CREATOR);
        break;
      case 3: 
        localIBinder3 = zzb.zzr(paramParcel, k);
        break;
      case 4: 
        localPendingIntent = (PendingIntent)zzb.zza(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 5: 
        localIBinder2 = zzb.zzr(paramParcel, k);
        break;
      case 6: 
        localIBinder1 = zzb.zzr(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new zzq(i, localzzo, localIBinder3, localPendingIntent, localIBinder2, localIBinder1);
  }
  
  public zzq[] zzon(int paramInt)
  {
    return new zzq[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */