package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Beta
@GwtCompatible(emulated=true)
public final class Uninterruptibles
{
  @GwtIncompatible("concurrency")
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch)
  {
    int i = 0;
    try
    {
      paramCountDownLatch.await();
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException = localInterruptedException;
        i = 1;
      }
    }
    finally
    {
      paramCountDownLatch = finally;
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      throw paramCountDownLatch;
    }
  }
  
  /* Error */
  @GwtIncompatible("concurrency")
  public static boolean awaitUninterruptibly(CountDownLatch paramCountDownLatch, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: iload 6
    //   8: istore 4
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 42	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   15: lstore 7
    //   17: iload 6
    //   19: istore 4
    //   21: invokestatic 48	java/lang/System:nanoTime	()J
    //   24: lstore 9
    //   26: lload 7
    //   28: lstore_1
    //   29: iload 5
    //   31: istore 4
    //   33: aload_0
    //   34: lload_1
    //   35: getstatic 52	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   38: invokevirtual 55	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   41: istore 11
    //   43: iload 5
    //   45: ifeq +9 -> 54
    //   48: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   51: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   54: iload 11
    //   56: ireturn
    //   57: astore_3
    //   58: iconst_1
    //   59: istore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: invokestatic 48	java/lang/System:nanoTime	()J
    //   67: lstore_1
    //   68: lload 9
    //   70: lload 7
    //   72: ladd
    //   73: lload_1
    //   74: lsub
    //   75: lstore_1
    //   76: goto -47 -> 29
    //   79: astore_0
    //   80: iload 4
    //   82: ifeq +9 -> 91
    //   85: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramCountDownLatch	CountDownLatch
    //   0	93	1	paramLong	long
    //   0	93	3	paramTimeUnit	TimeUnit
    //   8	73	4	i	int
    //   4	59	5	j	int
    //   1	17	6	k	int
    //   15	56	7	l1	long
    //   24	45	9	l2	long
    //   41	14	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	43	57	java/lang/InterruptedException
    //   10	17	79	finally
    //   21	26	79	finally
    //   33	43	79	finally
    //   64	68	79	finally
  }
  
  public static <V> V getUninterruptibly(Future<V> paramFuture)
    throws ExecutionException
  {
    int i = 0;
    try
    {
      Object localObject = paramFuture.get();
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return (V)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException = localInterruptedException;
        i = 1;
      }
    }
    finally
    {
      paramFuture = finally;
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      throw paramFuture;
    }
  }
  
  /* Error */
  @GwtIncompatible("TODO")
  public static <V> V getUninterruptibly(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException, java.util.concurrent.TimeoutException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: iload 6
    //   8: istore 4
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 42	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   15: lstore 7
    //   17: iload 6
    //   19: istore 4
    //   21: invokestatic 48	java/lang/System:nanoTime	()J
    //   24: lstore 9
    //   26: lload 7
    //   28: lstore_1
    //   29: iload 5
    //   31: istore 4
    //   33: aload_0
    //   34: lload_1
    //   35: getstatic 52	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   38: invokeinterface 75 4 0
    //   43: astore_3
    //   44: iload 5
    //   46: ifeq +9 -> 55
    //   49: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   55: aload_3
    //   56: areturn
    //   57: astore_3
    //   58: iconst_1
    //   59: istore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: invokestatic 48	java/lang/System:nanoTime	()J
    //   67: lstore_1
    //   68: lload 9
    //   70: lload 7
    //   72: ladd
    //   73: lload_1
    //   74: lsub
    //   75: lstore_1
    //   76: goto -47 -> 29
    //   79: astore_0
    //   80: iload 4
    //   82: ifeq +9 -> 91
    //   85: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFuture	Future<V>
    //   0	93	1	paramLong	long
    //   0	93	3	paramTimeUnit	TimeUnit
    //   8	73	4	i	int
    //   4	59	5	j	int
    //   1	17	6	k	int
    //   15	56	7	l1	long
    //   24	45	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   33	44	57	java/lang/InterruptedException
    //   10	17	79	finally
    //   21	26	79	finally
    //   33	44	79	finally
    //   64	68	79	finally
  }
  
  @GwtIncompatible("concurrency")
  public static void joinUninterruptibly(Thread paramThread)
  {
    int i = 0;
    try
    {
      paramThread.join();
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException = localInterruptedException;
        i = 1;
      }
    }
    finally
    {
      paramThread = finally;
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      throw paramThread;
    }
  }
  
  /* Error */
  @GwtIncompatible("concurrency")
  public static void joinUninterruptibly(Thread paramThread, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 88	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore 5
    //   11: iload 6
    //   13: istore 4
    //   15: aload_3
    //   16: lload_1
    //   17: invokevirtual 42	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   20: lstore 7
    //   22: iload 6
    //   24: istore 4
    //   26: invokestatic 48	java/lang/System:nanoTime	()J
    //   29: lstore 9
    //   31: lload 7
    //   33: lstore_1
    //   34: iload 5
    //   36: istore 4
    //   38: getstatic 52	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   41: aload_0
    //   42: lload_1
    //   43: invokevirtual 92	java/util/concurrent/TimeUnit:timedJoin	(Ljava/lang/Thread;J)V
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   54: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   57: return
    //   58: astore_3
    //   59: iconst_1
    //   60: istore 4
    //   62: iconst_1
    //   63: istore 5
    //   65: invokestatic 48	java/lang/System:nanoTime	()J
    //   68: lstore_1
    //   69: lload 9
    //   71: lload 7
    //   73: ladd
    //   74: lload_1
    //   75: lsub
    //   76: lstore_1
    //   77: goto -43 -> 34
    //   80: astore_0
    //   81: iload 4
    //   83: ifeq +9 -> 92
    //   86: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   89: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramThread	Thread
    //   0	94	1	paramLong	long
    //   0	94	3	paramTimeUnit	TimeUnit
    //   13	69	4	i	int
    //   9	55	5	j	int
    //   6	17	6	k	int
    //   20	52	7	l1	long
    //   29	41	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   38	46	58	java/lang/InterruptedException
    //   15	22	80	finally
    //   26	31	80	finally
    //   38	46	80	finally
    //   65	69	80	finally
  }
  
  @GwtIncompatible("concurrency")
  public static <E> void putUninterruptibly(BlockingQueue<E> paramBlockingQueue, E paramE)
  {
    int i = 0;
    try
    {
      paramBlockingQueue.put(paramE);
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException = localInterruptedException;
        i = 1;
      }
    }
    finally
    {
      paramBlockingQueue = finally;
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      throw paramBlockingQueue;
    }
  }
  
  /* Error */
  @GwtIncompatible("concurrency")
  public static void sleepUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 5
    //   8: istore_3
    //   9: aload_2
    //   10: lload_0
    //   11: invokevirtual 42	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   14: lstore 6
    //   16: iload 5
    //   18: istore_3
    //   19: invokestatic 48	java/lang/System:nanoTime	()J
    //   22: lstore 8
    //   24: lload 6
    //   26: lstore_0
    //   27: iload 4
    //   29: istore_3
    //   30: getstatic 52	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: lload_0
    //   34: invokevirtual 107	java/util/concurrent/TimeUnit:sleep	(J)V
    //   37: iload 4
    //   39: ifeq +9 -> 48
    //   42: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   48: return
    //   49: astore_2
    //   50: iconst_1
    //   51: istore_3
    //   52: iconst_1
    //   53: istore 4
    //   55: invokestatic 48	java/lang/System:nanoTime	()J
    //   58: lstore_0
    //   59: lload 8
    //   61: lload 6
    //   63: ladd
    //   64: lload_0
    //   65: lsub
    //   66: lstore_0
    //   67: goto -40 -> 27
    //   70: astore_2
    //   71: iload_3
    //   72: ifeq +9 -> 81
    //   75: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   78: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramLong	long
    //   0	83	2	paramTimeUnit	TimeUnit
    //   8	64	3	i	int
    //   4	50	4	j	int
    //   1	16	5	k	int
    //   14	48	6	l1	long
    //   22	38	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   30	37	49	java/lang/InterruptedException
    //   9	16	70	finally
    //   19	24	70	finally
    //   30	37	70	finally
    //   55	59	70	finally
  }
  
  @GwtIncompatible("concurrency")
  public static <E> E takeUninterruptibly(BlockingQueue<E> paramBlockingQueue)
  {
    int i = 0;
    try
    {
      Object localObject = paramBlockingQueue.take();
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return (E)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException = localInterruptedException;
        i = 1;
      }
    }
    finally
    {
      paramBlockingQueue = finally;
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      throw paramBlockingQueue;
    }
  }
  
  /* Error */
  @GwtIncompatible("concurrency")
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: iload 7
    //   8: istore 5
    //   10: aload 4
    //   12: lload_2
    //   13: invokevirtual 42	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   16: lstore 8
    //   18: iload 7
    //   20: istore 5
    //   22: invokestatic 48	java/lang/System:nanoTime	()J
    //   25: lstore 10
    //   27: lload 8
    //   29: lstore_2
    //   30: iload 6
    //   32: istore 5
    //   34: aload_0
    //   35: iload_1
    //   36: lload_2
    //   37: getstatic 52	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   40: invokevirtual 121	java/util/concurrent/Semaphore:tryAcquire	(IJLjava/util/concurrent/TimeUnit;)Z
    //   43: istore 12
    //   45: iload 6
    //   47: ifeq +9 -> 56
    //   50: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   53: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   56: iload 12
    //   58: ireturn
    //   59: astore 4
    //   61: iconst_1
    //   62: istore 5
    //   64: iconst_1
    //   65: istore 6
    //   67: invokestatic 48	java/lang/System:nanoTime	()J
    //   70: lstore_2
    //   71: lload 10
    //   73: lload 8
    //   75: ladd
    //   76: lload_2
    //   77: lsub
    //   78: lstore_2
    //   79: goto -49 -> 30
    //   82: astore_0
    //   83: iload 5
    //   85: ifeq +9 -> 94
    //   88: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   91: invokevirtual 34	java/lang/Thread:interrupt	()V
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramSemaphore	Semaphore
    //   0	96	1	paramInt	int
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   8	76	5	i	int
    //   4	62	6	j	int
    //   1	18	7	k	int
    //   16	58	8	l1	long
    //   25	47	10	l2	long
    //   43	14	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	45	59	java/lang/InterruptedException
    //   10	18	82	finally
    //   22	27	82	finally
    //   34	45	82	finally
    //   67	71	82	finally
  }
  
  @GwtIncompatible("concurrency")
  public static boolean tryAcquireUninterruptibly(Semaphore paramSemaphore, long paramLong, TimeUnit paramTimeUnit)
  {
    return tryAcquireUninterruptibly(paramSemaphore, 1, paramLong, paramTimeUnit);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/Uninterruptibles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */