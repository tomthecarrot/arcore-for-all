package com.google.common.geometry;

import java.lang.reflect.Array;

public final class S2Cell
  implements S2Region
{
  private static final int MAX_CELL_SIZE = 1073741824;
  private static final double MAX_ERROR = 4.440892098500626E-16D;
  private static final double POLE_MIN_LAT = Math.asin(Math.sqrt(0.3333333333333333D)) - 4.440892098500626E-16D;
  S2CellId cellId;
  byte face;
  byte level;
  byte orientation;
  double[][] uv = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
  
  strictfp S2Cell() {}
  
  public strictfp S2Cell(S2CellId paramS2CellId)
  {
    init(paramS2CellId);
  }
  
  public strictfp S2Cell(S2LatLng paramS2LatLng)
  {
    init(S2CellId.fromLatLng(paramS2LatLng));
  }
  
  public strictfp S2Cell(S2Point paramS2Point)
  {
    init(S2CellId.fromPoint(paramS2Point));
  }
  
  public static strictfp double averageArea(int paramInt)
  {
    return S2Projections.AVG_AREA.getValue(paramInt);
  }
  
  public static strictfp S2Cell fromFacePosLevel(int paramInt1, byte paramByte, int paramInt2)
  {
    return new S2Cell(S2CellId.fromFacePosLevel(paramInt1, paramByte, paramInt2));
  }
  
  private strictfp double getLatitude(int paramInt1, int paramInt2)
  {
    S2Point localS2Point = S2Projections.faceUvToXyz(this.face, this.uv[0][paramInt1], this.uv[1][paramInt2]);
    return Math.atan2(localS2Point.z, Math.sqrt(localS2Point.x * localS2Point.x + localS2Point.y * localS2Point.y));
  }
  
  private strictfp double getLongitude(int paramInt1, int paramInt2)
  {
    S2Point localS2Point = S2Projections.faceUvToXyz(this.face, this.uv[0][paramInt1], this.uv[1][paramInt2]);
    return Math.atan2(localS2Point.y, localS2Point.x);
  }
  
  private strictfp void init(S2CellId paramS2CellId)
  {
    this.cellId = paramS2CellId;
    MutableInteger[] arrayOfMutableInteger = new MutableInteger[2];
    MutableInteger localMutableInteger = new MutableInteger(0);
    int i = 0;
    while (i < 2)
    {
      arrayOfMutableInteger[i] = new MutableInteger(0);
      i += 1;
    }
    this.face = ((byte)paramS2CellId.toFaceIJOrientation(arrayOfMutableInteger[0], arrayOfMutableInteger[1], localMutableInteger));
    this.orientation = ((byte)localMutableInteger.intValue());
    this.level = ((byte)paramS2CellId.level());
    int j = 1 << 30 - this.level;
    i = 0;
    while (i < 2)
    {
      int k = (arrayOfMutableInteger[i].intValue() & -j) * 2 - 1073741824;
      this.uv[i][0] = S2Projections.stToUV(9.313225746154785E-10D * k);
      this.uv[i][1] = S2Projections.stToUV(9.313225746154785E-10D * (k + j * 2));
      i += 1;
    }
  }
  
  public strictfp double approxArea()
  {
    if (this.level < 2) {
      return averageArea(this.level);
    }
    double d = 0.5D * S2Point.crossProd(S2Point.sub(getVertex(2), getVertex(0)), S2Point.sub(getVertex(3), getVertex(1))).norm();
    return 2.0D * d / (Math.sqrt(1.0D - Math.min(0.3183098861837907D * d, 1.0D)) + 1.0D);
  }
  
  public strictfp double averageArea()
  {
    return averageArea(this.level);
  }
  
  public strictfp S2Region clone()
  {
    S2Cell localS2Cell = new S2Cell();
    localS2Cell.face = this.face;
    localS2Cell.level = this.level;
    localS2Cell.orientation = this.orientation;
    localS2Cell.uv = ((double[][])this.uv.clone());
    return localS2Cell;
  }
  
  public strictfp boolean contains(S2Cell paramS2Cell)
  {
    return this.cellId.contains(paramS2Cell.cellId);
  }
  
  public strictfp boolean contains(S2Point paramS2Point)
  {
    boolean bool = true;
    paramS2Point = S2Projections.faceXyzToUv(this.face, paramS2Point);
    if (paramS2Point == null) {
      return false;
    }
    if ((paramS2Point.x() >= this.uv[0][0]) && (paramS2Point.x() <= this.uv[0][1]) && (paramS2Point.y() >= this.uv[1][0]) && (paramS2Point.y() <= this.uv[1][1])) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof S2Cell))
    {
      paramObject = (S2Cell)paramObject;
      bool1 = bool2;
      if (this.face == ((S2Cell)paramObject).face)
      {
        bool1 = bool2;
        if (this.level == ((S2Cell)paramObject).level)
        {
          bool1 = bool2;
          if (this.orientation == ((S2Cell)paramObject).orientation)
          {
            bool1 = bool2;
            if (this.cellId.equals(((S2Cell)paramObject).cellId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public strictfp double exactArea()
  {
    S2Point localS2Point1 = getVertex(0);
    S2Point localS2Point2 = getVertex(1);
    S2Point localS2Point3 = getVertex(2);
    S2Point localS2Point4 = getVertex(3);
    return S2.area(localS2Point1, localS2Point2, localS2Point3) + S2.area(localS2Point1, localS2Point3, localS2Point4);
  }
  
  public strictfp int face()
  {
    return this.face;
  }
  
  public strictfp S2Cap getCapBound()
  {
    double d1 = this.uv[0][0];
    double d2 = this.uv[0][1];
    double d3 = this.uv[1][0];
    double d4 = this.uv[1][1];
    S2Cap localS2Cap = S2Cap.fromAxisHeight(S2Point.normalize(S2Projections.faceUvToXyz(this.face, 0.5D * (d1 + d2), 0.5D * (d3 + d4))), 0.0D);
    int i = 0;
    while (i < 4)
    {
      localS2Cap = localS2Cap.addPoint(getVertex(i));
      i += 1;
    }
    return localS2Cap;
  }
  
  public strictfp S2Point getCenter()
  {
    return S2Point.normalize(getCenterRaw());
  }
  
  public strictfp S2Point getCenterRaw()
  {
    return this.cellId.toPointRaw();
  }
  
  public strictfp R2Vector getCenterUV()
  {
    MutableInteger localMutableInteger1 = new MutableInteger(0);
    MutableInteger localMutableInteger2 = new MutableInteger(0);
    this.cellId.toFaceIJOrientation(localMutableInteger1, localMutableInteger2, null);
    int i = 1 << 30 - this.level;
    return new R2Vector(S2Projections.stToUV(((localMutableInteger1.intValue() & -i) * 2 + i - 1073741824) * 9.313225746154785E-10D), S2Projections.stToUV(((localMutableInteger2.intValue() & -i) * 2 + i - 1073741824) * 9.313225746154785E-10D));
  }
  
  public strictfp S2Point getEdge(int paramInt)
  {
    return S2Point.normalize(getEdgeRaw(paramInt));
  }
  
  public strictfp S2Point getEdgeRaw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return S2Point.neg(S2Projections.getUNorm(this.face, this.uv[0][0]));
    case 0: 
      return S2Projections.getVNorm(this.face, this.uv[1][0]);
    case 1: 
      return S2Projections.getUNorm(this.face, this.uv[0][1]);
    }
    return S2Point.neg(S2Projections.getVNorm(this.face, this.uv[1][1]));
  }
  
  public strictfp S2LatLngRect getRectBound()
  {
    if (this.level > 0)
    {
      double d1 = this.uv[0][0] + this.uv[0][1];
      double d2 = this.uv[1][0] + this.uv[1][1];
      int i;
      int j;
      if (S2Projections.getUAxis(this.face).z == 0.0D) {
        if (d1 < 0.0D)
        {
          i = 1;
          if (S2Projections.getVAxis(this.face).z != 0.0D) {
            break label195;
          }
          if (d2 >= 0.0D) {
            break label189;
          }
          j = 1;
        }
      }
      R1Interval localR1Interval;
      for (;;)
      {
        localR1Interval = R1Interval.fromPointPair(getLatitude(i, j), getLatitude(1 - i, 1 - j)).expanded(4.440892098500626E-16D).intersection(S2LatLngRect.fullLat());
        if ((localR1Interval.lo() != -1.5707963267948966D) && (localR1Interval.hi() != 1.5707963267948966D)) {
          break label213;
        }
        return new S2LatLngRect(localR1Interval, S1Interval.full());
        i = 0;
        break;
        if (d1 > 0.0D)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label189:
        j = 0;
        continue;
        label195:
        if (d2 > 0.0D) {
          j = 1;
        } else {
          j = 0;
        }
      }
      label213:
      return new S2LatLngRect(localR1Interval, S1Interval.fromPointPair(getLongitude(i, 1 - j), getLongitude(1 - i, j)).expanded(4.440892098500626E-16D));
    }
    switch (this.face)
    {
    default: 
      return new S2LatLngRect(new R1Interval(-1.5707963267948966D, -POLE_MIN_LAT), new S1Interval(-3.141592653589793D, 3.141592653589793D));
    case 0: 
      return new S2LatLngRect(new R1Interval(-0.7853981633974483D, 0.7853981633974483D), new S1Interval(-0.7853981633974483D, 0.7853981633974483D));
    case 1: 
      return new S2LatLngRect(new R1Interval(-0.7853981633974483D, 0.7853981633974483D), new S1Interval(0.7853981633974483D, 2.356194490192345D));
    case 2: 
      return new S2LatLngRect(new R1Interval(POLE_MIN_LAT, 1.5707963267948966D), new S1Interval(-3.141592653589793D, 3.141592653589793D));
    case 3: 
      return new S2LatLngRect(new R1Interval(-0.7853981633974483D, 0.7853981633974483D), new S1Interval(2.356194490192345D, -2.356194490192345D));
    }
    return new S2LatLngRect(new R1Interval(-0.7853981633974483D, 0.7853981633974483D), new S1Interval(-2.356194490192345D, -0.7853981633974483D));
  }
  
  public strictfp S2Point getVertex(int paramInt)
  {
    return S2Point.normalize(getVertexRaw(paramInt));
  }
  
  public strictfp S2Point getVertexRaw(int paramInt)
  {
    return S2Projections.faceUvToXyz(this.face, this.uv[0][(paramInt >> 1 ^ paramInt & 0x1)], this.uv[1][(paramInt >> 1)]);
  }
  
  public strictfp int hashCode()
  {
    return (((this.face + 629) * 37 + this.orientation) * 37 + this.level) * 37 + id().hashCode();
  }
  
  public strictfp S2CellId id()
  {
    return this.cellId;
  }
  
  public strictfp boolean isLeaf()
  {
    return this.level == 30;
  }
  
  public strictfp byte level()
  {
    return this.level;
  }
  
  public strictfp boolean mayIntersect(S2Cell paramS2Cell)
  {
    return this.cellId.intersects(paramS2Cell.cellId);
  }
  
  public strictfp byte orientation()
  {
    return this.orientation;
  }
  
  public strictfp boolean subdivide(S2Cell[] paramArrayOfS2Cell)
  {
    if (this.cellId.isLeaf()) {
      return false;
    }
    R2Vector localR2Vector = getCenterUV();
    S2CellId localS2CellId = this.cellId.childBegin();
    int i = 0;
    while (i < 4)
    {
      S2Cell localS2Cell = paramArrayOfS2Cell[i];
      localS2Cell.face = this.face;
      localS2Cell.level = ((byte)(this.level + 1));
      localS2Cell.orientation = ((byte)(this.orientation ^ S2.posToOrientation(i)));
      localS2Cell.cellId = localS2CellId;
      int k = S2.posToIJ(this.orientation, i);
      int j = 0;
      while (j < 2)
      {
        int m = 1 - (k >> 1 - j & 0x1);
        localS2Cell.uv[j][m] = localR2Vector.get(j);
        localS2Cell.uv[j][(1 - m)] = this.uv[j][(1 - m)];
        j += 1;
      }
      i += 1;
      localS2CellId = localS2CellId.next();
    }
    return true;
  }
  
  public strictfp String toString()
  {
    return "[" + this.face + ", " + this.level + ", " + this.orientation + ", " + this.cellId + "]";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */