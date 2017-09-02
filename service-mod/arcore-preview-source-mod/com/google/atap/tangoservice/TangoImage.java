package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;

public class TangoImage
  implements Parcelable
{
  public static final Parcelable.Creator<TangoImage> CREATOR = new Parcelable.Creator()
  {
    public TangoImage createFromParcel(Parcel paramAnonymousParcel)
    {
      TangoImage localTangoImage = new TangoImage();
      localTangoImage.readFromParcel(paramAnonymousParcel);
      return localTangoImage;
    }
    
    public TangoImage[] newArray(int paramAnonymousInt)
    {
      return new TangoImage[paramAnonymousInt];
    }
  };
  public static final int DEPTH16 = 1144402265;
  public static final int RGBA_8888 = 1;
  public static final int RGB_888 = 3;
  public static final int TANGO_MAX_IMAGE_PLANES = 4;
  public static final int YCRCB_420_SP = 17;
  public static final int YV12 = 842094169;
  public int format = 0;
  public int height = 0;
  public int numPlanes = 0;
  public ByteBuffer[] planeData = new ByteBuffer[4];
  public int[] planePixelStride = new int[4];
  public int[] planeRowStride = new int[4];
  public int[] planeSize = new int[4];
  public long timestampNs = 0L;
  public int width = 0;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.format = paramParcel.readInt();
    this.timestampNs = paramParcel.readLong();
    this.numPlanes = paramParcel.readInt();
    paramParcel.readIntArray(this.planeSize);
    paramParcel.readIntArray(this.planeRowStride);
    paramParcel.readIntArray(this.planePixelStride);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.format);
    paramParcel.writeLong(this.timestampNs);
    paramParcel.writeInt(this.numPlanes);
    paramParcel.writeIntArray(this.planeSize);
    paramParcel.writeIntArray(this.planeRowStride);
    paramParcel.writeIntArray(this.planePixelStride);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */