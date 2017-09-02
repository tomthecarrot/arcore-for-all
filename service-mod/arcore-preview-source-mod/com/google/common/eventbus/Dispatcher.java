package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher
{
  static Dispatcher immediate()
  {
    return ImmediateDispatcher.INSTANCE;
  }
  
  static Dispatcher legacyAsync()
  {
    return new LegacyAsyncDispatcher(null);
  }
  
  static Dispatcher perThreadDispatchQueue()
  {
    return new PerThreadQueuedDispatcher(null);
  }
  
  abstract void dispatch(Object paramObject, Iterator<Subscriber> paramIterator);
  
  private static final class ImmediateDispatcher
    extends Dispatcher
  {
    private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      while (paramIterator.hasNext()) {
        ((Subscriber)paramIterator.next()).dispatchEvent(paramObject);
      }
    }
  }
  
  private static final class LegacyAsyncDispatcher
    extends Dispatcher
  {
    private final ConcurrentLinkedQueue<EventWithSubscriber> queue = Queues.newConcurrentLinkedQueue();
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      while (paramIterator.hasNext()) {
        this.queue.add(new EventWithSubscriber(paramObject, (Subscriber)paramIterator.next(), null));
      }
      for (;;)
      {
        paramObject = (EventWithSubscriber)this.queue.poll();
        if (paramObject == null) {
          break;
        }
        ((EventWithSubscriber)paramObject).subscriber.dispatchEvent(((EventWithSubscriber)paramObject).event);
      }
    }
    
    private static final class EventWithSubscriber
    {
      private final Object event;
      private final Subscriber subscriber;
      
      private EventWithSubscriber(Object paramObject, Subscriber paramSubscriber)
      {
        this.event = paramObject;
        this.subscriber = paramSubscriber;
      }
    }
  }
  
  private static final class PerThreadQueuedDispatcher
    extends Dispatcher
  {
    private final ThreadLocal<Boolean> dispatching = new ThreadLocal()
    {
      protected Boolean initialValue()
      {
        return Boolean.valueOf(false);
      }
    };
    private final ThreadLocal<Queue<Event>> queue = new ThreadLocal()
    {
      protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> initialValue()
      {
        return Queues.newArrayDeque();
      }
    };
    
    void dispatch(Object paramObject, Iterator<Subscriber> paramIterator)
    {
      Preconditions.checkNotNull(paramObject);
      Preconditions.checkNotNull(paramIterator);
      Queue localQueue = (Queue)this.queue.get();
      localQueue.offer(new Event(paramObject, paramIterator, null));
      if (!((Boolean)this.dispatching.get()).booleanValue())
      {
        this.dispatching.set(Boolean.valueOf(true));
        try
        {
          paramObject = (Event)localQueue.poll();
          if (paramObject != null) {
            while (((Event)paramObject).subscribers.hasNext()) {
              ((Subscriber)((Event)paramObject).subscribers.next()).dispatchEvent(((Event)paramObject).event);
            }
          }
          this.dispatching.remove();
        }
        finally
        {
          this.dispatching.remove();
          this.queue.remove();
        }
        this.queue.remove();
      }
    }
    
    private static final class Event
    {
      private final Object event;
      private final Iterator<Subscriber> subscribers;
      
      private Event(Object paramObject, Iterator<Subscriber> paramIterator)
      {
        this.event = paramObject;
        this.subscribers = paramIterator;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */