package com.google.atap.tango;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.atap.tangocloudservice.TangoUserDataUploadService;

public class UploadUserSegmentsActivity
  extends Activity
{
  private static final String TAG = UploadUserSegmentsActivity.class.getSimpleName();
  
  public static boolean hasUserSegments()
  {
    return TangoUserDataUploadService.getNumberOfUserSegments() != 0;
  }
  
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
    Intent localIntent = new Intent(localContext, TangoUserDataUploadService.class);
    localIntent.putExtra("TRIGGERTYPE", "MANUAL");
    startService(localIntent);
    Toast.makeText(localContext, "Launched upload data service in background.", 1).show();
    finish();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/UploadUserSegmentsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */