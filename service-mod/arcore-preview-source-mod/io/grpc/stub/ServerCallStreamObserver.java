package io.grpc.stub;

public abstract class ServerCallStreamObserver<V>
  extends CallStreamObserver<V>
{
  public abstract boolean isCancelled();
  
  public abstract void setCompression(String paramString);
  
  public abstract void setOnCancelHandler(Runnable paramRunnable);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/ServerCallStreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */