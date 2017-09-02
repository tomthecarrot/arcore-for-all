package com.google.location.visualmapping.client.clock;

public abstract interface Clock
{
  public abstract long currentThreadTimeMillis();
  
  public abstract long elapsedRealtime();
  
  public abstract long elapsedRealtimeNanos();
  
  public abstract boolean setCurrentTimeMillis(long paramLong);
  
  public abstract void sleep(long paramLong);
  
  public abstract long uptimeMillis();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/clock/Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */