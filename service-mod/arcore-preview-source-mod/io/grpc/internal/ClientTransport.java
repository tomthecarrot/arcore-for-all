package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ClientTransport
{
  public abstract ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata);
  
  public abstract ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext);
  
  public abstract void ping(PingCallback paramPingCallback, Executor paramExecutor);
  
  public static abstract interface PingCallback
  {
    public abstract void onFailure(Throwable paramThrowable);
    
    public abstract void onSuccess(long paramLong);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */