package io.grpc;

abstract class PartialForwardingServerCall<ReqT, RespT>
  extends ServerCall<ReqT, RespT>
{
  public void close(Status paramStatus, Metadata paramMetadata)
  {
    delegate().close(paramStatus, paramMetadata);
  }
  
  protected abstract ServerCall<?, ?> delegate();
  
  public Attributes getAttributes()
  {
    return delegate().getAttributes();
  }
  
  public boolean isCancelled()
  {
    return delegate().isCancelled();
  }
  
  public boolean isReady()
  {
    return delegate().isReady();
  }
  
  public void request(int paramInt)
  {
    delegate().request(paramInt);
  }
  
  public void sendHeaders(Metadata paramMetadata)
  {
    delegate().sendHeaders(paramMetadata);
  }
  
  public void setCompression(String paramString)
  {
    delegate().setCompression(paramString);
  }
  
  public void setMessageCompression(boolean paramBoolean)
  {
    delegate().setMessageCompression(paramBoolean);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/PartialForwardingServerCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */