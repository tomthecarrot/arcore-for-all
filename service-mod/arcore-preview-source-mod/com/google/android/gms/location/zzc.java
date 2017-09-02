package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  static void zza(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 1, paramActivityRecognitionResult.zzbCX, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 2, paramActivityRecognitionResult.zzbCY);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 3, paramActivityRecognitionResult.zzbCZ);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 4, paramActivityRecognitionResult.zzbDa);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramActivityRecognitionResult.extras, false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, paramInt);
  }
  
  public ActivityRecognitionResult zzjG(Parcel paramParcel)
  {
    long l1 = 0L;
    Bundle localBundle = null;
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    long l2 = 0L;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zzb.zzc(paramParcel, k, DetectedActivity.CREATOR);
        break;
      case 2: 
        l2 = zzb.zzi(paramParcel, k);
        break;
      case 3: 
        l1 = zzb.zzi(paramParcel, k);
        break;
      case 4: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 5: 
        localBundle = zzb.zzs(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new ActivityRecognitionResult(localArrayList, l2, l1, i, localBundle);
  }
  
  public ActivityRecognitionResult[] zznJ(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */