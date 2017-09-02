package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzaas<A extends Api.zzb, L>
{
  private final zzzw.zzb<L> zzaOB;
  
  protected zzaas(zzzw.zzb<L> paramzzb)
  {
    this.zzaOB = paramzzb;
  }
  
  protected abstract void zzc(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException;
  
  public zzzw.zzb<L> zzyK()
  {
    return this.zzaOB;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */