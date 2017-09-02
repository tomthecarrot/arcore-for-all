package com.google.atap.tango;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class ClearAdfActivity
  extends Activity
  implements ClearAdfDialogFragment.ClearAdfDialogListener
{
  private TangoInternal mTangoInternal;
  
  public static boolean hasAdfFiles(Context paramContext, TangoInternal paramTangoInternal)
  {
    String str1 = PermissionHelper.getPermissionFilename("ADF_LOAD_SAVE_PERMISSION");
    String str2 = PermissionHelper.getPermissionFileContent(paramContext, str1);
    PermissionHelper.givePermissionToApp(paramContext, paramContext.getPackageName(), str1, str2);
    boolean bool = paramTangoInternal.hasAdfs();
    PermissionHelper.revokePermissionFromApp(paramContext, "ADF_LOAD_SAVE_PERMISSION", paramContext.getPackageName());
    return bool;
  }
  
  private void showFragment()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ClearAdfDialogFragment.newInstance().show(ClearAdfActivity.this.getFragmentManager(), ClearAdfDialogFragment.class.getSimpleName());
      }
    });
  }
  
  public void onClearAdfRequested()
  {
    String str1 = PermissionHelper.getPermissionFilename("ADF_LOAD_SAVE_PERMISSION");
    String str2 = PermissionHelper.getPermissionFileContent(this, str1);
    PermissionHelper.givePermissionToApp(this, getPackageName(), str1, str2);
    this.mTangoInternal.clearAllAdfs();
    PermissionHelper.revokePermissionFromApp(this, "ADF_LOAD_SAVE_PERMISSION", getPackageName());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mTangoInternal.disconnect();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mTangoInternal = new TangoInternal(this, new Runnable()
    {
      public void run()
      {
        ClearAdfActivity.this.showFragment();
      }
    });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/ClearAdfActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */