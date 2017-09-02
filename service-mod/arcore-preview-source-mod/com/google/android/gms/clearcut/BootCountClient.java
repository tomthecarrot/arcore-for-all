package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.clearcut.internal.zza;
import com.google.android.gms.clearcut.internal.zze.zza;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.internal.zzyr.zza;

public class BootCountClient
  extends zzd<Api.ApiOptions.NoOptions>
{
  public BootCountClient(Context paramContext)
  {
    super(paramContext, BootCount.API, null, new zzym());
  }
  
  public PendingResult<BootCountResult> getBootCount()
  {
    return doRead(new zzb(asGoogleApiClient()));
  }
  
  public static abstract interface BootCountResult
    extends Result
  {
    public abstract int getBootCount();
  }
  
  static class zza
    implements BootCountClient.BootCountResult
  {
    private final int zzaIH;
    private final Status zzaiT;
    
    public zza(Status paramStatus, int paramInt)
    {
      this.zzaiT = paramStatus;
      this.zzaIH = paramInt;
    }
    
    public int getBootCount()
    {
      return this.zzaIH;
    }
    
    public Status getStatus()
    {
      return this.zzaiT;
    }
  }
  
  static final class zzb
    extends zzyr.zza<BootCountClient.BootCountResult, zza>
  {
    zzb(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected BootCountClient.BootCountResult zzH(Status paramStatus)
    {
      return new BootCountClient.zza(paramStatus, -1);
    }
    
    protected void zza(zza paramzza)
      throws RemoteException
    {
      paramzza.zza(new zze.zza()
      {
        public void zza(Status paramAnonymousStatus, int paramAnonymousInt)
        {
          BootCountClient.zzb.this.zzb(new BootCountClient.zza(paramAnonymousStatus, paramAnonymousInt));
        }
      });
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/BootCountClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */