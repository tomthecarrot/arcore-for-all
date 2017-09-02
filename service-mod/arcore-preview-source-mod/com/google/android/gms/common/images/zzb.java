package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb
  implements Parcelable.Creator<WebImage>
{
  static void zza(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramWebImage.mVersionCode);
    zzc.zza(paramParcel, 2, paramWebImage.getUrl(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramWebImage.getWidth());
    zzc.zzc(paramParcel, 4, paramWebImage.getHeight());
    zzc.zzK(paramParcel, i);
  }
  
  public WebImage zzdr(Parcel paramParcel)
  {
    int i = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    Uri localUri = null;
    int j = 0;
    int k = 0;
    if (paramParcel.dataPosition() < m)
    {
      int n = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzgg(n))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, n);
      }
      for (;;)
      {
        break;
        k = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
        continue;
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, n, Uri.CREATOR);
        continue;
        j = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
        continue;
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new WebImage(k, localUri, j, i);
  }
  
  public WebImage[] zzfT(int paramInt)
  {
    return new WebImage[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/images/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */