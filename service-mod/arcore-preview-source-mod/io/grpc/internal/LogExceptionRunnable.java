package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogExceptionRunnable
  implements Runnable
{
  private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
  private final Runnable task;
  
  public LogExceptionRunnable(Runnable paramRunnable)
  {
    this.task = ((Runnable)Preconditions.checkNotNull(paramRunnable, "task"));
  }
  
  public void run()
  {
    try
    {
      this.task.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      log.log(Level.SEVERE, "Exception while executing runnable " + this.task, localThrowable);
      MoreThrowables.throwIfUnchecked(localThrowable);
      throw new AssertionError(localThrowable);
    }
  }
  
  public String toString()
  {
    return "LogExceptionRunnable(" + this.task + ")";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/LogExceptionRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */