package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancer.Factory;
import io.grpc.LoadBalancer.Helper;
import io.grpc.LoadBalancer.PickSubchannelArgs;
import io.grpc.LoadBalancer.SubchannelPicker;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.NameResolver.Factory;
import io.grpc.NameResolver.Listener;
import io.grpc.ResolvedServerInfoGroup;
import io.grpc.Status;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class ManagedChannelImpl
  extends ManagedChannel
  implements WithLogId
{
  static final long IDLE_TIMEOUT_MILLIS_DISABLE = -1L;
  @VisibleForTesting
  static final Status SHUTDOWN_NOW_STATUS = Status.UNAVAILABLE.withDescription("Channel shutdownNow invoked");
  @VisibleForTesting
  static final long SUBCHANNEL_SHUTDOWN_DELAY_SECONDS = 5L;
  @VisibleForTesting
  static final Pattern URI_PATTERN;
  private static final Logger log = Logger.getLogger(ManagedChannelImpl.class.getName());
  private final BackoffPolicy.Provider backoffPolicyProvider;
  private final ChannelExecutor channelExecutor = new ChannelExecutor();
  private final CompressorRegistry compressorRegistry;
  private final DecompressorRegistry decompressorRegistry;
  private final DelayedClientTransport delayedTransport;
  private final ManagedClientTransport.Listener delayedTransportListener = new ManagedClientTransport.Listener()
  {
    public void transportInUse(boolean paramAnonymousBoolean)
    {
      ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(ManagedChannelImpl.this.delayedTransport, paramAnonymousBoolean);
    }
    
    public void transportReady() {}
    
    public void transportShutdown(Status paramAnonymousStatus)
    {
      Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
    }
    
    public void transportTerminated()
    {
      Preconditions.checkState(ManagedChannelImpl.this.shutdown.get(), "Channel must have been shut down");
      ManagedChannelImpl.access$202(ManagedChannelImpl.this, true);
      if (ManagedChannelImpl.this.loadBalancer != null)
      {
        ManagedChannelImpl.this.loadBalancer.shutdown();
        ManagedChannelImpl.access$302(ManagedChannelImpl.this, null);
      }
      if (ManagedChannelImpl.this.nameResolver != null)
      {
        ManagedChannelImpl.this.nameResolver.shutdown();
        ManagedChannelImpl.access$402(ManagedChannelImpl.this, null);
      }
      ManagedChannelImpl.this.maybeShutdownNowSubchannels();
      ManagedChannelImpl.this.maybeTerminateChannel();
    }
  };
  private final Executor executor;
  private final ObjectPool<? extends Executor> executorPool;
  @Nullable
  private IdleModeTimer idleModeTimer;
  @Nullable
  private ScheduledFuture<?> idleModeTimerFuture;
  private final long idleTimeoutMillis;
  @VisibleForTesting
  final InUseStateAggregator<Object> inUseStateAggregator = new InUseStateAggregator()
  {
    void handleInUse()
    {
      ManagedChannelImpl.this.exitIdleMode();
    }
    
    void handleNotInUse()
    {
      if (ManagedChannelImpl.this.shutdown.get()) {
        return;
      }
      ManagedChannelImpl.this.rescheduleIdleTimer();
    }
  };
  private final Channel interceptorChannel;
  @Nullable
  private LoadBalancer loadBalancer;
  private final LoadBalancer.Factory loadBalancerFactory;
  private final LogId logId = LogId.allocate(getClass().getName());
  private NameResolver nameResolver;
  private final NameResolver.Factory nameResolverFactory;
  private final Attributes nameResolverParams;
  private final Set<InternalSubchannel> oobChannels = new HashSet(1, 0.75F);
  private final ObjectPool<? extends Executor> oobExecutorPool;
  private volatile ScheduledExecutorService scheduledExecutor;
  private final AtomicBoolean shutdown = new AtomicBoolean(false);
  private boolean shutdownNowed;
  private final StatsContextFactory statsFactory;
  private final Supplier<Stopwatch> stopwatchSupplier;
  @Nullable
  private volatile LoadBalancer.SubchannelPicker subchannelPicker;
  private final Set<InternalSubchannel> subchannels = new HashSet(16, 0.75F);
  private final String target;
  private volatile boolean terminated;
  private final CountDownLatch terminatedLatch = new CountDownLatch(1);
  private volatile boolean terminating;
  private final ObjectPool<ScheduledExecutorService> timerServicePool;
  private final ClientTransportFactory transportFactory;
  private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider()
  {
    public ClientTransport get(LoadBalancer.PickSubchannelArgs paramAnonymousPickSubchannelArgs)
    {
      Object localObject = ManagedChannelImpl.this.subchannelPicker;
      if (ManagedChannelImpl.this.shutdown.get()) {
        paramAnonymousPickSubchannelArgs = ManagedChannelImpl.this.delayedTransport;
      }
      do
      {
        return paramAnonymousPickSubchannelArgs;
        if (localObject == null)
        {
          ManagedChannelImpl.this.channelExecutor.executeLater(new Runnable()
          {
            public void run()
            {
              ManagedChannelImpl.this.exitIdleMode();
            }
          }).drain();
          return ManagedChannelImpl.this.delayedTransport;
        }
        localObject = GrpcUtil.getTransportFromPickResult(((LoadBalancer.SubchannelPicker)localObject).pickSubchannel(paramAnonymousPickSubchannelArgs), paramAnonymousPickSubchannelArgs.getCallOptions().isWaitForReady());
        paramAnonymousPickSubchannelArgs = (LoadBalancer.PickSubchannelArgs)localObject;
      } while (localObject != null);
      return ManagedChannelImpl.this.delayedTransport;
    }
  };
  @Nullable
  private final String userAgent;
  
  static
  {
    URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
  }
  
  ManagedChannelImpl(String paramString1, BackoffPolicy.Provider paramProvider, NameResolver.Factory paramFactory, Attributes paramAttributes, LoadBalancer.Factory paramFactory1, ClientTransportFactory paramClientTransportFactory, DecompressorRegistry paramDecompressorRegistry, CompressorRegistry paramCompressorRegistry, ObjectPool<ScheduledExecutorService> paramObjectPool, ObjectPool<? extends Executor> paramObjectPool1, ObjectPool<? extends Executor> paramObjectPool2, Supplier<Stopwatch> paramSupplier, long paramLong, @Nullable String paramString2, List<ClientInterceptor> paramList, StatsContextFactory paramStatsContextFactory)
  {
    this.target = ((String)Preconditions.checkNotNull(paramString1, "target"));
    this.nameResolverFactory = ((NameResolver.Factory)Preconditions.checkNotNull(paramFactory, "nameResolverFactory"));
    this.nameResolverParams = ((Attributes)Preconditions.checkNotNull(paramAttributes, "nameResolverParams"));
    this.nameResolver = getNameResolver(paramString1, paramFactory, paramAttributes);
    this.loadBalancerFactory = ((LoadBalancer.Factory)Preconditions.checkNotNull(paramFactory1, "loadBalancerFactory"));
    this.executorPool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool1, "executorPool"));
    this.oobExecutorPool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool2, "oobExecutorPool"));
    this.executor = ((Executor)Preconditions.checkNotNull(paramObjectPool1.getObject(), "executor"));
    this.delayedTransport = new DelayedClientTransport(this.executor, this.channelExecutor);
    this.delayedTransport.start(this.delayedTransportListener);
    this.backoffPolicyProvider = paramProvider;
    this.transportFactory = new CallCredentialsApplyingTransportFactory(paramClientTransportFactory, this.executor);
    this.interceptorChannel = ClientInterceptors.intercept(new RealChannel(null), paramList);
    this.timerServicePool = ((ObjectPool)Preconditions.checkNotNull(paramObjectPool, "timerServicePool"));
    this.scheduledExecutor = ((ScheduledExecutorService)Preconditions.checkNotNull(paramObjectPool.getObject(), "timerService"));
    this.stopwatchSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier, "stopwatchSupplier"));
    if (paramLong == -1L)
    {
      this.idleTimeoutMillis = paramLong;
      this.decompressorRegistry = ((DecompressorRegistry)Preconditions.checkNotNull(paramDecompressorRegistry, "decompressorRegistry"));
      this.compressorRegistry = ((CompressorRegistry)Preconditions.checkNotNull(paramCompressorRegistry, "compressorRegistry"));
      this.userAgent = paramString2;
      this.statsFactory = ((StatsContextFactory)Preconditions.checkNotNull(paramStatsContextFactory, "statsFactory"));
      log.log(Level.FINE, "[{0}] Created with target {1}", new Object[] { getLogId(), paramString1 });
      return;
    }
    if (paramLong >= AbstractManagedChannelImplBuilder.IDLE_MODE_MIN_TIMEOUT_MILLIS) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid idleTimeoutMillis %s", new Object[] { Long.valueOf(paramLong) });
      this.idleTimeoutMillis = paramLong;
      break;
    }
  }
  
  private void cancelIdleTimer()
  {
    if (this.idleModeTimerFuture != null)
    {
      this.idleModeTimerFuture.cancel(false);
      this.idleModeTimer.cancelled = true;
      this.idleModeTimerFuture = null;
      this.idleModeTimer = null;
    }
  }
  
  @VisibleForTesting
  static NameResolver getNameResolver(String paramString, NameResolver.Factory paramFactory, Attributes paramAttributes)
  {
    Object localObject = null;
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      URI localURI = new URI(paramString);
      localObject = localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        localStringBuilder.append(localURISyntaxException.getMessage());
      }
      if (URI_PATTERN.matcher(paramString).matches()) {
        break label129;
      }
      try
      {
        localObject = new URI(paramFactory.getDefaultScheme(), "", "/" + paramString, null);
        paramFactory = paramFactory.newNameResolver((URI)localObject, paramAttributes);
        if (paramFactory != null) {
          return paramFactory;
        }
      }
      catch (URISyntaxException paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
      label129:
      if (localStringBuilder.length() <= 0) {
        break label191;
      }
    }
    if (localObject != null)
    {
      localObject = paramFactory.newNameResolver((URI)localObject, paramAttributes);
      if (localObject != null) {
        return (NameResolver)localObject;
      }
    }
    label191:
    for (paramFactory = " (" + localStringBuilder + ")";; paramFactory = "") {
      throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", new Object[] { paramString, paramFactory }));
    }
  }
  
  private void maybeShutdownNowSubchannels()
  {
    if (this.shutdownNowed)
    {
      Iterator localIterator = this.subchannels.iterator();
      while (localIterator.hasNext()) {
        ((InternalSubchannel)localIterator.next()).shutdownNow(SHUTDOWN_NOW_STATUS);
      }
      localIterator = this.oobChannels.iterator();
      while (localIterator.hasNext()) {
        ((InternalSubchannel)localIterator.next()).shutdownNow(SHUTDOWN_NOW_STATUS);
      }
    }
  }
  
  private void maybeTerminateChannel()
  {
    if (this.terminated) {}
    while ((!this.shutdown.get()) || (!this.subchannels.isEmpty()) || (!this.oobChannels.isEmpty())) {
      return;
    }
    log.log(Level.FINE, "[{0}] Terminated", getLogId());
    this.terminated = true;
    this.terminatedLatch.countDown();
    this.executorPool.returnObject(this.executor);
    this.scheduledExecutor = ((ScheduledExecutorService)this.timerServicePool.returnObject(this.scheduledExecutor));
    this.transportFactory.close();
  }
  
  private void rescheduleIdleTimer()
  {
    if (this.idleTimeoutMillis == -1L) {
      return;
    }
    cancelIdleTimer();
    this.idleModeTimer = new IdleModeTimer(null);
    this.idleModeTimerFuture = this.scheduledExecutor.schedule(new LogExceptionRunnable(new Runnable()
    {
      public void run()
      {
        ManagedChannelImpl.this.channelExecutor.executeLater(ManagedChannelImpl.this.idleModeTimer).drain();
      }
    }), this.idleTimeoutMillis, TimeUnit.MILLISECONDS);
  }
  
  public String authority()
  {
    return this.interceptorChannel.authority();
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.terminatedLatch.await(paramLong, paramTimeUnit);
  }
  
  @VisibleForTesting
  void exitIdleMode()
  {
    if (this.shutdown.get()) {}
    for (;;)
    {
      return;
      if (this.inUseStateAggregator.isInUse()) {
        cancelIdleTimer();
      }
      while (this.loadBalancer == null)
      {
        log.log(Level.FINE, "[{0}] Exiting idle mode", getLogId());
        Object localObject = new LbHelperImpl(this.nameResolver);
        ((LbHelperImpl)localObject).lb = this.loadBalancerFactory.newLoadBalancer((LoadBalancer.Helper)localObject);
        this.loadBalancer = ((LbHelperImpl)localObject).lb;
        localObject = new NameResolverListenerImpl((LbHelperImpl)localObject);
        try
        {
          this.nameResolver.start((NameResolver.Listener)localObject);
          return;
        }
        catch (Throwable localThrowable)
        {
          ((NameResolverListenerImpl)localObject).onError(Status.fromThrowable(localThrowable));
          return;
        }
        rescheduleIdleTimer();
      }
    }
  }
  
  public LogId getLogId()
  {
    return this.logId;
  }
  
  public boolean isShutdown()
  {
    return this.shutdown.get();
  }
  
  public boolean isTerminated()
  {
    return this.terminated;
  }
  
  public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions)
  {
    return this.interceptorChannel.newCall(paramMethodDescriptor, paramCallOptions);
  }
  
  public ManagedChannelImpl shutdown()
  {
    log.log(Level.FINE, "[{0}] shutdown() called", getLogId());
    if (!this.shutdown.compareAndSet(false, true)) {
      return this;
    }
    this.delayedTransport.shutdown();
    this.channelExecutor.executeLater(new Runnable()
    {
      public void run()
      {
        ManagedChannelImpl.this.cancelIdleTimer();
      }
    }).drain();
    log.log(Level.FINE, "[{0}] Shutting down", getLogId());
    return this;
  }
  
  public ManagedChannelImpl shutdownNow()
  {
    log.log(Level.FINE, "[{0}] shutdownNow() called", getLogId());
    shutdown();
    this.delayedTransport.shutdownNow(SHUTDOWN_NOW_STATUS);
    this.channelExecutor.executeLater(new Runnable()
    {
      public void run()
      {
        if (ManagedChannelImpl.this.shutdownNowed) {
          return;
        }
        ManagedChannelImpl.access$1802(ManagedChannelImpl.this, true);
        ManagedChannelImpl.this.maybeShutdownNowSubchannels();
      }
    }).drain();
    return this;
  }
  
  private class IdleModeTimer
    implements Runnable
  {
    boolean cancelled;
    
    private IdleModeTimer() {}
    
    public void run()
    {
      if (this.cancelled) {
        return;
      }
      ManagedChannelImpl.log.log(Level.FINE, "[{0}] Entering idle mode", ManagedChannelImpl.this.getLogId());
      ManagedChannelImpl.this.nameResolver.shutdown();
      ManagedChannelImpl.access$402(ManagedChannelImpl.this, ManagedChannelImpl.getNameResolver(ManagedChannelImpl.this.target, ManagedChannelImpl.this.nameResolverFactory, ManagedChannelImpl.this.nameResolverParams));
      ManagedChannelImpl.this.loadBalancer.shutdown();
      ManagedChannelImpl.access$302(ManagedChannelImpl.this, null);
      ManagedChannelImpl.access$1202(ManagedChannelImpl.this, null);
    }
  }
  
  private class LbHelperImpl
    extends LoadBalancer.Helper
  {
    LoadBalancer lb;
    final NameResolver nr;
    
    LbHelperImpl(NameResolver paramNameResolver)
    {
      this.nr = ((NameResolver)Preconditions.checkNotNull(paramNameResolver, "NameResolver"));
    }
    
    public ManagedChannel createOobChannel(final EquivalentAddressGroup paramEquivalentAddressGroup, String paramString)
    {
      ScheduledExecutorService localScheduledExecutorService = ManagedChannelImpl.this.scheduledExecutor;
      if (localScheduledExecutorService != null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "scheduledExecutor is already cleared. Looks like you are calling this method after you've already shut down");
        final OobChannel localOobChannel = new OobChannel(ManagedChannelImpl.this.statsFactory, paramString, ManagedChannelImpl.this.oobExecutorPool, localScheduledExecutorService, ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.channelExecutor);
        paramEquivalentAddressGroup = new InternalSubchannel(paramEquivalentAddressGroup, paramString, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, localScheduledExecutorService, ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.channelExecutor, new InternalSubchannel.Callback()
        {
          void onStateChange(InternalSubchannel paramAnonymousInternalSubchannel, ConnectivityStateInfo paramAnonymousConnectivityStateInfo)
          {
            localOobChannel.handleSubchannelStateChange(paramAnonymousConnectivityStateInfo);
          }
          
          void onTerminated(InternalSubchannel paramAnonymousInternalSubchannel)
          {
            ManagedChannelImpl.this.oobChannels.remove(paramAnonymousInternalSubchannel);
            localOobChannel.handleSubchannelTerminated();
            ManagedChannelImpl.this.maybeTerminateChannel();
          }
        });
        localOobChannel.setSubchannel(paramEquivalentAddressGroup);
        runSerialized(new Runnable()
        {
          public void run()
          {
            if (ManagedChannelImpl.this.terminating) {
              localOobChannel.shutdown();
            }
            if (!ManagedChannelImpl.this.terminated) {
              ManagedChannelImpl.this.oobChannels.add(paramEquivalentAddressGroup);
            }
          }
        });
        return localOobChannel;
      }
    }
    
    public SubchannelImpl createSubchannel(EquivalentAddressGroup paramEquivalentAddressGroup, final Attributes paramAttributes)
    {
      Preconditions.checkNotNull(paramEquivalentAddressGroup, "addressGroup");
      Preconditions.checkNotNull(paramAttributes, "attrs");
      final Object localObject = ManagedChannelImpl.this.scheduledExecutor;
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "scheduledExecutor is already cleared. Looks like you are calling this method after you've already shut down");
        paramAttributes = new ManagedChannelImpl.SubchannelImplImpl(ManagedChannelImpl.this, paramAttributes);
        localObject = new InternalSubchannel(paramEquivalentAddressGroup, ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, (ScheduledExecutorService)localObject, ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.channelExecutor, new InternalSubchannel.Callback()
        {
          void onInUse(InternalSubchannel paramAnonymousInternalSubchannel)
          {
            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(paramAnonymousInternalSubchannel, true);
          }
          
          void onNotInUse(InternalSubchannel paramAnonymousInternalSubchannel)
          {
            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(paramAnonymousInternalSubchannel, false);
          }
          
          void onStateChange(InternalSubchannel paramAnonymousInternalSubchannel, ConnectivityStateInfo paramAnonymousConnectivityStateInfo)
          {
            if ((paramAnonymousConnectivityStateInfo.getState() == ConnectivityState.TRANSIENT_FAILURE) || (paramAnonymousConnectivityStateInfo.getState() == ConnectivityState.IDLE)) {
              ManagedChannelImpl.LbHelperImpl.this.nr.refresh();
            }
            ManagedChannelImpl.LbHelperImpl.this.lb.handleSubchannelState(paramAttributes, paramAnonymousConnectivityStateInfo);
          }
          
          void onTerminated(InternalSubchannel paramAnonymousInternalSubchannel)
          {
            ManagedChannelImpl.this.subchannels.remove(paramAnonymousInternalSubchannel);
            ManagedChannelImpl.this.maybeTerminateChannel();
          }
        });
        paramAttributes.subchannel = ((InternalSubchannel)localObject);
        ManagedChannelImpl.log.log(Level.FINE, "[{0}] {1} created for {2}", new Object[] { ManagedChannelImpl.this.getLogId(), ((InternalSubchannel)localObject).getLogId(), paramEquivalentAddressGroup });
        runSerialized(new Runnable()
        {
          public void run()
          {
            if (ManagedChannelImpl.this.terminating) {
              localObject.shutdown();
            }
            if (!ManagedChannelImpl.this.terminated) {
              ManagedChannelImpl.this.subchannels.add(localObject);
            }
          }
        });
        return paramAttributes;
      }
    }
    
    public String getAuthority()
    {
      return ManagedChannelImpl.this.authority();
    }
    
    public NameResolver.Factory getNameResolverFactory()
    {
      return ManagedChannelImpl.this.nameResolverFactory;
    }
    
    public void runSerialized(Runnable paramRunnable)
    {
      ManagedChannelImpl.this.channelExecutor.executeLater(paramRunnable).drain();
    }
    
    public void updatePicker(final LoadBalancer.SubchannelPicker paramSubchannelPicker)
    {
      runSerialized(new Runnable()
      {
        public void run()
        {
          ManagedChannelImpl.access$1202(ManagedChannelImpl.this, paramSubchannelPicker);
          ManagedChannelImpl.this.delayedTransport.reprocess(paramSubchannelPicker);
        }
      });
    }
  }
  
  private class NameResolverListenerImpl
    implements NameResolver.Listener
  {
    final LoadBalancer balancer;
    final LoadBalancer.Helper helper;
    
    NameResolverListenerImpl(ManagedChannelImpl.LbHelperImpl paramLbHelperImpl)
    {
      this.balancer = paramLbHelperImpl.lb;
      this.helper = paramLbHelperImpl;
    }
    
    public void onError(final Status paramStatus)
    {
      if (!paramStatus.isOk()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "the error status must not be OK");
        ManagedChannelImpl.log.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[] { ManagedChannelImpl.this.getLogId(), paramStatus });
        ManagedChannelImpl.this.channelExecutor.executeLater(new Runnable()
        {
          public void run()
          {
            if (ManagedChannelImpl.this.terminated) {
              return;
            }
            ManagedChannelImpl.NameResolverListenerImpl.this.balancer.handleNameResolutionError(paramStatus);
          }
        }).drain();
        return;
      }
    }
    
    public void onUpdate(final List<ResolvedServerInfoGroup> paramList, final Attributes paramAttributes)
    {
      if (paramList.isEmpty())
      {
        onError(Status.UNAVAILABLE.withDescription("NameResolver returned an empty list"));
        return;
      }
      ManagedChannelImpl.log.log(Level.FINE, "[{0}] resolved address: {1}, config={2}", new Object[] { ManagedChannelImpl.this.getLogId(), paramList, paramAttributes });
      this.helper.runSerialized(new Runnable()
      {
        public void run()
        {
          if (ManagedChannelImpl.this.terminated) {
            return;
          }
          try
          {
            ManagedChannelImpl.NameResolverListenerImpl.this.balancer.handleResolvedAddresses(paramList, paramAttributes);
            return;
          }
          catch (Throwable localThrowable)
          {
            ManagedChannelImpl.log.log(Level.WARNING, "[" + ManagedChannelImpl.this.getLogId() + "] Unexpected exception from LoadBalancer", localThrowable);
            ManagedChannelImpl.NameResolverListenerImpl.this.balancer.handleNameResolutionError(Status.INTERNAL.withCause(localThrowable).withDescription("Thrown from handleResolvedAddresses(): " + localThrowable));
          }
        }
      });
    }
  }
  
  private class RealChannel
    extends Channel
  {
    private RealChannel() {}
    
    public String authority()
    {
      return (String)Preconditions.checkNotNull(ManagedChannelImpl.this.nameResolver.getServiceAuthority(), "authority");
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions)
    {
      Executor localExecutor2 = paramCallOptions.getExecutor();
      Executor localExecutor1 = localExecutor2;
      if (localExecutor2 == null) {
        localExecutor1 = ManagedChannelImpl.this.executor;
      }
      return new ClientCallImpl(paramMethodDescriptor, localExecutor1, paramCallOptions, StatsTraceContext.newClientContext(paramMethodDescriptor.getFullMethodName(), ManagedChannelImpl.this.statsFactory, ManagedChannelImpl.this.stopwatchSupplier), ManagedChannelImpl.this.transportProvider, ManagedChannelImpl.this.scheduledExecutor).setDecompressorRegistry(ManagedChannelImpl.this.decompressorRegistry).setCompressorRegistry(ManagedChannelImpl.this.compressorRegistry);
    }
  }
  
  private final class SubchannelImplImpl
    extends SubchannelImpl
  {
    final Attributes attrs;
    @GuardedBy("shutdownLock")
    ScheduledFuture<?> delayedShutdownTask;
    final Object shutdownLock = new Object();
    @GuardedBy("shutdownLock")
    boolean shutdownRequested;
    InternalSubchannel subchannel;
    
    SubchannelImplImpl(Attributes paramAttributes)
    {
      this.attrs = ((Attributes)Preconditions.checkNotNull(paramAttributes, "attrs"));
    }
    
    public EquivalentAddressGroup getAddresses()
    {
      return this.subchannel.getAddressGroup();
    }
    
    public Attributes getAttributes()
    {
      return this.attrs;
    }
    
    ClientTransport obtainActiveTransport()
    {
      return this.subchannel.obtainActiveTransport();
    }
    
    public void requestConnection()
    {
      this.subchannel.obtainActiveTransport();
    }
    
    public void shutdown()
    {
      for (;;)
      {
        synchronized (this.shutdownLock)
        {
          if (this.shutdownRequested)
          {
            if ((ManagedChannelImpl.this.terminating) && (this.delayedShutdownTask != null))
            {
              this.delayedShutdownTask.cancel(false);
              this.delayedShutdownTask = null;
              ScheduledExecutorService localScheduledExecutorService = ManagedChannelImpl.this.scheduledExecutor;
              if ((ManagedChannelImpl.this.terminating) || (localScheduledExecutorService == null)) {
                break;
              }
              this.delayedShutdownTask = localScheduledExecutorService.schedule(new LogExceptionRunnable(new Runnable()
              {
                public void run()
                {
                  ManagedChannelImpl.SubchannelImplImpl.this.subchannel.shutdown();
                }
              }), 5L, TimeUnit.SECONDS);
              return;
            }
            return;
          }
        }
        this.shutdownRequested = true;
      }
      this.subchannel.shutdown();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ManagedChannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */