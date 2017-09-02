package com.google.atap.tangoservice;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.tango.loader.ITangoCameraNative;
import com.google.tango.loader.ITangoCameraNative.Stub;
import com.google.tango.loader.ObjectWrapper;

public class TangoCameraNativeLoader
{
  private static ITangoCameraNative sCamera;
  private static Context sRemoteContext;
  
  public static int connectOnFrameAvailable(int paramInt, IOnFrameAvailableListener paramIOnFrameAvailableListener, boolean paramBoolean)
  {
    try
    {
      paramInt = sCamera.connectOnFrameAvailable(paramInt, paramIOnFrameAvailableListener, paramBoolean);
      return paramInt;
    }
    catch (RemoteException paramIOnFrameAvailableListener)
    {
      paramIOnFrameAvailableListener.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramIOnFrameAvailableListener) {}
    return -2;
  }
  
  public static int connectOnImageAvailable(int paramInt, IOnImageAvailableListener paramIOnImageAvailableListener, boolean paramBoolean)
  {
    try
    {
      paramInt = sCamera.connectOnImageAvailable(paramInt, paramIOnImageAvailableListener, paramBoolean);
      return paramInt;
    }
    catch (RemoteException paramIOnImageAvailableListener)
    {
      paramIOnImageAvailableListener.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramIOnImageAvailableListener) {}
    return -2;
  }
  
  public static int connectOnTextureAvailable(int paramInt, boolean paramBoolean)
  {
    try
    {
      paramInt = sCamera.connectOnTextureAvailable(paramInt, paramBoolean);
      return paramInt;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
  
  public static int connectTextureId(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramInt1 = sCamera.connectTextureId(paramInt1, paramInt2, paramBoolean);
      return paramInt1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return -1;
  }
  
  public static void disconnect()
  {
    sCamera = null;
  }
  
  public static int disconnectCamera(int paramInt)
  {
    try
    {
      paramInt = sCamera.disconnectCamera(paramInt);
      return paramInt;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
  
  public static int initialize(Context paramContext, ITangoListener paramITangoListener)
  {
    loadCameraApi(paramContext);
    try
    {
      int i = sCamera.initialize(ObjectWrapper.wrap(paramContext), paramITangoListener);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramContext) {}
    return -2;
  }
  
  private static int loadCameraApi(Context paramContext)
  {
    try
    {
      sRemoteContext = paramContext.createPackageContext("com.google.tango", 3);
      sCamera = ITangoCameraNative.Stub.asInterface(newBinderInstance(sRemoteContext.getClassLoader(), "com.google.tango.jni.TangoCameraNative"));
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static int lockCameraBuffer(int paramInt, double[] paramArrayOfDouble, long[] paramArrayOfLong)
  {
    try
    {
      paramInt = sCamera.lockCameraBuffer(paramInt, paramArrayOfDouble, paramArrayOfLong);
      return paramInt;
    }
    catch (RemoteException paramArrayOfDouble)
    {
      paramArrayOfDouble.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramArrayOfDouble) {}
    return -2;
  }
  
  private static IBinder newBinderInstance(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = (IBinder)paramClassLoader.loadClass(paramString).newInstance();
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
    catch (InstantiationException paramClassLoader)
    {
      throw new IllegalStateException("Unable to instantiate the remote class " + paramString);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramString);
    }
  }
  
  public static int setDatasetPathAndUUID(String paramString1, String paramString2)
  {
    try
    {
      int i = sCamera.setDatasetPathAndUUID(paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramString1) {}
    return -2;
  }
  
  public static int startCamerasIfNeeded()
  {
    try
    {
      int i = sCamera.startCamerasIfNeeded();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
  
  public static int stopAllCameras()
  {
    try
    {
      int i = sCamera.stopAllCameras();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
  
  public static int unlockCameraBuffer(int paramInt, long paramLong)
  {
    try
    {
      paramInt = sCamera.unlockCameraBuffer(paramInt, paramLong);
      return paramInt;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
  
  public static int updateTexture(int paramInt, double[] paramArrayOfDouble)
  {
    try
    {
      paramInt = sCamera.updateTexture(paramInt, paramArrayOfDouble);
      return paramInt;
    }
    catch (RemoteException paramArrayOfDouble)
    {
      paramArrayOfDouble.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramArrayOfDouble) {}
    return -2;
  }
  
  public static int updateTextureExternalOes(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    try
    {
      paramInt1 = sCamera.updateTextureExternalOes(paramInt1, paramInt2, paramArrayOfDouble);
      return paramInt1;
    }
    catch (RemoteException paramArrayOfDouble)
    {
      paramArrayOfDouble.printStackTrace();
      return -1;
    }
    catch (NullPointerException paramArrayOfDouble) {}
    return -2;
  }
  
  public static int updateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      paramInt1 = sCamera.updateTextureExternalOesForBuffer(paramInt1, paramInt2, paramLong);
      return paramInt1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return -1;
    }
    catch (NullPointerException localNullPointerException) {}
    return -2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoCameraNativeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */