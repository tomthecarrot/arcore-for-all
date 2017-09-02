package com.google.atap.tangoservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TangoConfig
  implements Parcelable
{
  public static final int CONFIG_TYPE_AREA_DESCRIPTION = 3;
  public static final int CONFIG_TYPE_CURRENT = 1;
  public static final int CONFIG_TYPE_DEFAULT = 0;
  public static final int CONFIG_TYPE_MOTION_TRACKING = 2;
  public static final int CONFIG_TYPE_RUNTIME = 4;
  public static final Parcelable.Creator<TangoConfig> CREATOR = new Parcelable.Creator()
  {
    public TangoConfig createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoConfig(paramAnonymousParcel, null);
    }
    
    public TangoConfig[] newArray(int paramAnonymousInt)
    {
      return new TangoConfig[paramAnonymousInt];
    }
  };
  public static final String KEY_BOOLEAN_AUTORECOVERY = "config_enable_auto_recovery";
  public static final String KEY_BOOLEAN_COLORCAMERA = "config_enable_color_camera";
  public static final String KEY_BOOLEAN_DATASETRECORDING = "config_enable_dataset_recording";
  public static final String KEY_BOOLEAN_DEPTH = "config_enable_depth";
  public static final String KEY_BOOLEAN_DRIFT_CORRECTION = "config_enable_drift_correction";
  public static final String KEY_BOOLEAN_EXPERIMENTAL_DEPTH_FROM_VIO = "config_experimental_enable_depth_from_vio";
  public static final String KEY_BOOLEAN_EXPERIMENTAL_LOADDATASETUUID = "config_experimental_load_dataset_UUID";
  public static final String KEY_BOOLEAN_EXPERIMENTAL_ONLINE_CALIBRATION = "config_experimental_enable_online_calibration";
  public static final String KEY_BOOLEAN_EXPERIMENTAL_PLANE_DETECTION = "config_experimental_enable_plane_detection";
  public static final String KEY_BOOLEAN_HIGH_RATE_POSE = "config_high_rate_pose";
  public static final String KEY_BOOLEAN_LEARNINGMODE = "config_enable_learning_mode";
  public static final String KEY_BOOLEAN_LOWLATENCYIMUINTEGRATION = "config_enable_low_latency_imu_integration";
  public static final String KEY_BOOLEAN_MOTIONTRACKING = "config_enable_motion_tracking";
  public static final String KEY_BOOLEAN_SMOOTH_POSE = "config_smooth_pose";
  public static final String KEY_BOOLEAN_USE_3DOF_FALLBACK = "config_experimental_3dof_fallback";
  public static final String KEY_DOUBLE_DEPTHPERIODINSECONDS = "depth_period_in_seconds";
  public static final String KEY_INT_DATASETRECORDING_MODE = "config_dataset_recording_mode";
  public static final String KEY_INT_DEPTH_MODE = "config_depth_mode";
  public static final String KEY_INT_EXPERIMENTAL_RUNTIME_PLANE_DETECTION_CONTROL = "config_runtime_plane_detection_control";
  public static final String KEY_INT_EXPERIMENTAL_RUNTIME_RECORDING_CONTROL = "config_runtime_recording_control";
  public static final String KEY_INT_MAXPOINTCLOUDELEMENTS = "max_point_cloud_elements";
  public static final String KEY_INT_RUNTIME_DEPTH_FRAMERATE = "config_runtime_depth_framerate";
  public static final String KEY_STRING_AREADESCRIPTION = "config_load_area_description_UUID";
  public static final String KEY_STRING_DATASETS_PATH = "config_datasets_path";
  public static final String KEY_STRING_LETANGO_LOADDATASETUUID = "config_letango_load_dataset_UUID";
  public static final String KEY_STRING_SERVICEVERSION = "tango_service_library_version";
  public static final int TANGO_DATASETRECORDING_MODE_ALL = 3;
  public static final int TANGO_DATASETRECORDING_MODE_MOTION_TRACKING = 0;
  public static final int TANGO_DATASETRECORDING_MODE_MOTION_TRACKING_AND_FISHEYE = 2;
  public static final int TANGO_DATASETRECORDING_MODE_SCENE_RECONSTRUCTION = 1;
  public static final int TANGO_DEPTH_MODE_POINT_CLOUD = 0;
  public static final int TANGO_DEPTH_MODE_XYZ_IJ = -1;
  public static final int TANGO_RUNTIME_PLANE_DETECTION_NO_CHANGE = 0;
  public static final int TANGO_RUNTIME_PLANE_DETECTION_START = 1;
  public static final int TANGO_RUNTIME_PLANE_DETECTION_STOP = 2;
  public static final int TANGO_RUNTIME_RECORDING_NO_CHANGE = 0;
  public static final int TANGO_RUNTIME_RECORDING_START = 1;
  public static final int TANGO_RUNTIME_RECORDING_STOP = 2;
  private static final String VALUETYPE_BOOL = "bool";
  private static final String VALUETYPE_DOUBLE = "double";
  private static final String VALUETYPE_INT32 = "int32";
  private static final String VALUETYPE_INT64 = "uint64";
  private static final String VALUETYPE_STRING = "string";
  private Bundle data = new Bundle();
  private HashMap<String, String> typemap = new HashMap();
  
  public TangoConfig() {}
  
  private TangoConfig(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean getBoolean(String paramString)
  {
    return this.data.getBoolean(paramString);
  }
  
  public double getDouble(String paramString)
  {
    return this.data.getDouble(paramString);
  }
  
  public int getInt(String paramString)
  {
    return this.data.getInt(paramString);
  }
  
  public long getLong(String paramString)
  {
    return this.data.getLong(paramString);
  }
  
  public String getString(String paramString)
  {
    return this.data.getString(paramString);
  }
  
  public Set<String> keySet()
  {
    return this.typemap.keySet();
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.typemap.put(paramString, "bool");
    this.data.putBoolean(paramString, paramBoolean);
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    this.typemap.put(paramString, "double");
    this.data.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.typemap.put(paramString, "int32");
    this.data.putInt(paramString, paramInt);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    this.typemap.put(paramString, "uint64");
    this.data.putLong(paramString, paramLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.typemap.put(paramString1, "string");
    this.data.putString(paramString1, paramString2);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    while (paramParcel.dataAvail() > 0)
    {
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      paramParcel.readString();
      String str3 = paramParcel.readString();
      if (str2.equals("bool")) {
        putBoolean(str1, str3.equalsIgnoreCase("true"));
      } else if (str2.equals("int32")) {
        putInt(str1, Integer.parseInt(str3));
      } else if (str2.equals("uint64")) {
        putLong(str1, Long.parseLong(str3));
      } else if (str2.equals("double")) {
        putDouble(str1, Double.parseDouble(str3));
      } else if (str2.equals("string")) {
        putString(str1, str3);
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Iterator localIterator = this.typemap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str3 = (String)this.typemap.get(str2);
      paramParcel.writeString(str2);
      paramParcel.writeString(str3);
      paramParcel.writeString("desc");
      String str1 = "";
      if (str3.equals("bool")) {
        str1 = "" + getBoolean(str2);
      }
      for (;;)
      {
        paramParcel.writeString(str1);
        break;
        if (str3.equals("int32")) {
          str1 = "" + getInt(str2);
        } else if (str3.equals("uint64")) {
          str1 = "" + getLong(str2);
        } else if (str3.equals("double")) {
          str1 = "" + getDouble(str2);
        } else if (str3.equals("string")) {
          str1 = "" + getString(str2);
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */