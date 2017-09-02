package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.TimeUnit;

public abstract class zzaaa<A extends Result, B extends Result>
  extends PendingResult<B>
{
  private final PendingResult<A> zzaOF;
  
  public zzaaa(PendingResult<A> paramPendingResult)
  {
    zzac.zzC(paramPendingResult);
    this.zzaOF = paramPendingResult;
  }
  
  private <T extends Result> ResultTransform<? super A, T> zza(final ResultTransform<? super B, T> paramResultTransform)
  {
    new ResultTransform()
    {
      public Status onFailure(Status paramAnonymousStatus)
      {
        return paramResultTransform.onFailure(paramAnonymousStatus);
      }
      
      public PendingResult<T> onSuccess(A paramAnonymousA)
      {
        return paramResultTransform.onSuccess(zzaaa.this.zze(paramAnonymousA));
      }
    };
  }
  
  public B await()
  {
    return zze(this.zzaOF.await());
  }
  
  public B await(long paramLong, TimeUnit paramTimeUnit)
  {
    return zze(this.zzaOF.await(paramLong, paramTimeUnit));
  }
  
  public void cancel()
  {
    this.zzaOF.cancel();
  }
  
  public boolean isCanceled()
  {
    return this.zzaOF.isCanceled();
  }
  
  public void setResultCallback(final ResultCallback<? super B> paramResultCallback)
  {
    this.zzaOF.setResultCallback(new ResultCallback()
    {
      public void onResult(@NonNull A paramAnonymousA)
      {
        paramResultCallback.onResult(zzaaa.this.zze(paramAnonymousA));
      }
    });
  }
  
  public void setResultCallback(final ResultCallback<? super B> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    this.zzaOF.setResultCallback(new ResultCallback()
    {
      public void onResult(@NonNull A paramAnonymousA)
      {
        paramResultCallback.onResult(zzaaa.this.zze(paramAnonymousA));
      }
    }, paramLong, paramTimeUnit);
  }
  
  public void store(ResultStore paramResultStore, int paramInt)
  {
    this.zzaOF.store(paramResultStore, paramInt);
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super B, ? extends S> paramResultTransform)
  {
    return this.zzaOF.then(zza(paramResultTransform));
  }
  
  public void zza(PendingResult.zza paramzza)
  {
    this.zzaOF.zza(paramzza);
  }
  
  protected abstract B zze(A paramA);
  
  public void zzfB(int paramInt)
  {
    this.zzaOF.zzfB(paramInt);
  }
  
  public Integer zzxe()
  {
    return this.zzaOF.zzxe();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */