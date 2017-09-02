package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public abstract class RateLimiter
{
  private volatile Object mutexDoNotUseDirectly;
  private final SleepingStopwatch stopwatch;
  
  RateLimiter(SleepingStopwatch paramSleepingStopwatch)
  {
    this.stopwatch = ((SleepingStopwatch)Preconditions.checkNotNull(paramSleepingStopwatch));
  }
  
  private boolean canAcquire(long paramLong1, long paramLong2)
  {
    return queryEarliestAvailable(paramLong1) - paramLong2 <= paramLong1;
  }
  
  private static int checkPermits(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Requested permits (%s) must be positive", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
    }
  }
  
  public static RateLimiter create(double paramDouble)
  {
    return create(SleepingStopwatch.createFromSystemTimer(), paramDouble);
  }
  
  public static RateLimiter create(double paramDouble, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "warmupPeriod must not be negative: %s", new Object[] { Long.valueOf(paramLong) });
      return create(SleepingStopwatch.createFromSystemTimer(), paramDouble, paramLong, paramTimeUnit, 3.0D);
    }
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble)
  {
    paramSleepingStopwatch = new SmoothRateLimiter.SmoothBursty(paramSleepingStopwatch, 1.0D);
    paramSleepingStopwatch.setRate(paramDouble);
    return paramSleepingStopwatch;
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble1, long paramLong, TimeUnit paramTimeUnit, double paramDouble2)
  {
    paramSleepingStopwatch = new SmoothRateLimiter.SmoothWarmingUp(paramSleepingStopwatch, paramLong, paramTimeUnit, paramDouble2);
    paramSleepingStopwatch.setRate(paramDouble1);
    return paramSleepingStopwatch;
  }
  
  private Object mutex()
  {
    Object localObject1 = this.mutexDoNotUseDirectly;
    if (localObject1 == null)
    {
      for (;;)
      {
        try
        {
          Object localObject4 = this.mutexDoNotUseDirectly;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new Object();
          }
        }
        finally
        {
          continue;
        }
        try
        {
          this.mutexDoNotUseDirectly = localObject1;
          return localObject1;
        }
        finally {}
      }
      throw ((Throwable)localObject1);
    }
    return localObject2;
  }
  
  public double acquire()
  {
    return acquire(1);
  }
  
  public double acquire(int paramInt)
  {
    long l = reserve(paramInt);
    this.stopwatch.sleepMicrosUninterruptibly(l);
    return 1.0D * l / TimeUnit.SECONDS.toMicros(1L);
  }
  
  abstract double doGetRate();
  
  abstract void doSetRate(double paramDouble, long paramLong);
  
  public final double getRate()
  {
    synchronized (mutex())
    {
      double d = doGetRate();
      return d;
    }
  }
  
  abstract long queryEarliestAvailable(long paramLong);
  
  final long reserve(int paramInt)
  {
    checkPermits(paramInt);
    synchronized (mutex())
    {
      long l = reserveAndGetWaitLength(paramInt, this.stopwatch.readMicros());
      return l;
    }
  }
  
  final long reserveAndGetWaitLength(int paramInt, long paramLong)
  {
    return Math.max(reserveEarliestAvailable(paramInt, paramLong) - paramLong, 0L);
  }
  
  abstract long reserveEarliestAvailable(int paramInt, long paramLong);
  
  public final void setRate(double paramDouble)
  {
    if ((paramDouble > 0.0D) && (!Double.isNaN(paramDouble))) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "rate must be positive");
      synchronized (mutex())
      {
        doSetRate(paramDouble, this.stopwatch.readMicros());
        return;
      }
    }
  }
  
  public String toString()
  {
    return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(getRate()) });
  }
  
  public boolean tryAcquire()
  {
    return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt)
  {
    return tryAcquire(paramInt, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt, long paramLong, TimeUnit arg4)
  {
    paramLong = Math.max(???.toMicros(paramLong), 0L);
    checkPermits(paramInt);
    synchronized (mutex())
    {
      long l = this.stopwatch.readMicros();
      if (!canAcquire(l, paramLong)) {
        return false;
      }
      paramLong = reserveAndGetWaitLength(paramInt, l);
      this.stopwatch.sleepMicrosUninterruptibly(paramLong);
      return true;
    }
  }
  
  public boolean tryAcquire(long paramLong, TimeUnit paramTimeUnit)
  {
    return tryAcquire(1, paramLong, paramTimeUnit);
  }
  
  @VisibleForTesting
  static abstract class SleepingStopwatch
  {
    static final SleepingStopwatch createFromSystemTimer()
    {
      new SleepingStopwatch()
      {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        
        long readMicros()
        {
          return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
        }
        
        void sleepMicrosUninterruptibly(long paramAnonymousLong)
        {
          if (paramAnonymousLong > 0L) {
            Uninterruptibles.sleepUninterruptibly(paramAnonymousLong, TimeUnit.MICROSECONDS);
          }
        }
      };
    }
    
    abstract long readMicros();
    
    abstract void sleepMicrosUninterruptibly(long paramLong);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/RateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */