package io.grpc.internal;

import io.grpc.LoadBalancer.Subchannel;
import javax.annotation.Nullable;

abstract class SubchannelImpl
  extends LoadBalancer.Subchannel
{
  @Nullable
  abstract ClientTransport obtainActiveTransport();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/SubchannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */