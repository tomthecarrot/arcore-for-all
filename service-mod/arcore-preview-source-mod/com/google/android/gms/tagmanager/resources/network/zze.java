package com.google.android.gms.tagmanager.resources.network;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbpa;
import com.google.android.gms.internal.zzbpd;
import com.google.android.gms.internal.zzbpf;
import com.google.android.gms.internal.zzbpg;
import com.google.android.gms.internal.zzbpg.zza;
import com.google.android.gms.internal.zzbpg.zza.zza;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzbph.zzg;
import com.google.android.gms.tagmanager.ContainerRefreshPolicy;
import com.google.android.gms.tagmanager.Log;
import java.util.List;

public abstract class zze
{
  private zzbpf zzcBV;
  private zzbpd zzcBW;
  private final ContainerRefreshPolicy zzctx;
  private Clock zzvi;
  
  public zze(zzbpf paramzzbpf, zzbpd paramzzbpd, ContainerRefreshPolicy paramContainerRefreshPolicy)
  {
    this(paramzzbpf, paramzzbpd, paramContainerRefreshPolicy, zzh.zzAM());
  }
  
  public zze(zzbpf paramzzbpf, zzbpd paramzzbpd, ContainerRefreshPolicy paramContainerRefreshPolicy, Clock paramClock)
  {
    if (paramzzbpf.zzaan().size() == 1) {}
    for (;;)
    {
      zzac.zzaw(bool);
      this.zzcBV = paramzzbpf;
      this.zzcBW = paramzzbpd;
      this.zzvi = paramClock;
      this.zzctx = paramContainerRefreshPolicy;
      return;
      bool = false;
    }
  }
  
  public void zzY(byte[] paramArrayOfByte)
  {
    localObject1 = String.valueOf(this.zzcBV.getId());
    if (((String)localObject1).length() != 0) {}
    for (localObject1 = "ResourceManager: Resource downloaded from Network: ".concat((String)localObject1);; localObject1 = new String("ResourceManager: Resource downloaded from Network: "))
    {
      Log.v((String)localObject1);
      localzzbpa = (zzbpa)this.zzcBV.zzaan().get(0);
      this.zzctx.reportContainerSuccessfulLoad();
      zzbpg.zza.zza localzza = zzbpg.zza.zza.zzcBF;
      localObject1 = null;
      l2 = 0L;
      l1 = l2;
      try
      {
        localObject2 = this.zzcBW.zzac(paramArrayOfByte);
        l1 = l2;
        localObject1 = localObject2;
        l2 = this.zzvi.currentTimeMillis();
        if (localObject2 == null)
        {
          l1 = l2;
          localObject1 = localObject2;
          Log.i("Parsed resource from network is null");
        }
      }
      catch (zzbph.zzg localzzg)
      {
        for (;;)
        {
          Object localObject2;
          Log.i("Resource from network is corrupted");
          Object localObject3 = localObject1;
          l2 = l1;
          continue;
          paramArrayOfByte = new zzbpg.zza(Status.zzaLe, localzzbpa, zzbpg.zza.zza.zzcBF);
        }
      }
      if (localObject2 == null) {
        break;
      }
      paramArrayOfByte = new zzbpg.zza(Status.zzaLc, localzzbpa, paramArrayOfByte, (zzbph.zzc)localObject2, localzza, l2);
      zza(new zzbpg(paramArrayOfByte));
      return;
    }
  }
  
  protected abstract void zza(zzbpg paramzzbpg);
  
  public void zza(zza paramzza)
  {
    Object localObject = String.valueOf(paramzza.name());
    if (((String)localObject).length() != 0) {}
    for (localObject = "ResourceManager: Failed to download a resource: ".concat((String)localObject);; localObject = new String("ResourceManager: Failed to download a resource: "))
    {
      Log.e((String)localObject);
      localObject = (zzbpa)this.zzcBV.zzaan().get(0);
      if (paramzza == zza.zzcCa) {
        this.zzctx.reportContainerForbiddenError();
      }
      zza(new zzbpg(new zzbpg.zza(Status.zzaLe, (zzbpa)localObject, zzbpg.zza.zza.zzcBF)));
      return;
    }
  }
  
  public static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/resources/network/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */