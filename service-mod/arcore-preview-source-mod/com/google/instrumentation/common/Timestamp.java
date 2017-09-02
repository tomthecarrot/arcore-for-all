package com.google.instrumentation.common;

public class Timestamp
{
  private static final int MAX_NANOS = 999999999;
  private static final long MAX_SECONDS = 315576000000L;
  private static final long NUM_MILLIS_PER_SECOND = 1000L;
  private static final int NUM_NANOS_PER_MILLI = 1000000;
  private final int nanos;
  private final long seconds;
  
  private Timestamp(long paramLong, int paramInt)
  {
    this.seconds = paramLong;
    this.nanos = paramInt;
  }
  
  public static Timestamp create(long paramLong, int paramInt)
  {
    if ((paramLong < -315576000000L) || (paramLong > 315576000000L)) {
      return new Timestamp(0L, 0);
    }
    if ((paramInt < 0) || (paramInt > 999999999)) {
      return new Timestamp(0L, 0);
    }
    return new Timestamp(paramLong, paramInt);
  }
  
  public static Timestamp fromMillis(long paramLong)
  {
    long l = paramLong / 1000L;
    int i = 1000000 * (int)(paramLong % 1000L);
    if (i < 0) {
      return new Timestamp(l - 1L, i + 999999999 + 1);
    }
    return new Timestamp(l, i);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Timestamp)) {
        return false;
      }
      paramObject = (Timestamp)paramObject;
    } while ((this.seconds == ((Timestamp)paramObject).seconds) && (this.nanos == ((Timestamp)paramObject).nanos));
    return false;
  }
  
  public int getNanos()
  {
    return this.nanos;
  }
  
  public long getSeconds()
  {
    return this.seconds;
  }
  
  public int hashCode()
  {
    return ((int)(this.seconds ^ this.seconds >>> 32) + 527) * 31 + this.nanos;
  }
  
  public String toString()
  {
    return "Timestamp<" + this.seconds + "," + this.nanos + ">";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/common/Timestamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */