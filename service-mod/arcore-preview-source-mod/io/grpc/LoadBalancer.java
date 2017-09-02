package io.grpc;

import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

@NotThreadSafe
public abstract class LoadBalancer
{
  public abstract void handleNameResolutionError(Status paramStatus);
  
  public abstract void handleResolvedAddresses(List<ResolvedServerInfoGroup> paramList, Attributes paramAttributes);
  
  public abstract void handleSubchannelState(Subchannel paramSubchannel, ConnectivityStateInfo paramConnectivityStateInfo);
  
  public abstract void shutdown();
  
  @ThreadSafe
  public static abstract class Factory
  {
    public abstract LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper);
  }
  
  @ThreadSafe
  public static abstract class Helper
  {
    public abstract ManagedChannel createOobChannel(EquivalentAddressGroup paramEquivalentAddressGroup, String paramString);
    
    public abstract LoadBalancer.Subchannel createSubchannel(EquivalentAddressGroup paramEquivalentAddressGroup, Attributes paramAttributes);
    
    public abstract String getAuthority();
    
    public abstract NameResolver.Factory getNameResolverFactory();
    
    public abstract void runSerialized(Runnable paramRunnable);
    
    public abstract void updatePicker(LoadBalancer.SubchannelPicker paramSubchannelPicker);
  }
  
  @Immutable
  public static final class PickResult
  {
    private static final PickResult NO_RESULT = new PickResult(null, Status.OK);
    private final Status status;
    @Nullable
    private final LoadBalancer.Subchannel subchannel;
    
    private PickResult(@Nullable LoadBalancer.Subchannel paramSubchannel, Status paramStatus)
    {
      this.subchannel = paramSubchannel;
      this.status = ((Status)Preconditions.checkNotNull(paramStatus, "status"));
    }
    
    public static PickResult withError(Status paramStatus)
    {
      if (!paramStatus.isOk()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "error status shouldn't be OK");
        return new PickResult(null, paramStatus);
      }
    }
    
    public static PickResult withNoResult()
    {
      return NO_RESULT;
    }
    
    public static PickResult withSubchannel(LoadBalancer.Subchannel paramSubchannel)
    {
      return new PickResult((LoadBalancer.Subchannel)Preconditions.checkNotNull(paramSubchannel, "subchannel"), Status.OK);
    }
    
    public Status getStatus()
    {
      return this.status;
    }
    
    @Nullable
    public LoadBalancer.Subchannel getSubchannel()
    {
      return this.subchannel;
    }
    
    public String toString()
    {
      return "[subchannel=" + this.subchannel + " status=" + this.status + "]";
    }
  }
  
  public static abstract class PickSubchannelArgs
  {
    public abstract CallOptions getCallOptions();
    
    public abstract Metadata getHeaders();
    
    public abstract MethodDescriptor<?, ?> getMethodDescriptor();
  }
  
  @ThreadSafe
  public static abstract class Subchannel
  {
    public abstract EquivalentAddressGroup getAddresses();
    
    public abstract Attributes getAttributes();
    
    public abstract void requestConnection();
    
    public abstract void shutdown();
  }
  
  @ThreadSafe
  public static abstract class SubchannelPicker
  {
    @Deprecated
    public LoadBalancer.PickResult pickSubchannel(Attributes paramAttributes, Metadata paramMetadata)
    {
      throw new UnsupportedOperationException();
    }
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs)
    {
      return pickSubchannel(paramPickSubchannelArgs.getCallOptions().getAffinity(), paramPickSubchannelArgs.getHeaders());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/LoadBalancer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */