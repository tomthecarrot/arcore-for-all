package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzyt<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zzaLK = new ThreadLocal()
  {
    protected Boolean zzxv()
    {
      return Boolean.valueOf(false);
    }
  };
  private boolean zzJ;
  protected final WeakReference<GoogleApiClient> zzaAq;
  private R zzaKY;
  private final Object zzaLL = new Object();
  protected final zza<R> zzaLM;
  private final ArrayList<PendingResult.zza> zzaLN = new ArrayList();
  private ResultCallback<? super R> zzaLO;
  private final AtomicReference<zzaar.zzb> zzaLP = new AtomicReference();
  private zzb zzaLQ;
  private volatile boolean zzaLR;
  private boolean zzaLS;
  private zzs zzaLT;
  private Integer zzaLU;
  private volatile zzaaq<R> zzaLV;
  private boolean zzaLW = false;
  private Status zzaiT;
  private final CountDownLatch zztC = new CountDownLatch(1);
  
  @Deprecated
  zzyt()
  {
    this.zzaLM = new zza(Looper.getMainLooper());
    this.zzaAq = new WeakReference(null);
  }
  
  @Deprecated
  protected zzyt(Looper paramLooper)
  {
    this.zzaLM = new zza(paramLooper);
    this.zzaAq = new WeakReference(null);
  }
  
  protected zzyt(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      this.zzaLM = new zza(localLooper);
      this.zzaAq = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (this.zzaLL)
    {
      if (!this.zzaLR)
      {
        zzac.zza(bool, "Result has already been consumed.");
        zzac.zza(isReady(), "Result is not ready.");
        Result localResult = this.zzaKY;
        this.zzaKY = null;
        this.zzaLO = null;
        this.zzaLR = true;
        zzxs();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzc(R paramR)
  {
    this.zzaKY = paramR;
    this.zzaLT = null;
    this.zztC.countDown();
    this.zzaiT = this.zzaKY.getStatus();
    if (this.zzJ) {
      this.zzaLO = null;
    }
    for (;;)
    {
      paramR = this.zzaLN.iterator();
      while (paramR.hasNext()) {
        ((PendingResult.zza)paramR.next()).zzM(this.zzaiT);
      }
      if (this.zzaLO == null)
      {
        if ((this.zzaKY instanceof Releasable)) {
          this.zzaLQ = new zzb(null);
        }
      }
      else
      {
        this.zzaLM.zzxw();
        this.zzaLM.zza(this.zzaLO, get());
      }
    }
    this.zzaLN.clear();
  }
  
  public static void zzd(Result paramResult)
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
      Log.w("BasePendingResult", String.valueOf(paramResult).length() + 18 + "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  private void zzxs()
  {
    zzaar.zzb localzzb = (zzaar.zzb)this.zzaLP.getAndSet(null);
    if (localzzb != null) {
      localzzb.zzc(this);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread");
      if (!this.zzaLR)
      {
        bool1 = true;
        label28:
        zzac.zza(bool1, "Result has already been consumed");
        if (this.zzaLV != null) {
          break label80;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        this.zztC.await();
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzQ(Status.zzaLd);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.zzaLR)
      {
        bool1 = true;
        label39:
        zzac.zza(bool1, "Result has already been consumed.");
        if (this.zzaLV != null) {
          break label109;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.zztC.await(paramLong, paramTimeUnit)) {
          zzQ(Status.zzaLf);
        }
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label39;
        label109:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzQ(Status.zzaLd);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (this.zzaLL)
    {
      if ((this.zzJ) || (this.zzaLR)) {
        return;
      }
      zzs localzzs = this.zzaLT;
      if (localzzs == null) {}
    }
    try
    {
      this.zzaLT.cancel();
      zzd(this.zzaKY);
      this.zzJ = true;
      zzc(zzb(Status.zzaLg));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (this.zzaLL)
    {
      boolean bool = this.zzJ;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.zztC.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    Object localObject = this.zzaLL;
    if (paramResultCallback == null) {}
    try
    {
      this.zzaLO = null;
      return;
    }
    finally {}
    if (!this.zzaLR)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (this.zzaLV != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (isReady()) {
      this.zzaLM.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzaLO = paramResultCallback;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    Object localObject = this.zzaLL;
    if (paramResultCallback == null) {}
    try
    {
      this.zzaLO = null;
      return;
    }
    finally {}
    if (!this.zzaLR)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (this.zzaLV != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label90;
      }
      return;
      bool1 = false;
      break;
    }
    label90:
    if (isReady()) {
      this.zzaLM.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzaLO = paramResultCallback;
      this.zzaLM.zza(this, paramTimeUnit.toMillis(paramLong));
    }
  }
  
  public void store(ResultStore paramResultStore, int paramInt)
  {
    zzac.zzb(paramResultStore, "ResultStore must not be null.");
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if (!this.zzaLR)
        {
          bool = true;
          zzac.zza(bool, "Result has already been consumed.");
          paramResultStore.zza(paramInt, this);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.zzaLR)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if (this.zzaLV != null) {
          break label152;
        }
        bool1 = true;
        zzac.zza(bool1, "Cannot call then() twice.");
        if (this.zzaLO != null) {
          break label157;
        }
        bool1 = true;
        zzac.zza(bool1, "Cannot call then() if callbacks are set.");
        if (this.zzJ) {
          break label162;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot call then() if result was canceled.");
        this.zzaLW = true;
        this.zzaLV = new zzaaq(this.zzaAq);
        paramResultTransform = this.zzaLV.then(paramResultTransform);
        if (isReady())
        {
          this.zzaLM.zza(this.zzaLV, get());
          return paramResultTransform;
        }
        this.zzaLO = this.zzaLV;
      }
      bool1 = false;
      break;
      label152:
      bool1 = false;
      continue;
      label157:
      bool1 = false;
      continue;
      label162:
      bool1 = false;
    }
  }
  
  public final void zzQ(Status paramStatus)
  {
    synchronized (this.zzaLL)
    {
      if (!isReady())
      {
        zzb(zzb(paramStatus));
        this.zzaLS = true;
      }
      return;
    }
  }
  
  public final void zza(PendingResult.zza paramzza)
  {
    if (paramzza != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Callback cannot be null.");
      synchronized (this.zzaLL)
      {
        if (isReady())
        {
          paramzza.zzM(this.zzaiT);
          return;
        }
        this.zzaLN.add(paramzza);
      }
    }
  }
  
  protected final void zza(zzs paramzzs)
  {
    synchronized (this.zzaLL)
    {
      this.zzaLT = paramzzs;
      return;
    }
  }
  
  public void zza(zzaar.zzb paramzzb)
  {
    this.zzaLP.set(paramzzb);
  }
  
  @NonNull
  protected abstract R zzb(Status paramStatus);
  
  public final void zzb(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaLL)
      {
        if ((!this.zzaLS) && (!this.zzJ))
        {
          if ((!isReady()) || (!isReady()))
          {
            bool1 = true;
            zzac.zza(bool1, "Results have already been set");
            if (this.zzaLR) {
              break label91;
            }
            bool1 = bool2;
            zzac.zza(bool1, "Result has already been consumed");
            zzc(paramR);
          }
        }
        else
        {
          zzd(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label91:
      bool1 = false;
    }
  }
  
  public void zzfB(int paramInt)
  {
    if (this.zzaLU == null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "PendingResult should only be stored once.");
      this.zzaLU = Integer.valueOf(paramInt);
      return;
    }
  }
  
  public Integer zzxe()
  {
    return this.zzaLU;
  }
  
  public boolean zzxr()
  {
    synchronized (this.zzaLL)
    {
      if (((GoogleApiClient)this.zzaAq.get() == null) || (!this.zzaLW)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public void zzxt()
  {
    setResultCallback(null);
  }
  
  public void zzxu()
  {
    if ((this.zzaLW) || (((Boolean)zzaLK.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaLW = bool;
      return;
    }
  }
  
  public static class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
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
        Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
        return;
      case 1: 
        paramMessage = (Pair)paramMessage.obj;
        zzb((ResultCallback)paramMessage.first, (Result)paramMessage.second);
        return;
      }
      ((zzyt)paramMessage.obj).zzQ(Status.zzaLf);
    }
    
    public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void zza(zzyt<R> paramzzyt, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramzzyt), paramLong);
    }
    
    protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        zzyt.zzd(paramR);
        throw paramResultCallback;
      }
    }
    
    public void zzxw()
    {
      removeMessages(2);
    }
  }
  
  private final class zzb
  {
    private zzb() {}
    
    protected void finalize()
      throws Throwable
    {
      zzyt.zzd(zzyt.zza(zzyt.this));
      super.finalize();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */