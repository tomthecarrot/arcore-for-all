package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult>
{
  private Queue<zzf<TResult>> zzcEF;
  private boolean zzcEG;
  private final Object zzrU = new Object();
  
  public void zza(@NonNull Task<TResult> paramTask)
  {
    for (;;)
    {
      zzf localzzf;
      synchronized (this.zzrU)
      {
        if ((this.zzcEF == null) || (this.zzcEG)) {
          return;
        }
        this.zzcEG = true;
        synchronized (this.zzrU)
        {
          localzzf = (zzf)this.zzcEF.poll();
          if (localzzf == null)
          {
            this.zzcEG = false;
            return;
          }
        }
      }
      localzzf.onComplete(paramTask);
    }
  }
  
  public void zza(@NonNull zzf<TResult> paramzzf)
  {
    synchronized (this.zzrU)
    {
      if (this.zzcEF == null) {
        this.zzcEF = new ArrayDeque();
      }
      this.zzcEF.add(paramzzf);
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tasks/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */