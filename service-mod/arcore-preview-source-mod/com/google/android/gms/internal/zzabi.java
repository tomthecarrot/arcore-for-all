package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzabi<R extends Result>
  extends zzyr.zza<R, zzabj>
{
  public zzabi(GoogleApiClient paramGoogleApiClient)
  {
    super(zzabf.API, paramGoogleApiClient);
  }
  
  static abstract class zza
    extends zzabi<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */