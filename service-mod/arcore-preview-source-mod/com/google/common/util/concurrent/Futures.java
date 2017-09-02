package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public final class Futures
  extends GwtFuturesCatchingSpecialization
{
  private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new AsyncFunction()
  {
    public ListenableFuture<Object> apply(ListenableFuture<Object> paramAnonymousListenableFuture)
    {
      return paramAnonymousListenableFuture;
    }
  };
  
  public static <V> void addCallback(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback)
  {
    addCallback(paramListenableFuture, paramFutureCallback, MoreExecutors.directExecutor());
  }
  
  public static <V> void addCallback(ListenableFuture<V> paramListenableFuture, final FutureCallback<? super V> paramFutureCallback, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFutureCallback);
    paramListenableFuture.addListener(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = Uninterruptibles.getUninterruptibly(this.val$future);
          paramFutureCallback.onSuccess(localObject);
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          paramFutureCallback.onFailure(localExecutionException.getCause());
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          paramFutureCallback.onFailure(localRuntimeException);
          return;
        }
        catch (Error localError)
        {
          paramFutureCallback.onFailure(localError);
        }
      }
    }, paramExecutor);
  }
  
  @CheckReturnValue
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new ListFuture(ImmutableList.copyOf(paramIterable), true);
  }
  
  @SafeVarargs
  @CheckReturnValue
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new ListFuture(ImmutableList.copyOf(paramVarArgs), true);
  }
  
  @Deprecated
  static <V> AsyncFunction<Throwable, V> asAsyncFunction(FutureFallback<V> paramFutureFallback)
  {
    Preconditions.checkNotNull(paramFutureFallback);
    new AsyncFunction()
    {
      public ListenableFuture<V> apply(Throwable paramAnonymousThrowable)
        throws Exception
      {
        return (ListenableFuture)Preconditions.checkNotNull(this.val$fallback.create(paramAnonymousThrowable), "FutureFallback.create returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      }
    };
  }
  
  @CheckReturnValue
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction)
  {
    paramClass = new CatchingFuture(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.directExecutor());
    return paramClass;
  }
  
  @CheckReturnValue
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction, Executor paramExecutor)
  {
    paramClass = new CatchingFuture(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(paramClass, rejectionPropagatingExecutor(paramExecutor, paramClass));
    return paramClass;
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction)
  {
    paramClass = new AsyncCatchingFuture(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.directExecutor());
    return paramClass;
  }
  
  @GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction, Executor paramExecutor)
  {
    paramClass = new AsyncCatchingFuture(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(paramClass, rejectionPropagatingExecutor(paramExecutor, paramClass));
    return paramClass;
  }
  
  @CheckReturnValue
  public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> paramListenableFuture)
  {
    return transformAsync(paramListenableFuture, DEREFERENCER);
  }
  
  @Deprecated
  @GwtIncompatible("reflection")
  public static <V, X extends Exception> V get(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit, Class<X> paramClass)
    throws Exception
  {
    return (V)getChecked(paramFuture, paramClass, paramLong, paramTimeUnit);
  }
  
  @Deprecated
  @GwtIncompatible("reflection")
  public static <V, X extends Exception> V get(Future<V> paramFuture, Class<X> paramClass)
    throws Exception
  {
    return (V)getChecked(paramFuture, paramClass);
  }
  
  @GwtIncompatible("reflection")
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass)
    throws Exception
  {
    return (V)FuturesGetChecked.getChecked(paramFuture, paramClass);
  }
  
  @GwtIncompatible("reflection")
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass, long paramLong, TimeUnit paramTimeUnit)
    throws Exception
  {
    return (V)FuturesGetChecked.getChecked(paramFuture, paramClass, paramLong, paramTimeUnit);
  }
  
  @GwtIncompatible("TODO")
  public static <V> V getUnchecked(Future<V> paramFuture)
  {
    Preconditions.checkNotNull(paramFuture);
    try
    {
      paramFuture = Uninterruptibles.getUninterruptibly(paramFuture);
      return paramFuture;
    }
    catch (ExecutionException paramFuture)
    {
      wrapAndThrowUnchecked(paramFuture.getCause());
      throw new AssertionError();
    }
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <V> ListenableFuture<V> immediateCancelledFuture()
  {
    return new ImmediateCancelledFuture();
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V paramV)
  {
    return new ImmediateSuccessfulCheckedFuture(paramV);
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X paramX)
  {
    Preconditions.checkNotNull(paramX);
    return new ImmediateFailedCheckedFuture(paramX);
  }
  
  @CheckReturnValue
  public static <V> ListenableFuture<V> immediateFailedFuture(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    return new ImmediateFailedFuture(paramThrowable);
  }
  
  @CheckReturnValue
  public static <V> ListenableFuture<V> immediateFuture(@Nullable V paramV)
  {
    if (paramV == null) {
      return ImmediateSuccessfulFuture.NULL;
    }
    return new ImmediateSuccessfulFuture(paramV);
  }
  
  @CheckReturnValue
  @Beta
  @GwtIncompatible("TODO")
  public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> paramIterable)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    SerializingExecutor localSerializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      final ListenableFuture localListenableFuture = (ListenableFuture)paramIterable.next();
      SettableFuture localSettableFuture = SettableFuture.create();
      localConcurrentLinkedQueue.add(localSettableFuture);
      localListenableFuture.addListener(new Runnable()
      {
        public void run()
        {
          ((SettableFuture)this.val$delegates.remove()).setFuture(localListenableFuture);
        }
      }, localSerializingExecutor);
      localBuilder.add(localSettableFuture);
    }
    return localBuilder.build();
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <I, O> Future<O> lazyTransform(Future<I> paramFuture, final Function<? super I, ? extends O> paramFunction)
  {
    Preconditions.checkNotNull(paramFuture);
    Preconditions.checkNotNull(paramFunction);
    new Future()
    {
      private O applyTransformation(I paramAnonymousI)
        throws ExecutionException
      {
        try
        {
          paramAnonymousI = paramFunction.apply(paramAnonymousI);
          return paramAnonymousI;
        }
        catch (Throwable paramAnonymousI)
        {
          throw new ExecutionException(paramAnonymousI);
        }
      }
      
      public boolean cancel(boolean paramAnonymousBoolean)
      {
        return this.val$input.cancel(paramAnonymousBoolean);
      }
      
      public O get()
        throws InterruptedException, ExecutionException
      {
        return (O)applyTransformation(this.val$input.get());
      }
      
      public O get(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, ExecutionException, TimeoutException
      {
        return (O)applyTransformation(this.val$input.get(paramAnonymousLong, paramAnonymousTimeUnit));
      }
      
      public boolean isCancelled()
      {
        return this.val$input.isCancelled();
      }
      
      public boolean isDone()
      {
        return this.val$input.isDone();
      }
    };
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> paramListenableFuture, Function<? super Exception, X> paramFunction)
  {
    return new MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture), paramFunction);
  }
  
  @CheckReturnValue
  @GwtIncompatible("TODO")
  public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> paramListenableFuture)
  {
    return new NonCancellationPropagatingFuture(paramListenableFuture);
  }
  
  private static Executor rejectionPropagatingExecutor(Executor paramExecutor, final AbstractFuture<?> paramAbstractFuture)
  {
    Preconditions.checkNotNull(paramExecutor);
    if (paramExecutor == MoreExecutors.directExecutor()) {
      return paramExecutor;
    }
    new Executor()
    {
      volatile boolean thrownFromDelegate = true;
      
      public void execute(final Runnable paramAnonymousRunnable)
      {
        try
        {
          this.val$delegate.execute(new Runnable()
          {
            public void run()
            {
              Futures.2.this.thrownFromDelegate = false;
              paramAnonymousRunnable.run();
            }
          });
          return;
        }
        catch (RejectedExecutionException paramAnonymousRunnable)
        {
          while (!this.thrownFromDelegate) {}
          paramAbstractFuture.setException(paramAnonymousRunnable);
        }
      }
    };
  }
  
  @CheckReturnValue
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new ListFuture(ImmutableList.copyOf(paramIterable), false);
  }
  
  @SafeVarargs
  @CheckReturnValue
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new ListFuture(ImmutableList.copyOf(paramVarArgs), false);
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    paramFunction = new ChainingFuture(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(paramFunction, MoreExecutors.directExecutor());
    return paramFunction;
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFunction);
    paramFunction = new ChainingFuture(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(paramFunction, rejectionPropagatingExecutor(paramExecutor, paramFunction));
    return paramFunction;
  }
  
  @Deprecated
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
  {
    return transformAsync(paramListenableFuture, paramAsyncFunction);
  }
  
  @Deprecated
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor)
  {
    return transformAsync(paramListenableFuture, paramAsyncFunction, paramExecutor);
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
  {
    paramAsyncFunction = new AsyncChainingFuture(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(paramAsyncFunction, MoreExecutors.directExecutor());
    return paramAsyncFunction;
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramExecutor);
    paramAsyncFunction = new AsyncChainingFuture(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(paramAsyncFunction, rejectionPropagatingExecutor(paramExecutor, paramAsyncFunction));
    return paramAsyncFunction;
  }
  
  @Deprecated
  @CheckReturnValue
  public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> paramListenableFuture, FutureFallback<? extends V> paramFutureFallback)
  {
    return withFallback(paramListenableFuture, paramFutureFallback, MoreExecutors.directExecutor());
  }
  
  @Deprecated
  @CheckReturnValue
  public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> paramListenableFuture, FutureFallback<? extends V> paramFutureFallback, Executor paramExecutor)
  {
    return catchingAsync(paramListenableFuture, Throwable.class, asAsyncFunction(paramFutureFallback), paramExecutor);
  }
  
  @CheckReturnValue
  @GwtIncompatible("java.util.concurrent.ScheduledExecutorService")
  public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> paramListenableFuture, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    TimeoutFuture localTimeoutFuture = new TimeoutFuture(paramListenableFuture);
    Futures.TimeoutFuture.Fire localFire = new Futures.TimeoutFuture.Fire(localTimeoutFuture);
    localTimeoutFuture.timer = paramScheduledExecutorService.schedule(localFire, paramLong, paramTimeUnit);
    paramListenableFuture.addListener(localFire, MoreExecutors.directExecutor());
    return localTimeoutFuture;
  }
  
  @GwtIncompatible("TODO")
  private static void wrapAndThrowUnchecked(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof Error)) {
      throw new ExecutionError((Error)paramThrowable);
    }
    throw new UncheckedExecutionException(paramThrowable);
  }
  
  private static abstract class AbstractCatchingFuture<V, X extends Throwable, F>
    extends AbstractFuture.TrustedFuture<V>
    implements Runnable
  {
    @Nullable
    Class<X> exceptionType;
    @Nullable
    F fallback;
    @Nullable
    ListenableFuture<? extends V> inputFuture;
    
    AbstractCatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, F paramF)
    {
      this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
      this.exceptionType = ((Class)Preconditions.checkNotNull(paramClass));
      this.fallback = Preconditions.checkNotNull(paramF);
    }
    
    abstract void doFallback(F paramF, X paramX)
      throws Exception;
    
    final void done()
    {
      maybePropagateCancellation(this.inputFuture);
      this.inputFuture = null;
      this.exceptionType = null;
      this.fallback = null;
    }
    
    public final void run()
    {
      int k = 1;
      ListenableFuture localListenableFuture = this.inputFuture;
      Class localClass = this.exceptionType;
      Object localObject = this.fallback;
      int i;
      int j;
      if (localListenableFuture == null)
      {
        i = 1;
        if (localClass != null) {
          break label58;
        }
        j = 1;
        label34:
        if (localObject != null) {
          break label63;
        }
      }
      for (;;)
      {
        if ((k | j | i | isCancelled()) == 0) {
          break label68;
        }
        return;
        i = 0;
        break;
        label58:
        j = 0;
        break label34;
        label63:
        k = 0;
      }
      label68:
      this.inputFuture = null;
      this.exceptionType = null;
      this.fallback = null;
      try
      {
        set(Uninterruptibles.getUninterruptibly(localListenableFuture));
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        Throwable localThrowable1 = localExecutionException.getCause();
        try
        {
          if (Platform.isInstanceOfThrowableClass(localThrowable1, localClass))
          {
            doFallback(localObject, localThrowable1);
            return;
          }
        }
        catch (Throwable localThrowable2)
        {
          setException(localThrowable2);
          return;
        }
      }
      catch (Throwable localThrowable3)
      {
        for (;;) {}
        setException(localThrowable3);
      }
    }
  }
  
  private static abstract class AbstractChainingFuture<I, O, F>
    extends AbstractFuture.TrustedFuture<O>
    implements Runnable
  {
    @Nullable
    F function;
    @Nullable
    ListenableFuture<? extends I> inputFuture;
    
    AbstractChainingFuture(ListenableFuture<? extends I> paramListenableFuture, F paramF)
    {
      this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
      this.function = Preconditions.checkNotNull(paramF);
    }
    
    abstract void doTransform(F paramF, I paramI)
      throws Exception;
    
    final void done()
    {
      maybePropagateCancellation(this.inputFuture);
      this.inputFuture = null;
      this.function = null;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 32	com/google/common/util/concurrent/Futures$AbstractChainingFuture:inputFuture	Lcom/google/common/util/concurrent/ListenableFuture;
      //   6: astore 5
      //   8: aload_0
      //   9: getfield 34	com/google/common/util/concurrent/Futures$AbstractChainingFuture:function	Ljava/lang/Object;
      //   12: astore 4
      //   14: aload_0
      //   15: invokevirtual 59	com/google/common/util/concurrent/Futures$AbstractChainingFuture:isCancelled	()Z
      //   18: istore_3
      //   19: aload 5
      //   21: ifnonnull +93 -> 114
      //   24: iconst_1
      //   25: istore_1
      //   26: goto +74 -> 100
      //   29: aload_0
      //   30: aconst_null
      //   31: putfield 32	com/google/common/util/concurrent/Futures$AbstractChainingFuture:inputFuture	Lcom/google/common/util/concurrent/ListenableFuture;
      //   34: aload_0
      //   35: aconst_null
      //   36: putfield 34	com/google/common/util/concurrent/Futures$AbstractChainingFuture:function	Ljava/lang/Object;
      //   39: aload 5
      //   41: invokestatic 65	com/google/common/util/concurrent/Uninterruptibles:getUninterruptibly	(Ljava/util/concurrent/Future;)Ljava/lang/Object;
      //   44: astore 5
      //   46: aload_0
      //   47: aload 4
      //   49: aload 5
      //   51: invokevirtual 67	com/google/common/util/concurrent/Futures$AbstractChainingFuture:doTransform	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   54: return
      //   55: astore 4
      //   57: aload_0
      //   58: aload 4
      //   60: invokevirtual 71	java/lang/reflect/UndeclaredThrowableException:getCause	()Ljava/lang/Throwable;
      //   63: invokevirtual 75	com/google/common/util/concurrent/Futures$AbstractChainingFuture:setException	(Ljava/lang/Throwable;)Z
      //   66: pop
      //   67: return
      //   68: astore 4
      //   70: aload_0
      //   71: iconst_0
      //   72: invokevirtual 79	com/google/common/util/concurrent/Futures$AbstractChainingFuture:cancel	(Z)Z
      //   75: pop
      //   76: return
      //   77: astore 4
      //   79: aload_0
      //   80: aload 4
      //   82: invokevirtual 75	com/google/common/util/concurrent/Futures$AbstractChainingFuture:setException	(Ljava/lang/Throwable;)Z
      //   85: pop
      //   86: return
      //   87: astore 4
      //   89: aload_0
      //   90: aload 4
      //   92: invokevirtual 80	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
      //   95: invokevirtual 75	com/google/common/util/concurrent/Futures$AbstractChainingFuture:setException	(Ljava/lang/Throwable;)Z
      //   98: pop
      //   99: return
      //   100: aload 4
      //   102: ifnonnull +17 -> 119
      //   105: iload_2
      //   106: iload_1
      //   107: iload_3
      //   108: ior
      //   109: ior
      //   110: ifeq -81 -> 29
      //   113: return
      //   114: iconst_0
      //   115: istore_1
      //   116: goto -16 -> 100
      //   119: iconst_0
      //   120: istore_2
      //   121: goto -16 -> 105
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	124	0	this	AbstractChainingFuture
      //   25	91	1	bool1	boolean
      //   1	120	2	i	int
      //   18	91	3	bool2	boolean
      //   12	36	4	localObject1	Object
      //   55	4	4	localUndeclaredThrowableException	java.lang.reflect.UndeclaredThrowableException
      //   68	1	4	localCancellationException	CancellationException
      //   77	4	4	localThrowable	Throwable
      //   87	14	4	localExecutionException	ExecutionException
      //   6	44	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	55	java/lang/reflect/UndeclaredThrowableException
      //   29	39	55	java/lang/reflect/UndeclaredThrowableException
      //   39	46	55	java/lang/reflect/UndeclaredThrowableException
      //   46	54	55	java/lang/reflect/UndeclaredThrowableException
      //   70	76	55	java/lang/reflect/UndeclaredThrowableException
      //   89	99	55	java/lang/reflect/UndeclaredThrowableException
      //   39	46	68	java/util/concurrent/CancellationException
      //   2	19	77	java/lang/Throwable
      //   29	39	77	java/lang/Throwable
      //   39	46	77	java/lang/Throwable
      //   46	54	77	java/lang/Throwable
      //   70	76	77	java/lang/Throwable
      //   89	99	77	java/lang/Throwable
      //   39	46	87	java/util/concurrent/ExecutionException
    }
  }
  
  static final class AsyncCatchingFuture<V, X extends Throwable>
    extends Futures.AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>>
  {
    AsyncCatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction)
    {
      super(paramClass, paramAsyncFunction);
    }
    
    void doFallback(AsyncFunction<? super X, ? extends V> paramAsyncFunction, X paramX)
      throws Exception
    {
      paramAsyncFunction = paramAsyncFunction.apply(paramX);
      Preconditions.checkNotNull(paramAsyncFunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      setFuture(paramAsyncFunction);
    }
  }
  
  private static final class AsyncChainingFuture<I, O>
    extends Futures.AbstractChainingFuture<I, O, AsyncFunction<? super I, ? extends O>>
  {
    AsyncChainingFuture(ListenableFuture<? extends I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
    {
      super(paramAsyncFunction);
    }
    
    void doTransform(AsyncFunction<? super I, ? extends O> paramAsyncFunction, I paramI)
      throws Exception
    {
      paramAsyncFunction = paramAsyncFunction.apply(paramI);
      Preconditions.checkNotNull(paramAsyncFunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      setFuture(paramAsyncFunction);
    }
  }
  
  static final class CatchingFuture<V, X extends Throwable>
    extends Futures.AbstractCatchingFuture<V, X, Function<? super X, ? extends V>>
  {
    CatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction)
    {
      super(paramClass, paramFunction);
    }
    
    void doFallback(Function<? super X, ? extends V> paramFunction, X paramX)
      throws Exception
    {
      set(paramFunction.apply(paramX));
    }
  }
  
  private static final class ChainingFuture<I, O>
    extends Futures.AbstractChainingFuture<I, O, Function<? super I, ? extends O>>
  {
    ChainingFuture(ListenableFuture<? extends I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
    {
      super(paramFunction);
    }
    
    void doTransform(Function<? super I, ? extends O> paramFunction, I paramI)
    {
      set(paramFunction.apply(paramI));
    }
  }
  
  @GwtIncompatible("TODO")
  private static class ImmediateCancelledFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    private final CancellationException thrown = new CancellationException("Immediate cancelled future.");
    
    ImmediateCancelledFuture()
    {
      super();
    }
    
    public V get()
    {
      throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
    }
    
    public boolean isCancelled()
    {
      return true;
    }
  }
  
  @GwtIncompatible("TODO")
  private static class ImmediateFailedCheckedFuture<V, X extends Exception>
    extends Futures.ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    private final X thrown;
    
    ImmediateFailedCheckedFuture(X paramX)
    {
      super();
      this.thrown = paramX;
    }
    
    public V checkedGet()
      throws Exception
    {
      throw this.thrown;
    }
    
    public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
      throws Exception
    {
      Preconditions.checkNotNull(paramTimeUnit);
      throw this.thrown;
    }
    
    public V get()
      throws ExecutionException
    {
      throw new ExecutionException(this.thrown);
    }
  }
  
  private static class ImmediateFailedFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    private final Throwable thrown;
    
    ImmediateFailedFuture(Throwable paramThrowable)
    {
      super();
      this.thrown = paramThrowable;
    }
    
    public V get()
      throws ExecutionException
    {
      throw new ExecutionException(this.thrown);
    }
  }
  
  private static abstract class ImmediateFuture<V>
    implements ListenableFuture<V>
  {
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
    
    public void addListener(Runnable paramRunnable, Executor paramExecutor)
    {
      Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
      Preconditions.checkNotNull(paramExecutor, "Executor was null.");
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
    
    public boolean cancel(boolean paramBoolean)
    {
      return false;
    }
    
    public abstract V get()
      throws ExecutionException;
    
    public V get(long paramLong, TimeUnit paramTimeUnit)
      throws ExecutionException
    {
      Preconditions.checkNotNull(paramTimeUnit);
      return (V)get();
    }
    
    public boolean isCancelled()
    {
      return false;
    }
    
    public boolean isDone()
    {
      return true;
    }
  }
  
  @GwtIncompatible("TODO")
  private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception>
    extends Futures.ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    @Nullable
    private final V value;
    
    ImmediateSuccessfulCheckedFuture(@Nullable V paramV)
    {
      super();
      this.value = paramV;
    }
    
    public V checkedGet()
    {
      return (V)this.value;
    }
    
    public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      return (V)this.value;
    }
    
    public V get()
    {
      return (V)this.value;
    }
  }
  
  private static class ImmediateSuccessfulFuture<V>
    extends Futures.ImmediateFuture<V>
  {
    static final ImmediateSuccessfulFuture<Object> NULL = new ImmediateSuccessfulFuture(null);
    @Nullable
    private final V value;
    
    ImmediateSuccessfulFuture(@Nullable V paramV)
    {
      super();
      this.value = paramV;
    }
    
    public V get()
    {
      return (V)this.value;
    }
  }
  
  private static final class ListFuture<V>
    extends CollectionFuture<V, List<V>>
  {
    ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> paramImmutableCollection, boolean paramBoolean)
    {
      init(new ListFutureRunningState(paramImmutableCollection, paramBoolean));
    }
    
    private final class ListFutureRunningState
      extends CollectionFuture<V, List<V>>.CollectionFutureRunningState
    {
      ListFutureRunningState(boolean paramBoolean)
      {
        super(paramBoolean, bool);
      }
      
      public List<V> combine(List<Optional<V>> paramList)
      {
        ArrayList localArrayList = Lists.newArrayList();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (Optional)localIterator.next();
          if (paramList != null) {}
          for (paramList = paramList.orNull();; paramList = null)
          {
            localArrayList.add(paramList);
            break;
          }
        }
        return Collections.unmodifiableList(localArrayList);
      }
    }
  }
  
  @GwtIncompatible("TODO")
  private static class MappingCheckedFuture<V, X extends Exception>
    extends AbstractCheckedFuture<V, X>
  {
    final Function<? super Exception, X> mapper;
    
    MappingCheckedFuture(ListenableFuture<V> paramListenableFuture, Function<? super Exception, X> paramFunction)
    {
      super();
      this.mapper = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    protected X mapException(Exception paramException)
    {
      return (Exception)this.mapper.apply(paramException);
    }
  }
  
  @GwtIncompatible("TODO")
  private static final class NonCancellationPropagatingFuture<V>
    extends AbstractFuture.TrustedFuture<V>
  {
    NonCancellationPropagatingFuture(final ListenableFuture<V> paramListenableFuture)
    {
      paramListenableFuture.addListener(new Runnable()
      {
        public void run()
        {
          Futures.NonCancellationPropagatingFuture.this.setFuture(paramListenableFuture);
        }
      }, MoreExecutors.directExecutor());
    }
  }
  
  private static final class TimeoutFuture<V>
    extends AbstractFuture.TrustedFuture<V>
  {
    @Nullable
    ListenableFuture<V> delegateRef;
    @Nullable
    Future<?> timer;
    
    TimeoutFuture(ListenableFuture<V> paramListenableFuture)
    {
      this.delegateRef = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
    }
    
    void done()
    {
      maybePropagateCancellation(this.delegateRef);
      Future localFuture = this.timer;
      if (localFuture != null) {
        localFuture.cancel(false);
      }
      this.delegateRef = null;
      this.timer = null;
    }
    
    private static final class Fire<V>
      implements Runnable
    {
      @Nullable
      Futures.TimeoutFuture<V> timeoutFutureRef;
      
      Fire(Futures.TimeoutFuture<V> paramTimeoutFuture)
      {
        this.timeoutFutureRef = paramTimeoutFuture;
      }
      
      public void run()
      {
        Futures.TimeoutFuture localTimeoutFuture = this.timeoutFutureRef;
        if (localTimeoutFuture == null) {}
        ListenableFuture localListenableFuture;
        do
        {
          return;
          localListenableFuture = localTimeoutFuture.delegateRef;
        } while (localListenableFuture == null);
        this.timeoutFutureRef = null;
        if (localListenableFuture.isDone())
        {
          localTimeoutFuture.setFuture(localListenableFuture);
          return;
        }
        try
        {
          localTimeoutFuture.setException(new TimeoutException("Future timed out: " + localListenableFuture));
          return;
        }
        finally
        {
          localListenableFuture.cancel(true);
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/Futures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */