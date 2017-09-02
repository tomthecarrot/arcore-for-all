package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.stats.WakeLock;

public class CampaignTrackingReceiver
  extends BroadcastReceiver
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
    boolean bool = zzao.zza(paramContext, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
    zzabi = Boolean.valueOf(bool);
    return bool;
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onReceive(Context paramContext, Intent arg2)
  {
    localzzaf = zzf.zzar(paramContext).zznr();
    if (??? == null)
    {
      localzzaf.zzbu("CampaignTrackingReceiver received null intent");
      return;
    }
    String str = ???.getStringExtra("referrer");
    ??? = ???.getAction();
    localzzaf.zza("CampaignTrackingReceiver received", ???);
    if ((!"com.android.vending.INSTALL_REFERRER".equals(???)) || (TextUtils.isEmpty(str)))
    {
      localzzaf.zzbu("CampaignTrackingReceiver received unexpected intent without referrer extra");
      return;
    }
    boolean bool = CampaignTrackingService.zzap(paramContext);
    if (!bool) {
      localzzaf.zzbu("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
    }
    zzw(paramContext, str);
    ??? = zzmy();
    zzac.zzC(???);
    Intent localIntent = new Intent(paramContext, ???);
    localIntent.putExtra("referrer", str);
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
        zzabh = new WakeLock(paramContext, 1, "Analytics campaign WakeLock");
        zzabh.setReferenceCounted(false);
      }
      zzabh.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzzaf.zzbu("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  protected Class<? extends CampaignTrackingService> zzmy()
  {
    return CampaignTrackingService.class;
  }
  
  protected void zzw(Context paramContext, String paramString) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/CampaignTrackingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */