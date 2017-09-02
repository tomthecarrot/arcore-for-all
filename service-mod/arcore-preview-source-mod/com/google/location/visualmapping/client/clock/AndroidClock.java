package com.google.location.visualmapping.client.clock;

import android.os.SystemClock;

public final class AndroidClock
  implements Clock
{
  public long currentThreadTimeMillis()
  {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long elapsedRealtimeNanos()
  {
    return SystemClock.elapsedRealtimeNanos();
  }
  
  public boolean setCurrentTimeMillis(long paramLong)
  {
    return SystemClock.setCurrentTimeMillis(paramLong);
  }
  
  public void sleep(long paramLong)
  {
    SystemClock.sleep(paramLong);
  }
  
  public long uptimeMillis()
  {
    return SystemClock.uptimeMillis();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/clock/AndroidClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */