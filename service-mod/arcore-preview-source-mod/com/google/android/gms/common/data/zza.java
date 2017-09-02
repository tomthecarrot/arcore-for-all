package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<BitmapTeleporter>
{
  static void zza(BitmapTeleporter paramBitmapTeleporter, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramBitmapTeleporter.mVersionCode);
    zzc.zza(paramParcel, 2, paramBitmapTeleporter.zzSC, paramInt, false);
    zzc.zzc(paramParcel, 3, paramBitmapTeleporter.zzahZ);
    zzc.zzK(paramParcel, i);
  }
  
  public BitmapTeleporter zzdo(Parcel paramParcel)
  {
    int i = 0;
    int k = zzb.zzdA(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = zzb.zzg(paramParcel, m);
        continue;
        localParcelFileDescriptor = (ParcelFileDescriptor)zzb.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        continue;
        i = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new BitmapTeleporter(j, localParcelFileDescriptor, i);
  }
  
  public BitmapTeleporter[] zzfK(int paramInt)
  {
    return new BitmapTeleporter[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/data/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */