package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Attributes.Builder;
import io.grpc.Attributes.Key;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancer.Factory;
import io.grpc.LoadBalancer.Helper;
import io.grpc.LoadBalancer.PickResult;
import io.grpc.LoadBalancer.PickSubchannelArgs;
import io.grpc.LoadBalancer.Subchannel;
import io.grpc.LoadBalancer.SubchannelPicker;
import io.grpc.ResolvedServerInfo;
import io.grpc.ResolvedServerInfoGroup;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class RoundRobinLoadBalancerFactory
  extends LoadBalancer.Factory
{
  private static final RoundRobinLoadBalancerFactory INSTANCE = new RoundRobinLoadBalancerFactory();
  
  public static RoundRobinLoadBalancerFactory getInstance()
  {
    return INSTANCE;
  }
  
  public LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper)
  {
    return new RoundRobinLoadBalancer(paramHelper);
  }
  
  @VisibleForTesting
  static final class Picker
    extends LoadBalancer.SubchannelPicker
  {
    @GuardedBy("this")
    private int index = 0;
    private final List<LoadBalancer.Subchannel> list;
    private final int size;
    @Nullable
    private final Status status;
    
    Picker(List<LoadBalancer.Subchannel> paramList, @Nullable Status paramStatus)
    {
      this.list = Collections.unmodifiableList(paramList);
      this.size = paramList.size();
      this.status = paramStatus;
    }
    
    private LoadBalancer.Subchannel nextSubchannel()
    {
      if (this.size == 0) {
        throw new NoSuchElementException();
      }
      try
      {
        LoadBalancer.Subchannel localSubchannel = (LoadBalancer.Subchannel)this.list.get(this.index);
        this.index += 1;
        if (this.index >= this.size) {
          this.index = 0;
        }
        return localSubchannel;
      }
      finally {}
    }
    
    @VisibleForTesting
    List<LoadBalancer.Subchannel> getList()
    {
      return this.list;
    }
    
    @VisibleForTesting
    Status getStatus()
    {
      return this.status;
    }
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs paramPickSubchannelArgs)
    {
      if (this.size > 0) {
        return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
      }
      if (this.status != null) {
        return LoadBalancer.PickResult.withError(this.status);
      }
      return LoadBalancer.PickResult.withNoResult();
    }
  }
  
  @VisibleForTesting
  static class RoundRobinLoadBalancer
    extends LoadBalancer
  {
    @VisibleForTesting
    static final Attributes.Key<AtomicReference<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.of("state-info");
    private final LoadBalancer.Helper helper;
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    
    RoundRobinLoadBalancer(LoadBalancer.Helper paramHelper)
    {
      this.helper = ((LoadBalancer.Helper)Preconditions.checkNotNull(paramHelper, "helper"));
    }
    
    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> paramCollection)
    {
      ArrayList localArrayList = new ArrayList(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        LoadBalancer.Subchannel localSubchannel = (LoadBalancer.Subchannel)paramCollection.next();
        if (((ConnectivityStateInfo)getSubchannelStateInfoRef(localSubchannel).get()).getState() == ConnectivityState.READY) {
          localArrayList.add(localSubchannel);
        }
      }
      return localArrayList;
    }
    
    @Nullable
    private Status getAggregatedError()
    {
      Object localObject = null;
      Iterator localIterator = getSubchannels().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (ConnectivityStateInfo)getSubchannelStateInfoRef((LoadBalancer.Subchannel)localIterator.next()).get();
          if (((ConnectivityStateInfo)localObject).getState() != ConnectivityState.TRANSIENT_FAILURE) {
            localObject = null;
          }
        }
        else
        {
          return (Status)localObject;
        }
        localObject = ((ConnectivityStateInfo)localObject).getStatus();
      }
    }
    
    private static AtomicReference<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel paramSubchannel)
    {
      return (AtomicReference)Preconditions.checkNotNull(paramSubchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }
    
    private static Set<EquivalentAddressGroup> resolvedServerInfoGroupToEquivalentAddressGroup(List<ResolvedServerInfoGroup> paramList)
    {
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((ResolvedServerInfoGroup)paramList.next()).getResolvedServerInfoList().iterator();
        while (localIterator.hasNext()) {
          localHashSet.add(new EquivalentAddressGroup(((ResolvedServerInfo)localIterator.next()).getAddress()));
        }
      }
      return localHashSet;
    }
    
    private static <T> Set<T> setsDifference(Set<T> paramSet1, Set<T> paramSet2)
    {
      paramSet1 = new HashSet(paramSet1);
      paramSet1.removeAll(paramSet2);
      return paramSet1;
    }
    
    private void updatePicker(@Nullable Status paramStatus)
    {
      List localList = filterNonFailingSubchannels(getSubchannels());
      this.helper.updatePicker(new RoundRobinLoadBalancerFactory.Picker(localList, paramStatus));
    }
    
    @VisibleForTesting
    Collection<LoadBalancer.Subchannel> getSubchannels()
    {
      return this.subchannels.values();
    }
    
    public void handleNameResolutionError(Status paramStatus)
    {
      updatePicker(paramStatus);
    }
    
    public void handleResolvedAddresses(List<ResolvedServerInfoGroup> paramList, Attributes paramAttributes)
    {
      paramAttributes = this.subchannels.keySet();
      paramList = resolvedServerInfoGroupToEquivalentAddressGroup(paramList);
      Object localObject1 = setsDifference(paramList, paramAttributes);
      paramList = setsDifference(paramAttributes, paramList);
      paramAttributes = ((Set)localObject1).iterator();
      while (paramAttributes.hasNext())
      {
        localObject1 = (EquivalentAddressGroup)paramAttributes.next();
        Object localObject2 = Attributes.newBuilder().set(STATE_INFO, new AtomicReference(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build();
        localObject2 = (LoadBalancer.Subchannel)Preconditions.checkNotNull(this.helper.createSubchannel((EquivalentAddressGroup)localObject1, (Attributes)localObject2), "subchannel");
        this.subchannels.put(localObject1, localObject2);
        ((LoadBalancer.Subchannel)localObject2).requestConnection();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramAttributes = (EquivalentAddressGroup)paramList.next();
        ((LoadBalancer.Subchannel)this.subchannels.remove(paramAttributes)).shutdown();
      }
      updatePicker(getAggregatedError());
    }
    
    public void handleSubchannelState(LoadBalancer.Subchannel paramSubchannel, ConnectivityStateInfo paramConnectivityStateInfo)
    {
      if (!this.subchannels.containsValue(paramSubchannel)) {
        return;
      }
      if (paramConnectivityStateInfo.getState() == ConnectivityState.IDLE) {
        paramSubchannel.requestConnection();
      }
      getSubchannelStateInfoRef(paramSubchannel).set(paramConnectivityStateInfo);
      updatePicker(getAggregatedError());
    }
    
    public void shutdown()
    {
      Iterator localIterator = getSubchannels().iterator();
      while (localIterator.hasNext()) {
        ((LoadBalancer.Subchannel)localIterator.next()).shutdown();
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/util/RoundRobinLoadBalancerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */