package com.google.atap.tango;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import com.google.atap.tangocloudservice.TangoCloudScheduler;
import com.google.atap.tangoservice.TangoErrorException;

public class CoreUpdateReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "TangoCore-CoreUpdateReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("TangoCore-CoreUpdateReceiver", "Update detected.");
    BootReceiver.copyLibs(paramContext, true);
    BootReceiver.copyAllFiles(paramContext);
    boolean bool = BootReceiver.isTangoDevKitDevice();
    int i = 0;
    int k = 0;
    int j = 0;
    int m = 0;
    if (bool) {
      paramIntent = new TangoInternal(paramContext, null);
    }
    try
    {
      paramIntent.disconnect();
      j = 1;
      i = k;
    }
    catch (TangoErrorException paramIntent)
    {
      for (;;)
      {
        try
        {
          i = paramContext.getPackageManager().getPackageInfo("com.google.tango", 0).versionCode;
          paramIntent.edit().putInt("VERSION_AT_LAST_TANGO_RESTART", i).commit();
          return;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
        paramIntent = paramIntent;
        Log.d("TangoCore-CoreUpdateReceiver", "Caught expected TangoErrorException.");
        i = 1;
        j = m;
      }
    }
    catch (SecurityException paramIntent)
    {
      for (;;)
      {
        Log.d("TangoCore-CoreUpdateReceiver", "Caught SecurityException. This suggests an old service.");
        i = k;
        j = m;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.d("TangoCore-CoreUpdateReceiver", "Caught unhandled exception:", paramIntent);
        i = k;
        j = m;
        continue;
        Log.i("TangoCore-CoreUpdateReceiver", "Project Tango has been updated. Please reboot.");
        Toast.makeText(paramContext, "Project Tango has been updated. Please reboot.", 1).show();
      }
    }
    TangoRunner.runTango(paramContext);
    if ((!bool) || (j != 0) || (i != 0))
    {
      Log.i("TangoCore-CoreUpdateReceiver", "Project Tango has been updated. Please restart any running Project Tango applications.");
      Toast.makeText(paramContext, "Project Tango has been updated. Please restart any running Project Tango applications.", 1).show();
      TangoCloudScheduler.newScheduler(paramContext).schedule();
      paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/CoreUpdateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */