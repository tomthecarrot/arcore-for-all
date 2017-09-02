package com.google.atap.tango;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class UninstallReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "TangoCore-UninstallReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("TangoCore-UninstallReceiver", "Uninstall detected.");
    paramIntent = paramIntent.getDataString().replaceFirst("package:", "");
    PermissionHelper.revokePermissionFromApp(paramContext, "ADF_LOAD_SAVE_PERMISSION", paramIntent);
    PermissionHelper.revokePermissionFromApp(paramContext, "DATASET_PERMISSION", paramIntent);
    Log.i("TangoCore-UninstallReceiver", "Tango permissions revoked for " + paramIntent);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/UninstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */