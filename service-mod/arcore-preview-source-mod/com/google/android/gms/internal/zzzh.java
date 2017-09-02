package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzm.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzzh
  extends GoogleApiClient
  implements zzzq.zza
{
  private final Context mContext;
  private final int zzaKQ;
  private final GoogleApiAvailability zzaKS;
  final Api.zza<? extends zzbgc, zzbgd> zzaKT;
  private boolean zzaKW;
  private final Lock zzaMk;
  final zzg zzaMp;
  final Map<Api<?>, Boolean> zzaMs;
  final Queue<zzyr.zza<?, ?>> zzaMy = new LinkedList();
  private final zzm.zza zzaNA = new zzm.zza()
  {
    public boolean isConnected()
    {
      return zzzh.this.isConnected();
    }
    
    public Bundle zzwi()
    {
      return null;
    }
  };
  private final zzm zzaNm;
  private zzzq zzaNn = null;
  private volatile boolean zzaNo;
  private long zzaNp = 120000L;
  private long zzaNq = 5000L;
  private final zza zzaNr;
  zzzn zzaNs;
  final Map<Api.zzc<?>, Api.zze> zzaNt;
  Set<Scope> zzaNu = new HashSet();
  private final zzzx zzaNv = new zzzx();
  private final ArrayList<zzyu> zzaNw;
  private Integer zzaNx = null;
  Set<zzaaq> zzaNy = null;
  final zzaar zzaNz;
  private final Looper zzrD;
  
  public zzzh(Context paramContext, Lock paramLock, Looper paramLooper, zzg paramzzg, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzbgc, zzbgd> paramzza, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.zzc<?>, Api.zze> paramMap1, int paramInt1, int paramInt2, ArrayList<zzyu> paramArrayList, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.zzaMk = paramLock;
    this.zzaKW = paramBoolean;
    this.zzaNm = new zzm(paramLooper, this.zzaNA);
    this.zzrD = paramLooper;
    this.zzaNr = new zza(paramLooper);
    this.zzaKS = paramGoogleApiAvailability;
    this.zzaKQ = paramInt1;
    if (this.zzaKQ >= 0) {
      this.zzaNx = Integer.valueOf(paramInt2);
    }
    this.zzaMs = paramMap;
    this.zzaNt = paramMap1;
    this.zzaNw = paramArrayList;
    this.zzaNz = new zzaar(this.zzaNt);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.zzaNm.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      this.zzaNm.registerConnectionFailedListener(paramLock);
    }
    this.zzaMp = paramzzg;
    this.zzaKT = paramzza;
  }
  
  private void resume()
  {
    this.zzaMk.lock();
    try
    {
      if (isResuming()) {
        zzxY();
      }
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public static int zza(Iterable<Api.zze> paramIterable, boolean paramBoolean)
  {
    int k = 1;
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.zze localzze = (Api.zze)paramIterable.next();
      if (localzze.zzqB()) {
        j = 1;
      }
      if (!localzze.zzqP()) {
        break label85;
      }
      i = 1;
    }
    label85:
    for (;;)
    {
      break;
      if (j != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (paramBoolean) {
            j = 2;
          }
        }
        return j;
      }
      return 3;
    }
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzaal paramzzaal, final boolean paramBoolean)
  {
    zzabf.zzaSO.zzi(paramGoogleApiClient).setResultCallback(new ResultCallback()
    {
      public void zzx(@NonNull Status paramAnonymousStatus)
      {
        zzn.zzaw(zzzh.zzc(zzzh.this)).zzrb();
        if ((paramAnonymousStatus.isSuccess()) && (zzzh.this.isConnected())) {
          zzzh.this.reconnect();
        }
        paramzzaal.zzb(paramAnonymousStatus);
        if (paramBoolean) {
          paramGoogleApiClient.disconnect();
        }
      }
    });
  }
  
  private void zzb(@NonNull zzzr paramzzzr)
  {
    if (this.zzaKQ >= 0)
    {
      zzyo.zza(paramzzzr).zzfE(this.zzaKQ);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  private void zzfH(int paramInt)
  {
    if (this.zzaNx == null) {
      this.zzaNx = Integer.valueOf(paramInt);
    }
    Object localObject2;
    while (this.zzaNn != null)
    {
      return;
      if (this.zzaNx.intValue() != paramInt)
      {
        localObject1 = String.valueOf(zzfI(paramInt));
        localObject2 = String.valueOf(zzfI(this.zzaNx.intValue()));
        throw new IllegalStateException(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length() + "Cannot use sign-in mode: " + (String)localObject1 + ". Mode was already set to " + (String)localObject2);
      }
    }
    Object localObject1 = this.zzaNt.values().iterator();
    paramInt = 0;
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api.zze)((Iterator)localObject1).next();
      if (((Api.zze)localObject2).zzqB()) {
        i = 1;
      }
      if (!((Api.zze)localObject2).zzqP()) {
        break label463;
      }
      paramInt = 1;
    }
    label463:
    for (;;)
    {
      break;
      switch (this.zzaNx.intValue())
      {
      }
      while ((this.zzaKW) && (paramInt == 0))
      {
        this.zzaNn = new zzyy(this.mContext, this.zzaMk, this.zzrD, this.zzaKS, this.zzaNt, this.zzaMp, this.zzaMs, this.zzaKT, this.zzaNw, this, false);
        return;
        if (i == 0) {
          throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        }
        if (paramInt != 0)
        {
          throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
          if (i != 0)
          {
            if (this.zzaKW)
            {
              this.zzaNn = new zzyy(this.mContext, this.zzaMk, this.zzrD, this.zzaKS, this.zzaNt, this.zzaMp, this.zzaMs, this.zzaKT, this.zzaNw, this, true);
              return;
            }
            this.zzaNn = zzyw.zza(this.mContext, this, this.zzaMk, this.zzrD, this.zzaKS, this.zzaNt, this.zzaMp, this.zzaMs, this.zzaKT, this.zzaNw);
            return;
          }
        }
      }
      this.zzaNn = new zzzj(this.mContext, this, this.zzaMk, this.zzrD, this.zzaKS, this.zzaNt, this.zzaMp, this.zzaMs, this.zzaKT, this.zzaNw, this);
      return;
    }
  }
  
  static String zzfI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  private void zzxY()
  {
    this.zzaNm.zzzS();
    this.zzaNn.connect();
  }
  
  private void zzxZ()
  {
    this.zzaMk.lock();
    try
    {
      if (zzyb()) {
        zzxY();
      }
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "blockingConnect must not be called on the UI thread");
      this.zzaMk.lock();
      try
      {
        if (this.zzaKQ >= 0) {
          if (this.zzaNx != null)
          {
            bool1 = bool2;
            label45:
            zzac.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzfH(this.zzaNx.intValue());
            this.zzaNm.zzzS();
            ConnectionResult localConnectionResult = this.zzaNn.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label45;
            if (this.zzaNx != null) {
              break label143;
            }
            this.zzaNx = Integer.valueOf(zza(this.zzaNt.values(), false));
          }
        } while (this.zzaNx.intValue() != 2);
      }
      finally
      {
        this.zzaMk.unlock();
      }
    }
    label143:
    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    boolean bool = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    zzac.zza(bool, "blockingConnect must not be called on the UI thread");
    zzac.zzb(paramTimeUnit, "TimeUnit must not be null");
    this.zzaMk.lock();
    try
    {
      if (this.zzaNx == null) {
        this.zzaNx = Integer.valueOf(zza(this.zzaNt.values(), false));
      }
      while (this.zzaNx.intValue() != 2)
      {
        zzfH(this.zzaNx.intValue());
        this.zzaNm.zzzS();
        paramTimeUnit = this.zzaNn.blockingConnect(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    zzac.zza(isConnected(), "GoogleApiClient is not connected yet.");
    if (this.zzaNx.intValue() != 2) {}
    final zzaal localzzaal;
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localzzaal = new zzaal(this);
      if (!this.zzaNt.containsKey(zzabf.zzaiF)) {
        break;
      }
      zza(this, localzzaal, false);
      return localzzaal;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        zzzh.zza(zzzh.this, (GoogleApiClient)localAtomicReference.get(), localzzaal, true);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt) {}
    };
    GoogleApiClient.OnConnectionFailedListener local3 = new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(@NonNull ConnectionResult paramAnonymousConnectionResult)
      {
        localzzaal.zzb(new Status(8));
      }
    };
    localObject = new GoogleApiClient.Builder(this.mContext).addApi(zzabf.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(local3).setHandler(this.zzaNr).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localzzaal;
  }
  
  public void connect()
  {
    boolean bool = false;
    this.zzaMk.lock();
    try
    {
      if (this.zzaKQ >= 0)
      {
        if (this.zzaNx != null) {
          bool = true;
        }
        zzac.zza(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      do
      {
        for (;;)
        {
          connect(this.zzaNx.intValue());
          return;
          if (this.zzaNx != null) {
            break;
          }
          this.zzaNx = Integer.valueOf(zza(this.zzaNt.values(), false));
        }
      } while (this.zzaNx.intValue() != 2);
    }
    finally
    {
      this.zzaMk.unlock();
    }
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  /* Error */
  public void connect(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 116	com/google/android/gms/internal/zzzh:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 196 1 0
    //   11: iload_3
    //   12: istore_2
    //   13: iload_1
    //   14: iconst_3
    //   15: if_icmpeq +17 -> 32
    //   18: iload_3
    //   19: istore_2
    //   20: iload_1
    //   21: iconst_1
    //   22: if_icmpeq +10 -> 32
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +50 -> 77
    //   30: iload_3
    //   31: istore_2
    //   32: iload_2
    //   33: new 285	java/lang/StringBuilder
    //   36: dup
    //   37: bipush 33
    //   39: invokespecial 290	java/lang/StringBuilder:<init>	(I)V
    //   42: ldc_w 457
    //   45: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_1
    //   49: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 462	com/google/android/gms/common/internal/zzac:zzb	(ZLjava/lang/Object;)V
    //   58: aload_0
    //   59: iload_1
    //   60: invokespecial 371	com/google/android/gms/internal/zzzh:zzfH	(I)V
    //   63: aload_0
    //   64: invokespecial 202	com/google/android/gms/internal/zzzh:zzxY	()V
    //   67: aload_0
    //   68: getfield 116	com/google/android/gms/internal/zzzh:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   71: invokeinterface 205 1 0
    //   76: return
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -47 -> 32
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 116	com/google/android/gms/internal/zzzh:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 205 1 0
    //   93: aload 4
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	zzzh
    //   0	96	1	paramInt	int
    //   12	67	2	bool1	boolean
    //   1	30	3	bool2	boolean
    //   82	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	67	82	finally
  }
  
  public void disconnect()
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNz.release();
      if (this.zzaNn != null) {
        this.zzaNn.disconnect();
      }
      this.zzaNv.release();
      Iterator localIterator = this.zzaMy.iterator();
      while (localIterator.hasNext())
      {
        zzyr.zza localzza = (zzyr.zza)localIterator.next();
        localzza.zza(null);
        localzza.cancel();
      }
      this.zzaMy.clear();
    }
    finally
    {
      this.zzaMk.unlock();
    }
    zzzq localzzzq = this.zzaNn;
    if (localzzzq == null)
    {
      this.zzaMk.unlock();
      return;
    }
    zzyb();
    this.zzaNm.zzzR();
    this.zzaMk.unlock();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zzaNo);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zzaMy.size());
    this.zzaNz.dump(paramPrintWriter);
    if (this.zzaNn != null) {
      this.zzaNn.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @NonNull
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    this.zzaMk.lock();
    try
    {
      if ((!isConnected()) && (!isResuming())) {
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      }
    }
    finally
    {
      this.zzaMk.unlock();
    }
    if (this.zzaNt.containsKey(paramApi.zzwS()))
    {
      ConnectionResult localConnectionResult = this.zzaNn.getConnectionResult(paramApi);
      if (localConnectionResult == null)
      {
        if (isResuming())
        {
          paramApi = ConnectionResult.zzaJO;
          this.zzaMk.unlock();
          return paramApi;
        }
        Log.w("GoogleApiClientImpl", zzyd());
        Log.wtf("GoogleApiClientImpl", String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
        paramApi = new ConnectionResult(8, null);
        this.zzaMk.unlock();
        return paramApi;
      }
      this.zzaMk.unlock();
      return localConnectionResult;
    }
    throw new IllegalArgumentException(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public Looper getLooper()
  {
    return this.zzrD;
  }
  
  public int getSessionId()
  {
    return System.identityHashCode(this);
  }
  
  public boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    if (!isConnected()) {
      return false;
    }
    paramApi = (Api.zze)this.zzaNt.get(paramApi.zzwS());
    if ((paramApi != null) && (paramApi.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isConnected()
  {
    return (this.zzaNn != null) && (this.zzaNn.isConnected());
  }
  
  public boolean isConnecting()
  {
    return (this.zzaNn != null) && (this.zzaNn.isConnecting());
  }
  
  public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zzaNm.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zzaNm.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  boolean isResuming()
  {
    return this.zzaNo;
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzaNm.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzaNm.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    zzb(new zzzr(paramFragmentActivity));
  }
  
  public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzaNm.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzaNm.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramzzc)
  {
    paramzzc = (Api.zze)this.zzaNt.get(paramzzc);
    zzac.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    boolean bool;
    if (paramT.zzwS() != null) {
      bool = true;
    }
    for (;;)
    {
      zzac.zzb(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      bool = this.zzaNt.containsKey(paramT.zzwS());
      String str;
      if (paramT.getApi() != null)
      {
        str = paramT.getApi().getName();
        label45:
        zzac.zzb(bool, String.valueOf(str).length() + 65 + "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.zzaMk.lock();
      }
      try
      {
        if (this.zzaNn == null)
        {
          this.zzaMy.add(paramT);
          return paramT;
          bool = false;
          continue;
          str = "the API";
          break label45;
        }
        paramT = this.zzaNn.zza(paramT);
        return paramT;
      }
      finally
      {
        this.zzaMk.unlock();
      }
    }
  }
  
  public void zza(ResultStore paramResultStore)
  {
    this.zzaNz.zza(paramResultStore);
  }
  
  public void zza(zzaaq paramzzaaq)
  {
    this.zzaMk.lock();
    try
    {
      if (this.zzaNy == null) {
        this.zzaNy = new HashSet();
      }
      this.zzaNy.add(paramzzaaq);
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public boolean zza(@NonNull Api<?> paramApi)
  {
    return this.zzaNt.containsKey(paramApi.zzwS());
  }
  
  public boolean zza(zzaah paramzzaah)
  {
    return (this.zzaNn != null) && (this.zzaNn.zza(paramzzaah));
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    boolean bool;
    if (paramT.zzwS() != null)
    {
      bool = true;
      zzac.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = this.zzaNt.containsKey(paramT.zzwS());
      if (paramT.getApi() == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject = paramT.getApi().getName();; localObject = "the API")
    {
      zzac.zzb(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      this.zzaMk.lock();
      try
      {
        if (this.zzaNn != null) {
          break label136;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.zzaMk.unlock();
      }
      bool = false;
      break;
    }
    label136:
    if (isResuming())
    {
      this.zzaMy.add(paramT);
      while (!this.zzaMy.isEmpty())
      {
        localObject = (zzyr.zza)this.zzaMy.remove();
        this.zzaNz.zzb((zzyt)localObject);
        ((zzyr.zza)localObject).zzP(Status.zzaLe);
      }
      this.zzaMk.unlock();
      return paramT;
    }
    paramT = this.zzaNn.zzb(paramT);
    this.zzaMk.unlock();
    return paramT;
  }
  
  public void zzb(zzaaq paramzzaaq)
  {
    this.zzaMk.lock();
    for (;;)
    {
      try
      {
        if (this.zzaNy == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!this.zzaNy.remove(paramzzaaq))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (zzyc()) {
          continue;
        }
      }
      finally
      {
        this.zzaMk.unlock();
      }
      this.zzaNn.zzxy();
    }
  }
  
  <C extends Api.zze> C zzc(Api.zzc<?> paramzzc)
  {
    paramzzc = (Api.zze)this.zzaNt.get(paramzzc);
    zzac.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public void zzc(ConnectionResult paramConnectionResult)
  {
    if (!this.zzaKS.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode())) {
      zzyb();
    }
    if (!isResuming())
    {
      this.zzaNm.zzn(paramConnectionResult);
      this.zzaNm.zzzR();
    }
  }
  
  public void zzf(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean)) {
      zzya();
    }
    this.zzaNz.zzyS();
    this.zzaNm.zzfZ(paramInt);
    this.zzaNm.zzzR();
    if (paramInt == 2) {
      zzxY();
    }
  }
  
  public <L> zzzw<L> zzu(@NonNull L paramL)
  {
    this.zzaMk.lock();
    try
    {
      paramL = this.zzaNv.zzb(paramL, this.zzrD);
      return paramL;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public void zzu(Bundle paramBundle)
  {
    while (!this.zzaMy.isEmpty()) {
      zzb((zzyr.zza)this.zzaMy.remove());
    }
    this.zzaNm.zzw(paramBundle);
  }
  
  public void zzxa()
  {
    if (this.zzaNn != null) {
      this.zzaNn.zzxa();
    }
  }
  
  void zzya()
  {
    if (isResuming()) {
      return;
    }
    this.zzaNo = true;
    if (this.zzaNs == null) {
      this.zzaNs = this.zzaKS.zza(this.mContext.getApplicationContext(), new zzb(this));
    }
    this.zzaNr.sendMessageDelayed(this.zzaNr.obtainMessage(1), this.zzaNp);
    this.zzaNr.sendMessageDelayed(this.zzaNr.obtainMessage(2), this.zzaNq);
  }
  
  boolean zzyb()
  {
    if (!isResuming()) {
      return false;
    }
    this.zzaNo = false;
    this.zzaNr.removeMessages(2);
    this.zzaNr.removeMessages(1);
    if (this.zzaNs != null)
    {
      this.zzaNs.unregister();
      this.zzaNs = null;
    }
    return true;
  }
  
  boolean zzyc()
  {
    boolean bool1 = false;
    this.zzaMk.lock();
    try
    {
      Set localSet = this.zzaNy;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = this.zzaNy.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  String zzyd()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.w("GoogleApiClientImpl", 31 + "Unknown message id: " + i);
        return;
      case 1: 
        zzzh.zzb(zzzh.this);
        return;
      }
      zzzh.zza(zzzh.this);
    }
  }
  
  static class zzb
    extends zzzn.zza
  {
    private WeakReference<zzzh> zzaNF;
    
    zzb(zzzh paramzzzh)
    {
      this.zzaNF = new WeakReference(paramzzzh);
    }
    
    public void zzxq()
    {
      zzzh localzzzh = (zzzh)this.zzaNF.get();
      if (localzzzh == null) {
        return;
      }
      zzzh.zza(localzzzh);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */