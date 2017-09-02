package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

public class zzw
  extends zzd
{
  private boolean zzaeP;
  private boolean zzaeQ;
  private AlarmManager zzaeR = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzw(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private PendingIntent zzpd()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zznA();
    this.zzaeQ = false;
    this.zzaeR.cancel(zzpd());
  }
  
  protected void onInitialize()
  {
    try
    {
      this.zzaeR.cancel(zzpd());
      if (zzns().zzoD() > 0L)
      {
        ActivityInfo localActivityInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
        if ((localActivityInfo != null) && (localActivityInfo.enabled))
        {
          zzbr("Receiver registered. Using alarm for local dispatch.");
          this.zzaeP = true;
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  public void schedule()
  {
    zznA();
    zzac.zza(zzpc(), "Receiver not registered");
    long l1 = zzns().zzoD();
    if (l1 > 0L)
    {
      cancel();
      long l2 = zznq().elapsedRealtime();
      this.zzaeQ = true;
      this.zzaeR.setInexactRepeating(2, l2 + l1, 0L, zzpd());
    }
  }
  
  public boolean zzcJ()
  {
    return this.zzaeQ;
  }
  
  public boolean zzpc()
  {
    return this.zzaeP;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */