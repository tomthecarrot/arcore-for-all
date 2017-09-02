package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String zzbAL = "google.com/iid";
  private static String zzbAM = "CMD";
  private static String zzbxk = "gcm.googleapis.com/refresh";
  MessengerCompat zzbAJ = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      InstanceIDListenerService.zza(InstanceIDListenerService.this, paramAnonymousMessage, MessengerCompat.zzc(paramAnonymousMessage));
    }
  });
  BroadcastReceiver zzbAK = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramAnonymousIntent.getStringExtra("registration_id");
        paramAnonymousContext = String.valueOf(paramAnonymousIntent.getExtras());
        Log.d("InstanceID", String.valueOf(paramAnonymousContext).length() + 46 + "Received GSF callback using dynamic receiver: " + paramAnonymousContext);
      }
      InstanceIDListenerService.this.zzq(paramAnonymousIntent);
      InstanceIDListenerService.this.stop();
    }
  };
  int zzbAN;
  int zzbAO;
  
  static void zza(Context paramContext, zzc paramzzc)
  {
    paramzzc.zzJU();
    paramzzc = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzc.putExtra(zzbAM, "RST");
    paramzzc.setPackage(paramContext.getPackageName());
    paramContext.startService(paramzzc);
  }
  
  private void zza(Message paramMessage, int paramInt)
  {
    Rpc.findAppIDPackage(this);
    getPackageManager();
    if ((paramInt != Rpc.zzbAU) && (paramInt != Rpc.zzbAT))
    {
      int i = Rpc.zzbAT;
      int j = Rpc.zzbAU;
      Log.w("InstanceID", 77 + "Message from unexpected caller " + paramInt + " mine=" + i + " appid=" + j);
      return;
    }
    zzq((Intent)paramMessage.obj);
  }
  
  static void zzbF(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(zzbAM, "SYNC");
    paramContext.startService(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return this.zzbAJ.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(this.zzbAK, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.zzbAK);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zznq(paramInt2);
    if (paramIntent == null)
    {
      stop();
      return 2;
    }
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        zzq(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  public void onTokenRefresh() {}
  
  void stop()
  {
    try
    {
      this.zzbAN -= 1;
      if (this.zzbAN == 0) {
        stopSelf(this.zzbAO);
      }
      if (Log.isLoggable("InstanceID", 3))
      {
        int i = this.zzbAN;
        int j = this.zzbAO;
        Log.d("InstanceID", 28 + "Stop " + i + " " + j);
      }
      return;
    }
    finally {}
  }
  
  public void zzaO(boolean paramBoolean)
  {
    onTokenRefresh();
  }
  
  void zznq(int paramInt)
  {
    try
    {
      this.zzbAN += 1;
      if (paramInt > this.zzbAO) {
        this.zzbAO = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void zzq(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("subtype");
    Object localObject1;
    String str1;
    if (str2 == null)
    {
      localObject1 = InstanceID.getInstance(this);
      str1 = paramIntent.getStringExtra(zzbAM);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label131;
      }
      if (Log.isLoggable("InstanceID", 3))
      {
        str1 = String.valueOf(str2);
        if (str1.length() == 0) {
          break label117;
        }
        str1 = "Register result in service ".concat(str1);
        label76:
        Log.d("InstanceID", str1);
      }
      ((InstanceID)localObject1).zzJR().zzE(paramIntent);
    }
    label117:
    label131:
    do
    {
      return;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("subtype", str2);
      localObject1 = InstanceID.getInstance(this, (Bundle)localObject1);
      break;
      str1 = new String("Register result in service ");
      break label76;
      Object localObject2;
      if (Log.isLoggable("InstanceID", 3))
      {
        localObject2 = String.valueOf(paramIntent.getExtras());
        Log.d("InstanceID", String.valueOf(str2).length() + 18 + String.valueOf(str1).length() + String.valueOf(localObject2).length() + "Service command " + str2 + " " + str1 + " " + (String)localObject2);
      }
      if (paramIntent.getStringExtra("unregistered") != null)
      {
        localObject2 = ((InstanceID)localObject1).zzJQ();
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ((zzc)localObject2).zzeK(str1);
        ((InstanceID)localObject1).zzJR().zzE(paramIntent);
        return;
      }
      if (zzbxk.equals(paramIntent.getStringExtra("from")))
      {
        ((InstanceID)localObject1).zzJQ().zzeK(str2);
        zzaO(false);
        return;
      }
      if ("RST".equals(str1))
      {
        ((InstanceID)localObject1).zzJP();
        zzaO(true);
        return;
      }
      if (!"RST_FULL".equals(str1)) {
        break label348;
      }
    } while (((InstanceID)localObject1).zzJQ().isEmpty());
    ((InstanceID)localObject1).zzJQ().zzJU();
    zzaO(true);
    return;
    label348:
    if ("SYNC".equals(str1))
    {
      ((InstanceID)localObject1).zzJQ().zzeK(str2);
      zzaO(false);
      return;
    }
    "PING".equals(str1);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/iid/InstanceIDListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */