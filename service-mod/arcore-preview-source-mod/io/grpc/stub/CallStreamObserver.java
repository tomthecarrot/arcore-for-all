package io.grpc.stub;

public abstract class CallStreamObserver<V>
  implements StreamObserver<V>
{
  public abstract void disableAutoInboundFlowControl();
  
  public abstract boolean isReady();
  
  public abstract void request(int paramInt);
  
  public abstract void setMessageCompression(boolean paramBoolean);
  
  public abstract void setOnReadyHandler(Runnable paramRunnable);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/stub/CallStreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */