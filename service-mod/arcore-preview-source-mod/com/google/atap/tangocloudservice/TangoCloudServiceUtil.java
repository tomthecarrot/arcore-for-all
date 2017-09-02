package com.google.atap.tangocloudservice;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class TangoCloudServiceUtil
{
  public static final String ACTION_CANCEL = "CANCEL";
  public static final String DEFAULT_ADF_DIR_PATH = "/data/data/com.google.tango/files/Cloud/";
  public static final String MANUAL_TRIGGER = "MANUAL";
  public static final String SCHEDULED_TRIGGER = "SCHEDULED";
  public static final String TAG = "TangoCloudService";
  public static final String TRIGGER_TYPE = "TRIGGERTYPE";
  
  public static boolean isCharging(Context paramContext)
  {
    int i = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
    return (i == 2) || (i == 5);
  }
  
  public static boolean isUnmeteredWifiConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return (paramContext.getNetworkInfo(1).isConnected()) && (!paramContext.isActiveNetworkMetered());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudservice/TangoCloudServiceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */