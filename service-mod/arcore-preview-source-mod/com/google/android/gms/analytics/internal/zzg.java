package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

public class zzg
{
  private final Context zzadP;
  private final Context zzwB;
  
  public zzg(Context paramContext)
  {
    zzac.zzC(paramContext);
    paramContext = paramContext.getApplicationContext();
    zzac.zzb(paramContext, "Application context can't be null");
    this.zzwB = paramContext;
    this.zzadP = paramContext;
  }
  
  public Context getApplicationContext()
  {
    return this.zzwB;
  }
  
  protected zzv zza(zzf paramzzf)
  {
    return new zzv(paramzzf);
  }
  
  protected com.google.android.gms.analytics.zzh zzas(Context paramContext)
  {
    return com.google.android.gms.analytics.zzh.zzaq(paramContext);
  }
  
  protected zzk zzb(zzf paramzzf)
  {
    return new zzk(paramzzf);
  }
  
  protected zza zzc(zzf paramzzf)
  {
    return new zza(paramzzf);
  }
  
  protected zzn zzd(zzf paramzzf)
  {
    return new zzn(paramzzf);
  }
  
  protected zzap zze(zzf paramzzf)
  {
    return new zzap(paramzzf);
  }
  
  protected zzaf zzf(zzf paramzzf)
  {
    return new zzaf(paramzzf);
  }
  
  protected zzs zzg(zzf paramzzf)
  {
    return new zzs(paramzzf);
  }
  
  protected Clock zzh(zzf paramzzf)
  {
    return com.google.android.gms.common.util.zzh.zzAM();
  }
  
  protected GoogleAnalytics zzi(zzf paramzzf)
  {
    return new GoogleAnalytics(paramzzf);
  }
  
  zzl zzj(zzf paramzzf)
  {
    return new zzl(paramzzf, this);
  }
  
  zzag zzk(zzf paramzzf)
  {
    return new zzag(paramzzf);
  }
  
  protected zzb zzl(zzf paramzzf)
  {
    return new zzb(paramzzf, this);
  }
  
  public zzj zzm(zzf paramzzf)
  {
    return new zzj(paramzzf);
  }
  
  public zzah zzn(zzf paramzzf)
  {
    return new zzah(paramzzf);
  }
  
  public Context zznC()
  {
    return this.zzadP;
  }
  
  public zzi zzo(zzf paramzzf)
  {
    return new zzi(paramzzf);
  }
  
  public zzw zzp(zzf paramzzf)
  {
    return new zzw(paramzzf);
  }
  
  public zzai zzq(zzf paramzzf)
  {
    return new zzai(paramzzf);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */