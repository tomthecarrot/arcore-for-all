package com.google.common.geometry;

public class S2Point
  implements Comparable<S2Point>
{
  final double x;
  final double y;
  final double z;
  
  public strictfp S2Point()
  {
    this.z = 0.0D;
    this.y = 0.0D;
    this.x = 0.0D;
  }
  
  public strictfp S2Point(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.z = paramDouble3;
  }
  
  public static strictfp S2Point add(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    return new S2Point(paramS2Point1.x + paramS2Point2.x, paramS2Point1.y + paramS2Point2.y, paramS2Point1.z + paramS2Point2.z);
  }
  
  public static strictfp S2Point crossProd(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    return new S2Point(paramS2Point1.y * paramS2Point2.z - paramS2Point1.z * paramS2Point2.y, paramS2Point1.z * paramS2Point2.x - paramS2Point1.x * paramS2Point2.z, paramS2Point1.x * paramS2Point2.y - paramS2Point1.y * paramS2Point2.x);
  }
  
  public static strictfp S2Point div(S2Point paramS2Point, double paramDouble)
  {
    return new S2Point(paramS2Point.x / paramDouble, paramS2Point.y / paramDouble, paramS2Point.z / paramDouble);
  }
  
  public static strictfp S2Point fabs(S2Point paramS2Point)
  {
    return new S2Point(Math.abs(paramS2Point.x), Math.abs(paramS2Point.y), Math.abs(paramS2Point.z));
  }
  
  public static strictfp S2Point minus(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    return sub(paramS2Point1, paramS2Point2);
  }
  
  public static strictfp S2Point mul(S2Point paramS2Point, double paramDouble)
  {
    return new S2Point(paramS2Point.x * paramDouble, paramS2Point.y * paramDouble, paramS2Point.z * paramDouble);
  }
  
  public static strictfp S2Point neg(S2Point paramS2Point)
  {
    return new S2Point(-paramS2Point.x, -paramS2Point.y, -paramS2Point.z);
  }
  
  public static strictfp S2Point normalize(S2Point paramS2Point)
  {
    double d2 = paramS2Point.norm();
    double d1 = d2;
    if (d2 != 0.0D) {
      d1 = 1.0D / d2;
    }
    return mul(paramS2Point, d1);
  }
  
  public static strictfp S2Point sub(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    return new S2Point(paramS2Point1.x - paramS2Point2.x, paramS2Point1.y - paramS2Point2.y, paramS2Point1.z - paramS2Point2.z);
  }
  
  strictfp boolean aequal(S2Point paramS2Point, double paramDouble)
  {
    return (Math.abs(this.x - paramS2Point.x) < paramDouble) && (Math.abs(this.y - paramS2Point.y) < paramDouble) && (Math.abs(this.z - paramS2Point.z) < paramDouble);
  }
  
  public strictfp double angle(S2Point paramS2Point)
  {
    return Math.atan2(crossProd(this, paramS2Point).norm(), dotProd(paramS2Point));
  }
  
  public strictfp int compareTo(S2Point paramS2Point)
  {
    if (lessThan(paramS2Point)) {
      return -1;
    }
    if (equals(paramS2Point)) {
      return 0;
    }
    return 1;
  }
  
  public strictfp double dotProd(S2Point paramS2Point)
  {
    return this.x * paramS2Point.x + this.y * paramS2Point.y + this.z * paramS2Point.z;
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2Point)) {}
    do
    {
      return false;
      paramObject = (S2Point)paramObject;
    } while ((this.x != ((S2Point)paramObject).x) || (this.y != ((S2Point)paramObject).y) || (this.z != ((S2Point)paramObject).z));
    return true;
  }
  
  public strictfp double get(int paramInt)
  {
    if (paramInt == 0) {
      return this.x;
    }
    if (paramInt == 1) {
      return this.y;
    }
    return this.z;
  }
  
  public strictfp int hashCode()
  {
    long l = 17L + (37L * 17L + Double.doubleToLongBits(Math.abs(this.x)));
    l += 37L * l + Double.doubleToLongBits(Math.abs(this.y));
    l += 37L * l + Double.doubleToLongBits(Math.abs(this.z));
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp int largestAbsComponent()
  {
    int i = 2;
    S2Point localS2Point = fabs(this);
    if (localS2Point.x > localS2Point.y) {
      if (localS2Point.x > localS2Point.z) {
        i = 0;
      }
    }
    while (localS2Point.y <= localS2Point.z) {
      return i;
    }
    return 1;
  }
  
  public strictfp boolean lessThan(S2Point paramS2Point)
  {
    if (this.x < paramS2Point.x) {}
    do
    {
      do
      {
        return true;
        if (paramS2Point.x < this.x) {
          return false;
        }
      } while (this.y < paramS2Point.y);
      if (paramS2Point.y < this.y) {
        return false;
      }
    } while (this.z < paramS2Point.z);
    return false;
  }
  
  public strictfp double norm()
  {
    return Math.sqrt(norm2());
  }
  
  public strictfp double norm2()
  {
    return this.x * this.x + this.y * this.y + this.z * this.z;
  }
  
  public strictfp S2Point ortho()
  {
    int i = largestAbsComponent();
    S2Point localS2Point;
    if (i == 1) {
      localS2Point = new S2Point(1.0D, 0.0D, 0.0D);
    }
    for (;;)
    {
      return normalize(crossProd(this, localS2Point));
      if (i == 2) {
        localS2Point = new S2Point(0.0D, 1.0D, 0.0D);
      } else {
        localS2Point = new S2Point(0.0D, 0.0D, 1.0D);
      }
    }
  }
  
  public strictfp String toDegreesString()
  {
    S2LatLng localS2LatLng = new S2LatLng(this);
    return "(" + Double.toString(localS2LatLng.latDegrees()) + ", " + Double.toString(localS2LatLng.lngDegrees()) + ")";
  }
  
  public strictfp String toString()
  {
    return "(" + this.x + ", " + this.y + ", " + this.z + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */