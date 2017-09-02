package io.grpc.internal;

import java.io.IOException;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface InternalServer
{
  public abstract int getPort();
  
  public abstract void shutdown();
  
  public abstract void start(ServerListener paramServerListener)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/InternalServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */