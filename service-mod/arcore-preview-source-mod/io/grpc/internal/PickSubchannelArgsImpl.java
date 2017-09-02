package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer.PickSubchannelArgs;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

final class PickSubchannelArgsImpl
  extends LoadBalancer.PickSubchannelArgs
{
  private final CallOptions callOptions;
  private final Metadata headers;
  private final MethodDescriptor<?, ?> method;
  
  PickSubchannelArgsImpl(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions)
  {
    this.method = ((MethodDescriptor)Preconditions.checkNotNull(paramMethodDescriptor, "method"));
    this.headers = ((Metadata)Preconditions.checkNotNull(paramMetadata, "headers"));
    this.callOptions = ((CallOptions)Preconditions.checkNotNull(paramCallOptions, "callOptions"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (PickSubchannelArgsImpl)paramObject;
    } while ((Objects.equal(this.callOptions, ((PickSubchannelArgsImpl)paramObject).callOptions)) && (Objects.equal(this.headers, ((PickSubchannelArgsImpl)paramObject).headers)) && (Objects.equal(this.method, ((PickSubchannelArgsImpl)paramObject).method)));
    return false;
  }
  
  public CallOptions getCallOptions()
  {
    return this.callOptions;
  }
  
  public Metadata getHeaders()
  {
    return this.headers;
  }
  
  public MethodDescriptor<?, ?> getMethodDescriptor()
  {
    return this.method;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.callOptions, this.headers, this.method });
  }
  
  public final String toString()
  {
    return "[method=" + this.method + " headers=" + this.headers + " callOptions=" + this.callOptions + "]";
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/PickSubchannelArgsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */