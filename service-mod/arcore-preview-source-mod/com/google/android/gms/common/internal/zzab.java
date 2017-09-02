package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public class zzab
{
  private static final zzb zzaSy = new zzb()
  {
    public zza zzX(Status paramAnonymousStatus)
    {
      return zzb.zzW(paramAnonymousStatus);
    }
  };
  
  public static <R extends Result, T extends zzf<R>> Task<T> zza(PendingResult<R> paramPendingResult, T paramT)
  {
    zza(paramPendingResult, new zza()
    {
      public T zzf(R paramAnonymousR)
      {
        zzab.this.zzb(paramAnonymousR);
        return zzab.this;
      }
    });
  }
  
  public static <R extends Result, T> Task<T> zza(PendingResult<R> paramPendingResult, zza<R, T> paramzza)
  {
    return zza(paramPendingResult, paramzza, zzaSy);
  }
  
  public static <R extends Result, T> Task<T> zza(PendingResult<R> paramPendingResult, final zza<R, T> paramzza, final zzb paramzzb)
  {
    final TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.zza(new PendingResult.zza()
    {
      public void zzM(Status paramAnonymousStatus)
      {
        if (paramAnonymousStatus.isSuccess())
        {
          paramAnonymousStatus = zzab.this.await(0L, TimeUnit.MILLISECONDS);
          localTaskCompletionSource.setResult(paramzza.zzg(paramAnonymousStatus));
          return;
        }
        localTaskCompletionSource.setException(paramzzb.zzX(paramAnonymousStatus));
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  public static <R extends Result> Task<Void> zzb(PendingResult<R> paramPendingResult)
  {
    zza(paramPendingResult, new zza() {});
  }
  
  public static abstract interface zza<R extends Result, T>
  {
    public abstract T zzg(R paramR);
  }
  
  public static abstract interface zzb
  {
    public abstract zza zzX(Status paramStatus);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */