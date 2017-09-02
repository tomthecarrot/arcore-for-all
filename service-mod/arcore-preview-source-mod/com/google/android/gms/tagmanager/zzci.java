package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzci
  implements ContainerHolderLoader.zze
{
  private boolean mClosed;
  private final Context mContext;
  private final String zzcaK;
  private String zzctD;
  private zzbe<zzaj.zzj> zzcvJ;
  private CtfeHost zzcvK;
  private final ScheduledExecutorService zzcvM;
  private final zza zzcvN;
  private ScheduledFuture<?> zzcvO;
  
  public zzci(Context paramContext, String paramString, CtfeHost paramCtfeHost)
  {
    this(paramContext, paramString, paramCtfeHost, null, null);
  }
  
  zzci(Context paramContext, String paramString, CtfeHost paramCtfeHost, zzb paramzzb, zza paramzza)
  {
    this.zzcvK = paramCtfeHost;
    this.mContext = paramContext;
    this.zzcaK = paramString;
    paramContext = paramzzb;
    if (paramzzb == null) {
      paramContext = new zzb()
      {
        public ScheduledExecutorService zzYf()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.zzcvM = paramContext.zzYf();
    if (paramzza == null)
    {
      this.zzcvN = new zza()
      {
        public zzch zza(CtfeHost paramAnonymousCtfeHost)
        {
          return new zzch(zzci.zza(zzci.this), zzci.zzb(zzci.this), paramAnonymousCtfeHost);
        }
      };
      return;
    }
    this.zzcvN = paramzza;
  }
  
  private void zzYe()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  private zzch zzjU(String paramString)
  {
    zzch localzzch = this.zzcvN.zza(this.zzcvK);
    localzzch.zza(this.zzcvJ);
    localzzch.zzjG(this.zzctD);
    localzzch.zzjT(paramString);
    return localzzch;
  }
  
  public void release()
  {
    try
    {
      zzYe();
      if (this.zzcvO != null) {
        this.zzcvO.cancel(false);
      }
      this.zzcvM.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void zza(zzbe<zzaj.zzj> paramzzbe)
  {
    try
    {
      zzYe();
      this.zzcvJ = paramzzbe;
      return;
    }
    finally
    {
      paramzzbe = finally;
      throw paramzzbe;
    }
  }
  
  public void zzf(long paramLong, String paramString)
  {
    try
    {
      String str = this.zzcaK;
      Log.v(String.valueOf(str).length() + 55 + "loadAfterDelay: containerId=" + str + " delay=" + paramLong);
      zzYe();
      if (this.zzcvJ == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.zzcvO != null) {
      this.zzcvO.cancel(false);
    }
    this.zzcvO = this.zzcvM.schedule(zzjU(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void zzjG(String paramString)
  {
    try
    {
      zzYe();
      this.zzctD = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract zzch zza(CtfeHost paramCtfeHost);
  }
  
  static abstract interface zzb
  {
    public abstract ScheduledExecutorService zzYf();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */