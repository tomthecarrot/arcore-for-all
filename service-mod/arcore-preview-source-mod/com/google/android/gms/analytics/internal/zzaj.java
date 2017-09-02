package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.stats.WakeLock;

public final class zzaj
{
  static WakeLock zzabh;
  static Boolean zzabi;
  static Object zzuq = new Object();
  
  public static boolean zzao(Context paramContext)
  {
    zzac.zzC(paramContext);
    if (zzabi != null) {
      return zzabi.booleanValue();
    }
    boolean bool = zzao.zza(paramContext, "com.google.android.gms.analytics.AnalyticsReceiver", false);
    zzabi = Boolean.valueOf(bool);
    return bool;
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onReceive(Context paramContext, Intent arg2)
  {
    localzzaf = zzf.zzar(paramContext).zznr();
    if (??? == null) {
      localzzaf.zzbu("AnalyticsReceiver called with null intent");
    }
    do
    {
      return;
      ??? = ???.getAction();
      localzzaf.zza("Local AnalyticsReceiver got", ???);
    } while (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(???));
    boolean bool = zzak.zzap(paramContext);
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(paramContext, "com.google.android.gms.analytics.AnalyticsService"));
    localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    synchronized (zzuq)
    {
      paramContext.startService(localIntent);
      if (!bool) {
        return;
      }
    }
    try
    {
      if (zzabh == null)
      {
        zzabh = new WakeLock(paramContext, 1, "Analytics WakeLock");
        zzabh.setReferenceCounted(false);
      }
      zzabh.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzzaf.zzbu("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */