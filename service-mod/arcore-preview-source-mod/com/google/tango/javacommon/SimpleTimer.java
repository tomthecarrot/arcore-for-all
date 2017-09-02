package com.google.tango.javacommon;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class SimpleTimer
{
  private static final double NANOS_TO_MILLIS = 1.0D / TimeUnit.MILLISECONDS.toNanos(1L);
  private static final double NANOS_TO_SECONDS = 1.0D / TimeUnit.SECONDS.toNanos(1L);
  private long mStartNanos = 0L;
  
  public static SimpleTimer startNew()
  {
    SimpleTimer localSimpleTimer = new SimpleTimer();
    localSimpleTimer.restart();
    return localSimpleTimer;
  }
  
  public long elapsedMillis()
  {
    return (elapsedNanos() * NANOS_TO_MILLIS);
  }
  
  public long elapsedNanos()
  {
    return SystemClock.elapsedRealtimeNanos() - this.mStartNanos;
  }
  
  public double elapsedSeconds()
  {
    return elapsedNanos() * NANOS_TO_SECONDS;
  }
  
  public long getStartNanos()
  {
    return this.mStartNanos;
  }
  
  public void restart()
  {
    this.mStartNanos = SystemClock.elapsedRealtimeNanos();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/javacommon/SimpleTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */