package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class ListenerCallQueue<L>
  implements Runnable
{
  private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
  private final Executor executor;
  @GuardedBy("this")
  private boolean isThreadScheduled;
  private final L listener;
  @GuardedBy("this")
  private final Queue<Callback<L>> waitQueue = Queues.newArrayDeque();
  
  ListenerCallQueue(L paramL, Executor paramExecutor)
  {
    this.listener = Preconditions.checkNotNull(paramL);
    this.executor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  void add(Callback<L> paramCallback)
  {
    try
    {
      this.waitQueue.add(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  /* Error */
  void execute()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   8: ifne +10 -> 18
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ifeq +13 -> 34
    //   24: aload_0
    //   25: getfield 66	com/google/common/util/concurrent/ListenerCallQueue:executor	Ljava/util/concurrent/Executor;
    //   28: aload_0
    //   29: invokeinterface 84 2 0
    //   34: return
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    //   40: astore_2
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: getstatic 41	com/google/common/util/concurrent/ListenerCallQueue:logger	Ljava/util/logging/Logger;
    //   53: getstatic 90	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   56: new 92	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   63: ldc 95
    //   65: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 62	com/google/common/util/concurrent/ListenerCallQueue:listener	Ljava/lang/Object;
    //   72: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: ldc 104
    //   77: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 66	com/google/common/util/concurrent/ListenerCallQueue:executor	Ljava/util/concurrent/Executor;
    //   84: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: aload_2
    //   91: invokevirtual 111	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ListenerCallQueue
    //   1	20	1	i	int
    //   35	4	2	localObject1	Object
    //   40	55	2	localRuntimeException	RuntimeException
    //   96	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	35	finally
    //   18	20	35	finally
    //   36	38	35	finally
    //   24	34	40	java/lang/RuntimeException
    //   43	50	96	finally
    //   97	99	96	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: iload_2
    //   5: istore_1
    //   6: aload_0
    //   7: monitorenter
    //   8: iload_3
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   14: invokestatic 116	com/google/common/base/Preconditions:checkState	(Z)V
    //   17: iload_3
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 54	com/google/common/util/concurrent/ListenerCallQueue:waitQueue	Ljava/util/Queue;
    //   23: invokeinterface 120 1 0
    //   28: checkcast 9	com/google/common/util/concurrent/ListenerCallQueue$Callback
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +28 -> 63
    //   38: iload_3
    //   39: istore_1
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   45: iconst_0
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ifeq +12 -> 62
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: iload_3
    //   64: istore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: iload_2
    //   68: istore_1
    //   69: aload 4
    //   71: aload_0
    //   72: getfield 62	com/google/common/util/concurrent/ListenerCallQueue:listener	Ljava/lang/Object;
    //   75: invokevirtual 124	com/google/common/util/concurrent/ListenerCallQueue$Callback:call	(Ljava/lang/Object;)V
    //   78: goto -74 -> 4
    //   81: astore 5
    //   83: iload_2
    //   84: istore_1
    //   85: getstatic 41	com/google/common/util/concurrent/ListenerCallQueue:logger	Ljava/util/logging/Logger;
    //   88: getstatic 90	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   91: new 92	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   98: ldc 126
    //   100: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 62	com/google/common/util/concurrent/ListenerCallQueue:listener	Ljava/lang/Object;
    //   107: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: ldc -128
    //   112: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokestatic 132	com/google/common/util/concurrent/ListenerCallQueue$Callback:access$000	(Lcom/google/common/util/concurrent/ListenerCallQueue$Callback;)Ljava/lang/String;
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aload 5
    //   128: invokevirtual 111	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto -127 -> 4
    //   134: astore 4
    //   136: iload_1
    //   137: ifeq +12 -> 149
    //   140: aload_0
    //   141: monitorenter
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 81	com/google/common/util/concurrent/ListenerCallQueue:isThreadScheduled	Z
    //   147: aload_0
    //   148: monitorexit
    //   149: aload 4
    //   151: athrow
    //   152: astore 4
    //   154: aload_0
    //   155: monitorexit
    //   156: aload 4
    //   158: athrow
    //   159: astore 4
    //   161: aload_0
    //   162: monitorexit
    //   163: aload 4
    //   165: athrow
    //   166: astore 4
    //   168: aload_0
    //   169: monitorexit
    //   170: aload 4
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ListenerCallQueue
    //   5	132	1	i	int
    //   3	81	2	j	int
    //   1	63	3	k	int
    //   31	85	4	localCallback	Callback
    //   134	16	4	localObject1	Object
    //   152	5	4	localObject2	Object
    //   159	5	4	localObject3	Object
    //   166	5	4	localObject4	Object
    //   81	46	5	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   69	78	81	java/lang/RuntimeException
    //   6	8	134	finally
    //   69	78	134	finally
    //   85	131	134	finally
    //   156	159	134	finally
    //   10	17	152	finally
    //   19	33	152	finally
    //   40	45	152	finally
    //   47	49	152	finally
    //   65	67	152	finally
    //   154	156	152	finally
    //   55	62	159	finally
    //   161	163	159	finally
    //   142	149	166	finally
    //   168	170	166	finally
  }
  
  static abstract class Callback<L>
  {
    private final String methodCall;
    
    Callback(String paramString)
    {
      this.methodCall = paramString;
    }
    
    abstract void call(L paramL);
    
    void enqueueOn(Iterable<ListenerCallQueue<L>> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        ((ListenerCallQueue)paramIterable.next()).add(this);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/ListenerCallQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */