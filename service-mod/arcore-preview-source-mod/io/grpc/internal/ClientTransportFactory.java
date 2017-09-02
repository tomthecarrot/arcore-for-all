package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import javax.annotation.Nullable;

public abstract interface ClientTransportFactory
  extends Closeable
{
  public abstract void close();
  
  public abstract ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ClientTransportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */