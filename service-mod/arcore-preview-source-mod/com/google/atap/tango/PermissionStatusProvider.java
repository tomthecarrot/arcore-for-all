package com.google.atap.tango;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class PermissionStatusProvider
  extends ContentProvider
{
  private static final String TAG = PermissionStatusProvider.class.getSimpleName();
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  @TargetApi(19)
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramUri = paramUri.getPath().replace("/", "");
    if (paramUri.equals("MOTION_TRACKING_PERMISSION"))
    {
      Log.w(TAG, "You no longer need to request motion tracking permissions.");
      return new MatrixCursor(new String[] { "" });
    }
    paramUri = PermissionHelper.getPermissionFilename(paramUri);
    if (TextUtils.isEmpty(paramUri))
    {
      Log.e(TAG, "Invalid permission type set!");
      return null;
    }
    paramUri = PermissionHelper.getPermissionFileContent(getContext(), paramUri).split("\n");
    int j = paramUri.length;
    int i = 0;
    while (i < j)
    {
      if (paramUri[i].equals(getCallingPackage()))
      {
        Log.i(TAG, "Permission was already granted.");
        return new MatrixCursor(new String[] { "" });
      }
      i += 1;
    }
    Log.i(TAG, "No permissions.");
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionStatusProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */