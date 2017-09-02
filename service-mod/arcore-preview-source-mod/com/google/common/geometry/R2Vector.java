package com.google.common.geometry;

public final class R2Vector
{
  private final double x;
  private final double y;
  
  public strictfp R2Vector()
  {
    this(0.0D, 0.0D);
  }
  
  public strictfp R2Vector(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public strictfp R2Vector(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length != 2) {
      throw new IllegalStateException("Points must have exactly 2 coordinates");
    }
    this.x = paramArrayOfDouble[0];
    this.y = paramArrayOfDouble[1];
  }
  
  public static strictfp R2Vector add(R2Vector paramR2Vector1, R2Vector paramR2Vector2)
  {
    return new R2Vector(paramR2Vector1.x + paramR2Vector2.x, paramR2Vector1.y + paramR2Vector2.y);
  }
  
  public static strictfp double dotProd(R2Vector paramR2Vector1, R2Vector paramR2Vector2)
  {
    return paramR2Vector1.x * paramR2Vector2.x + paramR2Vector1.y * paramR2Vector2.y;
  }
  
  public static strictfp R2Vector mul(R2Vector paramR2Vector, double paramDouble)
  {
    return new R2Vector(paramR2Vector.x * paramDouble, paramR2Vector.y * paramDouble);
  }
  
  public strictfp double crossProd(R2Vector paramR2Vector)
  {
    return this.x * paramR2Vector.y - this.y * paramR2Vector.x;
  }
  
  public strictfp double dotProd(R2Vector paramR2Vector)
  {
    return dotProd(this, paramR2Vector);
  }
  
  public strictfp boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof R2Vector)) {}
    do
    {
      return false;
      paramObject = (R2Vector)paramObject;
    } while ((this.x != ((R2Vector)paramObject).x) || (this.y != ((R2Vector)paramObject).y));
    return true;
  }
  
  public strictfp double get(int paramInt)
  {
    if (paramInt > 1) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    if (paramInt == 0) {
      return this.x;
    }
    return this.y;
  }
  
  public strictfp int hashCode()
  {
    long l = 17L + (37L * 17L + Double.doubleToLongBits(Math.abs(this.x)));
    l += 37L * l + Double.doubleToLongBits(Math.abs(this.y));
    return (int)(l >>> 32 ^ l);
  }
  
  public strictfp boolean lessThan(R2Vector paramR2Vector)
  {
    if (this.x < paramR2Vector.x) {}
    do
    {
      return true;
      if (paramR2Vector.x < this.x) {
        return false;
      }
    } while (this.y < paramR2Vector.y);
    return false;
  }
  
  public strictfp double norm2()
  {
    return this.x * this.x + this.y * this.y;
  }
  
  public strictfp String toString()
  {
    return "(" + this.x + ", " + this.y + ")";
  }
  
  public strictfp double x()
  {
    return this.x;
  }
  
  public strictfp double y()
  {
    return this.y;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/R2Vector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */