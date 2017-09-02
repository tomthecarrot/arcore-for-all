package io.grpc.internal;

public abstract interface ServerListener
{
  public abstract void serverShutdown();
  
  public abstract ServerTransportListener transportCreated(ServerTransport paramServerTransport);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ServerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */