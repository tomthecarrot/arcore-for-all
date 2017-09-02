package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;

public class zzc
  implements Parcelable.Creator<ReportingState>
{
  static void zza(ReportingState paramReportingState, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 2, paramReportingState.getReportingEnabled());
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 3, paramReportingState.getHistoryEnabled());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 4, paramReportingState.isAllowed());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 5, paramReportingState.isActive());
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 7, paramReportingState.getExpectedOptInResult());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 8, paramReportingState.zzLa(), false);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(paramParcel, 9, paramReportingState.zzKZ());
    com.google.android.gms.common.internal.safeparcel.zzc.zza(paramParcel, 10, paramReportingState.canAccessSettings());
    com.google.android.gms.common.internal.safeparcel.zzc.zzK(paramParcel, paramInt);
  }
  
  public ReportingState zzkF(Parcel paramParcel)
  {
    boolean bool1 = false;
    int n = zzb.zzdA(paramParcel);
    Integer localInteger = null;
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(i1))
      {
      case 6: 
      default: 
        zzb.zzb(paramParcel, i1);
        break;
      case 2: 
        m = zzb.zzg(paramParcel, i1);
        break;
      case 3: 
        k = zzb.zzg(paramParcel, i1);
        break;
      case 4: 
        bool3 = zzb.zzc(paramParcel, i1);
        break;
      case 5: 
        bool2 = zzb.zzc(paramParcel, i1);
        break;
      case 7: 
        j = zzb.zzg(paramParcel, i1);
        break;
      case 8: 
        localInteger = zzb.zzh(paramParcel, i1);
        break;
      case 9: 
        i = zzb.zzg(paramParcel, i1);
        break;
      case 10: 
        bool1 = zzb.zzc(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zzb.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new ReportingState(m, k, bool3, bool2, j, i, localInteger, bool1);
  }
  
  public ReportingState[] zzoY(int paramInt)
  {
    return new ReportingState[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */