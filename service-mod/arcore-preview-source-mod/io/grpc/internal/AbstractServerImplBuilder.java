package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.instrumentation.stats.Stats;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalNotifyOnServerBuild;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class AbstractServerImplBuilder<T extends AbstractServerImplBuilder<T>>
  extends ServerBuilder<T>
{
  private static final HandlerRegistry EMPTY_FALLBACK_REGISTRY = new HandlerRegistry()
  {
    public List<ServerServiceDefinition> getServices()
    {
      return Collections.emptyList();
    }
    
    public ServerMethodDefinition<?, ?> lookupMethod(String paramAnonymousString1, @Nullable String paramAnonymousString2)
    {
      return null;
    }
  };
  @Nullable
  private CompressorRegistry compressorRegistry;
  @Nullable
  private DecompressorRegistry decompressorRegistry;
  @Nullable
  private Executor executor;
  @Nullable
  private HandlerRegistry fallbackRegistry;
  private final List<InternalNotifyOnServerBuild> notifyOnBuildList = new ArrayList();
  private final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();
  @Nullable
  private StatsContextFactory statsFactory;
  private final ArrayList<ServerTransportFilter> transportFilters = new ArrayList();
  
  private ObjectPool<? extends Executor> getExecutorPool()
  {
    final Executor localExecutor = this.executor;
    if (localExecutor == null) {
      return SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    }
    new ObjectPool()
    {
      public Executor getObject()
      {
        return localExecutor;
      }
      
      public Executor returnObject(Object paramAnonymousObject)
      {
        return null;
      }
    };
  }
  
  private T thisT()
  {
    return this;
  }
  
  public final T addService(BindableService paramBindableService)
  {
    if ((paramBindableService instanceof InternalNotifyOnServerBuild)) {
      this.notifyOnBuildList.add((InternalNotifyOnServerBuild)paramBindableService);
    }
    return addService(paramBindableService.bindService());
  }
  
  public final T addService(ServerServiceDefinition paramServerServiceDefinition)
  {
    this.registryBuilder.addService(paramServerServiceDefinition);
    return thisT();
  }
  
  public final T addTransportFilter(ServerTransportFilter paramServerTransportFilter)
  {
    this.transportFilters.add(Preconditions.checkNotNull(paramServerTransportFilter, "filter"));
    return thisT();
  }
  
  public ServerImpl build()
  {
    Object localObject = buildTransportServer();
    localObject = new ServerImpl(getExecutorPool(), SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE), this.registryBuilder.build(), (HandlerRegistry)MoreObjects.firstNonNull(this.fallbackRegistry, EMPTY_FALLBACK_REGISTRY), (InternalServer)localObject, Context.ROOT, (DecompressorRegistry)MoreObjects.firstNonNull(this.decompressorRegistry, DecompressorRegistry.getDefaultInstance()), (CompressorRegistry)MoreObjects.firstNonNull(this.compressorRegistry, CompressorRegistry.getDefaultInstance()), this.transportFilters, (StatsContextFactory)MoreObjects.firstNonNull(this.statsFactory, MoreObjects.firstNonNull(Stats.getStatsContextFactory(), NoopStatsContextFactory.INSTANCE)), GrpcUtil.STOPWATCH_SUPPLIER);
    Iterator localIterator = this.notifyOnBuildList.iterator();
    while (localIterator.hasNext()) {
      ((InternalNotifyOnServerBuild)localIterator.next()).notifyOnBuild((Server)localObject);
    }
    return (ServerImpl)localObject;
  }
  
  protected abstract InternalServer buildTransportServer();
  
  public final T compressorRegistry(CompressorRegistry paramCompressorRegistry)
  {
    this.compressorRegistry = paramCompressorRegistry;
    return thisT();
  }
  
  public final T decompressorRegistry(DecompressorRegistry paramDecompressorRegistry)
  {
    this.decompressorRegistry = paramDecompressorRegistry;
    return thisT();
  }
  
  public final T directExecutor()
  {
    return executor(MoreExecutors.directExecutor());
  }
  
  public final T executor(@Nullable Executor paramExecutor)
  {
    this.executor = paramExecutor;
    return thisT();
  }
  
  public final T fallbackHandlerRegistry(HandlerRegistry paramHandlerRegistry)
  {
    this.fallbackRegistry = paramHandlerRegistry;
    return thisT();
  }
  
  @VisibleForTesting
  protected T statsContextFactory(StatsContextFactory paramStatsContextFactory)
  {
    this.statsFactory = paramStatsContextFactory;
    return thisT();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractServerImplBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */