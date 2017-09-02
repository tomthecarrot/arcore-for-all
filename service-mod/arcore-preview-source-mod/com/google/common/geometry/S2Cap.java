package com.google.common.geometry;

public final class S2Cap
  implements S2Region
{
  private static final double ROUND_UP = 1.0000000000000002D;
  private final S2Point axis;
  private final double height;
  
  private strictfp S2Cap()
  {
    this.axis = new S2Point();
    this.height = 0.0D;
  }
  
  private strictfp S2Cap(S2Point paramS2Point, double paramDouble)
  {
    this.axis = paramS2Point;
    this.height = paramDouble;
  }
  
  public static strictfp S2Cap empty()
  {
    return new S2Cap(new S2Point(1.0D, 0.0D, 0.0D), -1.0D);
  }
  
  public static strictfp S2Cap fromAxisAngle(S2Point paramS2Point, S1Angle paramS1Angle)
  {
    double d = Math.sin(0.5D * paramS1Angle.radians());
    return new S2Cap(paramS2Point, 2.0D * d * d);
  }
  
  public static strictfp S2Cap fromAxisArea(S2Point paramS2Point, double paramDouble)
  {
    return new S2Cap(paramS2Point, paramDouble / 6.283185307179586D);
  }
  
  public static strictfp S2Cap fromAxisHeight(S2Point paramS2Point, double paramDouble)
  {
    return new S2Cap(paramS2Point, paramDouble);
  }
  
  public static strictfp S2Cap full()
  {
    return new S2Cap(new S2Point(1.0D, 0.0D, 0.0D), 2.0D);
  }
  
  public strictfp S2Cap addCap(S2Cap paramS2Cap)
  {
    if (isEmpty()) {
      return new S2Cap(paramS2Cap.axis, paramS2Cap.height);
    }
    double d = this.axis.angle(paramS2Cap.axis) + paramS2Cap.angle().radians();
    if (d >= 3.141592653589793D) {
      return new S2Cap(this.axis, 2.0D);
    }
    d = Math.sin(0.5D * d);
    d = Math.max(this.height, 2.0000000000000004D * d * d);
    return new S2Cap(this.axis, d);
  }
  
  public strictfp S2Cap addPoint(S2Point paramS2Point)
  {
    if (isEmpty()) {
      return new S2Cap(paramS2Point, 0.0D);
    }
    double d = S2Point.sub(this.axis, paramS2Point).norm2();
    d = Math.max(this.height, 0.5000000000000001D * d);
    return new S2Cap(this.axis, d);
  }
  
  public strictfp S1Angle angle()
  {
    if (isEmpty()) {
      return S1Angle.radians(-1.0D);
    }
    return S1Angle.radians(2.0D * Math.asin(Math.sqrt(0.5D * this.height)));
  }
  
  strictfp boolean approxEquals(S2Cap paramS2Cap)
  {
    return approxEquals(paramS2Cap, 1.0E-14D);
  }
  
  strictfp boolean approxEquals(S2Cap paramS2Cap, double paramDouble)
  {
    return ((this.axis.aequal(paramS2Cap.axis, paramDouble)) && (Math.abs(this.height - paramS2Cap.height) <= paramDouble)) || ((isEmpty()) && (paramS2Cap.height <= paramDouble)) || ((paramS2Cap.isEmpty()) && (this.height <= paramDouble)) || ((isFull()) && (paramS2Cap.height >= 2.0D - paramDouble)) || ((paramS2Cap.isFull()) && (this.height >= 2.0D - paramDouble));
  }
  
  public strictfp double area()
  {
    return 6.283185307179586D * Math.max(0.0D, this.height);
  }
  
  public strictfp S2Point axis()
  {
    return this.axis;
  }
  
  public strictfp S2Cap complement()
  {
    if (isFull()) {}
    for (double d = -1.0D;; d = 2.0D - Math.max(this.height, 0.0D)) {
      return fromAxisHeight(S2Point.neg(this.axis), d);
    }
  }
  
  public strictfp boolean contains(S2Cap paramS2Cap)
  {
    if ((isFull()) || (paramS2Cap.isEmpty())) {}
    while (angle().radians() >= this.axis.angle(paramS2Cap.axis) + paramS2Cap.angle().radians()) {
      return true;
    }
    return false;
  }
  
  public strictfp boolean contains(S2Cell paramS2Cell)
  {
    S2Point[] arrayOfS2Point = new S2Point[4];
    int i = 0;
    if (i < 4)
    {
      arrayOfS2Point[i] = paramS2Cell.getVertex(i);
      if (contains(arrayOfS2Point[i])) {}
    }
    while (complement().intersects(paramS2Cell, arrayOfS2Point))
    {
      return false;
      i += 1;
      break;
    }
    return true;
  }
  
  public strictfp boolean contains(S2Point paramS2Point)
  {
    return S2Point.sub(this.axis, paramS2Point).norm2() <= 2.0D * this.height;
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2Cap)) {}
    do
    {
      return false;
      paramObject = (S2Cap)paramObject;
    } while (((!this.axis.equals(((S2Cap)paramObject).axis)) || (this.height != ((S2Cap)paramObject).height)) && ((!isEmpty()) || (!((S2Cap)paramObject).isEmpty())) && ((!isFull()) || (!((S2Cap)paramObject).isFull())));
    return true;
  }
  
  public strictfp S2Cap getCapBound()
  {
    return this;
  }
  
  public strictfp S2LatLngRect getRectBound()
  {
    if (isEmpty()) {
      return S2LatLngRect.empty();
    }
    S2LatLng localS2LatLng = new S2LatLng(this.axis);
    double d1 = angle().radians();
    int i = 0;
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    arrayOfDouble2[0] = -3.141592653589793D;
    arrayOfDouble2[1] = 3.141592653589793D;
    arrayOfDouble1[0] = (localS2LatLng.lat().radians() - d1);
    if (arrayOfDouble1[0] <= -1.5707963267948966D)
    {
      arrayOfDouble1[0] = -1.5707963267948966D;
      i = 1;
    }
    arrayOfDouble1[1] = (localS2LatLng.lat().radians() + d1);
    if (arrayOfDouble1[1] >= 1.5707963267948966D)
    {
      arrayOfDouble1[1] = 1.5707963267948966D;
      i = 1;
    }
    if (i == 0)
    {
      d1 = Math.sqrt(this.height * (2.0D - this.height));
      double d2 = Math.cos(localS2LatLng.lat().radians());
      if (d1 <= d2)
      {
        d1 = Math.asin(d1 / d2);
        arrayOfDouble2[0] = Math.IEEEremainder(localS2LatLng.lng().radians() - d1, 6.283185307179586D);
        arrayOfDouble2[1] = Math.IEEEremainder(localS2LatLng.lng().radians() + d1, 6.283185307179586D);
      }
    }
    return new S2LatLngRect(new R1Interval(arrayOfDouble1[0], arrayOfDouble1[1]), new S1Interval(arrayOfDouble2[0], arrayOfDouble2[1]));
  }
  
  public strictfp int hashCode()
  {
    if (isFull()) {
      return 17;
    }
    if (isEmpty()) {
      return 37;
    }
    int i = this.axis.hashCode();
    long l = Double.doubleToLongBits(this.height);
    return (i + 629) * 37 + (int)(l >>> 32 ^ l);
  }
  
  public strictfp double height()
  {
    return this.height;
  }
  
  public strictfp boolean interiorContains(S2Point paramS2Point)
  {
    return (isFull()) || (S2Point.sub(this.axis, paramS2Point).norm2() < 2.0D * this.height);
  }
  
  public strictfp boolean interiorIntersects(S2Cap paramS2Cap)
  {
    return !complement().contains(paramS2Cap);
  }
  
  public strictfp boolean intersects(S2Cell paramS2Cell, S2Point[] paramArrayOfS2Point)
  {
    if (this.height >= 1.0D) {
      return false;
    }
    if (isEmpty()) {
      return false;
    }
    if (paramS2Cell.contains(this.axis)) {
      return true;
    }
    double d1 = this.height;
    double d2 = this.height;
    int i = 0;
    if (i < 4)
    {
      S2Point localS2Point = paramS2Cell.getEdgeRaw(i);
      double d3 = this.axis.dotProd(localS2Point);
      if (d3 > 0.0D) {}
      do
      {
        i += 1;
        break;
        if (d3 * d3 > localS2Point.norm2() * (d1 * (2.0D - d2))) {
          return false;
        }
        localS2Point = S2Point.crossProd(localS2Point, this.axis);
      } while ((localS2Point.dotProd(paramArrayOfS2Point[i]) >= 0.0D) || (localS2Point.dotProd(paramArrayOfS2Point[(i + 1 & 0x3)]) <= 0.0D));
      return true;
    }
    return false;
  }
  
  public strictfp boolean isEmpty()
  {
    return this.height < 0.0D;
  }
  
  public strictfp boolean isFull()
  {
    return this.height >= 2.0D;
  }
  
  public strictfp boolean isValid()
  {
    return (S2.isUnitLength(this.axis)) && (this.height <= 2.0D);
  }
  
  public strictfp boolean mayIntersect(S2Cell paramS2Cell)
  {
    S2Point[] arrayOfS2Point = new S2Point[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfS2Point[i] = paramS2Cell.getVertex(i);
      if (contains(arrayOfS2Point[i])) {
        return true;
      }
      i += 1;
    }
    return intersects(paramS2Cell, arrayOfS2Point);
  }
  
  public strictfp String toString()
  {
    return "[Point = " + this.axis.toString() + " Height = " + this.height + "]";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Cap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */