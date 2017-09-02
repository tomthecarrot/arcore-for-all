package com.google.android.gms.clearcut.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzj
  implements Parcelable.Creator<PlayLoggerContext>
{
  static void zza(PlayLoggerContext paramPlayLoggerContext, Parcel paramParcel, int paramInt)
  {
    paramInt = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 2, paramPlayLoggerContext.packageName, false);
    zzc.zzc(paramParcel, 3, paramPlayLoggerContext.packageVersionCode);
    zzc.zzc(paramParcel, 4, paramPlayLoggerContext.logSource);
    zzc.zza(paramParcel, 5, paramPlayLoggerContext.uploadAccountName, false);
    zzc.zza(paramParcel, 6, paramPlayLoggerContext.loggingId, false);
    zzc.zza(paramParcel, 7, paramPlayLoggerContext.logAndroidId);
    zzc.zza(paramParcel, 8, paramPlayLoggerContext.logSourceName, false);
    zzc.zza(paramParcel, 9, paramPlayLoggerContext.isAnonymous);
    zzc.zzc(paramParcel, 10, paramPlayLoggerContext.qosTier);
    zzc.zzK(paramParcel, paramInt);
  }
  
  public PlayLoggerContext zzdj(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zzb.zzdA(paramParcel);
    boolean bool2 = true;
    boolean bool1 = false;
    String str2 = null;
    String str3 = null;
    int j = 0;
    int k = 0;
    String str4 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(n))
      {
      default: 
        zzb.zzb(paramParcel, n);
        break;
      case 2: 
        str4 = zzb.zzq(paramParcel, n);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, n);
        break;
      case 4: 
        j = zzb.zzg(paramParcel, n);
        break;
      case 5: 
        str3 = zzb.zzq(paramParcel, n);
        break;
      case 6: 
        str2 = zzb.zzq(paramParcel, n);
        break;
      case 7: 
        bool2 = zzb.zzc(paramParcel, n);
        break;
      case 8: 
        str1 = zzb.zzq(paramParcel, n);
        break;
      case 9: 
        bool1 = zzb.zzc(paramParcel, n);
        break;
      case 10: 
        i = zzb.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zzb.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new PlayLoggerContext(str4, k, j, str3, str2, bool2, str1, bool1, i);
  }
  
  public PlayLoggerContext[] zzfy(int paramInt)
  {
    return new PlayLoggerContext[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */