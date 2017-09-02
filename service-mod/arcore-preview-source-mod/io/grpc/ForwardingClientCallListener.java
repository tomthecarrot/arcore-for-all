package io.grpc;

public abstract class ForwardingClientCallListener<RespT>
  extends ClientCall.Listener<RespT>
{
  protected abstract ClientCall.Listener<RespT> delegate();
  
  public void onClose(Status paramStatus, Metadata paramMetadata)
  {
    delegate().onClose(paramStatus, paramMetadata);
  }
  
  public void onHeaders(Metadata paramMetadata)
  {
    delegate().onHeaders(paramMetadata);
  }
  
  public void onMessage(RespT paramRespT)
  {
    delegate().onMessage(paramRespT);
  }
  
  public void onReady()
  {
    delegate().onReady();
  }
  
  public static abstract class SimpleForwardingClientCallListener<RespT>
    extends ForwardingClientCallListener<RespT>
  {
    private final ClientCall.Listener<RespT> delegate;
    
    protected SimpleForwardingClientCallListener(ClientCall.Listener<RespT> paramListener)
    {
      this.delegate = paramListener;
    }
    
    protected ClientCall.Listener<RespT> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ForwardingClientCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */