package com.google.common.geometry;

public final class S1Interval
  implements Cloneable
{
  private final double hi;
  private final double lo;
  
  public strictfp S1Interval(double paramDouble1, double paramDouble2)
  {
    this(paramDouble1, paramDouble2, false);
  }
  
  private strictfp S1Interval(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    double d2 = paramDouble1;
    double d3 = paramDouble2;
    double d5 = d3;
    double d4 = d2;
    if (!paramBoolean)
    {
      double d1 = d2;
      if (paramDouble1 == -3.141592653589793D)
      {
        d1 = d2;
        if (paramDouble2 != 3.141592653589793D) {
          d1 = 3.141592653589793D;
        }
      }
      d5 = d3;
      d4 = d1;
      if (paramDouble2 == -3.141592653589793D)
      {
        d5 = d3;
        d4 = d1;
        if (paramDouble1 != 3.141592653589793D)
        {
          d5 = 3.141592653589793D;
          d4 = d1;
        }
      }
    }
    this.lo = d4;
    this.hi = d5;
  }
  
  public strictfp S1Interval(S1Interval paramS1Interval)
  {
    this.lo = paramS1Interval.lo;
    this.hi = paramS1Interval.hi;
  }
  
  public static strictfp S1Interval empty()
  {
    return new S1Interval(3.141592653589793D, -3.141592653589793D, true);
  }
  
  public static strictfp S1Interval fromPoint(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == -3.141592653589793D) {
      d = 3.141592653589793D;
    }
    return new S1Interval(d, d, true);
  }
  
  public static strictfp S1Interval fromPointPair(double paramDouble1, double paramDouble2)
  {
    double d = paramDouble1;
    if (paramDouble1 == -3.141592653589793D) {
      d = 3.141592653589793D;
    }
    paramDouble1 = paramDouble2;
    if (paramDouble2 == -3.141592653589793D) {
      paramDouble1 = 3.141592653589793D;
    }
    if (positiveDistance(d, paramDouble1) <= 3.141592653589793D) {
      return new S1Interval(d, paramDouble1, true);
    }
    return new S1Interval(paramDouble1, d, true);
  }
  
  public static strictfp S1Interval full()
  {
    return new S1Interval(-3.141592653589793D, 3.141592653589793D, true);
  }
  
  public static strictfp double positiveDistance(double paramDouble1, double paramDouble2)
  {
    double d = paramDouble2 - paramDouble1;
    if (d >= 0.0D) {
      return d;
    }
    return paramDouble2 + 3.141592653589793D - (paramDouble1 - 3.141592653589793D);
  }
  
  public strictfp S1Interval addPoint(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == -3.141592653589793D) {
      d = 3.141592653589793D;
    }
    if (fastContains(d)) {
      return new S1Interval(this);
    }
    if (isEmpty()) {
      return fromPoint(d);
    }
    if (positiveDistance(d, lo()) < positiveDistance(hi(), d)) {
      return new S1Interval(d, hi());
    }
    return new S1Interval(lo(), d);
  }
  
  public strictfp boolean approxEquals(S1Interval paramS1Interval)
  {
    return approxEquals(paramS1Interval, 1.0E-9D);
  }
  
  public strictfp boolean approxEquals(S1Interval paramS1Interval, double paramDouble)
  {
    if (isEmpty()) {
      if (paramS1Interval.getLength() > paramDouble) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!paramS1Interval.isEmpty()) {
          break;
        }
      } while (getLength() <= paramDouble);
      return false;
    } while (Math.abs(Math.IEEEremainder(paramS1Interval.lo() - lo(), 6.283185307179586D)) + Math.abs(Math.IEEEremainder(paramS1Interval.hi() - hi(), 6.283185307179586D)) <= paramDouble);
    return false;
  }
  
  public strictfp S1Interval complement()
  {
    if (lo() == hi()) {
      return full();
    }
    return new S1Interval(hi(), lo(), true);
  }
  
  public strictfp boolean contains(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == -3.141592653589793D) {
      d = 3.141592653589793D;
    }
    return fastContains(d);
  }
  
  public strictfp boolean contains(S1Interval paramS1Interval)
  {
    boolean bool = false;
    if (isInverted()) {
      if (paramS1Interval.isInverted()) {
        if ((paramS1Interval.lo() < lo()) || (paramS1Interval.hi() > hi())) {}
      }
    }
    do
    {
      do
      {
        return true;
        return false;
      } while (((paramS1Interval.lo() >= lo()) || (paramS1Interval.hi() <= hi())) && (!isEmpty()));
      return false;
      if (paramS1Interval.isInverted())
      {
        if ((isFull()) || (paramS1Interval.isEmpty())) {
          bool = true;
        }
        return bool;
      }
    } while ((paramS1Interval.lo() >= lo()) && (paramS1Interval.hi() <= hi()));
    return false;
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof S1Interval))
    {
      paramObject = (S1Interval)paramObject;
      bool1 = bool2;
      if (lo() == ((S1Interval)paramObject).lo())
      {
        bool1 = bool2;
        if (hi() == ((S1Interval)paramObject).hi()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public strictfp S1Interval expanded(double paramDouble)
  {
    if (isEmpty()) {
      return this;
    }
    if (getLength() + 2.0D * paramDouble >= 6.283185307179585D) {
      return full();
    }
    double d1 = Math.IEEEremainder(lo() - paramDouble, 6.283185307179586D);
    double d2 = Math.IEEEremainder(hi() + paramDouble, 6.283185307179586D);
    paramDouble = d1;
    if (d1 == -3.141592653589793D) {
      paramDouble = 3.141592653589793D;
    }
    return new S1Interval(paramDouble, d2);
  }
  
  public strictfp boolean fastContains(double paramDouble)
  {
    if (isInverted()) {
      if (((paramDouble < lo()) && (paramDouble > hi())) || (isEmpty())) {}
    }
    while ((paramDouble >= lo()) && (paramDouble <= hi()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public strictfp double getCenter()
  {
    double d = 0.5D * (lo() + hi());
    if (!isInverted()) {
      return d;
    }
    if (d <= 0.0D) {}
    for (d += 3.141592653589793D;; d -= 3.141592653589793D) {
      return d;
    }
  }
  
  public strictfp double getLength()
  {
    double d = hi() - lo();
    if (d >= 0.0D) {
      return d;
    }
    d += 6.283185307179586D;
    if (d > 0.0D) {
      return d;
    }
    return -1.0D;
  }
  
  public strictfp int hashCode()
  {
    long l = 37L * (37L * 17L + Double.doubleToLongBits(lo())) + Double.doubleToLongBits(hi());
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp double hi()
  {
    return this.hi;
  }
  
  public strictfp boolean interiorContains(double paramDouble)
  {
    boolean bool = false;
    double d = paramDouble;
    if (paramDouble == -3.141592653589793D) {
      d = 3.141592653589793D;
    }
    if (isInverted()) {
      if ((d > lo()) || (d < hi())) {
        bool = true;
      }
    }
    while (((d <= lo()) || (d >= hi())) && (!isFull())) {
      return bool;
    }
    return true;
  }
  
  public strictfp boolean interiorContains(S1Interval paramS1Interval)
  {
    boolean bool = false;
    if (isInverted()) {
      if (!paramS1Interval.isInverted()) {
        if ((paramS1Interval.lo() > lo()) || (paramS1Interval.hi() < hi())) {
          bool = true;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (((paramS1Interval.lo() <= lo()) || (paramS1Interval.hi() >= hi())) && (!paramS1Interval.isEmpty()));
        return true;
        if (!paramS1Interval.isInverted()) {
          break;
        }
      } while ((!isFull()) && (!paramS1Interval.isEmpty()));
      return true;
    } while (((paramS1Interval.lo() <= lo()) || (paramS1Interval.hi() >= hi())) && (!isFull()));
    return true;
  }
  
  public strictfp boolean interiorIntersects(S1Interval paramS1Interval)
  {
    if ((isEmpty()) || (paramS1Interval.isEmpty()) || (lo() == hi())) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!isInverted()) {
            break;
          }
        } while ((!paramS1Interval.isInverted()) && (paramS1Interval.lo() >= hi()) && (paramS1Interval.hi() <= lo()));
        return true;
        if (!paramS1Interval.isInverted()) {
          break;
        }
      } while ((paramS1Interval.lo() >= hi()) && (paramS1Interval.hi() <= lo()));
      return true;
    } while (((paramS1Interval.lo() >= hi()) || (paramS1Interval.hi() <= lo())) && (!isFull()));
    return true;
  }
  
  public strictfp S1Interval intersection(S1Interval paramS1Interval)
  {
    S1Interval localS1Interval;
    if (paramS1Interval.isEmpty()) {
      localS1Interval = empty();
    }
    label68:
    do
    {
      do
      {
        return localS1Interval;
        if (!fastContains(paramS1Interval.lo())) {
          break label68;
        }
        if (!fastContains(paramS1Interval.hi())) {
          break;
        }
        localS1Interval = this;
      } while (paramS1Interval.getLength() >= getLength());
      return paramS1Interval;
      return new S1Interval(paramS1Interval.lo(), hi(), true);
      if (fastContains(paramS1Interval.hi())) {
        return new S1Interval(lo(), paramS1Interval.hi(), true);
      }
      localS1Interval = this;
    } while (paramS1Interval.fastContains(lo()));
    return empty();
  }
  
  public strictfp boolean intersects(S1Interval paramS1Interval)
  {
    boolean bool = true;
    if ((isEmpty()) || (paramS1Interval.isEmpty())) {}
    do
    {
      do
      {
        return false;
        if (!isInverted()) {
          break;
        }
      } while ((!paramS1Interval.isInverted()) && (paramS1Interval.lo() > hi()) && (paramS1Interval.hi() < lo()));
      return true;
      if (!paramS1Interval.isInverted()) {
        break;
      }
    } while ((paramS1Interval.lo() > hi()) && (paramS1Interval.hi() < lo()));
    return true;
    if ((paramS1Interval.lo() <= hi()) && (paramS1Interval.hi() >= lo())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public strictfp boolean isEmpty()
  {
    return lo() - hi() == 6.283185307179586D;
  }
  
  public strictfp boolean isFull()
  {
    return hi() - lo() == 6.283185307179586D;
  }
  
  public strictfp boolean isInverted()
  {
    return lo() > hi();
  }
  
  public strictfp boolean isValid()
  {
    return (Math.abs(lo()) <= 3.141592653589793D) && (Math.abs(hi()) <= 3.141592653589793D) && ((lo() != -3.141592653589793D) || (hi() == 3.141592653589793D)) && ((hi() != -3.141592653589793D) || (lo() == 3.141592653589793D));
  }
  
  public strictfp double lo()
  {
    return this.lo;
  }
  
  public strictfp String toString()
  {
    return "[" + lo() + ", " + hi() + "]";
  }
  
  public strictfp S1Interval union(S1Interval paramS1Interval)
  {
    if (paramS1Interval.isEmpty()) {
      return this;
    }
    if (fastContains(paramS1Interval.lo()))
    {
      if (fastContains(paramS1Interval.hi()))
      {
        if (contains(paramS1Interval)) {
          return this;
        }
        return full();
      }
      return new S1Interval(lo(), paramS1Interval.hi(), true);
    }
    if (fastContains(paramS1Interval.hi())) {
      return new S1Interval(paramS1Interval.lo(), hi(), true);
    }
    if ((isEmpty()) || (paramS1Interval.fastContains(lo()))) {
      return paramS1Interval;
    }
    if (positiveDistance(paramS1Interval.hi(), lo()) < positiveDistance(hi(), paramS1Interval.lo())) {
      return new S1Interval(paramS1Interval.lo(), hi(), true);
    }
    return new S1Interval(lo(), paramS1Interval.hi(), true);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S1Interval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */