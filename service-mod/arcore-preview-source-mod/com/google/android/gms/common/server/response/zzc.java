package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<FieldMappingDictionary.Entry>
{
  static void zza(FieldMappingDictionary.Entry paramEntry, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramEntry.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, paramEntry.className, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 3, paramEntry.zzaTV, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, paramInt);
  }
  
  public FieldMappingDictionary.Entry zzdK(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    String str = null;
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
        str = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        localArrayList = zzb.zzc(paramParcel, k, FieldMappingDictionary.FieldMapPair.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new FieldMappingDictionary.Entry(i, str, localArrayList);
  }
  
  public FieldMappingDictionary.Entry[] zzgs(int paramInt)
  {
    return new FieldMappingDictionary.Entry[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */