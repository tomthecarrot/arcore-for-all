package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
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
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzyw
  implements zzzq
{
  private final Context mContext;
  private final zzzh zzaMa;
  private final zzzj zzaMb;
  private final zzzj zzaMc;
  private final Map<Api.zzc<?>, zzzj> zzaMd;
  private final Set<zzaah> zzaMe = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zze zzaMf;
  private Bundle zzaMg;
  private ConnectionResult zzaMh = null;
  private ConnectionResult zzaMi = null;
  private boolean zzaMj = false;
  private final Lock zzaMk;
  private int zzaMl = 0;
  private final Looper zzrD;
  
  private zzyw(Context paramContext, zzzh paramzzzh, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.zzc<?>, Api.zze> paramMap1, Map<Api.zzc<?>, Api.zze> paramMap2, zzg paramzzg, Api.zza<? extends zzbgc, zzbgd> paramzza, Api.zze paramzze, ArrayList<zzyu> paramArrayList1, ArrayList<zzyu> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4)
  {
    this.mContext = paramContext;
    this.zzaMa = paramzzzh;
    this.zzaMk = paramLock;
    this.zzrD = paramLooper;
    this.zzaMf = paramzze;
    this.zzaMb = new zzzj(paramContext, this.zzaMa, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zza(null));
    this.zzaMc = new zzzj(paramContext, this.zzaMa, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramzzg, paramMap3, paramzza, paramArrayList1, new zzb(null));
    paramContext = new ArrayMap();
    paramzzzh = paramMap2.keySet().iterator();
    while (paramzzzh.hasNext()) {
      paramContext.put((Api.zzc)paramzzzh.next(), this.zzaMb);
    }
    paramzzzh = paramMap1.keySet().iterator();
    while (paramzzzh.hasNext()) {
      paramContext.put((Api.zzc)paramzzzh.next(), this.zzaMc);
    }
    this.zzaMd = Collections.unmodifiableMap(paramContext);
  }
  
  public static zzyw zza(Context paramContext, zzzh paramzzzh, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.zzc<?>, Api.zze> paramMap, zzg paramzzg, Map<Api<?>, Boolean> paramMap1, Api.zza<? extends zzbgc, zzbgd> paramzza, ArrayList<zzyu> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzqP()) {
        paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
      }
      if (((Api.zze)localObject1).zzqB()) {
        localArrayMap1.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap2.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    boolean bool;
    if (!localArrayMap1.isEmpty())
    {
      bool = true;
      zzac.zza(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new ArrayMap();
      localObject2 = new ArrayMap();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Api)((Iterator)localObject3).next();
        Api.zzc localzzc = ((Api)localObject4).zzwS();
        if (localArrayMap1.containsKey(localzzc))
        {
          ((Map)localObject1).put(localObject4, (Boolean)paramMap1.get(localObject4));
          continue;
          bool = false;
          break;
        }
        if (localArrayMap2.containsKey(localzzc)) {
          ((Map)localObject2).put(localObject4, (Boolean)paramMap1.get(localObject4));
        } else {
          throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject4 = (zzyu)paramArrayList.next();
      if (((Map)localObject1).containsKey(((zzyu)localObject4).zzaHI)) {
        paramMap1.add(localObject4);
      } else if (((Map)localObject2).containsKey(((zzyu)localObject4).zzaHI)) {
        ((ArrayList)localObject3).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
      }
    }
    return new zzyw(paramContext, paramzzzh, paramLock, paramLooper, paramGoogleApiAvailabilityLight, localArrayMap1, localArrayMap2, paramzzg, paramzza, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  private void zza(ConnectionResult paramConnectionResult)
  {
    switch (this.zzaMl)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzaMl = 0;
      return;
      this.zzaMa.zzc(paramConnectionResult);
      zzxD();
    }
  }
  
  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private boolean zzc(zzyr.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = paramzza.zzwS();
    zzac.zzb(this.zzaMd.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzzj)this.zzaMd.get(paramzza)).equals(this.zzaMc);
  }
  
  private void zze(int paramInt, boolean paramBoolean)
  {
    this.zzaMa.zzf(paramInt, paramBoolean);
    this.zzaMi = null;
    this.zzaMh = null;
  }
  
  private void zzt(Bundle paramBundle)
  {
    if (this.zzaMg == null) {
      this.zzaMg = paramBundle;
    }
    while (paramBundle == null) {
      return;
    }
    this.zzaMg.putAll(paramBundle);
  }
  
  private void zzxA()
  {
    this.zzaMi = null;
    this.zzaMh = null;
    this.zzaMb.connect();
    this.zzaMc.connect();
  }
  
  private void zzxB()
  {
    if (zzb(this.zzaMh)) {
      if ((zzb(this.zzaMi)) || (zzxE())) {
        zzxC();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.zzaMi == null);
      if (this.zzaMl == 1)
      {
        zzxD();
        return;
      }
      zza(this.zzaMi);
      this.zzaMb.disconnect();
      return;
      if ((this.zzaMh != null) && (zzb(this.zzaMi)))
      {
        this.zzaMc.disconnect();
        zza(this.zzaMh);
        return;
      }
    } while ((this.zzaMh == null) || (this.zzaMi == null));
    ConnectionResult localConnectionResult = this.zzaMh;
    if (this.zzaMc.zzaNL < this.zzaMb.zzaNL) {
      localConnectionResult = this.zzaMi;
    }
    zza(localConnectionResult);
  }
  
  private void zzxC()
  {
    switch (this.zzaMl)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
    }
    for (;;)
    {
      this.zzaMl = 0;
      return;
      this.zzaMa.zzu(this.zzaMg);
      zzxD();
    }
  }
  
  private void zzxD()
  {
    Iterator localIterator = this.zzaMe.iterator();
    while (localIterator.hasNext()) {
      ((zzaah)localIterator.next()).zzqO();
    }
    this.zzaMe.clear();
  }
  
  private boolean zzxE()
  {
    return (this.zzaMi != null) && (this.zzaMi.getErrorCode() == 4);
  }
  
  @Nullable
  private PendingIntent zzxF()
  {
    if (this.zzaMf == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, this.zzaMa.getSessionId(), this.zzaMf.zzqQ(), 134217728);
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void connect()
  {
    this.zzaMl = 2;
    this.zzaMj = false;
    zzxA();
  }
  
  public void disconnect()
  {
    this.zzaMi = null;
    this.zzaMh = null;
    this.zzaMl = 0;
    this.zzaMb.disconnect();
    this.zzaMc.disconnect();
    zzxD();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zzaMc.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zzaMb.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    if (((zzzj)this.zzaMd.get(paramApi.zzwS())).equals(this.zzaMc))
    {
      if (zzxE()) {
        return new ConnectionResult(4, zzxF());
      }
      return this.zzaMc.getConnectionResult(paramApi);
    }
    return this.zzaMb.getConnectionResult(paramApi);
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 387 1 0
    //   11: aload_0
    //   12: getfield 86	com/google/android/gms/internal/zzyw:zzaMb	Lcom/google/android/gms/internal/zzzj;
    //   15: invokevirtual 389	com/google/android/gms/internal/zzzj:isConnected	()Z
    //   18: ifeq +44 -> 62
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 392	com/google/android/gms/internal/zzyw:zzxz	()Z
    //   27: ifne +24 -> 51
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: invokespecial 281	com/google/android/gms/internal/zzyw:zzxE	()Z
    //   36: ifne +15 -> 51
    //   39: aload_0
    //   40: getfield 66	com/google/android/gms/internal/zzyw:zzaMl	I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +16 -> 62
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 395 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -13 -> 51
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 395 1 0
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzyw
    //   43	4	1	i	int
    //   22	42	2	bool1	boolean
    //   1	49	3	bool2	boolean
    //   67	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	67	finally
    //   23	30	67	finally
    //   32	44	67	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: getfield 66	com/google/android/gms/internal/zzyw:zzaMl	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 395 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 395 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zzyw
    //   13	4	1	i	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT)
  {
    if (zzc(paramT))
    {
      if (zzxE())
      {
        paramT.zzP(new Status(4, null, zzxF()));
        return paramT;
      }
      return this.zzaMc.zza(paramT);
    }
    return this.zzaMb.zza(paramT);
  }
  
  public boolean zza(zzaah paramzzaah)
  {
    this.zzaMk.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzxz()))
      {
        this.zzaMe.add(paramzzaah);
        if (this.zzaMl == 0) {
          this.zzaMl = 1;
        }
        this.zzaMi = null;
        this.zzaMc.connect();
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
    if (zzc(paramT))
    {
      if (zzxE())
      {
        paramT.zzP(new Status(4, null, zzxF()));
        return paramT;
      }
      return this.zzaMc.zzb(paramT);
    }
    return this.zzaMb.zzb(paramT);
  }
  
  /* Error */
  public void zzxa()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: invokevirtual 414	com/google/android/gms/internal/zzyw:isConnecting	()Z
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 89	com/google/android/gms/internal/zzyw:zzaMc	Lcom/google/android/gms/internal/zzzj;
    //   18: invokevirtual 289	com/google/android/gms/internal/zzzj:disconnect	()V
    //   21: aload_0
    //   22: new 243	com/google/android/gms/common/ConnectionResult
    //   25: dup
    //   26: iconst_4
    //   27: invokespecial 423	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   30: putfield 62	com/google/android/gms/internal/zzyw:zzaMi	Lcom/google/android/gms/common/ConnectionResult;
    //   33: iload_1
    //   34: ifeq +36 -> 70
    //   37: new 425	android/os/Handler
    //   40: dup
    //   41: aload_0
    //   42: getfield 74	com/google/android/gms/internal/zzyw:zzrD	Landroid/os/Looper;
    //   45: invokespecial 428	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   48: new 8	com/google/android/gms/internal/zzyw$1
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 430	com/google/android/gms/internal/zzyw$1:<init>	(Lcom/google/android/gms/internal/zzyw;)V
    //   56: invokevirtual 434	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 395 1 0
    //   69: return
    //   70: aload_0
    //   71: invokespecial 225	com/google/android/gms/internal/zzyw:zzxD	()V
    //   74: goto -14 -> 60
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 72	com/google/android/gms/internal/zzyw:zzaMk	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 395 1 0
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzyw
    //   13	21	1	bool	boolean
    //   77	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	33	77	finally
    //   37	60	77	finally
    //   70	74	77	finally
  }
  
  public void zzxy()
  {
    this.zzaMb.zzxy();
    this.zzaMc.zzxy();
  }
  
  public boolean zzxz()
  {
    return this.zzaMc.isConnected();
  }
  
  private class zza
    implements zzzq.zza
  {
    private zza() {}
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        zzyw.zza(zzyw.this, paramConnectionResult);
        zzyw.zzb(zzyw.this);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
    
    public void zzf(int paramInt, boolean paramBoolean)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        if ((zzyw.zzc(zzyw.this)) || (zzyw.zzd(zzyw.this) == null) || (!zzyw.zzd(zzyw.this).isSuccess()))
        {
          zzyw.zza(zzyw.this, false);
          zzyw.zza(zzyw.this, paramInt, paramBoolean);
          return;
        }
        zzyw.zza(zzyw.this, true);
        zzyw.zze(zzyw.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
    
    public void zzu(@Nullable Bundle paramBundle)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        zzyw.zza(zzyw.this, paramBundle);
        zzyw.zza(zzyw.this, ConnectionResult.zzaJO);
        zzyw.zzb(zzyw.this);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
  }
  
  private class zzb
    implements zzzq.zza
  {
    private zzb() {}
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        zzyw.zzb(zzyw.this, paramConnectionResult);
        zzyw.zzb(zzyw.this);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
    
    public void zzf(int paramInt, boolean paramBoolean)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        if (zzyw.zzc(zzyw.this))
        {
          zzyw.zza(zzyw.this, false);
          zzyw.zza(zzyw.this, paramInt, paramBoolean);
          return;
        }
        zzyw.zza(zzyw.this, true);
        zzyw.zzf(zzyw.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
    
    public void zzu(@Nullable Bundle paramBundle)
    {
      zzyw.zza(zzyw.this).lock();
      try
      {
        zzyw.zzb(zzyw.this, ConnectionResult.zzaJO);
        zzyw.zzb(zzyw.this);
        return;
      }
      finally
      {
        zzyw.zza(zzyw.this).unlock();
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */