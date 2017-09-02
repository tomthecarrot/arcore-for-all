package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

public class GcmReceiver
  extends WakefulBroadcastReceiver
{
  private static String zzbxk = "gcm.googleapis.com/refresh";
  
  private void doStartService(Context paramContext, Intent paramIntent)
  {
    if (isOrderedBroadcast()) {
      setResultCode(500);
    }
    zzf(paramContext, paramIntent);
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        paramContext = startWakefulService(paramContext, paramIntent);
      }
      while (paramContext == null)
      {
        Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
        if (!isOrderedBroadcast()) {
          return;
        }
        setResultCode(404);
        return;
        paramContext = paramContext.startService(paramIntent);
        Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", paramContext);
      if (isOrderedBroadcast())
      {
        setResultCode(401);
        return;
        if (isOrderedBroadcast()) {
          setResultCode(-1);
        }
      }
    }
  }
  
  private void zzf(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if ((localObject == null) || (((ResolveInfo)localObject).serviceInfo == null))
    {
      Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
      return;
    }
    localObject = ((ResolveInfo)localObject).serviceInfo;
    if ((!paramContext.getPackageName().equals(((ServiceInfo)localObject).packageName)) || (((ServiceInfo)localObject).name == null))
    {
      paramContext = String.valueOf(((ServiceInfo)localObject).packageName);
      paramIntent = String.valueOf(((ServiceInfo)localObject).name);
      Log.e("GcmReceiver", String.valueOf(paramContext).length() + 94 + String.valueOf(paramIntent).length() + "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + paramContext + "/" + paramIntent);
      return;
    }
    String str = ((ServiceInfo)localObject).name;
    localObject = str;
    if (str.startsWith("."))
    {
      localObject = String.valueOf(paramContext.getPackageName());
      str = String.valueOf(str);
      if (str.length() != 0) {
        localObject = ((String)localObject).concat(str);
      }
    }
    else if (Log.isLoggable("GcmReceiver", 3))
    {
      str = String.valueOf(localObject);
      if (str.length() == 0) {
        break label237;
      }
    }
    label237:
    for (str = "Restricting intent to a specific service: ".concat(str);; str = new String("Restricting intent to a specific service: "))
    {
      Log.d("GcmReceiver", str);
      paramIntent.setClassName(paramContext.getPackageName(), (String)localObject);
      return;
      localObject = new String((String)localObject);
      break;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18) {
      paramIntent.removeCategory(paramContext.getPackageName());
    }
    String str = paramIntent.getStringExtra("from");
    if (("com.google.android.c2dm.intent.REGISTRATION".equals(paramIntent.getAction())) || ("google.com/iid".equals(str)) || (zzbxk.equals(str))) {
      paramIntent.setAction("com.google.android.gms.iid.InstanceID");
    }
    str = paramIntent.getStringExtra("gcm.rawData64");
    if (str != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    if ("com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
      onStartWakefulService(paramContext, paramIntent);
    }
    for (;;)
    {
      if ((isOrderedBroadcast()) && (getResultCode() == 0)) {
        setResultCode(-1);
      }
      return;
      doStartService(paramContext, paramIntent);
    }
  }
  
  public void onStartWakefulService(Context paramContext, Intent paramIntent)
  {
    doStartService(paramContext, paramIntent);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/GcmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */