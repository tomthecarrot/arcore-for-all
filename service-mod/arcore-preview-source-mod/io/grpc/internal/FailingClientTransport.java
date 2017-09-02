package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.Executor;

class FailingClientTransport
  implements ClientTransport
{
  @VisibleForTesting
  final Status error;
  
  FailingClientTransport(Status paramStatus)
  {
    if (!paramStatus.isOk()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "error must not be OK");
      this.error = paramStatus;
      return;
    }
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata)
  {
    return newStream(paramMethodDescriptor, paramMetadata, CallOptions.DEFAULT, StatsTraceContext.NOOP);
  }
  
  public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
  {
    return new FailingClientStream(this.error);
  }
  
  public void ping(final ClientTransport.PingCallback paramPingCallback, Executor paramExecutor)
  {
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        paramPingCallback.onFailure(FailingClientTransport.this.error.asException());
      }
    });
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/FailingClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */