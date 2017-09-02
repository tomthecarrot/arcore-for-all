package io.grpc.internal;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ObjectPool<T>
{
  public abstract T getObject();
  
  public abstract T returnObject(Object paramObject);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */