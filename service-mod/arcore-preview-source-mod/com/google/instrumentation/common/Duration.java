package com.google.instrumentation.common;

public class Duration
{
  private static final int MAX_NANOS = 999999999;
  private static final long MAX_SECONDS = 315576000000L;
  private static final long NUM_MILLIS_PER_SECOND = 1000L;
  private static final int NUM_NANOS_PER_MILLI = 1000000;
  private final int nanos;
  private final long seconds;
  
  private Duration(long paramLong, int paramInt)
  {
    this.seconds = paramLong;
    this.nanos = paramInt;
  }
  
  public static Duration create(long paramLong, int paramInt)
  {
    if ((paramLong < -315576000000L) || (paramLong > 315576000000L)) {
      return new Duration(0L, 0);
    }
    if ((paramInt < -999999999) || (paramInt > 999999999)) {
      return new Duration(0L, 0);
    }
    if (((paramLong < 0L) && (paramInt > 0)) || ((paramLong > 0L) && (paramInt < 0))) {
      return new Duration(0L, 0);
    }
    return new Duration(paramLong, paramInt);
  }
  
  public static Duration fromMillis(long paramLong)
  {
    return new Duration(paramLong / 1000L, (int)(paramLong % 1000L) * 1000000);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Duration)) {
        return false;
      }
      paramObject = (Duration)paramObject;
    } while ((this.seconds == ((Duration)paramObject).seconds) && (this.nanos == ((Duration)paramObject).nanos));
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
    return "Duration<" + this.seconds + "," + this.nanos + ">";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/common/Duration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */