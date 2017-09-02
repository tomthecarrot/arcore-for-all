package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer
  implements Runnable
{
  private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
  private static final Field inheritableThreadLocals = getInheritableThreadLocalsField();
  private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
  private final WeakReference<Class<?>> finalizableReferenceClassReference;
  private final PhantomReference<Object> frqReference;
  private final ReferenceQueue<Object> queue;
  
  private Finalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference)
  {
    this.queue = paramReferenceQueue;
    this.finalizableReferenceClassReference = new WeakReference(paramClass);
    this.frqReference = paramPhantomReference;
  }
  
  private boolean cleanUp(Reference<?> paramReference)
  {
    Method localMethod = getFinalizeReferentMethod();
    if (localMethod == null) {
      return false;
    }
    for (;;)
    {
      paramReference.clear();
      if (paramReference == this.frqReference) {
        break;
      }
      try
      {
        localMethod.invoke(paramReference, new Object[0]);
        Reference localReference = this.queue.poll();
        paramReference = localReference;
        if (localReference != null) {
          continue;
        }
        return true;
      }
      catch (Throwable paramReference)
      {
        for (;;)
        {
          logger.log(Level.SEVERE, "Error cleaning up after reference.", paramReference);
        }
      }
    }
  }
  
  private Method getFinalizeReferentMethod()
  {
    Object localObject = (Class)this.finalizableReferenceClassReference.get();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Class)localObject).getMethod("finalizeReferent", new Class[0]);
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
  }
  
  public static Field getInheritableThreadLocalsField()
  {
    try
    {
      Field localField = Thread.class.getDeclaredField("inheritableThreadLocals");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
    }
    return null;
  }
  
  public static void startFinalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference)
  {
    if (!paramClass.getName().equals("com.google.common.base.FinalizableReference")) {
      throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }
    paramClass = new Thread(new Finalizer(paramClass, paramReferenceQueue, paramPhantomReference));
    paramClass.setName(Finalizer.class.getName());
    paramClass.setDaemon(true);
    try
    {
      if (inheritableThreadLocals != null) {
        inheritableThreadLocals.set(paramClass, null);
      }
      paramClass.start();
      return;
    }
    catch (Throwable paramReferenceQueue)
    {
      for (;;)
      {
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", paramReferenceQueue);
      }
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        boolean bool = cleanUp(this.queue.remove());
        if (!bool) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/internal/Finalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */