package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class SharedResourceHolder
{
  static final long DESTROY_DELAY_SECONDS = 1L;
  private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory()
  {
    public ScheduledExecutorService createScheduledExecutor()
    {
      return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
    }
  });
  private ScheduledExecutorService destroyer;
  private final ScheduledExecutorFactory destroyerFactory;
  private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap();
  
  SharedResourceHolder(ScheduledExecutorFactory paramScheduledExecutorFactory)
  {
    this.destroyerFactory = paramScheduledExecutorFactory;
  }
  
  public static <T> T get(Resource<T> paramResource)
  {
    return (T)holder.getInternal(paramResource);
  }
  
  public static <T> T release(Resource<T> paramResource, T paramT)
  {
    return (T)holder.releaseInternal(paramResource, paramT);
  }
  
  <T> T getInternal(Resource<T> paramResource)
  {
    try
    {
      Instance localInstance2 = (Instance)this.instances.get(paramResource);
      Instance localInstance1 = localInstance2;
      if (localInstance2 == null)
      {
        localInstance1 = new Instance(paramResource.create());
        this.instances.put(paramResource, localInstance1);
      }
      if (localInstance1.destroyTask != null)
      {
        localInstance1.destroyTask.cancel(false);
        localInstance1.destroyTask = null;
      }
      localInstance1.refcount += 1;
      paramResource = localInstance1.payload;
      return paramResource;
    }
    finally {}
  }
  
  <T> T releaseInternal(final Resource<T> paramResource, final T paramT)
  {
    boolean bool2 = true;
    final Instance localInstance;
    try
    {
      localInstance = (Instance)this.instances.get(paramResource);
      if (localInstance == null) {
        throw new IllegalArgumentException("No cached instance found for " + paramResource);
      }
    }
    finally {}
    if (paramT == localInstance.payload)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Releasing the wrong instance");
      if (localInstance.refcount <= 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Refcount has already reached zero");
      localInstance.refcount -= 1;
      if (localInstance.refcount == 0)
      {
        if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
          break label144;
        }
        paramResource.close(paramT);
        this.instances.remove(paramResource);
      }
      return null;
      bool1 = false;
      break;
    }
    label144:
    if (localInstance.destroyTask == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Destroy task already scheduled");
      if (this.destroyer == null) {
        this.destroyer = this.destroyerFactory.createScheduledExecutor();
      }
      localInstance.destroyTask = this.destroyer.schedule(new LogExceptionRunnable(new Runnable()
      {
        public void run()
        {
          synchronized (SharedResourceHolder.this)
          {
            if (localInstance.refcount == 0)
            {
              paramResource.close(paramT);
              SharedResourceHolder.this.instances.remove(paramResource);
              if (SharedResourceHolder.this.instances.isEmpty())
              {
                SharedResourceHolder.this.destroyer.shutdown();
                SharedResourceHolder.access$102(SharedResourceHolder.this, null);
              }
            }
            return;
          }
        }
      }), 1L, TimeUnit.SECONDS);
      break;
    }
  }
  
  private static class Instance
  {
    ScheduledFuture<?> destroyTask;
    final Object payload;
    int refcount;
    
    Instance(Object paramObject)
    {
      this.payload = paramObject;
    }
  }
  
  public static abstract interface Resource<T>
  {
    public abstract void close(T paramT);
    
    public abstract T create();
  }
  
  static abstract interface ScheduledExecutorFactory
  {
    public abstract ScheduledExecutorService createScheduledExecutor();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/SharedResourceHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */