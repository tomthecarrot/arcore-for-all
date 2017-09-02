package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class SerializingExecutor
  implements Executor
{
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  private final Executor executor;
  private final Object internalLock = new Object()
  {
    public String toString()
    {
      return "SerializingExecutor lock: " + super.toString();
    }
  };
  @GuardedBy("internalLock")
  private boolean isThreadScheduled = false;
  private final TaskRunner taskRunner = new TaskRunner(null);
  @GuardedBy("internalLock")
  private final Queue<Runnable> waitQueue = new ArrayDeque(4);
  
  public SerializingExecutor(Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramExecutor, "'executor' must not be null.");
    this.executor = paramExecutor;
  }
  
  /* Error */
  public void execute(Runnable arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 90
    //   3: invokestatic 74	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 66	io/grpc/internal/SerializingExecutor:internalLock	Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 54	io/grpc/internal/SerializingExecutor:waitQueue	Ljava/util/Queue;
    //   20: aload_1
    //   21: invokeinterface 96 2 0
    //   26: pop
    //   27: aload_0
    //   28: getfield 56	io/grpc/internal/SerializingExecutor:isThreadScheduled	Z
    //   31: ifne +10 -> 41
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 56	io/grpc/internal/SerializingExecutor:isThreadScheduled	Z
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_3
    //   42: monitorexit
    //   43: iload_2
    //   44: ifeq +34 -> 78
    //   47: aload_0
    //   48: getfield 76	io/grpc/internal/SerializingExecutor:executor	Ljava/util/concurrent/Executor;
    //   51: aload_0
    //   52: getfield 61	io/grpc/internal/SerializingExecutor:taskRunner	Lio/grpc/internal/SerializingExecutor$TaskRunner;
    //   55: invokeinterface 98 2 0
    //   60: iconst_0
    //   61: ifeq +17 -> 78
    //   64: aload_0
    //   65: getfield 66	io/grpc/internal/SerializingExecutor:internalLock	Ljava/lang/Object;
    //   68: astore_1
    //   69: aload_1
    //   70: monitorenter
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 56	io/grpc/internal/SerializingExecutor:isThreadScheduled	Z
    //   76: aload_1
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_3
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: iconst_1
    //   91: ifeq +17 -> 108
    //   94: aload_0
    //   95: getfield 66	io/grpc/internal/SerializingExecutor:internalLock	Ljava/lang/Object;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 56	io/grpc/internal/SerializingExecutor:isThreadScheduled	Z
    //   106: aload_1
    //   107: monitorexit
    //   108: aload_3
    //   109: athrow
    //   110: astore_3
    //   111: aload_1
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	SerializingExecutor
    //   8	36	2	i	int
    //   13	68	3	localObject1	Object
    //   84	4	3	localObject2	Object
    //   89	20	3	localObject3	Object
    //   110	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	79	finally
    //   27	39	79	finally
    //   41	43	79	finally
    //   80	82	79	finally
    //   71	78	84	finally
    //   85	87	84	finally
    //   47	60	89	finally
    //   101	108	110	finally
    //   111	113	110	finally
  }
  
  private class TaskRunner
    implements Runnable
  {
    private TaskRunner() {}
    
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
      //   7: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   10: invokestatic 29	io/grpc/internal/SerializingExecutor:access$100	(Lio/grpc/internal/SerializingExecutor;)Ljava/lang/Object;
      //   13: astore 4
      //   15: iload_2
      //   16: istore_1
      //   17: aload 4
      //   19: monitorenter
      //   20: iload_3
      //   21: istore_1
      //   22: aload_0
      //   23: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   26: invokestatic 33	io/grpc/internal/SerializingExecutor:access$200	(Lio/grpc/internal/SerializingExecutor;)Z
      //   29: invokestatic 39	com/google/common/base/Preconditions:checkState	(Z)V
      //   32: iload_3
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   38: invokestatic 43	io/grpc/internal/SerializingExecutor:access$300	(Lio/grpc/internal/SerializingExecutor;)Ljava/util/Queue;
      //   41: invokeinterface 49 1 0
      //   46: checkcast 6	java/lang/Runnable
      //   49: astore 5
      //   51: aload 5
      //   53: ifnonnull +48 -> 101
      //   56: iload_3
      //   57: istore_1
      //   58: aload_0
      //   59: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   62: iconst_0
      //   63: invokestatic 53	io/grpc/internal/SerializingExecutor:access$202	(Lio/grpc/internal/SerializingExecutor;Z)Z
      //   66: pop
      //   67: iconst_0
      //   68: istore_1
      //   69: aload 4
      //   71: monitorexit
      //   72: iconst_0
      //   73: ifeq +27 -> 100
      //   76: aload_0
      //   77: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   80: invokestatic 29	io/grpc/internal/SerializingExecutor:access$100	(Lio/grpc/internal/SerializingExecutor;)Ljava/lang/Object;
      //   83: astore 4
      //   85: aload 4
      //   87: monitorenter
      //   88: aload_0
      //   89: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   92: iconst_0
      //   93: invokestatic 53	io/grpc/internal/SerializingExecutor:access$202	(Lio/grpc/internal/SerializingExecutor;Z)Z
      //   96: pop
      //   97: aload 4
      //   99: monitorexit
      //   100: return
      //   101: iload_3
      //   102: istore_1
      //   103: aload 4
      //   105: monitorexit
      //   106: iload_2
      //   107: istore_1
      //   108: aload 5
      //   110: invokeinterface 55 1 0
      //   115: goto -111 -> 4
      //   118: astore 4
      //   120: iload_2
      //   121: istore_1
      //   122: invokestatic 59	io/grpc/internal/SerializingExecutor:access$400	()Ljava/util/logging/Logger;
      //   125: getstatic 65	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
      //   128: new 67	java/lang/StringBuilder
      //   131: dup
      //   132: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   135: ldc 70
      //   137: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: aload 5
      //   142: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   145: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: aload 4
      //   150: invokevirtual 87	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   153: goto -149 -> 4
      //   156: astore 5
      //   158: iload_1
      //   159: ifeq +27 -> 186
      //   162: aload_0
      //   163: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   166: invokestatic 29	io/grpc/internal/SerializingExecutor:access$100	(Lio/grpc/internal/SerializingExecutor;)Ljava/lang/Object;
      //   169: astore 4
      //   171: aload 4
      //   173: monitorenter
      //   174: aload_0
      //   175: getfield 15	io/grpc/internal/SerializingExecutor$TaskRunner:this$0	Lio/grpc/internal/SerializingExecutor;
      //   178: iconst_0
      //   179: invokestatic 53	io/grpc/internal/SerializingExecutor:access$202	(Lio/grpc/internal/SerializingExecutor;Z)Z
      //   182: pop
      //   183: aload 4
      //   185: monitorexit
      //   186: aload 5
      //   188: athrow
      //   189: astore 5
      //   191: aload 4
      //   193: monitorexit
      //   194: aload 5
      //   196: athrow
      //   197: astore 5
      //   199: aload 4
      //   201: monitorexit
      //   202: aload 5
      //   204: athrow
      //   205: astore 5
      //   207: aload 4
      //   209: monitorexit
      //   210: aload 5
      //   212: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	213	0	this	TaskRunner
      //   5	154	1	i	int
      //   3	118	2	j	int
      //   1	101	3	k	int
      //   118	31	4	localRuntimeException	RuntimeException
      //   49	92	5	localRunnable	Runnable
      //   156	31	5	localObject3	Object
      //   189	6	5	localObject4	Object
      //   197	6	5	localObject5	Object
      //   205	6	5	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   108	115	118	java/lang/RuntimeException
      //   6	15	156	finally
      //   17	20	156	finally
      //   108	115	156	finally
      //   122	153	156	finally
      //   194	197	156	finally
      //   22	32	189	finally
      //   34	51	189	finally
      //   58	67	189	finally
      //   69	72	189	finally
      //   103	106	189	finally
      //   191	194	189	finally
      //   88	100	197	finally
      //   199	202	197	finally
      //   174	186	205	finally
      //   207	210	205	finally
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/SerializingExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */