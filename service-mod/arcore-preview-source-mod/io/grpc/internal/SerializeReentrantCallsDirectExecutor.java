package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerializeReentrantCallsDirectExecutor
  implements Executor
{
  private static final Logger log = Logger.getLogger(SerializeReentrantCallsDirectExecutor.class.getName());
  private boolean executing;
  private ArrayDeque<Runnable> taskQueue;
  
  private void completeQueuedTasks()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.taskQueue.poll();
      if (localRunnable == null) {
        break;
      }
      try
      {
        localRunnable.run();
      }
      catch (Throwable localThrowable)
      {
        log.log(Level.SEVERE, "Exception while executing runnable " + localRunnable, localThrowable);
      }
    }
  }
  
  private void enqueue(Runnable paramRunnable)
  {
    if (this.taskQueue == null) {
      this.taskQueue = new ArrayDeque(4);
    }
    this.taskQueue.add(paramRunnable);
  }
  
  public void execute(Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramRunnable, "'task' must not be null.");
    if (!this.executing)
    {
      this.executing = true;
      try
      {
        paramRunnable.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        log.log(Level.SEVERE, "Exception while executing runnable " + paramRunnable, localThrowable);
        return;
      }
      finally
      {
        if (this.taskQueue != null) {
          completeQueuedTasks();
        }
        this.executing = false;
      }
    }
    enqueue(paramRunnable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/SerializeReentrantCallsDirectExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */