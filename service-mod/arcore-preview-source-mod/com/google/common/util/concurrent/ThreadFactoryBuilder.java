package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder
{
  private ThreadFactory backingThreadFactory = null;
  private Boolean daemon = null;
  private String nameFormat = null;
  private Integer priority = null;
  private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
  
  private static ThreadFactory build(ThreadFactoryBuilder paramThreadFactoryBuilder)
  {
    final String str = paramThreadFactoryBuilder.nameFormat;
    final Boolean localBoolean = paramThreadFactoryBuilder.daemon;
    final Integer localInteger = paramThreadFactoryBuilder.priority;
    final Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = paramThreadFactoryBuilder.uncaughtExceptionHandler;
    if (paramThreadFactoryBuilder.backingThreadFactory != null)
    {
      paramThreadFactoryBuilder = paramThreadFactoryBuilder.backingThreadFactory;
      if (str == null) {
        break label70;
      }
    }
    label70:
    for (final AtomicLong localAtomicLong = new AtomicLong(0L);; localAtomicLong = null)
    {
      new ThreadFactory()
      {
        public Thread newThread(Runnable paramAnonymousRunnable)
        {
          paramAnonymousRunnable = this.val$backingThreadFactory.newThread(paramAnonymousRunnable);
          if (str != null) {
            paramAnonymousRunnable.setName(ThreadFactoryBuilder.format(str, new Object[] { Long.valueOf(localAtomicLong.getAndIncrement()) }));
          }
          if (localBoolean != null) {
            paramAnonymousRunnable.setDaemon(localBoolean.booleanValue());
          }
          if (localInteger != null) {
            paramAnonymousRunnable.setPriority(localInteger.intValue());
          }
          if (localUncaughtExceptionHandler != null) {
            paramAnonymousRunnable.setUncaughtExceptionHandler(localUncaughtExceptionHandler);
          }
          return paramAnonymousRunnable;
        }
      };
      paramThreadFactoryBuilder = Executors.defaultThreadFactory();
      break;
    }
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public ThreadFactory build()
  {
    return build(this);
  }
  
  public ThreadFactoryBuilder setDaemon(boolean paramBoolean)
  {
    this.daemon = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public ThreadFactoryBuilder setNameFormat(String paramString)
  {
    format(paramString, new Object[] { Integer.valueOf(0) });
    this.nameFormat = paramString;
    return this;
  }
  
  public ThreadFactoryBuilder setPriority(int paramInt)
  {
    if (paramInt >= 1)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Thread priority (%s) must be >= %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1) });
      if (paramInt > 10) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Thread priority (%s) must be <= %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(10) });
      this.priority = Integer.valueOf(paramInt);
      return this;
      bool = false;
      break;
    }
  }
  
  public ThreadFactoryBuilder setThreadFactory(ThreadFactory paramThreadFactory)
  {
    this.backingThreadFactory = ((ThreadFactory)Preconditions.checkNotNull(paramThreadFactory));
    return this;
  }
  
  public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.uncaughtExceptionHandler = ((Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(paramUncaughtExceptionHandler));
    return this;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/ThreadFactoryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */