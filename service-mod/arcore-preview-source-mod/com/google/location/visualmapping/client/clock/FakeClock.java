package com.google.location.visualmapping.client.clock;

import android.os.SystemClock;

public final class FakeClock
  implements Clock
{
  private long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
  private long elapsedRealtime = SystemClock.elapsedRealtime();
  private long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
  private long uptimeMillis = SystemClock.uptimeMillis();
  
  public void advance(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.currentThreadTimeMillis += paramLong;
    this.elapsedRealtime += paramLong;
    this.elapsedRealtimeNanos += 1000L * paramLong;
    this.uptimeMillis += paramLong;
  }
  
  public long currentThreadTimeMillis()
  {
    return this.currentThreadTimeMillis;
  }
  
  public long elapsedRealtime()
  {
    return this.elapsedRealtime;
  }
  
  public long elapsedRealtimeNanos()
  {
    return this.elapsedRealtimeNanos;
  }
  
  public boolean setCurrentTimeMillis(long paramLong)
  {
    return true;
  }
  
  public void sleep(long paramLong) {}
  
  public long uptimeMillis()
  {
    return this.uptimeMillis;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/clock/FakeClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */