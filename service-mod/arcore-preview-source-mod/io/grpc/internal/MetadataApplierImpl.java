package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials.MetadataApplier;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class MetadataApplierImpl
  implements CallCredentials.MetadataApplier
{
  private final CallOptions callOptions;
  private final Context ctx;
  DelayedStream delayedStream;
  boolean finalized;
  private final Object lock = new Object();
  private final MethodDescriptor<?, ?> method;
  private final Metadata origHeaders;
  @Nullable
  @GuardedBy("lock")
  private ClientStream returnedStream;
  private final StatsTraceContext statsTraceCtx;
  private final ClientTransport transport;
  
  MetadataApplierImpl(ClientTransport paramClientTransport, MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    this.transport = paramClientTransport;
    this.method = paramMethodDescriptor;
    this.origHeaders = paramMetadata;
    this.callOptions = paramCallOptions;
    this.ctx = Context.current();
    this.statsTraceCtx = paramStatsTraceContext;
  }
  
  private void finalizeWith(ClientStream paramClientStream)
  {
    boolean bool2 = true;
    if (!this.finalized) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1, "already finalized");
      this.finalized = true;
      for (;;)
      {
        synchronized (this.lock)
        {
          if (this.returnedStream == null)
          {
            this.returnedStream = paramClientStream;
            return;
          }
          if (this.delayedStream != null)
          {
            bool1 = bool2;
            Preconditions.checkState(bool1, "delayedStream is null");
            this.delayedStream.setStream(paramClientStream);
            return;
          }
        }
        bool1 = false;
      }
    }
  }
  
  /* Error */
  public void apply(Metadata paramMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	io/grpc/internal/MetadataApplierImpl:finalized	Z
    //   4: ifne +74 -> 78
    //   7: iconst_1
    //   8: istore_2
    //   9: iload_2
    //   10: ldc 85
    //   12: invokestatic 70	com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
    //   15: aload_1
    //   16: ldc 87
    //   18: invokestatic 91	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_0
    //   23: getfield 43	io/grpc/internal/MetadataApplierImpl:origHeaders	Lio/grpc/Metadata;
    //   26: aload_1
    //   27: invokevirtual 96	io/grpc/Metadata:merge	(Lio/grpc/Metadata;)V
    //   30: aload_0
    //   31: getfield 53	io/grpc/internal/MetadataApplierImpl:ctx	Lio/grpc/Context;
    //   34: invokevirtual 99	io/grpc/Context:attach	()Lio/grpc/Context;
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 39	io/grpc/internal/MetadataApplierImpl:transport	Lio/grpc/internal/ClientTransport;
    //   42: aload_0
    //   43: getfield 41	io/grpc/internal/MetadataApplierImpl:method	Lio/grpc/MethodDescriptor;
    //   46: aload_0
    //   47: getfield 43	io/grpc/internal/MetadataApplierImpl:origHeaders	Lio/grpc/Metadata;
    //   50: aload_0
    //   51: getfield 45	io/grpc/internal/MetadataApplierImpl:callOptions	Lio/grpc/CallOptions;
    //   54: aload_0
    //   55: getfield 55	io/grpc/internal/MetadataApplierImpl:statsTraceCtx	Lio/grpc/internal/StatsTraceContext;
    //   58: invokeinterface 105 5 0
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 53	io/grpc/internal/MetadataApplierImpl:ctx	Lio/grpc/Context;
    //   68: aload_1
    //   69: invokevirtual 109	io/grpc/Context:detach	(Lio/grpc/Context;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 111	io/grpc/internal/MetadataApplierImpl:finalizeWith	(Lio/grpc/internal/ClientStream;)V
    //   77: return
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -71 -> 9
    //   83: astore_3
    //   84: aload_0
    //   85: getfield 53	io/grpc/internal/MetadataApplierImpl:ctx	Lio/grpc/Context;
    //   88: aload_1
    //   89: invokevirtual 109	io/grpc/Context:detach	(Lio/grpc/Context;)V
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	MetadataApplierImpl
    //   0	94	1	paramMetadata	Metadata
    //   8	72	2	bool	boolean
    //   63	11	3	localClientStream	ClientStream
    //   83	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	64	83	finally
  }
  
  public void fail(Status paramStatus)
  {
    boolean bool2 = true;
    if (!paramStatus.isOk())
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Cannot fail with OK status");
      if (this.finalized) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "apply() or fail() already called");
      finalizeWith(new FailingClientStream(paramStatus));
      return;
      bool1 = false;
      break;
    }
  }
  
  ClientStream returnStream()
  {
    synchronized (this.lock)
    {
      if (this.returnedStream == null)
      {
        this.delayedStream = new DelayedStream();
        localObject2 = this.delayedStream;
        this.returnedStream = ((ClientStream)localObject2);
        return (ClientStream)localObject2;
      }
      Object localObject2 = this.returnedStream;
      return (ClientStream)localObject2;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/MetadataApplierImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */