package com.google.atap.tango;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.tango.javacommon.FileUtils;

public class PermissionHelper
{
  private static final String PERMISSION_FILE_ADF_LOAD_SAVE = "adf_load_save_permissions.txt";
  private static final String PERMISSION_FILE_DATASET = "dataset_permissions.txt";
  private static final String TAG = PermissionHelper.class.getSimpleName();
  
  public static void createPermissionFilesIfMissing(Context paramContext)
  {
    FileUtils.createFileIfMissing(paramContext, "adf_load_save_permissions.txt");
    FileUtils.createFileIfMissing(paramContext, "dataset_permissions.txt");
  }
  
  public static String[] getAppsWithPermission(Context paramContext, String paramString)
  {
    paramString = getPermissionFilename(paramString);
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.fileExists(paramContext, paramString))) {
      return new String[0];
    }
    paramContext = getPermissionFileContent(paramContext, paramString);
    if (TextUtils.isEmpty(paramContext)) {
      return new String[0];
    }
    return paramContext.split("\n");
  }
  
  public static String getPermissionFileContent(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.fileExists(paramContext, paramString))) {
      return "";
    }
    return FileUtils.readFromFile(paramContext, paramString);
  }
  
  public static String getPermissionFilename(String paramString)
  {
    if (paramString.equals("ADF_LOAD_SAVE_PERMISSION")) {
      return "adf_load_save_permissions.txt";
    }
    if (paramString.equals("DATASET_PERMISSION")) {
      return "dataset_permissions.txt";
    }
    Log.e(TAG, "Invalid permission type set");
    return "";
  }
  
  public static String getPermissionType(Context paramContext, String paramString)
  {
    if (paramString.equals("MOTION_TRACKING_PERMISSION")) {
      return paramContext.getString(2131099689);
    }
    if (paramString.equals("ADF_LOAD_SAVE_PERMISSION")) {
      return paramContext.getString(2131099685);
    }
    if (paramString.equals("DATASET_PERMISSION")) {
      return paramContext.getString(2131099686);
    }
    Log.e(TAG, "Invalid permission type set");
    return "INVALID";
  }
  
  public static String[] getPermissionTypes()
  {
    return new String[] { "ADF_LOAD_SAVE_PERMISSION", "DATASET_PERMISSION" };
  }
  
  public static void givePermissionToApp(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    FileUtils.writeToFile(paramContext, paramString2, paramString3 + paramString1 + "\n");
  }
  
  public static void revokePermissionFromApp(Context paramContext, String paramString1, String paramString2)
  {
    String str1 = "";
    String[] arrayOfString = getAppsWithPermission(paramContext, paramString1);
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      if (str2.equals(paramString2)) {}
      for (;;)
      {
        i += 1;
        break;
        str1 = str1 + str2 + "\n";
      }
    }
    FileUtils.writeToFile(paramContext, getPermissionFilename(paramString1), str1);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */