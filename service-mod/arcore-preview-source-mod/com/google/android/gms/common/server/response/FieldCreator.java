package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzabq;

public class FieldCreator
  implements Parcelable.Creator<FastJsonResponse.Field>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void zza(FastJsonResponse.Field paramField, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramField.getVersionCode());
    zzc.zzc(paramParcel, 2, paramField.getTypeIn());
    zzc.zza(paramParcel, 3, paramField.isTypeInArray());
    zzc.zzc(paramParcel, 4, paramField.getTypeOut());
    zzc.zza(paramParcel, 5, paramField.isTypeOutArray());
    zzc.zza(paramParcel, 6, paramField.getOutputFieldName(), false);
    zzc.zzc(paramParcel, 7, paramField.getSafeParcelableFieldId());
    zzc.zza(paramParcel, 8, paramField.zzAo(), false);
    zzc.zza(paramParcel, 9, paramField.zzAp(), paramInt, false);
    zzc.zzK(paramParcel, i);
  }
  
  public FastJsonResponse.Field createFromParcel(Parcel paramParcel)
  {
    zzabq localzzabq = null;
    int i = 0;
    int n = zzb.zzdA(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(i1))
      {
      default: 
        zzb.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zzb.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zzb.zzg(paramParcel, i1);
        break;
      case 3: 
        bool2 = zzb.zzc(paramParcel, i1);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, i1);
        break;
      case 5: 
        bool1 = zzb.zzc(paramParcel, i1);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, i1);
        break;
      case 7: 
        i = zzb.zzg(paramParcel, i1);
        break;
      case 8: 
        str1 = zzb.zzq(paramParcel, i1);
        break;
      case 9: 
        localzzabq = (zzabq)zzb.zza(paramParcel, i1, zzabq.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zzb.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new FastJsonResponse.Field(m, k, bool2, j, bool1, str2, i, str1, localzzabq);
  }
  
  public FastJsonResponse.Field[] newArray(int paramInt)
  {
    return new FastJsonResponse.Field[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/FieldCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */