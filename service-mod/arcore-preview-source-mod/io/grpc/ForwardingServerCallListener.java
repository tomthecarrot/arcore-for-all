package io.grpc;

public abstract class ForwardingServerCallListener<ReqT>
  extends PartialForwardingServerCallListener<ReqT>
{
  protected abstract ServerCall.Listener<ReqT> delegate();
  
  public void onMessage(ReqT paramReqT)
  {
    delegate().onMessage(paramReqT);
  }
  
  public static abstract class SimpleForwardingServerCallListener<ReqT>
    extends ForwardingServerCallListener<ReqT>
  {
    private final ServerCall.Listener<ReqT> delegate;
    
    protected SimpleForwardingServerCallListener(ServerCall.Listener<ReqT> paramListener)
    {
      this.delegate = paramListener;
    }
    
    protected ServerCall.Listener<ReqT> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ForwardingServerCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */