package io.grpc;

import com.google.common.base.Preconditions;

public final class InternalMethodDescriptor
{
  private final InternalKnownTransport transport;
  
  public InternalMethodDescriptor(InternalKnownTransport paramInternalKnownTransport)
  {
    this.transport = ((InternalKnownTransport)Preconditions.checkNotNull(paramInternalKnownTransport, "transport"));
  }
  
  public Object geRawMethodName(MethodDescriptor<?, ?> paramMethodDescriptor)
  {
    return paramMethodDescriptor.getRawMethodName(this.transport.ordinal());
  }
  
  public void setRawMethodName(MethodDescriptor<?, ?> paramMethodDescriptor, Object paramObject)
  {
    paramMethodDescriptor.setRawMethodName(this.transport.ordinal(), paramObject);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/InternalMethodDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */