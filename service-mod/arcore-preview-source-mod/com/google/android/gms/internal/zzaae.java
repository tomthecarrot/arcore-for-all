package com.google.android.gms.internal;

import android.util.SparseArray;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.internal.zzac;

public class zzaae
  extends ResultStore
{
  private final SparseArray<PendingResult<?>> zzaOM = new SparseArray();
  private final SparseArray<ResultCallbacks<?>> zzaON = new SparseArray();
  private final Object zzrU = new Object();
  
  public boolean hasPendingResult(int paramInt)
  {
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if (this.zzaOM.get(paramInt) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void remove(int paramInt)
  {
    synchronized (this.zzrU)
    {
      PendingResult localPendingResult = (PendingResult)this.zzaOM.get(paramInt);
      if (localPendingResult != null)
      {
        this.zzaOM.remove(paramInt);
        if ((ResultCallback)this.zzaON.get(paramInt) != null) {
          localPendingResult.setResultCallback(null);
        }
      }
      return;
    }
  }
  
  public void setResultCallbacks(int paramInt, ResultCallbacks paramResultCallbacks)
  {
    zzac.zzb(paramResultCallbacks, "ResultCallbacks cannot be null.");
    synchronized (this.zzrU)
    {
      this.zzaON.put(paramInt, paramResultCallbacks);
      PendingResult localPendingResult = (PendingResult)this.zzaOM.get(paramInt);
      if (localPendingResult != null) {
        localPendingResult.setResultCallback(paramResultCallbacks);
      }
      return;
    }
  }
  
  public <R extends Result> void zza(int paramInt, PendingResult<R> paramPendingResult)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if (this.zzaOM.get(paramInt) == null)
        {
          bool1 = true;
          zzac.zzb(bool1, 96 + "ResultStore ResultId must be unique within the current activity. Violating ResultId: " + paramInt);
          if (paramPendingResult.zzxe() != null) {
            break label119;
          }
          bool1 = bool2;
          zzac.zzb(bool1, "PendingResult has already been saved.");
          paramPendingResult.zzfB(paramInt);
          this.zzaOM.put(paramInt, paramPendingResult);
          ResultCallbacks localResultCallbacks = (ResultCallbacks)this.zzaON.get(paramInt);
          if (localResultCallbacks != null) {
            paramPendingResult.setResultCallback(localResultCallbacks);
          }
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label119:
      bool1 = false;
    }
  }
  
  public void zzx(Object paramObject)
  {
    Object localObject = this.zzrU;
    int i = 0;
    try
    {
      while (i < this.zzaOM.size())
      {
        ((PendingResult)this.zzaOM.valueAt(i)).cancel();
        i += 1;
      }
      zzv(paramObject);
      return;
    }
    finally {}
  }
  
  public void zzyM()
  {
    synchronized (this.zzrU)
    {
      this.zzaON.clear();
      int i = 0;
      while (i < this.zzaOM.size())
      {
        ((PendingResult)this.zzaOM.valueAt(i)).setResultCallback(null);
        i += 1;
      }
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */