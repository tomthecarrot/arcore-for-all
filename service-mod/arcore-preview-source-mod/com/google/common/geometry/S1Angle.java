package com.google.common.geometry;

public final class S1Angle
  implements Comparable<S1Angle>
{
  private final double radians;
  
  public strictfp S1Angle()
  {
    this.radians = 0.0D;
  }
  
  private strictfp S1Angle(double paramDouble)
  {
    this.radians = paramDouble;
  }
  
  public strictfp S1Angle(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    this.radians = paramS2Point1.angle(paramS2Point2);
  }
  
  public static strictfp S1Angle degrees(double paramDouble)
  {
    return new S1Angle(0.017453292519943295D * paramDouble);
  }
  
  public static strictfp S1Angle e5(long paramLong)
  {
    return degrees(paramLong * 1.0E-5D);
  }
  
  public static strictfp S1Angle e6(long paramLong)
  {
    return degrees(paramLong * 1.0E-6D);
  }
  
  public static strictfp S1Angle e7(long paramLong)
  {
    return degrees(paramLong * 1.0E-7D);
  }
  
  public static strictfp S1Angle max(S1Angle paramS1Angle1, S1Angle paramS1Angle2)
  {
    if (paramS1Angle2.greaterThan(paramS1Angle1)) {
      return paramS1Angle2;
    }
    return paramS1Angle1;
  }
  
  public static strictfp S1Angle min(S1Angle paramS1Angle1, S1Angle paramS1Angle2)
  {
    if (paramS1Angle2.greaterThan(paramS1Angle1)) {
      return paramS1Angle1;
    }
    return paramS1Angle2;
  }
  
  public static strictfp S1Angle radians(double paramDouble)
  {
    return new S1Angle(paramDouble);
  }
  
  public strictfp int compareTo(S1Angle paramS1Angle)
  {
    if (this.radians < paramS1Angle.radians) {
      return -1;
    }
    if (this.radians > paramS1Angle.radians) {
      return 1;
    }
    return 0;
  }
  
  public strictfp double degrees()
  {
    return this.radians * 57.29577951308232D;
  }
  
  public strictfp long e5()
  {
    return Math.round(degrees() * 100000.0D);
  }
  
  public strictfp long e6()
  {
    return Math.round(degrees() * 1000000.0D);
  }
  
  public strictfp long e7()
  {
    return Math.round(degrees() * 1.0E7D);
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof S1Angle))
    {
      bool1 = bool2;
      if (radians() == ((S1Angle)paramObject).radians()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public strictfp boolean greaterOrEquals(S1Angle paramS1Angle)
  {
    return radians() >= paramS1Angle.radians();
  }
  
  public strictfp boolean greaterThan(S1Angle paramS1Angle)
  {
    return radians() > paramS1Angle.radians();
  }
  
  public strictfp int hashCode()
  {
    long l = Double.doubleToLongBits(this.radians);
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp boolean lessOrEquals(S1Angle paramS1Angle)
  {
    return radians() <= paramS1Angle.radians();
  }
  
  public strictfp boolean lessThan(S1Angle paramS1Angle)
  {
    return radians() < paramS1Angle.radians();
  }
  
  public strictfp double radians()
  {
    return this.radians;
  }
  
  public strictfp String toString()
  {
    return degrees() + "d";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S1Angle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */