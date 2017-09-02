package com.google.tango;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.atap.tango.TangoServiceJNINative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DatasetFileProvider
  extends ContentProvider
{
  private static final String AUTHORITY = "com.google.tango.fileprovider.v1";
  private static final String[] CURRENT_UUID_COLUMNS = { "current_uuid" };
  private static final String[] DIR_LIST_COLUMNS;
  private static final String PATHNAME = "datasets";
  private static final String TAG = DatasetFileProvider.class.getSimpleName();
  private File mRoot;
  
  static
  {
    DIR_LIST_COLUMNS = new String[] { "name", "is_directory" };
  }
  
  private String getCallingPackageName()
  {
    return "";
  }
  
  private File getFileForUri(Uri paramUri)
  {
    paramUri = mapUriToPackageUri(paramUri).getEncodedPath();
    int i = paramUri.indexOf('/', 1);
    return new File(this.mRoot, Uri.decode(paramUri.substring(i + 1)));
  }
  
  private Uri mapUriToPackageUri(Uri paramUri)
  {
    Object localObject1 = paramUri.getPathSegments();
    if ((((List)localObject1).size() < 1) || (!((String)((List)localObject1).get(0)).equals("datasets"))) {
      throw new RuntimeException("unexpected structure of path uri=" + paramUri.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("content://");
    localStringBuilder.append("com.google.tango.fileprovider.v1");
    localStringBuilder.append('/');
    localStringBuilder.append("datasets");
    localStringBuilder.append('/');
    localStringBuilder.append(getCallingPackageName());
    Object localObject2 = new StringBuilder(this.mRoot.getAbsolutePath());
    ((StringBuilder)localObject2).append('/');
    ((StringBuilder)localObject2).append(getCallingPackageName());
    int i = 1;
    while (i < ((List)localObject1).size())
    {
      localStringBuilder.append('/');
      localStringBuilder.append((String)((List)localObject1).get(i));
      ((StringBuilder)localObject2).append('/');
      ((StringBuilder)localObject2).append(Uri.decode((String)((List)localObject1).get(i)));
      i += 1;
    }
    try
    {
      localObject1 = new File(((StringBuilder)localObject2).toString()).getCanonicalPath();
      localObject2 = new File(this.mRoot, getCallingPackageName()).getAbsolutePath();
      if (!((String)localObject1).equals(localObject2))
      {
        boolean bool = ((String)localObject1).startsWith((String)localObject2 + "/");
        if (!bool) {}
      }
      else
      {
        return Uri.parse(localStringBuilder.toString());
      }
      throw new SecurityException("mapUriToPackageUri isolation check fail, uri=" + paramUri);
    }
    catch (IOException paramUri)
    {
      throw new RuntimeException(paramUri);
    }
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (getFileForUri(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return "application/octet-stream";
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts yet");
  }
  
  public boolean onCreate()
  {
    try
    {
      this.mRoot = new File(getContext().getFilesDir(), "datasets").getCanonicalFile();
      return true;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    return ParcelFileDescriptor.open(getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i;
    if (paramUri.equals(Uri.parse("content://com.google.tango.fileprovider.v1/datasets/current.uuid")))
    {
      paramArrayOfString1 = new MatrixCursor(CURRENT_UUID_COLUMNS, 1);
      paramUri = new String[1];
      i = TangoServiceJNINative.GetCurrentDatasetUuid(paramUri);
      if (i != 0) {
        Log.e(TAG, "getCurrentDatasetUuid error, result=" + i);
      }
    }
    int k;
    label142:
    do
    {
      return paramArrayOfString1;
      paramArrayOfString1.addRow(new Object[] { paramUri[0] });
      return paramArrayOfString1;
      paramArrayOfString1 = getFileForUri(paramUri);
      if (!paramArrayOfString1.exists()) {
        return new MatrixCursor(DIR_LIST_COLUMNS, 0);
      }
      if (!paramArrayOfString1.isDirectory()) {
        break;
      }
      paramUri = paramArrayOfString1.listFiles();
      paramString1 = new MatrixCursor(DIR_LIST_COLUMNS, paramUri.length);
      k = paramUri.length;
      i = 0;
      paramArrayOfString1 = paramString1;
    } while (i >= k);
    paramArrayOfString1 = paramUri[i];
    paramArrayOfString2 = paramArrayOfString1.getName();
    if (paramArrayOfString1.isDirectory()) {}
    for (int j = 1;; j = 0)
    {
      paramString1.addRow(new Object[] { paramArrayOfString2, Integer.valueOf(j) });
      i += 1;
      break label142;
      paramUri = new File[1];
      paramUri[0] = paramArrayOfString1;
      break;
    }
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/DatasetFileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */