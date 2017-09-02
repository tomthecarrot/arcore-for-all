package com.google.atap.tango.serviceassets;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.google.tango.javacommon.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConfigAssetUtils
{
  private static final String FONT_DESTINATION = "font.bff";
  private static final String FONT_SOURCE = "font-yellowstone.bff";
  private static final String INVERTED_MULTI_INDICES = "lens_invariant_ocvfreak/inverted_multi_indices";
  private static final String PRODUCT_QUANTIZERS = "lens_invariant_ocvfreak/product_quantizers";
  private static final String PROJECTION_MATRICES = "lens_invariant_ocvfreak/projection_matrices";
  private static final String TAG = ConfigAssetUtils.class.getSimpleName();
  
  public static void copyAssetsToConfig(Context paramContext, String paramString)
    throws IOException
  {
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString);
      AssetManager localAssetManager = paramContext.getAssets();
      String str = getConfigAssetPath(paramContext).concat(paramString);
      paramContext = new File(str).getAbsoluteFile();
      if (!paramContext.isDirectory())
      {
        Log.i(TAG, "Destination directory doesn't exist, creating directory: " + str);
        if ((!paramContext.mkdirs()) && (!paramContext.isDirectory())) {
          Log.e(TAG, "Could not create output directory: " + str);
        }
      }
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        paramContext = arrayOfString[i];
        if (paramContext.contains("sha1")) {}
        for (;;)
        {
          i += 1;
          break;
          try
          {
            Object localObject = new File(str, paramContext);
            if (!((File)localObject).exists())
            {
              localObject = new FileOutputStream((File)localObject);
              InputStream localInputStream = localAssetManager.open(paramString + "/" + paramContext);
              FileUtils.copyStream(localInputStream, (OutputStream)localObject);
              localInputStream.close();
              ((OutputStream)localObject).flush();
              ((OutputStream)localObject).close();
              Log.i(TAG, "Copied " + str + "/" + paramContext);
            }
          }
          catch (FileNotFoundException paramString)
          {
            paramContext = "Failed to open " + paramContext + " for output";
            Log.e(TAG, paramContext, paramString);
            throw new IOException(paramContext, paramString);
            Log.i(TAG, "Skipped the pre-existing " + str + "/" + paramContext);
          }
          catch (IOException paramString)
          {
            paramContext = "Failed to copy asset file: " + paramContext;
            Log.e(TAG, paramContext, paramString);
            throw new IOException(paramContext, paramString);
          }
        }
      }
    }
    catch (IOException paramContext)
    {
      paramString = "Failed to get asset file list for folder: " + paramString;
      Log.e(TAG, paramString, paramContext);
      throw new IOException(paramString, paramContext);
    }
  }
  
  public static void copyFontAssets(Context paramContext)
    throws IOException
  {
    String str = paramContext.getFilesDir().toString().concat("/font.bff");
    try
    {
      Object localObject = new File(str);
      if (!((File)localObject).exists())
      {
        localObject = new FileOutputStream((File)localObject);
        paramContext = paramContext.getAssets().open("font-yellowstone.bff");
        FileUtils.copyStream(paramContext, (OutputStream)localObject);
        paramContext.close();
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        Log.i(TAG, "Copied " + str);
        return;
      }
      Log.i(TAG, "Skipped the pre-existing " + str);
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e(TAG, "Failed to open font-yellowstone.bff for output", paramContext);
      throw new IOException("Failed to open font-yellowstone.bff for output", paramContext);
    }
    catch (IOException paramContext)
    {
      Log.e(TAG, "Failed to copy asset file: font-yellowstone.bff", paramContext);
      throw new IOException("Failed to copy asset file: font-yellowstone.bff", paramContext);
    }
  }
  
  public static void copyLoopClosureAssetsToConfig(Context paramContext)
    throws IOException
  {
    copyAssetsToConfig(paramContext, "lens_invariant_ocvfreak/inverted_multi_indices");
    copyAssetsToConfig(paramContext, "lens_invariant_ocvfreak/product_quantizers");
    copyAssetsToConfig(paramContext, "lens_invariant_ocvfreak/projection_matrices");
  }
  
  public static String getConfigAssetPath(Context paramContext)
  {
    return paramContext.getFilesDir().toString().concat("/config/");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/serviceassets/ConfigAssetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */