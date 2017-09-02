package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.analytics.internal.G;
import com.google.android.gms.analytics.internal.G.Value;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzap;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends zza
{
  private static List<Runnable> zzabr = new ArrayList();
  private Set<zza> zzabs = new HashSet();
  private boolean zzabt;
  private boolean zzabu;
  private volatile boolean zzabv;
  private boolean zzabw;
  private boolean zzus;
  
  public GoogleAnalytics(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzf.zzar(paramContext).zznE();
  }
  
  /* Error */
  public static void runWhenInitialized(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 65	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 31	com/google/android/gms/analytics/GoogleAnalytics:zzabr	Ljava/util/List;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: invokeinterface 70 1 0
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 31	com/google/android/gms/analytics/GoogleAnalytics:zzabr	Ljava/util/List;
    //   27: aload_0
    //   28: invokeinterface 76 2 0
    //   33: pop
    //   34: goto -14 -> 20
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   8	20	37	finally
    //   20	23	37	finally
    //   24	34	37	finally
    //   38	41	37	finally
  }
  
  public static void zzmD()
  {
    try
    {
      if (zzabr != null)
      {
        Iterator localIterator = zzabr.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        zzabr = null;
      }
    }
    finally {}
  }
  
  private zzb zzmF()
  {
    return zzmt().zzmF();
  }
  
  private zzap zzmG()
  {
    return zzmt().zzmG();
  }
  
  public void dispatchLocalHits()
  {
    zzmF().zznk();
  }
  
  @TargetApi(14)
  public void enableAutoActivityReports(Application paramApplication)
  {
    int i = Build.VERSION.SDK_INT;
    if (!this.zzabt)
    {
      paramApplication.registerActivityLifecycleCallbacks(new zzb());
      this.zzabt = true;
    }
  }
  
  public String getAdvertiserId()
  {
    zzac.zzcV("getAdvertiserIdFields can not be called from the main thread");
    return zzmt().zznG().zznf();
  }
  
  public boolean getAppOptOut()
  {
    return this.zzabv;
  }
  
  public String getClientId()
  {
    zzac.zzcV("getClientId can not be called from the main thread");
    return zzmt().zznH().zzop();
  }
  
  @Deprecated
  public Logger getLogger()
  {
    return zzae.getLogger();
  }
  
  public void initialize()
  {
    zzmC();
    this.zzus = true;
  }
  
  public boolean isDryRunEnabled()
  {
    return this.zzabu;
  }
  
  public boolean isInitialized()
  {
    return this.zzus;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new Tracker(zzmt(), null, null);
      if (paramInt > 0)
      {
        zzan localzzan = (zzan)new zzam(zzmt()).zzaB(paramInt);
        if (localzzan != null) {
          localTracker.zza(localzzan);
        }
      }
      localTracker.initialize();
      return localTracker;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      paramString = new Tracker(zzmt(), paramString, null);
      paramString.initialize();
      return paramString;
    }
    finally {}
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.zzabt) {
      zzm(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.zzabt) {
      zzn(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    this.zzabv = paramBoolean;
    if (this.zzabv) {
      zzmF().zznj();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.zzabu = paramBoolean;
  }
  
  public void setLocalDispatchPeriod(int paramInt)
  {
    zzmF().setLocalDispatchPeriod(paramInt);
  }
  
  @Deprecated
  public void setLogger(Logger paramLogger)
  {
    zzae.setLogger(paramLogger);
    if (!this.zzabw)
    {
      paramLogger = (String)G.loggingTag.get();
      String str = (String)G.loggingTag.get();
      Log.i(paramLogger, String.valueOf(str).length() + 112 + "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + str + " DEBUG");
      this.zzabw = true;
    }
  }
  
  void zza(zza paramzza)
  {
    this.zzabs.add(paramzza);
    paramzza = zzmt().getContext();
    if ((paramzza instanceof Application)) {
      enableAutoActivityReports((Application)paramzza);
    }
  }
  
  void zzb(zza paramzza)
  {
    this.zzabs.remove(paramzza);
  }
  
  void zzm(Activity paramActivity)
  {
    Iterator localIterator = this.zzabs.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzo(paramActivity);
    }
  }
  
  void zzmC()
  {
    zzap localzzap = zzmG();
    localzzap.zzph();
    if (localzzap.zzpl()) {
      setDryRun(localzzap.zzpm());
    }
    localzzap.zzph();
  }
  
  void zzmE()
  {
    zzmF().zznl();
  }
  
  void zzn(Activity paramActivity)
  {
    Iterator localIterator = this.zzabs.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzp(paramActivity);
    }
  }
  
  static abstract interface zza
  {
    public abstract void zzo(Activity paramActivity);
    
    public abstract void zzp(Activity paramActivity);
  }
  
  @TargetApi(14)
  class zzb
    implements Application.ActivityLifecycleCallbacks
  {
    zzb() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.this.zzm(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.this.zzn(paramActivity);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */