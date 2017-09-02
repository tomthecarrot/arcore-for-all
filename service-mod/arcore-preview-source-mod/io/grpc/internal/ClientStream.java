package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Status;

public abstract interface ClientStream
  extends Stream
{
  public abstract void cancel(Status paramStatus);
  
  public abstract Attributes getAttributes();
  
  public abstract void halfClose();
  
  public abstract void setAuthority(String paramString);
  
  public abstract void setMaxInboundMessageSize(int paramInt);
  
  public abstract void setMaxOutboundMessageSize(int paramInt);
  
  public abstract void start(ClientStreamListener paramClientStreamListener);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ClientStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */