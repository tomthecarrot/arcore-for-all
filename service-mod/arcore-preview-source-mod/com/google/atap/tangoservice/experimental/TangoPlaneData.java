package com.google.atap.tangoservice.experimental;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.atap.tangoservice.TangoPoseData;
import java.util.Arrays;

public class TangoPlaneData
  implements Parcelable
{
  public static final Parcelable.Creator<TangoPlaneData> CREATOR = new Parcelable.Creator()
  {
    public TangoPlaneData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoPlaneData(paramAnonymousParcel, null);
    }
    
    public TangoPlaneData[] newArray(int paramAnonymousInt)
    {
      return new TangoPlaneData[paramAnonymousInt];
    }
  };
  public double[] boundaryPolygon;
  public double centerX = 0.0D;
  public double centerY = 0.0D;
  public double height = 0.0D;
  public int id;
  public boolean isValid = true;
  public TangoPoseData pose;
  public int subsumedBy = -1;
  public double timestamp;
  public double width = 0.0D;
  public double yaw = 0.0D;
  
  public TangoPlaneData() {}
  
  private TangoPlaneData(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.pose = ((TangoPoseData)TangoPoseData.CREATOR.createFromParcel(paramParcel));
    this.boundaryPolygon = paramParcel.createDoubleArray();
    this.centerX = paramParcel.readDouble();
    this.centerY = paramParcel.readDouble();
    this.width = paramParcel.readDouble();
    this.height = paramParcel.readDouble();
    this.yaw = paramParcel.readDouble();
    this.timestamp = paramParcel.readDouble();
    this.subsumedBy = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isValid = bool;
      return;
    }
  }
  
  public String toString()
  {
    return String.format("id:%d, p:%s, b:%s, c:[%.2f, %.2f], w:%.2f, h:%.2f, y:%.2f, t:%.2f, s:%d, v:%b", new Object[] { Integer.valueOf(this.id), this.pose, Arrays.toString(this.boundaryPolygon), Double.valueOf(this.centerX), Double.valueOf(this.centerY), Double.valueOf(this.width), Double.valueOf(this.height), Double.valueOf(this.yaw), Double.valueOf(this.timestamp), Integer.valueOf(this.subsumedBy), Boolean.valueOf(this.isValid) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    this.pose.writeToParcel(paramParcel, paramInt);
    paramParcel.writeDoubleArray(this.boundaryPolygon);
    paramParcel.writeDouble(this.centerX);
    paramParcel.writeDouble(this.centerY);
    paramParcel.writeDouble(this.width);
    paramParcel.writeDouble(this.height);
    paramParcel.writeDouble(this.yaw);
    paramParcel.writeDouble(this.timestamp);
    paramParcel.writeInt(this.subsumedBy);
    if (this.isValid) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/experimental/TangoPlaneData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */