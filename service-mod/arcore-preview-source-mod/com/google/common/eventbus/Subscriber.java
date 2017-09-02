package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

class Subscriber
{
  @Weak
  private EventBus bus;
  private final Executor executor;
  private final Method method;
  @VisibleForTesting
  final Object target;
  
  private Subscriber(EventBus paramEventBus, Object paramObject, Method paramMethod)
  {
    this.bus = paramEventBus;
    this.target = Preconditions.checkNotNull(paramObject);
    this.method = paramMethod;
    paramMethod.setAccessible(true);
    this.executor = paramEventBus.executor();
  }
  
  private SubscriberExceptionContext context(Object paramObject)
  {
    return new SubscriberExceptionContext(this.bus, paramObject, this.target, this.method);
  }
  
  static Subscriber create(EventBus paramEventBus, Object paramObject, Method paramMethod)
  {
    if (isDeclaredThreadSafe(paramMethod)) {
      return new Subscriber(paramEventBus, paramObject, paramMethod);
    }
    return new SynchronizedSubscriber(paramEventBus, paramObject, paramMethod, null);
  }
  
  private static boolean isDeclaredThreadSafe(Method paramMethod)
  {
    return paramMethod.getAnnotation(AllowConcurrentEvents.class) != null;
  }
  
  final void dispatchEvent(final Object paramObject)
  {
    this.executor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Subscriber.this.invokeSubscriberMethod(paramObject);
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Subscriber.this.bus.handleSubscriberException(localInvocationTargetException.getCause(), Subscriber.this.context(paramObject));
        }
      }
    });
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Subscriber))
    {
      paramObject = (Subscriber)paramObject;
      bool1 = bool2;
      if (this.target == ((Subscriber)paramObject).target)
      {
        bool1 = bool2;
        if (this.method.equals(((Subscriber)paramObject).method)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return (this.method.hashCode() + 31) * 31 + System.identityHashCode(this.target);
  }
  
  @VisibleForTesting
  void invokeSubscriberMethod(Object paramObject)
    throws InvocationTargetException
  {
    try
    {
      this.method.invoke(this.target, new Object[] { Preconditions.checkNotNull(paramObject) });
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new Error("Method rejected target/argument: " + paramObject, localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new Error("Method became inaccessible: " + paramObject, localIllegalAccessException);
    }
    catch (InvocationTargetException paramObject)
    {
      if ((((InvocationTargetException)paramObject).getCause() instanceof Error)) {
        throw ((Error)((InvocationTargetException)paramObject).getCause());
      }
      throw ((Throwable)paramObject);
    }
  }
  
  @VisibleForTesting
  static final class SynchronizedSubscriber
    extends Subscriber
  {
    private SynchronizedSubscriber(EventBus paramEventBus, Object paramObject, Method paramMethod)
    {
      super(paramObject, paramMethod, null);
    }
    
    void invokeSubscriberMethod(Object paramObject)
      throws InvocationTargetException
    {
      try
      {
        super.invokeSubscriberMethod(paramObject);
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */