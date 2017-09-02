package com.google.atap.tangoservice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.Set;

public class TangoAreaDescriptionMetaData
  implements Parcelable
{
  public static final Parcelable.Creator<TangoAreaDescriptionMetaData> CREATOR = new Parcelable.Creator()
  {
    public TangoAreaDescriptionMetaData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoAreaDescriptionMetaData(paramAnonymousParcel, null);
    }
    
    public TangoAreaDescriptionMetaData[] newArray(int paramAnonymousInt)
    {
      return new TangoAreaDescriptionMetaData[paramAnonymousInt];
    }
  };
  public static final String KEY_DATE_MS_SINCE_EPOCH = "date_ms_since_epoch";
  public static final String KEY_NAME = "name";
  public static final String KEY_TRANSFORMATION = "transformation";
  public static final String KEY_UUID = "id";
  private Bundle data = new Bundle();
  
  public TangoAreaDescriptionMetaData() {}
  
  private TangoAreaDescriptionMetaData(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] get(String paramString)
  {
    return this.data.getByteArray(paramString);
  }
  
  public Set<String> keySet()
  {
    return this.data.keySet();
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      byte[] arrayOfByte = paramParcel.createByteArray();
      if ((str != null) && (arrayOfByte != null)) {
        this.data.putByteArray(str, arrayOfByte);
      }
      i += 1;
    }
  }
  
  public void set(String paramString, byte[] paramArrayOfByte)
  {
    this.data.putByteArray(paramString, paramArrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.data.keySet();
    paramParcel.writeInt(((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramParcel.writeString(str);
      paramParcel.writeByteArray(this.data.getByteArray(str));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoAreaDescriptionMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */