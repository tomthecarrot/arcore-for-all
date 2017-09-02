package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaac;
import com.google.android.gms.internal.zzaai;
import com.google.android.gms.internal.zzaak;
import com.google.android.gms.internal.zzaao;
import com.google.android.gms.internal.zzaas;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.internal.zzyn;
import com.google.android.gms.internal.zzyr.zza;
import com.google.android.gms.internal.zzza;
import com.google.android.gms.internal.zzzl;
import com.google.android.gms.internal.zzzl.zza;
import com.google.android.gms.internal.zzzm;
import com.google.android.gms.internal.zzzw;
import com.google.android.gms.internal.zzzw.zzb;
import com.google.android.gms.internal.zzzx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzd<O extends Api.ApiOptions>
{
  private final Context mContext;
  private final int mId;
  private final Api<O> zzaHI;
  private final GoogleApiClient zzaKA;
  private final zzaak zzaKB;
  protected final zzzl zzaKC;
  private final O zzaKy;
  private final zzyn<O> zzaKz;
  private final Account zzagc;
  private final Looper zzrD;
  
  @Deprecated
  @MainThread
  public zzd(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, Looper paramLooper, zzaak paramzzaak)
  {
    this(paramActivity, paramApi, paramO, new zzd.zza.zza().zzb(paramLooper).zza(paramzzaak).zzwX());
  }
  
  @MainThread
  public zzd(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, zza paramzza)
  {
    zzac.zzb(paramActivity, "Null activity is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramzza, "Settings must not be null; use Settings.createDefault() instead.");
    this.mContext = paramActivity.getApplicationContext();
    this.zzaHI = paramApi;
    this.zzaKy = paramO;
    this.zzrD = paramzza.zzaKF;
    this.zzaKz = zzyn.zza(this.zzaHI, this.zzaKy);
    this.zzaKA = new zzzm(this);
    this.zzaKC = zzzl.zzaV(this.mContext);
    this.mId = this.zzaKC.zzyl();
    this.zzaKB = paramzza.zzaKE;
    this.zzagc = paramzza.account;
    zzza.zza(paramActivity, this.zzaKC, this.zzaKz);
    this.zzaKC.zzb(this);
  }
  
  @Deprecated
  public zzd(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, zzaak paramzzaak)
  {
    this(paramActivity, paramApi, paramO, new zzd.zza.zza().zza(paramzzaak).zzb(paramActivity.getMainLooper()).zzwX());
  }
  
  protected zzd(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper)
  {
    zzac.zzb(paramContext, "Null context is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.zzaHI = paramApi;
    this.zzaKy = null;
    this.zzrD = paramLooper;
    this.zzaKz = zzyn.zzb(paramApi);
    this.zzaKA = new zzzm(this);
    this.zzaKC = zzzl.zzaV(this.mContext);
    this.mId = this.zzaKC.zzyl();
    this.zzaKB = new zzym();
    this.zzagc = null;
  }
  
  @Deprecated
  public zzd(@NonNull Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, zzaak paramzzaak)
  {
    this(paramContext, paramApi, paramO, new zzd.zza.zza().zzb(paramLooper).zza(paramzzaak).zzwX());
  }
  
  public zzd(@NonNull Context paramContext, Api<O> paramApi, O paramO, zza paramzza)
  {
    zzac.zzb(paramContext, "Null context is not permitted.");
    zzac.zzb(paramApi, "Api must not be null.");
    zzac.zzb(paramzza, "Settings must not be null; use Settings.createDefault() instead.");
    this.mContext = paramContext.getApplicationContext();
    this.zzaHI = paramApi;
    this.zzaKy = paramO;
    this.zzrD = paramzza.zzaKF;
    this.zzaKz = zzyn.zza(this.zzaHI, this.zzaKy);
    this.zzaKA = new zzzm(this);
    this.zzaKC = zzzl.zzaV(this.mContext);
    this.mId = this.zzaKC.zzyl();
    this.zzaKB = paramzza.zzaKE;
    this.zzagc = paramzza.account;
    this.zzaKC.zzb(this);
  }
  
  @Deprecated
  public zzd(@NonNull Context paramContext, Api<O> paramApi, O paramO, zzaak paramzzaak)
  {
    this(paramContext, paramApi, paramO, new zzd.zza.zza().zza(paramzzaak).zzwX());
  }
  
  private <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zza(int paramInt, @NonNull T paramT)
  {
    paramT.zzxu();
    this.zzaKC.zza(this, paramInt, paramT);
    return paramT;
  }
  
  private <TResult, A extends Api.zzb> Task<TResult> zza(int paramInt, @NonNull zzaao<A, TResult> paramzzaao)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zzaKC.zza(this, paramInt, paramzzaao, localTaskCompletionSource, this.zzaKB);
    return localTaskCompletionSource.getTask();
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return this.zzaKA;
  }
  
  @WorkerThread
  public Api.zze buildApiClient(Looper paramLooper, zzzl.zza<O> paramzza)
  {
    zzg localzzg = new GoogleApiClient.Builder(this.mContext).setAccount(this.zzagc).zzxc();
    return this.zzaHI.zzwR().zza(this.mContext, paramLooper, localzzg, this.zzaKy, paramzza, paramzza);
  }
  
  public zzaai createSignInCoordinator(Context paramContext, Handler paramHandler)
  {
    return new zzaai(paramContext, paramHandler);
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T doBestEffortWrite(@NonNull T paramT)
  {
    return zza(2, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doBestEffortWrite(zzaao<A, TResult> paramzzaao)
  {
    return zza(2, paramzzaao);
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T doRead(@NonNull T paramT)
  {
    return zza(0, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doRead(zzaao<A, TResult> paramzzaao)
  {
    return zza(0, paramzzaao);
  }
  
  public <A extends Api.zzb, T extends zzaac<A, ?>, U extends zzaas<A, ?>> Task<Void> doRegisterEventListener(@NonNull T paramT, U paramU)
  {
    zzac.zzC(paramT);
    zzac.zzC(paramU);
    zzac.zzb(paramT.zzyK(), "Listener has already been released.");
    zzac.zzb(paramU.zzyK(), "Listener has already been released.");
    zzac.zzb(paramT.zzyK().equals(paramU.zzyK()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.zzaKC.zza(this, paramT, paramU);
  }
  
  public Task<Void> doUnregisterEventListener(@NonNull zzzw.zzb<?> paramzzb)
  {
    zzac.zzb(paramzzb, "Listener key cannot be null.");
    return this.zzaKC.zza(this, paramzzb);
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T doWrite(@NonNull T paramT)
  {
    return zza(1, paramT);
  }
  
  public <TResult, A extends Api.zzb> Task<TResult> doWrite(zzaao<A, TResult> paramzzaao)
  {
    return zza(1, paramzzaao);
  }
  
  public Api<O> getApi()
  {
    return this.zzaHI;
  }
  
  public zzyn<O> getApiKey()
  {
    return this.zzaKz;
  }
  
  public O getApiOptions()
  {
    return this.zzaKy;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext;
  }
  
  public int getInstanceId()
  {
    return this.mId;
  }
  
  public Looper getLooper()
  {
    return this.zzrD;
  }
  
  public <L> zzzw<L> registerListener(@NonNull L paramL, String paramString)
  {
    return zzzx.zzb(paramL, this.zzrD, paramString);
  }
  
  public static class zza
  {
    public static final zza zzaKD = new zza().zzwX();
    public final Account account;
    public final zzaak zzaKE;
    public final Looper zzaKF;
    
    private zza(zzaak paramzzaak, Account paramAccount, Looper paramLooper)
    {
      this.zzaKE = paramzzaak;
      this.account = paramAccount;
      this.zzaKF = paramLooper;
    }
    
    public static class zza
    {
      private zzaak zzaKB;
      private Looper zzrD;
      
      public zza zza(zzaak paramzzaak)
      {
        zzac.zzb(paramzzaak, "StatusExceptionMapper must not be null.");
        this.zzaKB = paramzzaak;
        return this;
      }
      
      public zza zzb(Looper paramLooper)
      {
        zzac.zzb(paramLooper, "Looper must not be null.");
        this.zzrD = paramLooper;
        return this;
      }
      
      public zzd.zza zzwX()
      {
        if (this.zzaKB == null) {
          this.zzaKB = new zzym();
        }
        if (this.zzrD == null) {
          if (Looper.myLooper() == null) {
            break label56;
          }
        }
        label56:
        for (this.zzrD = Looper.myLooper();; this.zzrD = Looper.getMainLooper()) {
          return new zzd.zza(this.zzaKB, null, this.zzrD, null);
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */