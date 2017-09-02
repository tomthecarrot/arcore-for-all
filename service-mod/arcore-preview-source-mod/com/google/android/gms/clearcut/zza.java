package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.clearcut.internal.PlayLoggerContext;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zza
  implements Parcelable.Creator<LogEventParcelable>
{
  static void zza(LogEventParcelable paramLogEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zza(paramParcel, 2, paramLogEventParcelable.playLoggerContext, paramInt, false);
    zzc.zza(paramParcel, 3, paramLogEventParcelable.logEventBytes, false);
    zzc.zza(paramParcel, 4, paramLogEventParcelable.testCodes, false);
    zzc.zza(paramParcel, 5, paramLogEventParcelable.mendelPackages, false);
    zzc.zza(paramParcel, 6, paramLogEventParcelable.experimentIds, false);
    zzc.zza(paramParcel, 7, paramLogEventParcelable.experimentTokens, false);
    zzc.zza(paramParcel, 8, paramLogEventParcelable.addPhenotypeExperimentTokens);
    zzc.zzK(paramParcel, i);
  }
  
  public LogEventParcelable zzdi(Parcel paramParcel)
  {
    byte[][] arrayOfByte = null;
    int i = zzb.zzdA(paramParcel);
    boolean bool = true;
    int[] arrayOfInt1 = null;
    String[] arrayOfString = null;
    int[] arrayOfInt2 = null;
    byte[] arrayOfByte1 = null;
    PlayLoggerContext localPlayLoggerContext = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(j))
      {
      default: 
        zzb.zzb(paramParcel, j);
        break;
      case 2: 
        localPlayLoggerContext = (PlayLoggerContext)zzb.zza(paramParcel, j, PlayLoggerContext.CREATOR);
        break;
      case 3: 
        arrayOfByte1 = zzb.zzt(paramParcel, j);
        break;
      case 4: 
        arrayOfInt2 = zzb.zzw(paramParcel, j);
        break;
      case 5: 
        arrayOfString = zzb.zzC(paramParcel, j);
        break;
      case 6: 
        arrayOfInt1 = zzb.zzw(paramParcel, j);
        break;
      case 7: 
        arrayOfByte = zzb.zzu(paramParcel, j);
        break;
      case 8: 
        bool = zzb.zzc(paramParcel, j);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zzb.zza(37 + "Overread allowed size end=" + i, paramParcel);
    }
    return new LogEventParcelable(localPlayLoggerContext, arrayOfByte1, arrayOfInt2, arrayOfString, arrayOfInt1, arrayOfByte, bool);
  }
  
  public LogEventParcelable[] zzfx(int paramInt)
  {
    return new LogEventParcelable[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */