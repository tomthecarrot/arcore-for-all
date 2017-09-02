package com.google.atap.tango;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

public class TangoClientLibLoader
{
  public static final int ARCH_ARM32 = 2;
  public static final int ARCH_ARM64 = 1;
  public static final int ARCH_DEFAULT = 0;
  public static final int ARCH_ERROR = -2;
  public static final int ARCH_FALLBACK = -1;
  public static final int ARCH_X86 = 4;
  public static final int ARCH_X86_64 = 3;
  public static final boolean PURE_JAVA_PATH;
  private static final String TAG = "TangoClientLibLoader";
  private static final int loadedSoArch;
  
  static
  {
    boolean bool;
    String str;
    if (Build.VERSION.SDK_INT >= 24)
    {
      bool = true;
      PURE_JAVA_PATH = bool;
      j = -2;
      if (PURE_JAVA_PATH) {
        break label310;
      }
      str = "/data/data/com.google.tango/libfiles/";
      if (!new File("/data/data/com.google.tango/libfiles/").exists()) {
        str = "/data/data/com.projecttango.tango/libfiles/";
      }
      Log.i("TangoClientLibLoader", "basePath: " + str);
    }
    try
    {
      System.load(str + "arm64-v8a/libtango_client_api.so");
      j = 1;
      i = 1;
      Log.i("TangoClientLibLoader", "Success! Using arm64-v8a/libtango_client_api.");
      j = i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError6)
    {
      int i;
      for (;;) {}
    }
    i = j;
    if (j < 0) {
      i = j;
    }
    try
    {
      System.load(str + "armeabi-v7a/libtango_client_api.so");
      j = 2;
      i = j;
      Log.i("TangoClientLibLoader", "Success! Using armeabi-v7a/libtango_client_api.");
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError5)
    {
      for (;;) {}
    }
    j = i;
    if (i < 0) {}
    try
    {
      System.load(str + "x86_64/libtango_client_api.so");
      j = 3;
      i = j;
      Log.i("TangoClientLibLoader", "Success! Using x86_64/libtango_client_api.");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError4)
    {
      for (;;)
      {
        label310:
        j = i;
      }
    }
    i = j;
    if (j < 0) {
      i = j;
    }
    try
    {
      System.load(str + "x86/libtango_client_api.so");
      j = 4;
      i = j;
      Log.i("TangoClientLibLoader", "Success! Using x86/libtango_client_api.");
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
    {
      for (;;) {}
    }
    j = i;
    if (i < 0) {}
    try
    {
      System.load(str + "default/libtango_client_api.so");
      i = 0;
      j = 0;
      Log.i("TangoClientLibLoader", "Success! Using default/libtango_client_api.");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      for (;;)
      {
        j = i;
      }
    }
    i = j;
    if (j < 0) {
      i = j;
    }
    for (;;)
    {
      try
      {
        System.loadLibrary("tango_client_api");
        j = -1;
        i = j;
        Log.i("TangoClientLibLoader", "Falling back to libtango_client_api.so symlink.");
        i = j;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        continue;
      }
      loadedSoArch = i;
      return;
      bool = false;
      break;
      i = 0;
      Log.i("TangoClientLibLoader", "Pure Java path, not loading libtango_client_api.so at all.");
    }
  }
  
  public static int getTangoClientApiArch()
  {
    return loadedSoArch;
  }
  
  public static boolean loadedSuccessfully()
  {
    return getTangoClientApiArch() != -2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoClientLibLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */