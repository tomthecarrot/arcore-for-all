package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzac;

class zzag
  extends BroadcastReceiver
{
  static final String zzafo = zzag.class.getName();
  private final zzf zzadx;
  private boolean zzafp;
  private boolean zzafq;
  
  zzag(zzf paramzzf)
  {
    zzac.zzC(paramzzf);
    this.zzadx = paramzzf;
  }
  
  private Context getContext()
  {
    return this.zzadx.getContext();
  }
  
  private zzb zzmF()
  {
    return this.zzadx.zzmF();
  }
  
  private zzaf zznr()
  {
    return this.zzadx.zznr();
  }
  
  private void zzpx()
  {
    zznr();
    zzmF();
  }
  
  public boolean isConnected()
  {
    if (!this.zzafp) {
      this.zzadx.zznr().zzbu("Connectivity unknown. Receiver not registered");
    }
    return this.zzafq;
  }
  
  protected boolean isNetworkConnected()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
  
  public boolean isRegistered()
  {
    return this.zzafp;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzpx();
    paramContext = paramIntent.getAction();
    this.zzadx.zznr().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = isNetworkConnected();
      if (this.zzafq != bool)
      {
        this.zzafq = bool;
        zzmF().zzR(bool);
      }
    }
    do
    {
      return;
      if (!"com.google.analytics.RADIO_POWERED".equals(paramContext)) {
        break;
      }
    } while (paramIntent.hasExtra(zzafo));
    zzmF().zznn();
    return;
    this.zzadx.zznr().zzd("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    if (!isRegistered()) {
      return;
    }
    this.zzadx.zznr().zzbr("Unregistering connectivity change receiver");
    this.zzafp = false;
    this.zzafq = false;
    Context localContext = getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zznr().zze("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzpw()
  {
    zzpx();
    if (this.zzafp) {
      return;
    }
    Context localContext = getContext();
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(localContext.getPackageName());
    localContext.registerReceiver(this, localIntentFilter);
    this.zzafq = isNetworkConnected();
    this.zzadx.zznr().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzafq));
    this.zzafp = true;
  }
  
  public void zzpy()
  {
    int i = Build.VERSION.SDK_INT;
    Context localContext = getContext();
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(localContext.getPackageName());
    localIntent.putExtra(zzafo, true);
    localContext.sendOrderedBroadcast(localIntent, null);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */