package com.google.android.gms.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class WifiScan
  extends zza
{
  public static final Parcelable.Creator<WifiScan> CREATOR = new zzy();
  static final long[] zzbEn = new long[0];
  private final long zzbEo;
  final long[] zzbEp;
  
  WifiScan(long paramLong, long[] paramArrayOfLong)
  {
    this.zzbEo = paramLong;
    if (paramArrayOfLong != null) {}
    for (;;)
    {
      this.zzbEp = paramArrayOfLong;
      return;
      paramArrayOfLong = zzbEn;
    }
  }
  
  @Nullable
  public static WifiScan fromLocation(Location paramLocation)
  {
    paramLocation = paramLocation.getExtras();
    if (paramLocation != null)
    {
      paramLocation = paramLocation.getByteArray("wifiScan");
      if (paramLocation != null) {
        return zzF(paramLocation);
      }
    }
    return null;
  }
  
  public static WifiScan zzF(byte[] paramArrayOfByte)
  {
    return (WifiScan)zzd.zza(paramArrayOfByte, CREATOR);
  }
  
  private void zzoh(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getNumDevices()))
    {
      int i = getNumDevices();
      throw new IndexOutOfBoundsException(49 + "Index " + paramInt + " out of bounds: [0, " + i + ")");
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WifiScan)) {}
    do
    {
      return false;
      paramObject = (WifiScan)paramObject;
    } while ((((WifiScan)paramObject).zzbEo != this.zzbEo) || (!Arrays.equals(((WifiScan)paramObject).zzbEp, this.zzbEp)));
    return true;
  }
  
  public long getElapsedRealtimeMs()
  {
    return this.zzbEo;
  }
  
  public long getMac(int paramInt)
  {
    zzoh(paramInt);
    return this.zzbEp[paramInt] & 0xFFFFFFFFFFFF;
  }
  
  public int getNumDevices()
  {
    return this.zzbEp.length;
  }
  
  public byte getPowerLevelDbm(int paramInt)
  {
    zzoh(paramInt);
    return (byte)(int)((this.zzbEp[paramInt] & 0xFF000000000000) >>> 48);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.zzbEp);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WifiScan[elapsed rt: ");
    localStringBuilder.append(this.zzbEo);
    int j = getNumDevices();
    int i = 0;
    if (i < j)
    {
      localStringBuilder.append(", Device[mac: ").append(getMac(i));
      localStringBuilder.append(", power [dbm]: ").append(getPowerLevelDbm(i));
      if (i < j - 1) {
        localStringBuilder.append("], ");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("]");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private static final AtomicReference<Builder> zzbEq = new AtomicReference();
    private long zzaUx;
    private long[] zzbEr;
    private int zzbEs;
    
    private Builder(int paramInt, long paramLong)
    {
      zzd(paramInt, paramLong);
    }
    
    public static Builder create(int paramInt, long paramLong)
    {
      Builder localBuilder = (Builder)zzbEq.getAndSet(null);
      if (localBuilder != null)
      {
        localBuilder.zzd(paramInt, paramLong);
        return localBuilder;
      }
      return new Builder(paramInt, paramLong);
    }
    
    private void zzd(int paramInt, long paramLong)
    {
      this.zzaUx = paramLong;
      this.zzbEr = new long[paramInt];
      this.zzbEs = 0;
    }
    
    public Builder addDevice(long paramLong, byte paramByte)
    {
      if (this.zzbEs >= this.zzbEr.length) {
        throw new IllegalStateException("Builder is full, have already added devices to capacity");
      }
      this.zzbEr[this.zzbEs] = (paramByte << 48 | paramLong);
      this.zzbEs += 1;
      return this;
    }
    
    public WifiScan build()
    {
      if (this.zzbEs != this.zzbEr.length)
      {
        int i = this.zzbEr.length;
        int j = this.zzbEs;
        throw new IllegalStateException(73 + "Haven't filled devices yet, expected " + i + " but received " + j);
      }
      WifiScan localWifiScan = new WifiScan(this.zzaUx, this.zzbEr);
      this.zzbEr = null;
      zzbEq.set(this);
      return localWifiScan;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/WifiScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */