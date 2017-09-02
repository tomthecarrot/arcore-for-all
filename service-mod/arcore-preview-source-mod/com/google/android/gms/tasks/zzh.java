package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzzs;
import com.google.android.gms.internal.zzzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult>
  extends Task<TResult>
{
  private TResult zzbzJ;
  private final zzg<TResult> zzcEJ = new zzg();
  private boolean zzcEK;
  private Exception zzcEL;
  private final Object zzrU = new Object();
  
  private void zzaaC()
  {
    zzac.zza(this.zzcEK, "Task is not yet complete");
  }
  
  private void zzaaD()
  {
    if (!this.zzcEK) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Task is already complete");
      return;
    }
  }
  
  private void zzaaE()
  {
    synchronized (this.zzrU)
    {
      if (!this.zzcEK) {
        return;
      }
      this.zzcEJ.zza(this);
      return;
    }
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new zzc(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzcEJ.zza(paramOnCompleteListener);
    zza.zzC(paramActivity).zzb(paramOnCompleteListener);
    zzaaE();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzcEJ.zza(new zzc(paramExecutor, paramOnCompleteListener));
    zzaaE();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new zzd(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzcEJ.zza(paramOnFailureListener);
    zza.zzC(paramActivity).zzb(paramOnFailureListener);
    zzaaE();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  @NonNull
  public Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    this.zzcEJ.zza(new zzd(paramExecutor, paramOnFailureListener));
    zzaaE();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new zze(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzcEJ.zza(paramOnSuccessListener);
    zza.zzC(paramActivity).zzb(paramOnSuccessListener);
    zzaaE();
    return this;
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  @NonNull
  public Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzcEJ.zza(new zze(paramExecutor, paramOnSuccessListener));
    zzaaE();
    return this;
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzh localzzh = new zzh();
    this.zzcEJ.zza(new zza(paramExecutor, paramContinuation, localzzh));
    zzaaE();
    return localzzh;
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzh localzzh = new zzh();
    this.zzcEJ.zza(new zzb(paramExecutor, paramContinuation, localzzh));
    zzaaE();
    return localzzh;
  }
  
  @Nullable
  public Exception getException()
  {
    synchronized (this.zzrU)
    {
      Exception localException = this.zzcEL;
      return localException;
    }
  }
  
  public TResult getResult()
  {
    synchronized (this.zzrU)
    {
      zzaaC();
      if (this.zzcEL != null) {
        throw new RuntimeExecutionException(this.zzcEL);
      }
    }
    Object localObject3 = this.zzbzJ;
    return (TResult)localObject3;
  }
  
  public <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass)
    throws Throwable
  {
    synchronized (this.zzrU)
    {
      zzaaC();
      if (paramClass.isInstance(this.zzcEL)) {
        throw ((Throwable)paramClass.cast(this.zzcEL));
      }
    }
    if (this.zzcEL != null) {
      throw new RuntimeExecutionException(this.zzcEL);
    }
    paramClass = this.zzbzJ;
    return paramClass;
  }
  
  public boolean isComplete()
  {
    synchronized (this.zzrU)
    {
      boolean bool = this.zzcEK;
      return bool;
    }
  }
  
  public boolean isSuccessful()
  {
    for (;;)
    {
      synchronized (this.zzrU)
      {
        if ((this.zzcEK) && (this.zzcEL == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void setException(@NonNull Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (this.zzrU)
    {
      zzaaD();
      this.zzcEK = true;
      this.zzcEL = paramException;
      this.zzcEJ.zza(this);
      return;
    }
  }
  
  public void setResult(TResult paramTResult)
  {
    synchronized (this.zzrU)
    {
      zzaaD();
      this.zzcEK = true;
      this.zzbzJ = paramTResult;
      this.zzcEJ.zza(this);
      return;
    }
  }
  
  public boolean trySetException(@NonNull Exception paramException)
  {
    zzac.zzb(paramException, "Exception must not be null");
    synchronized (this.zzrU)
    {
      if (this.zzcEK) {
        return false;
      }
      this.zzcEK = true;
      this.zzcEL = paramException;
      this.zzcEJ.zza(this);
      return true;
    }
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.zzrU)
    {
      if (this.zzcEK) {
        return false;
      }
      this.zzcEK = true;
      this.zzbzJ = paramTResult;
      this.zzcEJ.zza(this);
      return true;
    }
  }
  
  private static class zza
    extends zzzs
  {
    private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();
    
    private zza(zzzt paramzzzt)
    {
      super();
      this.zzaOu.zza("TaskOnStopCallback", this);
    }
    
    public static zza zzC(Activity paramActivity)
    {
      zzzt localzzzt = zzt(paramActivity);
      zza localzza = (zza)localzzzt.zza("TaskOnStopCallback", zza.class);
      paramActivity = localzza;
      if (localzza == null) {
        paramActivity = new zza(localzzzt);
      }
      return paramActivity;
    }
    
    @MainThread
    public void onStop()
    {
      synchronized (this.mListeners)
      {
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          zzf localzzf = (zzf)((WeakReference)localIterator.next()).get();
          if (localzzf != null) {
            localzzf.cancel();
          }
        }
      }
      this.mListeners.clear();
    }
    
    public <T> void zzb(zzf<T> paramzzf)
    {
      synchronized (this.mListeners)
      {
        this.mListeners.add(new WeakReference(paramzzf));
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tasks/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */