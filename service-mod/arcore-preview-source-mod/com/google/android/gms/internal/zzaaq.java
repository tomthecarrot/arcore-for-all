package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class zzaaq<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final WeakReference<GoogleApiClient> zzaAq;
  private final Object zzaLL = new Object();
  private ResultTransform<? super R, ? extends Result> zzaOU = null;
  private zzaaq<? extends Result> zzaOV = null;
  private volatile ResultCallbacks<? super R> zzaOW = null;
  private PendingResult<R> zzaOX = null;
  private Status zzaOY = null;
  private final zza zzaOZ;
  private boolean zzaPa = false;
  
  public zzaaq(WeakReference<GoogleApiClient> paramWeakReference)
  {
    zzac.zzb(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zzaAq = paramWeakReference;
    paramWeakReference = (GoogleApiClient)this.zzaAq.get();
    if (paramWeakReference != null) {}
    for (paramWeakReference = paramWeakReference.getLooper();; paramWeakReference = Looper.getMainLooper())
    {
      this.zzaOZ = new zza(paramWeakReference);
      return;
    }
  }
  
  private void zzS(Status paramStatus)
  {
    synchronized (this.zzaLL)
    {
      this.zzaOY = paramStatus;
      zzT(this.zzaOY);
      return;
    }
  }
  
  private void zzT(Status paramStatus)
  {
    synchronized (this.zzaLL)
    {
      if (this.zzaOU != null)
      {
        paramStatus = this.zzaOU.onFailure(paramStatus);
        zzac.zzb(paramStatus, "onFailure must not return null");
        this.zzaOV.zzS(paramStatus);
      }
      while (!zzyR()) {
        return;
      }
      this.zzaOW.onFailure(paramStatus);
    }
  }
  
  private void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResult = String.valueOf(paramResult);
      Log.w("TransformedResultImpl", String.valueOf(paramResult).length() + 18 + "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  private void zzyP()
  {
    if ((this.zzaOU == null) && (this.zzaOW == null)) {}
    do
    {
      return;
      GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzaAq.get();
      if ((!this.zzaPa) && (this.zzaOU != null) && (localGoogleApiClient != null))
      {
        localGoogleApiClient.zza(this);
        this.zzaPa = true;
      }
      if (this.zzaOY != null)
      {
        zzT(this.zzaOY);
        return;
      }
    } while (this.zzaOX == null);
    this.zzaOX.setResultCallback(this);
  }
  
  private boolean zzyR()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzaAq.get();
    return (this.zzaOW != null) && (localGoogleApiClient != null);
  }
  
  public void andFinally(@NonNull ResultCallbacks<? super R> paramResultCallbacks)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if (this.zzaOW == null)
        {
          bool1 = true;
          zzac.zza(bool1, "Cannot call andFinally() twice.");
          if (this.zzaOU != null) {
            break label65;
          }
          bool1 = bool2;
          zzac.zza(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zzaOW = paramResultCallbacks;
          zzyP();
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label65:
      bool1 = false;
    }
  }
  
  public void onResult(final R paramR)
  {
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if (paramR.getStatus().isSuccess())
        {
          if (this.zzaOU != null)
          {
            zzaaf.zzyh().submit(new Runnable()
            {
              @WorkerThread
              public void run()
              {
                try
                {
                  zzyt.zzaLK.set(Boolean.valueOf(true));
                  Object localObject1 = zzaaq.zzc(zzaaq.this).onSuccess(paramR);
                  zzaaq.zzd(zzaaq.this).sendMessage(zzaaq.zzd(zzaaq.this).obtainMessage(0, localObject1));
                  zzyt.zzaLK.set(Boolean.valueOf(false));
                  zzaaq.zza(zzaaq.this, paramR);
                  localObject1 = (GoogleApiClient)zzaaq.zze(zzaaq.this).get();
                  if (localObject1 != null) {
                    ((GoogleApiClient)localObject1).zzb(zzaaq.this);
                  }
                  return;
                }
                catch (RuntimeException localRuntimeException)
                {
                  zzaaq.zzd(zzaaq.this).sendMessage(zzaaq.zzd(zzaaq.this).obtainMessage(1, localRuntimeException));
                  GoogleApiClient localGoogleApiClient1;
                  return;
                }
                finally
                {
                  zzyt.zzaLK.set(Boolean.valueOf(false));
                  zzaaq.zza(zzaaq.this, paramR);
                  GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzaaq.zze(zzaaq.this).get();
                  if (localGoogleApiClient2 != null) {
                    localGoogleApiClient2.zzb(zzaaq.this);
                  }
                }
              }
            });
            return;
          }
          if (!zzyR()) {
            continue;
          }
          this.zzaOW.onSuccess(paramR);
        }
      }
      zzS(paramR.getStatus());
      zzd(paramR);
    }
  }
  
  @NonNull
  public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if (this.zzaOU == null)
        {
          bool1 = true;
          zzac.zza(bool1, "Cannot call then() twice.");
          if (this.zzaOW != null) {
            break label83;
          }
          bool1 = bool2;
          zzac.zza(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zzaOU = paramResultTransform;
          paramResultTransform = new zzaaq(this.zzaAq);
          this.zzaOV = paramResultTransform;
          zzyP();
          return paramResultTransform;
        }
      }
      boolean bool1 = false;
      continue;
      label83:
      bool1 = false;
    }
  }
  
  public void zza(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zzaLL)
    {
      this.zzaOX = paramPendingResult;
      zzyP();
      return;
    }
  }
  
  void zzyQ()
  {
    this.zzaOW = null;
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.e("TransformedResultImpl", 70 + "TransformationResultHandler received unknown message type: " + i);
        return;
      case 0: 
        PendingResult localPendingResult1 = (PendingResult)paramMessage.obj;
        paramMessage = zzaaq.zzf(zzaaq.this);
        if (localPendingResult1 == null) {}
        for (;;)
        {
          try
          {
            zzaaq.zza(zzaaq.zzg(zzaaq.this), new Status(13, "Transform returned null"));
            return;
          }
          finally {}
          if ((localPendingResult2 instanceof zzaag)) {
            zzaaq.zza(zzaaq.zzg(zzaaq.this), ((zzaag)localPendingResult2).getStatus());
          } else {
            zzaaq.zzg(zzaaq.this).zza(localPendingResult2);
          }
        }
      }
      RuntimeException localRuntimeException = (RuntimeException)paramMessage.obj;
      paramMessage = String.valueOf(localRuntimeException.getMessage());
      if (paramMessage.length() != 0) {}
      for (paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);; paramMessage = new String("Runtime exception on the transformation worker thread: "))
      {
        Log.e("TransformedResultImpl", paramMessage);
        throw localRuntimeException;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */