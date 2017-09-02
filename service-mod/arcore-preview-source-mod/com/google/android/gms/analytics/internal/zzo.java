package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzo
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<zzo> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public zzo[] zzaA(int paramAnonymousInt)
    {
      return new zzo[paramAnonymousInt];
    }
    
    @Deprecated
    public zzo zzx(Parcel paramAnonymousParcel)
    {
      return new zzo(paramAnonymousParcel);
    }
  };
  private String mValue;
  private String zzGK;
  private String zzaeD;
  
  @Deprecated
  public zzo() {}
  
  @Deprecated
  zzo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.zzGK = paramParcel.readString();
    this.zzaeD = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzGK;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzGK);
    paramParcel.writeString(this.zzaeD);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */