package io.grpc;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Deadline
  implements Comparable<Deadline>
{
  private static final long MAX_OFFSET = TimeUnit.DAYS.toNanos(36500L);
  private static final long MIN_OFFSET = -MAX_OFFSET;
  private static final SystemTicker SYSTEM_TICKER = new SystemTicker(null);
  private final long deadlineNanos;
  private volatile boolean expired;
  private final Ticker ticker;
  
  private Deadline(Ticker paramTicker, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.ticker = paramTicker;
    paramLong2 = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, paramLong2));
    this.deadlineNanos = (paramLong1 + paramLong2);
    if ((paramBoolean) && (paramLong2 <= 0L)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.expired = paramBoolean;
      return;
    }
  }
  
  private Deadline(Ticker paramTicker, long paramLong, boolean paramBoolean)
  {
    this(paramTicker, paramTicker.read(), paramLong, paramBoolean);
  }
  
  public static Deadline after(long paramLong, TimeUnit paramTimeUnit)
  {
    return after(paramLong, paramTimeUnit, SYSTEM_TICKER);
  }
  
  static Deadline after(long paramLong, TimeUnit paramTimeUnit, Ticker paramTicker)
  {
    checkNotNull(paramTimeUnit, "units");
    return new Deadline(paramTicker, paramTimeUnit.toNanos(paramLong), true);
  }
  
  private static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public int compareTo(Deadline paramDeadline)
  {
    long l = this.deadlineNanos - paramDeadline.deadlineNanos;
    if (l < 0L) {
      return -1;
    }
    if (l > 0L) {
      return 1;
    }
    return 0;
  }
  
  public boolean isBefore(Deadline paramDeadline)
  {
    return this.deadlineNanos - paramDeadline.deadlineNanos < 0L;
  }
  
  public boolean isExpired()
  {
    if (!this.expired)
    {
      if (this.deadlineNanos - this.ticker.read() <= 0L) {
        this.expired = true;
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public Deadline minimum(Deadline paramDeadline)
  {
    if (isBefore(paramDeadline)) {
      return this;
    }
    return paramDeadline;
  }
  
  public Deadline offset(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong == 0L) {
      return this;
    }
    return new Deadline(this.ticker, this.deadlineNanos, paramTimeUnit.toNanos(paramLong), isExpired());
  }
  
  public ScheduledFuture<?> runOnExpiration(Runnable paramRunnable, ScheduledExecutorService paramScheduledExecutorService)
  {
    checkNotNull(paramRunnable, "task");
    checkNotNull(paramScheduledExecutorService, "scheduler");
    return paramScheduledExecutorService.schedule(paramRunnable, this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
  }
  
  public long timeRemaining(TimeUnit paramTimeUnit)
  {
    long l = this.ticker.read();
    if ((!this.expired) && (this.deadlineNanos - l <= 0L)) {
      this.expired = true;
    }
    return paramTimeUnit.convert(this.deadlineNanos - l, TimeUnit.NANOSECONDS);
  }
  
  public String toString()
  {
    return timeRemaining(TimeUnit.NANOSECONDS) + " ns from now";
  }
  
  private static class SystemTicker
    extends Deadline.Ticker
  {
    public long read()
    {
      return System.nanoTime();
    }
  }
  
  static abstract class Ticker
  {
    public abstract long read();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Deadline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */