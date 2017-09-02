package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultStore;
import com.google.android.gms.common.api.Status;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzaar
{
  public static final Status zzaPd = new Status(8, "The connection to Google Play services was lost");
  private static final zzyt<?>[] zzaPe = new zzyt[0];
  private final Map<Api.zzc<?>, Api.zze> zzaNt;
  final Set<zzyt<?>> zzaPf = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final zzb zzaPg = new zzb()
  {
    public void zzc(zzyt<?> paramAnonymouszzyt)
    {
      zzaar.this.zzaPf.remove(paramAnonymouszzyt);
      if ((paramAnonymouszzyt.zzxe() != null) && (zzaar.zza(zzaar.this) != null)) {
        zzaar.zza(zzaar.this).remove(paramAnonymouszzyt.zzxe().intValue());
      }
    }
  };
  private ResultStore zzaPh;
  
  public zzaar(Map<Api.zzc<?>, Api.zze> paramMap)
  {
    this.zzaNt = paramMap;
  }
  
  private static void zza(zzyt<?> paramzzyt, ResultStore paramResultStore, IBinder paramIBinder)
  {
    if (paramzzyt.isReady())
    {
      paramzzyt.zza(new zza(paramzzyt, paramResultStore, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zza localzza = new zza(paramzzyt, paramResultStore, paramIBinder, null);
      paramzzyt.zza(localzza);
      try
      {
        paramIBinder.linkToDeath(localzza, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramzzyt.cancel();
        paramResultStore.remove(paramzzyt.zzxe().intValue());
        return;
      }
    }
    paramzzyt.zza(null);
    paramzzyt.cancel();
    paramResultStore.remove(paramzzyt.zzxe().intValue());
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzaPf.size());
  }
  
  public void release()
  {
    zzyt[] arrayOfzzyt = (zzyt[])this.zzaPf.toArray(zzaPe);
    int j = arrayOfzzyt.length;
    int i = 0;
    if (i < j)
    {
      zzyt localzzyt = arrayOfzzyt[i];
      localzzyt.zza(null);
      if (localzzyt.zzxe() == null) {
        if (localzzyt.zzxr()) {
          this.zzaPf.remove(localzzyt);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localzzyt.zzxt();
        IBinder localIBinder = ((Api.zze)this.zzaNt.get(((zzyr.zza)localzzyt).zzwS())).zzwU();
        zza(localzzyt, this.zzaPh, localIBinder);
        this.zzaPf.remove(localzzyt);
      }
    }
  }
  
  public void zza(ResultStore paramResultStore)
  {
    this.zzaPh = paramResultStore;
  }
  
  void zzb(zzyt<? extends Result> paramzzyt)
  {
    this.zzaPf.add(paramzzyt);
    paramzzyt.zza(this.zzaPg);
  }
  
  public void zzyS()
  {
    zzyt[] arrayOfzzyt = (zzyt[])this.zzaPf.toArray(zzaPe);
    int j = arrayOfzzyt.length;
    int i = 0;
    while (i < j)
    {
      arrayOfzzyt[i].zzQ(zzaPd);
      i += 1;
    }
  }
  
  private static class zza
    implements IBinder.DeathRecipient, zzaar.zzb
  {
    private final WeakReference<zzyt<?>> zzaPj;
    private final WeakReference<ResultStore> zzaPk;
    private final WeakReference<IBinder> zzaPl;
    
    private zza(zzyt<?> paramzzyt, ResultStore paramResultStore, IBinder paramIBinder)
    {
      this.zzaPk = new WeakReference(paramResultStore);
      this.zzaPj = new WeakReference(paramzzyt);
      this.zzaPl = new WeakReference(paramIBinder);
    }
    
    private void zzyT()
    {
      Object localObject = (zzyt)this.zzaPj.get();
      ResultStore localResultStore = (ResultStore)this.zzaPk.get();
      if ((localResultStore != null) && (localObject != null)) {
        localResultStore.remove(((zzyt)localObject).zzxe().intValue());
      }
      localObject = (IBinder)this.zzaPl.get();
      if (localObject != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public void binderDied()
    {
      zzyT();
    }
    
    public void zzc(zzyt<?> paramzzyt)
    {
      zzyT();
    }
  }
  
  static abstract interface zzb
  {
    public abstract void zzc(zzyt<?> paramzzyt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */