package com.google.atap.tango;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.atap.tangoservice.Tango.FoiListener;
import com.google.atap.tangoservice.Tango.OnFrameAvailableListener;
import com.google.atap.tangoservice.Tango.TangoUpdateCallback;
import com.google.atap.tangoservice.TangoAreaDescriptionMetaData;
import com.google.atap.tangoservice.TangoCameraIntrinsics;
import com.google.atap.tangoservice.TangoConfig;
import com.google.atap.tangoservice.TangoEvent;
import com.google.atap.tangoservice.TangoPointCloudData;
import com.google.atap.tangoservice.TangoPoseData;
import com.google.atap.tangoservice.TangoTransformation;
import com.google.atap.tangoservice.experimental.TangoImageBuffer;

public class TangoJNINative
{
  static
  {
    if (!TangoClientLibLoader.loadedSuccessfully()) {
      Log.e("TangoJNINative", "ERROR! Unable to load libtango_client_api.so!");
    }
  }
  
  public static native int Connect(TangoConfig paramTangoConfig);
  
  public static native int ConnectListener(int[] paramArrayOfInt, Tango.TangoUpdateCallback paramTangoUpdateCallback, TangoPoseData paramTangoPoseData, TangoPointCloudData paramTangoPointCloudData, TangoEvent paramTangoEvent);
  
  public static native int ConnectOnFrameAvailable(int paramInt, Tango.OnFrameAvailableListener paramOnFrameAvailableListener, TangoImageBuffer paramTangoImageBuffer);
  
  public static native int ConnectOnImageAvailable(int paramInt, Tango.TangoUpdateCallback paramTangoUpdateCallback);
  
  public static native int ConnectTextureId(int paramInt1, int paramInt2);
  
  public static native int CreateFrameOfInterest2(double paramDouble, String paramString, TangoTransformation paramTangoTransformation, Tango.FoiListener paramFoiListener);
  
  public static native int DeleteAreaDescription(String paramString);
  
  public static native int DeleteDataset(String paramString);
  
  public static native int DeleteFramesOfInterest(String[] paramArrayOfString, Tango.FoiListener paramFoiListener);
  
  public static native void Disconnect();
  
  public static native int DisconnectCamera(int paramInt);
  
  public static native int GetAreaDescriptionMetadata(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData);
  
  public static native int GetAreaDescriptionUUIDList(String[] paramArrayOfString);
  
  public static native IBinder GetBinder();
  
  public static native int GetCameraIntrinsics(int paramInt, TangoCameraIntrinsics paramTangoCameraIntrinsics);
  
  public static native void GetConfig(int paramInt, TangoConfig paramTangoConfig);
  
  public static native int GetCurrentDatasetUUID(String[] paramArrayOfString);
  
  public static native int GetDatasets(String[] paramArrayOfString);
  
  public static native int GetPoseAtTime(double paramDouble, int paramInt1, int paramInt2, TangoPoseData paramTangoPoseData);
  
  public static native int GetPoseAtTime2(double paramDouble, String paramString1, String paramString2, TangoPoseData paramTangoPoseData);
  
  public static native int Initialize(Context paramContext);
  
  public static native int LoadFramesOfInterest(String[] paramArrayOfString, Tango.FoiListener paramFoiListener);
  
  public static native void ResetMotionTracking();
  
  public static native int SaveAreaDescription(String[] paramArrayOfString);
  
  public static native int SaveAreaDescriptionMetadata(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData);
  
  public static native int SetBinder(IBinder paramIBinder);
  
  public static native int SetRuntimeConfig(TangoConfig paramTangoConfig);
  
  public static native int UpdateTexture(int paramInt, double[] paramArrayOfDouble);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoJNINative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */