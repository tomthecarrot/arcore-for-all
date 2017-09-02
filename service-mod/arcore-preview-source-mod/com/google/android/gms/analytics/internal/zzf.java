package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

public class zzf
{
  private static volatile zzf zzadA;
  private final Context mContext;
  private final Context zzadB;
  private final zzs zzadC;
  private final zzaf zzadD;
  private final com.google.android.gms.analytics.zzh zzadE;
  private final zzb zzadF;
  private final zzw zzadG;
  private final zzap zzadH;
  private final zzai zzadI;
  private final GoogleAnalytics zzadJ;
  private final zzn zzadK;
  private final zza zzadL;
  private final zzk zzadM;
  private final zzv zzadN;
  private final Clock zzvi;
  
  protected zzf(zzg paramzzg)
  {
    Object localObject1 = paramzzg.getApplicationContext();
    zzac.zzb(localObject1, "Application context can't be null");
    Object localObject2 = paramzzg.zznC();
    zzac.zzC(localObject2);
    this.mContext = ((Context)localObject1);
    this.zzadB = ((Context)localObject2);
    this.zzvi = paramzzg.zzh(this);
    this.zzadC = paramzzg.zzg(this);
    localObject2 = paramzzg.zzf(this);
    ((zzaf)localObject2).initialize();
    this.zzadD = ((zzaf)localObject2);
    localObject2 = zznr();
    Object localObject3 = zze.VERSION;
    ((zzaf)localObject2).zzbt(String.valueOf(localObject3).length() + 134 + "Google Analytics " + (String)localObject3 + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
    localObject2 = paramzzg.zzq(this);
    ((zzai)localObject2).initialize();
    this.zzadI = ((zzai)localObject2);
    localObject2 = paramzzg.zze(this);
    ((zzap)localObject2).initialize();
    this.zzadH = ((zzap)localObject2);
    localObject2 = paramzzg.zzl(this);
    localObject3 = paramzzg.zzd(this);
    zza localzza = paramzzg.zzc(this);
    zzk localzzk = paramzzg.zzb(this);
    zzv localzzv = paramzzg.zza(this);
    localObject1 = paramzzg.zzas((Context)localObject1);
    ((com.google.android.gms.analytics.zzh)localObject1).zza(zznB());
    this.zzadE = ((com.google.android.gms.analytics.zzh)localObject1);
    localObject1 = paramzzg.zzi(this);
    ((zzn)localObject3).initialize();
    this.zzadK = ((zzn)localObject3);
    localzza.initialize();
    this.zzadL = localzza;
    localzzk.initialize();
    this.zzadM = localzzk;
    localzzv.initialize();
    this.zzadN = localzzv;
    paramzzg = paramzzg.zzp(this);
    paramzzg.initialize();
    this.zzadG = paramzzg;
    ((zzb)localObject2).initialize();
    this.zzadF = ((zzb)localObject2);
    ((GoogleAnalytics)localObject1).initialize();
    this.zzadJ = ((GoogleAnalytics)localObject1);
    ((zzb)localObject2).start();
  }
  
  private void zza(zzd paramzzd)
  {
    zzac.zzb(paramzzd, "Analytics service not created/initialized");
    zzac.zzb(paramzzd.isInitialized(), "Analytics service not initialized");
  }
  
  public static zzf zzar(Context paramContext)
  {
    zzac.zzC(paramContext);
    if (zzadA == null) {}
    try
    {
      if (zzadA == null)
      {
        Clock localClock = com.google.android.gms.common.util.zzh.zzAM();
        long l1 = localClock.elapsedRealtime();
        paramContext = new zzf(new zzg(paramContext));
        zzadA = paramContext;
        GoogleAnalytics.zzmD();
        l1 = localClock.elapsedRealtime() - l1;
        long l2 = ((Long)G.initializationWarningThreshold.get()).longValue();
        if (l1 > l2) {
          paramContext.zznr().zzc("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        }
      }
      return zzadA;
    }
    finally {}
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public zzb zzmF()
  {
    zza(this.zzadF);
    return this.zzadF;
  }
  
  public zzap zzmG()
  {
    zza(this.zzadH);
    return this.zzadH;
  }
  
  public void zzmW() {}
  
  protected Thread.UncaughtExceptionHandler zznB()
  {
    new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        paramAnonymousThread = zzf.this.zznD();
        if (paramAnonymousThread != null) {
          paramAnonymousThread.zze("Job execution failed", paramAnonymousThrowable);
        }
      }
    };
  }
  
  public Context zznC()
  {
    return this.zzadB;
  }
  
  public zzaf zznD()
  {
    return this.zzadD;
  }
  
  public GoogleAnalytics zznE()
  {
    zzac.zzC(this.zzadJ);
    zzac.zzb(this.zzadJ.isInitialized(), "Analytics instance not initialized");
    return this.zzadJ;
  }
  
  public zzai zznF()
  {
    if ((this.zzadI == null) || (!this.zzadI.isInitialized())) {
      return null;
    }
    return this.zzadI;
  }
  
  public zza zznG()
  {
    zza(this.zzadL);
    return this.zzadL;
  }
  
  public zzn zznH()
  {
    zza(this.zzadK);
    return this.zzadK;
  }
  
  public Clock zznq()
  {
    return this.zzvi;
  }
  
  public zzaf zznr()
  {
    zza(this.zzadD);
    return this.zzadD;
  }
  
  public zzs zzns()
  {
    return this.zzadC;
  }
  
  public com.google.android.gms.analytics.zzh zznt()
  {
    zzac.zzC(this.zzadE);
    return this.zzadE;
  }
  
  public zzw zznu()
  {
    zza(this.zzadG);
    return this.zzadG;
  }
  
  public zzai zznv()
  {
    zza(this.zzadI);
    return this.zzadI;
  }
  
  public zzk zzny()
  {
    zza(this.zzadM);
    return this.zzadM;
  }
  
  public zzv zznz()
  {
    return this.zzadN;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */