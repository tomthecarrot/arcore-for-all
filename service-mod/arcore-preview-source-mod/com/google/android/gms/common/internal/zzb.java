package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zze;

public class zzb
{
  @NonNull
  public static zza zzW(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new zze(paramStatus);
    }
    return new zza(paramStatus);
  }
  
  @NonNull
  public static zza zzl(@NonNull ConnectionResult paramConnectionResult)
  {
    return zzW(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */