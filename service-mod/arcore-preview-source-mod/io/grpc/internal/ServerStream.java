package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;

public abstract interface ServerStream
  extends Stream
{
  public abstract void cancel(Status paramStatus);
  
  public abstract void close(Status paramStatus, Metadata paramMetadata);
  
  public abstract Attributes getAttributes();
  
  public abstract String getAuthority();
  
  public abstract void setListener(ServerStreamListener paramServerStreamListener);
  
  public abstract StatsTraceContext statsTraceContext();
  
  public abstract void writeHeaders(Metadata paramMetadata);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */