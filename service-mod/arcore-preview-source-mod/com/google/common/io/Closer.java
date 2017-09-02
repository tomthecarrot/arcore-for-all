package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Closer
  implements Closeable
{
  private static final Suppressor SUPPRESSOR;
  private final Deque<Closeable> stack = new ArrayDeque(4);
  @VisibleForTesting
  final Suppressor suppressor;
  private Throwable thrown;
  
  static
  {
    if (SuppressingSuppressor.isAvailable()) {}
    for (Object localObject = SuppressingSuppressor.INSTANCE;; localObject = LoggingSuppressor.INSTANCE)
    {
      SUPPRESSOR = (Suppressor)localObject;
      return;
    }
  }
  
  @VisibleForTesting
  Closer(Suppressor paramSuppressor)
  {
    this.suppressor = ((Suppressor)Preconditions.checkNotNull(paramSuppressor));
  }
  
  public static Closer create()
  {
    return new Closer(SUPPRESSOR);
  }
  
  public void close()
    throws IOException
  {
    Object localObject = this.thrown;
    while (!this.stack.isEmpty())
    {
      Closeable localCloseable = (Closeable)this.stack.removeFirst();
      try
      {
        localCloseable.close();
      }
      catch (Throwable localThrowable)
      {
        if (localObject == null) {
          localObject = localThrowable;
        } else {
          this.suppressor.suppress(localCloseable, (Throwable)localObject, localThrowable);
        }
      }
    }
    if ((this.thrown == null) && (localObject != null))
    {
      Throwables.propagateIfPossible((Throwable)localObject, IOException.class);
      throw new AssertionError(localObject);
    }
  }
  
  public <C extends Closeable> C register(@Nullable C paramC)
  {
    if (paramC != null) {
      this.stack.addFirst(paramC);
    }
    return paramC;
  }
  
  public RuntimeException rethrow(Throwable paramThrowable)
    throws IOException
  {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    throw new RuntimeException(paramThrowable);
  }
  
  public <X extends Exception> RuntimeException rethrow(Throwable paramThrowable, Class<X> paramClass)
    throws IOException, Exception
  {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    Throwables.propagateIfPossible(paramThrowable, paramClass);
    throw new RuntimeException(paramThrowable);
  }
  
  public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1)
    throws IOException, Exception, Exception
  {
    Preconditions.checkNotNull(paramThrowable);
    this.thrown = paramThrowable;
    Throwables.propagateIfPossible(paramThrowable, IOException.class);
    Throwables.propagateIfPossible(paramThrowable, paramClass, paramClass1);
    throw new RuntimeException(paramThrowable);
  }
  
  @VisibleForTesting
  static final class LoggingSuppressor
    implements Closer.Suppressor
  {
    static final LoggingSuppressor INSTANCE = new LoggingSuppressor();
    
    public void suppress(Closeable paramCloseable, Throwable paramThrowable1, Throwable paramThrowable2)
    {
      Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + paramCloseable, paramThrowable2);
    }
  }
  
  @VisibleForTesting
  static final class SuppressingSuppressor
    implements Closer.Suppressor
  {
    static final SuppressingSuppressor INSTANCE = new SuppressingSuppressor();
    static final Method addSuppressed = getAddSuppressed();
    
    private static Method getAddSuppressed()
    {
      try
      {
        Method localMethod = Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
        return localMethod;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    static boolean isAvailable()
    {
      return addSuppressed != null;
    }
    
    public void suppress(Closeable paramCloseable, Throwable paramThrowable1, Throwable paramThrowable2)
    {
      if (paramThrowable1 == paramThrowable2) {
        return;
      }
      try
      {
        addSuppressed.invoke(paramThrowable1, new Object[] { paramThrowable2 });
        return;
      }
      catch (Throwable localThrowable)
      {
        Closer.LoggingSuppressor.INSTANCE.suppress(paramCloseable, paramThrowable1, paramThrowable2);
      }
    }
  }
  
  @VisibleForTesting
  static abstract interface Suppressor
  {
    public abstract void suppress(Closeable paramCloseable, Throwable paramThrowable1, Throwable paramThrowable2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/Closer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */