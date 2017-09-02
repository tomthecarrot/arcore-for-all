package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TangoEvent
  implements Parcelable
{
  public static final Parcelable.Creator<TangoEvent> CREATOR = new Parcelable.Creator()
  {
    public TangoEvent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoEvent(paramAnonymousParcel, null);
    }
    
    public TangoEvent[] newArray(int paramAnonymousInt)
    {
      return new TangoEvent[paramAnonymousInt];
    }
  };
  public static final String DESCRIPTION_COLOR_OVER_EXPOSED = "ColorOverExposed";
  public static final String DESCRIPTION_COLOR_UNDER_EXPOSED = "ColorUnderExposed";
  public static final String DESCRIPTION_FISHEYE_OVER_EXPOSED = "FisheyeOverExposed";
  public static final String DESCRIPTION_FISHEYE_UNDER_EXPOSED = "FisheyeUnderExposed";
  public static final String DESCRIPTION_SENSOR_CALLBACK_FAILURE = "callback_failure";
  public static final String DESCRIPTION_SENSOR_STARTUP_FAILURE = "startup_failure";
  public static final String DESCRIPTION_TOO_FEW_FEATURES_TRACKED = "TooFewFeaturesTracked";
  public static final int EVENT_AREA_LEARNING = 6;
  public static final int EVENT_CLOUD_ADF = 7;
  public static final int EVENT_COLOR_CAMERA = 3;
  public static final int EVENT_FEATURE_TRACKING = 5;
  public static final int EVENT_FISHEYE_CAMERA = 2;
  public static final int EVENT_GENERAL = 1;
  public static final int EVENT_IMU = 4;
  public static final int EVENT_SENSOR_FAILURE = 8;
  public static final int EVENT_UNKNOWN = 0;
  public static final String KEY_AREA_DESCRIPTION_SAVE_PROGRESS = "AreaDescriptionSaveProgress";
  public static final String KEY_SENSOR_FEATURES = "features";
  public static final String KEY_SENSOR_IMU = "imu";
  public static final String KEY_SERVICE_EXCEPTION = "TangoServiceException";
  public static final String VALUE_SERVICE_FAULT = "Service faulted will restart.";
  public String eventKey;
  public int eventType;
  public String eventValue;
  public double timestamp;
  
  public TangoEvent() {}
  
  private TangoEvent(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.timestamp = paramParcel.readDouble();
    this.eventType = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      this.eventKey = paramParcel.readString();
      this.eventValue = paramParcel.readString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.timestamp);
    paramParcel.writeInt(this.eventType);
    paramParcel.writeInt(1);
    paramParcel.writeString(this.eventKey);
    paramParcel.writeString(this.eventValue);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */