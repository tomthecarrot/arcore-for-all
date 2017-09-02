package com.google.common.geometry;

public class S2LatLng
{
  public static final S2LatLng CENTER = new S2LatLng(0.0D, 0.0D);
  public static final double EARTH_RADIUS_METERS = 6367000.0D;
  private final double latRadians;
  private final double lngRadians;
  
  public strictfp S2LatLng()
  {
    this(0.0D, 0.0D);
  }
  
  private strictfp S2LatLng(double paramDouble1, double paramDouble2)
  {
    this.latRadians = paramDouble1;
    this.lngRadians = paramDouble2;
  }
  
  public strictfp S2LatLng(S1Angle paramS1Angle1, S1Angle paramS1Angle2)
  {
    this(paramS1Angle1.radians(), paramS1Angle2.radians());
  }
  
  public strictfp S2LatLng(S2Point paramS2Point)
  {
    this(Math.atan2(paramS2Point.z, Math.sqrt(paramS2Point.x * paramS2Point.x + paramS2Point.y * paramS2Point.y)), Math.atan2(paramS2Point.y, paramS2Point.x));
  }
  
  public static strictfp S2LatLng fromDegrees(double paramDouble1, double paramDouble2)
  {
    return new S2LatLng(S1Angle.degrees(paramDouble1), S1Angle.degrees(paramDouble2));
  }
  
  public static strictfp S2LatLng fromE5(long paramLong1, long paramLong2)
  {
    return new S2LatLng(S1Angle.e5(paramLong1), S1Angle.e5(paramLong2));
  }
  
  public static strictfp S2LatLng fromE6(long paramLong1, long paramLong2)
  {
    return new S2LatLng(S1Angle.e6(paramLong1), S1Angle.e6(paramLong2));
  }
  
  public static strictfp S2LatLng fromE7(long paramLong1, long paramLong2)
  {
    return new S2LatLng(S1Angle.e7(paramLong1), S1Angle.e7(paramLong2));
  }
  
  public static strictfp S2LatLng fromRadians(double paramDouble1, double paramDouble2)
  {
    return new S2LatLng(paramDouble1, paramDouble2);
  }
  
  public static strictfp S1Angle latitude(S2Point paramS2Point)
  {
    return S1Angle.radians(Math.atan2(paramS2Point.get(2), Math.sqrt(paramS2Point.get(0) * paramS2Point.get(0) + paramS2Point.get(1) * paramS2Point.get(1))));
  }
  
  public static strictfp S1Angle longitude(S2Point paramS2Point)
  {
    return S1Angle.radians(Math.atan2(paramS2Point.get(1), paramS2Point.get(0)));
  }
  
  public strictfp S2LatLng add(S2LatLng paramS2LatLng)
  {
    return new S2LatLng(this.latRadians + paramS2LatLng.latRadians, this.lngRadians + paramS2LatLng.lngRadians);
  }
  
  public strictfp boolean approxEquals(S2LatLng paramS2LatLng)
  {
    return approxEquals(paramS2LatLng, 1.0E-9D);
  }
  
  public strictfp boolean approxEquals(S2LatLng paramS2LatLng, double paramDouble)
  {
    return (Math.abs(this.latRadians - paramS2LatLng.latRadians) < paramDouble) && (Math.abs(this.lngRadians - paramS2LatLng.lngRadians) < paramDouble);
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof S2LatLng))
    {
      paramObject = (S2LatLng)paramObject;
      bool1 = bool2;
      if (this.latRadians == ((S2LatLng)paramObject).latRadians)
      {
        bool1 = bool2;
        if (this.lngRadians == ((S2LatLng)paramObject).lngRadians) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public strictfp double getDistance(S2LatLng paramS2LatLng, double paramDouble)
  {
    return getDistance(paramS2LatLng).radians() * paramDouble;
  }
  
  public strictfp S1Angle getDistance(S2LatLng paramS2LatLng)
  {
    double d1 = lat().radians();
    double d2 = paramS2LatLng.lat().radians();
    double d4 = lng().radians();
    double d5 = paramS2LatLng.lng().radians();
    double d3 = Math.sin(0.5D * (d2 - d1));
    d4 = Math.sin(0.5D * (d5 - d4));
    d1 = d3 * d3 + d4 * d4 * Math.cos(d1) * Math.cos(d2);
    return S1Angle.radians(2.0D * Math.atan2(Math.sqrt(d1), Math.sqrt(Math.max(0.0D, 1.0D - d1))));
  }
  
  public strictfp double getEarthDistance(S2LatLng paramS2LatLng)
  {
    return getDistance(paramS2LatLng, 6367000.0D);
  }
  
  public strictfp int hashCode()
  {
    long l = 17L + (37L * 17L + Double.doubleToLongBits(this.latRadians));
    l += 37L * l + Double.doubleToLongBits(this.lngRadians);
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp boolean isValid()
  {
    return (Math.abs(lat().radians()) <= 1.5707963267948966D) && (Math.abs(lng().radians()) <= 3.141592653589793D);
  }
  
  public strictfp S1Angle lat()
  {
    return S1Angle.radians(this.latRadians);
  }
  
  public strictfp double latDegrees()
  {
    return 57.29577951308232D * this.latRadians;
  }
  
  public strictfp double latRadians()
  {
    return this.latRadians;
  }
  
  public strictfp S1Angle lng()
  {
    return S1Angle.radians(this.lngRadians);
  }
  
  public strictfp double lngDegrees()
  {
    return 57.29577951308232D * this.lngRadians;
  }
  
  public strictfp double lngRadians()
  {
    return this.lngRadians;
  }
  
  public strictfp S2LatLng mul(double paramDouble)
  {
    return new S2LatLng(this.latRadians * paramDouble, this.lngRadians * paramDouble);
  }
  
  public strictfp S2LatLng normalized()
  {
    return new S2LatLng(Math.max(-1.5707963267948966D, Math.min(1.5707963267948966D, lat().radians())), Math.IEEEremainder(lng().radians(), 6.283185307179586D));
  }
  
  public strictfp S2LatLng sub(S2LatLng paramS2LatLng)
  {
    return new S2LatLng(this.latRadians - paramS2LatLng.latRadians, this.lngRadians - paramS2LatLng.lngRadians);
  }
  
  public strictfp S2Point toPoint()
  {
    double d1 = lat().radians();
    double d2 = lng().radians();
    double d3 = Math.cos(d1);
    return new S2Point(Math.cos(d2) * d3, Math.sin(d2) * d3, Math.sin(d1));
  }
  
  public strictfp String toString()
  {
    return "(" + this.latRadians + ", " + this.lngRadians + ")";
  }
  
  public strictfp String toStringDegrees()
  {
    return "(" + latDegrees() + ", " + lngDegrees() + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */