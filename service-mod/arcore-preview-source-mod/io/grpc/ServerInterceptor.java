package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface ServerInterceptor
{
  public abstract <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata, ServerCallHandler<ReqT, RespT> paramServerCallHandler);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/ServerInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */