package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PickFirstBalancerFactory
  extends LoadBalancer.Factory
{
  private static final PickFirstBalancerFactory INSTANCE = new PickFirstBalancerFactory();
  
  public static PickFirstBalancerFactory getInstance()
  {
    return INSTANCE;
  }
  
  public LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper)
  {
    return new PickFirstBalancer(paramHelper);
  }
  
  @VisibleForTesting
  static final class PickFirstBalancer
    extends LoadBalancer
  {
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;
    
    PickFirstBalancer(LoadBalancer.Helper paramHelper)
    {
      this.helper = ((LoadBalancer.Helper)Preconditions.checkNotNull(paramHelper, "helper"));
    }
    
    private static EquivalentAddressGroup flattenResolvedServerInfoGroupsIntoEquivalentAddressGroup(List<ResolvedServerInfoGroup> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((ResolvedServerInfoGroup)paramList.next()).getResolvedServerInfoList().iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(((ResolvedServerInfo)localIterator.next()).getAddress());
        }
      }
      return new EquivalentAddressGroup(localArrayList);
    }
    
    public void handleNameResolutionError(Status paramStatus)
    {
      if (this.subchannel != null)
      {
        this.subchannel.shutdown();
        this.subchannel = null;
      }
      this.helper.updatePicker(new PickFirstBalancerFactory.Picker(LoadBalancer.PickResult.withError(paramStatus)));
    }
    
    public void handleResolvedAddresses(List<ResolvedServerInfoGroup> paramList, Attributes paramAttributes)
    {
      paramList = flattenResolvedServerInfoGroupsIntoEquivalentAddressGroup(paramList);
      if ((this.subchannel == null) || (!paramList.equals(this.subchannel.getAddresses())))
      {
        if (this.subchannel != null) {
          this.subchannel.shutdown();
        }
        this.subchannel = this.helper.createSubchannel(paramList, Attributes.EMPTY);
        this.helper.updatePicker(new PickFirstBalancerFactory.Picker(LoadBalancer.PickResult.withSubchannel(this.subchannel)));
      }
    }
    
    public void handleSubchannelState(LoadBalancer.Subchannel paramSubchannel, ConnectivityStateInfo paramConnectivityStateInfo)
    {
      ConnectivityState localConnectivityState = paramConnectivityStateInfo.getState();
      if ((paramSubchannel != this.subchannel) || (localConnectivityState == ConnectivityState.SHUTDOWN)) {
        return;
      }
      switch (PickFirstBalancerFactory.1.$SwitchMap$io$grpc$ConnectivityState[localConnectivityState.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Unsupported state:" + localConnectivityState);
      case 1: 
        paramSubchannel = LoadBalancer.PickResult.withNoResult();
      }
      for (;;)
      {
        this.helper.updatePicker(new PickFirstBalancerFactory.Picker(paramSubchannel));
        return;
        paramSubchannel = LoadBalancer.PickResult.withSubchannel(paramSubchannel);
        continue;
        paramSubchannel = LoadBalancer.PickResult.withError(paramConnectivityStateInfo.getStatus());
      }
    }
    
    public void shutdown()
    {
      if (this.subchannel != null) {
        this.subchannel.shutdown();
      }
    }
  }
  
  @VisibleForTesting
  static final class Picker
    extends LoadBalancer.SubchannelPicker
  {
    private final LoadBalancer.PickResult result;
    
    Picker(LoadBalancer.PickResult paramPickResult)
    {
      this.result = ((LoadBalancer.PickResult)Preconditions.checkNotNull(paramPickResult, "result"));
    }
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs)
    {
      return this.result;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/PickFirstBalancerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */