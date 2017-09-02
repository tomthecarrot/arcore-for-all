package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Callables
{
  public static <T> Callable<T> returning(@Nullable T paramT)
  {
    new Callable()
    {
      public T call()
      {
        return (T)this.val$value;
      }
    };
  }
  
  @GwtIncompatible("threads")
  static Runnable threadRenaming(final Runnable paramRunnable, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    Preconditions.checkNotNull(paramRunnable);
    new Runnable()
    {
      public void run()
      {
        Thread localThread = Thread.currentThread();
        String str = localThread.getName();
        boolean bool = Callables.trySetName((String)this.val$nameSupplier.get(), localThread);
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          if (bool) {
            Callables.trySetName(str, localThread);
          }
        }
      }
    };
  }
  
  @GwtIncompatible("threads")
  static <T> Callable<T> threadRenaming(final Callable<T> paramCallable, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    Preconditions.checkNotNull(paramCallable);
    new Callable()
    {
      public T call()
        throws Exception
      {
        Thread localThread = Thread.currentThread();
        String str = localThread.getName();
        boolean bool = Callables.trySetName((String)this.val$nameSupplier.get(), localThread);
        try
        {
          Object localObject1 = paramCallable.call();
          return (T)localObject1;
        }
        finally
        {
          if (bool) {
            Callables.trySetName(str, localThread);
          }
        }
      }
    };
  }
  
  @GwtIncompatible("threads")
  private static boolean trySetName(String paramString, Thread paramThread)
  {
    try
    {
      paramThread.setName(paramString);
      return true;
    }
    catch (SecurityException paramString) {}
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/Callables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */