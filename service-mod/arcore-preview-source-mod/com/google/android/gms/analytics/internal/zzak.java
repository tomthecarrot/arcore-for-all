package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.stats.WakeLock;

public final class zzak
{
  private static Boolean zzabj;
  private final Context mContext;
  private final Handler mHandler;
  private final zza zzafC;
  
  public zzak(zza paramzza)
  {
    this.mContext = paramzza.getContext();
    zzac.zzC(this.mContext);
    this.zzafC = paramzza;
    this.mHandler = new Handler();
  }
  
  public static boolean zzap(Context paramContext)
  {
    zzac.zzC(paramContext);
    if (zzabj != null) {
      return zzabj.booleanValue();
    }
    boolean bool = zzao.zzy(paramContext, "com.google.android.gms.analytics.AnalyticsService");
    zzabj = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzmz()
  {
    try
    {
      synchronized (zzaj.zzuq)
      {
        WakeLock localWakeLock = zzaj.zzabh;
        if ((localWakeLock != null) && (localWakeLock.isHeld())) {
          localWakeLock.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onCreate()
  {
    zzf.zzar(this.mContext).zznr().zzbr("Local AnalyticsService is starting up");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onDestroy()
  {
    zzf.zzar(this.mContext).zznr().zzbr("Local AnalyticsService is shutting down");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzmz();
    final zzf localzzf = zzf.zzar(this.mContext);
    final zzaf localzzaf = localzzf.zznr();
    if (paramIntent == null) {
      localzzaf.zzbu("AnalyticsService started with null intent");
    }
    do
    {
      return 2;
      paramIntent = paramIntent.getAction();
      localzzaf.zza("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    } while (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent));
    localzzf.zzmF().zza(new zzx()
    {
      public void zzf(Throwable paramAnonymousThrowable)
      {
        zzak.zzb(zzak.this).post(new Runnable()
        {
          public void run()
          {
            if (zzak.zza(zzak.this).callServiceStopSelfResult(zzak.1.this.zzabl)) {
              zzak.1.this.zzabk.zzbr("Local AnalyticsService processed last dispatch request");
            }
          }
        });
      }
    });
    return 2;
  }
  
  public static abstract interface zza
  {
    public abstract boolean callServiceStopSelfResult(int paramInt);
    
    public abstract Context getContext();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */