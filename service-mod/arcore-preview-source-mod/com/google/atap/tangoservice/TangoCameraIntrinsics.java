package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TangoCameraIntrinsics
  implements Parcelable
{
  public static final Parcelable.Creator<TangoCameraIntrinsics> CREATOR = new Parcelable.Creator()
  {
    public TangoCameraIntrinsics createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoCameraIntrinsics(paramAnonymousParcel, null);
    }
    
    public TangoCameraIntrinsics[] newArray(int paramAnonymousInt)
    {
      return new TangoCameraIntrinsics[paramAnonymousInt];
    }
  };
  public static final int TANGO_CALIBRATION_EQUIDISTANT = 1;
  public static final int TANGO_CALIBRATION_POLYNOMIAL_2_PARAMETERS = 2;
  public static final int TANGO_CALIBRATION_POLYNOMIAL_3_PARAMETERS = 3;
  public static final int TANGO_CALIBRATION_POLYNOMIAL_5_PARAMETERS = 4;
  public static final int TANGO_CALIBRATION_UNKNOWN = 0;
  public static final int TANGO_CAMERA_COLOR = 0;
  public static final int TANGO_CAMERA_DEPTH = 3;
  public static final int TANGO_CAMERA_FISHEYE = 2;
  public static final int TANGO_CAMERA_RGBIR = 1;
  public int calibrationType;
  public int cameraId;
  public double cx;
  public double cy;
  public double[] distortion = { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
  public double fx;
  public double fy;
  public int height;
  public int width;
  
  public TangoCameraIntrinsics() {}
  
  private TangoCameraIntrinsics(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.cameraId = paramParcel.readInt();
    this.calibrationType = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fx = paramParcel.readDouble();
    this.fy = paramParcel.readDouble();
    this.cx = paramParcel.readDouble();
    this.cy = paramParcel.readDouble();
    paramParcel.readDoubleArray(this.distortion);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cameraId);
    paramParcel.writeInt(this.calibrationType);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeDouble(this.fx);
    paramParcel.writeDouble(this.fy);
    paramParcel.writeDouble(this.cx);
    paramParcel.writeDouble(this.cy);
    paramParcel.writeDoubleArray(this.distortion);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoCameraIntrinsics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */