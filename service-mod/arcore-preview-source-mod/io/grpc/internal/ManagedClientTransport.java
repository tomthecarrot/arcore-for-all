package io.grpc.internal;

import io.grpc.Status;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ManagedClientTransport
  extends ClientTransport, WithLogId
{
  public abstract void shutdown();
  
  public abstract void shutdownNow(Status paramStatus);
  
  @CheckReturnValue
  @Nullable
  public abstract Runnable start(Listener paramListener);
  
  public static abstract interface Listener
  {
    public abstract void transportInUse(boolean paramBoolean);
    
    public abstract void transportReady();
    
    public abstract void transportShutdown(Status paramStatus);
    
    public abstract void transportTerminated();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ManagedClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */