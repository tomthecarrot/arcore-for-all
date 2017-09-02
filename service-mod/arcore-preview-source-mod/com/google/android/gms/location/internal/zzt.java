package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class zzt
  extends zza
  implements Geofence
{
  public static final Parcelable.Creator<zzt> CREATOR = new zzu();
  private final String zzOI;
  private final int zzbDq;
  private final short zzbDs;
  private final double zzbDt;
  private final double zzbDu;
  private final float zzbDv;
  private final int zzbDw;
  private final int zzbDx;
  private final long zzbEZ;
  
  public zzt(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    zzeU(paramString);
    zze(paramFloat);
    zze(paramDouble1, paramDouble2);
    paramInt1 = zzop(paramInt1);
    this.zzbDs = paramShort;
    this.zzOI = paramString;
    this.zzbDt = paramDouble1;
    this.zzbDu = paramDouble2;
    this.zzbDv = paramFloat;
    this.zzbEZ = paramLong;
    this.zzbDq = paramInt1;
    this.zzbDw = paramInt2;
    this.zzbDx = paramInt3;
  }
  
  public static zzt zzG(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (zzt)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  private static void zze(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException(42 + "invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException(43 + "invalid longitude: " + paramDouble2);
    }
  }
  
  private static void zze(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException(31 + "invalid radius: " + paramFloat);
    }
  }
  
  private static void zzeU(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "requestId is null or too long: ".concat(paramString);; paramString = new String("requestId is null or too long: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  private static int zzop(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException(46 + "No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String zzoq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof zzt)) {
        return false;
      }
      paramObject = (zzt)paramObject;
      if (this.zzbDv != ((zzt)paramObject).zzbDv) {
        return false;
      }
      if (this.zzbDt != ((zzt)paramObject).zzbDt) {
        return false;
      }
      if (this.zzbDu != ((zzt)paramObject).zzbDu) {
        return false;
      }
    } while (this.zzbDs == ((zzt)paramObject).zzbDs);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzbEZ;
  }
  
  public double getLatitude()
  {
    return this.zzbDt;
  }
  
  public double getLongitude()
  {
    return this.zzbDu;
  }
  
  public float getRadius()
  {
    return this.zzbDv;
  }
  
  public String getRequestId()
  {
    return this.zzOI;
  }
  
  public int getTransitionTypes()
  {
    return this.zzbDq;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.zzbDt);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.zzbDu);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.zzbDv)) * 31 + this.zzbDs) * 31 + this.zzbDq;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zzoq(this.zzbDs), this.zzOI, Integer.valueOf(this.zzbDq), Double.valueOf(this.zzbDt), Double.valueOf(this.zzbDu), Float.valueOf(this.zzbDv), Integer.valueOf(this.zzbDw / 1000), Integer.valueOf(this.zzbDx), Long.valueOf(this.zzbEZ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
  
  public short zzKv()
  {
    return this.zzbDs;
  }
  
  public int zzKw()
  {
    return this.zzbDw;
  }
  
  public int zzKx()
  {
    return this.zzbDx;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */