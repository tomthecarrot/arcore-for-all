package com.google.atap.tango;

import android.content.Context;
import android.os.IBinder.DeathRecipient;
import com.google.atap.tangoservice.ITangoListener;
import com.google.atap.tangoservice.TangoAreaDescriptionMetaData;
import com.google.atap.tangoservice.TangoCameraIntrinsics;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoPoseData;
import com.google.atap.tangoservice.experimental.TangoPlaneData;
import com.google.atap.tangoservice.fois.FoiRequest;
import java.util.List;

public class TangoServiceJNINative
{
  static
  {
    System.loadLibrary("tango_service_library");
  }
  
  public static native void CacheCloudTilesForLocation(double paramDouble1, double paramDouble2, double paramDouble3, TangoService.CloudTileProgressCallback paramCloudTileProgressCallback);
  
  public static native void CancelCloudTileCaching();
  
  public static native void ClearCloudTileCache();
  
  public static native int Connect(int paramInt, String paramString, ITangoListener paramITangoListener, TangoConfig paramTangoConfig);
  
  public static native int ConnectFeatureServer(int paramInt, float[] paramArrayOfFloat);
  
  public static native void CreateNativeService(TangoService paramTangoService);
  
  public static native int DeleteAreaDescription(String paramString1, String paramString2);
  
  public static native int DeleteDataset(String paramString1, String paramString2);
  
  public static native void DestroyNativeService();
  
  public static native int Disconnect(int paramInt);
  
  public static native int DisconnectFeatureServer();
  
  public static native int ExportAreaDescriptionFile(String paramString1, String paramString2, String paramString3);
  
  public static native int FoiRequest(FoiRequest paramFoiRequest);
  
  public static native int GetAreaDescriptionUuidList(String paramString, String[] paramArrayOfString);
  
  public static native int GetCameraIntrinsics(int paramInt, TangoCameraIntrinsics paramTangoCameraIntrinsics);
  
  public static native int GetConfig(Context paramContext, int paramInt, TangoConfig paramTangoConfig);
  
  public static native int GetCurrentDatasetUuid(String[] paramArrayOfString);
  
  public static native int GetDatasetUuids(String paramString, String[] paramArrayOfString);
  
  public static native int GetPlaneByUVCoord(int paramInt, TangoPoseData paramTangoPoseData, double[] paramArrayOfDouble, TangoPlaneData paramTangoPlaneData);
  
  public static native int GetPlanes(List<TangoPlaneData> paramList);
  
  public static native int GetPoseAtTime(Context paramContext, double paramDouble, int paramInt1, int paramInt2, TangoPoseData paramTangoPoseData);
  
  public static native int GetPoseAtTime2(double paramDouble, String paramString1, String paramString2, TangoPoseData paramTangoPoseData);
  
  public static native int ImportAreaDescriptionFile(String paramString1, String[] paramArrayOfString, String paramString2);
  
  public static native boolean IsCloudTileCacheEmpty();
  
  public static native int LoadAreaDescriptionMetaData(String paramString1, String paramString2, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData);
  
  public static native void ReportApiUsage(int paramInt, String paramString);
  
  public static native int ResetMotionTracking();
  
  public static native int SaveAreaDescription(String paramString, String[] paramArrayOfString);
  
  public static native int SaveAreaDescriptionMetaData(String paramString1, String paramString2, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData);
  
  public static native int SetPoseListenerFrames(int paramInt, int[] paramArrayOfInt);
  
  public static native int SetRuntimeConfig(Context paramContext, TangoConfig paramTangoConfig);
  
  public static native int StartOnlineCalibrationSolve();
  
  public static native int UpdateFeatureServer();
  
  public static class NativeDeathRecipient
    implements IBinder.DeathRecipient
  {
    private final long nativeDeathRecipient;
    
    public NativeDeathRecipient(long paramLong)
    {
      this.nativeDeathRecipient = paramLong;
    }
    
    private native void freeNativeDeathRecipient(long paramLong);
    
    private native void nativeBinderDied(long paramLong);
    
    public void binderDied()
    {
      nativeBinderDied(this.nativeDeathRecipient);
    }
    
    public void finalize()
    {
      freeNativeDeathRecipient(this.nativeDeathRecipient);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoServiceJNINative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */