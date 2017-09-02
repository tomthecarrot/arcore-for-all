package com.google.atap.tango;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.view.Surface;
import com.google.atap.tangocloudservice.TangoCloudScheduler;
import com.google.atap.tangoservice.ITangoListener;
import com.google.atap.tangoservice.TangoAreaDescriptionMetaData;
import com.google.atap.tangoservice.TangoCameraIntrinsics;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoCoordinateFramePair;
import com.google.atap.tangoservice.TangoEvent;
import com.google.atap.tangoservice.TangoPointCloudData;
import com.google.atap.tangoservice.TangoPoseData;
import com.google.atap.tangoservice.TangoXyzIjData;
import com.google.atap.tangoservice.experimental.TangoPlaneData;
import com.google.atap.tangoservice.fois.FoiRequest;
import com.google.atap.tangoservice.fois.FoiResponse;
import com.google.tango.analytics.TangoAnalyticsTracker;
import com.google.tango.analytics.TangoAnalyticsUtil;
import com.google.tango.cloudlib.Utils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TangoService
  extends Service
{
  private static final String TAG = "TangoService.java";
  private static TangoService sInstance;
  private ITangoWrapper mBinder;
  private PackageManager mPackageManager;
  private TangoAnalyticsTracker mTracker = null;
  
  private static String getAndroidPermissionString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("Unexpected permission code " + paramInt);
    case 1: 
      return "android.permission.CAMERA";
    case 2: 
      return "com.google.tango.permission.DATASETS";
    }
    return "android.permission.ACCESS_FINE_LOCATION";
  }
  
  public static TangoService getInstance()
  {
    return sInstance;
  }
  
  private void init()
  {
    Process.setThreadPriority(1);
    Context localContext = getApplicationContext();
    this.mPackageManager = localContext.getPackageManager();
    this.mTracker = TangoAnalyticsUtil.getClearcutTracker(localContext);
    TangoServiceJNINative.CreateNativeService(this);
    TangoCloudScheduler.newScheduler(localContext).schedule();
    setupJavaBinder();
    startService(new Intent(this, TangoService.class));
  }
  
  private void setupJavaBinder()
  {
    this.mBinder = new ITangoWrapper()
    {
      private String getCallingPackage()
      {
        String str2 = TangoService.this.mPackageManager.getNameForUid(Binder.getCallingUid());
        int i = str2.indexOf(':');
        String str1 = str2;
        if (i >= 0) {
          str1 = str2.substring(0, i);
        }
        return str1;
      }
      
      public int connect(ITangoListener paramAnonymousITangoListener, TangoConfig paramAnonymousTangoConfig)
        throws RemoteException
      {
        return TangoServiceJNINative.Connect(Binder.getCallingPid(), getCallingPackage(), paramAnonymousITangoListener, paramAnonymousTangoConfig);
      }
      
      public int connectSurface(int paramAnonymousInt, Surface paramAnonymousSurface)
      {
        return -2;
      }
      
      public int deleteAreaDescription(String paramAnonymousString)
        throws RemoteException
      {
        return TangoServiceJNINative.DeleteAreaDescription(getCallingPackage(), paramAnonymousString);
      }
      
      public int deleteDataset(String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return -1;
        }
        return TangoServiceJNINative.DeleteDataset(getCallingPackage(), paramAnonymousString);
      }
      
      public int disconnect()
        throws RemoteException
      {
        return TangoServiceJNINative.Disconnect(Binder.getCallingPid());
      }
      
      public int disconnectSurface(int paramAnonymousInt)
      {
        return 0;
      }
      
      public int exportAreaDescriptionFile(String paramAnonymousString1, String paramAnonymousString2)
        throws RemoteException
      {
        return TangoServiceJNINative.ExportAreaDescriptionFile(getCallingPackage(), paramAnonymousString1, paramAnonymousString2);
      }
      
      public int foiRequest(FoiRequest paramAnonymousFoiRequest)
      {
        return TangoServiceJNINative.FoiRequest(paramAnonymousFoiRequest);
      }
      
      public int getAreaDescriptionUuidList(List<String> paramAnonymousList)
        throws RemoteException
      {
        String[] arrayOfString = new String[1];
        int i = TangoServiceJNINative.GetAreaDescriptionUuidList(getCallingPackage(), arrayOfString);
        paramAnonymousList.add(arrayOfString[0]);
        return i;
      }
      
      public int getCameraIntrinsics(int paramAnonymousInt, TangoCameraIntrinsics paramAnonymousTangoCameraIntrinsics)
        throws RemoteException
      {
        return TangoServiceJNINative.GetCameraIntrinsics(paramAnonymousInt, paramAnonymousTangoCameraIntrinsics);
      }
      
      public int getConfig(int paramAnonymousInt, TangoConfig paramAnonymousTangoConfig)
        throws RemoteException
      {
        return TangoServiceJNINative.GetConfig(TangoService.this, paramAnonymousInt, paramAnonymousTangoConfig);
      }
      
      public int getCurrentDatasetUuid(List<String> paramAnonymousList)
      {
        String[] arrayOfString = new String[1];
        int i = TangoServiceJNINative.GetCurrentDatasetUuid(arrayOfString);
        paramAnonymousList.add(arrayOfString[0]);
        return i;
      }
      
      public int getDatasetUuids(List<String> paramAnonymousList)
      {
        String[] arrayOfString = new String[1];
        int i = TangoServiceJNINative.GetDatasetUuids(getCallingPackage(), arrayOfString);
        paramAnonymousList.add(arrayOfString[0]);
        return i;
      }
      
      public int getPlaneByUVCoord(int paramAnonymousInt, TangoPoseData paramAnonymousTangoPoseData, double[] paramAnonymousArrayOfDouble, TangoPlaneData paramAnonymousTangoPlaneData)
      {
        return TangoServiceJNINative.GetPlaneByUVCoord(paramAnonymousInt, paramAnonymousTangoPoseData, paramAnonymousArrayOfDouble, paramAnonymousTangoPlaneData);
      }
      
      public int getPlanes(List<TangoPlaneData> paramAnonymousList)
      {
        return TangoServiceJNINative.GetPlanes(paramAnonymousList);
      }
      
      public int getPoseAtTime(double paramAnonymousDouble, TangoCoordinateFramePair paramAnonymousTangoCoordinateFramePair, TangoPoseData paramAnonymousTangoPoseData)
        throws RemoteException
      {
        return TangoServiceJNINative.GetPoseAtTime(TangoService.this, paramAnonymousDouble, paramAnonymousTangoCoordinateFramePair.baseFrame, paramAnonymousTangoCoordinateFramePair.targetFrame, paramAnonymousTangoPoseData);
      }
      
      public int getPoseAtTime2(double paramAnonymousDouble, String paramAnonymousString1, String paramAnonymousString2, TangoPoseData paramAnonymousTangoPoseData)
      {
        return TangoServiceJNINative.GetPoseAtTime2(paramAnonymousDouble, paramAnonymousString1, paramAnonymousString2, paramAnonymousTangoPoseData);
      }
      
      public int importAreaDescriptionFile(List<String> paramAnonymousList, String paramAnonymousString)
        throws RemoteException
      {
        String[] arrayOfString = new String[1];
        int i = TangoServiceJNINative.ImportAreaDescriptionFile(getCallingPackage(), arrayOfString, paramAnonymousString);
        paramAnonymousList.add(arrayOfString[0]);
        return i;
      }
      
      public int loadAreaDescriptionMetaData(String paramAnonymousString, TangoAreaDescriptionMetaData paramAnonymousTangoAreaDescriptionMetaData)
        throws RemoteException
      {
        return TangoServiceJNINative.LoadAreaDescriptionMetaData(getCallingPackage(), paramAnonymousString, paramAnonymousTangoAreaDescriptionMetaData);
      }
      
      public int reportApiUsage(TangoConfig paramAnonymousTangoConfig)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        localStringBuilder.append("{");
        Iterator localIterator = paramAnonymousTangoConfig.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (i != 0)
          {
            localStringBuilder.append(",");
            label64:
            localStringBuilder.append("\n");
            boolean bool = paramAnonymousTangoConfig.getBoolean(str);
            localStringBuilder.append("\"");
            localStringBuilder.append(str);
            localStringBuilder.append("\": ");
            if (!bool) {
              break label127;
            }
          }
          label127:
          for (str = "1";; str = "0")
          {
            localStringBuilder.append(str);
            break;
            i = 1;
            break label64;
          }
        }
        localStringBuilder.append("\n}");
        paramAnonymousTangoConfig = localStringBuilder.toString();
        TangoServiceJNINative.ReportApiUsage(Binder.getCallingPid(), paramAnonymousTangoConfig);
        return 0;
      }
      
      public int resetMotionTracking()
        throws RemoteException
      {
        return TangoServiceJNINative.ResetMotionTracking();
      }
      
      public int saveAreaDescription(List<String> paramAnonymousList)
        throws RemoteException
      {
        String[] arrayOfString = new String[1];
        int i = TangoServiceJNINative.SaveAreaDescription(getCallingPackage(), arrayOfString);
        paramAnonymousList.add(arrayOfString[0]);
        return i;
      }
      
      public int saveAreaDescriptionMetaData(String paramAnonymousString, TangoAreaDescriptionMetaData paramAnonymousTangoAreaDescriptionMetaData)
        throws RemoteException
      {
        return TangoServiceJNINative.SaveAreaDescriptionMetaData(getCallingPackage(), paramAnonymousString, paramAnonymousTangoAreaDescriptionMetaData);
      }
      
      public int setPoseListenerFrames(List<TangoCoordinateFramePair> paramAnonymousList)
        throws RemoteException
      {
        Object localObject = new int[0];
        if (paramAnonymousList != null)
        {
          int[] arrayOfInt = new int[paramAnonymousList.size() * 2];
          int i = 0;
          for (;;)
          {
            localObject = arrayOfInt;
            if (i >= paramAnonymousList.size()) {
              break;
            }
            arrayOfInt[(i * 2)] = ((TangoCoordinateFramePair)paramAnonymousList.get(i)).baseFrame;
            arrayOfInt[(i * 2 + 1)] = ((TangoCoordinateFramePair)paramAnonymousList.get(i)).targetFrame;
            i += 1;
          }
        }
        return TangoServiceJNINative.SetPoseListenerFrames(Binder.getCallingPid(), (int[])localObject);
      }
      
      public int setRuntimeConfig(TangoConfig paramAnonymousTangoConfig)
        throws RemoteException
      {
        return TangoServiceJNINative.SetRuntimeConfig(TangoService.this, paramAnonymousTangoConfig);
      }
      
      public int startOnlineCalibrationSolve()
      {
        return TangoServiceJNINative.StartOnlineCalibrationSolve();
      }
    };
  }
  
  public void cacheCloudTilesForLocation(Location paramLocation, CloudTileProgressCallback paramCloudTileProgressCallback)
  {
    TangoServiceJNINative.CacheCloudTilesForLocation(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy(), paramCloudTileProgressCallback);
  }
  
  public void cancelCloudTileCaching() {}
  
  public void clearCloudTileCache() {}
  
  public TangoAnalyticsTracker getAnalyticsTracker()
  {
    Log.d("TangoService.java", "Returned Tracker!");
    return this.mTracker;
  }
  
  public String getCertFingerprint(String paramString)
  {
    return Utils.getCertFingerprint(this, paramString);
  }
  
  public String getCloudServicesApiKey(String paramString)
  {
    return Utils.getApiKey(this, paramString);
  }
  
  public boolean hasAndroidPermission(int paramInt, String paramString)
  {
    return PermissionChecker.checkCallingPermission(this, getAndroidPermissionString(paramInt), paramString) == 0;
  }
  
  public boolean isCloudTileCacheEmpty()
  {
    return TangoServiceJNINative.IsCloudTileCacheEmpty();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.d("TangoService.java", "onBind()");
    BootReceiver.copyLibs(this, false);
    BootReceiver.copyAllFiles(this);
    PermissionHelper.createPermissionFilesIfMissing(this);
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Log.d("TangoService.java", "onCreate()");
    init();
    sInstance = this;
  }
  
  public void onDestroy()
  {
    sInstance = null;
    super.onDestroy();
    Log.d("TangoService.java", "onDestroy()");
    if (this.mBinder != null) {
      this.mBinder.invalidate();
    }
    TangoServiceJNINative.DestroyNativeService();
  }
  
  public void onFoiResponse(ITangoListener paramITangoListener, FoiResponse paramFoiResponse)
  {
    try
    {
      paramITangoListener.onFoiResponse(paramFoiResponse);
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public void onFrameAvailable(ITangoListener paramITangoListener, int paramInt) {}
  
  public void onOnlineCalibrationStatus(ITangoListener paramITangoListener, int paramInt)
  {
    try
    {
      paramITangoListener.onOnlineCalibrationStatus(paramInt);
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public void onPointCloudAvailable(ITangoListener paramITangoListener, TangoPointCloudData paramTangoPointCloudData)
  {
    try
    {
      paramTangoPointCloudData.pointCloudParcelFileDescriptor = ParcelFileDescriptor.fromFd(paramTangoPointCloudData.pointCloudNativeFileDescriptor);
      paramITangoListener.onPointCloudAvailable(paramTangoPointCloudData);
      paramTangoPointCloudData.pointCloudParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public void onPoseAvailable(ITangoListener paramITangoListener, TangoPoseData paramTangoPoseData)
  {
    try
    {
      paramITangoListener.onPoseAvailable(paramTangoPoseData);
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.d("TangoService.java", "onStartCommand()");
    return 1;
  }
  
  public void onTangoEvent(ITangoListener paramITangoListener, TangoEvent paramTangoEvent)
  {
    try
    {
      paramITangoListener.onTangoEvent(paramTangoEvent);
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public void onXyzIjAvailable(ITangoListener paramITangoListener, TangoXyzIjData paramTangoXyzIjData)
  {
    try
    {
      paramITangoListener.onXyzIjAvailable();
      return;
    }
    catch (RemoteException paramITangoListener)
    {
      paramITangoListener.printStackTrace();
    }
  }
  
  public static abstract interface CloudTileProgressCallback
  {
    public abstract void reportProgress(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */