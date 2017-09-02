package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;

public class zzyr
{
  public static abstract class zza<R extends Result, A extends Api.zzb>
    extends zzyt<R>
    implements zzyr.zzb<R>
  {
    private final Api<?> zzaHI;
    private final Api.zzc<A> zzaLC;
    
    @Deprecated
    protected zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzaLC = ((Api.zzc)zzac.zzC(paramzzc));
      this.zzaHI = null;
    }
    
    protected zza(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzaLC = paramApi.zzwS();
      this.zzaHI = paramApi;
    }
    
    private void zze(RemoteException paramRemoteException)
    {
      zzP(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    public final Api<?> getApi()
    {
      return this.zzaHI;
    }
    
    public final void zzP(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "Failed result must not be success");
        zzb(zzb(paramStatus));
        return;
      }
    }
    
    protected abstract void zza(A paramA)
      throws RemoteException;
    
    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zze(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zze(paramA);
      }
    }
    
    public final Api.zzc<A> zzwS()
    {
      return this.zzaLC;
    }
  }
  
  public static abstract interface zzb<R>
  {
    public abstract void setResult(R paramR);
    
    public abstract void zzP(Status paramStatus);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */