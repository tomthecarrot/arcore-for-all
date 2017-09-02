package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.Executor;

abstract class ForwardingConnectionClientTransport
  implements ConnectionClientTransport
{
  protected abstract ConnectionClientTransport delegate();
  
  public Attributes getAttributes()
  {
    return delegate().getAttributes();
  }
  
  public LogId getLogId()
  {
    return delegate().getLogId();
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata)
  {
    return delegate().newStream(paramMethodDescriptor, paramMetadata);
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    return delegate().newStream(paramMethodDescriptor, paramMetadata, paramCallOptions, paramStatsTraceContext);
  }
  
  public void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor)
  {
    delegate().ping(paramPingCallback, paramExecutor);
  }
  
  public void shutdown()
  {
    delegate().shutdown();
  }
  
  public void shutdownNow(Status paramStatus)
  {
    delegate().shutdownNow(paramStatus);
  }
  
  public Runnable start(ManagedClientTransport.Listener paramListener)
  {
    return delegate().start(paramListener);
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[" + delegate().toString() + "]";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ForwardingConnectionClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */