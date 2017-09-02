package com.google.common.geometry;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public final class S2Polyline
  implements S2Region
{
  private static final Logger log = Logger.getLogger(S2Polyline.class.getCanonicalName());
  private final int numVertices;
  private final S2Point[] vertices;
  
  public strictfp S2Polyline(S2Polyline paramS2Polyline)
  {
    this.numVertices = paramS2Polyline.numVertices();
    this.vertices = ((S2Point[])paramS2Polyline.vertices.clone());
  }
  
  public strictfp S2Polyline(List<S2Point> paramList)
  {
    this.numVertices = paramList.size();
    this.vertices = ((S2Point[])paramList.toArray(new S2Point[this.numVertices]));
  }
  
  public strictfp boolean contains(S2Cell paramS2Cell)
  {
    throw new UnsupportedOperationException("'containment' is not numerically well-defined except at the polyline vertices");
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof S2Polyline)) {}
    do
    {
      return false;
      paramObject = (S2Polyline)paramObject;
    } while (this.numVertices != ((S2Polyline)paramObject).numVertices);
    int i = 0;
    for (;;)
    {
      if (i >= this.vertices.length) {
        break label61;
      }
      if (!this.vertices[i].equals(paramObject.vertices[i])) {
        break;
      }
      i += 1;
    }
    label61:
    return true;
  }
  
  public strictfp S1Angle getArclengthAngle()
  {
    double d = 0.0D;
    int i = 1;
    while (i < numVertices())
    {
      d += vertex(i - 1).angle(vertex(i));
      i += 1;
    }
    return S1Angle.radians(d);
  }
  
  public strictfp S2Cap getCapBound()
  {
    return getRectBound().getCapBound();
  }
  
  public strictfp int getNearestEdgeIndex(S2Point paramS2Point)
  {
    if (numVertices() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Empty polyline");
      if (numVertices() != 1) {
        break;
      }
      return 0;
    }
    Object localObject1 = S1Angle.radians(10.0D);
    int j = -1;
    int i = 0;
    while (i < numVertices() - 1)
    {
      S1Angle localS1Angle = S2EdgeUtil.getDistance(paramS2Point, vertex(i), vertex(i + 1));
      Object localObject2 = localObject1;
      if (localS1Angle.lessThan((S1Angle)localObject1))
      {
        localObject2 = localS1Angle;
        j = i;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return j;
  }
  
  public strictfp S2LatLngRect getRectBound()
  {
    S2EdgeUtil.RectBounder localRectBounder = new S2EdgeUtil.RectBounder();
    int i = 0;
    while (i < numVertices())
    {
      localRectBounder.addPoint(vertex(i));
      i += 1;
    }
    return localRectBounder.getBound();
  }
  
  public strictfp int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.numVertices), Integer.valueOf(Arrays.deepHashCode(this.vertices)) });
  }
  
  public strictfp S2Point interpolate(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return vertex(0);
    }
    double d1 = 0.0D;
    int i = 1;
    while (i < numVertices())
    {
      d1 += vertex(i - 1).angle(vertex(i));
      i += 1;
    }
    paramDouble *= d1;
    i = 1;
    while (i < numVertices())
    {
      d1 = vertex(i - 1).angle(vertex(i));
      if (paramDouble < d1)
      {
        double d2 = Math.sin(paramDouble) / Math.sin(d1);
        return S2Point.add(S2Point.mul(vertex(i - 1), Math.cos(paramDouble) - Math.cos(d1) * d2), S2Point.mul(vertex(i), d2));
      }
      paramDouble -= d1;
      i += 1;
    }
    return vertex(numVertices() - 1);
  }
  
  public strictfp boolean isValid(List<S2Point> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!S2.isUnitLength((S2Point)paramList.get(i)))
      {
        log.info("Vertex " + i + " is not unit length");
        return false;
      }
      i += 1;
    }
    i = 1;
    while (i < j)
    {
      if ((((S2Point)paramList.get(i - 1)).equals(paramList.get(i))) || (((S2Point)paramList.get(i - 1)).equals(S2Point.neg((S2Point)paramList.get(i)))))
      {
        log.info("Vertices " + (i - 1) + " and " + i + " are identical or antipodal");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public strictfp boolean mayIntersect(S2Cell paramS2Cell)
  {
    if (numVertices() == 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < numVertices())
      {
        if (paramS2Cell.contains(vertex(i))) {
          return true;
        }
        i += 1;
      }
      S2Point[] arrayOfS2Point = new S2Point[4];
      i = 0;
      while (i < 4)
      {
        arrayOfS2Point[i] = paramS2Cell.getVertex(i);
        i += 1;
      }
      i = 0;
      while (i < 4)
      {
        paramS2Cell = new S2EdgeUtil.EdgeCrosser(arrayOfS2Point[i], arrayOfS2Point[(i + 1 & 0x3)], vertex(0));
        int j = 1;
        while (j < numVertices())
        {
          if (paramS2Cell.robustCrossing(vertex(j)) >= 0) {
            return true;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public strictfp int numVertices()
  {
    return this.numVertices;
  }
  
  public strictfp S2Point projectToEdge(S2Point paramS2Point, int paramInt)
  {
    if (numVertices() > 0)
    {
      bool = true;
      Preconditions.checkState(bool, "Empty polyline");
      if ((numVertices() != 1) && (paramInt >= numVertices() - 1)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Invalid edge index");
      if (numVertices() != 1) {
        break label65;
      }
      return vertex(0);
      bool = false;
      break;
    }
    label65:
    return S2EdgeUtil.getClosestPoint(paramS2Point, vertex(paramInt), vertex(paramInt + 1));
  }
  
  public strictfp S2Point vertex(int paramInt)
  {
    return this.vertices[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Polyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */