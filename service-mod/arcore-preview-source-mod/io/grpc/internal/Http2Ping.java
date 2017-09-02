package io.grpc.internal;

import com.google.common.base.Stopwatch;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public class Http2Ping
{
  private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
  @GuardedBy("this")
  private Map<ClientTransport.PingCallback, Executor> callbacks = new LinkedHashMap();
  @GuardedBy("this")
  private boolean completed;
  private final long data;
  @GuardedBy("this")
  private Throwable failureCause;
  @GuardedBy("this")
  private long roundTripTimeNanos;
  private final Stopwatch stopwatch;
  
  public Http2Ping(long paramLong, Stopwatch paramStopwatch)
  {
    this.data = paramLong;
    this.stopwatch = paramStopwatch;
  }
  
  private static Runnable asRunnable(ClientTransport.PingCallback paramPingCallback, final long paramLong)
  {
    new Runnable()
    {
      public void run()
      {
        Http2Ping.this.onSuccess(paramLong);
      }
    };
  }
  
  private static Runnable asRunnable(ClientTransport.PingCallback paramPingCallback, final Throwable paramThrowable)
  {
    new Runnable()
    {
      public void run()
      {
        Http2Ping.this.onFailure(paramThrowable);
      }
    };
  }
  
  private static void doExecute(Executor paramExecutor, Runnable paramRunnable)
  {
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (Throwable paramExecutor)
    {
      log.log(Level.SEVERE, "Failed to execute PingCallback", paramExecutor);
    }
  }
  
  public static void notifyFailed(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor, Throwable paramThrowable)
  {
    doExecute(paramExecutor, asRunnable(paramPingCallback, paramThrowable));
  }
  
  /* Error */
  public void addCallback(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	io/grpc/internal/Http2Ping:completed	Z
    //   6: ifne +18 -> 24
    //   9: aload_0
    //   10: getfield 51	io/grpc/internal/Http2Ping:callbacks	Ljava/util/Map;
    //   13: aload_1
    //   14: aload_2
    //   15: invokeinterface 101 3 0
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 103	io/grpc/internal/Http2Ping:failureCause	Ljava/lang/Throwable;
    //   28: ifnull +20 -> 48
    //   31: aload_1
    //   32: aload_0
    //   33: getfield 103	io/grpc/internal/Http2Ping:failureCause	Ljava/lang/Throwable;
    //   36: invokestatic 89	io/grpc/internal/Http2Ping:asRunnable	(Lio/grpc/internal/ClientTransport$PingCallback;Ljava/lang/Throwable;)Ljava/lang/Runnable;
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: aload_1
    //   44: invokestatic 91	io/grpc/internal/Http2Ping:doExecute	(Ljava/util/concurrent/Executor;Ljava/lang/Runnable;)V
    //   47: return
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 105	io/grpc/internal/Http2Ping:roundTripTimeNanos	J
    //   53: invokestatic 107	io/grpc/internal/Http2Ping:asRunnable	(Lio/grpc/internal/ClientTransport$PingCallback;J)Ljava/lang/Runnable;
    //   56: astore_1
    //   57: goto -17 -> 40
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	Http2Ping
    //   0	65	1	paramPingCallback	ClientTransport.PingCallback
    //   0	65	2	paramExecutor	Executor
    // Exception table:
    //   from	to	target	type
    //   2	23	60	finally
    //   24	40	60	finally
    //   40	42	60	finally
    //   48	57	60	finally
    //   61	63	60	finally
  }
  
  public boolean complete()
  {
    try
    {
      if (this.completed) {
        return false;
      }
      this.completed = true;
      long l = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
      this.roundTripTimeNanos = l;
      Object localObject1 = this.callbacks;
      this.callbacks = null;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        doExecute((Executor)localEntry.getValue(), asRunnable((ClientTransport.PingCallback)localEntry.getKey(), l));
      }
      return true;
    }
    finally {}
  }
  
  public void failed(Throwable paramThrowable)
  {
    try
    {
      if (this.completed) {
        return;
      }
      this.completed = true;
      this.failureCause = paramThrowable;
      Object localObject = this.callbacks;
      this.callbacks = null;
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        notifyFailed((ClientTransport.PingCallback)localEntry.getKey(), (Executor)localEntry.getValue(), paramThrowable);
      }
      return;
    }
    finally {}
  }
  
  public long payload()
  {
    return this.data;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/Http2Ping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */