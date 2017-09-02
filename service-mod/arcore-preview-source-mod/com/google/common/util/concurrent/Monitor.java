package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
public final class Monitor
{
  @GuardedBy("lock")
  private Guard activeGuards = null;
  private final boolean fair;
  private final ReentrantLock lock;
  
  public Monitor()
  {
    this(false);
  }
  
  public Monitor(boolean paramBoolean)
  {
    this.fair = paramBoolean;
    this.lock = new ReentrantLock(paramBoolean);
  }
  
  @GuardedBy("lock")
  private void await(Guard paramGuard, boolean paramBoolean)
    throws InterruptedException
  {
    if (paramBoolean) {
      signalNextWaiter();
    }
    beginWaitingFor(paramGuard);
    try
    {
      do
      {
        paramGuard.condition.await();
        paramBoolean = paramGuard.isSatisfied();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      endWaitingFor(paramGuard);
    }
  }
  
  @GuardedBy("lock")
  private boolean awaitNanos(Guard paramGuard, long paramLong, boolean paramBoolean)
    throws InterruptedException
  {
    int i = 1;
    for (;;)
    {
      boolean bool;
      if (paramLong <= 0L)
      {
        bool = false;
        paramBoolean = bool;
        if (i == 0)
        {
          endWaitingFor(paramGuard);
          paramBoolean = bool;
        }
        return paramBoolean;
      }
      int j = i;
      int k;
      if (i != 0) {
        if (paramBoolean) {
          k = i;
        }
      }
      try
      {
        signalNextWaiter();
        k = i;
        beginWaitingFor(paramGuard);
        j = 0;
        k = j;
        paramLong = paramGuard.condition.awaitNanos(paramLong);
        k = j;
        bool = paramGuard.isSatisfied();
        i = j;
        if (!bool) {
          continue;
        }
        paramBoolean = true;
        return true;
      }
      finally
      {
        if (k == 0) {
          endWaitingFor(paramGuard);
        }
      }
    }
  }
  
  @GuardedBy("lock")
  private void awaitUninterruptibly(Guard paramGuard, boolean paramBoolean)
  {
    if (paramBoolean) {
      signalNextWaiter();
    }
    beginWaitingFor(paramGuard);
    try
    {
      do
      {
        paramGuard.condition.awaitUninterruptibly();
        paramBoolean = paramGuard.isSatisfied();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      endWaitingFor(paramGuard);
    }
  }
  
  @GuardedBy("lock")
  private void beginWaitingFor(Guard paramGuard)
  {
    int i = paramGuard.waiterCount;
    paramGuard.waiterCount = (i + 1);
    if (i == 0)
    {
      paramGuard.next = this.activeGuards;
      this.activeGuards = paramGuard;
    }
  }
  
  @GuardedBy("lock")
  private void endWaitingFor(Guard paramGuard)
  {
    int i = paramGuard.waiterCount - 1;
    paramGuard.waiterCount = i;
    Guard localGuard1;
    Guard localGuard2;
    if (i == 0)
    {
      localGuard1 = this.activeGuards;
      localGuard2 = null;
    }
    for (;;)
    {
      if (localGuard1 == paramGuard)
      {
        if (localGuard2 == null) {
          this.activeGuards = localGuard1.next;
        }
        for (;;)
        {
          localGuard1.next = null;
          return;
          localGuard2.next = localGuard1.next;
        }
      }
      localGuard2 = localGuard1;
      localGuard1 = localGuard1.next;
    }
  }
  
  private static long initNanoTime(long paramLong)
  {
    if (paramLong <= 0L) {
      paramLong = 0L;
    }
    long l;
    do
    {
      return paramLong;
      l = System.nanoTime();
      paramLong = l;
    } while (l != 0L);
    return 1L;
  }
  
  @GuardedBy("lock")
  private boolean isSatisfied(Guard paramGuard)
  {
    try
    {
      boolean bool = paramGuard.isSatisfied();
      return bool;
    }
    catch (Throwable paramGuard)
    {
      signalAllWaiters();
      throw Throwables.propagate(paramGuard);
    }
  }
  
  private static long remainingNanos(long paramLong1, long paramLong2)
  {
    if (paramLong2 <= 0L) {
      return 0L;
    }
    return paramLong2 - (System.nanoTime() - paramLong1);
  }
  
  @GuardedBy("lock")
  private void signalAllWaiters()
  {
    for (Guard localGuard = this.activeGuards; localGuard != null; localGuard = localGuard.next) {
      localGuard.condition.signalAll();
    }
  }
  
  @GuardedBy("lock")
  private void signalNextWaiter()
  {
    for (Guard localGuard = this.activeGuards;; localGuard = localGuard.next) {
      if (localGuard != null)
      {
        if (isSatisfied(localGuard)) {
          localGuard.condition.signal();
        }
      }
      else {
        return;
      }
    }
  }
  
  private static long toSafeNanos(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = paramTimeUnit.toNanos(paramLong);
    if (l <= 0L) {
      paramLong = 0L;
    }
    do
    {
      return paramLong;
      paramLong = l;
    } while (l <= 6917529027641081853L);
    return 6917529027641081853L;
  }
  
  public void enter()
  {
    this.lock.lock();
  }
  
  /* Error */
  public boolean enter(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: lload_1
    //   1: aload_3
    //   2: invokestatic 122	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   5: lstore 4
    //   7: aload_0
    //   8: getfield 33	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 28	com/google/common/util/concurrent/Monitor:fair	Z
    //   16: ifne +16 -> 32
    //   19: aload_3
    //   20: invokevirtual 125	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   23: ifeq +9 -> 32
    //   26: iconst_1
    //   27: istore 9
    //   29: iload 9
    //   31: ireturn
    //   32: invokestatic 130	java/lang/Thread:interrupted	()Z
    //   35: istore 8
    //   37: iload 8
    //   39: istore 9
    //   41: invokestatic 85	java/lang/System:nanoTime	()J
    //   44: lstore 6
    //   46: lload 4
    //   48: lstore_1
    //   49: iload 8
    //   51: istore 9
    //   53: aload_3
    //   54: lload_1
    //   55: getstatic 134	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   58: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   61: istore 10
    //   63: iload 10
    //   65: istore 9
    //   67: iload 8
    //   69: ifeq -40 -> 29
    //   72: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: invokevirtual 143	java/lang/Thread:interrupt	()V
    //   78: iload 10
    //   80: ireturn
    //   81: astore 11
    //   83: iconst_1
    //   84: istore 9
    //   86: iconst_1
    //   87: istore 8
    //   89: lload 6
    //   91: lload 4
    //   93: invokestatic 145	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   96: lstore_1
    //   97: goto -48 -> 49
    //   100: astore_3
    //   101: iload 9
    //   103: ifeq +9 -> 112
    //   106: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   109: invokevirtual 143	java/lang/Thread:interrupt	()V
    //   112: aload_3
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	Monitor
    //   0	114	1	paramLong	long
    //   0	114	3	paramTimeUnit	TimeUnit
    //   5	87	4	l1	long
    //   44	46	6	l2	long
    //   35	53	8	bool1	boolean
    //   27	75	9	bool2	boolean
    //   61	18	10	bool3	boolean
    //   81	1	11	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   53	63	81	java/lang/InterruptedException
    //   41	46	100	finally
    //   53	63	100	finally
    //   89	97	100	finally
  }
  
  public boolean enterIf(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      boolean bool = paramGuard.isSatisfied();
      if (!bool) {
        localReentrantLock.unlock();
      }
      return bool;
    }
    finally
    {
      if (0 == 0) {
        localReentrantLock.unlock();
      }
    }
  }
  
  public boolean enterIf(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    boolean bool1;
    if (!enter(paramLong, paramTimeUnit)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        this.lock.unlock();
        return bool2;
      }
      finally
      {
        if (0 == 0) {
          this.lock.unlock();
        }
      }
    }
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      boolean bool = paramGuard.isSatisfied();
      if (!bool) {
        localReentrantLock.unlock();
      }
      return bool;
    }
    finally
    {
      if (0 == 0) {
        localReentrantLock.unlock();
      }
    }
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool1;
    if (!localReentrantLock.tryLock(paramLong, paramTimeUnit)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        localReentrantLock.unlock();
        return bool2;
      }
      finally
      {
        if (0 == 0) {
          localReentrantLock.unlock();
        }
      }
    }
  }
  
  public void enterInterruptibly()
    throws InterruptedException
  {
    this.lock.lockInterruptibly();
  }
  
  public boolean enterInterruptibly(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.lock.tryLock(paramLong, paramTimeUnit);
  }
  
  public void enterWhen(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool = localReentrantLock.isHeldByCurrentThread();
    localReentrantLock.lockInterruptibly();
    try
    {
      if (!paramGuard.isSatisfied()) {
        await(paramGuard, bool);
      }
      if (1 == 0) {
        leave();
      }
      return;
    }
    finally
    {
      if (0 == 0) {
        leave();
      }
    }
  }
  
  /* Error */
  public boolean enterWhen(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: lload_2
    //   1: aload 4
    //   3: invokestatic 122	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore 7
    //   8: aload_1
    //   9: getfield 150	com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpeq +11 -> 24
    //   16: new 152	java/lang/IllegalMonitorStateException
    //   19: dup
    //   20: invokespecial 153	java/lang/IllegalMonitorStateException:<init>	()V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 33	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: astore 11
    //   30: aload 11
    //   32: invokevirtual 168	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   35: istore 10
    //   37: lconst_0
    //   38: lstore 5
    //   40: aload_0
    //   41: getfield 28	com/google/common/util/concurrent/Monitor:fair	Z
    //   44: ifne +86 -> 130
    //   47: invokestatic 130	java/lang/Thread:interrupted	()Z
    //   50: ifeq +11 -> 61
    //   53: new 39	java/lang/InterruptedException
    //   56: dup
    //   57: invokespecial 174	java/lang/InterruptedException:<init>	()V
    //   60: athrow
    //   61: aload 11
    //   63: invokevirtual 125	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   66: ifeq +64 -> 130
    //   69: aload_1
    //   70: invokevirtual 58	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   73: ifne +28 -> 101
    //   76: lload 5
    //   78: lconst_0
    //   79: lcmp
    //   80: ifne +70 -> 150
    //   83: lload 7
    //   85: lstore_2
    //   86: aload_0
    //   87: aload_1
    //   88: lload_2
    //   89: iload 10
    //   91: invokespecial 176	com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   94: istore 9
    //   96: iload 9
    //   98: ifeq +63 -> 161
    //   101: iconst_1
    //   102: istore 9
    //   104: iload 9
    //   106: ifne +21 -> 127
    //   109: iconst_0
    //   110: ifeq +12 -> 122
    //   113: iload 10
    //   115: ifne +7 -> 122
    //   118: aload_0
    //   119: invokespecial 42	com/google/common/util/concurrent/Monitor:signalNextWaiter	()V
    //   122: aload 11
    //   124: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   127: iload 9
    //   129: ireturn
    //   130: lload 7
    //   132: invokestatic 178	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   135: lstore 5
    //   137: aload 11
    //   139: lload_2
    //   140: aload 4
    //   142: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   145: ifne -76 -> 69
    //   148: iconst_0
    //   149: ireturn
    //   150: lload 5
    //   152: lload 7
    //   154: invokestatic 145	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   157: lstore_2
    //   158: goto -72 -> 86
    //   161: iconst_0
    //   162: istore 9
    //   164: goto -60 -> 104
    //   167: astore_1
    //   168: aload 11
    //   170: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: iconst_0
    //   177: ifne +21 -> 198
    //   180: iconst_1
    //   181: ifeq +12 -> 193
    //   184: iload 10
    //   186: ifne +7 -> 193
    //   189: aload_0
    //   190: invokespecial 42	com/google/common/util/concurrent/Monitor:signalNextWaiter	()V
    //   193: aload 11
    //   195: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: aload 11
    //   203: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	Monitor
    //   0	208	1	paramGuard	Guard
    //   0	208	2	paramLong	long
    //   0	208	4	paramTimeUnit	TimeUnit
    //   38	113	5	l1	long
    //   6	147	7	l2	long
    //   94	69	9	bool1	boolean
    //   35	150	10	bool2	boolean
    //   28	174	11	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   118	122	167	finally
    //   69	76	175	finally
    //   86	96	175	finally
    //   150	158	175	finally
    //   189	193	200	finally
  }
  
  public void enterWhenUninterruptibly(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool = localReentrantLock.isHeldByCurrentThread();
    localReentrantLock.lock();
    try
    {
      if (!paramGuard.isSatisfied()) {
        awaitUninterruptibly(paramGuard, bool);
      }
      if (1 == 0) {
        leave();
      }
      return;
    }
    finally
    {
      if (0 == 0) {
        leave();
      }
    }
  }
  
  /* Error */
  public boolean enterWhenUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: lload_2
    //   1: aload 4
    //   3: invokestatic 122	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore 5
    //   8: aload_1
    //   9: getfield 150	com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpeq +11 -> 24
    //   16: new 152	java/lang/IllegalMonitorStateException
    //   19: dup
    //   20: invokespecial 153	java/lang/IllegalMonitorStateException:<init>	()V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 33	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: astore 4
    //   30: lconst_0
    //   31: lstore_2
    //   32: aload 4
    //   34: invokevirtual 168	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   37: istore 14
    //   39: invokestatic 130	java/lang/Thread:interrupted	()Z
    //   42: istore 13
    //   44: iload 13
    //   46: istore 11
    //   48: aload_0
    //   49: getfield 28	com/google/common/util/concurrent/Monitor:fair	Z
    //   52: ifne +19 -> 71
    //   55: iload 13
    //   57: istore 12
    //   59: iload 13
    //   61: istore 11
    //   63: aload 4
    //   65: invokevirtual 125	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   68: ifne +42 -> 110
    //   71: iload 13
    //   73: istore 11
    //   75: lload 5
    //   77: invokestatic 178	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   80: lstore_2
    //   81: lload 5
    //   83: lstore 7
    //   85: iload 13
    //   87: istore 12
    //   89: iload 12
    //   91: istore 11
    //   93: aload 4
    //   95: lload 7
    //   97: getstatic 134	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   100: invokevirtual 136	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   103: istore 13
    //   105: iload 13
    //   107: ifeq +60 -> 167
    //   110: iload 14
    //   112: istore 11
    //   114: lload_2
    //   115: lstore 7
    //   117: aload_1
    //   118: invokevirtual 58	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   121: istore 13
    //   123: iload 13
    //   125: ifeq +77 -> 202
    //   128: iconst_1
    //   129: istore 13
    //   131: iload 13
    //   133: ifne +12 -> 145
    //   136: iload 12
    //   138: istore 11
    //   140: aload 4
    //   142: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   145: iload 13
    //   147: istore 11
    //   149: iload 12
    //   151: ifeq +13 -> 164
    //   154: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   157: invokevirtual 143	java/lang/Thread:interrupt	()V
    //   160: iload 13
    //   162: istore 11
    //   164: iload 11
    //   166: ireturn
    //   167: iconst_0
    //   168: istore 11
    //   170: iload 12
    //   172: ifeq -8 -> 164
    //   175: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   178: invokevirtual 143	java/lang/Thread:interrupt	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore 15
    //   185: iconst_1
    //   186: istore 11
    //   188: iconst_1
    //   189: istore 12
    //   191: lload_2
    //   192: lload 5
    //   194: invokestatic 145	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   197: lstore 7
    //   199: goto -110 -> 89
    //   202: lload_2
    //   203: lconst_0
    //   204: lcmp
    //   205: ifne +33 -> 238
    //   208: lload_2
    //   209: lstore 7
    //   211: lload 5
    //   213: invokestatic 178	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   216: lstore_2
    //   217: lload 5
    //   219: lstore 9
    //   221: lload_2
    //   222: lstore 7
    //   224: aload_0
    //   225: aload_1
    //   226: lload 9
    //   228: iload 11
    //   230: invokespecial 176	com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   233: istore 13
    //   235: goto -104 -> 131
    //   238: lload_2
    //   239: lstore 7
    //   241: lload_2
    //   242: lload 5
    //   244: invokestatic 145	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   247: lstore 9
    //   249: goto -28 -> 221
    //   252: astore 15
    //   254: iconst_1
    //   255: istore 12
    //   257: iconst_0
    //   258: istore 11
    //   260: lload 7
    //   262: lstore_2
    //   263: goto -149 -> 114
    //   266: astore_1
    //   267: iconst_0
    //   268: ifne +12 -> 280
    //   271: iload 12
    //   273: istore 11
    //   275: aload 4
    //   277: invokevirtual 156	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   280: iload 12
    //   282: istore 11
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: iload 11
    //   289: ifeq +9 -> 298
    //   292: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   295: invokevirtual 143	java/lang/Thread:interrupt	()V
    //   298: aload_1
    //   299: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	Monitor
    //   0	300	1	paramGuard	Guard
    //   0	300	2	paramLong	long
    //   0	300	4	paramTimeUnit	TimeUnit
    //   6	237	5	l1	long
    //   83	178	7	l2	long
    //   219	29	9	l3	long
    //   46	242	11	bool1	boolean
    //   57	224	12	bool2	boolean
    //   42	192	13	bool3	boolean
    //   37	74	14	bool4	boolean
    //   183	1	15	localInterruptedException1	InterruptedException
    //   252	1	15	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   93	105	183	java/lang/InterruptedException
    //   117	123	252	java/lang/InterruptedException
    //   211	217	252	java/lang/InterruptedException
    //   224	235	252	java/lang/InterruptedException
    //   241	249	252	java/lang/InterruptedException
    //   117	123	266	finally
    //   211	217	266	finally
    //   224	235	266	finally
    //   241	249	266	finally
    //   48	55	286	finally
    //   63	71	286	finally
    //   75	81	286	finally
    //   93	105	286	finally
    //   140	145	286	finally
    //   191	199	286	finally
    //   275	280	286	finally
    //   284	286	286	finally
  }
  
  public int getOccupiedDepth()
  {
    return this.lock.getHoldCount();
  }
  
  public int getQueueLength()
  {
    return this.lock.getQueueLength();
  }
  
  public int getWaitQueueLength(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    this.lock.lock();
    try
    {
      int i = paramGuard.waiterCount;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean hasQueuedThread(Thread paramThread)
  {
    return this.lock.hasQueuedThread(paramThread);
  }
  
  public boolean hasQueuedThreads()
  {
    return this.lock.hasQueuedThreads();
  }
  
  public boolean hasWaiters(Guard paramGuard)
  {
    return getWaitQueueLength(paramGuard) > 0;
  }
  
  public boolean isFair()
  {
    return this.fair;
  }
  
  public boolean isOccupied()
  {
    return this.lock.isLocked();
  }
  
  public boolean isOccupiedByCurrentThread()
  {
    return this.lock.isHeldByCurrentThread();
  }
  
  public void leave()
  {
    ReentrantLock localReentrantLock = this.lock;
    try
    {
      if (localReentrantLock.getHoldCount() == 1) {
        signalNextWaiter();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean tryEnter()
  {
    return this.lock.tryLock();
  }
  
  public boolean tryEnterIf(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool1;
    if (!localReentrantLock.tryLock()) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        localReentrantLock.unlock();
        return bool2;
      }
      finally
      {
        if (0 == 0) {
          localReentrantLock.unlock();
        }
      }
    }
  }
  
  public void waitFor(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (!paramGuard.isSatisfied()) {
      await(paramGuard, true);
    }
  }
  
  public boolean waitFor(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = toSafeNanos(paramLong, paramTimeUnit);
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (paramGuard.isSatisfied()) {
      return true;
    }
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    return awaitNanos(paramGuard, paramLong, true);
  }
  
  public void waitForUninterruptibly(Guard paramGuard)
  {
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (!paramGuard.isSatisfied()) {
      awaitUninterruptibly(paramGuard, true);
    }
  }
  
  public boolean waitForUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = toSafeNanos(paramLong, paramTimeUnit);
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    boolean bool2;
    if (paramGuard.isSatisfied()) {
      bool2 = true;
    }
    for (;;)
    {
      return bool2;
      boolean bool3 = true;
      long l2 = initNanoTime(l1);
      boolean bool1 = Thread.interrupted();
      paramLong = l1;
      label77:
      bool2 = bool1;
      try
      {
        bool3 = awaitNanos(paramGuard, paramLong, bool3);
        bool2 = bool3;
        return bool3;
      }
      catch (InterruptedException paramTimeUnit)
      {
        boolean bool4 = true;
        bool1 = true;
        bool2 = bool4;
        bool3 = paramGuard.isSatisfied();
        if (bool3)
        {
          bool2 = true;
          if (1 == 0) {
            continue;
          }
          Thread.currentThread().interrupt();
          return true;
        }
        bool3 = false;
        bool2 = bool4;
        paramLong = remainingNanos(l2, l1);
        break label77;
      }
      finally
      {
        if (bool2) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  @Beta
  public static abstract class Guard
  {
    final Condition condition;
    @Weak
    final Monitor monitor;
    @GuardedBy("monitor.lock")
    Guard next;
    @GuardedBy("monitor.lock")
    int waiterCount = 0;
    
    protected Guard(Monitor paramMonitor)
    {
      this.monitor = ((Monitor)Preconditions.checkNotNull(paramMonitor, "monitor"));
      this.condition = paramMonitor.lock.newCondition();
    }
    
    public abstract boolean isSatisfied();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/Monitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */