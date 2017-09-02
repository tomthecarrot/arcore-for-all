package com.google.android.gms.location.settings;

import android.accounts.Account;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SettingsClient
{
  @Deprecated
  public static final String LOCATION_HISTORY_ACTION = "com.google.android.gms.location.settings.LOCATION_HISTORY";
  
  public static Intent getLocationHistoryIntent(Account paramAccount)
  {
    Intent localIntent = new Intent("com.google.android.gms.location.settings.LOCATION_HISTORY");
    if (paramAccount != null) {
      localIntent.putExtra("account", paramAccount);
    }
    return localIntent;
  }
  
  public static void launchGoogleLocationSettings(Context paramContext)
  {
    zzO(paramContext, "com.google.android.gms.location.settings.GOOGLE_LOCATION_SETTINGS");
  }
  
  private static void zzO(Context paramContext, String paramString)
  {
    paramString = new Intent(paramString);
    paramString.setFlags(268435456);
    paramString.setPackage("com.google.android.gms");
    try
    {
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramString);
      Log.e("GCoreLocationSettings", String.valueOf(paramContext).length() + 40 + "Problem while starting settings activity" + paramContext);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/settings/SettingsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */