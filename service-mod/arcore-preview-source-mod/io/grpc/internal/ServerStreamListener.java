package io.grpc.internal;

import io.grpc.Status;

public abstract interface ServerStreamListener
  extends StreamListener
{
  public abstract void closed(Status paramStatus);
  
  public abstract void halfClosed();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerStreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */