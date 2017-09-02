package com.google.atap.tango;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.atap.tango.serviceassets.ConfigAssetUtils;
import com.google.atap.tangocloudservice.TangoCloudScheduler;
import com.google.tango.javacommon.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class BootReceiver
  extends BroadcastReceiver
{
  private static final String ANDROID_PROPERTY_PERSIST_CALIBRATION_FAC = "persist.config.calibration_fac";
  private static final String ANDROID_PROPERTY_PERSIST_CAL_PATH = "persist.config.persist_cal_path";
  private static final String ANDROID_PROPERTY_RO_CALIBRATION_FAC = "ro.config.calibration_fac";
  private static final String FACTORY_CALIBRATION_CONTEXT_DIR_PATH = "/config/calibration.xml";
  private static final String TAG = "TangoCore-BootReceiver";
  private static final String TANGO_PROPERTIES_FILE_PATH = "/system/vendor/etc/tango.properties";
  private static final String TANGO_PROPERTY_PERSIST_CALIBRATION = "persist_calibration";
  private static final boolean USE_TANGO_RUNNER = ;
  public static final String VERSION_AT_LAST_TANGO_RESTART = "VERSION_AT_LAST_TANGO_RESTART";

  public static void copyAllFiles(Context paramContext)
  {
    restoreDeviceCalibration(paramContext);
    String str = ConfigAssetUtils.getConfigAssetPath(paramContext);
    Log.i("TangoCore-BootReceiver", "Copying config asset files to " + str + " ...");
    try
    {
      ConfigAssetUtils.copyLoopClosureAssetsToConfig(paramContext);
      Log.i("TangoCore-BootReceiver", "Copying step finished, ready to launch!");
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        Log.e("TangoCore-BootReceiver", "Failed to copy asset files to " + str + "We're going to continue anyway, but this could cause further errors.", paramContext);
      }
    }
  }

  private static void copyFileIfNeeded(File paramFile1, File paramFile2)
  {
    try
    {
      if (!paramFile2.exists())
      {
        if (!paramFile1.exists()) {
          Log.e("TangoCore-BootReceiver", "Error: Unable to find " + paramFile1.getName());
        }
        paramFile1 = new FileInputStream(paramFile1);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
        FileUtils.copyStream(paramFile1, localFileOutputStream);
        paramFile1.close();
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!paramFile2.exists())
        {
          Log.e("TangoCore-BootReceiver", "Error: Failed to create: " + paramFile2.getName());
          return;
        }
        Log.i("TangoCore-BootReceiver", "Calibration restored to: " + paramFile2.getName());
        return;
      }
    }
    catch (FileNotFoundException paramFile1)
    {
      paramFile1.printStackTrace();
      return;
    }
    catch (IOException paramFile1)
    {
      paramFile1.printStackTrace();
    }
  }

  public static void copyLib(Context paramContext, int paramInt, String paramString)
  {
    Log.i("TangoCore-BootReceiver", "About to copy " + paramString);
    try
    {
      paramContext = paramContext.getResources().openRawResource(paramInt);
      Object localObject = new File(paramString).getParentFile();
      ((File)localObject).mkdirs();
      ((File)localObject).setExecutable(true, false);
      localObject = new FileOutputStream(paramString);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        paramInt = paramContext.read(arrayOfByte);
        if (paramInt <= 0) {
          break;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, paramInt);
      }
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
      paramContext.close();
      ((FileOutputStream)localObject).close();
      new File(paramString).setReadable(true, false);
      Log.i("TangoCore-BootReceiver", "Copied " + paramString);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }

  public static void copyLibs(Context paramContext, boolean paramBoolean)
  {
    String str1 = "/data/data/" + paramContext.getApplicationContext().getPackageName() + "/";
    String str2 = str1 + "libfiles/";
    if ((paramBoolean) || (!new File(str2 + "default/libtango_client_api.so").exists())) {
      copyLib(paramContext, 2131034112, str2 + "default/libtango_client_api.so");
    }
    if ((paramBoolean) || (!new File(str2 + "armeabi-v7a/libtango_client_api.so").exists())) {
      copyLib(paramContext, 2131034113, str2 + "armeabi-v7a/libtango_client_api.so");
    }
    new File(str1).setExecutable(true, false);
    new File(str2).setExecutable(true, false);
  }

  private static String getPathFromAndroidProperty(String paramString)
  {
    try
    {
      paramString = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "/system/bin/getprop", paramString }).getInputStream())).readLine();
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }

  protected static boolean isTangoDevKitDevice()
  {
    return (Build.MANUFACTURER.equals("Google")) && (Build.DEVICE.equals("yellowstone"));
  }

  private static void restoreDeviceCalibration(Context paramContext)
  {
    Object localObject1 = new Properties();
    try
    {
      localObject2 = new FileInputStream("/system/vendor/etc/tango.properties");
      ((Properties)localObject1).load((InputStream)localObject2);
      ((FileInputStream)localObject2).close();
      localObject1 = ((Properties)localObject1).getProperty("persist_calibration", null);
      if (((String)localObject1).isEmpty())
      {
        Log.e("TangoCore-BootReceiver", "Cannot locate persistent backup of factory calibration file: persist_calibration not set in /system/vendor/etc/tango.properties");
        return;
      }
      localObject2 = paramContext.getApplicationContext().getFilesDir().toString().concat("/config/calibration.xml");
    }
    catch (FileNotFoundException paramContext)
    {
      do
      {
        Log.w("TangoCore-BootReceiver", "Failed to find: /system/vendor/etc/tango.properties, falling back to Android system properties to find calibration files.");
        paramContext = getPathFromAndroidProperty("persist.config.persist_cal_path");
        if (paramContext.isEmpty())
        {
          Log.e("TangoCore-BootReceiver", "Cannot locate persistent backup of factory calibration file: persist.config.persist_cal_path not set.");
          return;
        }
        localObject1 = paramContext.concat("/calibration.xml");
        Object localObject2 = getPathFromAndroidProperty("persist.config.calibration_fac");
        paramContext = (Context)localObject2;
        if (((String)localObject2).isEmpty()) {
          paramContext = getPathFromAndroidProperty("ro.config.calibration_fac");
        }
        localObject2 = paramContext;
      } while (!paramContext.isEmpty());
      Log.e("TangoCore-BootReceiver", "Cannot find location for factory calibration file: persist.config.calibration_fac and ro.config.calibration_fac not set");
      return;
    }
    catch (IOException paramContext)
    {
      Log.e("TangoCore-BootReceiver", "Error while reading from: /system/vendor/etc/tango.properties", paramContext);
    }
    paramContext = new File((String)localObject2);
    if (!paramContext.getParentFile().exists())
    {
      paramContext.getParentFile().mkdirs();
      Log.i("TangoCore-BootReceiver", "Creating " + paramContext.getParentFile().getAbsolutePath());
    }
    copyFileIfNeeded(new File((String)localObject1), paramContext);
    if (isTangoDevKitDevice())
    {
      paramContext = new File(Environment.getExternalStorageDirectory().toString().concat("/config/rig.txt"));
      copyFileIfNeeded(new File(getPathFromAndroidProperty("persist.config.persist_cal_path").concat("/rig.txt")), paramContext);
    }
    paramContext = new File("/data/data/com.google.tango/files/config/calibration.xml");
    if (paramContext.exists())
    {
      paramContext.setReadable(true, false);
      new File("/data/data/com.google.tango/files/config/").setExecutable(true, false);
      new File("/data/data/com.google.tango/files/").setExecutable(true, false);
      return;
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("TangoCore-BootReceiver", "Setting up Tango device.");
    TangoRunner.runTango(paramContext);
    PermissionHelper.createPermissionFilesIfMissing(paramContext);
    copyLibs(paramContext, true);
    copyAllFiles(paramContext);
    if ((Build.VERSION.SDK_INT <= 19) || (!USE_TANGO_RUNNER)) {}
    try
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext);
      int i = paramContext.getPackageManager().getPackageInfo("com.google.tango", 0).versionCode;
      if (paramIntent.getInt("VERSION_AT_LAST_TANGO_RESTART", -1) != i)
      {
        paramIntent.edit().putInt("VERSION_AT_LAST_TANGO_RESTART", i).commit();
        new TangoInternal(paramContext, null).disconnect();
      }
      paramIntent = new File(paramContext.getApplicationContext().getFilesDir() + "/debug");
      if (!paramIntent.exists()) {
        paramIntent.mkdirs();
      }
      paramIntent.setWritable(true, false);
      paramIntent.setReadable(true, false);
      TangoCloudScheduler.newScheduler(paramContext).schedule();
      Log.i("TangoCore-BootReceiver", "Tango device is now set up!");
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/BootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
