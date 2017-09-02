package com.google.common.geometry;

public abstract interface S2Region
{
  public abstract boolean contains(S2Cell paramS2Cell);
  
  public abstract S2Cap getCapBound();
  
  public abstract S2LatLngRect getRectBound();
  
  public abstract boolean mayIntersect(S2Cell paramS2Cell);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Region.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */