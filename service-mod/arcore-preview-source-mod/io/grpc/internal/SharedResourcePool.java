package io.grpc.internal;

public final class SharedResourcePool<T>
  implements ObjectPool<T>
{
  private final SharedResourceHolder.Resource<T> resource;
  
  private SharedResourcePool(SharedResourceHolder.Resource<T> paramResource)
  {
    this.resource = paramResource;
  }
  
  public static <T> SharedResourcePool<T> forResource(SharedResourceHolder.Resource<T> paramResource)
  {
    return new SharedResourcePool(paramResource);
  }
  
  public T getObject()
  {
    return (T)SharedResourceHolder.get(this.resource);
  }
  
  public T returnObject(Object paramObject)
  {
    SharedResourceHolder.release(this.resource, paramObject);
    return null;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/SharedResourcePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */