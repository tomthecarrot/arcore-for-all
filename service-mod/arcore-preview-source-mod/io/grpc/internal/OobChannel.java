package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer.PickResult;
import io.grpc.LoadBalancer.PickSubchannelArgs;
import io.grpc.LoadBalancer.SubchannelPicker;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class OobChannel
  extends ManagedChannel
  implements WithLogId
{
  private static final Logger log = Logger.getLogger(OobChannel.class.getName());
  private final String authority;
  private final ScheduledExecutorService deadlineCancellationExecutor;
  private final DelayedClientTransport delayedTransport;
  private final Executor executor;
  private final ObjectPool<? extends Executor> executorPool;
  private final LogId logId = LogId.allocate(getClass().getName());
  private volatile boolean shutdown;
  private final StatsContextFactory statsFactory;
  private final Supplier<Stopwatch> stopwatchSupplier;
  private SubchannelImpl subchannelImpl;
  private LoadBalancer.SubchannelPicker subchannelPicker;
  private final CountDownLatch terminatedLatch = new CountDownLatch(1);
  private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider()
  {
    public ClientTransport get(LoadBalancer.PickSubchannelArgs paramAnonymousPickSubchannelArgs)
    {
      return OobChannel.this.delayedTransport;
    }
  };
  
  OobChannel(StatsContextFactory paramStatsContextFactory, String paramString, ObjectPool<? extends Executor> paramObjectPool, ScheduledExecutorService paramScheduledExecutorService, Supplier<Stopwatch> paramSupplier, ChannelExecutor paramChannelExecutor)
  {
    this.statsFactory = ((StatsContextFactory)Preconditions.checkNotNull(paramStatsContextFactory, "statsFactory"));
    this.authority = ((String)Preconditions.checkNotNull(paramString, "authority"));
    this.executorPool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool, "executorPool"));
    this.executor = ((Executor)Preconditions.checkNotNull(paramObjectPool.getObject(), "executor"));
    this.deadlineCancellationExecutor = ((ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService, "deadlineCancellationExecutor"));
    this.stopwatchSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier, "stopwatchSupplier"));
    this.delayedTransport = new DelayedClientTransport(this.executor, paramChannelExecutor);
    this.delayedTransport.start(new ManagedClientTransport.Listener()
    {
      public void transportInUse(boolean paramAnonymousBoolean) {}
      
      public void transportReady() {}
      
      public void transportShutdown(Status paramAnonymousStatus) {}
      
      public void transportTerminated()
      {
        OobChannel.this.subchannelImpl.shutdown();
      }
    });
  }
  
  public String authority()
  {
    return this.authority;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.terminatedLatch.await(paramLong, paramTimeUnit);
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  void handleSubchannelStateChange(final ConnectivityStateInfo paramConnectivityStateInfo)
  {
    switch (paramConnectivityStateInfo.getState())
    {
    default: 
      return;
    case ???: 
    case ???: 
      this.delayedTransport.reprocess(this.subchannelPicker);
      return;
    }
    this.delayedTransport.reprocess(new LoadBalancer.SubchannelPicker()
    {
      final LoadBalancer.PickResult errorResult = LoadBalancer.PickResult.withError(paramConnectivityStateInfo.getStatus());
      
      public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs paramAnonymousPickSubchannelArgs)
      {
        return this.errorResult;
      }
    });
  }
  
  void handleSubchannelTerminated()
  {
    this.executorPool.returnObject(this.executor);
    this.terminatedLatch.countDown();
  }
  
  public boolean isShutdown()
  {
    return this.shutdown;
  }
  
  public boolean isTerminated()
  {
    return this.terminatedLatch.getCount() == 0L;
  }
  
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> paramMethodDescriptor, CallOptions paramCallOptions)
  {
    StatsTraceContext localStatsTraceContext = StatsTraceContext.newClientContext(paramMethodDescriptor.getFullMethodName(), this.statsFactory, this.stopwatchSupplier);
    if (paramCallOptions.getExecutor() == null) {}
    for (Executor localExecutor = this.executor;; localExecutor = paramCallOptions.getExecutor()) {
      return new ClientCallImpl(paramMethodDescriptor, localExecutor, paramCallOptions, localStatsTraceContext, this.transportProvider, this.deadlineCancellationExecutor);
    }
  }
  
  void setSubchannel(final InternalSubchannel paramInternalSubchannel)
  {
    log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[] { this, paramInternalSubchannel });
    this.subchannelImpl = new SubchannelImpl()
    {
      public EquivalentAddressGroup getAddresses()
      {
        return paramInternalSubchannel.getAddressGroup();
      }
      
      public Attributes getAttributes()
      {
        return Attributes.EMPTY;
      }
      
      ClientTransport obtainActiveTransport()
      {
        return paramInternalSubchannel.obtainActiveTransport();
      }
      
      public void requestConnection()
      {
        paramInternalSubchannel.obtainActiveTransport();
      }
      
      public void shutdown()
      {
        paramInternalSubchannel.shutdown();
      }
    };
    this.subchannelPicker = new LoadBalancer.SubchannelPicker()
    {
      final LoadBalancer.PickResult result = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);
      
      public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs paramAnonymousPickSubchannelArgs)
      {
        return this.result;
      }
    };
    this.delayedTransport.reprocess(this.subchannelPicker);
  }
  
  public ManagedChannel shutdown()
  {
    this.shutdown = true;
    this.delayedTransport.shutdown();
    return this;
  }
  
  public ManagedChannel shutdownNow()
  {
    this.shutdown = true;
    this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
    return this;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/OobChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */