package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class Channel
{
  public abstract String authority();
  
  public abstract <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> paramMethodDescriptor, CallOptions paramCallOptions);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */