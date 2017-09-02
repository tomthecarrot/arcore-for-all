package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class UncaughtExceptionHandlers
{
  public static Thread.UncaughtExceptionHandler systemExit()
  {
    return new Exiter(Runtime.getRuntime());
  }
  
  @VisibleForTesting
  static final class Exiter
    implements Thread.UncaughtExceptionHandler
  {
    private static final Logger logger = Logger.getLogger(Exiter.class.getName());
    private final Runtime runtime;
    
    Exiter(Runtime paramRuntime)
    {
      this.runtime = paramRuntime;
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      try
      {
        logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[] { paramThread }), paramThrowable);
        return;
      }
      catch (Throwable paramThread)
      {
        System.err.println(paramThrowable.getMessage());
        System.err.println(paramThread.getMessage());
        return;
      }
      finally
      {
        this.runtime.exit(1);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/UncaughtExceptionHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */