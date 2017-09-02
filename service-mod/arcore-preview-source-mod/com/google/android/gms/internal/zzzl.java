package com.google.android.gms.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zzzl
  implements Handler.Callback
{
  public static final Status zzaNQ = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status zzaNR = new Status(4, "The user must be signed in to make this API call.");
  private static zzzl zzaNT;
  private static final Object zzuq = new Object();
  private final Context mContext;
  private final Handler mHandler;
  private final GoogleApiAvailability zzaKS;
  private final Map<zzyn<?>, zza<?>> zzaMq = new ConcurrentHashMap(5, 0.75F, 1);
  private long zzaNS = 10000L;
  private int zzaNU = -1;
  private final AtomicInteger zzaNV = new AtomicInteger(1);
  private final AtomicInteger zzaNW = new AtomicInteger(0);
  private zzza zzaNX = null;
  private final Set<zzyn<?>> zzaNY = new zza();
  private final Set<zzyn<?>> zzaNZ = new zza();
  private long zzaNp = 120000L;
  private long zzaNq = 5000L;
  
  private zzzl(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
    this.zzaKS = paramGoogleApiAvailability;
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
  }
  
  @WorkerThread
  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Object localObject = this.zzaMq.values().iterator();
    zza localzza;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localzza = (zza)((Iterator)localObject).next();
    } while (localzza.getInstanceId() != paramInt);
    for (;;)
    {
      if (localzza != null)
      {
        localObject = String.valueOf(this.zzaKS.getErrorString(paramConnectionResult.getErrorCode()));
        paramConnectionResult = String.valueOf(paramConnectionResult.getErrorMessage());
        localzza.zzR(new Status(17, String.valueOf(localObject).length() + 69 + String.valueOf(paramConnectionResult).length() + "Error resolution was canceled by the user, original error message: " + (String)localObject + ": " + paramConnectionResult));
        return;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + paramInt + " while trying to fail enqueued calls.", new Exception());
      return;
      localzza = null;
    }
  }
  
  @WorkerThread
  private void zza(zzaab paramzzaab)
  {
    zza localzza2 = (zza)this.zzaMq.get(paramzzaab.zzaOK.getApiKey());
    zza localzza1 = localzza2;
    if (localzza2 == null)
    {
      zzc(paramzzaab.zzaOK);
      localzza1 = (zza)this.zzaMq.get(paramzzaab.zzaOK.getApiKey());
    }
    if ((localzza1.zzqB()) && (this.zzaNW.get() != paramzzaab.zzaOJ))
    {
      paramzzaab.zzaOI.zzN(zzaNQ);
      localzza1.signOut();
      return;
    }
    localzza1.zza(paramzzaab.zzaOI);
  }
  
  @WorkerThread
  private void zza(zzyp paramzzyp)
  {
    Iterator localIterator = paramzzyp.zzxl().iterator();
    for (;;)
    {
      zzyn localzzyn;
      zza localzza;
      if (localIterator.hasNext())
      {
        localzzyn = (zzyn)localIterator.next();
        localzza = (zza)this.zzaMq.get(localzzyn);
        if (localzza == null) {
          paramzzyp.zza(localzzyn, new ConnectionResult(13));
        }
      }
      else
      {
        return;
      }
      if (localzza.isConnected()) {
        paramzzyp.zza(localzzyn, ConnectionResult.zzaJO);
      } else if (localzza.zzyw() != null) {
        paramzzyp.zza(localzzyn, localzza.zzyw());
      } else {
        localzza.zzb(paramzzyp);
      }
    }
  }
  
  public static zzzl zzaV(Context paramContext)
  {
    synchronized (zzuq)
    {
      if (zzaNT == null)
      {
        Looper localLooper = zzyk();
        zzaNT = new zzzl(paramContext.getApplicationContext(), localLooper, GoogleApiAvailability.getInstance());
      }
      paramContext = zzaNT;
      return paramContext;
    }
  }
  
  @WorkerThread
  private void zzau(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = 10000L;; l = 300000L)
    {
      this.zzaNS = l;
      this.mHandler.removeMessages(12);
      Iterator localIterator = this.zzaMq.keySet().iterator();
      while (localIterator.hasNext())
      {
        zzyn localzzyn = (zzyn)localIterator.next();
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, localzzyn), this.zzaNS);
      }
    }
  }
  
  @WorkerThread
  private void zzc(zzd<?> paramzzd)
  {
    zzyn localzzyn = paramzzd.getApiKey();
    zza localzza2 = (zza)this.zzaMq.get(localzzyn);
    zza localzza1 = localzza2;
    if (localzza2 == null)
    {
      localzza1 = new zza(paramzzd);
      this.zzaMq.put(localzzyn, localzza1);
    }
    if (localzza1.zzqB()) {
      this.zzaNZ.add(localzzyn);
    }
    localzza1.connect();
  }
  
  public static zzzl zzyi()
  {
    synchronized (zzuq)
    {
      zzac.zzb(zzaNT, "Must guarantee manager is non-null before using getInstance");
      zzzl localzzzl = zzaNT;
      return localzzzl;
    }
  }
  
  public static void zzyj()
  {
    synchronized (zzuq)
    {
      if (zzaNT != null) {
        zzaNT.signOut();
      }
      return;
    }
  }
  
  private static Looper zzyk()
  {
    HandlerThread localHandlerThread = new HandlerThread("GoogleApiHandler", 9);
    localHandlerThread.start();
    return localHandlerThread.getLooper();
  }
  
  @WorkerThread
  private void zzym()
  {
    zzt.zzAR();
    if ((this.mContext.getApplicationContext() instanceof Application))
    {
      zzyq.zza((Application)this.mContext.getApplicationContext());
      zzyq.zzxn().zza(new zzyq.zza()
      {
        public void zzas(boolean paramAnonymousBoolean)
        {
          zzzl.zza(zzzl.this).sendMessage(zzzl.zza(zzzl.this).obtainMessage(1, Boolean.valueOf(paramAnonymousBoolean)));
        }
      });
      if (!zzyq.zzxn().zzar(true)) {
        this.zzaNS = 300000L;
      }
    }
  }
  
  @WorkerThread
  private void zzyn()
  {
    Iterator localIterator = this.zzaMq.values().iterator();
    while (localIterator.hasNext())
    {
      zza localzza = (zza)localIterator.next();
      localzza.zzyv();
      localzza.connect();
    }
  }
  
  @WorkerThread
  private void zzyo()
  {
    Iterator localIterator = this.zzaNZ.iterator();
    while (localIterator.hasNext())
    {
      zzyn localzzyn = (zzyn)localIterator.next();
      ((zza)this.zzaMq.remove(localzzyn)).signOut();
    }
    this.zzaNZ.clear();
  }
  
  @WorkerThread
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      Log.w("GoogleApiManager", 31 + "Unknown message id: " + i);
      return false;
    case 1: 
      zzau(((Boolean)paramMessage.obj).booleanValue());
    }
    for (;;)
    {
      return true;
      zza((zzyp)paramMessage.obj);
      continue;
      zzyn();
      continue;
      zza((zzaab)paramMessage.obj);
      continue;
      zza(paramMessage.arg1, (ConnectionResult)paramMessage.obj);
      continue;
      zzym();
      continue;
      zzc((zzd)paramMessage.obj);
      continue;
      if (this.zzaMq.containsKey(paramMessage.obj))
      {
        ((zza)this.zzaMq.get(paramMessage.obj)).resume();
        continue;
        zzyo();
        continue;
        if (this.zzaMq.containsKey(paramMessage.obj))
        {
          ((zza)this.zzaMq.get(paramMessage.obj)).zzxZ();
          continue;
          if (this.zzaMq.containsKey(paramMessage.obj)) {
            ((zza)this.zzaMq.get(paramMessage.obj)).zzyz();
          }
        }
      }
    }
  }
  
  public void signOut()
  {
    this.zzaNW.incrementAndGet();
    this.mHandler.sendMessageAtFrontOfQueue(this.mHandler.obtainMessage(10));
  }
  
  PendingIntent zza(zzyn<?> paramzzyn, int paramInt)
  {
    if ((zza)this.zzaMq.get(paramzzyn) == null) {
      return null;
    }
    paramzzyn = ((zza)this.zzaMq.get(paramzzyn)).zzyA();
    if (paramzzyn == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, paramInt, paramzzyn.zzqQ(), 134217728);
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(@NonNull zzd<O> paramzzd, @NonNull zzaac<Api.zzb, ?> paramzzaac, @NonNull zzaas<Api.zzb, ?> paramzzaas)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramzzaac = new zzyl.zzc(new zzaad(paramzzaac, paramzzaas), localTaskCompletionSource);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(8, new zzaab(paramzzaac, this.zzaNW.get(), paramzzd)));
    return localTaskCompletionSource.getTask();
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(@NonNull zzd<O> paramzzd, @NonNull zzzw.zzb<?> paramzzb)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramzzb = new zzyl.zze(paramzzb, localTaskCompletionSource);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(13, new zzaab(paramzzb, this.zzaNW.get(), paramzzd)));
    return localTaskCompletionSource.getTask();
  }
  
  public Task<Void> zza(Iterable<? extends zzd<?>> paramIterable)
  {
    zzyp localzzyp = new zzyp(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (zzd)paramIterable.next();
      localObject = (zza)this.zzaMq.get(((zzd)localObject).getApiKey());
      if ((localObject == null) || (!((zza)localObject).isConnected()))
      {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, localzzyp));
        return localzzyp.getTask();
      }
    }
    localzzyp.zzxm();
    return localzzyp.getTask();
  }
  
  public void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zzc(paramConnectionResult, paramInt)) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public <O extends Api.ApiOptions, TResult> void zza(zzd<O> paramzzd, int paramInt, zzaao<Api.zzb, TResult> paramzzaao, TaskCompletionSource<TResult> paramTaskCompletionSource, zzaak paramzzaak)
  {
    paramzzaao = new zzyl.zzd(paramInt, paramzzaao, paramTaskCompletionSource, paramzzaak);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzaab(paramzzaao, this.zzaNW.get(), paramzzd)));
  }
  
  public <O extends Api.ApiOptions> void zza(zzd<O> paramzzd, int paramInt, zzyr.zza<? extends Result, Api.zzb> paramzza)
  {
    paramzza = new zzyl.zzb(paramInt, paramzza);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzaab(paramzza, this.zzaNW.get(), paramzzd)));
  }
  
  public void zza(@NonNull zzza paramzzza)
  {
    synchronized (zzuq)
    {
      if (this.zzaNX != paramzzza)
      {
        this.zzaNX = paramzzza;
        this.zzaNY.clear();
        this.zzaNY.addAll(paramzzza.zzxN());
      }
      return;
    }
  }
  
  public void zzb(zzd<?> paramzzd)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramzzd));
  }
  
  void zzb(@NonNull zzza paramzzza)
  {
    synchronized (zzuq)
    {
      if (this.zzaNX == paramzzza)
      {
        this.zzaNX = null;
        this.zzaNY.clear();
      }
      return;
    }
  }
  
  boolean zzc(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.zzaKS.zza(this.mContext, paramConnectionResult, paramInt);
  }
  
  void zzxa()
  {
    this.zzaNW.incrementAndGet();
    this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
  }
  
  public void zzxj()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
  }
  
  public int zzyl()
  {
    return this.zzaNV.getAndIncrement();
  }
  
  public class zza<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzyv
  {
    private final zzyn<O> zzaKz;
    private final Api.zze zzaMn;
    private boolean zzaNo;
    private final Queue<zzyl> zzaOb = new LinkedList();
    private final Api.zzb zzaOc;
    private final zzyz zzaOd;
    private final Set<zzyp> zzaOe = new HashSet();
    private final Map<zzzw.zzb<?>, zzaad> zzaOf = new HashMap();
    private final int zzaOg;
    private final zzaai zzaOh;
    private ConnectionResult zzaOi = null;
    
    @WorkerThread
    public zza()
    {
      Object localObject;
      this.zzaMn = ((zzd)localObject).buildApiClient(zzzl.zza(zzzl.this).getLooper(), this);
      if ((this.zzaMn instanceof zzal)) {}
      for (this.zzaOc = ((zzal)this.zzaMn).zzAh();; this.zzaOc = this.zzaMn)
      {
        this.zzaKz = ((zzd)localObject).getApiKey();
        this.zzaOd = new zzyz();
        this.zzaOg = ((zzd)localObject).getInstanceId();
        if (!this.zzaMn.zzqB()) {
          break;
        }
        this.zzaOh = ((zzd)localObject).createSignInCoordinator(zzzl.zzb(zzzl.this), zzzl.zza(zzzl.this));
        return;
      }
      this.zzaOh = null;
    }
    
    @WorkerThread
    private void zzb(zzyl paramzzyl)
    {
      paramzzyl.zza(this.zzaOd, zzqB());
      try
      {
        paramzzyl.zza(this);
        return;
      }
      catch (DeadObjectException paramzzyl)
      {
        onConnectionSuspended(1);
        this.zzaMn.disconnect();
      }
    }
    
    @WorkerThread
    private void zzj(ConnectionResult paramConnectionResult)
    {
      Iterator localIterator = this.zzaOe.iterator();
      while (localIterator.hasNext()) {
        ((zzyp)localIterator.next()).zza(this.zzaKz, paramConnectionResult);
      }
      this.zzaOe.clear();
    }
    
    @WorkerThread
    private void zzyr()
    {
      zzyv();
      zzj(ConnectionResult.zzaJO);
      zzyx();
      Iterator localIterator = this.zzaOf.values().iterator();
      for (;;)
      {
        zzaad localzzaad;
        if (localIterator.hasNext()) {
          localzzaad = (zzaad)localIterator.next();
        }
        try
        {
          localzzaad.zzaLk.zzb(this.zzaOc, new TaskCompletionSource());
        }
        catch (DeadObjectException localDeadObjectException)
        {
          onConnectionSuspended(1);
          this.zzaMn.disconnect();
          zzyt();
          zzyy();
          return;
        }
        catch (RemoteException localRemoteException) {}
      }
    }
    
    @WorkerThread
    private void zzys()
    {
      zzyv();
      this.zzaNo = true;
      this.zzaOd.zzxM();
      zzzl.zza(zzzl.this).sendMessageDelayed(Message.obtain(zzzl.zza(zzzl.this), 9, this.zzaKz), zzzl.zzc(zzzl.this));
      zzzl.zza(zzzl.this).sendMessageDelayed(Message.obtain(zzzl.zza(zzzl.this), 11, this.zzaKz), zzzl.zzd(zzzl.this));
      zzzl.zza(zzzl.this, -1);
    }
    
    @WorkerThread
    private void zzyt()
    {
      while ((this.zzaMn.isConnected()) && (!this.zzaOb.isEmpty())) {
        zzb((zzyl)this.zzaOb.remove());
      }
    }
    
    @WorkerThread
    private void zzyx()
    {
      if (this.zzaNo)
      {
        zzzl.zza(zzzl.this).removeMessages(11, this.zzaKz);
        zzzl.zza(zzzl.this).removeMessages(9, this.zzaKz);
        this.zzaNo = false;
      }
    }
    
    private void zzyy()
    {
      zzzl.zza(zzzl.this).removeMessages(12, this.zzaKz);
      zzzl.zza(zzzl.this).sendMessageDelayed(zzzl.zza(zzzl.this).obtainMessage(12, this.zzaKz), zzzl.zzh(zzzl.this));
    }
    
    @WorkerThread
    public void connect()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if ((this.zzaMn.isConnected()) || (this.zzaMn.isConnecting())) {
        return;
      }
      if ((this.zzaMn.zzwT()) && (zzzl.zzi(zzzl.this) != 0))
      {
        zzzl.zza(zzzl.this, zzzl.zzg(zzzl.this).isGooglePlayServicesAvailable(zzzl.zzb(zzzl.this)));
        if (zzzl.zzi(zzzl.this) != 0)
        {
          onConnectionFailed(new ConnectionResult(zzzl.zzi(zzzl.this), null));
          return;
        }
      }
      zzzl.zzb localzzb = new zzzl.zzb(zzzl.this, this.zzaMn, this.zzaKz);
      if (this.zzaMn.zzqB()) {
        this.zzaOh.zza(localzzb);
      }
      this.zzaMn.zza(localzzb);
    }
    
    public int getInstanceId()
    {
      return this.zzaOg;
    }
    
    boolean isConnected()
    {
      return this.zzaMn.isConnected();
    }
    
    public void onConnected(@Nullable Bundle paramBundle)
    {
      if (Looper.myLooper() == zzzl.zza(zzzl.this).getLooper())
      {
        zzyr();
        return;
      }
      zzzl.zza(zzzl.this).post(new Runnable()
      {
        public void run()
        {
          zzzl.zza.zzc(zzzl.zza.this);
        }
      });
    }
    
    @WorkerThread
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if (this.zzaOh != null) {
        this.zzaOh.zzyN();
      }
      zzyv();
      zzzl.zza(zzzl.this, -1);
      zzj(paramConnectionResult);
      if (paramConnectionResult.getErrorCode() == 4) {
        zzR(zzzl.zzyp());
      }
      do
      {
        return;
        if (this.zzaOb.isEmpty())
        {
          this.zzaOi = paramConnectionResult;
          return;
        }
        synchronized (zzzl.zzyq())
        {
          if ((zzzl.zze(zzzl.this) != null) && (zzzl.zzf(zzzl.this).contains(this.zzaKz)))
          {
            zzzl.zze(zzzl.this).zzb(paramConnectionResult, this.zzaOg);
            return;
          }
        }
      } while (zzzl.this.zzc(paramConnectionResult, this.zzaOg));
      if (paramConnectionResult.getErrorCode() == 18) {
        this.zzaNo = true;
      }
      if (this.zzaNo)
      {
        zzzl.zza(zzzl.this).sendMessageDelayed(Message.obtain(zzzl.zza(zzzl.this), 9, this.zzaKz), zzzl.zzc(zzzl.this));
        return;
      }
      paramConnectionResult = String.valueOf(this.zzaKz.zzxi());
      zzR(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      if (Looper.myLooper() == zzzl.zza(zzzl.this).getLooper())
      {
        zzys();
        return;
      }
      zzzl.zza(zzzl.this).post(new Runnable()
      {
        public void run()
        {
          zzzl.zza.zzd(zzzl.zza.this);
        }
      });
    }
    
    @WorkerThread
    public void resume()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if (this.zzaNo) {
        connect();
      }
    }
    
    @WorkerThread
    public void signOut()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      zzR(zzzl.zzaNQ);
      this.zzaOd.zzxL();
      Iterator localIterator = this.zzaOf.keySet().iterator();
      while (localIterator.hasNext()) {
        zza(new zzyl.zze((zzzw.zzb)localIterator.next(), new TaskCompletionSource()));
      }
      zzj(new ConnectionResult(4));
      this.zzaMn.disconnect();
    }
    
    @WorkerThread
    public void zzR(Status paramStatus)
    {
      zzac.zza(zzzl.zza(zzzl.this));
      Iterator localIterator = this.zzaOb.iterator();
      while (localIterator.hasNext()) {
        ((zzyl)localIterator.next()).zzN(paramStatus);
      }
      this.zzaOb.clear();
    }
    
    public void zza(final ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
    {
      if (Looper.myLooper() == zzzl.zza(zzzl.this).getLooper())
      {
        onConnectionFailed(paramConnectionResult);
        return;
      }
      zzzl.zza(zzzl.this).post(new Runnable()
      {
        public void run()
        {
          zzzl.zza.this.onConnectionFailed(paramConnectionResult);
        }
      });
    }
    
    @WorkerThread
    public void zza(zzyl paramzzyl)
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if (this.zzaMn.isConnected())
      {
        zzb(paramzzyl);
        zzyy();
        return;
      }
      this.zzaOb.add(paramzzyl);
      if ((this.zzaOi != null) && (this.zzaOi.hasResolution()))
      {
        onConnectionFailed(this.zzaOi);
        return;
      }
      connect();
    }
    
    @WorkerThread
    public void zzb(zzyp paramzzyp)
    {
      zzac.zza(zzzl.zza(zzzl.this));
      this.zzaOe.add(paramzzyp);
    }
    
    @WorkerThread
    public void zzi(@NonNull ConnectionResult paramConnectionResult)
    {
      zzac.zza(zzzl.zza(zzzl.this));
      this.zzaMn.disconnect();
      onConnectionFailed(paramConnectionResult);
    }
    
    public boolean zzqB()
    {
      return this.zzaMn.zzqB();
    }
    
    public Api.zze zzxG()
    {
      return this.zzaMn;
    }
    
    @WorkerThread
    public void zzxZ()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if (this.zzaNo)
      {
        zzyx();
        if (zzzl.zzg(zzzl.this).isGooglePlayServicesAvailable(zzzl.zzb(zzzl.this)) != 18) {
          break label71;
        }
      }
      label71:
      for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
      {
        zzR(localStatus);
        this.zzaMn.disconnect();
        return;
      }
    }
    
    zzbgc zzyA()
    {
      if (this.zzaOh == null) {
        return null;
      }
      return this.zzaOh.zzyA();
    }
    
    public Map<zzzw.zzb<?>, zzaad> zzyu()
    {
      return this.zzaOf;
    }
    
    @WorkerThread
    public void zzyv()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      this.zzaOi = null;
    }
    
    @WorkerThread
    public ConnectionResult zzyw()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      return this.zzaOi;
    }
    
    @WorkerThread
    public void zzyz()
    {
      zzac.zza(zzzl.zza(zzzl.this));
      if ((this.zzaMn.isConnected()) && (this.zzaOf.size() == 0))
      {
        if (this.zzaOd.zzxK()) {
          zzyy();
        }
      }
      else {
        return;
      }
      this.zzaMn.disconnect();
    }
  }
  
  private class zzb
    implements zzf.zzf, zzaai.zza
  {
    private final zzyn<?> zzaKz;
    private zzr zzaMZ = null;
    private final Api.zze zzaMn;
    private boolean zzaOl = false;
    private Set<Scope> zzamH = null;
    
    public zzb(zzyn<?> paramzzyn)
    {
      this.zzaMn = paramzzyn;
      zzyn localzzyn;
      this.zzaKz = localzzyn;
    }
    
    @WorkerThread
    private void zzyB()
    {
      if ((this.zzaOl) && (this.zzaMZ != null)) {
        this.zzaMn.zza(this.zzaMZ, this.zzamH);
      }
    }
    
    @WorkerThread
    public void zzb(zzr paramzzr, Set<Scope> paramSet)
    {
      if ((paramzzr == null) || (paramSet == null))
      {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zzi(new ConnectionResult(4));
        return;
      }
      this.zzaMZ = paramzzr;
      this.zzamH = paramSet;
      zzyB();
    }
    
    public void zzg(@NonNull final ConnectionResult paramConnectionResult)
    {
      zzzl.zza(zzzl.this).post(new Runnable()
      {
        public void run()
        {
          if (paramConnectionResult.isSuccess())
          {
            zzzl.zzb.zza(zzzl.zzb.this, true);
            if (zzzl.zzb.zza(zzzl.zzb.this).zzqB())
            {
              zzzl.zzb.zzb(zzzl.zzb.this);
              return;
            }
            zzzl.zzb.zza(zzzl.zzb.this).zza(null, Collections.emptySet());
            return;
          }
          ((zzzl.zza)zzzl.zzj(zzzl.this).get(zzzl.zzb.zzc(zzzl.zzb.this))).onConnectionFailed(paramConnectionResult);
        }
      });
    }
    
    @WorkerThread
    public void zzi(ConnectionResult paramConnectionResult)
    {
      ((zzzl.zza)zzzl.zzj(zzzl.this).get(this.zzaKz)).zzi(paramConnectionResult);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */