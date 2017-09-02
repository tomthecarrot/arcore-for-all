package io.grpc;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class Server
{
  public abstract void awaitTermination()
    throws InterruptedException;
  
  public abstract boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public List<ServerServiceDefinition> getImmutableServices()
  {
    return Collections.emptyList();
  }
  
  public List<ServerServiceDefinition> getMutableServices()
  {
    return Collections.emptyList();
  }
  
  public int getPort()
  {
    return -1;
  }
  
  public List<ServerServiceDefinition> getServices()
  {
    return Collections.emptyList();
  }
  
  public abstract boolean isShutdown();
  
  public abstract boolean isTerminated();
  
  public abstract Server shutdown();
  
  public abstract Server shutdownNow();
  
  public abstract Server start()
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */