package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus
{
  private static final Logger logger = Logger.getLogger(EventBus.class.getName());
  private final Dispatcher dispatcher;
  private final SubscriberExceptionHandler exceptionHandler;
  private final Executor executor;
  private final String identifier;
  private final SubscriberRegistry subscribers = new SubscriberRegistry(this);
  
  public EventBus()
  {
    this("default");
  }
  
  public EventBus(SubscriberExceptionHandler paramSubscriberExceptionHandler)
  {
    this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), paramSubscriberExceptionHandler);
  }
  
  public EventBus(String paramString)
  {
    this(paramString, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
  }
  
  EventBus(String paramString, Executor paramExecutor, Dispatcher paramDispatcher, SubscriberExceptionHandler paramSubscriberExceptionHandler)
  {
    this.identifier = ((String)Preconditions.checkNotNull(paramString));
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.dispatcher = ((Dispatcher)Preconditions.checkNotNull(paramDispatcher));
    this.exceptionHandler = ((SubscriberExceptionHandler)Preconditions.checkNotNull(paramSubscriberExceptionHandler));
  }
  
  final Executor executor()
  {
    return this.executor;
  }
  
  void handleSubscriberException(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext)
  {
    Preconditions.checkNotNull(paramThrowable);
    Preconditions.checkNotNull(paramSubscriberExceptionContext);
    try
    {
      this.exceptionHandler.handleException(paramThrowable, paramSubscriberExceptionContext);
      return;
    }
    catch (Throwable paramSubscriberExceptionContext)
    {
      logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[] { paramSubscriberExceptionContext, paramThrowable }), paramSubscriberExceptionContext);
    }
  }
  
  public final String identifier()
  {
    return this.identifier;
  }
  
  public void post(Object paramObject)
  {
    Iterator localIterator = this.subscribers.getSubscribers(paramObject);
    if (localIterator.hasNext()) {
      this.dispatcher.dispatch(paramObject, localIterator);
    }
    while ((paramObject instanceof DeadEvent)) {
      return;
    }
    post(new DeadEvent(this, paramObject));
  }
  
  public void register(Object paramObject)
  {
    this.subscribers.register(paramObject);
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
  }
  
  public void unregister(Object paramObject)
  {
    this.subscribers.unregister(paramObject);
  }
  
  static final class LoggingHandler
    implements SubscriberExceptionHandler
  {
    static final LoggingHandler INSTANCE = new LoggingHandler();
    
    private static Logger logger(SubscriberExceptionContext paramSubscriberExceptionContext)
    {
      return Logger.getLogger(EventBus.class.getName() + "." + paramSubscriberExceptionContext.getEventBus().identifier());
    }
    
    private static String message(SubscriberExceptionContext paramSubscriberExceptionContext)
    {
      Method localMethod = paramSubscriberExceptionContext.getSubscriberMethod();
      return "Exception thrown by subscriber method " + localMethod.getName() + '(' + localMethod.getParameterTypes()[0].getName() + ')' + " on subscriber " + paramSubscriberExceptionContext.getSubscriber() + " when dispatching event: " + paramSubscriberExceptionContext.getEvent();
    }
    
    public void handleException(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext)
    {
      Logger localLogger = logger(paramSubscriberExceptionContext);
      if (localLogger.isLoggable(Level.SEVERE)) {
        localLogger.log(Level.SEVERE, message(paramSubscriberExceptionContext), paramThrowable);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */