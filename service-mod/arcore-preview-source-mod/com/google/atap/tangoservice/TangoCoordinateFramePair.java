package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TangoCoordinateFramePair
  implements Parcelable
{
  public static final Parcelable.Creator<TangoCoordinateFramePair> CREATOR = new Parcelable.Creator()
  {
    public TangoCoordinateFramePair createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoCoordinateFramePair(paramAnonymousParcel, null);
    }
    
    public TangoCoordinateFramePair[] newArray(int paramAnonymousInt)
    {
      return new TangoCoordinateFramePair[paramAnonymousInt];
    }
  };
  public int baseFrame = 0;
  public int targetFrame = 0;
  
  public TangoCoordinateFramePair() {}
  
  public TangoCoordinateFramePair(int paramInt1, int paramInt2)
  {
    this.baseFrame = paramInt1;
    this.targetFrame = paramInt2;
  }
  
  private TangoCoordinateFramePair(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.baseFrame = paramParcel.readInt();
    this.targetFrame = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.baseFrame);
    paramParcel.writeInt(this.targetFrame);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoCoordinateFramePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */