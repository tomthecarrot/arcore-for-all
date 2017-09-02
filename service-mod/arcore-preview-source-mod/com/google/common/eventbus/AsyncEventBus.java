package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public class AsyncEventBus
  extends EventBus
{
  public AsyncEventBus(String paramString, Executor paramExecutor)
  {
    super(paramString, paramExecutor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
  }
  
  public AsyncEventBus(Executor paramExecutor)
  {
    super("default", paramExecutor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
  }
  
  public AsyncEventBus(Executor paramExecutor, SubscriberExceptionHandler paramSubscriberExceptionHandler)
  {
    super("default", paramExecutor, Dispatcher.legacyAsync(), paramSubscriberExceptionHandler);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/AsyncEventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */