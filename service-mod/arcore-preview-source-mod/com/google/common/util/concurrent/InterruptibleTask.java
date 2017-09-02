package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible(emulated=true)
abstract class InterruptibleTask
  implements Runnable
{
  private static final AtomicReferenceFieldUpdater<InterruptibleTask, Thread> RUNNER = AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "runner");
  private volatile boolean doneInterrupting;
  private volatile Thread runner;
  
  final void interruptTask()
  {
    Thread localThread = this.runner;
    if (localThread != null) {
      localThread.interrupt();
    }
    this.doneInterrupting = true;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: getstatic 29	com/google/common/util/concurrent/InterruptibleTask:RUNNER	Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;
    //   3: aload_0
    //   4: aconst_null
    //   5: invokestatic 46	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8: invokevirtual 50	java/util/concurrent/atomic/AtomicReferenceFieldUpdater:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: invokevirtual 53	com/google/common/util/concurrent/InterruptibleTask:runInterruptibly	()V
    //   19: aload_0
    //   20: invokevirtual 57	com/google/common/util/concurrent/InterruptibleTask:wasInterrupted	()Z
    //   23: ifeq -9 -> 14
    //   26: aload_0
    //   27: getfield 41	com/google/common/util/concurrent/InterruptibleTask:doneInterrupting	Z
    //   30: ifne -16 -> 14
    //   33: invokestatic 60	java/lang/Thread:yield	()V
    //   36: goto -10 -> 26
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 57	com/google/common/util/concurrent/InterruptibleTask:wasInterrupted	()Z
    //   44: ifeq +16 -> 60
    //   47: aload_0
    //   48: getfield 41	com/google/common/util/concurrent/InterruptibleTask:doneInterrupting	Z
    //   51: ifne +9 -> 60
    //   54: invokestatic 60	java/lang/Thread:yield	()V
    //   57: goto -10 -> 47
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	InterruptibleTask
    //   39	22	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	19	39	finally
  }
  
  abstract void runInterruptibly();
  
  abstract boolean wasInterrupted();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/InterruptibleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */