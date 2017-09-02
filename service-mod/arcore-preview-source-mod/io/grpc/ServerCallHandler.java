package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ServerCallHandler<RequestT, ResponseT>
{
  public abstract ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> paramServerCall, Metadata paramMetadata);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerCallHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */