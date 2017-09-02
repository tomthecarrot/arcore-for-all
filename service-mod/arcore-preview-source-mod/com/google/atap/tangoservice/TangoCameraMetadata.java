package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TangoCameraMetadata
  implements Parcelable
{
  public static final Parcelable.Creator<TangoCameraMetadata> CREATOR = new Parcelable.Creator()
  {
    public TangoCameraMetadata createFromParcel(Parcel paramAnonymousParcel)
    {
      TangoCameraMetadata localTangoCameraMetadata = new TangoCameraMetadata();
      localTangoCameraMetadata.readFromParcel(paramAnonymousParcel);
      return localTangoCameraMetadata;
    }
    
    public TangoCameraMetadata[] newArray(int paramAnonymousInt)
    {
      return new TangoCameraMetadata[paramAnonymousInt];
    }
  };
  public static final int NUM_COLOR_CORRECTION_GAIN_VALUES = 4;
  public static final int NUM_COLOR_CORRECTION_TRANSFORM_VALUES = 9;
  public static final int NUM_SENSOR_NEUTRAL_COLOR_POINT_VALUES = 3;
  public final float[] colorCorrectionGains = new float[4];
  public int colorCorrectionMode = 0;
  public final float[] colorCorrectionTransform = new float[9];
  public long exposureDurationNs = 0L;
  public long frameNumber = 0L;
  public float lensAperture = 0.0F;
  public int sensitivityISO = 0;
  public final float[] sensorNeutralColorPoint = new float[3];
  public long timestampNs = 0L;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.timestampNs = paramParcel.readLong();
    this.frameNumber = paramParcel.readLong();
    this.exposureDurationNs = paramParcel.readLong();
    this.sensitivityISO = paramParcel.readInt();
    this.lensAperture = paramParcel.readFloat();
    this.colorCorrectionMode = paramParcel.readInt();
    paramParcel.readFloatArray(this.colorCorrectionGains);
    paramParcel.readFloatArray(this.colorCorrectionTransform);
    paramParcel.readFloatArray(this.sensorNeutralColorPoint);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.timestampNs);
    paramParcel.writeLong(this.frameNumber);
    paramParcel.writeLong(this.exposureDurationNs);
    paramParcel.writeInt(this.sensitivityISO);
    paramParcel.writeFloat(this.lensAperture);
    paramParcel.writeInt(this.colorCorrectionMode);
    paramParcel.writeFloatArray(this.colorCorrectionGains);
    paramParcel.writeFloatArray(this.colorCorrectionTransform);
    paramParcel.writeFloatArray(this.sensorNeutralColorPoint);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoCameraMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */