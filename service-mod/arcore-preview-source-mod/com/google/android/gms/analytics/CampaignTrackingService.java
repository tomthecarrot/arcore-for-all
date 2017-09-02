package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzs;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.stats.WakeLock;

public class CampaignTrackingService
  extends Service
{
  private static Boolean zzabj;
  private Handler mHandler;
  
  private Handler getHandler()
  {
    Handler localHandler2 = this.mHandler;
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null)
    {
      localHandler1 = new Handler(getMainLooper());
      this.mHandler = localHandler1;
    }
    return localHandler1;
  }
  
  public static boolean zzap(Context paramContext)
  {
    zzac.zzC(paramContext);
    if (zzabj != null) {
      return zzabj.booleanValue();
    }
    boolean bool = zzao.zzy(paramContext, "com.google.android.gms.analytics.CampaignTrackingService");
    zzabj = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzmz()
  {
    try
    {
      synchronized (CampaignTrackingReceiver.zzuq)
      {
        WakeLock localWakeLock = CampaignTrackingReceiver.zzabh;
        if ((localWakeLock != null) && (localWakeLock.isHeld())) {
          localWakeLock.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onCreate()
  {
    super.onCreate();
    zzf.zzar(this).zznr().zzbr("CampaignTrackingService is starting up");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onDestroy()
  {
    zzf.zzar(this).zznr().zzbr("CampaignTrackingService is shutting down");
    super.onDestroy();
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzmz();
    zzf localzzf = zzf.zzar(this);
    final zzaf localzzaf = localzzf.zznr();
    paramIntent = paramIntent.getStringExtra("referrer");
    final Handler localHandler = getHandler();
    if (TextUtils.isEmpty(paramIntent))
    {
      localzzaf.zzbu("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
      localzzf.zznt().zzg(new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      return 2;
    }
    paramInt1 = localzzf.zzns().zzoy();
    if (paramIntent.length() <= paramInt1) {}
    for (;;)
    {
      localzzaf.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(paramInt2), paramIntent);
      localzzf.zzmF().zza(paramIntent, new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      return 2;
      localzzaf.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(paramIntent.length()), Integer.valueOf(paramInt1));
      paramIntent = paramIntent.substring(0, paramInt1);
    }
  }
  
  protected void zza(final zzaf paramzzaf, Handler paramHandler, final int paramInt)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        boolean bool = CampaignTrackingService.this.stopSelfResult(paramInt);
        if (bool) {
          paramzzaf.zza("Install campaign broadcast processed", Boolean.valueOf(bool));
        }
      }
    });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/CampaignTrackingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */