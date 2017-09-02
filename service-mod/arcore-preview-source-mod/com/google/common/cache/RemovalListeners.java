package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

public final class RemovalListeners
{
  public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> paramRemovalListener, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRemovalListener);
    Preconditions.checkNotNull(paramExecutor);
    new RemovalListener()
    {
      public void onRemoval(final RemovalNotification<K, V> paramAnonymousRemovalNotification)
      {
        this.val$executor.execute(new Runnable()
        {
          public void run()
          {
            RemovalListeners.1.this.val$listener.onRemoval(paramAnonymousRemovalNotification);
          }
        });
      }
    };
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/RemovalListeners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */