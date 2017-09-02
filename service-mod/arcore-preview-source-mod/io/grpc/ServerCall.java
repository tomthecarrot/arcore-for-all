package io.grpc;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use InProcessTransport and make a fake server instead")
public abstract class ServerCall<ReqT, RespT>
{
  public abstract void close(Status paramStatus, Metadata paramMetadata);
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();
  
  public abstract boolean isCancelled();
  
  public boolean isReady()
  {
    return true;
  }
  
  public abstract void request(int paramInt);
  
  public abstract void sendHeaders(Metadata paramMetadata);
  
  public abstract void sendMessage(RespT paramRespT);
  
  public void setCompression(String paramString) {}
  
  public void setMessageCompression(boolean paramBoolean) {}
  
  public static abstract class Listener<ReqT>
  {
    public void onCancel() {}
    
    public void onComplete() {}
    
    public void onHalfClose() {}
    
    public void onMessage(ReqT paramReqT) {}
    
    public void onReady() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */