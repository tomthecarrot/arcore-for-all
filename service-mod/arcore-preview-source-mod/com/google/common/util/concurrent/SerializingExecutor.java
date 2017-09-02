package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class SerializingExecutor
  implements Executor
{
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  private final Executor executor;
  private final Object internalLock = new Object();
  @GuardedBy("internalLock")
  private boolean isWorkerRunning = false;
  @GuardedBy("internalLock")
  private final Deque<Runnable> queue = new ArrayDeque();
  @GuardedBy("internalLock")
  private int suspensions = 0;
  
  public SerializingExecutor(Executor paramExecutor)
  {
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  private void startQueueWorker()
  {
    synchronized (this.internalLock)
    {
      if (this.queue.peek() == null) {
        return;
      }
      if (this.suspensions > 0) {
        return;
      }
    }
    if (this.isWorkerRunning) {
      return;
    }
    this.isWorkerRunning = true;
    try
    {
      this.executor.execute(new QueueWorker(null));
      if (0 != 0) {
        synchronized (this.internalLock)
        {
          this.isWorkerRunning = false;
          return;
        }
      }
      return;
    }
    finally
    {
      if (1 == 0) {}
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    synchronized (this.internalLock)
    {
      this.queue.add(paramRunnable);
      startQueueWorker();
      return;
    }
  }
  
  public void executeFirst(Runnable paramRunnable)
  {
    synchronized (this.internalLock)
    {
      this.queue.addFirst(paramRunnable);
      startQueueWorker();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.internalLock)
    {
      if (this.suspensions > 0)
      {
        bool = true;
        Preconditions.checkState(bool);
        this.suspensions -= 1;
        startQueueWorker();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void suspend()
  {
    synchronized (this.internalLock)
    {
      this.suspensions += 1;
      return;
    }
  }
  
  private final class QueueWorker
    implements Runnable
  {
    private QueueWorker() {}
    
    private void workOnQueue()
    {
      for (;;)
      {
        Runnable localRunnable = null;
        synchronized (SerializingExecutor.this.internalLock)
        {
          if (SerializingExecutor.this.suspensions == 0) {
            localRunnable = (Runnable)SerializingExecutor.this.queue.poll();
          }
          if (localRunnable == null)
          {
            SerializingExecutor.access$202(SerializingExecutor.this, false);
            return;
          }
          try
          {
            localRunnable.run();
          }
          catch (RuntimeException localRuntimeException)
          {
            SerializingExecutor.log.log(Level.SEVERE, "Exception while executing runnable " + localRunnable, localRuntimeException);
          }
        }
      }
    }
    
    public void run()
    {
      try
      {
        workOnQueue();
        return;
      }
      catch (Error localError)
      {
        synchronized (SerializingExecutor.this.internalLock)
        {
          SerializingExecutor.access$202(SerializingExecutor.this, false);
          throw localError;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/SerializingExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */