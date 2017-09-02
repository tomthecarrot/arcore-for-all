package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;

final class ExponentialBackoffPolicy
  implements BackoffPolicy
{
  private long initialBackoffMillis = TimeUnit.SECONDS.toMillis(1L);
  private double jitter = 0.2D;
  private long maxBackoffMillis = TimeUnit.MINUTES.toMillis(2L);
  private double multiplier = 1.6D;
  private long nextBackoffMillis = this.initialBackoffMillis;
  private Random random = new Random();
  
  private long uniformRandom(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 >= paramDouble1) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return (this.random.nextDouble() * (paramDouble2 - paramDouble1) + paramDouble1);
    }
  }
  
  public long nextBackoffMillis()
  {
    long l = this.nextBackoffMillis;
    this.nextBackoffMillis = Math.min((l * this.multiplier), this.maxBackoffMillis);
    return uniformRandom(-this.jitter * l, this.jitter * l) + l;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setInitialBackoffMillis(long paramLong)
  {
    this.initialBackoffMillis = paramLong;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setJitter(double paramDouble)
  {
    this.jitter = paramDouble;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setMaxBackoffMillis(long paramLong)
  {
    this.maxBackoffMillis = paramLong;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setMultiplier(double paramDouble)
  {
    this.multiplier = paramDouble;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setRandom(Random paramRandom)
  {
    this.random = paramRandom;
    return this;
  }
  
  static final class Provider
    implements BackoffPolicy.Provider
  {
    public BackoffPolicy get()
    {
      return new ExponentialBackoffPolicy();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ExponentialBackoffPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */