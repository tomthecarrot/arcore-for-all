package com.google.atap.tangoservice;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class TangoXyzIjData
  implements Parcelable
{
  public static final Parcelable.Creator<TangoXyzIjData> CREATOR = new Parcelable.Creator()
  {
    public TangoXyzIjData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoXyzIjData(paramAnonymousParcel, null);
    }
    
    public TangoXyzIjData[] newArray(int paramAnonymousInt)
    {
      return new TangoXyzIjData[paramAnonymousInt];
    }
  };
  public int ijCols;
  public ParcelFileDescriptor ijParcelFileDescriptor;
  public int ijRows;
  public double timestamp;
  public FloatBuffer xyz;
  public int xyzCount;
  @Deprecated
  public ParcelFileDescriptor xyzParcelFileDescriptor;
  @Deprecated
  public int xyzParcelFileDescriptorFlags;
  @Deprecated
  public int xyzParcelFileDescriptorOffset;
  @Deprecated
  public int xyzParcelFileDescriptorSize;
  
  public TangoXyzIjData() {}
  
  private TangoXyzIjData(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public FloatBuffer getXyzBuffer()
  {
    return this.xyz;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.timestamp = paramParcel.readDouble();
    this.xyzCount = paramParcel.readInt();
    Object localObject = paramParcel.readStrongBinder();
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(((IBinder)localObject).getInterfaceDescriptor());
      ((IBinder)localObject).transact(1, localParcel1, localParcel2, 0);
      this.xyzParcelFileDescriptor = localParcel2.readFileDescriptor();
      this.xyzParcelFileDescriptorSize = localParcel2.readInt();
      this.xyzParcelFileDescriptorFlags = localParcel2.readInt();
      this.xyzParcelFileDescriptorOffset = localParcel2.readInt();
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        localObject = new FileInputStream(this.xyzParcelFileDescriptor.getFileDescriptor());
        MappedByteBuffer localMappedByteBuffer = ((FileInputStream)localObject).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, this.xyzCount * 3 * 4);
        localMappedByteBuffer.order(ByteOrder.nativeOrder());
        ((FileInputStream)localObject).close();
        this.xyz = localMappedByteBuffer.asFloatBuffer();
        localParcel1.recycle();
        localParcel2.recycle();
        this.ijRows = paramParcel.readInt();
        this.ijCols = paramParcel.readInt();
        return;
        localRemoteException = localRemoteException;
        localRemoteException.printStackTrace();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoXyzIjData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */