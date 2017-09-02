package io.grpc;

import java.util.concurrent.TimeUnit;

public abstract class ManagedChannel
  extends Channel
{
  public abstract boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public ConnectivityState getState(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  public abstract boolean isShutdown();
  
  public abstract boolean isTerminated();
  
  public void notifyWhenStateChanged(ConnectivityState paramConnectivityState, Runnable paramRunnable)
  {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  public abstract ManagedChannel shutdown();
  
  public abstract ManagedChannel shutdownNow();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ManagedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */