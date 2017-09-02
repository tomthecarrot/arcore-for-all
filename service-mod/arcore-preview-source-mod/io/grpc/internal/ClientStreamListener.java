package io.grpc.internal;

import io.grpc.Metadata;
import io.grpc.Status;

public abstract interface ClientStreamListener
  extends StreamListener
{
  public abstract void closed(Status paramStatus, Metadata paramMetadata);
  
  public abstract void headersRead(Metadata paramMetadata);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ClientStreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */