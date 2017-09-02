package io.grpc;

import javax.annotation.Nullable;

public abstract class ForwardingClientCall<ReqT, RespT>
  extends ClientCall<ReqT, RespT>
{
  public void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    delegate().cancel(paramString, paramThrowable);
  }
  
  protected abstract ClientCall<ReqT, RespT> delegate();
  
  public Attributes getAttributes()
  {
    return delegate().getAttributes();
  }
  
  public void halfClose()
  {
    delegate().halfClose();
  }
  
  public boolean isReady()
  {
    return delegate().isReady();
  }
  
  public void request(int paramInt)
  {
    delegate().request(paramInt);
  }
  
  public void sendMessage(ReqT paramReqT)
  {
    delegate().sendMessage(paramReqT);
  }
  
  public void setMessageCompression(boolean paramBoolean)
  {
    delegate().setMessageCompression(paramBoolean);
  }
  
  public void start(ClientCall.Listener<RespT> paramListener, Metadata paramMetadata)
  {
    delegate().start(paramListener, paramMetadata);
  }
  
  public static abstract class SimpleForwardingClientCall<ReqT, RespT>
    extends ForwardingClientCall<ReqT, RespT>
  {
    private final ClientCall<ReqT, RespT> delegate;
    
    protected SimpleForwardingClientCall(ClientCall<ReqT, RespT> paramClientCall)
    {
      this.delegate = paramClientCall;
    }
    
    protected ClientCall<ReqT, RespT> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ForwardingClientCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */