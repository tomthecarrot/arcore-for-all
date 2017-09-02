package com.google.common.eventbus;

public abstract interface SubscriberExceptionHandler
{
  public abstract void handleException(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/eventbus/SubscriberExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */