package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class ChannelExecutor
{
  private static final Logger log = Logger.getLogger(ChannelExecutor.class.getName());
  @GuardedBy("lock")
  private boolean draining;
  private final Object lock = new Object();
  @GuardedBy("lock")
  private final LinkedList<Runnable> queue = new LinkedList();
  
  void drain()
  {
    int i = 0;
    for (;;)
    {
      Object localObject1 = this.lock;
      int j = i;
      if (i == 0) {}
      try
      {
        if (this.draining) {
          return;
        }
        this.draining = true;
        j = 1;
        Runnable localRunnable = (Runnable)this.queue.poll();
        if (localRunnable == null)
        {
          this.draining = false;
          return;
        }
      }
      finally {}
      try
      {
        ((Runnable)localObject2).run();
        i = j;
      }
      catch (Throwable localThrowable)
      {
        log.log(Level.WARNING, "Runnable threw exception in ChannelExecutor", localThrowable);
        i = j;
      }
    }
  }
  
  ChannelExecutor executeLater(Runnable paramRunnable)
  {
    synchronized (this.lock)
    {
      this.queue.add(Preconditions.checkNotNull(paramRunnable, "runnable is null"));
      return this;
    }
  }
  
  @VisibleForTesting
  int numPendingTasks()
  {
    synchronized (this.lock)
    {
      int i = this.queue.size();
      return i;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ChannelExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */