package io.grpc;

import com.google.errorprone.annotations.DoNotMock;
import javax.annotation.Nullable;

@DoNotMock("Use InProcessTransport and make a fake server instead")
public abstract class ClientCall<ReqT, RespT>
{
  public abstract void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable);
  
  public Attributes getAttributes()
  {
    return Attributes.EMPTY;
  }
  
  public abstract void halfClose();
  
  public boolean isReady()
  {
    return true;
  }
  
  public abstract void request(int paramInt);
  
  public abstract void sendMessage(ReqT paramReqT);
  
  public void setMessageCompression(boolean paramBoolean) {}
  
  public abstract void start(Listener<RespT> paramListener, Metadata paramMetadata);
  
  public static abstract class Listener<T>
  {
    public void onClose(Status paramStatus, Metadata paramMetadata) {}
    
    public void onHeaders(Metadata paramMetadata) {}
    
    public void onMessage(T paramT) {}
    
    public void onReady() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ClientCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */