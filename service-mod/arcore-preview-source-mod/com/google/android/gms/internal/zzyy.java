package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzyy
  implements zzzq
{
  private final zzzl zzaKC;
  private Map<zzyn<?>, ConnectionResult> zzaMA;
  private Map<zzyn<?>, ConnectionResult> zzaMB;
  private zzb zzaMC;
  private ConnectionResult zzaMD;
  private final Lock zzaMk;
  private final zzg zzaMp;
  private final Map<Api.zzc<?>, zzyx<?>> zzaMq = new HashMap();
  private final Map<Api.zzc<?>, zzyx<?>> zzaMr = new HashMap();
  private final Map<Api<?>, Boolean> zzaMs;
  private final zzzh zzaMt;
  private final GoogleApiAvailabilityLight zzaMu;
  private final Condition zzaMv;
  private final boolean zzaMw;
  private final boolean zzaMx;
  private final Queue<zzyr.zza<?, ?>> zzaMy = new LinkedList();
  private boolean zzaMz;
  private final Looper zzrD;
  
  public zzyy(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Boolean> paramMap1, Api.zza<? extends zzbgc, zzbgd> paramzza, ArrayList<zzyu> paramArrayList, zzzh paramzzzh, boolean paramBoolean)
  {
    this.zzaMk = paramLock;
    this.zzrD = paramLooper;
    this.zzaMv = paramLock.newCondition();
    this.zzaMu = paramGoogleApiAvailabilityLight;
    this.zzaMt = paramzzzh;
    this.zzaMs = paramMap1;
    this.zzaMp = paramzzg;
    this.zzaMw = paramBoolean;
    paramLock = new HashMap();
    paramGoogleApiAvailabilityLight = paramMap1.keySet().iterator();
    while (paramGoogleApiAvailabilityLight.hasNext())
    {
      paramMap1 = (Api)paramGoogleApiAvailabilityLight.next();
      paramLock.put(paramMap1.zzwS(), paramMap1);
    }
    paramGoogleApiAvailabilityLight = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (zzyu)paramMap1.next();
      paramGoogleApiAvailabilityLight.put(paramArrayList.zzaHI, paramArrayList);
    }
    paramMap = paramMap.entrySet().iterator();
    int j = 1;
    int i = 0;
    int k = 0;
    if (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramzzzh = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = (Api.zze)paramMap1.getValue();
      if (paramArrayList.zzwT())
      {
        k = 1;
        if (((Boolean)this.zzaMs.get(paramzzzh)).booleanValue()) {
          break label471;
        }
        i = j;
        j = 1;
      }
    }
    for (;;)
    {
      paramzzzh = new zzyx(paramContext, paramzzzh, paramLooper, paramArrayList, (zzyu)paramGoogleApiAvailabilityLight.get(paramzzzh), paramzzg, paramzza);
      this.zzaMq.put((Api.zzc)paramMap1.getKey(), paramzzzh);
      if (paramArrayList.zzqB()) {
        this.zzaMr.put((Api.zzc)paramMap1.getKey(), paramzzzh);
      }
      int m = j;
      j = i;
      i = m;
      break;
      m = 0;
      j = i;
      i = m;
      continue;
      if ((k != 0) && (j == 0) && (i == 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.zzaMx = paramBoolean;
        this.zzaKC = zzzl.zzyi();
        return;
      }
      label471:
      m = i;
      i = j;
      j = m;
    }
  }
  
  private boolean zza(zzyx<?> paramzzyx, ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zzaMs.get(paramzzyx.getApi())).booleanValue()) && (paramzzyx.zzxG().zzwT()) && (this.zzaMu.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  @Nullable
  private ConnectionResult zzb(@NonNull Api.zzc<?> paramzzc)
  {
    this.zzaMk.lock();
    try
    {
      paramzzc = (zzyx)this.zzaMq.get(paramzzc);
      if ((this.zzaMA != null) && (paramzzc != null))
      {
        paramzzc = (ConnectionResult)this.zzaMA.get(paramzzc.getApiKey());
        return paramzzc;
      }
      return null;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  private <T extends zzyr.zza<? extends Result, ? extends Api.zzb>> boolean zzd(@NonNull T paramT)
  {
    Api.zzc localzzc = paramT.zzwS();
    ConnectionResult localConnectionResult = zzb(localzzc);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.zzP(new Status(4, null, this.zzaKC.zza(((zzyx)this.zzaMq.get(localzzc)).getApiKey(), this.zzaMt.getSessionId())));
      return true;
    }
    return false;
  }
  
  private void zzxH()
  {
    if (this.zzaMp == null)
    {
      this.zzaMt.zzaNu = Collections.emptySet();
      return;
    }
    HashSet localHashSet = new HashSet(this.zzaMp.zzzF());
    Map localMap = this.zzaMp.zzzH();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
        localHashSet.addAll(((zzg.zza)localMap.get(localApi)).zzamH);
      }
    }
    this.zzaMt.zzaNu = localHashSet;
  }
  
  private void zzxI()
  {
    while (!this.zzaMy.isEmpty()) {
      zzb((zzyr.zza)this.zzaMy.remove());
    }
    this.zzaMt.zzu(null);
  }
  
  @Nullable
  private ConnectionResult zzxJ()
  {
    Iterator localIterator = this.zzaMq.values().iterator();
    int j = 0;
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject3 = (zzyx)localIterator.next();
      Api localApi = ((zzyx)localObject3).getApi();
      localObject3 = ((zzyx)localObject3).getApiKey();
      localObject3 = (ConnectionResult)this.zzaMA.get(localObject3);
      if ((!((ConnectionResult)localObject3).isSuccess()) && ((!((Boolean)this.zzaMs.get(localApi)).booleanValue()) || (((ConnectionResult)localObject3).hasResolution()) || (this.zzaMu.isUserResolvableError(((ConnectionResult)localObject3).getErrorCode()))))
      {
        int k;
        if ((((ConnectionResult)localObject3).getErrorCode() == 4) && (this.zzaMw))
        {
          k = localApi.zzwQ().getPriority();
          if ((localObject2 == null) || (j > k))
          {
            j = k;
            localObject2 = localObject3;
          }
        }
        else
        {
          k = localApi.zzwQ().getPriority();
          if ((localObject1 != null) && (i <= k)) {
            break label222;
          }
          localObject1 = localObject3;
          i = k;
        }
      }
    }
    label222:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (localObject2 != null) && (i > j)) {
        return (ConnectionResult)localObject2;
      }
      return (ConnectionResult)localObject1;
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zzaMv.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzaJO;
    }
    if (this.zzaMD != null) {
      return this.zzaMD;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzaMv.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzaJO;
    }
    if (this.zzaMD != null) {
      return this.zzaMD;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    this.zzaMk.lock();
    try
    {
      boolean bool = this.zzaMz;
      if (bool) {
        return;
      }
      this.zzaMz = true;
      this.zzaMA = null;
      this.zzaMB = null;
      this.zzaMC = null;
      this.zzaMD = null;
      this.zzaKC.zzxj();
      this.zzaKC.zza(this.zzaMq.values()).addOnCompleteListener(new zzabv(this.zzrD), new zza(null));
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public void disconnect()
  {
    this.zzaMk.lock();
    try
    {
      this.zzaMz = false;
      this.zzaMA = null;
      this.zzaMB = null;
      if (this.zzaMC != null)
      {
        this.zzaMC.cancel();
        this.zzaMC = null;
      }
      this.zzaMD = null;
      while (!this.zzaMy.isEmpty())
      {
        zzyr.zza localzza = (zzyr.zza)this.zzaMy.remove();
        localzza.zza(null);
        localzza.cancel();
      }
      this.zzaMv.signalAll();
    }
    finally
    {
      this.zzaMk.unlock();
    }
    this.zzaMk.unlock();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    return zzb(paramApi.zzwS());
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 223 1 0
    //   9: aload_0
    //   10: getfield 182	com/google/android/gms/internal/zzyy:zzaMA	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 179	com/google/android/gms/internal/zzyy:zzaMD	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 230 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 230 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzyy
    //   26	14	1	bool	boolean
    //   20	2	2	localConnectionResult	ConnectionResult
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 223 1 0
    //   9: aload_0
    //   10: getfield 182	com/google/android/gms/internal/zzyy:zzaMA	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 217	com/google/android/gms/internal/zzyy:zzaMz	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 230 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 67	com/google/android/gms/internal/zzyy:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 230 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzyy
    //   20	20	1	bool	boolean
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    if ((this.zzaMw) && (zzd(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.zzaMy.add(paramT);
      return paramT;
    }
    this.zzaMt.zzaNz.zzb(paramT);
    return ((zzyx)this.zzaMq.get(paramT.zzwS())).doRead(paramT);
  }
  
  public boolean zza(zzaah paramzzaah)
  {
    this.zzaMk.lock();
    try
    {
      if ((this.zzaMz) && (!zzxz()))
      {
        this.zzaKC.zzxj();
        this.zzaMC = new zzb(paramzzaah);
        this.zzaKC.zza(this.zzaMr.values()).addOnCompleteListener(new zzabv(this.zzrD), this.zzaMC);
        return true;
      }
      return false;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    Api.zzc localzzc = paramT.zzwS();
    if ((this.zzaMw) && (zzd(paramT))) {
      return paramT;
    }
    this.zzaMt.zzaNz.zzb(paramT);
    return ((zzyx)this.zzaMq.get(localzzc)).doWrite(paramT);
  }
  
  public void zzxa()
  {
    this.zzaMk.lock();
    try
    {
      this.zzaKC.zzxa();
      if (this.zzaMC != null)
      {
        this.zzaMC.cancel();
        this.zzaMC = null;
      }
      if (this.zzaMB == null) {
        this.zzaMB = new ArrayMap(this.zzaMr.size());
      }
      ConnectionResult localConnectionResult = new ConnectionResult(4);
      Iterator localIterator = this.zzaMr.values().iterator();
      while (localIterator.hasNext())
      {
        zzyx localzzyx = (zzyx)localIterator.next();
        this.zzaMB.put(localzzyx.getApiKey(), localConnectionResult);
      }
      if (this.zzaMA == null) {
        break label155;
      }
    }
    finally
    {
      this.zzaMk.unlock();
    }
    this.zzaMA.putAll(this.zzaMB);
    label155:
    this.zzaMk.unlock();
  }
  
  public void zzxy() {}
  
  public boolean zzxz()
  {
    this.zzaMk.lock();
    try
    {
      boolean bool;
      if (this.zzaMz)
      {
        bool = this.zzaMw;
        if (bool) {}
      }
      else
      {
        return false;
      }
      Iterator localIterator = this.zzaMr.keySet().iterator();
      while (localIterator.hasNext())
      {
        ConnectionResult localConnectionResult = zzb((Api.zzc)localIterator.next());
        if (localConnectionResult != null)
        {
          bool = localConnectionResult.isSuccess();
          if (bool) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  private class zza
    implements OnCompleteListener<Void>
  {
    private zza() {}
    
    public void onComplete(@NonNull Task<Void> paramTask)
    {
      zzyy.zza(zzyy.this).lock();
      Object localObject;
      try
      {
        boolean bool = zzyy.zzb(zzyy.this);
        if (!bool) {
          return;
        }
        if (paramTask.isSuccessful())
        {
          zzyy.zza(zzyy.this, new ArrayMap(zzyy.zzc(zzyy.this).size()));
          paramTask = zzyy.zzc(zzyy.this).values().iterator();
          while (paramTask.hasNext())
          {
            localObject = (zzyx)paramTask.next();
            zzyy.zzd(zzyy.this).put(((zzyx)localObject).getApiKey(), ConnectionResult.zzaJO);
          }
        }
        if (!(paramTask.getException() instanceof zzb)) {
          break label435;
        }
      }
      finally
      {
        zzyy.zza(zzyy.this).unlock();
      }
      paramTask = (zzb)paramTask.getException();
      if (zzyy.zze(zzyy.this))
      {
        zzyy.zza(zzyy.this, new ArrayMap(zzyy.zzc(zzyy.this).size()));
        localObject = zzyy.zzc(zzyy.this).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          zzyx localzzyx = (zzyx)((Iterator)localObject).next();
          zzyn localzzyn = localzzyx.getApiKey();
          ConnectionResult localConnectionResult = paramTask.zza(localzzyx);
          if (zzyy.zza(zzyy.this, localzzyx, localConnectionResult)) {
            zzyy.zzd(zzyy.this).put(localzzyn, new ConnectionResult(16));
          } else {
            zzyy.zzd(zzyy.this).put(localzzyn, localConnectionResult);
          }
        }
      }
      zzyy.zza(zzyy.this, paramTask.zzwV());
      zzyy.zza(zzyy.this, zzyy.zzf(zzyy.this));
      if (zzyy.zzg(zzyy.this) != null)
      {
        zzyy.zzd(zzyy.this).putAll(zzyy.zzg(zzyy.this));
        zzyy.zza(zzyy.this, zzyy.zzf(zzyy.this));
      }
      if (zzyy.zzh(zzyy.this) == null)
      {
        zzyy.zzi(zzyy.this);
        zzyy.zzj(zzyy.this);
      }
      for (;;)
      {
        zzyy.zzl(zzyy.this).signalAll();
        zzyy.zza(zzyy.this).unlock();
        return;
        label435:
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zzyy.zza(zzyy.this, Collections.emptyMap());
        zzyy.zza(zzyy.this, new ConnectionResult(8));
        break;
        zzyy.zza(zzyy.this, false);
        zzyy.zzk(zzyy.this).zzc(zzyy.zzh(zzyy.this));
      }
    }
  }
  
  private class zzb
    implements OnCompleteListener<Void>
  {
    private zzaah zzaMF;
    
    zzb(zzaah paramzzaah)
    {
      this.zzaMF = paramzzaah;
    }
    
    void cancel()
    {
      this.zzaMF.zzqO();
    }
    
    public void onComplete(@NonNull Task<Void> paramTask)
    {
      zzyy.zza(zzyy.this).lock();
      Object localObject;
      try
      {
        if (!zzyy.zzb(zzyy.this))
        {
          this.zzaMF.zzqO();
          return;
        }
        if (paramTask.isSuccessful())
        {
          zzyy.zzb(zzyy.this, new ArrayMap(zzyy.zzm(zzyy.this).size()));
          paramTask = zzyy.zzm(zzyy.this).values().iterator();
          while (paramTask.hasNext())
          {
            localObject = (zzyx)paramTask.next();
            zzyy.zzg(zzyy.this).put(((zzyx)localObject).getApiKey(), ConnectionResult.zzaJO);
          }
        }
        if (!(paramTask.getException() instanceof zzb)) {
          break label417;
        }
      }
      finally
      {
        zzyy.zza(zzyy.this).unlock();
      }
      paramTask = (zzb)paramTask.getException();
      if (zzyy.zze(zzyy.this))
      {
        zzyy.zzb(zzyy.this, new ArrayMap(zzyy.zzm(zzyy.this).size()));
        localObject = zzyy.zzm(zzyy.this).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          zzyx localzzyx = (zzyx)((Iterator)localObject).next();
          zzyn localzzyn = localzzyx.getApiKey();
          ConnectionResult localConnectionResult = paramTask.zza(localzzyx);
          if (zzyy.zza(zzyy.this, localzzyx, localConnectionResult)) {
            zzyy.zzg(zzyy.this).put(localzzyn, new ConnectionResult(16));
          } else {
            zzyy.zzg(zzyy.this).put(localzzyn, localConnectionResult);
          }
        }
      }
      zzyy.zzb(zzyy.this, paramTask.zzwV());
      for (;;)
      {
        if (zzyy.this.isConnected())
        {
          zzyy.zzd(zzyy.this).putAll(zzyy.zzg(zzyy.this));
          if (zzyy.zzf(zzyy.this) == null)
          {
            zzyy.zzi(zzyy.this);
            zzyy.zzj(zzyy.this);
            zzyy.zzl(zzyy.this).signalAll();
          }
        }
        this.zzaMF.zzqO();
        zzyy.zza(zzyy.this).unlock();
        return;
        label417:
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zzyy.zzb(zzyy.this, Collections.emptyMap());
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */