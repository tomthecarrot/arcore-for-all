package com.google.atap.tangoservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.atap.tango.TangoClientLibLoader;
import com.google.atap.tango.TangoJNINative;
import com.google.atap.tangoservice.experimental.TangoImageBuffer;
import com.google.atap.tangoservice.experimental.TangoPlaneData;
import com.google.atap.tangoservice.fois.FoiRequest;
import com.google.atap.tangoservice.fois.FoiRequest.Create;
import com.google.atap.tangoservice.fois.FoiRequest.Delete;
import com.google.atap.tangoservice.fois.FoiRequest.Load;
import com.google.atap.tangoservice.fois.FoiResponse;
import com.google.atap.tangoservice.fois.FoiResponse.Create;
import com.google.atap.tangoservice.fois.FoiResponse.Delete;
import com.google.atap.tangoservice.fois.FoiResponse.Load;
import com.google.tango.loader.IObjectWrapper;
import com.google.tango.loader.ObjectWrapper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Tango
{
  public static final String ANDROID_PERMISSION_DATASET = "com.google.tango.permission.DATASETS";
  public static final String COORDINATE_FRAME_CAMERA_DEPTH = "10000000-0000-0000-0000-000000000008";
  public static final String COORDINATE_FRAME_CAMERA_FISHEYE = "10000000-0000-0000-0000-000000000009";
  public static final String COORDINATE_FRAME_ID_AREA_DESCRIPTION = "10000000-0000-0000-0000-000000000001";
  public static final String COORDINATE_FRAME_ID_CAMERA_COLOR = "10000000-0000-0000-0000-000000000007";
  public static final String COORDINATE_FRAME_ID_DEVICE = "10000000-0000-0000-0000-000000000004";
  public static final String COORDINATE_FRAME_ID_DISPLAY = "10000000-0000-0000-0000-000000000006";
  public static final String COORDINATE_FRAME_ID_GLOBAL_WGS84 = "10000000-0000-0000-0000-000000000000";
  public static final String COORDINATE_FRAME_ID_IMU = "10000000-0000-0000-0000-000000000005";
  public static final String COORDINATE_FRAME_ID_NONE = "10000000-0000-0000-0000-0000000000ff";
  public static final String COORDINATE_FRAME_ID_PREVIOUS_DEVICE_POSE = "10000000-0000-0000-0000-000000000003";
  public static final String COORDINATE_FRAME_ID_START_OF_SERVICE = "10000000-0000-0000-0000-000000000002";
  private static final String EXTRA_KEY_DESTINATIONFILE = "DESTINATION_FILE";
  public static final String EXTRA_KEY_DESTINATIONUUID = "DESTINATION_UUID";
  private static final String EXTRA_KEY_PERMISSIONTYPE = "PERMISSIONTYPE";
  private static final String EXTRA_KEY_SOURCEFILE = "SOURCE_FILE";
  private static final String EXTRA_KEY_SOURCEUUID = "SOURCE_UUID";
  private static final String INTENT_CLASSPACKAGE = "com.google.tango";
  private static final String INTENT_DEPRECATED_CLASSPACKAGE = "com.projecttango.tango";
  private static final String INTENT_IMPORTEXPORT_CLASSNAME = "com.google.atap.tango.RequestImportExportActivity";
  private static final String INTENT_REQUESTPERMISSION_CLASSNAME = "com.google.atap.tango.RequestPermissionActivity";
  private static final String MAGIC_CLOUD_UUID = "use_cloud";
  private static final int MIN_VERSION = 13636;
  public static final String PERMISSIONTYPE_ADF_LOAD_SAVE = "ADF_LOAD_SAVE_PERMISSION";
  public static final String PERMISSIONTYPE_DATASET = "DATASET_PERMISSION";
  public static final String PERMISSIONTYPE_MOTION_TRACKING = "MOTION_TRACKING_PERMISSION";
  private static final boolean PURE_JAVA_PATH = TangoClientLibLoader.PURE_JAVA_PATH;
  public static final int STATUS_ERROR = -1;
  public static final int STATUS_INVALID = -2;
  private static final int STATUS_NO_ADF_PERMISSION = -4;
  private static final int STATUS_NO_CAMERA_PERMISSION = -5;
  private static final int STATUS_NO_DATASET_PERMISSION = -7;
  private static final int STATUS_NO_MOTION_TRACKING_PERMISSION = -3;
  public static final int STATUS_SUCCESS = 0;
  private static final String TAG = "Tango";
  public static final int TANGO_INTENT_ACTIVITYCODE = 1129;
  private TangoUpdateCallback mCallback;
  private Semaphore mCallbacksAllowed = new Semaphore(100);
  private final Map<String, FoiListener> mFoiListeners = new HashMap();
  private ITango mITango;
  private ITangoListener mITangoListener = new ITangoListener.Stub()
  {
    public void onFoiResponse(FoiResponse paramAnonymousFoiResponse)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      Tango.this.handleFoiResponse(paramAnonymousFoiResponse);
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onGraphicBufferAvailable(int paramAnonymousInt)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      if (Tango.this.mCallback != null) {
        Tango.this.mCallback.onFrameAvailable(paramAnonymousInt);
      }
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onOnlineCalibrationStatus(int paramAnonymousInt)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      if (Tango.this.mCallback != null) {
        Tango.this.mCallback.onOnlineCalibrationStatus(paramAnonymousInt);
      }
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onPointCloudAvailable(TangoPointCloudData paramAnonymousTangoPointCloudData)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      if (Tango.this.mCallback != null) {
        Tango.this.mCallback.onPointCloudAvailable(paramAnonymousTangoPointCloudData);
      }
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onPoseAvailable(TangoPoseData paramAnonymousTangoPoseData)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      if (Tango.this.mCallback != null) {
        Tango.this.mCallback.onPoseAvailable(paramAnonymousTangoPoseData);
      }
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onTangoEvent(TangoEvent paramAnonymousTangoEvent)
    {
      Tango.this.mCallbacksAllowed.acquireUninterruptibly();
      if (Tango.this.mCallback != null) {
        Tango.this.mCallback.onTangoEvent(paramAnonymousTangoEvent);
      }
      Tango.this.mCallbacksAllowed.release();
    }
    
    public void onXyzIjAvailable() {}
  };
  private Context mParent;
  private ServiceConnection mServiceConnection;
  private volatile boolean mTangoServiceConnected = false;
  private volatile boolean mTangoShouldBeDisconnected;
  
  public Tango(Context paramContext, final Runnable paramRunnable)
  {
    this.mParent = paramContext;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.google.tango", "com.google.atap.tango.TangoService");
    int i;
    if (paramContext.getPackageManager().resolveService(localIntent, 0) != null)
    {
      i = 1;
      j = i;
      if (i == 0)
      {
        localIntent = new Intent();
        localIntent.setClassName("com.projecttango.tango", "com.google.atap.tango.TangoService");
        if (paramContext.getPackageManager().resolveService(localIntent, 0) == null) {
          break label161;
        }
      }
    }
    label161:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label167;
      }
      Log.e("Tango", "Java version of Tango Service not found, falling back to tangoservice_d.");
      TangoJNINative.Initialize(paramContext);
      new Thread(paramRunnable).start();
      return;
      i = 0;
      break;
    }
    label167:
    if (PURE_JAVA_PATH) {
      TangoCameraNativeLoader.initialize(paramContext, this.mITangoListener);
    }
    this.mServiceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        Log.i("Tango", "TangoService connected.");
        if (Tango.PURE_JAVA_PATH)
        {
          Log.i("Tango", "Using the pure Java path for Tango client");
          Tango.access$402(Tango.this, ITango.Stub.asInterface(paramAnonymousIBinder));
        }
        while (Tango.this.mTangoShouldBeDisconnected)
        {
          Tango.this.disconnect();
          return;
          TangoJNINative.SetBinder(paramAnonymousIBinder);
        }
        new Thread(paramRunnable).start();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    paramContext.bindService(localIntent, this.mServiceConnection, 1);
    this.mTangoShouldBeDisconnected = false;
  }
  
  private void clearFoiListeners()
  {
    synchronized (this.mFoiListeners)
    {
      this.mFoiListeners.clear();
      return;
    }
  }
  
  private TangoFoiResult[] getFoiResults(FoiResponse paramFoiResponse)
  {
    if (paramFoiResponse == null) {
      return null;
    }
    switch (paramFoiResponse.mType)
    {
    default: 
      return null;
    case ???: 
      paramFoiResponse = (FoiResponse.Create)paramFoiResponse;
      int i = paramFoiResponse.mStatus;
      paramFoiResponse = paramFoiResponse.mFrameId;
      return getFoiResultsFromStatusesAndIds(new int[] { i }, new String[] { paramFoiResponse });
    case ???: 
      paramFoiResponse = (FoiResponse.Load)paramFoiResponse;
      return getFoiResultsFromStatusesAndIds(paramFoiResponse.mStatuses, paramFoiResponse.mFrameIds);
    }
    paramFoiResponse = (FoiResponse.Delete)paramFoiResponse;
    return getFoiResultsFromStatusesAndIds(paramFoiResponse.mStatuses, paramFoiResponse.mFrameIds);
  }
  
  private TangoFoiResult[] getFoiResultsFromStatusesAndIds(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfInt == null) || (paramArrayOfString == null) || (paramArrayOfInt.length != paramArrayOfString.length))
    {
      localObject = null;
      return (TangoFoiResult[])localObject;
    }
    TangoFoiResult[] arrayOfTangoFoiResult = new TangoFoiResult[paramArrayOfInt.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfTangoFoiResult;
      if (i >= paramArrayOfInt.length) {
        break;
      }
      if (paramArrayOfString[i] == null) {
        return null;
      }
      arrayOfTangoFoiResult[i] = new TangoFoiResult(paramArrayOfInt[i], paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public static Intent getRequestPermissionIntent(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.google.tango", "com.google.atap.tango.RequestPermissionActivity");
    localIntent.putExtra("PERMISSIONTYPE", paramString);
    return localIntent;
  }
  
  public static int getVersion(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      int i = Integer.parseInt(Integer.toString(paramContext.getPackageInfo("com.google.tango", 0).versionCode).substring(2));
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  private int handleFoiRequest(FoiRequest arg1, FoiListener paramFoiListener)
  {
    int j;
    if (paramFoiListener == null) {
      j = -2;
    }
    for (;;)
    {
      return j;
      String str = UUID.randomUUID().toString();
      ???.mId = str;
      synchronized (this.mFoiListeners)
      {
        this.mFoiListeners.put(str, paramFoiListener);
      }
      try
      {
        i = this.mITango.foiRequest(???);
        j = i;
        if (i == 0) {
          continue;
        }
        synchronized (this.mFoiListeners)
        {
          this.mFoiListeners.remove(str);
          return i;
        }
        ??? = finally;
        throw ???;
      }
      catch (RemoteException ???)
      {
        for (;;)
        {
          ???.printStackTrace();
          int i = -1;
        }
      }
    }
  }
  
  private void handleFoiResponse(FoiResponse arg1)
  {
    if (??? == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = ???.mId;
    } while (localObject1 == null);
    TangoFoiResult[] arrayOfTangoFoiResult = getFoiResults(???);
    synchronized (this.mFoiListeners)
    {
      localObject1 = (FoiListener)this.mFoiListeners.remove(localObject1);
      if ((localObject1 != null) && (arrayOfTangoFoiResult != null)) {
        ((FoiListener)localObject1).onFoiResult(arrayOfTangoFoiResult);
      }
      return;
    }
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    if (paramString.equals("MOTION_TRACKING_PERMISSION"))
    {
      Log.w("Tango", "You no longer need to request motion tracking permissions.");
      return true;
    }
    paramString = Uri.parse("content://com.google.atap.tango.PermissionStatusProvider/" + paramString);
    return paramContext.getContentResolver().query(paramString, null, null, null, null) != null;
  }
  
  private static boolean isStringEmpty(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
  
  public static native void nativeOnFrameAvailable(TangoImageBuffer paramTangoImageBuffer, int paramInt);
  
  public static void throwTangoExceptionIfNeeded(int paramInt)
  {
    switch (paramInt)
    {
    case -6: 
    case -1: 
    default: 
      throw new TangoErrorException();
    case -2: 
      throw new TangoInvalidException();
    case -3: 
      throw new SecurityException("Tango Permission Denied. No Motion Tracking permission.");
    case -4: 
      throw new TangoNoAdfPermissionException();
    case -5: 
      throw new TangoNoCameraPermissionException();
    case -7: 
      throw new TangoNoDatasetPermissionException();
    }
  }
  
  public void connect(TangoConfig paramTangoConfig)
  {
    String str1 = paramTangoConfig.getString("config_load_area_description_UUID");
    if ((str1 != null) && (str1.equals("use_cloud")))
    {
      Log.e("Tango", "The 'use_cloud' ADF string is deprecated. This is now enabled via the TangoConfig parameter 'config_experimental_use_cloud_adf'.");
      throw new TangoErrorException();
    }
    this.mParent.getPackageManager();
    int i = 0;
    int j = getVersion(this.mParent);
    Log.i("Tango", "com.google.tango: " + j);
    if (j < 0) {
      throw new TangoErrorException();
    }
    if (j < 13636) {
      i = 1;
    }
    if (PURE_JAVA_PATH) {}
    for (;;)
    {
      try
      {
        str1 = paramTangoConfig.getString("config_letango_load_dataset_UUID");
        str2 = paramTangoConfig.getString("config_datasets_path");
        if ((isStringEmpty(str1)) || (isStringEmpty(str2))) {
          continue;
        }
        throwTangoExceptionIfNeeded(TangoCameraNativeLoader.setDatasetPathAndUUID(str2, str1));
        throwTangoExceptionIfNeeded(this.mITango.connect(this.mITangoListener, paramTangoConfig));
        this.mTangoServiceConnected = true;
        if (paramTangoConfig.getBoolean("config_enable_color_camera")) {
          TangoCameraNativeLoader.startCamerasIfNeeded();
        }
      }
      catch (RemoteException paramTangoConfig)
      {
        String str2;
        paramTangoConfig.printStackTrace();
        continue;
      }
      catch (NullPointerException paramTangoConfig)
      {
        paramTangoConfig.printStackTrace();
        throw new TangoInvalidException();
      }
      if (i == 0) {
        break;
      }
      throw new TangoOutOfDateException();
      if ((!isStringEmpty(str1)) && (isStringEmpty(str2)))
      {
        Log.w("Tango", "Both dataset path and UUID must be set in config for LeTango playback");
        throw new TangoInvalidException();
        throwTangoExceptionIfNeeded(TangoJNINative.Connect(paramTangoConfig));
      }
    }
  }
  
  public void connectListener(List<TangoCoordinateFramePair> paramList, TangoUpdateCallback paramTangoUpdateCallback)
  {
    this.mCallback = paramTangoUpdateCallback;
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.setPoseListenerFrames(paramList));
        return;
      }
      catch (RemoteException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      catch (NullPointerException paramList)
      {
        paramList.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    Object localObject = new int[0];
    if (paramList != null)
    {
      int[] arrayOfInt = new int[paramList.size() * 2];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramList.size()) {
          break;
        }
        arrayOfInt[(i * 2)] = ((TangoCoordinateFramePair)paramList.get(i)).baseFrame;
        arrayOfInt[(i * 2 + 1)] = ((TangoCoordinateFramePair)paramList.get(i)).targetFrame;
        i += 1;
      }
    }
    if (paramTangoUpdateCallback != null)
    {
      throwTangoExceptionIfNeeded(TangoJNINative.ConnectListener((int[])localObject, paramTangoUpdateCallback, new TangoPoseData(), new TangoPointCloudData(), new TangoEvent()));
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.ConnectListener((int[])localObject, paramTangoUpdateCallback, null, null, null));
  }
  
  public void connectNativeOnFrameAvailableListener(int paramInt)
  {
    experimentalConnectOnFrameListener(paramInt, new OnFrameAvailableListener()
    {
      public void onFrameAvailable(TangoImageBuffer paramAnonymousTangoImageBuffer, int paramAnonymousInt)
      {
        Tango.nativeOnFrameAvailable(paramAnonymousTangoImageBuffer, paramAnonymousInt);
      }
    });
  }
  
  public void connectOnImageAvailable(int paramInt)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.connectOnImageAvailable(paramInt, new IOnImageAvailableListener.Stub()
      {
        public void onImageAvailable(int paramAnonymousInt, TangoImage paramAnonymousTangoImage, TangoCameraMetadata paramAnonymousTangoCameraMetadata, IObjectWrapper paramAnonymousIObjectWrapper1, IObjectWrapper paramAnonymousIObjectWrapper2, IObjectWrapper paramAnonymousIObjectWrapper3, IObjectWrapper paramAnonymousIObjectWrapper4)
        {
          paramAnonymousTangoImage.planeData[0] = ((ByteBuffer)ObjectWrapper.unwrap(paramAnonymousIObjectWrapper1, ByteBuffer.class));
          paramAnonymousTangoImage.planeData[1] = ((ByteBuffer)ObjectWrapper.unwrap(paramAnonymousIObjectWrapper2, ByteBuffer.class));
          paramAnonymousTangoImage.planeData[2] = ((ByteBuffer)ObjectWrapper.unwrap(paramAnonymousIObjectWrapper3, ByteBuffer.class));
          paramAnonymousTangoImage.planeData[3] = ((ByteBuffer)ObjectWrapper.unwrap(paramAnonymousIObjectWrapper4, ByteBuffer.class));
          if (Tango.this.mCallback != null) {
            Tango.this.mCallback.onImageAvailable(paramAnonymousTangoImage, paramAnonymousTangoCameraMetadata, paramAnonymousInt);
          }
        }
      }, this.mTangoServiceConnected));
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.ConnectOnImageAvailable(paramInt, this.mCallback));
  }
  
  public void connectOnTextureAvailable(int paramInt)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.connectOnTextureAvailable(paramInt, this.mTangoServiceConnected));
      return;
    }
    throwTangoExceptionIfNeeded(-2);
  }
  
  public void connectTextureId(int paramInt1, int paramInt2)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.connectTextureId(paramInt1, paramInt2, this.mTangoServiceConnected));
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.ConnectTextureId(paramInt1, paramInt2));
  }
  
  public void createFrameOfInterest(double paramDouble, String paramString, TangoTransformation paramTangoTransformation, FoiListener paramFoiListener)
  {
    if ((paramString == null) || (paramTangoTransformation == null) || (paramFoiListener == null)) {
      throwTangoExceptionIfNeeded(-2);
    }
    FoiRequest.Create localCreate;
    if (PURE_JAVA_PATH)
    {
      localCreate = new FoiRequest.Create();
      localCreate.mTimestamp = paramDouble;
      localCreate.mBaseFrameId = paramString;
      localCreate.mTransformation = paramTangoTransformation;
    }
    for (int i = handleFoiRequest(localCreate, paramFoiListener);; i = TangoJNINative.CreateFrameOfInterest2(paramDouble, paramString, paramTangoTransformation, paramFoiListener))
    {
      throwTangoExceptionIfNeeded(i);
      return;
    }
  }
  
  public void deleteAreaDescription(String paramString)
  {
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.deleteAreaDescription(paramString));
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.DeleteAreaDescription(paramString));
  }
  
  public void deleteFramesOfInterest(String[] paramArrayOfString, FoiListener paramFoiListener)
  {
    if ((paramArrayOfString == null) || (paramFoiListener == null)) {
      throwTangoExceptionIfNeeded(-2);
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        throwTangoExceptionIfNeeded(-2);
      }
      i += 1;
    }
    FoiRequest.Delete localDelete;
    if (PURE_JAVA_PATH)
    {
      localDelete = new FoiRequest.Delete();
      localDelete.mFrameIds = paramArrayOfString;
    }
    for (i = handleFoiRequest(localDelete, paramFoiListener);; i = TangoJNINative.DeleteFramesOfInterest(paramArrayOfString, paramFoiListener))
    {
      throwTangoExceptionIfNeeded(i);
      return;
    }
  }
  
  public void disconnect()
  {
    this.mCallbacksAllowed.acquireUninterruptibly(100);
    this.mTangoShouldBeDisconnected = true;
    this.mCallback = null;
    this.mCallbacksAllowed.release(100);
    if (PURE_JAVA_PATH)
    {
      try
      {
        TangoCameraNativeLoader.stopAllCameras();
        TangoCameraNativeLoader.disconnect();
        if (this.mITango != null) {
          this.mITango.disconnect();
        }
        this.mTangoServiceConnected = false;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
      clearFoiListeners();
      this.mITango = null;
    }
    for (;;)
    {
      if (this.mServiceConnection != null)
      {
        this.mParent.unbindService(this.mServiceConnection);
        this.mServiceConnection = null;
      }
      return;
      TangoJNINative.Disconnect();
    }
  }
  
  public void disconnectCamera(int paramInt)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.disconnectCamera(paramInt));
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.DisconnectCamera(paramInt));
  }
  
  public void disconnectWithoutUnbind()
  {
    this.mCallbacksAllowed.acquireUninterruptibly(100);
    this.mCallback = null;
    this.mCallbacksAllowed.release(100);
    if (PURE_JAVA_PATH)
    {
      try
      {
        TangoCameraNativeLoader.stopAllCameras();
        if (this.mITango != null) {
          this.mITango.disconnect();
        }
        this.mTangoServiceConnected = false;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
      clearFoiListeners();
      return;
    }
    TangoJNINative.Disconnect();
  }
  
  public void experimentalConnectOnFrameListener(int paramInt, final OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.connectOnFrameAvailable(paramInt, new IOnFrameAvailableListener.Stub()
      {
        public void onFrameAvailable(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong1, double paramAnonymousDouble, int paramAnonymousInt4, IObjectWrapper paramAnonymousIObjectWrapper, int paramAnonymousInt5, long paramAnonymousLong2)
        {
          paramAnonymousIObjectWrapper = new TangoImageBuffer(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong1, paramAnonymousDouble, paramAnonymousInt4, (ByteBuffer)ObjectWrapper.unwrap(paramAnonymousIObjectWrapper, ByteBuffer.class), paramAnonymousLong2);
          paramOnFrameAvailableListener.onFrameAvailable(paramAnonymousIObjectWrapper, paramAnonymousInt5);
        }
      }, this.mTangoServiceConnected));
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.ConnectOnFrameAvailable(paramInt, paramOnFrameAvailableListener, new TangoImageBuffer()));
  }
  
  public void experimentalDeleteDataset(String paramString)
  {
    if (PURE_JAVA_PATH) {
      return;
    }
    throwTangoExceptionIfNeeded(TangoJNINative.DeleteDataset(paramString));
  }
  
  public String experimentalGetCurrentDatasetUuid()
  {
    String[] arrayOfString = new String[1];
    if (PURE_JAVA_PATH) {}
    for (;;)
    {
      return arrayOfString[0];
      throwTangoExceptionIfNeeded(TangoJNINative.GetCurrentDatasetUUID(arrayOfString));
    }
  }
  
  public TangoPlaneData experimentalGetPlaneByUVCoord(int paramInt, TangoPoseData paramTangoPoseData, double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length != 2) || (paramArrayOfDouble[0] < 0.0D) || (paramArrayOfDouble[0] >= 1.0D) || (paramArrayOfDouble[1] < 0.0D) || (paramArrayOfDouble[1] >= 1.0D)) {
      throw new TangoInvalidException();
    }
    TangoPlaneData localTangoPlaneData = new TangoPlaneData();
    if (PURE_JAVA_PATH) {}
    try
    {
      throwTangoExceptionIfNeeded(this.mITango.getPlaneByUVCoord(paramInt, paramTangoPoseData, paramArrayOfDouble, localTangoPlaneData));
      return localTangoPlaneData;
    }
    catch (RemoteException paramTangoPoseData)
    {
      paramTangoPoseData.printStackTrace();
    }
    return localTangoPlaneData;
  }
  
  public List<TangoPlaneData> experimentalGetPlanes()
  {
    if (PURE_JAVA_PATH) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int i = this.mITango.getPlanes(localArrayList);
        if (i == 0) {
          return localArrayList;
        }
        return null;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public List<String> experimentalListDatasets()
  {
    Object localObject = new String[1];
    if (PURE_JAVA_PATH) {}
    for (;;)
    {
      localObject = localObject[0];
      if (((String)localObject).length() <= 0) {
        break;
      }
      return new ArrayList(Arrays.asList(((String)localObject).split("\\s*,\\s*")));
      throwTangoExceptionIfNeeded(TangoJNINative.GetDatasets((String[])localObject));
    }
    Log.w("Tango", "No datasets were found.");
    return new ArrayList();
  }
  
  public void exportAreaDescriptionFile(String paramString1, String paramString2)
  {
    try
    {
      Activity localActivity = (Activity)this.mParent;
      Intent localIntent2 = new Intent();
      localIntent2.setClassName("com.google.tango", "com.google.atap.tango.RequestImportExportActivity");
      Intent localIntent1 = localIntent2;
      if (localIntent2.resolveActivity(this.mParent.getPackageManager()) == null)
      {
        localIntent1 = new Intent();
        localIntent1.setClassName("com.projecttango.tango", "com.google.atap.tango.RequestImportExportActivity");
      }
      localIntent1.putExtra("SOURCE_UUID", paramString1);
      localIntent1.putExtra("DESTINATION_FILE", paramString2);
      localActivity.startActivityForResult(localIntent1, 1129);
      return;
    }
    catch (ClassCastException paramString1)
    {
      Log.e("Tango", "Error: exportAreaDescriptionFile can only be called from an Activity.");
      throw new TangoErrorException();
    }
  }
  
  public TangoCameraIntrinsics getCameraIntrinsics(int paramInt)
  {
    TangoCameraIntrinsics localTangoCameraIntrinsics = new TangoCameraIntrinsics();
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.getCameraIntrinsics(paramInt, localTangoCameraIntrinsics));
        return localTangoCameraIntrinsics;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return localTangoCameraIntrinsics;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.GetCameraIntrinsics(paramInt, localNullPointerException));
    return localNullPointerException;
  }
  
  public TangoConfig getConfig(int paramInt)
  {
    TangoConfig localTangoConfig = new TangoConfig();
    if (PURE_JAVA_PATH) {
      try
      {
        this.mITango.getConfig(paramInt, localTangoConfig);
        return localTangoConfig;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return localTangoConfig;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    TangoJNINative.GetConfig(paramInt, localNullPointerException);
    return localNullPointerException;
  }
  
  public TangoPoseData getPoseAtTime(double paramDouble, TangoCoordinateFramePair paramTangoCoordinateFramePair)
  {
    TangoPoseData localTangoPoseData = new TangoPoseData();
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.getPoseAtTime(paramDouble, paramTangoCoordinateFramePair, localTangoPoseData));
        return localTangoPoseData;
      }
      catch (RemoteException paramTangoCoordinateFramePair)
      {
        paramTangoCoordinateFramePair.printStackTrace();
        return localTangoPoseData;
      }
      catch (NullPointerException paramTangoCoordinateFramePair)
      {
        paramTangoCoordinateFramePair.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.GetPoseAtTime(paramDouble, paramTangoCoordinateFramePair.baseFrame, paramTangoCoordinateFramePair.targetFrame, localTangoPoseData));
    return localTangoPoseData;
  }
  
  public TangoPoseData getPoseAtTime(double paramDouble, String paramString1, String paramString2)
  {
    TangoPoseData localTangoPoseData = new TangoPoseData();
    if (PURE_JAVA_PATH) {}
    for (;;)
    {
      try
      {
        i = this.mITango.getPoseAtTime2(paramDouble, paramString1, paramString2, localTangoPoseData);
        throwTangoExceptionIfNeeded(i);
        return localTangoPoseData;
      }
      catch (RemoteException paramString1)
      {
        paramString1.printStackTrace();
        i = -1;
        continue;
      }
      int i = TangoJNINative.GetPoseAtTime2(paramDouble, paramString1, paramString2, localTangoPoseData);
    }
  }
  
  public void importAreaDescriptionFile(String paramString)
  {
    try
    {
      Activity localActivity = (Activity)this.mParent;
      Intent localIntent2 = new Intent();
      localIntent2.setClassName("com.google.tango", "com.google.atap.tango.RequestImportExportActivity");
      Intent localIntent1 = localIntent2;
      if (localIntent2.resolveActivity(this.mParent.getPackageManager()) == null)
      {
        localIntent1 = new Intent();
        localIntent1.setClassName("com.projecttango.tango", "com.google.atap.tango.RequestImportExportActivity");
      }
      localIntent1.putExtra("SOURCE_FILE", paramString);
      localActivity.startActivityForResult(localIntent1, 1129);
      return;
    }
    catch (ClassCastException paramString)
    {
      Log.e("Tango", "Error: importAreaDescriptionFile can only be called from an Activity.");
      throw new TangoErrorException();
    }
  }
  
  public ArrayList<String> listAreaDescriptions()
  {
    Object localObject1 = new String[1];
    if (PURE_JAVA_PATH)
    {
      try
      {
        Object localObject2 = new ArrayList();
        throwTangoExceptionIfNeeded(this.mITango.getAreaDescriptionUuidList((List)localObject2));
        localObject2 = (String[])((ArrayList)localObject2).toArray((Object[])localObject1);
        localObject1 = localObject2;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        throw new TangoInvalidException();
      }
      localObject1 = localObject1[0];
      if (((String)localObject1).length() <= 0) {
        break label134;
      }
    }
    label134:
    ArrayList localArrayList;
    for (localObject1 = new ArrayList(Arrays.asList(((String)localObject1).split("\\s*,\\s*")));; localArrayList = new ArrayList())
    {
      Log.i("Tango", "Number of uuids is " + ((ArrayList)localObject1).size());
      return (ArrayList<String>)localObject1;
      throwTangoExceptionIfNeeded(TangoJNINative.GetAreaDescriptionUUIDList(localNullPointerException));
      break;
      Log.w("Tango", "No UUIDs.");
    }
  }
  
  public TangoAreaDescriptionMetaData loadAreaDescriptionMetaData(String paramString)
  {
    TangoAreaDescriptionMetaData localTangoAreaDescriptionMetaData = new TangoAreaDescriptionMetaData();
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.loadAreaDescriptionMetaData(paramString, localTangoAreaDescriptionMetaData));
        return localTangoAreaDescriptionMetaData;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return localTangoAreaDescriptionMetaData;
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.GetAreaDescriptionMetadata(paramString, localTangoAreaDescriptionMetaData));
    return localTangoAreaDescriptionMetaData;
  }
  
  public void loadFramesOfInterest(String[] paramArrayOfString, FoiListener paramFoiListener)
  {
    if ((paramArrayOfString == null) || (paramFoiListener == null)) {
      throwTangoExceptionIfNeeded(-2);
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        throwTangoExceptionIfNeeded(-2);
      }
      i += 1;
    }
    FoiRequest.Load localLoad;
    if (PURE_JAVA_PATH)
    {
      localLoad = new FoiRequest.Load();
      localLoad.mFrameIds = paramArrayOfString;
    }
    for (i = handleFoiRequest(localLoad, paramFoiListener);; i = TangoJNINative.LoadFramesOfInterest(paramArrayOfString, paramFoiListener))
    {
      throwTangoExceptionIfNeeded(i);
      return;
    }
  }
  
  public double lockCameraBuffer(int paramInt, long[] paramArrayOfLong)
  {
    double[] arrayOfDouble = new double[1];
    if (PURE_JAVA_PATH) {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.lockCameraBuffer(paramInt, arrayOfDouble, paramArrayOfLong));
    }
    for (;;)
    {
      return arrayOfDouble[0];
      throwTangoExceptionIfNeeded(-2);
    }
  }
  
  public void resetMotionTracking()
  {
    if (PURE_JAVA_PATH) {
      try
      {
        this.mITango.resetMotionTracking();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    TangoJNINative.ResetMotionTracking();
  }
  
  public String saveAreaDescription()
  {
    Object localObject1 = new String[1];
    if (PURE_JAVA_PATH) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new ArrayList();
        throwTangoExceptionIfNeeded(this.mITango.saveAreaDescription((List)localObject2));
        localObject2 = (String[])((ArrayList)localObject2).toArray((Object[])localObject1);
        localObject1 = localObject2;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        throw new TangoInvalidException();
      }
      return localObject1[0];
      throwTangoExceptionIfNeeded(TangoJNINative.SaveAreaDescription(localNullPointerException));
    }
  }
  
  public void saveAreaDescriptionMetadata(String paramString, TangoAreaDescriptionMetaData paramTangoAreaDescriptionMetaData)
  {
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.saveAreaDescriptionMetaData(paramString, paramTangoAreaDescriptionMetaData));
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.SaveAreaDescriptionMetadata(paramString, paramTangoAreaDescriptionMetaData));
  }
  
  public void setRuntimeConfig(TangoConfig paramTangoConfig)
  {
    if (PURE_JAVA_PATH) {
      try
      {
        throwTangoExceptionIfNeeded(this.mITango.setRuntimeConfig(paramTangoConfig));
        return;
      }
      catch (RemoteException paramTangoConfig)
      {
        paramTangoConfig.printStackTrace();
        return;
      }
      catch (NullPointerException paramTangoConfig)
      {
        paramTangoConfig.printStackTrace();
        throw new TangoInvalidException();
      }
    }
    throwTangoExceptionIfNeeded(TangoJNINative.SetRuntimeConfig(paramTangoConfig));
  }
  
  public void unlockCameraBuffer(int paramInt, long paramLong)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.unlockCameraBuffer(paramInt, paramLong));
      return;
    }
    throwTangoExceptionIfNeeded(-2);
  }
  
  public double updateTexture(int paramInt)
  {
    double[] arrayOfDouble = new double[1];
    if (PURE_JAVA_PATH) {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.updateTexture(paramInt, arrayOfDouble));
    }
    for (;;)
    {
      return arrayOfDouble[0];
      throwTangoExceptionIfNeeded(TangoJNINative.UpdateTexture(paramInt, arrayOfDouble));
    }
  }
  
  public double updateTextureExternalOes(int paramInt1, int paramInt2)
  {
    double[] arrayOfDouble = new double[1];
    if (PURE_JAVA_PATH) {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.updateTextureExternalOes(paramInt1, paramInt2, arrayOfDouble));
    }
    for (;;)
    {
      return arrayOfDouble[0];
      throwTangoExceptionIfNeeded(-2);
    }
  }
  
  public void updateTextureExternalOesForBuffer(int paramInt1, int paramInt2, long paramLong)
  {
    if (PURE_JAVA_PATH)
    {
      throwTangoExceptionIfNeeded(TangoCameraNativeLoader.updateTextureExternalOesForBuffer(paramInt1, paramInt2, paramLong));
      return;
    }
    throwTangoExceptionIfNeeded(-2);
  }
  
  public static abstract interface FoiListener
  {
    public abstract void onFoiResult(TangoFoiResult[] paramArrayOfTangoFoiResult);
  }
  
  public static abstract interface OnFrameAvailableListener
  {
    public abstract void onFrameAvailable(TangoImageBuffer paramTangoImageBuffer, int paramInt);
  }
  
  @Deprecated
  public static abstract class OnTangoUpdateListener
    extends Tango.TangoUpdateCallback
  {}
  
  public static abstract class TangoUpdateCallback
  {
    public void onFrameAvailable(int paramInt) {}
    
    public void onImageAvailable(TangoImage paramTangoImage, TangoCameraMetadata paramTangoCameraMetadata, int paramInt) {}
    
    public void onOnlineCalibrationStatus(int paramInt) {}
    
    public void onPointCloudAvailable(TangoPointCloudData paramTangoPointCloudData) {}
    
    public void onPoseAvailable(TangoPoseData paramTangoPoseData) {}
    
    public void onTangoEvent(TangoEvent paramTangoEvent) {}
    
    public void onXyzIjAvailable(TangoXyzIjData paramTangoXyzIjData) {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/Tango.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */