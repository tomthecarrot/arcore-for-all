package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class TangoPointCloudData
  implements Parcelable
{
  public static final Parcelable.Creator<TangoPointCloudData> CREATOR = new Parcelable.Creator()
  {
    public TangoPointCloudData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoPointCloudData(paramAnonymousParcel, null);
    }
    
    public TangoPointCloudData[] newArray(int paramAnonymousInt)
    {
      return new TangoPointCloudData[paramAnonymousInt];
    }
  };
  public int numPoints;
  public int pointCloudNativeFileDescriptor;
  @Deprecated
  public ParcelFileDescriptor pointCloudParcelFileDescriptor;
  @Deprecated
  public int pointCloudParcelFileDescriptorFlags;
  @Deprecated
  public int pointCloudParcelFileDescriptorOffset;
  @Deprecated
  public int pointCloudParcelFileDescriptorSize;
  public FloatBuffer points;
  public double timestamp;
  
  public TangoPointCloudData() {}
  
  private TangoPointCloudData(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public FloatBuffer getPointsBuffer()
  {
    return this.points;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.timestamp = paramParcel.readDouble();
    this.numPoints = paramParcel.readInt();
    if (this.numPoints == 0) {
      return;
    }
    this.pointCloudParcelFileDescriptor = paramParcel.readFileDescriptor();
    this.pointCloudParcelFileDescriptorSize = paramParcel.readInt();
    this.pointCloudParcelFileDescriptorFlags = paramParcel.readInt();
    this.pointCloudParcelFileDescriptorOffset = paramParcel.readInt();
    try
    {
      paramParcel = new FileInputStream(this.pointCloudParcelFileDescriptor.getFileDescriptor());
      MappedByteBuffer localMappedByteBuffer = paramParcel.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, this.numPoints * 4 * 4);
      localMappedByteBuffer.order(ByteOrder.nativeOrder());
      paramParcel.close();
      this.pointCloudParcelFileDescriptor.close();
      this.points = localMappedByteBuffer.asFloatBuffer();
      return;
    }
    catch (IOException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.timestamp);
    paramParcel.writeInt(this.numPoints);
    paramParcel.writeFileDescriptor(this.pointCloudParcelFileDescriptor.getFileDescriptor());
    paramParcel.writeInt(this.pointCloudParcelFileDescriptorSize);
    paramParcel.writeInt(this.pointCloudParcelFileDescriptorFlags);
    paramParcel.writeInt(this.pointCloudParcelFileDescriptorOffset);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoPointCloudData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */