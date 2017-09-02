package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public final class SimpleTimeLimiter
  implements TimeLimiter
{
  private final ExecutorService executor;
  
  public SimpleTimeLimiter()
  {
    this(Executors.newCachedThreadPool());
  }
  
  public SimpleTimeLimiter(ExecutorService paramExecutorService)
  {
    this.executor = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
  }
  
  private static boolean declaresInterruptedEx(Method paramMethod)
  {
    paramMethod = paramMethod.getExceptionTypes();
    int j = paramMethod.length;
    int i = 0;
    while (i < j)
    {
      if (paramMethod[i] == InterruptedException.class) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static Set<Method> findInterruptibleMethods(Class<?> paramClass)
  {
    HashSet localHashSet = Sets.newHashSet();
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramClass[i];
      if (declaresInterruptedEx(localMethod)) {
        localHashSet.add(localMethod);
      }
      i += 1;
    }
    return localHashSet;
  }
  
  private static <T> T newProxy(Class<T> paramClass, InvocationHandler paramInvocationHandler)
  {
    return (T)paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
  
  private static Exception throwCause(Exception paramException, boolean paramBoolean)
    throws Exception
  {
    Throwable localThrowable = paramException.getCause();
    if (localThrowable == null) {
      throw paramException;
    }
    if (paramBoolean) {
      localThrowable.setStackTrace((StackTraceElement[])ObjectArrays.concat(localThrowable.getStackTrace(), paramException.getStackTrace(), StackTraceElement.class));
    }
    if ((localThrowable instanceof Exception)) {
      throw ((Exception)localThrowable);
    }
    if ((localThrowable instanceof Error)) {
      throw ((Error)localThrowable);
    }
    throw paramException;
  }
  
  public <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
    throws Exception
  {
    Preconditions.checkNotNull(paramCallable);
    Preconditions.checkNotNull(paramTimeUnit);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "timeout must be positive: %s", new Object[] { Long.valueOf(paramLong) });
      paramCallable = this.executor.submit(paramCallable);
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramTimeUnit = paramCallable.get(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        paramCallable.cancel(true);
        throw paramTimeUnit;
      }
      catch (ExecutionException paramCallable)
      {
        throw throwCause(paramCallable, true);
        paramTimeUnit = Uninterruptibles.getUninterruptibly(paramCallable, paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      catch (TimeoutException paramTimeUnit)
      {
        paramCallable.cancel(true);
        throw new UncheckedTimeoutException(paramTimeUnit);
      }
    }
  }
  
  public <T> T newProxy(final T paramT, Class<T> paramClass, final long paramLong, TimeUnit paramTimeUnit)
  {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramTimeUnit);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "bad timeout: %s", new Object[] { Long.valueOf(paramLong) });
      Preconditions.checkArgument(paramClass.isInterface(), "interfaceType must be an interface type");
      (T)newProxy(paramClass, new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, final Method paramAnonymousMethod, final Object[] paramAnonymousArrayOfObject)
          throws Throwable
        {
          paramAnonymousObject = new Callable()
          {
            public Object call()
              throws Exception
            {
              try
              {
                Object localObject = paramAnonymousMethod.invoke(SimpleTimeLimiter.1.this.val$target, paramAnonymousArrayOfObject);
                return localObject;
              }
              catch (InvocationTargetException localInvocationTargetException)
              {
                SimpleTimeLimiter.throwCause(localInvocationTargetException, false);
                throw new AssertionError("can't get here");
              }
            }
          };
          return SimpleTimeLimiter.this.callWithTimeout((Callable)paramAnonymousObject, paramLong, this.val$timeoutUnit, this.val$interruptibleMethods.contains(paramAnonymousMethod));
        }
      });
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/SimpleTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */