package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.tagmanager.ContainerRefreshPolicy;
import com.google.android.gms.tagmanager.Log;
import com.google.android.gms.tagmanager.resources.network.zze;
import com.google.android.gms.tagmanager.resources.network.zzg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzbpc
{
  private final Context mContext;
  Map<String, zzc<zzbph.zzc>> zzcAj = new HashMap();
  private final Map<String, zzg> zzcAk;
  private final zzbpj zzcBu;
  private String zzctL = null;
  private final Clock zzvi;
  
  public zzbpc(Context paramContext)
  {
    this(paramContext, new HashMap(), new zzbpj(paramContext), zzh.zzAM());
  }
  
  zzbpc(Context paramContext, Map<String, zzg> paramMap, zzbpj paramzzbpj, Clock paramClock)
  {
    this.mContext = paramContext;
    this.zzvi = paramClock;
    this.zzcBu = paramzzbpj;
    this.zzcAk = paramMap;
  }
  
  private void zza(zzbpf paramzzbpf, zza paramzza)
  {
    boolean bool = true;
    paramzzbpf = paramzzbpf.zzaan();
    if (paramzzbpf.size() == 1) {}
    for (;;)
    {
      zzac.zzaw(bool);
      zza((zzbpa)paramzzbpf.get(0), paramzza);
      return;
      bool = false;
    }
  }
  
  public void setCtfeServerAddress(String paramString)
  {
    this.zzctL = paramString;
  }
  
  void zza(final zzbpa paramzzbpa, final zza paramzza)
  {
    this.zzcBu.zza(paramzzbpa.zzZx(), paramzzbpa.zzaam(), zzbpe.zzcBz, new zzbpi()
    {
      public void zza(Status paramAnonymousStatus, Object paramAnonymousObject, Integer paramAnonymousInteger, long paramAnonymousLong)
      {
        if (paramAnonymousStatus.isSuccess())
        {
          if (paramAnonymousInteger == zzbpj.zzcBP) {}
          for (paramAnonymousStatus = zzbpg.zza.zza.zzcBH;; paramAnonymousStatus = zzbpg.zza.zza.zzcBG)
          {
            paramAnonymousStatus = new zzbpg.zza(Status.zzaLc, paramzzbpa, null, (zzbph.zzc)paramAnonymousObject, paramAnonymousStatus, paramAnonymousLong);
            paramzza.zza(new zzbpg(paramAnonymousStatus));
            return;
          }
        }
        paramAnonymousStatus = String.valueOf(paramzzbpa.getContainerId());
        if (paramAnonymousStatus.length() != 0) {}
        for (paramAnonymousStatus = "There is no valid resource for the container: ".concat(paramAnonymousStatus);; paramAnonymousStatus = new String("There is no valid resource for the container: "))
        {
          paramAnonymousStatus = new zzbpg.zza(new Status(16, paramAnonymousStatus), null, zzbpg.zza.zza.zzcBG);
          break;
        }
      }
    });
  }
  
  void zza(zzbpf paramzzbpf, zza paramzza, zze paramzze)
  {
    Iterator localIterator = paramzzbpf.zzaan().iterator();
    int i = 0;
    zzbpa localzzbpa;
    long l;
    if (localIterator.hasNext())
    {
      localzzbpa = (zzbpa)localIterator.next();
      zzc localzzc = (zzc)this.zzcAj.get(localzzbpa.getContainerId());
      if (localzzc != null)
      {
        l = localzzc.zzZB();
        label67:
        if (l + 900000L >= this.zzvi.currentTimeMillis()) {
          break label202;
        }
        i = 1;
      }
    }
    label199:
    label202:
    for (;;)
    {
      break;
      l = this.zzcBu.zzky(localzzbpa.getContainerId());
      break label67;
      if (i != 0)
      {
        paramzza = (zzg)this.zzcAk.get(paramzzbpf.getId());
        if (paramzza != null) {
          break label199;
        }
        if (this.zzctL == null)
        {
          paramzza = new zzg();
          this.zzcAk.put(paramzzbpf.getId(), paramzza);
        }
      }
      for (;;)
      {
        paramzza.zza(this.mContext, paramzzbpf, 0L, paramzze);
        return;
        paramzza = new zzg(this.zzctL);
        break;
        zza(paramzzbpf, paramzza);
        return;
      }
    }
  }
  
  void zza(zzbpg.zza paramzza)
  {
    Object localObject = paramzza.zzaaq().getContainerId();
    Status localStatus = paramzza.getStatus();
    paramzza = paramzza.zzaar();
    if (this.zzcAj.containsKey(localObject))
    {
      localObject = (zzc)this.zzcAj.get(localObject);
      ((zzc)localObject).zzaT(this.zzvi.currentTimeMillis());
      if (localStatus == Status.zzaLc)
      {
        ((zzc)localObject).zzeI(localStatus);
        ((zzc)localObject).zzai(paramzza);
      }
      return;
    }
    this.zzcAj.put(localObject, new zzc(localStatus, paramzza, this.zzvi.currentTimeMillis()));
  }
  
  public void zza(String paramString1, Integer paramInteger, @Nullable String paramString2, zza paramzza, ContainerRefreshPolicy paramContainerRefreshPolicy)
  {
    paramString1 = new zzbpf().zza(new zzbpa(paramString1, paramInteger, paramString2, false));
    zza(paramString1, paramzza, new zzb(paramString1, zzbpe.zzcBz, paramzza, paramContainerRefreshPolicy));
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzbpg paramzzbpg);
  }
  
  class zzb
    extends zze
  {
    private final zzbpc.zza zzcBx;
    
    zzb(zzbpf paramzzbpf, zzbpd paramzzbpd, zzbpc.zza paramzza, ContainerRefreshPolicy paramContainerRefreshPolicy)
    {
      super(paramzzbpd, paramContainerRefreshPolicy);
      this.zzcBx = paramzza;
    }
    
    protected void zza(zzbpg paramzzbpg)
    {
      zzbpg.zza localzza = paramzzbpg.zzaao();
      zzbpc.this.zza(localzza);
      if ((localzza.getStatus() == Status.zzaLc) && (localzza.zzaap() == zzbpg.zza.zza.zzcBF) && (localzza.getRawData() != null) && (localzza.getRawData().length > 0))
      {
        zzbpc.zza(zzbpc.this).zzh(localzza.zzaaq().zzZx(), localzza.getRawData());
        Log.v("Resource successfully load from Network.");
        this.zzcBx.zza(paramzzbpg);
        return;
      }
      if (localzza.getStatus().isSuccess())
      {
        paramzzbpg = "SUCCESS";
        paramzzbpg = String.valueOf(paramzzbpg);
        if (paramzzbpg.length() == 0) {
          break label212;
        }
        paramzzbpg = "Response status: ".concat(paramzzbpg);
        label117:
        Log.v(paramzzbpg);
        if (localzza.getStatus().isSuccess())
        {
          paramzzbpg = String.valueOf(localzza.zzaap().toString());
          if (paramzzbpg.length() == 0) {
            break label225;
          }
        }
      }
      label212:
      label225:
      for (paramzzbpg = "Response source: ".concat(paramzzbpg);; paramzzbpg = new String("Response source: "))
      {
        Log.v(paramzzbpg);
        int i = localzza.getRawData().length;
        Log.v(26 + "Response size: " + i);
        zzbpc.this.zza(localzza.zzaaq(), this.zzcBx);
        return;
        paramzzbpg = "FAILURE";
        break;
        paramzzbpg = new String("Response status: ");
        break label117;
      }
    }
  }
  
  static class zzc<T>
  {
    private T mData;
    private Status zzaiT;
    private long zzcAp;
    
    public zzc(Status paramStatus, T paramT, long paramLong)
    {
      this.zzaiT = paramStatus;
      this.mData = paramT;
      this.zzcAp = paramLong;
    }
    
    public long zzZB()
    {
      return this.zzcAp;
    }
    
    public void zzaT(long paramLong)
    {
      this.zzcAp = paramLong;
    }
    
    public void zzai(T paramT)
    {
      this.mData = paramT;
    }
    
    public void zzeI(Status paramStatus)
    {
      this.zzaiT = paramStatus;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */