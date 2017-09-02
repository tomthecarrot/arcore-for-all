package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public final class LocationRequest
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationRequest> CREATOR = new zzp();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  int mPriority;
  long zzbDR;
  long zzbDS;
  int zzbDT;
  float zzbDU;
  long zzbDV;
  long zzbDr;
  boolean zzbmG;
  
  public LocationRequest()
  {
    this.mPriority = 102;
    this.zzbDR = 3600000L;
    this.zzbDS = 600000L;
    this.zzbmG = false;
    this.zzbDr = Long.MAX_VALUE;
    this.zzbDT = Integer.MAX_VALUE;
    this.zzbDU = 0.0F;
    this.zzbDV = 0L;
  }
  
  LocationRequest(int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt2, float paramFloat, long paramLong4)
  {
    this.mPriority = paramInt1;
    this.zzbDR = paramLong1;
    this.zzbDS = paramLong2;
    this.zzbmG = paramBoolean;
    this.zzbDr = paramLong3;
    this.zzbDT = paramInt2;
    this.zzbDU = paramFloat;
    this.zzbDV = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void zzae(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(38 + "invalid interval: " + paramLong);
    }
  }
  
  private static void zzd(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException(37 + "invalid displacement: " + paramFloat);
    }
  }
  
  private static void zznV(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException(28 + "invalid quality: " + paramInt);
    }
  }
  
  public static String zznW(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      return "???";
    case 100: 
      return "PRIORITY_HIGH_ACCURACY";
    case 102: 
      return "PRIORITY_BALANCED_POWER_ACCURACY";
    case 104: 
      return "PRIORITY_LOW_POWER";
    }
    return "PRIORITY_NO_POWER";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((this.mPriority == ((LocationRequest)paramObject).mPriority) && (this.zzbDR == ((LocationRequest)paramObject).zzbDR) && (this.zzbDS == ((LocationRequest)paramObject).zzbDS) && (this.zzbmG == ((LocationRequest)paramObject).zzbmG) && (this.zzbDr == ((LocationRequest)paramObject).zzbDr) && (this.zzbDT == ((LocationRequest)paramObject).zzbDT) && (this.zzbDU == ((LocationRequest)paramObject).zzbDU) && (getMaxWaitTime() == ((LocationRequest)paramObject).getMaxWaitTime()));
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzbDr;
  }
  
  public long getFastestInterval()
  {
    return this.zzbDS;
  }
  
  public long getInterval()
  {
    return this.zzbDR;
  }
  
  public long getMaxWaitTime()
  {
    long l2 = this.zzbDV;
    long l1 = l2;
    if (l2 < this.zzbDR) {
      l1 = this.zzbDR;
    }
    return l1;
  }
  
  public int getNumUpdates()
  {
    return this.zzbDT;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.zzbDU;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.mPriority), Long.valueOf(this.zzbDR), Float.valueOf(this.zzbDU), Long.valueOf(this.zzbDV) });
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > Long.MAX_VALUE - l) {}
    for (this.zzbDr = Long.MAX_VALUE;; this.zzbDr = (l + paramLong))
    {
      if (this.zzbDr < 0L) {
        this.zzbDr = 0L;
      }
      return this;
    }
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.zzbDr = paramLong;
    if (this.zzbDr < 0L) {
      this.zzbDr = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    zzae(paramLong);
    this.zzbmG = true;
    this.zzbDS = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    zzae(paramLong);
    this.zzbDR = paramLong;
    if (!this.zzbmG) {
      this.zzbDS = ((this.zzbDR / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setMaxWaitTime(long paramLong)
  {
    zzae(paramLong);
    this.zzbDV = paramLong;
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException(31 + "invalid numUpdates: " + paramInt);
    }
    this.zzbDT = paramInt;
    return this;
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    zznV(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    zzd(paramFloat);
    this.zzbDU = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(zznW(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.zzbDR).append("ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.zzbDS).append("ms");
    if (this.zzbDV > this.zzbDR)
    {
      localStringBuilder.append(" maxWait=");
      localStringBuilder.append(this.zzbDV).append("ms");
    }
    if (this.zzbDU > 0.0F)
    {
      localStringBuilder.append(" smallestDisplacement=");
      localStringBuilder.append(this.zzbDU).append("m");
    }
    if (this.zzbDr != Long.MAX_VALUE)
    {
      long l1 = this.zzbDr;
      long l2 = SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l1 - l2).append("ms");
    }
    if (this.zzbDT != Integer.MAX_VALUE) {
      localStringBuilder.append(" num=").append(this.zzbDT);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */