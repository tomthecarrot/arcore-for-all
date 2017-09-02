package com.google.common.geometry;

public class S2EdgeUtil
{
  public static final S1Angle DEFAULT_INTERSECTION_TOLERANCE = S1Angle.radians(1.5E-15D);
  
  public static strictfp boolean edgeOrVertexCrossing(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    int i = robustCrossing(paramS2Point1, paramS2Point2, paramS2Point3, paramS2Point4);
    if (i < 0) {
      return false;
    }
    if (i > 0) {
      return true;
    }
    return vertexCrossing(paramS2Point1, paramS2Point2, paramS2Point3, paramS2Point4);
  }
  
  public static strictfp S2Point getClosestPoint(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3)
  {
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point1));
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point2));
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point3));
    S2Point localS2Point1 = S2.robustCrossProd(paramS2Point2, paramS2Point3);
    S2Point localS2Point2 = S2Point.minus(paramS2Point1, S2Point.mul(localS2Point1, paramS2Point1.dotProd(localS2Point1) / localS2Point1.norm2()));
    if ((S2.simpleCCW(localS2Point1, paramS2Point2, localS2Point2)) && (S2.simpleCCW(localS2Point2, paramS2Point3, localS2Point1))) {
      localS2Point1 = S2Point.normalize(localS2Point2);
    }
    do
    {
      return localS2Point1;
      localS2Point1 = paramS2Point2;
    } while (S2Point.minus(paramS2Point1, paramS2Point2).norm2() <= S2Point.minus(paramS2Point1, paramS2Point3).norm2());
    return paramS2Point3;
  }
  
  public static strictfp S1Angle getDistance(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3)
  {
    return getDistance(paramS2Point1, paramS2Point2, paramS2Point3, S2.robustCrossProd(paramS2Point2, paramS2Point3));
  }
  
  public static strictfp S1Angle getDistance(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point1));
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point2));
    Preconditions.checkArgument(S2.isUnitLength(paramS2Point3));
    if ((S2.simpleCCW(paramS2Point4, paramS2Point2, paramS2Point1)) && (S2.simpleCCW(paramS2Point1, paramS2Point3, paramS2Point4))) {
      return S1Angle.radians(Math.asin(Math.min(1.0D, Math.abs(paramS2Point1.dotProd(paramS2Point4)) / paramS2Point4.norm())));
    }
    return S1Angle.radians(2.0D * Math.asin(Math.min(1.0D, 0.5D * Math.sqrt(Math.min(S2Point.minus(paramS2Point1, paramS2Point2).norm2(), S2Point.minus(paramS2Point1, paramS2Point3).norm2())))));
  }
  
  public static strictfp double getDistanceFraction(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3)
  {
    if (!paramS2Point2.equals(paramS2Point3)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      double d = paramS2Point1.angle(paramS2Point2);
      return d / (d + paramS2Point1.angle(paramS2Point3));
    }
  }
  
  public static strictfp S2Point getIntersection(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    if (robustCrossing(paramS2Point1, paramS2Point2, paramS2Point3, paramS2Point4) > 0) {}
    S2Point localS2Point1;
    S2Point localS2Point2;
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Input edges a0a1 and b0b1 muct have a true robustCrossing.");
      localS2Point1 = S2Point.normalize(S2.robustCrossProd(paramS2Point1, paramS2Point2));
      localS2Point2 = S2Point.normalize(S2.robustCrossProd(paramS2Point3, paramS2Point4));
      localObject2 = S2Point.normalize(S2.robustCrossProd(localS2Point1, localS2Point2));
      localObject1 = localObject2;
      if (((S2Point)localObject2).dotProd(S2Point.add(S2Point.add(paramS2Point1, paramS2Point2), S2Point.add(paramS2Point3, paramS2Point4))) < 0.0D) {
        localObject1 = S2Point.neg((S2Point)localObject2);
      }
      if ((!S2.orderedCCW(paramS2Point1, (S2Point)localObject1, paramS2Point2, localS2Point1)) || (!S2.orderedCCW(paramS2Point3, (S2Point)localObject1, paramS2Point4, localS2Point2))) {
        break;
      }
      return (S2Point)localObject1;
    }
    Object localObject2 = new CloserResult(10.0D, (S2Point)localObject1);
    if (S2.orderedCCW(paramS2Point3, paramS2Point1, paramS2Point4, localS2Point2)) {
      ((CloserResult)localObject2).replaceIfCloser((S2Point)localObject1, paramS2Point1);
    }
    if (S2.orderedCCW(paramS2Point3, paramS2Point2, paramS2Point4, localS2Point2)) {
      ((CloserResult)localObject2).replaceIfCloser((S2Point)localObject1, paramS2Point2);
    }
    if (S2.orderedCCW(paramS2Point1, paramS2Point3, paramS2Point2, localS2Point1)) {
      ((CloserResult)localObject2).replaceIfCloser((S2Point)localObject1, paramS2Point3);
    }
    if (S2.orderedCCW(paramS2Point1, paramS2Point4, paramS2Point2, localS2Point1)) {
      ((CloserResult)localObject2).replaceIfCloser((S2Point)localObject1, paramS2Point4);
    }
    return ((CloserResult)localObject2).getVmin();
  }
  
  public static strictfp int robustCrossing(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    int j = -1;
    S2Point localS2Point = S2Point.crossProd(paramS2Point1, paramS2Point2);
    int k = -S2.robustCCW(paramS2Point1, paramS2Point2, paramS2Point3, localS2Point);
    int m = S2.robustCCW(paramS2Point1, paramS2Point2, paramS2Point4, localS2Point);
    int i;
    if ((m & k) == 0) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (m != k);
        localS2Point = S2Point.crossProd(paramS2Point3, paramS2Point4);
        i = j;
      } while (-S2.robustCCW(paramS2Point3, paramS2Point4, paramS2Point2, localS2Point) != k);
      i = j;
    } while (S2.robustCCW(paramS2Point3, paramS2Point4, paramS2Point1, localS2Point) != k);
    return 1;
  }
  
  public static strictfp boolean simpleCrossing(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    S2Point localS2Point = S2Point.crossProd(paramS2Point1, paramS2Point2);
    double d1 = -localS2Point.dotProd(paramS2Point3);
    if (d1 * localS2Point.dotProd(paramS2Point4) <= 0.0D) {
      return false;
    }
    paramS2Point3 = S2Point.crossProd(paramS2Point3, paramS2Point4);
    double d2 = -paramS2Point3.dotProd(paramS2Point2);
    double d3 = paramS2Point3.dotProd(paramS2Point1);
    return (d1 * d2 > 0.0D) && (d1 * d3 > 0.0D);
  }
  
  public static strictfp boolean vertexCrossing(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4)
  {
    if ((paramS2Point1.equals(paramS2Point2)) || (paramS2Point3.equals(paramS2Point4))) {}
    do
    {
      return false;
      if (paramS2Point1.equals(paramS2Point4)) {
        return S2.orderedCCW(S2.ortho(paramS2Point1), paramS2Point3, paramS2Point2, paramS2Point1);
      }
      if (paramS2Point2.equals(paramS2Point3)) {
        return S2.orderedCCW(S2.ortho(paramS2Point2), paramS2Point4, paramS2Point1, paramS2Point2);
      }
      if (paramS2Point1.equals(paramS2Point3)) {
        return S2.orderedCCW(S2.ortho(paramS2Point1), paramS2Point4, paramS2Point2, paramS2Point1);
      }
    } while (!paramS2Point2.equals(paramS2Point4));
    return S2.orderedCCW(S2.ortho(paramS2Point2), paramS2Point3, paramS2Point1, paramS2Point2);
  }
  
  static class CloserResult
  {
    private double dmin2;
    private S2Point vmin;
    
    public strictfp CloserResult(double paramDouble, S2Point paramS2Point)
    {
      this.dmin2 = paramDouble;
      this.vmin = paramS2Point;
    }
    
    public strictfp double getDmin2()
    {
      return this.dmin2;
    }
    
    public strictfp S2Point getVmin()
    {
      return this.vmin;
    }
    
    public strictfp void replaceIfCloser(S2Point paramS2Point1, S2Point paramS2Point2)
    {
      double d = S2Point.minus(paramS2Point1, paramS2Point2).norm2();
      if ((d < this.dmin2) || ((d == this.dmin2) && (paramS2Point2.lessThan(this.vmin))))
      {
        this.dmin2 = d;
        this.vmin = paramS2Point2;
      }
    }
  }
  
  public static class EdgeCrosser
  {
    private final S2Point a;
    private final S2Point aCrossB;
    private int acb;
    private final S2Point b;
    private S2Point c;
    
    public strictfp EdgeCrosser(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3)
    {
      this.a = paramS2Point1;
      this.b = paramS2Point2;
      this.aCrossB = S2Point.crossProd(paramS2Point1, paramS2Point2);
      restartAt(paramS2Point3);
    }
    
    private strictfp int robustCrossingInternal(S2Point paramS2Point)
    {
      S2Point localS2Point = S2Point.crossProd(this.c, paramS2Point);
      if (-S2.robustCCW(this.c, paramS2Point, this.b, localS2Point) != this.acb) {}
      while (S2.robustCCW(this.c, paramS2Point, this.a, localS2Point) != this.acb) {
        return -1;
      }
      return 1;
    }
    
    public strictfp boolean edgeOrVertexCrossing(S2Point paramS2Point)
    {
      S2Point localS2Point = new S2Point(this.c.get(0), this.c.get(1), this.c.get(2));
      int i = robustCrossing(paramS2Point);
      if (i < 0) {
        return false;
      }
      if (i > 0) {
        return true;
      }
      return S2EdgeUtil.vertexCrossing(this.a, this.b, localS2Point, paramS2Point);
    }
    
    public strictfp void restartAt(S2Point paramS2Point)
    {
      this.c = paramS2Point;
      this.acb = (-S2.robustCCW(this.a, this.b, paramS2Point, this.aCrossB));
    }
    
    public strictfp int robustCrossing(S2Point paramS2Point)
    {
      int j = S2.robustCCW(this.a, this.b, paramS2Point, this.aCrossB);
      int i;
      if ((j == -this.acb) && (j != 0)) {
        i = -1;
      }
      for (;;)
      {
        this.c = paramS2Point;
        this.acb = (-j);
        return i;
        if ((this.acb & j) == 0) {
          i = 0;
        } else {
          i = robustCrossingInternal(paramS2Point);
        }
      }
    }
  }
  
  public static class LongitudePruner
  {
    private S1Interval interval;
    private double lng0;
    
    public strictfp LongitudePruner(S1Interval paramS1Interval, S2Point paramS2Point)
    {
      this.interval = paramS1Interval;
      this.lng0 = S2LatLng.longitude(paramS2Point).radians();
    }
    
    public strictfp boolean intersects(S2Point paramS2Point)
    {
      double d = S2LatLng.longitude(paramS2Point).radians();
      boolean bool = this.interval.intersects(S1Interval.fromPointPair(this.lng0, d));
      this.lng0 = d;
      return bool;
    }
  }
  
  public static class RectBounder
  {
    private S2Point a;
    private S2LatLng aLatLng;
    private S2LatLngRect bound = S2LatLngRect.empty();
    
    public strictfp void addPoint(S2Point paramS2Point)
    {
      S2LatLng localS2LatLng = new S2LatLng(paramS2Point);
      if (this.bound.isEmpty()) {
        this.bound = this.bound.addPoint(localS2LatLng);
      }
      S2Point localS2Point;
      double d1;
      do
      {
        this.a = paramS2Point;
        this.aLatLng = localS2LatLng;
        return;
        this.bound = this.bound.union(S2LatLngRect.fromPointPair(this.aLatLng, localS2LatLng));
        localObject = S2.robustCrossProd(this.a, paramS2Point);
        localS2Point = S2Point.crossProd((S2Point)localObject, new S2Point(0.0D, 0.0D, 1.0D));
        d1 = localS2Point.dotProd(this.a);
      } while (d1 * localS2Point.dotProd(paramS2Point) >= 0.0D);
      double d2 = Math.acos(Math.abs(((S2Point)localObject).get(2) / ((S2Point)localObject).norm()));
      Object localObject = this.bound.lat();
      if (d1 < 0.0D) {}
      for (localObject = new R1Interval(((R1Interval)localObject).lo(), Math.max(d2, this.bound.lat().hi()));; localObject = new R1Interval(Math.min(-d2, this.bound.lat().lo()), ((R1Interval)localObject).hi()))
      {
        this.bound = new S2LatLngRect((R1Interval)localObject, this.bound.lng());
        break;
      }
    }
    
    public strictfp S2LatLngRect getBound()
    {
      return this.bound;
    }
  }
  
  public static class WedgeContains
    implements S2EdgeUtil.WedgeRelation
  {
    public strictfp int test(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4, S2Point paramS2Point5)
    {
      if ((S2.orderedCCW(paramS2Point3, paramS2Point5, paramS2Point4, paramS2Point2)) && (S2.orderedCCW(paramS2Point4, paramS2Point1, paramS2Point3, paramS2Point2))) {
        return 1;
      }
      return 0;
    }
  }
  
  public static class WedgeContainsOrCrosses
    implements S2EdgeUtil.WedgeRelation
  {
    public strictfp int test(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4, S2Point paramS2Point5)
    {
      int i = 0;
      if (S2.orderedCCW(paramS2Point1, paramS2Point3, paramS2Point5, paramS2Point2)) {
        if (S2.orderedCCW(paramS2Point5, paramS2Point4, paramS2Point1, paramS2Point2)) {
          i = 1;
        }
      }
      while (S2.orderedCCW(paramS2Point1, paramS2Point4, paramS2Point3, paramS2Point2))
      {
        do
        {
          return i;
        } while (paramS2Point3.equals(paramS2Point5));
        return -1;
      }
      return -1;
    }
  }
  
  public static class WedgeContainsOrIntersects
    implements S2EdgeUtil.WedgeRelation
  {
    public strictfp int test(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4, S2Point paramS2Point5)
    {
      int i = -1;
      if (S2.orderedCCW(paramS2Point1, paramS2Point3, paramS2Point5, paramS2Point2)) {
        if (S2.orderedCCW(paramS2Point5, paramS2Point4, paramS2Point1, paramS2Point2)) {
          i = 1;
        }
      }
      do
      {
        return i;
        if (!S2.orderedCCW(paramS2Point3, paramS2Point4, paramS2Point5, paramS2Point2)) {
          return 0;
        }
      } while (!paramS2Point3.equals(paramS2Point4));
      return 0;
    }
  }
  
  public static class WedgeIntersects
    implements S2EdgeUtil.WedgeRelation
  {
    public strictfp int test(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4, S2Point paramS2Point5)
    {
      if ((S2.orderedCCW(paramS2Point1, paramS2Point5, paramS2Point4, paramS2Point2)) && (S2.orderedCCW(paramS2Point4, paramS2Point3, paramS2Point1, paramS2Point2))) {
        return 0;
      }
      return -1;
    }
  }
  
  public static abstract interface WedgeRelation
  {
    public abstract int test(S2Point paramS2Point1, S2Point paramS2Point2, S2Point paramS2Point3, S2Point paramS2Point4, S2Point paramS2Point5);
  }
  
  public static class XYZPruner
  {
    private boolean boundSet = false;
    private S2Point lastVertex;
    private double maxDeformation;
    private double xmax;
    private double xmin;
    private double ymax;
    private double ymin;
    private double zmax;
    private double zmin;
    
    public strictfp void addEdgeToBounds(S2Point paramS2Point1, S2Point paramS2Point2)
    {
      if (!this.boundSet)
      {
        this.boundSet = true;
        d = paramS2Point1.x;
        this.xmax = d;
        this.xmin = d;
        d = paramS2Point1.y;
        this.ymax = d;
        this.ymin = d;
        d = paramS2Point1.z;
        this.zmax = d;
        this.zmin = d;
      }
      this.xmin = Math.min(this.xmin, Math.min(paramS2Point2.x, paramS2Point1.x));
      this.ymin = Math.min(this.ymin, Math.min(paramS2Point2.y, paramS2Point1.y));
      this.zmin = Math.min(this.zmin, Math.min(paramS2Point2.z, paramS2Point1.z));
      this.xmax = Math.max(this.xmax, Math.max(paramS2Point2.x, paramS2Point1.x));
      this.ymax = Math.max(this.ymax, Math.max(paramS2Point2.y, paramS2Point1.y));
      this.zmax = Math.max(this.zmax, Math.max(paramS2Point2.z, paramS2Point1.z));
      double d = Math.abs(paramS2Point1.x - paramS2Point2.x) + Math.abs(paramS2Point1.y - paramS2Point2.y) + Math.abs(paramS2Point1.z - paramS2Point2.z);
      if (d < 0.025D)
      {
        this.maxDeformation = Math.max(this.maxDeformation, 0.0025D * d);
        return;
      }
      if (d < 1.0D)
      {
        this.maxDeformation = Math.max(this.maxDeformation, 0.11D * d);
        return;
      }
      this.maxDeformation = (0.5D * d);
    }
    
    public strictfp boolean intersects(S2Point paramS2Point)
    {
      boolean bool2 = true;
      boolean bool1;
      if (((paramS2Point.x < this.xmin) && (this.lastVertex.x < this.xmin)) || ((paramS2Point.x > this.xmax) && (this.lastVertex.x > this.xmax))) {
        bool1 = false;
      }
      for (;;)
      {
        this.lastVertex = paramS2Point;
        return bool1;
        if (((paramS2Point.y < this.ymin) && (this.lastVertex.y < this.ymin)) || ((paramS2Point.y > this.ymax) && (this.lastVertex.y > this.ymax)))
        {
          bool1 = false;
        }
        else if ((paramS2Point.z >= this.zmin) || (this.lastVertex.z >= this.zmin))
        {
          bool1 = bool2;
          if (paramS2Point.z > this.zmax)
          {
            bool1 = bool2;
            if (this.lastVertex.z <= this.zmax) {}
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
    
    public strictfp void setFirstIntersectPoint(S2Point paramS2Point)
    {
      this.xmin -= this.maxDeformation;
      this.ymin -= this.maxDeformation;
      this.zmin -= this.maxDeformation;
      this.xmax += this.maxDeformation;
      this.ymax += this.maxDeformation;
      this.zmax += this.maxDeformation;
      this.lastVertex = paramS2Point;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2EdgeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */