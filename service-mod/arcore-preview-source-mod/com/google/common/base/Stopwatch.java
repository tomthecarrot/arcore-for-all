package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=true)
public final class Stopwatch
{
  private long elapsedNanos;
  private boolean isRunning;
  private long startTick;
  private final Ticker ticker;
  
  Stopwatch()
  {
    this.ticker = Ticker.systemTicker();
  }
  
  Stopwatch(Ticker paramTicker)
  {
    this.ticker = ((Ticker)Preconditions.checkNotNull(paramTicker, "ticker"));
  }
  
  private static String abbreviate(TimeUnit paramTimeUnit)
  {
    switch (paramTimeUnit)
    {
    default: 
      throw new AssertionError();
    case ???: 
      return "ns";
    case ???: 
      return "μs";
    case ???: 
      return "ms";
    case ???: 
      return "s";
    case ???: 
      return "min";
    case ???: 
      return "h";
    }
    return "d";
  }
  
  private static TimeUnit chooseUnit(long paramLong)
  {
    if (TimeUnit.DAYS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.DAYS;
    }
    if (TimeUnit.HOURS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.HOURS;
    }
    if (TimeUnit.MINUTES.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MINUTES;
    }
    if (TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.SECONDS;
    }
    if (TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MILLISECONDS;
    }
    if (TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MICROSECONDS;
    }
    return TimeUnit.NANOSECONDS;
  }
  
  @CheckReturnValue
  public static Stopwatch createStarted()
  {
    return new Stopwatch().start();
  }
  
  @CheckReturnValue
  public static Stopwatch createStarted(Ticker paramTicker)
  {
    return new Stopwatch(paramTicker).start();
  }
  
  @CheckReturnValue
  public static Stopwatch createUnstarted()
  {
    return new Stopwatch();
  }
  
  @CheckReturnValue
  public static Stopwatch createUnstarted(Ticker paramTicker)
  {
    return new Stopwatch(paramTicker);
  }
  
  private long elapsedNanos()
  {
    if (this.isRunning) {
      return this.ticker.read() - this.startTick + this.elapsedNanos;
    }
    return this.elapsedNanos;
  }
  
  @CheckReturnValue
  public long elapsed(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }
  
  @CheckReturnValue
  public boolean isRunning()
  {
    return this.isRunning;
  }
  
  public Stopwatch reset()
  {
    this.elapsedNanos = 0L;
    this.isRunning = false;
    return this;
  }
  
  public Stopwatch start()
  {
    if (!this.isRunning) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "This stopwatch is already running.");
      this.isRunning = true;
      this.startTick = this.ticker.read();
      return this;
    }
  }
  
  public Stopwatch stop()
  {
    long l = this.ticker.read();
    Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
    this.isRunning = false;
    this.elapsedNanos += l - this.startTick;
    return this;
  }
  
  @GwtIncompatible("String.format()")
  public String toString()
  {
    long l = elapsedNanos();
    TimeUnit localTimeUnit = chooseUnit(l);
    double d = l / TimeUnit.NANOSECONDS.convert(1L, localTimeUnit);
    return String.format(Locale.ROOT, "%.4g %s", new Object[] { Double.valueOf(d), abbreviate(localTimeUnit) });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Stopwatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */