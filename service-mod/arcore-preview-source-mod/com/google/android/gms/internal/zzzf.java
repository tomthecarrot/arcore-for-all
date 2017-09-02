package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzzf
  implements zzzi
{
  private final Context mContext;
  private final Api.zza<? extends zzbgc, zzbgd> zzaKT;
  private ConnectionResult zzaMD;
  private final zzzj zzaMN;
  private int zzaMQ;
  private int zzaMR = 0;
  private int zzaMS;
  private final Bundle zzaMT = new Bundle();
  private final Set<Api.zzc> zzaMU = new HashSet();
  private zzbgc zzaMV;
  private boolean zzaMW;
  private boolean zzaMX;
  private boolean zzaMY;
  private zzr zzaMZ;
  private final Lock zzaMk;
  private final zzg zzaMp;
  private final Map<Api<?>, Boolean> zzaMs;
  private final GoogleApiAvailabilityLight zzaMu;
  private boolean zzaNa;
  private boolean zzaNb;
  private ArrayList<Future<?>> zzaNc = new ArrayList();
  
  public zzzf(zzzj paramzzzj, zzg paramzzg, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.zza<? extends zzbgc, zzbgd> paramzza, Lock paramLock, Context paramContext)
  {
    this.zzaMN = paramzzzj;
    this.zzaMp = paramzzg;
    this.zzaMs = paramMap;
    this.zzaMu = paramGoogleApiAvailabilityLight;
    this.zzaKT = paramzza;
    this.zzaMk = paramLock;
    this.mContext = paramContext;
  }
  
  private void zza(zzbgq paramzzbgq)
  {
    if (!zzfF(0)) {
      return;
    }
    Object localObject = paramzzbgq.zzAb();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramzzbgq.zzWi();
      paramzzbgq = ((zzaf)localObject).zzAb();
      if (!paramzzbgq.isSuccess())
      {
        localObject = String.valueOf(paramzzbgq);
        Log.wtf("GoogleApiClientConnecting", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zzf(paramzzbgq);
        return;
      }
      this.zzaMY = true;
      this.zzaMZ = ((zzaf)localObject).zzAa();
      this.zzaNa = ((zzaf)localObject).zzAc();
      this.zzaNb = ((zzaf)localObject).zzAd();
      zzxS();
      return;
    }
    if (zze((ConnectionResult)localObject))
    {
      zzxV();
      zzxS();
      return;
    }
    zzf((ConnectionResult)localObject);
  }
  
  private boolean zza(int paramInt, boolean paramBoolean, ConnectionResult paramConnectionResult)
  {
    if ((paramBoolean) && (!zzd(paramConnectionResult))) {}
    while ((this.zzaMD != null) && (paramInt >= this.zzaMQ)) {
      return false;
    }
    return true;
  }
  
  private void zzat(boolean paramBoolean)
  {
    if (this.zzaMV != null)
    {
      if ((this.zzaMV.isConnected()) && (paramBoolean)) {
        this.zzaMV.zzVX();
      }
      this.zzaMV.disconnect();
      this.zzaMZ = null;
    }
  }
  
  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    int i = paramApi.zzwQ().getPriority();
    if (zza(i, paramBoolean, paramConnectionResult))
    {
      this.zzaMD = paramConnectionResult;
      this.zzaMQ = i;
    }
    this.zzaMN.zzaNI.put(paramApi.zzwS(), paramConnectionResult);
  }
  
  private boolean zzd(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {}
    while (this.zzaMu.getErrorResolutionIntent(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean zze(ConnectionResult paramConnectionResult)
  {
    return (this.zzaMW) && (!paramConnectionResult.hasResolution());
  }
  
  private void zzf(ConnectionResult paramConnectionResult)
  {
    zzxW();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzat(bool);
      this.zzaMN.zzh(paramConnectionResult);
      this.zzaMN.zzaNM.zzc(paramConnectionResult);
      return;
    }
  }
  
  private boolean zzfF(int paramInt)
  {
    if (this.zzaMR != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.zzaMN.zzaMa.zzyd());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = this.zzaMS;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(zzfG(this.zzaMR));
      String str2 = String.valueOf(zzfG(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private String zzfG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private boolean zzxR()
  {
    this.zzaMS -= 1;
    if (this.zzaMS > 0) {
      return false;
    }
    if (this.zzaMS < 0)
    {
      Log.w("GoogleApiClientConnecting", this.zzaMN.zzaMa.zzyd());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    if (this.zzaMD != null)
    {
      this.zzaMN.zzaNL = this.zzaMQ;
      zzf(this.zzaMD);
      return false;
    }
    return true;
  }
  
  private void zzxS()
  {
    if (this.zzaMS != 0) {}
    while ((this.zzaMX) && (!this.zzaMY)) {
      return;
    }
    zzxT();
  }
  
  private void zzxT()
  {
    ArrayList localArrayList = new ArrayList();
    this.zzaMR = 1;
    this.zzaMS = this.zzaMN.zzaNt.size();
    Iterator localIterator = this.zzaMN.zzaNt.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zzaMN.zzaNI.containsKey(localzzc))
      {
        if (zzxR()) {
          zzxU();
        }
      }
      else {
        localArrayList.add((Api.zze)this.zzaMN.zzaNt.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      this.zzaNc.add(zzzk.zzyh().submit(new zzc(localArrayList)));
    }
  }
  
  private void zzxU()
  {
    this.zzaMN.zzyf();
    zzzk.zzyh().execute(new Runnable()
    {
      public void run()
      {
        zzzf.zzb(zzzf.this).zzaO(zzzf.zza(zzzf.this));
      }
    });
    if (this.zzaMV != null)
    {
      if (this.zzaNa) {
        this.zzaMV.zza(this.zzaMZ, this.zzaNb);
      }
      zzat(false);
    }
    Object localObject = this.zzaMN.zzaNI.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localzzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zze)this.zzaMN.zzaNt.get(localzzc)).disconnect();
    }
    if (this.zzaMT.isEmpty()) {}
    for (localObject = null;; localObject = this.zzaMT)
    {
      this.zzaMN.zzaNM.zzu((Bundle)localObject);
      return;
    }
  }
  
  private void zzxV()
  {
    this.zzaMX = false;
    this.zzaMN.zzaMa.zzaNu = Collections.emptySet();
    Iterator localIterator = this.zzaMU.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (!this.zzaMN.zzaNI.containsKey(localzzc)) {
        this.zzaMN.zzaNI.put(localzzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private void zzxW()
  {
    Iterator localIterator = this.zzaNc.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.zzaNc.clear();
  }
  
  private Set<Scope> zzxX()
  {
    if (this.zzaMp == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet(this.zzaMp.zzzF());
    Map localMap = this.zzaMp.zzzH();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zzaMN.zzaNI.containsKey(localApi.zzwS())) {
        localHashSet.addAll(((zzg.zza)localMap.get(localApi)).zzamH);
      }
    }
    return localHashSet;
  }
  
  public void begin()
  {
    this.zzaMN.zzaNI.clear();
    this.zzaMX = false;
    this.zzaMD = null;
    this.zzaMR = 0;
    this.zzaMW = true;
    this.zzaMY = false;
    this.zzaNa = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.zzaMs.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zze localzze = (Api.zze)this.zzaMN.zzaNt.get(localApi.zzwS());
      int j;
      label127:
      boolean bool;
      if (localApi.zzwQ().getPriority() == 1)
      {
        j = 1;
        bool = ((Boolean)this.zzaMs.get(localApi)).booleanValue();
        if (localzze.zzqB())
        {
          this.zzaMX = true;
          if (!bool) {
            break label212;
          }
          this.zzaMU.add(localApi.zzwS());
        }
      }
      for (;;)
      {
        localHashMap.put(localzze, new zza(this, localApi, bool));
        i = j | i;
        break;
        j = 0;
        break label127;
        label212:
        this.zzaMW = false;
      }
    }
    if (i != 0) {
      this.zzaMX = false;
    }
    if (this.zzaMX)
    {
      this.zzaMp.zzd(Integer.valueOf(this.zzaMN.zzaMa.getSessionId()));
      localObject = new zze(null);
      this.zzaMV = ((zzbgc)this.zzaKT.zza(this.mContext, this.zzaMN.zzaMa.getLooper(), this.zzaMp, this.zzaMp.zzzL(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    this.zzaMS = this.zzaMN.zzaNt.size();
    this.zzaNc.add(zzzk.zzyh().submit(new zzb(localHashMap)));
  }
  
  public void connect() {}
  
  public boolean disconnect()
  {
    zzxW();
    zzat(true);
    this.zzaMN.zzh(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (!zzfF(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.zzaMT.putAll(paramBundle);
      }
    } while (!zzxR());
    zzxU();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzf(new ConnectionResult(8, null));
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(T paramT)
  {
    this.zzaMN.zzaMa.zzaMy.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    if (!zzfF(1)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramBoolean);
    } while (!zzxR());
    zzxU();
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  private static class zza
    implements zzf.zzf
  {
    private final Api<?> zzaHI;
    private final boolean zzaLY;
    private final WeakReference<zzzf> zzaNe;
    
    public zza(zzzf paramzzzf, Api<?> paramApi, boolean paramBoolean)
    {
      this.zzaNe = new WeakReference(paramzzzf);
      this.zzaHI = paramApi;
      this.zzaLY = paramBoolean;
    }
    
    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzzf localzzzf = (zzzf)this.zzaNe.get();
      if (localzzzf == null) {
        return;
      }
      if (Looper.myLooper() == zzzf.zzd(localzzzf).zzaMa.getLooper()) {
        bool = true;
      }
      zzac.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzzf.zzc(localzzzf).lock();
      try
      {
        bool = zzzf.zza(localzzzf, 0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzzf.zza(localzzzf, paramConnectionResult, this.zzaHI, this.zzaLY);
        }
        if (zzzf.zzk(localzzzf)) {
          zzzf.zzj(localzzzf);
        }
        return;
      }
      finally
      {
        zzzf.zzc(localzzzf).unlock();
      }
    }
  }
  
  private class zzb
    extends zzzf.zzf
  {
    private final Map<Api.zze, zzzf.zza> zzaNf;
    
    public zzb()
    {
      super(null);
      Map localMap;
      this.zzaNf = localMap;
    }
    
    @WorkerThread
    public void zzxQ()
    {
      int n = 1;
      int m = 0;
      final Object localObject = this.zzaNf.keySet().iterator();
      int j = 1;
      int i = 0;
      Api.zze localzze;
      int k;
      if (((Iterator)localObject).hasNext())
      {
        localzze = (Api.zze)((Iterator)localObject).next();
        if (localzze.zzwT())
        {
          if (zzzf.zza.zza((zzzf.zza)this.zzaNf.get(localzze))) {
            break label301;
          }
          i = 1;
          k = n;
        }
      }
      for (;;)
      {
        if (k != 0) {
          m = zzzf.zzb(zzzf.this).isGooglePlayServicesAvailable(zzzf.zza(zzzf.this));
        }
        if ((m != 0) && ((i != 0) || (j != 0)))
        {
          localObject = new ConnectionResult(m, null);
          zzzf.zzd(zzzf.this).zza(new zzzj.zza(zzzf.this)
          {
            public void zzxQ()
            {
              zzzf.zza(zzzf.this, localObject);
            }
          });
          label155:
          return;
          k = 0;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (zzzf.zze(zzzf.this)) {
            zzzf.zzf(zzzf.this).connect();
          }
          localObject = this.zzaNf.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localzze = (Api.zze)((Iterator)localObject).next();
            final zzf.zzf localzzf = (zzf.zzf)this.zzaNf.get(localzze);
            if ((localzze.zzwT()) && (m != 0)) {
              zzzf.zzd(zzzf.this).zza(new zzzj.zza(zzzf.this)
              {
                public void zzxQ()
                {
                  localzzf.zzg(new ConnectionResult(16, null));
                }
              });
            } else {
              localzze.zza(localzzf);
            }
          }
          break label155;
          label301:
          i = j;
          j = 1;
        }
        k = i;
        i = 0;
      }
    }
  }
  
  private class zzc
    extends zzzf.zzf
  {
    private final ArrayList<Api.zze> zzaNj;
    
    public zzc()
    {
      super(null);
      ArrayList localArrayList;
      this.zzaNj = localArrayList;
    }
    
    @WorkerThread
    public void zzxQ()
    {
      zzzf.zzd(zzzf.this).zzaMa.zzaNu = zzzf.zzg(zzzf.this);
      Iterator localIterator = this.zzaNj.iterator();
      while (localIterator.hasNext()) {
        ((Api.zze)localIterator.next()).zza(zzzf.zzh(zzzf.this), zzzf.zzd(zzzf.this).zzaMa.zzaNu);
      }
    }
  }
  
  private static class zzd
    extends zzbgg
  {
    private final WeakReference<zzzf> zzaNe;
    
    zzd(zzzf paramzzzf)
    {
      this.zzaNe = new WeakReference(paramzzzf);
    }
    
    @BinderThread
    public void zzb(final zzbgq paramzzbgq)
    {
      final zzzf localzzzf = (zzzf)this.zzaNe.get();
      if (localzzzf == null) {
        return;
      }
      zzzf.zzd(localzzzf).zza(new zzzj.zza(localzzzf)
      {
        public void zzxQ()
        {
          zzzf.zza(localzzzf, paramzzbgq);
        }
      });
    }
  }
  
  private class zze
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zze() {}
    
    public void onConnected(Bundle paramBundle)
    {
      zzzf.zzf(zzzf.this).zza(new zzzf.zzd(zzzf.this));
    }
    
    /* Error */
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   4: invokestatic 46	com/google/android/gms/internal/zzzf:zzc	(Lcom/google/android/gms/internal/zzzf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 51 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   16: aload_1
      //   17: invokestatic 55	com/google/android/gms/internal/zzzf:zzb	(Lcom/google/android/gms/internal/zzzf;Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   27: invokestatic 58	com/google/android/gms/internal/zzzf:zzi	(Lcom/google/android/gms/internal/zzzf;)V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   34: invokestatic 61	com/google/android/gms/internal/zzzf:zzj	(Lcom/google/android/gms/internal/zzzf;)V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   41: invokestatic 46	com/google/android/gms/internal/zzzf:zzc	(Lcom/google/android/gms/internal/zzzf;)Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 64 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   54: aload_1
      //   55: invokestatic 67	com/google/android/gms/internal/zzzf:zza	(Lcom/google/android/gms/internal/zzzf;Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/internal/zzzf$zze:zzaNd	Lcom/google/android/gms/internal/zzzf;
      //   66: invokestatic 46	com/google/android/gms/internal/zzzf:zzc	(Lcom/google/android/gms/internal/zzzf;)Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 64 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zze
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public void onConnectionSuspended(int paramInt) {}
  }
  
  private abstract class zzf
    implements Runnable
  {
    private zzf() {}
    
    @WorkerThread
    public void run()
    {
      zzzf.zzc(zzzf.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zzxQ();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzzf.zzd(zzzf.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzzf.zzc(zzzf.this).unlock();
      }
    }
    
    @WorkerThread
    protected abstract void zzxQ();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */