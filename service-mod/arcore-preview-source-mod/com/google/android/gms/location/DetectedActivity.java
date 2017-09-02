package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Comparator;

public class DetectedActivity
  extends zza
{
  public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzh();
  public static final int EXITING_VEHICLE = 6;
  public static final int FLOOR_CHANGE = 11;
  public static final int IN_ELEVATOR = 14;
  public static final int IN_VEHICLE = 0;
  public static final int OFF_BODY = 9;
  public static final int ON_BICYCLE = 1;
  public static final int ON_ESCALATOR = 13;
  public static final int ON_FOOT = 2;
  public static final int ON_STAIRS = 12;
  public static final int RUNNING = 8;
  public static final int SLEEPING = 15;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int TRUSTED_GAIT = 10;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  public static final Comparator<DetectedActivity> zzbDf = new Comparator()
  {
    public int zza(DetectedActivity paramAnonymousDetectedActivity1, DetectedActivity paramAnonymousDetectedActivity2)
    {
      int j = Integer.valueOf(paramAnonymousDetectedActivity2.getConfidence()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity1.getConfidence()));
      int i = j;
      if (j == 0) {
        i = Integer.valueOf(paramAnonymousDetectedActivity1.getType()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity2.getType()));
      }
      return i;
    }
  };
  public static final int[] zzbDg = { 9, 10 };
  public static final int[] zzbDh = { 0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14 };
  int zzbDi;
  int zzbDj;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    this.zzbDi = paramInt1;
    this.zzbDj = paramInt2;
  }
  
  private int zznM(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 15) {
      i = 4;
    }
    return i;
  }
  
  public static String zznN(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "IN_VEHICLE";
    case 1: 
      return "ON_BICYCLE";
    case 2: 
      return "ON_FOOT";
    case 3: 
      return "STILL";
    case 4: 
      return "UNKNOWN";
    case 5: 
      return "TILTING";
    case 7: 
      return "WALKING";
    }
    return "RUNNING";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DetectedActivity)paramObject;
    } while ((this.zzbDi == ((DetectedActivity)paramObject).zzbDi) && (this.zzbDj == ((DetectedActivity)paramObject).zzbDj));
    return false;
  }
  
  public int getConfidence()
  {
    return this.zzbDj;
  }
  
  public int getType()
  {
    return zznM(this.zzbDi);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzbDi), Integer.valueOf(this.zzbDj) });
  }
  
  public String toString()
  {
    String str = String.valueOf(zznN(getType()));
    int i = this.zzbDj;
    return String.valueOf(str).length() + 48 + "DetectedActivity [type=" + str + ", confidence=" + i + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */