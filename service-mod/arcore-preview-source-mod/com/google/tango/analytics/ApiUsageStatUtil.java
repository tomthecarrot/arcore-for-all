package com.google.tango.analytics;

import java.util.HashMap;

public class ApiUsageStatUtil
{
  private static final HashMap<String, TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey> ADF_METADATA_KEY_MAPPING;
  private static final HashMap<String, TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey> CONFIG_KEY_MAPPING = new HashMap();
  private static final HashMap<String, TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType> CONFIG_TYPE_MAPPING;
  
  static
  {
    ADF_METADATA_KEY_MAPPING = new HashMap();
    CONFIG_TYPE_MAPPING = new HashMap();
    CONFIG_KEY_MAPPING.put("config_enable_auto_recovery", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_AUTO_RECOVERY);
    CONFIG_KEY_MAPPING.put("config_enable_color_camera", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_COLOR_CAMERA);
    CONFIG_KEY_MAPPING.put("config_enable_dataset_recording", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_DATASET_RECORDING);
    CONFIG_KEY_MAPPING.put("config_enable_depth", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_DEPTH);
    CONFIG_KEY_MAPPING.put("config_enable_drift_correction", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_DRIFT_CORRECTION);
    CONFIG_KEY_MAPPING.put("config_enable_learning_mode", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_LEARNING_MODE);
    CONFIG_KEY_MAPPING.put("config_enable_low_latency_imu_integration", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_LOW_LATENCY_IMU_INTEGRATION);
    CONFIG_KEY_MAPPING.put("config_enable_motion_tracking", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_ENABLE_MOTION_TRACKING);
    CONFIG_KEY_MAPPING.put("config_experimental_3dof_fallback", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_3DOF_FALLBACK);
    CONFIG_KEY_MAPPING.put("config_experimental_adf_runtime_loading", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_ADF_RUNTIME_LOADING);
    CONFIG_KEY_MAPPING.put("config_experimental_enable_scene_reconstruction", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_ENABLE_SCENE_RECONSTRUCTION);
    CONFIG_KEY_MAPPING.put("config_experimental_use_cloud_adf", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_USE_CLOUD_ADF);
    CONFIG_KEY_MAPPING.put("config_high_rate_pose", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_HIGH_RATE_POSE);
    CONFIG_KEY_MAPPING.put("config_log_callback_data", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_LOG_CALLBACK_DATA);
    CONFIG_KEY_MAPPING.put("config_smooth_pose", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_SMOOTH_POSE);
    CONFIG_KEY_MAPPING.put("config_use_pgs_instead_of_viwls", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_USE_PGS_INSTEAD_OF_VIWLS);
    CONFIG_KEY_MAPPING.put("depth_period_in_seconds", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_DEPTH_PERIOD_IN_SECONDS);
    CONFIG_KEY_MAPPING.put("config_dataset_recording_mode", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_DATASET_RECORDING_MODE);
    CONFIG_KEY_MAPPING.put("config_depth_mode", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_DEPTH_MODE);
    CONFIG_KEY_MAPPING.put("config_runtime_depth_framerate", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_RUNTIME_DEPTH_FRAMERATE);
    CONFIG_KEY_MAPPING.put("config_runtime_recording_control", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_RUNTIME_RECORDING_CONTROL);
    CONFIG_KEY_MAPPING.put("experimental_color_uv_tex_data_height", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_COLOR_UV_TEX_DATA_HEIGHT);
    CONFIG_KEY_MAPPING.put("experimental_color_uv_tex_data_width", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_COLOR_UV_TEX_DATA_WIDTH);
    CONFIG_KEY_MAPPING.put("experimental_color_y_tex_data_height", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_COLOR_Y_TEX_DATA_HEIGHT);
    CONFIG_KEY_MAPPING.put("experimental_color_y_tex_data_width", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_COLOR_Y_TEX_DATA_WIDTH);
    CONFIG_KEY_MAPPING.put("internal_config_runtime_power_state", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_INTERNAL_CONFIG_RUNTIME_POWER_STATE);
    CONFIG_KEY_MAPPING.put("max_point_cloud_elements", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_MAX_POINT_CLOUD_ELEMENTS);
    CONFIG_KEY_MAPPING.put("config_datasets_path", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_DATASETS_PATH);
    CONFIG_KEY_MAPPING.put("config_experimental_load_dataset_UUID", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_EXPERIMENTAL_LOAD_DATASET_UUID);
    CONFIG_KEY_MAPPING.put("config_load_area_description_UUID", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_LOAD_AREA_DESCRIPTION_UUID);
    CONFIG_KEY_MAPPING.put("tango_service_library_version", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey.CONFIG_KEY_TANGO_SERVICE_LIBRARY_VERSION);
    ADF_METADATA_KEY_MAPPING.put("id", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey.ADF_METADATA_KEY_ID);
    ADF_METADATA_KEY_MAPPING.put("name", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey.ADF_METADATA_KEY_NAME);
    ADF_METADATA_KEY_MAPPING.put("transformation", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey.ADF_METADATA_KEY_TRANSFORMATION);
    ADF_METADATA_KEY_MAPPING.put("date_ms_since_epoch", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey.ADF_METADATA_KEY_DATE_MS_SINCE_EPOCH);
    CONFIG_TYPE_MAPPING.put("TANGO_CONFIG_DEFAULT", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType.CONFIG_TYPE_DEFAULT);
    CONFIG_TYPE_MAPPING.put("TANGO_CONFIG_CURRENT", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType.CONFIG_TYPE_CURRENT);
    CONFIG_TYPE_MAPPING.put("TANGO_CONFIG_MOTION_TRACKING", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType.CONFIG_TYPE_MOTION_TRACKING);
    CONFIG_TYPE_MAPPING.put("TANGO_CONFIG_AREA_LEARNING", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType.CONFIG_TYPE_AREA_LEARNING);
    CONFIG_TYPE_MAPPING.put("TANGO_CONFIG_RUNTIME", TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType.CONFIG_TYPE_RUNTIME);
  }
  
  public static TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey adfMetadataKeyFromString(String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.AdfMetadataKey)ADF_METADATA_KEY_MAPPING.get(paramString);
  }
  
  public static TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey configKeyFromString(String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigKey)CONFIG_KEY_MAPPING.get(paramString);
  }
  
  public static TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType configTypeFromString(String paramString)
  {
    return (TangoCoreAnalyticsLog.TangoCoreLog.DisconnectEvent.ApiUsageStat.ConfigType)CONFIG_TYPE_MAPPING.get(paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/ApiUsageStatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */