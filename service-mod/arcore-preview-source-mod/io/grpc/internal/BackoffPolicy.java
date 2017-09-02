package io.grpc.internal;

abstract interface BackoffPolicy
{
  public abstract long nextBackoffMillis();
  
  public static abstract interface Provider
  {
    public abstract BackoffPolicy get();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/BackoffPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */