package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzl
  implements Parcelable.Creator<GestureRequest>
{
  static void zza(GestureRequest paramGestureRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 1, paramGestureRequest.getGestureTypes(), false);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public GestureRequest zzjN(Parcel paramParcel)
  {
    int i = zzb.zzdA(paramParcel);
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 1: 
        localArrayList = zzb.zzD(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new GestureRequest(localArrayList);
  }
  
  public GestureRequest[] zznT(int paramInt)
  {
    return new GestureRequest[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */