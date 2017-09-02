package com.google.common.geometry;

public final class S2Edge
{
  private final S2Point end;
  private final S2Point start;
  
  public S2Edge(S2Point paramS2Point1, S2Point paramS2Point2)
  {
    this.start = paramS2Point1;
    this.end = paramS2Point2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof S2Edge))) {}
    do
    {
      return false;
      paramObject = (S2Edge)paramObject;
    } while ((!getStart().equals(((S2Edge)paramObject).getStart())) || (!getEnd().equals(((S2Edge)paramObject).getEnd())));
    return true;
  }
  
  public S2Point getEnd()
  {
    return this.end;
  }
  
  public S2Point getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    return getStart().hashCode() - getEnd().hashCode();
  }
  
  public String toString()
  {
    return String.format("Edge: (%s -> %s)\n   or [%s -> %s]", new Object[] { this.start.toDegreesString(), this.end.toDegreesString(), this.start, this.end });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/geometry/S2Edge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */