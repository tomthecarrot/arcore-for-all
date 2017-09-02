package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.Status;

class FailingClientStream
  extends NoopClientStream
{
  private final Status error;
  private boolean started;
  
  public FailingClientStream(Status paramStatus)
  {
    if (!paramStatus.isOk()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "error must not be OK");
      this.error = paramStatus;
      return;
    }
  }
  
  Status getError()
  {
    return this.error;
  }
  
  public void start(ClientStreamListener paramClientStreamListener)
  {
    if (!this.started) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "already started");
      this.started = true;
      paramClientStreamListener.closed(this.error, new Metadata());
      return;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/FailingClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */