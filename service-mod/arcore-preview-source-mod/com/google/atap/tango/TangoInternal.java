package com.google.atap.tango;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.atap.tangoservice.ITango;
import com.google.atap.tangoservice.ITango.Stub;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoErrorException;
import com.google.atap.tangoservice.TangoInvalidException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TangoInternal
{
  private static final int STATUS_ERROR = -1;
  private static final int STATUS_INVALID = -2;
  private static final int STATUS_SUCCESS = 0;
  private static final String TAG = "TangoCore-TangoInternal";
  private volatile boolean mNeedToUnbindService = false;
  private Context mParent;
  private ServiceConnection mServiceConnection = null;
  private ITango mTangoNativeService;
  private volatile boolean mTangoShouldBeDisconnected = true;
  
  public TangoInternal(Context paramContext, Runnable paramRunnable)
  {
    this.mParent = paramContext;
    bindToService(paramRunnable);
  }
  
  private void bindToService(final Runnable paramRunnable)
  {
    this.mNeedToUnbindService = false;
    try
    {
      Intent localIntent = getTangoServiceIntent();
      if (localIntent != null)
      {
        this.mServiceConnection = new ServiceConnection()
        {
          public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            TangoInternal.access$002(TangoInternal.this, ITango.Stub.asInterface(paramAnonymousIBinder));
            if (TangoInternal.this.mTangoShouldBeDisconnected)
            {
              TangoInternal.this.disconnect();
              return;
            }
            new Thread(paramRunnable).start();
          }
          
          public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
        };
        this.mNeedToUnbindService = this.mParent.bindService(localIntent, this.mServiceConnection, 1);
        this.mTangoShouldBeDisconnected = false;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      deprecatedBindToSystemService();
      new Thread(paramRunnable).start();
    }
  }
  
  public static TangoInternal constructBlocking(Context paramContext)
  {
    final Object localObject = new Object();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramContext = new TangoInternal(paramContext, new Runnable()
    {
      public void run()
      {
        this.val$ready.set(true);
        synchronized (localObject)
        {
          localObject.notify();
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        boolean bool = localAtomicBoolean.get();
        if (bool) {
          break;
        }
        try
        {
          localObject.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return paramContext;
    }
    finally {}
  }
  
  private void deprecatedBindToSystemService()
  {
    try
    {
      this.mTangoNativeService = ITango.Stub.asInterface((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "com.google.atap.tangoservice.ITango" }));
      if (this.mTangoNativeService == null) {
        throw new NullPointerException();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Thread.sleep(1000L);
            TangoInternal.this.deprecatedBindToSystemService();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }).start();
    }
  }
  
  private Intent getTangoServiceIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.google.tango", "com.google.atap.tango.TangoService");
    if (this.mParent.getPackageManager().resolveService(localIntent, 0) != null)
    {
      Log.i("TangoCore-TangoInternal", "Found: com.google.tango/com.google.atap.tango.TangoService");
      return localIntent;
    }
    localIntent = new Intent();
    localIntent.setClassName("com.projecttango.tango", "com.google.atap.tango.TangoService");
    if (this.mParent.getPackageManager().resolveService(localIntent, 0) != null)
    {
      Log.i("TangoCore-TangoInternal", "Found: com.projecttango.tango/com.google.atap.tango.TangoService");
      return localIntent;
    }
    Log.i("TangoCore-TangoInternal", "Error: No TangoService intent found.");
    return null;
  }
  
  private void throwTangoExceptionIfNeeded(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt == -2) {
      throw new TangoInvalidException();
    }
    throw new TangoErrorException();
  }
  
  public void cacheCloudTilesForLocation(Location paramLocation, TangoService.CloudTileProgressCallback paramCloudTileProgressCallback)
  {
    TangoService.getInstance().cacheCloudTilesForLocation(paramLocation, paramCloudTileProgressCallback);
  }
  
  public void cancelCloudTileCaching()
  {
    TangoService.getInstance().cancelCloudTileCaching();
  }
  
  public void clearAllAdfs()
  {
    if (this.mTangoNativeService == null) {
      throw new TangoErrorException();
    }
    try
    {
      Object localObject = new ArrayList();
      this.mTangoNativeService.getAreaDescriptionUuidList((List)localObject);
      localObject = ((String)((ArrayList)localObject).get(0)).split(",");
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].length() > 0) {
          this.mTangoNativeService.deleteAreaDescription(localObject[i]);
        }
        i += 1;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("TangoCore-TangoInternal", "Problem with clearAllAdfs", localRemoteException);
      try
      {
        TangoService.getInstance().clearCloudTileCache();
        return;
      }
      catch (Exception localException)
      {
        Log.e("TangoCore-TangoInternal", "Problem with TangoInternal.clearAllAdfs.", localException);
      }
    }
  }
  
  public void disconnect()
  {
    this.mTangoShouldBeDisconnected = true;
    if (this.mTangoNativeService != null) {}
    try
    {
      this.mTangoNativeService.disconnect();
      this.mTangoNativeService = null;
      if (this.mNeedToUnbindService)
      {
        this.mParent.unbindService(this.mServiceConnection);
        this.mServiceConnection = null;
        this.mNeedToUnbindService = false;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.i("TangoCore-TangoInternal", "Caught expected RemoteException due to Tango Service reset:", localRemoteException);
      }
    }
  }
  
  public void exportAreaDescriptionFile(String paramString1, String paramString2)
  {
    try
    {
      throwTangoExceptionIfNeeded(this.mTangoNativeService.exportAreaDescriptionFile(paramString1, paramString2));
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.e("TangoCore-TangoInternal", "Problem with exportAreaDescription");
      paramString1.printStackTrace();
      throw new TangoErrorException();
    }
  }
  
  public void forceSystemServiceReset()
  {
    try
    {
      ITango localITango = ITango.Stub.asInterface((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "com.google.atap.tangoservice.ITango" }));
      if (localITango != null) {
        localITango.disconnect();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean hasAdfs()
  {
    boolean bool = false;
    if (this.mTangoNativeService == null) {
      throw new TangoErrorException();
    }
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        this.mTangoNativeService.getAreaDescriptionUuidList(localArrayList);
        int i = ((String)localArrayList.get(0)).length();
        if (i > 0)
        {
          i = 1;
          if (!TangoService.getInstance().isCloudTileCacheEmpty())
          {
            j = 1;
            if ((i != 0) || (j != 0)) {
              bool = true;
            }
            return bool;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int j = 0;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("TangoCore-TangoInternal", "Problem with hasAdfs.", localRemoteException);
        throw new TangoErrorException();
      }
    }
  }
  
  public String importAreaDescriptionFile(String paramString)
  {
    if (this.mTangoNativeService == null) {
      throw new TangoErrorException();
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      throwTangoExceptionIfNeeded(this.mTangoNativeService.importAreaDescriptionFile(localArrayList, paramString));
      if (localArrayList.size() > 0)
      {
        paramString = (String)localArrayList.get(0);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      Log.e("TangoCore-TangoInternal", "Problem with importAreaDescription");
      paramString.printStackTrace();
      throw new TangoErrorException();
    }
  }
  
  public void setRuntimeConfig(TangoConfig paramTangoConfig)
  {
    if (this.mTangoNativeService == null) {
      throw new TangoErrorException();
    }
    try
    {
      this.mTangoNativeService.setRuntimeConfig(paramTangoConfig);
      return;
    }
    catch (RemoteException paramTangoConfig)
    {
      Log.e("TangoCore-TangoInternal", "Problem with setRuntimeConfig");
      paramTangoConfig.printStackTrace();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */