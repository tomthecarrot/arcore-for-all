package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zze;

public abstract class GCoreWakefulBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  private static String TAG = "GCoreWakefulBroadcastReceiver";
  
  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (paramContext != null)
    {
      zze.zzAH().zze(paramContext, paramIntent);
      return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
    }
    String str = TAG;
    paramContext = String.valueOf(paramIntent.toUri(0));
    if (paramContext.length() != 0) {}
    for (paramContext = "context shouldn't be null. intent: ".concat(paramContext);; paramContext = new String("context shouldn't be null. intent: "))
    {
      Log.w(str, paramContext);
      break;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName = zzg(paramContext, paramIntent);
    if (localComponentName == null) {
      return null;
    }
    zze localzze = zze.zzAH();
    String str = String.valueOf(localComponentName.flattenToShortString());
    if (str.length() != 0) {}
    for (str = "wake:".concat(str);; str = new String("wake:"))
    {
      localzze.zza(paramContext, paramIntent, str, TAG, null, 1, "com.google.android.gms");
      return localComponentName;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent, String paramString)
  {
    return zza(paramContext, paramIntent, paramString, paramContext.getPackageName());
  }
  
  public static ComponentName zza(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    ComponentName localComponentName = zzg(paramContext, paramIntent);
    if (localComponentName == null) {
      return null;
    }
    zze.zzAH().zza(paramContext, paramIntent, paramString1, TAG, null, 1, paramString2);
    return localComponentName;
  }
  
  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  private static ComponentName zzg(Context paramContext, Intent paramIntent)
  {
    paramIntent.putExtra("WAKE_LOCK_KEY", zzc.zzd(paramContext, paramIntent));
    return WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/stats/GCoreWakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */