package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzboz.zza;
import com.google.android.gms.internal.zzbpc;
import com.google.android.gms.internal.zzbpc.zza;
import com.google.android.gms.internal.zzbpg;
import com.google.android.gms.internal.zzbpg.zza;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzyt;

public class ContainerHolderLoader
  extends zzyt<ContainerHolder>
{
  private final Context mContext;
  private final String zzcaK;
  private volatile zzo zzctA;
  private volatile boolean zzctB;
  private zzaj.zzj zzctC;
  private String zzctD;
  private zze zzctE;
  private zza zzctF;
  private long zzctk;
  private final TagManager zzctr;
  private final zzd zzctu;
  private final zzbz zzctv;
  private final int zzctw;
  private final ContainerRefreshPolicy zzctx;
  private zzf zzcty;
  private zzbpc zzctz;
  private final Looper zzrD;
  private final Clock zzvi;
  
  ContainerHolderLoader(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzf paramzzf, zze paramzze, zzbpc paramzzbpc, Clock paramClock, zzbz paramzzbz, ContainerRefreshPolicy paramContainerRefreshPolicy) {}
  
  public ContainerHolderLoader(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, CtfeHost paramCtfeHost)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new zzcj(paramContext, paramString), new zzci(paramContext, paramString, paramCtfeHost), new zzbpc(paramContext), zzh.zzAM(), new zzbd(1, 5, 900000L, 5000L, "refreshing", zzh.zzAM()), new ContainerRefreshPolicy(paramContext, paramString));
    this.zzctz.setCtfeServerAddress(paramCtfeHost.getCtfeServerAddress());
  }
  
  private boolean zzXn()
  {
    zzbx localzzbx = zzbx.zzXY();
    return ((localzzbx.zzXZ() == zzbx.zza.zzcvy) || (localzzbx.zzXZ() == zzbx.zza.zzcvz)) && (this.zzcaK.equals(localzzbx.getContainerId()));
  }
  
  private void zza(zzaj.zzj paramzzj)
  {
    try
    {
      if (this.zzcty != null)
      {
        zzboz.zza localzza = new zzboz.zza();
        localzza.timeStamp = this.zzctk;
        localzza.zzlq = new zzaj.zzf();
        localzza.zzcBs = paramzzj;
        this.zzcty.zzb(localzza);
      }
      return;
    }
    finally
    {
      paramzzj = finally;
      throw paramzzj;
    }
  }
  
  private void zza(zzaj.zzj paramzzj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.zzctB;
        if (isReady())
        {
          zzo localzzo = this.zzctA;
          if (localzzo == null) {
            return;
          }
        }
        this.zzctC = paramzzj;
        this.zzctk = paramLong;
        long l = this.zzctx.getRefreshPeriodMilliseconds();
        zzaP(Math.max(0L, Math.min(l, this.zzctk + l - this.zzvi.currentTimeMillis())));
        paramzzj = new Container(this.mContext, this.zzctr.getDataLayer(), this.zzcaK, paramLong, paramzzj);
        if (this.zzctA == null)
        {
          this.zzctA = new zzo(this.zzctr, this.zzrD, paramzzj, this.zzctu);
          if ((!isReady()) && (this.zzctF.zzb(paramzzj))) {
            zzb(this.zzctA);
          }
        }
        else
        {
          this.zzctA.zza(paramzzj);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private void zzaP(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/google/android/gms/tagmanager/ContainerHolderLoader:zzctE	Lcom/google/android/gms/tagmanager/ContainerHolderLoader$zze;
    //   6: ifnonnull +12 -> 18
    //   9: ldc_w 288
    //   12: invokestatic 293	com/google/android/gms/tagmanager/Log:w	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 91	com/google/android/gms/tagmanager/ContainerHolderLoader:zzctE	Lcom/google/android/gms/tagmanager/ContainerHolderLoader$zze;
    //   22: lload_1
    //   23: aload_0
    //   24: getfield 105	com/google/android/gms/tagmanager/ContainerHolderLoader:zzctC	Lcom/google/android/gms/internal/zzaj$zzj;
    //   27: getfield 296	com/google/android/gms/internal/zzaj$zzj:zzlr	Ljava/lang/String;
    //   30: invokeinterface 299 4 0
    //   35: goto -20 -> 15
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ContainerHolderLoader
    //   0	43	1	paramLong	long
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	38	finally
    //   18	35	38	finally
  }
  
  private void zzbx(final boolean paramBoolean)
  {
    this.zzcty.zza(new zzb(null));
    this.zzctE.zza(new zzc(null));
    zzbph.zzc localzzc = this.zzcty.zzwl(this.zzctw);
    if (localzzc != null) {
      this.zzctA = new zzo(this.zzctr, this.zzrD, new Container(this.mContext, this.zzctr.getDataLayer(), this.zzcaK, 0L, localzzc), this.zzctu);
    }
    this.zzctF = new zza()
    {
      private Long zzctJ;
      
      private long zzXo()
      {
        if (this.zzctJ == null) {
          this.zzctJ = Long.valueOf(ContainerHolderLoader.zzg(ContainerHolderLoader.this).getRefreshPeriodMilliseconds());
        }
        return this.zzctJ.longValue();
      }
      
      public boolean zzb(Container paramAnonymousContainer)
      {
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + zzXo() < ContainerHolderLoader.zzh(ContainerHolderLoader.this).currentTimeMillis()) {}
        }
        while (!paramAnonymousContainer.isDefault())
        {
          return true;
          return false;
        }
        return false;
      }
    };
    if (zzXn())
    {
      this.zzctE.zzf(0L, "");
      return;
    }
    this.zzcty.zzXp();
  }
  
  protected ContainerHolder createFailedResult(Status paramStatus)
  {
    if (this.zzctA != null) {
      return this.zzctA;
    }
    if (paramStatus == Status.zzaLf) {
      Log.e("timer expired: setting result to failure");
    }
    return new zzo(paramStatus);
  }
  
  public void load(@Nullable final String paramString)
  {
    if (this.zzctw != -1) {}
    for (Integer localInteger = Integer.valueOf(this.zzctw);; localInteger = null)
    {
      this.zzctz.zza(this.zzcaK, localInteger, paramString, new zzbpc.zza()
      {
        public void zza(zzbpg paramAnonymouszzbpg)
        {
          if (paramAnonymouszzbpg.getStatus() != Status.zzaLc)
          {
            paramAnonymouszzbpg = String.valueOf(ContainerHolderLoader.zza(ContainerHolderLoader.this));
            if (paramAnonymouszzbpg.length() != 0) {}
            for (paramAnonymouszzbpg = "Load request failed for the container ".concat(paramAnonymouszzbpg);; paramAnonymouszzbpg = new String("Load request failed for the container "))
            {
              Log.e(paramAnonymouszzbpg);
              ContainerHolderLoader.this.zzb(ContainerHolderLoader.this.createFailedResult(Status.zzaLe));
              return;
            }
          }
          zzbph.zzc localzzc = paramAnonymouszzbpg.zzaao().zzaar();
          if (localzzc == null)
          {
            Log.e("Response doesn't have the requested container");
            ContainerHolderLoader.this.zzb(ContainerHolderLoader.this.createFailedResult(new Status(8, "Response doesn't have the requested container", null)));
            return;
          }
          long l = paramAnonymouszzbpg.zzaao().zzZI();
          ContainerHolderLoader.zza(ContainerHolderLoader.this, new zzo(ContainerHolderLoader.zzb(ContainerHolderLoader.this), ContainerHolderLoader.zzc(ContainerHolderLoader.this), new Container(ContainerHolderLoader.zzd(ContainerHolderLoader.this), ContainerHolderLoader.zzb(ContainerHolderLoader.this).getDataLayer(), ContainerHolderLoader.zza(ContainerHolderLoader.this), l, localzzc), new zzo.zza()
          {
            public String zzXk()
            {
              return ContainerHolderLoader.this.zzXk();
            }
            
            public void zzXm()
            {
              if (ContainerHolderLoader.zze(ContainerHolderLoader.this).zzpu()) {
                ContainerHolderLoader.this.load(ContainerHolderLoader.1.this.zzctG);
              }
            }
            
            public void zzjD(String paramAnonymous2String)
            {
              ContainerHolderLoader.this.zzjD(paramAnonymous2String);
            }
          }));
          ContainerHolderLoader.this.zzb(ContainerHolderLoader.zzf(ContainerHolderLoader.this));
        }
      }, this.zzctx);
      return;
    }
  }
  
  public void loadDefaultOnly()
  {
    Object localObject = this.zzcty.zzwl(this.zzctw);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.zzctr.getDataLayer(), this.zzcaK, 0L, (zzbph.zzc)localObject);
      zzb(new zzo(this.zzctr, this.zzrD, (Container)localObject, new zzo.zza()
      {
        public String zzXk()
        {
          return ContainerHolderLoader.this.zzXk();
        }
        
        public void zzXm()
        {
          Log.w("Refresh ignored: container loaded as default only.");
        }
        
        public void zzjD(String paramAnonymousString)
        {
          ContainerHolderLoader.this.zzjD(paramAnonymousString);
        }
      }));
    }
    for (;;)
    {
      this.zzctE = null;
      this.zzcty = null;
      return;
      Log.e("Default was requested, but no default container was found");
      zzb(createFailedResult(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void loadPreferFresh()
  {
    zzbx(true);
  }
  
  public void loadPreferNonDefault()
  {
    zzbx(false);
  }
  
  String zzXk()
  {
    try
    {
      String str = this.zzctD;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void zzjD(String paramString)
  {
    try
    {
      this.zzctD = paramString;
      if (this.zzctE != null) {
        this.zzctE.zzjG(paramString);
      }
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
    public abstract boolean zzb(Container paramContainer);
  }
  
  private class zzb
    implements zzbe<zzboz.zza>
  {
    private zzb() {}
    
    public void zza(zzboz.zza paramzza)
    {
      zzaj.zzj localzzj;
      if (paramzza.zzcBs != null) {
        localzzj = paramzza.zzcBs;
      }
      for (;;)
      {
        ContainerHolderLoader.zza(ContainerHolderLoader.this, localzzj, paramzza.timeStamp, true);
        return;
        zzaj.zzf localzzf = paramzza.zzlq;
        localzzj = new zzaj.zzj();
        localzzj.zzlq = localzzf;
        localzzj.zzlp = null;
        localzzj.zzlr = localzzf.version;
      }
    }
    
    public void zza(zzbe.zza paramzza)
    {
      if (!ContainerHolderLoader.zzi(ContainerHolderLoader.this)) {
        ContainerHolderLoader.zza(ContainerHolderLoader.this, 0L);
      }
    }
  }
  
  private class zzc
    implements zzbe<zzaj.zzj>
  {
    private zzc() {}
    
    public void zza(zzbe.zza arg1)
    {
      if (??? == zzbe.zza.zzcvb) {
        ContainerHolderLoader.zzg(ContainerHolderLoader.this).reportContainerForbiddenError();
      }
      synchronized (ContainerHolderLoader.this)
      {
        if (!ContainerHolderLoader.this.isReady())
        {
          if (ContainerHolderLoader.zzf(ContainerHolderLoader.this) != null) {
            ContainerHolderLoader.this.zzb(ContainerHolderLoader.zzf(ContainerHolderLoader.this));
          }
        }
        else
        {
          long l = ContainerHolderLoader.zzg(ContainerHolderLoader.this).getRetryPeriodMilliseconds();
          ContainerHolderLoader.zza(ContainerHolderLoader.this, l);
          return;
        }
        ContainerHolderLoader.this.zzb(ContainerHolderLoader.this.createFailedResult(Status.zzaLf));
      }
    }
    
    public void zzb(zzaj.zzj paramzzj)
    {
      ContainerHolderLoader.zzg(ContainerHolderLoader.this).reportContainerSuccessfulLoad();
      synchronized (ContainerHolderLoader.this)
      {
        if (paramzzj.zzlq == null)
        {
          if (ContainerHolderLoader.zzj(ContainerHolderLoader.this).zzlq == null)
          {
            Log.e("Current resource is null; network resource is also null");
            l = ContainerHolderLoader.zzg(ContainerHolderLoader.this).getRetryPeriodMilliseconds();
            ContainerHolderLoader.zza(ContainerHolderLoader.this, l);
            return;
          }
          paramzzj.zzlq = ContainerHolderLoader.zzj(ContainerHolderLoader.this).zzlq;
        }
        ContainerHolderLoader.zza(ContainerHolderLoader.this, paramzzj, ContainerHolderLoader.zzh(ContainerHolderLoader.this).currentTimeMillis(), false);
        long l = ContainerHolderLoader.zzk(ContainerHolderLoader.this);
        Log.v(58 + "setting refresh time to current time: " + l);
        if (!ContainerHolderLoader.zzl(ContainerHolderLoader.this)) {
          ContainerHolderLoader.zza(ContainerHolderLoader.this, paramzzj);
        }
        return;
      }
    }
  }
  
  private class zzd
    implements zzo.zza
  {
    private zzd() {}
    
    public String zzXk()
    {
      return ContainerHolderLoader.this.zzXk();
    }
    
    public void zzXm()
    {
      if (ContainerHolderLoader.zze(ContainerHolderLoader.this).zzpu()) {
        ContainerHolderLoader.zza(ContainerHolderLoader.this, 0L);
      }
    }
    
    public void zzjD(String paramString)
    {
      ContainerHolderLoader.this.zzjD(paramString);
    }
  }
  
  static abstract interface zze
    extends Releasable
  {
    public abstract void zza(zzbe<zzaj.zzj> paramzzbe);
    
    public abstract void zzf(long paramLong, String paramString);
    
    public abstract void zzjG(String paramString);
  }
  
  static abstract interface zzf
    extends Releasable
  {
    public abstract void zzXp();
    
    public abstract void zza(zzbe<zzboz.zza> paramzzbe);
    
    public abstract void zzb(zzboz.zza paramzza);
    
    public abstract zzbph.zzc zzwl(int paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/ContainerHolderLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */