package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder.SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
public final class ServiceManager
{
  private static final ListenerCallQueue.Callback<Listener> HEALTHY_CALLBACK = new ListenerCallQueue.Callback("healthy()")
  {
    void call(ServiceManager.Listener paramAnonymousListener)
    {
      paramAnonymousListener.healthy();
    }
  };
  private static final ListenerCallQueue.Callback<Listener> STOPPED_CALLBACK = new ListenerCallQueue.Callback("stopped()")
  {
    void call(ServiceManager.Listener paramAnonymousListener)
    {
      paramAnonymousListener.stopped();
    }
  };
  private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
  private final ImmutableList<Service> services;
  private final ServiceManagerState state;
  
  public ServiceManager(Iterable<? extends Service> paramIterable)
  {
    Object localObject = ImmutableList.copyOf(paramIterable);
    paramIterable = (Iterable<? extends Service>)localObject;
    if (((ImmutableList)localObject).isEmpty())
    {
      logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning(null));
      paramIterable = ImmutableList.of(new NoOpService(null));
    }
    this.state = new ServiceManagerState(paramIterable);
    this.services = paramIterable;
    localObject = new WeakReference(this.state);
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      Service localService = (Service)paramIterable.next();
      localService.addListener(new ServiceListener(localService, (WeakReference)localObject), MoreExecutors.directExecutor());
      if (localService.state() == Service.State.NEW) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Can only manage NEW services, %s", new Object[] { localService });
        break;
      }
    }
    this.state.markReady();
  }
  
  public void addListener(Listener paramListener)
  {
    this.state.addListener(paramListener, MoreExecutors.directExecutor());
  }
  
  public void addListener(Listener paramListener, Executor paramExecutor)
  {
    this.state.addListener(paramListener, paramExecutor);
  }
  
  public void awaitHealthy()
  {
    this.state.awaitHealthy();
  }
  
  public void awaitHealthy(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.state.awaitHealthy(paramLong, paramTimeUnit);
  }
  
  public void awaitStopped()
  {
    this.state.awaitStopped();
  }
  
  public void awaitStopped(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.state.awaitStopped(paramLong, paramTimeUnit);
  }
  
  public boolean isHealthy()
  {
    Iterator localIterator = this.services.iterator();
    while (localIterator.hasNext()) {
      if (!((Service)localIterator.next()).isRunning()) {
        return false;
      }
    }
    return true;
  }
  
  public ImmutableMultimap<Service.State, Service> servicesByState()
  {
    return this.state.servicesByState();
  }
  
  public ServiceManager startAsync()
  {
    Iterator localIterator = this.services.iterator();
    Service localService;
    if (localIterator.hasNext())
    {
      localService = (Service)localIterator.next();
      Service.State localState = localService.state();
      if (localState == Service.State.NEW) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Service %s is %s, cannot start it.", new Object[] { localService, localState });
        break;
      }
    }
    localIterator = this.services.iterator();
    while (localIterator.hasNext())
    {
      localService = (Service)localIterator.next();
      try
      {
        this.state.tryStartTiming(localService);
        localService.startAsync();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        logger.log(Level.WARNING, "Unable to start Service " + localService, localIllegalStateException);
      }
    }
    return this;
  }
  
  public ImmutableMap<Service, Long> startupTimes()
  {
    return this.state.startupTimes();
  }
  
  public ServiceManager stopAsync()
  {
    Iterator localIterator = this.services.iterator();
    while (localIterator.hasNext()) {
      ((Service)localIterator.next()).stopAsync();
    }
    return this;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
  }
  
  private static final class EmptyServiceManagerWarning
    extends Throwable
  {}
  
  @Beta
  public static abstract class Listener
  {
    public void failure(Service paramService) {}
    
    public void healthy() {}
    
    public void stopped() {}
  }
  
  private static final class NoOpService
    extends AbstractService
  {
    protected void doStart()
    {
      notifyStarted();
    }
    
    protected void doStop()
    {
      notifyStopped();
    }
  }
  
  private static final class ServiceListener
    extends Service.Listener
  {
    final Service service;
    final WeakReference<ServiceManager.ServiceManagerState> state;
    
    ServiceListener(Service paramService, WeakReference<ServiceManager.ServiceManagerState> paramWeakReference)
    {
      this.service = paramService;
      this.state = paramWeakReference;
    }
    
    public void failed(Service.State paramState, Throwable paramThrowable)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null)
      {
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          ServiceManager.logger.log(Level.SEVERE, "Service " + this.service + " has failed in the " + paramState + " state.", paramThrowable);
        }
        localServiceManagerState.transitionService(this.service, paramState, Service.State.FAILED);
      }
    }
    
    public void running()
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null) {
        localServiceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
      }
    }
    
    public void starting()
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null)
      {
        localServiceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
        }
      }
    }
    
    public void stopping(Service.State paramState)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null) {
        localServiceManagerState.transitionService(this.service, paramState, Service.State.STOPPING);
      }
    }
    
    public void terminated(Service.State paramState)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null)
      {
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.service, paramState });
        }
        localServiceManagerState.transitionService(this.service, paramState, Service.State.TERMINATED);
      }
    }
  }
  
  private static final class ServiceManagerState
  {
    final Monitor.Guard awaitHealthGuard = new AwaitHealthGuard();
    @GuardedBy("monitor")
    final List<ListenerCallQueue<ServiceManager.Listener>> listeners = Collections.synchronizedList(new ArrayList());
    final Monitor monitor = new Monitor();
    final int numberOfServices;
    @GuardedBy("monitor")
    boolean ready;
    @GuardedBy("monitor")
    final SetMultimap<Service.State, Service> servicesByState = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
    @GuardedBy("monitor")
    final Map<Service, Stopwatch> startupTimers = Maps.newIdentityHashMap();
    @GuardedBy("monitor")
    final Multiset<Service.State> states = this.servicesByState.keys();
    final Monitor.Guard stoppedGuard = new StoppedGuard();
    @GuardedBy("monitor")
    boolean transitioned;
    
    ServiceManagerState(ImmutableCollection<Service> paramImmutableCollection)
    {
      this.numberOfServices = paramImmutableCollection.size();
      this.servicesByState.putAll(Service.State.NEW, paramImmutableCollection);
    }
    
    void addListener(ServiceManager.Listener paramListener, Executor paramExecutor)
    {
      Preconditions.checkNotNull(paramListener, "listener");
      Preconditions.checkNotNull(paramExecutor, "executor");
      this.monitor.enter();
      try
      {
        if (!this.stoppedGuard.isSatisfied()) {
          this.listeners.add(new ListenerCallQueue(paramListener, paramExecutor));
        }
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    void awaitHealthy()
    {
      this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
      try
      {
        checkHealthy();
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    void awaitHealthy(long paramLong, TimeUnit paramTimeUnit)
      throws TimeoutException
    {
      this.monitor.enter();
      try
      {
        if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, paramLong, paramTimeUnit)) {
          throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
        }
      }
      finally
      {
        this.monitor.leave();
      }
      checkHealthy();
      this.monitor.leave();
    }
    
    void awaitStopped()
    {
      this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
      this.monitor.leave();
    }
    
    void awaitStopped(long paramLong, TimeUnit paramTimeUnit)
      throws TimeoutException
    {
      this.monitor.enter();
      try
      {
        if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, paramLong, paramTimeUnit)) {
          throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
        }
      }
      finally
      {
        this.monitor.leave();
      }
      this.monitor.leave();
    }
    
    @GuardedBy("monitor")
    void checkHealthy()
    {
      if (this.states.count(Service.State.RUNNING) != this.numberOfServices) {
        throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
      }
    }
    
    void executeListeners()
    {
      if (!this.monitor.isOccupiedByCurrentThread()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "It is incorrect to execute listeners with the monitor held.");
        int i = 0;
        while (i < this.listeners.size())
        {
          ((ListenerCallQueue)this.listeners.get(i)).execute();
          i += 1;
        }
      }
    }
    
    @GuardedBy("monitor")
    void fireFailedListeners(final Service paramService)
    {
      new ListenerCallQueue.Callback("failed({service=" + paramService + "})")
      {
        void call(ServiceManager.Listener paramAnonymousListener)
        {
          paramAnonymousListener.failure(paramService);
        }
      }.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireHealthyListeners()
    {
      ServiceManager.HEALTHY_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireStoppedListeners()
    {
      ServiceManager.STOPPED_CALLBACK.enqueueOn(this.listeners);
    }
    
    void markReady()
    {
      this.monitor.enter();
      try
      {
        if (!this.transitioned)
        {
          this.ready = true;
          return;
        }
        ArrayList localArrayList = Lists.newArrayList();
        Iterator localIterator = servicesByState().values().iterator();
        while (localIterator.hasNext())
        {
          Service localService = (Service)localIterator.next();
          if (localService.state() != Service.State.NEW) {
            localArrayList.add(localService);
          }
        }
        throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + localObject);
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    ImmutableMultimap<Service.State, Service> servicesByState()
    {
      ImmutableSetMultimap.Builder localBuilder = ImmutableSetMultimap.builder();
      this.monitor.enter();
      try
      {
        Iterator localIterator = this.servicesByState.entries().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!(localEntry.getValue() instanceof ServiceManager.NoOpService)) {
            localBuilder.put(localEntry);
          }
        }
      }
      finally
      {
        this.monitor.leave();
      }
      return ((ImmutableSetMultimap.Builder)localObject).build();
    }
    
    ImmutableMap<Service, Long> startupTimes()
    {
      this.monitor.enter();
      try
      {
        ArrayList localArrayList = Lists.newArrayListWithCapacity(this.startupTimers.size());
        Iterator localIterator = this.startupTimers.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          Service localService = (Service)((Map.Entry)localObject).getKey();
          localObject = (Stopwatch)((Map.Entry)localObject).getValue();
          if ((!((Stopwatch)localObject).isRunning()) && (!(localService instanceof ServiceManager.NoOpService))) {
            localArrayList.add(Maps.immutableEntry(localService, Long.valueOf(((Stopwatch)localObject).elapsed(TimeUnit.MILLISECONDS))));
          }
        }
      }
      finally
      {
        this.monitor.leave();
      }
      Collections.sort(localList, Ordering.natural().onResultOf(new Function()
      {
        public Long apply(Map.Entry<Service, Long> paramAnonymousEntry)
        {
          return (Long)paramAnonymousEntry.getValue();
        }
      }));
      return ImmutableMap.copyOf(localList);
    }
    
    /* Error */
    void transitionService(Service paramService, Service.State paramState1, Service.State paramState2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: aload_1
      //   4: invokestatic 439	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
      //   7: pop
      //   8: aload_2
      //   9: aload_3
      //   10: if_acmpeq +43 -> 53
      //   13: iload 4
      //   15: invokestatic 443	com/google/common/base/Preconditions:checkArgument	(Z)V
      //   18: aload_0
      //   19: getfield 51	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   22: invokevirtual 142	com/google/common/util/concurrent/Monitor:enter	()V
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield 301	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:transitioned	Z
      //   30: aload_0
      //   31: getfield 303	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:ready	Z
      //   34: istore 4
      //   36: iload 4
      //   38: ifne +21 -> 59
      //   41: aload_0
      //   42: getfield 51	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   45: invokevirtual 162	com/google/common/util/concurrent/Monitor:leave	()V
      //   48: aload_0
      //   49: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   52: return
      //   53: iconst_0
      //   54: istore 4
      //   56: goto -43 -> 13
      //   59: aload_0
      //   60: getfield 73	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:servicesByState	Lcom/google/common/collect/SetMultimap;
      //   63: aload_2
      //   64: aload_1
      //   65: invokeinterface 449 3 0
      //   70: ldc_w 451
      //   73: iconst_2
      //   74: anewarray 4	java/lang/Object
      //   77: dup
      //   78: iconst_0
      //   79: aload_1
      //   80: aastore
      //   81: dup
      //   82: iconst_1
      //   83: aload_2
      //   84: aastore
      //   85: invokestatic 454	com/google/common/base/Preconditions:checkState	(ZLjava/lang/String;[Ljava/lang/Object;)V
      //   88: aload_0
      //   89: getfield 73	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:servicesByState	Lcom/google/common/collect/SetMultimap;
      //   92: aload_3
      //   93: aload_1
      //   94: invokeinterface 456 3 0
      //   99: ldc_w 458
      //   102: iconst_2
      //   103: anewarray 4	java/lang/Object
      //   106: dup
      //   107: iconst_0
      //   108: aload_1
      //   109: aastore
      //   110: dup
      //   111: iconst_1
      //   112: aload_3
      //   113: aastore
      //   114: invokestatic 454	com/google/common/base/Preconditions:checkState	(ZLjava/lang/String;[Ljava/lang/Object;)V
      //   117: aload_0
      //   118: getfield 89	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:startupTimers	Ljava/util/Map;
      //   121: aload_1
      //   122: invokeinterface 460 2 0
      //   127: checkcast 389	com/google/common/base/Stopwatch
      //   130: astore 5
      //   132: aload 5
      //   134: astore_2
      //   135: aload 5
      //   137: ifnonnull +19 -> 156
      //   140: invokestatic 464	com/google/common/base/Stopwatch:createStarted	()Lcom/google/common/base/Stopwatch;
      //   143: astore_2
      //   144: aload_0
      //   145: getfield 89	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:startupTimers	Ljava/util/Map;
      //   148: aload_1
      //   149: aload_2
      //   150: invokeinterface 466 3 0
      //   155: pop
      //   156: aload_3
      //   157: getstatic 239	com/google/common/util/concurrent/Service$State:RUNNING	Lcom/google/common/util/concurrent/Service$State;
      //   160: invokevirtual 470	com/google/common/util/concurrent/Service$State:compareTo	(Ljava/lang/Enum;)I
      //   163: iflt +46 -> 209
      //   166: aload_2
      //   167: invokevirtual 392	com/google/common/base/Stopwatch:isRunning	()Z
      //   170: ifeq +39 -> 209
      //   173: aload_2
      //   174: invokevirtual 473	com/google/common/base/Stopwatch:stop	()Lcom/google/common/base/Stopwatch;
      //   177: pop
      //   178: aload_1
      //   179: instanceof 362
      //   182: ifne +27 -> 209
      //   185: invokestatic 477	com/google/common/util/concurrent/ServiceManager:access$200	()Ljava/util/logging/Logger;
      //   188: getstatic 483	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   191: ldc_w 485
      //   194: iconst_2
      //   195: anewarray 4	java/lang/Object
      //   198: dup
      //   199: iconst_0
      //   200: aload_1
      //   201: aastore
      //   202: dup
      //   203: iconst_1
      //   204: aload_2
      //   205: aastore
      //   206: invokevirtual 491	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;[Ljava/lang/Object;)V
      //   209: aload_3
      //   210: getstatic 227	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
      //   213: if_acmpne +8 -> 221
      //   216: aload_0
      //   217: aload_1
      //   218: invokevirtual 493	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireFailedListeners	(Lcom/google/common/util/concurrent/Service;)V
      //   221: aload_0
      //   222: getfield 81	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   225: getstatic 239	com/google/common/util/concurrent/Service$State:RUNNING	Lcom/google/common/util/concurrent/Service$State;
      //   228: invokeinterface 245 2 0
      //   233: aload_0
      //   234: getfield 116	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:numberOfServices	I
      //   237: if_icmpne +19 -> 256
      //   240: aload_0
      //   241: invokevirtual 495	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireHealthyListeners	()V
      //   244: aload_0
      //   245: getfield 51	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   248: invokevirtual 162	com/google/common/util/concurrent/Monitor:leave	()V
      //   251: aload_0
      //   252: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   255: return
      //   256: aload_0
      //   257: getfield 81	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   260: getstatic 224	com/google/common/util/concurrent/Service$State:TERMINATED	Lcom/google/common/util/concurrent/Service$State;
      //   263: invokeinterface 245 2 0
      //   268: aload_0
      //   269: getfield 81	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   272: getstatic 227	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
      //   275: invokeinterface 245 2 0
      //   280: iadd
      //   281: aload_0
      //   282: getfield 116	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:numberOfServices	I
      //   285: if_icmpne -41 -> 244
      //   288: aload_0
      //   289: invokevirtual 497	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireStoppedListeners	()V
      //   292: goto -48 -> 244
      //   295: astore_1
      //   296: aload_0
      //   297: getfield 51	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   300: invokevirtual 162	com/google/common/util/concurrent/Monitor:leave	()V
      //   303: aload_0
      //   304: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   307: aload_1
      //   308: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	309	0	this	ServiceManagerState
      //   0	309	1	paramService	Service
      //   0	309	2	paramState1	Service.State
      //   0	309	3	paramState2	Service.State
      //   1	54	4	bool	boolean
      //   130	6	5	localStopwatch	Stopwatch
      // Exception table:
      //   from	to	target	type
      //   25	36	295	finally
      //   59	132	295	finally
      //   140	156	295	finally
      //   156	209	295	finally
      //   209	221	295	finally
      //   221	244	295	finally
      //   256	292	295	finally
    }
    
    void tryStartTiming(Service paramService)
    {
      this.monitor.enter();
      try
      {
        if ((Stopwatch)this.startupTimers.get(paramService) == null) {
          this.startupTimers.put(paramService, Stopwatch.createStarted());
        }
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    final class AwaitHealthGuard
      extends Monitor.Guard
    {
      AwaitHealthGuard()
      {
        super();
      }
      
      public boolean isSatisfied()
      {
        return (ServiceManager.ServiceManagerState.this.states.count(Service.State.RUNNING) == ServiceManager.ServiceManagerState.this.numberOfServices) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.STOPPING)) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.TERMINATED)) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.FAILED));
      }
    }
    
    final class StoppedGuard
      extends Monitor.Guard
    {
      StoppedGuard()
      {
        super();
      }
      
      public boolean isSatisfied()
      {
        return ServiceManager.ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManager.ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManager.ServiceManagerState.this.numberOfServices;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */