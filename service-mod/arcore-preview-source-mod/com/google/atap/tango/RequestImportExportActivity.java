package com.google.atap.tango;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.atap.tangoservice.TangoException;

public class RequestImportExportActivity
  extends Activity
  implements RequestImportExportDialog.RequestImportExportListener
{
  public static final String EXTRA_KEY_DESTINATIONFILE = "DESTINATION_FILE";
  public static final String EXTRA_KEY_DESTINATIONUUID = "DESTINATION_UUID";
  public static final String EXTRA_KEY_ORIGINALPACKAGE = "ORIGINALPACKAGE";
  public static final String EXTRA_KEY_SOURCEFILE = "SOURCE_FILE";
  public static final String EXTRA_KEY_SOURCEUUID = "SOURCE_UUID";
  private static final int PERMISSIONS_REQUEST_CODE = 42;
  private static final String TAG = RequestImportExportActivity.class.getSimpleName();
  private String mAppName;
  private String mDestinationFilename;
  private String mSourceFile;
  private String mSourceUuid;
  private TangoInternal mTangoInternal;
  
  private void showDialog()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 42);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if ((RequestImportExportActivity.this.mSourceUuid != null) && (RequestImportExportActivity.this.mDestinationFilename != null))
        {
          RequestImportExportDialog.newInstance(RequestImportExportActivity.this.getString(2131099687), RequestImportExportActivity.this.mAppName).show(RequestImportExportActivity.this.getFragmentManager(), RequestPermissionDialog.class.getSimpleName());
          return;
        }
        if (RequestImportExportActivity.this.mSourceFile != null)
        {
          RequestImportExportDialog.newInstance(RequestImportExportActivity.this.getString(2131099688), RequestImportExportActivity.this.mAppName).show(RequestImportExportActivity.this.getFragmentManager(), RequestPermissionDialog.class.getSimpleName());
          return;
        }
        Log.e(RequestImportExportActivity.TAG, "Invalid request. Must set source file for importing OR source uuid + destination file for exporting.");
        RequestImportExportActivity.this.setResult(0);
        RequestImportExportActivity.this.finish();
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getCallingPackage();
    paramBundle = (Bundle)localObject;
    if (((String)localObject).equals("com.projecttango.tango")) {
      paramBundle = getIntent().getStringExtra("ORIGINALPACKAGE");
    }
    localObject = getApplicationContext().getPackageManager();
    this.mAppName = paramBundle;
    try
    {
      paramBundle = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramBundle, 0));
      if (paramBundle != null) {
        this.mAppName = paramBundle.toString();
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;) {}
    }
    this.mSourceUuid = getIntent().getStringExtra("SOURCE_UUID");
    this.mDestinationFilename = getIntent().getStringExtra("DESTINATION_FILE");
    this.mSourceFile = getIntent().getStringExtra("SOURCE_FILE");
    this.mTangoInternal = new TangoInternal(this, new Runnable()
    {
      public void run()
      {
        RequestImportExportActivity.this.showDialog();
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mTangoInternal.disconnect();
  }
  
  public void onExportAccepted()
  {
    try
    {
      this.mTangoInternal.exportAreaDescriptionFile(this.mSourceUuid, this.mDestinationFilename);
      Log.i(TAG, "Exported " + this.mSourceUuid + " to " + this.mDestinationFilename);
      setResult(-1);
      finish();
      return;
    }
    catch (TangoException localTangoException)
    {
      for (;;)
      {
        localTangoException.printStackTrace();
        setResult(0);
      }
    }
  }
  
  public void onImportAccepted()
  {
    try
    {
      String str = this.mTangoInternal.importAreaDescriptionFile(this.mSourceFile);
      Log.i(TAG, "Imported:" + str);
      Intent localIntent = new Intent();
      localIntent.putExtra("DESTINATION_UUID", str);
      setResult(-1, localIntent);
      finish();
      return;
    }
    catch (TangoException localTangoException)
    {
      for (;;)
      {
        localTangoException.printStackTrace();
        setResult(0);
      }
    }
  }
  
  public void onImportExportDenied()
  {
    Log.i(TAG, "Import/Export permission denied.");
    setResult(0);
    finish();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0)
    {
      showDialog();
      return;
    }
    Log.i(TAG, "Unable to perform import/export without SD card permissions.");
    setResult(0);
    finish();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/RequestImportExportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */