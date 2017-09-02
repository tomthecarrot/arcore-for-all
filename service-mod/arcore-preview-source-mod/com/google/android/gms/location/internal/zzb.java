package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;

public class zzb
  extends zzl<zzk>
{
  private final String zzbEv;
  protected final zzv<zzk> zzbEw = new zzv()
  {
    public zzk zzKn()
      throws DeadObjectException
    {
      return (zzk)zzb.this.zzzw();
    }
    
    public void zzzv()
    {
      zzb.zza(zzb.this);
    }
  };
  
  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzg paramzzg)
  {
    super(paramContext, paramLooper, 23, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzbEv = paramString;
  }
  
  protected String zzeJ()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String zzeK()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected zzk zzft(IBinder paramIBinder)
  {
    return zzk.zza.zzfw(paramIBinder);
  }
  
  protected Bundle zzql()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.zzbEv);
    return localBundle;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */