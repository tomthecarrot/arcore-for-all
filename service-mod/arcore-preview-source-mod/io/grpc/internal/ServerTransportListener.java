package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

public abstract interface ServerTransportListener
{
  public abstract StatsTraceContext methodDetermined(String paramString, Metadata paramMetadata);
  
  public abstract void streamCreated(ServerStream paramServerStream, String paramString, Metadata paramMetadata);
  
  public abstract Attributes transportReady(Attributes paramAttributes);
  
  public abstract void transportTerminated();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerTransportListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */