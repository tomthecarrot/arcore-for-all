package com.google.atap.tangoutilitylib;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResourceHelper
{
  private static final String ENCODING = "UTF-8";
  private static final String TAG = ResourceHelper.class.getSimpleName();
  
  public static String getResult(URL paramURL)
    throws IOException
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setDoInput(true);
    paramURL.setDoOutput(true);
    return toString(paramURL.getInputStream());
  }
  
  public static String getResultFromFile(String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    try
    {
      String str = toString(localFileInputStream);
      return str;
    }
    catch (IOException localIOException)
    {
      Log.e(TAG, "Error opening file: " + paramString);
      return "";
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static String getResultFromRawResource(int paramInt, Context paramContext)
    throws IOException
  {
    paramContext = paramContext.getResources().openRawResource(paramInt);
    try
    {
      String str = toString(paramContext);
      return str;
    }
    catch (IOException localIOException)
    {
      Log.e(TAG, "Error opening raw resource with id: " + paramInt);
      return "";
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static void saveAssetToSDcard(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = Environment.getExternalStorageDirectory().toString().concat("/" + paramString2);
    try
    {
      Object localObject = new File(paramString2);
      if (!((File)localObject).getParentFile().exists()) {
        ((File)localObject).getParentFile().mkdirs();
      }
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream((File)localObject);
      localObject = new byte['Ѐ'];
      for (;;)
      {
        int i = paramContext.read((byte[])localObject);
        if (i <= 0) {
          break;
        }
        paramString1.write((byte[])localObject, 0, i);
      }
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      System.out.println(paramContext.getMessage() + " in the specified directory.");
      return;
      paramContext.close();
      paramString1.close();
      System.out.println(paramString2 + " copied.");
      return;
    }
    catch (IOException paramContext)
    {
      System.out.println(paramContext.getMessage());
    }
  }
  
  public static void saveStringToFile(String paramString1, String paramString2)
    throws IOException
  {
    File localFile = new File(paramString1);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    paramString1 = new FileOutputStream(new File(paramString1));
    paramString1.write(paramString2.getBytes());
    paramString1.close();
  }
  
  public static String toString(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInputStream != null)
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append('\n');
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoutilitylib/ResourceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */