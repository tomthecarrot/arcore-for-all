package io.grpc;

abstract class PartialForwardingServerCallListener<ReqT>
  extends ServerCall.Listener<ReqT>
{
  protected abstract ServerCall.Listener<?> delegate();
  
  public void onCancel()
  {
    delegate().onCancel();
  }
  
  public void onComplete()
  {
    delegate().onComplete();
  }
  
  public void onHalfClose()
  {
    delegate().onHalfClose();
  }
  
  public void onReady()
  {
    delegate().onReady();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/PartialForwardingServerCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */