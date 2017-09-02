package com.google.common.geometry;

public class S2LatLngRect
  implements S2Region
{
  private final R1Interval lat;
  private final S1Interval lng;
  
  public strictfp S2LatLngRect(R1Interval paramR1Interval, S1Interval paramS1Interval)
  {
    this.lat = paramR1Interval;
    this.lng = paramS1Interval;
  }
  
  public strictfp S2LatLngRect(S2LatLng paramS2LatLng1, S2LatLng paramS2LatLng2)
  {
    this.lat = new R1Interval(paramS2LatLng1.lat().radians(), paramS2LatLng2.lat().radians());
    this.lng = new S1Interval(paramS2LatLng1.lng().radians(), paramS2LatLng2.lng().radians());
  }
  
  public static strictfp S2LatLngRect empty()
  {
    return new S2LatLngRect(R1Interval.empty(), S1Interval.empty());
  }
  
  public static strictfp S2LatLngRect fromCenterSize(S2LatLng paramS2LatLng1, S2LatLng paramS2LatLng2)
  {
    return fromPoint(paramS2LatLng1).expanded(paramS2LatLng2.mul(0.5D));
  }
  
  public static strictfp S2LatLngRect fromEdge(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    S2LatLngRect localS2LatLngRect = fromPointPair(new S2LatLng(paramS2Point1), new S2LatLng(paramS2Point2));
    S2Point localS2Point1 = S2.robustCrossProd(paramS2Point1, paramS2Point2);
    S2Point localS2Point2 = S2Point.crossProd(localS2Point1, new S2Point(0.0D, 0.0D, 1.0D));
    double d1 = localS2Point2.dotProd(paramS2Point1);
    if (d1 * localS2Point2.dotProd(paramS2Point2) >= 0.0D) {
      return localS2LatLngRect;
    }
    double d2 = Math.acos(Math.abs(localS2Point1.z / localS2Point1.norm()));
    if (d1 < 0.0D) {
      return new S2LatLngRect(new R1Interval(localS2LatLngRect.lat().lo(), d2), localS2LatLngRect.lng());
    }
    return new S2LatLngRect(new R1Interval(-d2, localS2LatLngRect.lat().hi()), localS2LatLngRect.lng());
  }
  
  public static strictfp S2LatLngRect fromPoint(S2LatLng paramS2LatLng)
  {
    return new S2LatLngRect(paramS2LatLng, paramS2LatLng);
  }
  
  public static strictfp S2LatLngRect fromPointPair(S2LatLng paramS2LatLng1, S2LatLng paramS2LatLng2)
  {
    return new S2LatLngRect(R1Interval.fromPointPair(paramS2LatLng1.lat().radians(), paramS2LatLng2.lat().radians()), S1Interval.fromPointPair(paramS2LatLng1.lng().radians(), paramS2LatLng2.lng().radians()));
  }
  
  public static strictfp S2LatLngRect full()
  {
    return new S2LatLngRect(fullLat(), fullLng());
  }
  
  public static strictfp R1Interval fullLat()
  {
    return new R1Interval(-1.5707963267948966D, 1.5707963267948966D);
  }
  
  public static strictfp S1Interval fullLng()
  {
    return S1Interval.full();
  }
  
  private static strictfp boolean intersectsLatEdge(S2Point paramS2Point1, S2Point paramS2Point2, double paramDouble, S1Interval paramS1Interval)
  {
    S2Point localS2Point2 = S2Point.normalize(S2.robustCrossProd(paramS2Point1, paramS2Point2));
    S2Point localS2Point1 = localS2Point2;
    if (localS2Point2.z < 0.0D) {
      localS2Point1 = S2Point.neg(localS2Point2);
    }
    localS2Point2 = S2Point.normalize(S2.robustCrossProd(localS2Point1, new S2Point(0.0D, 0.0D, 1.0D)));
    localS2Point1 = S2Point.crossProd(localS2Point2, localS2Point1);
    paramDouble = Math.sin(paramDouble);
    if (Math.abs(paramDouble) >= localS2Point1.z) {
      return false;
    }
    paramDouble /= localS2Point1.z;
    double d1 = Math.sqrt(1.0D - paramDouble * paramDouble);
    double d2 = Math.atan2(d1, paramDouble);
    paramS2Point1 = S1Interval.fromPointPair(Math.atan2(paramS2Point1.dotProd(localS2Point2), paramS2Point1.dotProd(localS2Point1)), Math.atan2(paramS2Point2.dotProd(localS2Point2), paramS2Point2.dotProd(localS2Point1)));
    if (paramS2Point1.contains(d2))
    {
      paramS2Point2 = S2Point.add(S2Point.mul(localS2Point1, paramDouble), S2Point.mul(localS2Point2, d1));
      if (paramS1Interval.contains(Math.atan2(paramS2Point2.y, paramS2Point2.x))) {
        return true;
      }
    }
    if (paramS2Point1.contains(-d2))
    {
      paramS2Point1 = S2Point.sub(S2Point.mul(localS2Point1, paramDouble), S2Point.mul(localS2Point2, d1));
      if (paramS1Interval.contains(Math.atan2(paramS2Point1.y, paramS2Point1.x))) {
        return true;
      }
    }
    return false;
  }
  
  private static strictfp boolean intersectsLngEdge(S2Point paramS2Point1, S2Point paramS2Point2, R1Interval paramR1Interval, double paramDouble)
  {
    return S2.simpleCrossing(paramS2Point1, paramS2Point2, S2LatLng.fromRadians(paramR1Interval.lo(), paramDouble).toPoint(), S2LatLng.fromRadians(paramR1Interval.hi(), paramDouble).toPoint());
  }
  
  public strictfp S2LatLngRect addPoint(S2LatLng paramS2LatLng)
  {
    return new S2LatLngRect(this.lat.addPoint(paramS2LatLng.lat().radians()), this.lng.addPoint(paramS2LatLng.lng().radians()));
  }
  
  public strictfp S2LatLngRect addPoint(S2Point paramS2Point)
  {
    return addPoint(new S2LatLng(paramS2Point));
  }
  
  public strictfp boolean approxEquals(S2LatLngRect paramS2LatLngRect)
  {
    return approxEquals(paramS2LatLngRect, 1.0E-15D);
  }
  
  public strictfp boolean approxEquals(S2LatLngRect paramS2LatLngRect, double paramDouble)
  {
    return (this.lat.approxEquals(paramS2LatLngRect.lat, paramDouble)) && (this.lng.approxEquals(paramS2LatLngRect.lng, paramDouble));
  }
  
  public strictfp double area()
  {
    if (isEmpty()) {
      return 0.0D;
    }
    return lng().getLength() * Math.abs(Math.sin(latHi().radians()) - Math.sin(latLo().radians()));
  }
  
  public strictfp S2Region clone()
  {
    return new S2LatLngRect(lo(), hi());
  }
  
  public strictfp boolean contains(S2Cell paramS2Cell)
  {
    return contains(paramS2Cell.getRectBound());
  }
  
  public strictfp boolean contains(S2LatLng paramS2LatLng)
  {
    return (this.lat.contains(paramS2LatLng.lat().radians())) && (this.lng.contains(paramS2LatLng.lng().radians()));
  }
  
  public strictfp boolean contains(S2LatLngRect paramS2LatLngRect)
  {
    return (this.lat.contains(paramS2LatLngRect.lat)) && (this.lng.contains(paramS2LatLngRect.lng));
  }
  
  public strictfp boolean contains(S2Point paramS2Point)
  {
    return contains(new S2LatLng(paramS2Point));
  }
  
  public strictfp S2LatLngRect convolveWithCap(S1Angle paramS1Angle)
  {
    S2Cap localS2Cap = S2Cap.fromAxisAngle(new S2Point(1.0D, 0.0D, 0.0D), paramS1Angle);
    paramS1Angle = this;
    int i = 0;
    while (i < 4)
    {
      paramS1Angle = paramS1Angle.union(S2Cap.fromAxisHeight(getVertex(i).toPoint(), localS2Cap.height()).getRectBound());
      i += 1;
    }
    return paramS1Angle;
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2LatLngRect)) {}
    do
    {
      return false;
      paramObject = (S2LatLngRect)paramObject;
    } while ((!lat().equals(((S2LatLngRect)paramObject).lat())) || (!lng().equals(((S2LatLngRect)paramObject).lng())));
    return true;
  }
  
  public strictfp S2LatLngRect expanded(S2LatLng paramS2LatLng)
  {
    if (isEmpty()) {
      return this;
    }
    return new S2LatLngRect(this.lat.expanded(paramS2LatLng.lat().radians()).intersection(fullLat()), this.lng.expanded(paramS2LatLng.lng().radians()));
  }
  
  public strictfp S2Cap getCapBound()
  {
    Object localObject;
    if (isEmpty()) {
      localObject = S2Cap.empty();
    }
    S2Cap localS2Cap2;
    S2Cap localS2Cap1;
    do
    {
      return (S2Cap)localObject;
      double d1;
      if (this.lat.lo() + this.lat.hi() < 0.0D) {
        d1 = -1.0D;
      }
      for (double d2 = 1.5707963267948966D + this.lat.hi();; d2 = 1.5707963267948966D - this.lat.lo())
      {
        localS2Cap2 = S2Cap.fromAxisAngle(new S2Point(0.0D, 0.0D, d1), S1Angle.radians(d2));
        d1 = this.lng.hi() - this.lng.lo();
        if ((Math.IEEEremainder(d1, 6.283185307179586D) < 0.0D) || (d1 >= 6.283185307179586D)) {
          break label191;
        }
        localS2Cap1 = S2Cap.fromAxisAngle(getCenter().toPoint(), S1Angle.radians(0.0D));
        int i = 0;
        while (i < 4)
        {
          localS2Cap1 = localS2Cap1.addPoint(getVertex(i).toPoint());
          i += 1;
        }
        d1 = 1.0D;
      }
      localObject = localS2Cap1;
    } while (localS2Cap1.height() < localS2Cap2.height());
    label191:
    return localS2Cap2;
  }
  
  public strictfp S2LatLng getCenter()
  {
    return S2LatLng.fromRadians(this.lat.getCenter(), this.lng.getCenter());
  }
  
  public strictfp S1Angle getDistance(S2LatLng paramS2LatLng)
  {
    if (!isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      Preconditions.checkArgument(paramS2LatLng.isValid());
      if (!lng().contains(paramS2LatLng.lng().radians())) {
        break;
      }
      return S1Angle.radians(Math.max(0.0D, Math.max(paramS2LatLng.lat().radians() - lat().hi(), lat().lo() - paramS2LatLng.lat().radians())));
    }
    Object localObject = new S1Interval(lng().hi(), lng().complement().getCenter());
    double d = lng().lo();
    if (((S1Interval)localObject).contains(paramS2LatLng.lng().radians())) {
      d = lng().hi();
    }
    localObject = S2LatLng.fromRadians(lat().lo(), d).toPoint();
    S2Point localS2Point1 = S2LatLng.fromRadians(lat().hi(), d).toPoint();
    S2Point localS2Point2 = S2LatLng.fromRadians(0.0D, d - 1.5707963267948966D).normalized().toPoint();
    return S2EdgeUtil.getDistance(paramS2LatLng.toPoint(), (S2Point)localObject, localS2Point1, localS2Point2);
  }
  
  public strictfp S1Angle getDistance(S2LatLngRect paramS2LatLngRect)
  {
    if (!isEmpty())
    {
      bool = true;
      Preconditions.checkState(bool);
      if (paramS2LatLngRect.isEmpty()) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (!lng().intersects(paramS2LatLngRect.lng())) {
        break label123;
      }
      if (!lat().intersects(paramS2LatLngRect.lat())) {
        break label69;
      }
      return S1Angle.radians(0.0D);
      bool = false;
      break;
    }
    label69:
    if (lat().lo() > paramS2LatLngRect.lat().hi()) {
      localObject1 = paramS2LatLngRect.latHi();
    }
    for (paramS2LatLngRect = latLo();; paramS2LatLngRect = paramS2LatLngRect.latLo())
    {
      return S1Angle.radians(paramS2LatLngRect.radians() - ((S1Angle)localObject1).radians());
      localObject1 = latHi();
    }
    label123:
    Object localObject1 = S1Interval.fromPointPair(lng().lo(), paramS2LatLngRect.lng().hi());
    Object localObject2 = S1Interval.fromPointPair(lng().hi(), paramS2LatLngRect.lng().lo());
    if (((S1Interval)localObject1).getLength() < ((S1Interval)localObject2).getLength()) {
      localObject2 = lngLo();
    }
    for (localObject1 = paramS2LatLngRect.lngHi();; localObject1 = paramS2LatLngRect.lngLo())
    {
      S2Point localS2Point1 = new S2LatLng(latLo(), (S1Angle)localObject2).toPoint();
      S2Point localS2Point2 = new S2LatLng(latHi(), (S1Angle)localObject2).toPoint();
      localObject2 = S2LatLng.fromRadians(0.0D, ((S1Angle)localObject2).radians() - 1.5707963267948966D).normalized().toPoint();
      S2Point localS2Point3 = new S2LatLng(paramS2LatLngRect.latLo(), (S1Angle)localObject1).toPoint();
      paramS2LatLngRect = new S2LatLng(paramS2LatLngRect.latHi(), (S1Angle)localObject1).toPoint();
      localObject1 = S2LatLng.fromRadians(0.0D, ((S1Angle)localObject1).radians() - 1.5707963267948966D).normalized().toPoint();
      return S1Angle.min(S2EdgeUtil.getDistance(localS2Point1, localS2Point3, paramS2LatLngRect, (S2Point)localObject1), S1Angle.min(S2EdgeUtil.getDistance(localS2Point2, localS2Point3, paramS2LatLngRect, (S2Point)localObject1), S1Angle.min(S2EdgeUtil.getDistance(localS2Point3, localS2Point1, localS2Point2, (S2Point)localObject2), S2EdgeUtil.getDistance(paramS2LatLngRect, localS2Point1, localS2Point2, (S2Point)localObject2))));
      localObject2 = lngHi();
    }
  }
  
  public strictfp S2LatLngRect getRectBound()
  {
    return this;
  }
  
  public strictfp S2LatLng getSize()
  {
    return S2LatLng.fromRadians(this.lat.getLength(), this.lng.getLength());
  }
  
  public strictfp S2LatLng getVertex(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Invalid vertex index.");
    case 0: 
      return S2LatLng.fromRadians(this.lat.lo(), this.lng.lo());
    case 1: 
      return S2LatLng.fromRadians(this.lat.lo(), this.lng.hi());
    case 2: 
      return S2LatLng.fromRadians(this.lat.hi(), this.lng.hi());
    }
    return S2LatLng.fromRadians(this.lat.hi(), this.lng.lo());
  }
  
  public strictfp int hashCode()
  {
    return (this.lat.hashCode() + 629) * 37 + this.lng.hashCode();
  }
  
  public strictfp S2LatLng hi()
  {
    return new S2LatLng(latHi(), lngHi());
  }
  
  public strictfp boolean interiorContains(S2LatLng paramS2LatLng)
  {
    return (this.lat.interiorContains(paramS2LatLng.lat().radians())) && (this.lng.interiorContains(paramS2LatLng.lng().radians()));
  }
  
  public strictfp boolean interiorContains(S2LatLngRect paramS2LatLngRect)
  {
    return (this.lat.interiorContains(paramS2LatLngRect.lat)) && (this.lng.interiorContains(paramS2LatLngRect.lng));
  }
  
  public strictfp boolean interiorContains(S2Point paramS2Point)
  {
    return interiorContains(new S2LatLng(paramS2Point));
  }
  
  public strictfp boolean interiorIntersects(S2LatLngRect paramS2LatLngRect)
  {
    return (this.lat.interiorIntersects(paramS2LatLngRect.lat)) && (this.lng.interiorIntersects(paramS2LatLngRect.lng));
  }
  
  public strictfp S2LatLngRect intersection(S2LatLngRect paramS2LatLngRect)
  {
    R1Interval localR1Interval = this.lat.intersection(paramS2LatLngRect.lat);
    paramS2LatLngRect = this.lng.intersection(paramS2LatLngRect.lng);
    if ((localR1Interval.isEmpty()) || (paramS2LatLngRect.isEmpty())) {
      return empty();
    }
    return new S2LatLngRect(localR1Interval, paramS2LatLngRect);
  }
  
  public strictfp boolean intersects(S2Cell paramS2Cell)
  {
    if (isEmpty()) {}
    do
    {
      return false;
      if (contains(paramS2Cell.getCenter())) {
        return true;
      }
      if (paramS2Cell.contains(getCenter().toPoint())) {
        return true;
      }
    } while (!intersects(paramS2Cell.getRectBound()));
    S2Point[] arrayOfS2Point = new S2Point[4];
    S2LatLng[] arrayOfS2LatLng = new S2LatLng[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfS2Point[i] = paramS2Cell.getVertex(i);
      arrayOfS2LatLng[i] = new S2LatLng(arrayOfS2Point[i]);
      if (contains(arrayOfS2LatLng[i])) {
        return true;
      }
      i += 1;
    }
    i = 0;
    label111:
    if (i < 4)
    {
      paramS2Cell = S1Interval.fromPointPair(arrayOfS2LatLng[i].lng().radians(), arrayOfS2LatLng[(i + 1 & 0x3)].lng().radians());
      if (this.lng.intersects(paramS2Cell)) {
        break label162;
      }
    }
    label162:
    S2Point localS2Point1;
    S2Point localS2Point2;
    do
    {
      i += 1;
      break label111;
      break;
      localS2Point1 = arrayOfS2Point[i];
      localS2Point2 = arrayOfS2Point[(i + 1 & 0x3)];
      if ((paramS2Cell.contains(this.lng.lo())) && (intersectsLngEdge(localS2Point1, localS2Point2, this.lat, this.lng.lo()))) {
        return true;
      }
      if ((paramS2Cell.contains(this.lng.hi())) && (intersectsLngEdge(localS2Point1, localS2Point2, this.lat, this.lng.hi()))) {
        return true;
      }
      if (intersectsLatEdge(localS2Point1, localS2Point2, this.lat.lo(), this.lng)) {
        return true;
      }
    } while (!intersectsLatEdge(localS2Point1, localS2Point2, this.lat.hi(), this.lng));
    return true;
  }
  
  public strictfp boolean intersects(S2LatLngRect paramS2LatLngRect)
  {
    return (this.lat.intersects(paramS2LatLngRect.lat)) && (this.lng.intersects(paramS2LatLngRect.lng));
  }
  
  public strictfp boolean isEmpty()
  {
    return this.lat.isEmpty();
  }
  
  public strictfp boolean isFull()
  {
    return (this.lat.equals(fullLat())) && (this.lng.isFull());
  }
  
  public strictfp boolean isInverted()
  {
    return this.lng.isInverted();
  }
  
  public strictfp boolean isValid()
  {
    return (Math.abs(this.lat.lo()) <= 1.5707963267948966D) && (Math.abs(this.lat.hi()) <= 1.5707963267948966D) && (this.lng.isValid()) && (this.lat.isEmpty() == this.lng.isEmpty());
  }
  
  public strictfp R1Interval lat()
  {
    return this.lat;
  }
  
  public strictfp S1Angle latHi()
  {
    return S1Angle.radians(this.lat.hi());
  }
  
  public strictfp S1Angle latLo()
  {
    return S1Angle.radians(this.lat.lo());
  }
  
  public strictfp S1Interval lng()
  {
    return this.lng;
  }
  
  public strictfp S1Angle lngHi()
  {
    return S1Angle.radians(this.lng.hi());
  }
  
  public strictfp S1Angle lngLo()
  {
    return S1Angle.radians(this.lng.lo());
  }
  
  public strictfp S2LatLng lo()
  {
    return new S2LatLng(latLo(), lngLo());
  }
  
  public strictfp boolean mayIntersect(S2Cell paramS2Cell)
  {
    return intersects(paramS2Cell.getRectBound());
  }
  
  public strictfp String toString()
  {
    return "[Lo=" + lo() + ", Hi=" + hi() + "]";
  }
  
  public strictfp S2LatLngRect union(S2LatLngRect paramS2LatLngRect)
  {
    return new S2LatLngRect(this.lat.union(paramS2LatLngRect.lat), this.lng.union(paramS2LatLngRect.lng));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2LatLngRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */