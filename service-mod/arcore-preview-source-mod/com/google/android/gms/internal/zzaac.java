package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzaac<A extends Api.zzb, L>
{
  private final zzzw<L> zzaOL;
  
  protected zzaac(zzzw<L> paramzzzw)
  {
    this.zzaOL = paramzzzw;
  }
  
  protected abstract void zzb(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException;
  
  public zzzw.zzb<L> zzyK()
  {
    return this.zzaOL.zzyK();
  }
  
  public void zzyL()
  {
    this.zzaOL.clear();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */