package io.grpc.internal;

import io.grpc.Status;

public abstract interface ServerTransport
  extends WithLogId
{
  public abstract void shutdown();
  
  public abstract void shutdownNow(Status paramStatus);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */