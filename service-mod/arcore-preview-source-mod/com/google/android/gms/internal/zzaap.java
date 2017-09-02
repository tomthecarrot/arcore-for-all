package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

public class zzaap
{
  public static void zza(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    zza(paramStatus, null, paramTaskCompletionSource);
  }
  
  public static <TResult> void zza(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramTResult);
      return;
    }
    paramTaskCompletionSource.setException(new zza(paramStatus));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */