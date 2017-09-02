package com.google.atap.tango;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class RequestPermissionActivity
  extends Activity
  implements RequestPermissionDialog.RequestPermissionListener
{
  public static final String EXTRA_KEY_ORIGINALPACKAGE = "ORIGINALPACKAGE";
  public static final String EXTRA_KEY_PERMISSIONTYPE = "PERMISSIONTYPE";
  public static final String EXTRA_VALUE_ADF_LOAD_SAVE = "ADF_LOAD_SAVE_PERMISSION";
  public static final String EXTRA_VALUE_DATASET = "DATASET_PERMISSION";
  public static final String EXTRA_VALUE_MOTION_TRACKING = "MOTION_TRACKING_PERMISSION";
  private static final String TAG = RequestPermissionActivity.class.getSimpleName();
  private String mPermissionFileContent;
  private String mPermissionFilename;
  private String mPermissionType;
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    localObject1 = getCallingPackage();
    if (localObject1 == null)
    {
      Log.e(TAG, "RequestPermissionActivity must be started by startActivityForResult.");
      setResult(0);
      finish();
      return;
    }
    paramBundle = (Bundle)localObject1;
    if (((String)localObject1).equals("com.projecttango.tango")) {
      paramBundle = getIntent().getStringExtra("ORIGINALPACKAGE");
    }
    Object localObject2 = getApplicationContext().getPackageManager();
    localObject1 = paramBundle;
    try
    {
      CharSequence localCharSequence = ((PackageManager)localObject2).getApplicationLabel(((PackageManager)localObject2).getApplicationInfo(paramBundle, 0));
      localObject2 = localObject1;
      if (localCharSequence != null) {
        localObject2 = localCharSequence.toString();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int j;
        Object localObject3 = localObject1;
      }
    }
    this.mPermissionType = getIntent().getStringExtra("PERMISSIONTYPE");
    if (this.mPermissionType == null)
    {
      Log.e(TAG, "No permission type set!");
      setResult(0);
      finish();
      return;
    }
    if (this.mPermissionType.equals("MOTION_TRACKING_PERMISSION"))
    {
      Log.w(TAG, "You no longer need to request motion tracking permissions.");
      setResult(-1);
      finish();
      return;
    }
    this.mPermissionFilename = PermissionHelper.getPermissionFilename(this.mPermissionType);
    if (TextUtils.isEmpty(this.mPermissionFilename))
    {
      Log.e(TAG, "Invalid permission type set!");
      setResult(0);
      finish();
      return;
    }
    this.mPermissionFileContent = PermissionHelper.getPermissionFileContent(this, this.mPermissionFilename);
    localObject1 = this.mPermissionFileContent.split("\n");
    j = localObject1.length;
    while (i < j)
    {
      if (localObject1[i].equals(paramBundle))
      {
        Log.i(TAG, "Permission was already granted.");
        setResult(-1);
        finish();
        return;
      }
      i += 1;
    }
    RequestPermissionDialog.newInstance(paramBundle, (String)localObject2, PermissionHelper.getPermissionType(this, this.mPermissionType)).show(getFragmentManager(), RequestPermissionDialog.class.getSimpleName());
  }
  
  public void onPermissionAccepted(String paramString)
  {
    PermissionHelper.givePermissionToApp(this, paramString, this.mPermissionFilename, this.mPermissionFileContent);
    Log.i(TAG, "Permission granted.");
    setResult(-1);
    finish();
  }
  
  public void onPermissionDenied()
  {
    Log.i(TAG, "Permission denied.");
    setResult(0);
    finish();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/RequestPermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */