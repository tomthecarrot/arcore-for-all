package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzabh
  implements zzabg
{
  public PendingResult<Status> zzi(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzabi.zza(paramGoogleApiClient)
    {
      protected void zza(zzabj paramAnonymouszzabj)
        throws RemoteException
      {
        ((zzabl)paramAnonymouszzabj.zzzw()).zza(new zzabh.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzabe
  {
    private final zzyr.zzb<Status> zzaOS;
    
    public zza(zzyr.zzb<Status> paramzzb)
    {
      this.zzaOS = paramzzb;
    }
    
    public void zzgh(int paramInt)
      throws RemoteException
    {
      this.zzaOS.setResult(new Status(paramInt));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */