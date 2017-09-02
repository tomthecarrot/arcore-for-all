package com.google.tango.analytics;

import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class ClearcutTrackerUtil
{
  private static final String FIRST_PARTY_PREFIX = "com.google.";
  private static final String INSTALLER_ANDROID_VENDING = "com.android.vending";
  private static final String INSTALLER_GOOGLE_GMS = "com.google.android.gms";
  private static final String TAG = ClearcutTrackerUtil.class.getName();
  
  private static TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat apiUsageStatFromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    Object localObject;
    do
    {
      return null;
      localObject = new Properties();
      try
      {
        ((Properties)localObject).load(new StringReader(paramString));
        paramString = TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.newBuilder();
        Iterator localIterator = ((Properties)localObject).stringPropertyNames().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!applyApiUsageParam(paramString, str, ((Properties)localObject).getProperty(str))) {
            return null;
          }
        }
      }
      catch (IOException paramString)
      {
        Log.d(TAG, paramString.toString());
        return null;
      }
      localObject = paramString.getApiName();
    } while ((localObject == null) || (((String)localObject).length() == 0));
    return (TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat)paramString.build();
  }
  
  static boolean applyApiUsageParam(TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.Builder paramBuilder, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if (paramString1.equals("api_name"))
    {
      paramBuilder.setApiName(paramString2);
      return true;
    }
    if (paramString1.equals("config_key"))
    {
      paramString1 = ApiUsageStatUtil.configKeyFromString(paramString2);
      if (paramString1 != null)
      {
        paramBuilder.setConfigKey(paramString1);
        return true;
      }
      return false;
    }
    if (paramString1.equals("adf_metadata_key"))
    {
      paramString1 = ApiUsageStatUtil.adfMetadataKeyFromString(paramString2);
      if (paramString1 != null)
      {
        paramBuilder.setAdfMetadataKey(paramString1);
        return true;
      }
      return false;
    }
    if (paramString1.equals("get_config_type"))
    {
      paramString1 = ApiUsageStatUtil.configTypeFromString(paramString2);
      if (paramString1 != null)
      {
        paramBuilder.setGetConfigType(paramString1);
        return true;
      }
      return false;
    }
    return false;
  }
  
  static List<TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat> getApiUsageStats(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        String str = (String)localIterator.next();
        if (paramString.getInt(str) != 0)
        {
          TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat localApiUsageStat = apiUsageStatFromString(str);
          if (localApiUsageStat != null) {
            localArrayList.add(localApiUsageStat);
          } else {
            Log.d(TAG, "Failed to parse API call string: " + str);
          }
        }
      }
      catch (JSONException paramString)
      {
        Log.d(TAG, paramString.toString());
        throw new RuntimeException(paramString);
      }
    }
    return localArrayList;
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getCloudAdfTileDownloadedProto(double paramDouble1, long paramLong1, long paramLong2, double paramDouble2, String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventDownloadCloudAdf((TangoCoreAnalyticsLog.TangoCoreLog.DownloadCloudAdfEvent)TangoCoreAnalyticsLog.TangoCoreLog.DownloadCloudAdfEvent.newBuilder().setDurationSeconds(paramDouble1).setBytesRead(paramLong1).setTileId(paramLong2).setCacheWriteDurationSeconds(paramDouble2).build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getCloudAdfTileLoadedProto(double paramDouble, int paramInt, long paramLong, Long[] paramArrayOfLong, String paramString)
  {
    TangoCoreAnalyticsLog.TangoCoreLog.LoadCloudAdfEvent.Builder localBuilder = TangoCoreAnalyticsLog.TangoCoreLog.LoadCloudAdfEvent.newBuilder().setDurationSeconds(paramDouble).setNumberOfTiles(paramInt).setBytesRead(paramLong);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localBuilder.addTileId(paramArrayOfLong[paramInt].longValue());
      paramInt += 1;
    }
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventLoadCloudAdf((TangoCoreAnalyticsLog.TangoCoreLog.LoadCloudAdfEvent)localBuilder.build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getCloudDownloadFailureProto(long paramLong, int paramInt, String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventCloudFailure((TangoCoreAnalyticsLog.TangoCoreLog.CloudFailureEvent)TangoCoreAnalyticsLog.TangoCoreLog.CloudFailureEvent.newBuilder().setTileId(paramLong).setErrorStatus(paramInt).build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getCloudReadyProto(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventCloudReady((TangoCoreAnalyticsLog.TangoCoreLog.CloudReadyEvent)TangoCoreAnalyticsLog.TangoCoreLog.CloudReadyEvent.newBuilder().setConnectToCloudStartDurationSeconds(paramDouble1).setCloudStartToReadyDurationSeconds(paramDouble2).setNumberOfTilesDownloaded(paramInt1).setNumberOfTilesLoaded(paramInt2).build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getConnectProto(double paramDouble, int paramInt, String paramString1, TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig paramTangoSessionConfig, String paramString2)
  {
    TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType localErrorType;
    switch (paramInt)
    {
    default: 
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.UNKNOWN_ERROR;
    }
    for (;;)
    {
      return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString2).setEventConnect(TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.newBuilder().setConnectCallDurationSeconds(paramDouble).setErrorMessage(localErrorType).setApplicationName(paramString1).setConfigInfo(paramTangoSessionConfig)).build();
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.NO_DATASET_PERMISSION;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.NO_IMPORT_EXPORT_PERMISSION;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.NO_CAMERA_PERMISSION;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.NO_ADF_PERMISSION;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.NO_MOTION_TRACKING_PERMISSION;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.INVALID_ARGUMENT;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.OTHER_ERROR;
      continue;
      localErrorType = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.ErrorType.SUCCESS;
    }
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getDisconnectProto(double paramDouble1, double paramDouble2, List<TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat> paramList, String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventDisconnect((TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent)TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.newBuilder().addAllApiUsageStat(paramList).setSessionDurationSeconds(paramDouble1).build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getHalDebugStatsProto(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str;
    for (;;)
    {
      Object localObject;
      try
      {
        localJSONObject1 = new JSONObject(paramString1);
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("events");
        paramString1 = TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.newBuilder();
        Iterator localIterator = localJSONObject2.keys();
        if (!localIterator.hasNext()) {
          break label298;
        }
        str = (String)localIterator.next();
        localObject = localJSONObject2.getJSONObject(str);
        localObject = (TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats.newBuilder().setSessionDuration(((JSONObject)localObject).optDouble("duration", -1.0D)).setAverageRate(((JSONObject)localObject).optDouble("rate", -1.0D)).setTotalEvents(((JSONObject)localObject).getInt("total")).setNonIncreasingEvents(((JSONObject)localObject).getInt("non-increasing")).setSkippedEvents(((JSONObject)localObject).getInt("skipped")).setStutterEvents(((JSONObject)localObject).getInt("stutter")).build();
        if (str.equals("Accel"))
        {
          paramString1.setAccelerometerStats((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)localObject);
          continue;
        }
        if (!str.equals("Gyro")) {
          break label206;
        }
      }
      catch (JSONException paramString1)
      {
        Log.d(TAG, paramString1.toString());
        throw new RuntimeException(paramString1);
      }
      paramString1.setGyroscopeStats((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)localObject);
      continue;
      label206:
      if (str.equals("Features"))
      {
        paramString1.setFeaturesStats((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)localObject);
      }
      else if (str.equals("PointCloud"))
      {
        paramString1.setPointCloudStats((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)localObject);
      }
      else
      {
        if (!str.equals("RGB")) {
          break;
        }
        paramString1.setRgbCameraStats((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent.HalStats)localObject);
      }
    }
    throw new IllegalArgumentException("Encountered unexpected event type: " + str);
    label298:
    JSONObject localJSONObject1 = localJSONObject1.getJSONObject("device");
    paramString1.setCpuLoad(localJSONObject1.getInt("CPU_load")).setDeviceTemperature(localJSONObject1.optInt("temperature", -1)).setFaultEvent(paramBoolean);
    paramString1 = (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setHalDebugEvent((TangoCoreAnalyticsLog.TangoCoreLog.HalDebugEvent)paramString1.build()).setTangoSessionId(paramString2).build();
    return paramString1;
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getLocalizationSuccessProto(double paramDouble1, double paramDouble2, String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventLocalizationSuccess((TangoCoreAnalyticsLog.TangoCoreLog.LocalizationSuccessEvent)TangoCoreAnalyticsLog.TangoCoreLog.LocalizationSuccessEvent.newBuilder().setDistanceWalkedMeters(paramDouble2).setDurationSeconds(paramDouble1).build()).build();
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig getSessionConfigProto(String paramString)
  {
    TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.Builder localBuilder = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.newBuilder();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoDepthMode localTangoDepthMode;
        boolean bool;
        switch (localJSONObject.getInt("config_dataset_recording_mode"))
        {
        case 0: 
          paramString = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoRecordingMode.UNKNOWN_RECORDING_MODE;
          switch (localJSONObject.getInt("config_depth_mode"))
          {
          case -1: 
            localTangoDepthMode = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoDepthMode.UNKNOWN_DEPTH_MODE;
            paramString = localBuilder.setEnableAutoRecovery(localJSONObject.getBoolean("config_enable_auto_recovery")).setEnableColorCamera(localJSONObject.getBoolean("config_enable_color_camera")).setEnableDepth(localJSONObject.getBoolean("config_enable_depth")).setEnableLowLatencyImuIntegration(localJSONObject.getBoolean("config_enable_low_latency_imu_integration")).setEnableLearningMode(localJSONObject.getBoolean("config_enable_learning_mode")).setEnableMotionTracking(localJSONObject.getBoolean("config_enable_motion_tracking")).setDatasetRecordingMode(paramString).setEnableDatasetRecording(localJSONObject.getBoolean("config_enable_dataset_recording")).setEnableSceneReconstruction(localJSONObject.getBoolean("config_experimental_enable_scene_reconstruction")).setUseCloudAdf(localJSONObject.getBoolean("config_experimental_use_cloud_adf")).setHighRatePose(localJSONObject.getBoolean("config_high_rate_pose")).setSmoothPose(localJSONObject.getBoolean("config_smooth_pose"));
            if (!localJSONObject.optString("config_experimental_load_dataset_UUID").equals(""))
            {
              bool = true;
              paramString.setUseDataset(bool).setTangoServiceLibVersion(localJSONObject.getString("tango_service_library_version")).setDepthMode(localTangoDepthMode).setEnableDriftCorrection(localJSONObject.getBoolean("config_enable_drift_correction")).setEnable3DofFallback(localJSONObject.getBoolean("config_experimental_3dof_fallback")).setAdfRuntimeLoading(localJSONObject.getBoolean("config_experimental_adf_runtime_loading")).setLogCallbackData(localJSONObject.getBoolean("config_log_callback_data")).setRuntimeDepthFramerate(localJSONObject.getInt("config_runtime_depth_framerate")).setUsePgsInsteadOfViwls(localJSONObject.getBoolean("config_use_pgs_instead_of_viwls"));
              return (TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig)localBuilder.build();
              paramString = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoRecordingMode.MOTION_TRACKING;
            }
            break;
          }
          break;
        case 1: 
          paramString = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoRecordingMode.SCENE_RECONSTRUCTION;
          break;
        case 2: 
          paramString = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoRecordingMode.MOTION_TRACKING_AND_FISHEYE;
          break;
        case 3: 
          paramString = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoRecordingMode.ALL_MODES;
          continue;
          localTangoDepthMode = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoDepthMode.POINTCLOUD_XYZIJ;
          continue;
          localTangoDepthMode = TangoCoreAnalyticsLog.TangoCoreLog.ConnectEvent.TangoSessionConfig.TangoDepthMode.POINTCLOUD_XYZC;
          continue;
          bool = false;
          break;
        }
      }
      catch (Exception paramString)
      {
        Log.d(TAG, paramString.toString());
        throw new RuntimeException(paramString);
      }
    }
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getUserDataSegmentFirstFixProto(long paramLong, int paramInt, String paramString)
  {
    TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent.SegmentStatus localSegmentStatus;
    switch (paramInt)
    {
    default: 
      localSegmentStatus = TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent.SegmentStatus.UNKNOWN_STATUS;
    }
    for (;;)
    {
      return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventUserSegment((TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent)TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent.newBuilder().setNumBytes(paramLong).setStatus(localSegmentStatus).build()).build();
      localSegmentStatus = TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent.SegmentStatus.SEGMENT_DISCARDED;
      continue;
      localSegmentStatus = TangoCoreAnalyticsLog.TangoCoreLog.UserLocalizationSegmentEvent.SegmentStatus.SEGMENT_SAVED;
    }
  }
  
  static TangoCoreAnalyticsLog.TangoCoreLog getVioResetProto(double paramDouble1, double paramDouble2, int paramInt, String paramString)
  {
    TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.ResetType localResetType;
    switch (paramInt)
    {
    default: 
      localResetType = TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.ResetType.UNKNOWN_TYPE;
    }
    for (;;)
    {
      return (TangoCoreAnalyticsLog.TangoCoreLog)TangoCoreAnalyticsLog.TangoCoreLog.newBuilder().setTangoSessionId(paramString).setEventVioReset((TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent)TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.newBuilder().setVioSessionDurationSeconds(paramDouble1).setDistanceWalkedMeters(paramDouble2).setResetType(localResetType).build()).build();
      localResetType = TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.ResetType.AUTOMATIC;
      continue;
      localResetType = TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.ResetType.MANUAL;
      continue;
      localResetType = TangoCoreAnalyticsLog.TangoCoreLog.VioResetEvent.ResetType.DISCONNECT;
    }
  }
  
  static boolean shouldLogAppName(PackageManager paramPackageManager, String paramString)
  {
    boolean bool = false;
    if ((paramString != null) && (paramString.startsWith("com.google."))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramPackageManager = paramPackageManager.getInstallerPackageName(paramString);
        if (("com.google.android.gms".equals(paramPackageManager)) || ("com.android.vending".equals(paramPackageManager))) {
          return true;
        }
      }
      catch (IllegalArgumentException paramPackageManager)
      {
        Log.d(TAG, "Illegal Application Name", paramPackageManager);
      }
    }
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/ClearcutTrackerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */