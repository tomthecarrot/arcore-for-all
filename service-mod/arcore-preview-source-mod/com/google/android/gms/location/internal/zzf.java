package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzf
  extends zza
  implements Result
{
  public static final Parcelable.Creator<zzf> CREATOR = new zzg();
  public static final zzf zzbEG = new zzf(Status.zzaLc);
  private final Status zzaiT;
  
  public zzf(Status paramStatus)
  {
    this.zzaiT = paramStatus;
  }
  
  public Status getStatus()
  {
    return this.zzaiT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */