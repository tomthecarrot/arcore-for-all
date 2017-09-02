package com.google.android.gms.ads.identifier;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.internal.zzcs.zza;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AdvertisingIdListenerService
  extends Service
{
  private IBinder zzsA;
  private final Object zzsB = new Object();
  private boolean zzsC;
  private volatile int zzsy = -1;
  private ExecutorService zzsz;
  
  private void zzbI()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == this.zzsy) {
      return;
    }
    if (zzy.zzf(this, i))
    {
      this.zzsy = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices.");
  }
  
  public abstract void onAdvertisingIdInfoChanged(AdvertisingIdClient.Info paramInfo);
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.ads.identifier.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.zzsA;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzsz = Executors.newSingleThreadExecutor();
    this.zzsA = new zza(null);
  }
  
  public void onDestroy()
  {
    synchronized (this.zzsB)
    {
      this.zzsC = true;
      this.zzsz.shutdown();
      super.onDestroy();
      return;
    }
  }
  
  private class zza
    extends zzcs.zza
  {
    private zza() {}
    
    public void zzb(final Bundle paramBundle)
    {
      synchronized (AdvertisingIdListenerService.zza(AdvertisingIdListenerService.this))
      {
        if (AdvertisingIdListenerService.zzb(AdvertisingIdListenerService.this)) {
          return;
        }
        AdvertisingIdListenerService.zzc(AdvertisingIdListenerService.this);
        AdvertisingIdListenerService.zzd(AdvertisingIdListenerService.this).execute(new Runnable()
        {
          public void run()
          {
            AdvertisingIdListenerService.this.onAdvertisingIdInfoChanged(new AdvertisingIdClient.Info(paramBundle.getString("ad_id"), paramBundle.getBoolean("lat_enabled")));
          }
        });
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/ads/identifier/AdvertisingIdListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */