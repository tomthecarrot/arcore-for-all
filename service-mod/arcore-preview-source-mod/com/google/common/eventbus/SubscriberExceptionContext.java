package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

public class SubscriberExceptionContext
{
  private final Object event;
  private final EventBus eventBus;
  private final Object subscriber;
  private final Method subscriberMethod;
  
  SubscriberExceptionContext(EventBus paramEventBus, Object paramObject1, Object paramObject2, Method paramMethod)
  {
    this.eventBus = ((EventBus)Preconditions.checkNotNull(paramEventBus));
    this.event = Preconditions.checkNotNull(paramObject1);
    this.subscriber = Preconditions.checkNotNull(paramObject2);
    this.subscriberMethod = ((Method)Preconditions.checkNotNull(paramMethod));
  }
  
  public Object getEvent()
  {
    return this.event;
  }
  
  public EventBus getEventBus()
  {
    return this.eventBus;
  }
  
  public Object getSubscriber()
  {
    return this.subscriber;
  }
  
  public Method getSubscriberMethod()
  {
    return this.subscriberMethod;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/SubscriberExceptionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */