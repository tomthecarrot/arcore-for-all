package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TangoPoseData
  implements Parcelable
{
  public static final int COORDINATE_FRAME_AREA_DESCRIPTION = 1;
  public static final int COORDINATE_FRAME_CAMERA_COLOR = 7;
  public static final int COORDINATE_FRAME_CAMERA_DEPTH = 8;
  public static final int COORDINATE_FRAME_CAMERA_FISHEYE = 9;
  public static final int COORDINATE_FRAME_DEVICE = 4;
  public static final int COORDINATE_FRAME_DISPLAY = 6;
  public static final int COORDINATE_FRAME_GLOBAL_WGS84 = 0;
  public static final int COORDINATE_FRAME_IMU = 5;
  public static final int COORDINATE_FRAME_PREVIOUS_DEVICE_POSE = 3;
  public static final int COORDINATE_FRAME_START_OF_SERVICE = 2;
  public static final int COORDINATE_FRAME_UUID = 10;
  public static final Parcelable.Creator<TangoPoseData> CREATOR = new Parcelable.Creator()
  {
    public TangoPoseData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoPoseData(paramAnonymousParcel, null);
    }
    
    public TangoPoseData[] newArray(int paramAnonymousInt)
    {
      return new TangoPoseData[paramAnonymousInt];
    }
  };
  public static final String[] FRAME_NAMES = { "GLOBAL_WGS84", "AREA_DESCRIPTION", "START_OF_SERVICE", "PREVIOUS_DEVICE_POSE", "DEVICE", "IMU", "DISPLAY", "CAMERA_COLOR", "CAMERA_DEPTH", "CAMERA_FISHEYE", "UUID" };
  public static final int INDEX_ROTATION_W = 3;
  public static final int INDEX_ROTATION_X = 0;
  public static final int INDEX_ROTATION_Y = 1;
  public static final int INDEX_ROTATION_Z = 2;
  public static final int INDEX_TRANSLATION_X = 0;
  public static final int INDEX_TRANSLATION_Y = 1;
  public static final int INDEX_TRANSLATION_Z = 2;
  public static final int POSE_INITIALIZING = 0;
  public static final int POSE_INVALID = 2;
  public static final int POSE_UNKNOWN = 3;
  public static final int POSE_VALID = 1;
  public static final String[] STATUS_NAMES = { "INITIALIZING", "VALID", "INVALID", "UNKNOWN" };
  public float accuracy = 0.0F;
  public int baseFrame = 0;
  public int confidence = 0;
  public double[] rotation = { 0.0D, 0.0D, 0.0D, 1.0D };
  public int statusCode = 0;
  public int targetFrame = 0;
  public double timestamp = 0.0D;
  public double[] translation = { 0.0D, 0.0D, 0.0D };
  
  public TangoPoseData()
  {
    this.statusCode = 2;
  }
  
  private TangoPoseData(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float[] getRotationAsFloats()
  {
    float[] arrayOfFloat = new float[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfFloat[i] = ((float)this.rotation[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public float[] getTranslationAsFloats()
  {
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfFloat[i] = ((float)this.translation[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.timestamp = paramParcel.readDouble();
    paramParcel.readDoubleArray(this.rotation);
    paramParcel.readDoubleArray(this.translation);
    this.statusCode = paramParcel.readInt();
    this.baseFrame = paramParcel.readInt();
    this.targetFrame = paramParcel.readInt();
  }
  
  public String toString()
  {
    String str1 = String.format("TangoPoseData: status: %d (%s), time: %f, base: %d (%s), target: %d (%s) ", new Object[] { Integer.valueOf(this.statusCode), STATUS_NAMES[this.statusCode], Double.valueOf(this.timestamp), Integer.valueOf(this.baseFrame), FRAME_NAMES[this.baseFrame], Integer.valueOf(this.targetFrame), FRAME_NAMES[this.targetFrame] });
    String str2 = String.format("p: [%.3f, %.3f, %.3f], q: [%.4f, %.4f, %.4f, %.4f]\n", new Object[] { Double.valueOf(this.translation[0]), Double.valueOf(this.translation[1]), Double.valueOf(this.translation[2]), Double.valueOf(this.rotation[0]), Double.valueOf(this.rotation[1]), Double.valueOf(this.rotation[2]), Double.valueOf(this.rotation[3]) });
    return str1 + str2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.timestamp);
    paramParcel.writeDoubleArray(this.rotation);
    paramParcel.writeDoubleArray(this.translation);
    paramParcel.writeInt(this.statusCode);
    paramParcel.writeInt(this.baseFrame);
    paramParcel.writeInt(this.targetFrame);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoPoseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */