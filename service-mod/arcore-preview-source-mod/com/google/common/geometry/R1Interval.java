package com.google.common.geometry;

public final class R1Interval
{
  private final double hi;
  private final double lo;
  
  public strictfp R1Interval(double paramDouble1, double paramDouble2)
  {
    this.lo = paramDouble1;
    this.hi = paramDouble2;
  }
  
  public static strictfp R1Interval empty()
  {
    return new R1Interval(1.0D, 0.0D);
  }
  
  public static strictfp R1Interval fromPoint(double paramDouble)
  {
    return new R1Interval(paramDouble, paramDouble);
  }
  
  public static strictfp R1Interval fromPointPair(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 <= paramDouble2) {
      return new R1Interval(paramDouble1, paramDouble2);
    }
    return new R1Interval(paramDouble2, paramDouble1);
  }
  
  public strictfp R1Interval addPoint(double paramDouble)
  {
    if (isEmpty()) {
      return fromPoint(paramDouble);
    }
    if (paramDouble < lo()) {
      return new R1Interval(paramDouble, hi());
    }
    if (paramDouble > hi()) {
      return new R1Interval(lo(), paramDouble);
    }
    return new R1Interval(lo(), hi());
  }
  
  public strictfp boolean approxEquals(R1Interval paramR1Interval)
  {
    return approxEquals(paramR1Interval, 1.0E-15D);
  }
  
  public strictfp boolean approxEquals(R1Interval paramR1Interval, double paramDouble)
  {
    if (isEmpty()) {
      if (paramR1Interval.getLength() > paramDouble) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!paramR1Interval.isEmpty()) {
          break;
        }
      } while (getLength() <= paramDouble);
      return false;
    } while (Math.abs(paramR1Interval.lo() - lo()) + Math.abs(paramR1Interval.hi() - hi()) <= paramDouble);
    return false;
  }
  
  public strictfp boolean contains(double paramDouble)
  {
    return (paramDouble >= lo()) && (paramDouble <= hi());
  }
  
  public strictfp boolean contains(R1Interval paramR1Interval)
  {
    if (paramR1Interval.isEmpty()) {}
    while ((paramR1Interval.lo() >= lo()) && (paramR1Interval.hi() <= hi())) {
      return true;
    }
    return false;
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof R1Interval))
    {
      paramObject = (R1Interval)paramObject;
      if ((lo() != ((R1Interval)paramObject).lo()) || (hi() != ((R1Interval)paramObject).hi()))
      {
        bool1 = bool2;
        if (isEmpty())
        {
          bool1 = bool2;
          if (!((R1Interval)paramObject).isEmpty()) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public strictfp R1Interval expanded(double paramDouble)
  {
    if (isEmpty()) {
      return this;
    }
    return new R1Interval(lo() - paramDouble, hi() + paramDouble);
  }
  
  public strictfp double getCenter()
  {
    return 0.5D * (lo() + hi());
  }
  
  public strictfp double getLength()
  {
    return hi() - lo();
  }
  
  public strictfp int hashCode()
  {
    if (isEmpty()) {
      return 17;
    }
    long l = 37L * (37L * 17L + Double.doubleToLongBits(this.lo)) + Double.doubleToLongBits(this.hi);
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp double hi()
  {
    return this.hi;
  }
  
  public strictfp boolean interiorContains(double paramDouble)
  {
    return (paramDouble > lo()) && (paramDouble < hi());
  }
  
  public strictfp boolean interiorContains(R1Interval paramR1Interval)
  {
    if (paramR1Interval.isEmpty()) {}
    while ((paramR1Interval.lo() > lo()) && (paramR1Interval.hi() < hi())) {
      return true;
    }
    return false;
  }
  
  public strictfp boolean interiorIntersects(R1Interval paramR1Interval)
  {
    return (paramR1Interval.lo() < hi()) && (lo() < paramR1Interval.hi()) && (lo() < hi()) && (paramR1Interval.lo() <= paramR1Interval.hi());
  }
  
  public strictfp R1Interval intersection(R1Interval paramR1Interval)
  {
    return new R1Interval(Math.max(lo(), paramR1Interval.lo()), Math.min(hi(), paramR1Interval.hi()));
  }
  
  public strictfp boolean intersects(R1Interval paramR1Interval)
  {
    if (lo() <= paramR1Interval.lo()) {
      if ((paramR1Interval.lo() > hi()) || (paramR1Interval.lo() > paramR1Interval.hi())) {}
    }
    while ((lo() <= paramR1Interval.hi()) && (lo() <= hi()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public strictfp boolean isEmpty()
  {
    return lo() > hi();
  }
  
  public strictfp double lo()
  {
    return this.lo;
  }
  
  public strictfp String toString()
  {
    return "[" + lo() + ", " + hi() + "]";
  }
  
  public strictfp R1Interval union(R1Interval paramR1Interval)
  {
    if (isEmpty()) {
      return paramR1Interval;
    }
    if (paramR1Interval.isEmpty()) {
      return this;
    }
    return new R1Interval(Math.min(lo(), paramR1Interval.lo()), Math.max(hi(), paramR1Interval.hi()));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/R1Interval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */