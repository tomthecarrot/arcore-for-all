package com.google.atap.tangoservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class TangoTransformation
  implements Parcelable
{
  public static final Parcelable.Creator<TangoTransformation> CREATOR = new Parcelable.Creator()
  {
    public TangoTransformation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TangoTransformation(paramAnonymousParcel, null);
    }
    
    public TangoTransformation[] newArray(int paramAnonymousInt)
    {
      return new TangoTransformation[paramAnonymousInt];
    }
  };
  public static final int INDEX_ROTATION_W = 3;
  public static final int INDEX_ROTATION_X = 0;
  public static final int INDEX_ROTATION_Y = 1;
  public static final int INDEX_ROTATION_Z = 2;
  public static final int INDEX_TRANSLATION_X = 0;
  public static final int INDEX_TRANSLATION_Y = 1;
  public static final int INDEX_TRANSLATION_Z = 2;
  public final double[] rotation = { 0.0D, 0.0D, 0.0D, 1.0D };
  public final double[] translation = { 0.0D, 0.0D, 0.0D };
  
  public TangoTransformation() {}
  
  private TangoTransformation(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != TangoTransformation.class)) {}
    do
    {
      return false;
      paramObject = (TangoTransformation)paramObject;
    } while ((!Arrays.equals(this.rotation, ((TangoTransformation)paramObject).rotation)) || (!Arrays.equals(this.translation, ((TangoTransformation)paramObject).translation)));
    return true;
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
    paramParcel.readDoubleArray(this.rotation);
    paramParcel.readDoubleArray(this.translation);
  }
  
  public String toString()
  {
    return String.format("p: [%.3f, %.3f, %.3f], q: [%.4f, %.4f, %.4f, %.4f]\n", new Object[] { Double.valueOf(this.translation[0]), Double.valueOf(this.translation[1]), Double.valueOf(this.translation[2]), Double.valueOf(this.rotation[0]), Double.valueOf(this.rotation[1]), Double.valueOf(this.rotation[2]), Double.valueOf(this.rotation[3]) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDoubleArray(this.rotation);
    paramParcel.writeDoubleArray(this.translation);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/TangoTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */