package com.google.atap.tango;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;
import com.google.atap.tangocloudservice.TangoCloudAdfDownloadService;

public class DownloadCloudAdfsActivity
  extends Activity
{
  private static final int REQUEST_LOCATION_PERMISSION = 1;
  private static final String TAG = DownloadCloudAdfsActivity.class.getSimpleName();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.d(TAG, "onCreate()");
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d(TAG, "onResume()");
    Context localContext = getApplicationContext();
    if (ContextCompat.checkSelfPermission(localContext, "android.permission.ACCESS_FINE_LOCATION") != 0)
    {
      ActivityCompat.requestPermissions(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
      finish();
      return;
    }
    Intent localIntent = new Intent(localContext, TangoCloudAdfDownloadService.class);
    localIntent.putExtra("TRIGGERTYPE", "MANUAL");
    startService(localIntent);
    Toast.makeText(localContext, "Launched cloud ADF download in background.", 1).show();
    finish();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/DownloadCloudAdfsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */