package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzzj
  implements zzyv, zzzq
{
  private final Context mContext;
  final Api.zza<? extends zzbgc, zzbgd> zzaKT;
  final zzzh zzaMa;
  private final Lock zzaMk;
  final zzg zzaMp;
  final Map<Api<?>, Boolean> zzaMs;
  private final GoogleApiAvailabilityLight zzaMu;
  private final Condition zzaNG;
  private final zzb zzaNH;
  final Map<Api.zzc<?>, ConnectionResult> zzaNI = new HashMap();
  private volatile zzzi zzaNJ;
  private ConnectionResult zzaNK = null;
  int zzaNL;
  final zzzq.zza zzaNM;
  final Map<Api.zzc<?>, Api.zze> zzaNt;
  
  public zzzj(Context paramContext, zzzh paramzzzh, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Boolean> paramMap1, Api.zza<? extends zzbgc, zzbgd> paramzza, ArrayList<zzyu> paramArrayList, zzzq.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zzaMk = paramLock;
    this.zzaMu = paramGoogleApiAvailabilityLight;
    this.zzaNt = paramMap;
    this.zzaMp = paramzzg;
    this.zzaMs = paramMap1;
    this.zzaKT = paramzza;
    this.zzaMa = paramzzzh;
    this.zzaNM = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzyu)paramContext.next()).zza(this);
    }
    this.zzaNH = new zzb(paramLooper);
    this.zzaNG = paramLock.newCondition();
    this.zzaNJ = new zzzg(this);
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        this.zzaNG.await();
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
    if (this.zzaNK != null) {
      return this.zzaNK;
    }
    return new ConnectionResult(13, null);
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzaNG.awaitNanos(paramLong))
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
    if (this.zzaNK != null) {
      return this.zzaNK;
    }
    return new ConnectionResult(13, null);
  }
  
  public void connect()
  {
    this.zzaNJ.connect();
  }
  
  public void disconnect()
  {
    if (this.zzaNJ.disconnect()) {
      this.zzaNI.clear();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.zzaNJ);
    Iterator localIterator = this.zzaMs.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zze)this.zzaNt.get(localApi.zzwS())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    paramApi = paramApi.zzwS();
    if (this.zzaNt.containsKey(paramApi))
    {
      if (((Api.zze)this.zzaNt.get(paramApi)).isConnected()) {
        return ConnectionResult.zzaJO;
      }
      if (this.zzaNI.containsKey(paramApi)) {
        return (ConnectionResult)this.zzaNI.get(paramApi);
      }
    }
    return null;
  }
  
  public boolean isConnected()
  {
    return this.zzaNJ instanceof zzze;
  }
  
  public boolean isConnecting()
  {
    return this.zzaNJ instanceof zzzf;
  }
  
  public void onConnected(@Nullable Bundle paramBundle)
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNJ.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNJ.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    paramT.zzxu();
    return this.zzaNJ.zza(paramT);
  }
  
  public void zza(@NonNull ConnectionResult paramConnectionResult, @NonNull Api<?> paramApi, boolean paramBoolean)
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNJ.zza(paramConnectionResult, paramApi, paramBoolean);
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  void zza(zza paramzza)
  {
    paramzza = this.zzaNH.obtainMessage(1, paramzza);
    this.zzaNH.sendMessage(paramzza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zzaNH.obtainMessage(2, paramRuntimeException);
    this.zzaNH.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(zzaah paramzzaah)
  {
    return false;
  }
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    paramT.zzxu();
    return this.zzaNJ.zzb(paramT);
  }
  
  void zzh(ConnectionResult paramConnectionResult)
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNK = paramConnectionResult;
      this.zzaNJ = new zzzg(this);
      this.zzaNJ.begin();
      this.zzaNG.signalAll();
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  public void zzxa() {}
  
  public void zzxy()
  {
    if (isConnected()) {
      ((zzze)this.zzaNJ).zzxP();
    }
  }
  
  void zzye()
  {
    this.zzaMk.lock();
    try
    {
      this.zzaNJ = new zzzf(this, this.zzaMp, this.zzaMs, this.zzaMu, this.zzaKT, this.zzaMk, this.mContext);
      this.zzaNJ.begin();
      this.zzaNG.signalAll();
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  void zzyf()
  {
    this.zzaMk.lock();
    try
    {
      this.zzaMa.zzyb();
      this.zzaNJ = new zzze(this);
      this.zzaNJ.begin();
      this.zzaNG.signalAll();
      return;
    }
    finally
    {
      this.zzaMk.unlock();
    }
  }
  
  void zzyg()
  {
    Iterator localIterator = this.zzaNt.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
  }
  
  static abstract class zza
  {
    private final zzzi zzaNN;
    
    protected zza(zzzi paramzzzi)
    {
      this.zzaNN = paramzzzi;
    }
    
    public final void zzc(zzzj paramzzzj)
    {
      zzzj.zza(paramzzzj).lock();
      try
      {
        zzzi localzzzi1 = zzzj.zzb(paramzzzj);
        zzzi localzzzi2 = this.zzaNN;
        if (localzzzi1 != localzzzi2) {
          return;
        }
        zzxQ();
        return;
      }
      finally
      {
        zzzj.zza(paramzzzj).unlock();
      }
    }
    
    protected abstract void zzxQ();
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.w("GACStateManager", 31 + "Unknown message id: " + i);
        return;
      case 1: 
        ((zzzj.zza)paramMessage.obj).zzc(zzzj.this);
        return;
      }
      throw ((RuntimeException)paramMessage.obj);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */