package io.grpc.internal;

import io.grpc.Attributes;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ConnectionClientTransport
  extends ManagedClientTransport
{
  public abstract Attributes getAttributes();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ConnectionClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */