package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import sun.misc.Unsafe;

@GwtCompatible(emulated=true)
public abstract class AbstractFuture<V>
  implements ListenableFuture<V>
{
  private static final AtomicHelper ATOMIC_HELPER;
  private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
  private static final Object NULL;
  private static final long SPIN_THRESHOLD_NANOS = 1000L;
  private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
  private volatile Listener listeners;
  private volatile Object value;
  private volatile Waiter waiters;
  
  static
  {
    try
    {
      localObject = new UnsafeAtomicHelper(null);
      ATOMIC_HELPER = (AtomicHelper)localObject;
      NULL = new Object();
      return;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          Object localObject = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
        }
        catch (Throwable localThrowable1)
        {
          log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", localThrowable2);
          log.log(Level.SEVERE, "SafeAtomicHelper is broken!", localThrowable1);
          SynchronizedHelper localSynchronizedHelper = new SynchronizedHelper(null);
        }
      }
    }
  }
  
  static final CancellationException cancellationExceptionWithCause(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  private Listener clearListeners()
  {
    Listener localListener;
    do
    {
      localListener = this.listeners;
    } while (!ATOMIC_HELPER.casListeners(this, localListener, Listener.TOMBSTONE));
    return localListener;
  }
  
  private Waiter clearWaiters()
  {
    Waiter localWaiter;
    do
    {
      localWaiter = this.waiters;
    } while (!ATOMIC_HELPER.casWaiters(this, localWaiter, Waiter.TOMBSTONE));
    return localWaiter;
  }
  
  private void complete()
  {
    for (Object localObject1 = clearWaiters(); localObject1 != null; localObject1 = ((Waiter)localObject1).next) {
      ((Waiter)localObject1).unpark();
    }
    Object localObject2 = clearListeners();
    localObject1 = null;
    Object localObject3;
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject2 == null) {
        break;
      }
      localObject3 = ((Listener)localObject2).next;
      ((Listener)localObject2).next = ((Listener)localObject1);
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    while (localObject3 != null)
    {
      executeListener(((Listener)localObject3).task, ((Listener)localObject3).executor);
      localObject3 = ((Listener)localObject3).next;
    }
    done();
  }
  
  private boolean completeWithFuture(ListenableFuture<? extends V> paramListenableFuture, Object paramObject)
  {
    boolean bool = false;
    if ((paramListenableFuture instanceof TrustedFuture)) {
      paramListenableFuture = ((AbstractFuture)paramListenableFuture).value;
    }
    for (;;)
    {
      if (ATOMIC_HELPER.casValue(this, paramObject, paramListenableFuture))
      {
        complete();
        bool = true;
      }
      return bool;
      try
      {
        paramListenableFuture = Uninterruptibles.getUninterruptibly(paramListenableFuture);
        if (paramListenableFuture == null) {
          paramListenableFuture = NULL;
        }
        for (;;)
        {
          break;
        }
      }
      catch (ExecutionException paramListenableFuture)
      {
        paramListenableFuture = new Failure(paramListenableFuture.getCause());
      }
      catch (CancellationException paramListenableFuture)
      {
        paramListenableFuture = new Cancellation(false, paramListenableFuture);
      }
      catch (Throwable paramListenableFuture)
      {
        paramListenableFuture = new Failure(paramListenableFuture);
      }
    }
  }
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  private V getDoneValue(Object paramObject)
    throws ExecutionException
  {
    if ((paramObject instanceof Cancellation)) {
      throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)paramObject).cause);
    }
    if ((paramObject instanceof Failure)) {
      throw new ExecutionException(((Failure)paramObject).exception);
    }
    if (paramObject == NULL) {
      return null;
    }
    return (V)paramObject;
  }
  
  private Throwable newCancellationCause()
  {
    return new CancellationException("Future.cancel() was called.");
  }
  
  private void removeWaiter(Waiter paramWaiter)
  {
    paramWaiter.thread = null;
    for (;;)
    {
      Object localObject1 = null;
      Object localObject2 = this.waiters;
      paramWaiter = (Waiter)localObject2;
      if (localObject2 == Waiter.TOMBSTONE) {
        return;
      }
      label22:
      Waiter localWaiter;
      if (paramWaiter != null)
      {
        localWaiter = paramWaiter.next;
        if (paramWaiter.thread == null) {
          break label49;
        }
        localObject2 = paramWaiter;
      }
      label49:
      label71:
      do
      {
        do
        {
          paramWaiter = localWaiter;
          localObject1 = localObject2;
          break label22;
          break;
          if (localObject1 == null) {
            break label71;
          }
          ((Waiter)localObject1).next = localWaiter;
          localObject2 = localObject1;
        } while (((Waiter)localObject1).thread != null);
        break;
        localObject2 = localObject1;
      } while (ATOMIC_HELPER.casWaiters(this, paramWaiter, localWaiter));
    }
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    Object localObject = this.listeners;
    if (localObject != Listener.TOMBSTONE)
    {
      Listener localListener2 = new Listener(paramRunnable, paramExecutor);
      Listener localListener1;
      do
      {
        localListener2.next = ((Listener)localObject);
        if (ATOMIC_HELPER.casListeners(this, (Listener)localObject, localListener2)) {
          return;
        }
        localListener1 = this.listeners;
        localObject = localListener1;
      } while (localListener1 != Listener.TOMBSTONE);
    }
    executeListener(paramRunnable, paramExecutor);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    Object localObject2 = this.value;
    int i;
    Object localObject1;
    label34:
    Cancellation localCancellation;
    if (localObject2 == null)
    {
      i = 1;
      if ((i | localObject2 instanceof SetFuture) == 0) {
        break label123;
      }
      if (!GENERATE_CANCELLATION_CAUSES) {
        break label101;
      }
      localObject1 = newCancellationCause();
      localCancellation = new Cancellation(paramBoolean, (Throwable)localObject1);
      localObject1 = localObject2;
    }
    label101:
    do
    {
      if (ATOMIC_HELPER.casValue(this, localObject1, localCancellation))
      {
        if (paramBoolean) {
          interruptTask();
        }
        complete();
        if ((localObject1 instanceof SetFuture)) {
          ((SetFuture)localObject1).future.cancel(paramBoolean);
        }
        return true;
        i = 0;
        break;
        localObject1 = null;
        break label34;
      }
      localObject2 = this.value;
      localObject1 = localObject2;
    } while ((localObject2 instanceof SetFuture));
    label123:
    return false;
  }
  
  void done() {}
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof SetFuture)) {
        break label51;
      }
    }
    label51:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label56;
      }
      return (V)getDoneValue(localObject);
      i = 0;
      break;
    }
    label56:
    localObject = this.waiters;
    if (localObject != Waiter.TOMBSTONE)
    {
      Waiter localWaiter2 = new Waiter();
      label157:
      label160:
      Waiter localWaiter1;
      do
      {
        localWaiter2.setNext((Waiter)localObject);
        if (ATOMIC_HELPER.casWaiters(this, (Waiter)localObject, localWaiter2)) {
          for (;;)
          {
            LockSupport.park(this);
            if (Thread.interrupted())
            {
              removeWaiter(localWaiter2);
              throw new InterruptedException();
            }
            localObject = this.value;
            if (localObject != null)
            {
              i = 1;
              if ((localObject instanceof SetFuture)) {
                break label157;
              }
            }
            for (j = 1;; j = 0)
            {
              if ((i & j) == 0) {
                break label160;
              }
              return (V)getDoneValue(localObject);
              i = 0;
              break;
            }
          }
        }
        localWaiter1 = this.waiters;
        localObject = localWaiter1;
      } while (localWaiter1 != Waiter.TOMBSTONE);
    }
    return (V)getDoneValue(this.value);
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, ExecutionException
  {
    long l2 = paramTimeUnit.toNanos(paramLong);
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    paramTimeUnit = this.value;
    int i;
    if (paramTimeUnit != null)
    {
      i = 1;
      if ((paramTimeUnit instanceof SetFuture)) {
        break label63;
      }
    }
    label63:
    for (int j = 1;; j = 0)
    {
      if ((i & j) == 0) {
        break label69;
      }
      return (V)getDoneValue(paramTimeUnit);
      i = 0;
      break;
    }
    label69:
    long l1;
    Waiter localWaiter2;
    if (l2 > 0L)
    {
      l1 = System.nanoTime() + l2;
      paramLong = l2;
      if (l2 >= 1000L)
      {
        paramTimeUnit = this.waiters;
        if (paramTimeUnit == Waiter.TOMBSTONE) {
          break label299;
        }
        localWaiter2 = new Waiter();
        localWaiter2.setNext(paramTimeUnit);
        if (!ATOMIC_HELPER.casWaiters(this, paramTimeUnit, localWaiter2)) {
          break label282;
        }
      }
    }
    else
    {
      label210:
      label216:
      do
      {
        LockSupport.parkNanos(this, l2);
        if (Thread.interrupted())
        {
          removeWaiter(localWaiter2);
          throw new InterruptedException();
          l1 = 0L;
          break;
        }
        paramTimeUnit = this.value;
        if (paramTimeUnit != null)
        {
          i = 1;
          if ((paramTimeUnit instanceof SetFuture)) {
            break label210;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i & j) == 0) {
            break label216;
          }
          return (V)getDoneValue(paramTimeUnit);
          i = 0;
          break;
        }
        paramLong = l1 - System.nanoTime();
        l2 = paramLong;
      } while (paramLong >= 1000L);
      removeWaiter(localWaiter2);
    }
    for (;;)
    {
      if (paramLong <= 0L) {
        break label344;
      }
      paramTimeUnit = this.value;
      if (paramTimeUnit != null)
      {
        i = 1;
        label258:
        if ((paramTimeUnit instanceof SetFuture)) {
          break label314;
        }
      }
      label282:
      label299:
      label314:
      for (j = 1;; j = 0)
      {
        if ((i & j) == 0) {
          break label320;
        }
        return (V)getDoneValue(paramTimeUnit);
        Waiter localWaiter1 = this.waiters;
        paramTimeUnit = localWaiter1;
        if (localWaiter1 != Waiter.TOMBSTONE) {
          break;
        }
        return (V)getDoneValue(this.value);
        i = 0;
        break label258;
      }
      label320:
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      paramLong = l1 - System.nanoTime();
    }
    label344:
    throw new TimeoutException();
  }
  
  protected void interruptTask() {}
  
  public boolean isCancelled()
  {
    return this.value instanceof Cancellation;
  }
  
  public boolean isDone()
  {
    int j = 1;
    Object localObject = this.value;
    int i;
    if (localObject != null)
    {
      i = 1;
      if ((localObject instanceof SetFuture)) {
        break label29;
      }
    }
    for (;;)
    {
      return i & j;
      i = 0;
      break;
      label29:
      j = 0;
    }
  }
  
  final void maybePropagateCancellation(@Nullable Future<?> paramFuture)
  {
    if (paramFuture != null) {}
    for (int i = 1;; i = 0)
    {
      if ((i & isCancelled()) != 0) {
        paramFuture.cancel(wasInterrupted());
      }
      return;
    }
  }
  
  protected boolean set(@Nullable V paramV)
  {
    if (paramV == null) {
      paramV = NULL;
    }
    while (ATOMIC_HELPER.casValue(this, null, paramV))
    {
      complete();
      return true;
    }
    return false;
  }
  
  protected boolean setException(Throwable paramThrowable)
  {
    paramThrowable = new Failure((Throwable)Preconditions.checkNotNull(paramThrowable));
    if (ATOMIC_HELPER.casValue(this, null, paramThrowable))
    {
      complete();
      return true;
    }
    return false;
  }
  
  @Beta
  protected boolean setFuture(ListenableFuture<? extends V> paramListenableFuture)
  {
    Preconditions.checkNotNull(paramListenableFuture);
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramListenableFuture.isDone()) {
        return completeWithFuture(paramListenableFuture, null);
      }
      localObject1 = new SetFuture(paramListenableFuture);
      if (ATOMIC_HELPER.casValue(this, null, localObject1)) {
        for (;;)
        {
          try
          {
            paramListenableFuture.addListener((Runnable)localObject1, MoreExecutors.directExecutor());
            return true;
          }
          catch (Throwable paramListenableFuture) {}
          try
          {
            paramListenableFuture = new Failure(paramListenableFuture);
            ATOMIC_HELPER.casValue(this, localObject1, paramListenableFuture);
          }
          catch (Throwable paramListenableFuture)
          {
            for (;;)
            {
              paramListenableFuture = Failure.FALLBACK_INSTANCE;
            }
          }
        }
      }
      localObject1 = this.value;
    }
    if ((localObject1 instanceof Cancellation)) {
      paramListenableFuture.cancel(((Cancellation)localObject1).wasInterrupted);
    }
    return false;
  }
  
  final Throwable trustedGetException()
  {
    return ((Failure)this.value).exception;
  }
  
  protected final boolean wasInterrupted()
  {
    Object localObject = this.value;
    return ((localObject instanceof Cancellation)) && (((Cancellation)localObject).wasInterrupted);
  }
  
  private static abstract class AtomicHelper
  {
    abstract boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2);
    
    abstract boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2);
    
    abstract boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
    
    abstract void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread);
  }
  
  private static final class Cancellation
  {
    @Nullable
    final Throwable cause;
    final boolean wasInterrupted;
    
    Cancellation(boolean paramBoolean, @Nullable Throwable paramThrowable)
    {
      this.wasInterrupted = paramBoolean;
      this.cause = paramThrowable;
    }
  }
  
  private static final class Failure
  {
    static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.")
    {
      public Throwable fillInStackTrace()
      {
        return this;
      }
    });
    final Throwable exception;
    
    Failure(Throwable paramThrowable)
    {
      this.exception = ((Throwable)Preconditions.checkNotNull(paramThrowable));
    }
  }
  
  private static final class Listener
  {
    static final Listener TOMBSTONE = new Listener(null, null);
    final Executor executor;
    @Nullable
    Listener next;
    final Runnable task;
    
    Listener(Runnable paramRunnable, Executor paramExecutor)
    {
      this.task = paramRunnable;
      this.executor = paramExecutor;
    }
  }
  
  private static final class SafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> listenersUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> waiterNextUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> waiterThreadUpdater;
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> waitersUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> paramAtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Object> paramAtomicReferenceFieldUpdater4)
    {
      super();
      this.waiterThreadUpdater = paramAtomicReferenceFieldUpdater;
      this.waiterNextUpdater = paramAtomicReferenceFieldUpdater1;
      this.waitersUpdater = paramAtomicReferenceFieldUpdater2;
      this.listenersUpdater = paramAtomicReferenceFieldUpdater3;
      this.valueUpdater = paramAtomicReferenceFieldUpdater4;
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      return this.listenersUpdater.compareAndSet(paramAbstractFuture, paramListener1, paramListener2);
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      return this.valueUpdater.compareAndSet(paramAbstractFuture, paramObject1, paramObject2);
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      return this.waitersUpdater.compareAndSet(paramAbstractFuture, paramWaiter1, paramWaiter2);
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      this.waiterNextUpdater.lazySet(paramWaiter1, paramWaiter2);
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      this.waiterThreadUpdater.lazySet(paramWaiter, paramThread);
    }
  }
  
  private final class SetFuture
    implements Runnable
  {
    final ListenableFuture<? extends V> future;
    
    SetFuture()
    {
      ListenableFuture localListenableFuture;
      this.future = localListenableFuture;
    }
    
    public void run()
    {
      if (AbstractFuture.this.value != this) {
        return;
      }
      AbstractFuture.this.completeWithFuture(this.future, this);
    }
  }
  
  private static final class SynchronizedHelper
    extends AbstractFuture.AtomicHelper
  {
    private SynchronizedHelper()
    {
      super();
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      try
      {
        if (paramAbstractFuture.listeners == paramListener1)
        {
          AbstractFuture.access$702(paramAbstractFuture, paramListener2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      try
      {
        if (paramAbstractFuture.value == paramObject1)
        {
          AbstractFuture.access$302(paramAbstractFuture, paramObject2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      try
      {
        if (paramAbstractFuture.waiters == paramWaiter1)
        {
          AbstractFuture.access$602(paramAbstractFuture, paramWaiter2);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      paramWaiter1.next = paramWaiter2;
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      paramWaiter.thread = paramThread;
    }
  }
  
  static abstract class TrustedFuture<V>
    extends AbstractFuture<V>
  {
    public final void addListener(Runnable paramRunnable, Executor paramExecutor)
    {
      super.addListener(paramRunnable, paramExecutor);
    }
    
    public final V get()
      throws InterruptedException, ExecutionException
    {
      return (V)super.get();
    }
    
    public final V get(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException, ExecutionException, TimeoutException
    {
      return (V)super.get(paramLong, paramTimeUnit);
    }
    
    public final boolean isCancelled()
    {
      return super.isCancelled();
    }
    
    public final boolean isDone()
    {
      return super.isDone();
    }
  }
  
  private static final class UnsafeAtomicHelper
    extends AbstractFuture.AtomicHelper
  {
    static final long LISTENERS_OFFSET;
    static final Unsafe UNSAFE;
    static final long VALUE_OFFSET;
    static final long WAITERS_OFFSET;
    static final long WAITER_NEXT_OFFSET;
    static final long WAITER_THREAD_OFFSET;
    
    static
    {
      try
      {
        localUnsafe1 = Unsafe.getUnsafe();
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          try
          {
            Unsafe localUnsafe1;
            WAITERS_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
            LISTENERS_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
            VALUE_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
            WAITER_THREAD_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("thread"));
            WAITER_NEXT_OFFSET = localUnsafe1.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("next"));
            UNSAFE = localUnsafe1;
            return;
          }
          catch (Exception localException)
          {
            throw Throwables.propagate(localException);
          }
          localSecurityException = localSecurityException;
          try
          {
            Unsafe localUnsafe2 = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction()
            {
              public Unsafe run()
                throws Exception
              {
                Field[] arrayOfField = Unsafe.class.getDeclaredFields();
                int j = arrayOfField.length;
                int i = 0;
                while (i < j)
                {
                  Object localObject = arrayOfField[i];
                  ((Field)localObject).setAccessible(true);
                  localObject = ((Field)localObject).get(null);
                  if (Unsafe.class.isInstance(localObject)) {
                    return (Unsafe)Unsafe.class.cast(localObject);
                  }
                  i += 1;
                }
                throw new NoSuchFieldError("the Unsafe");
              }
            });
          }
          catch (PrivilegedActionException localPrivilegedActionException)
          {
            throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
          }
        }
      }
    }
    
    private UnsafeAtomicHelper()
    {
      super();
    }
    
    boolean casListeners(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Listener paramListener1, AbstractFuture.Listener paramListener2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, LISTENERS_OFFSET, paramListener1, paramListener2);
    }
    
    boolean casValue(AbstractFuture<?> paramAbstractFuture, Object paramObject1, Object paramObject2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, VALUE_OFFSET, paramObject1, paramObject2);
    }
    
    boolean casWaiters(AbstractFuture<?> paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      return UNSAFE.compareAndSwapObject(paramAbstractFuture, WAITERS_OFFSET, paramWaiter1, paramWaiter2);
    }
    
    void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
    {
      UNSAFE.putObject(paramWaiter1, WAITER_NEXT_OFFSET, paramWaiter2);
    }
    
    void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
    {
      UNSAFE.putObject(paramWaiter, WAITER_THREAD_OFFSET, paramThread);
    }
  }
  
  private static final class Waiter
  {
    static final Waiter TOMBSTONE = new Waiter(false);
    @Nullable
    volatile Waiter next;
    @Nullable
    volatile Thread thread;
    
    Waiter()
    {
      AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
    
    Waiter(boolean paramBoolean) {}
    
    void setNext(Waiter paramWaiter)
    {
      AbstractFuture.ATOMIC_HELPER.putNext(this, paramWaiter);
    }
    
    void unpark()
    {
      Thread localThread = this.thread;
      if (localThread != null)
      {
        this.thread = null;
        LockSupport.unpark(localThread);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AbstractFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */