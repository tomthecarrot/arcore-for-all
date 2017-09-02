package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.instrumentation.stats.Stats;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.Attributes;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.LoadBalancer.Factory;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolver.Factory;
import io.grpc.NameResolver.Listener;
import io.grpc.NameResolverProvider;
import io.grpc.PickFirstBalancerFactory;
import io.grpc.ResolvedServerInfo;
import io.grpc.ResolvedServerInfoGroup;
import io.grpc.ResolvedServerInfoGroup.Builder;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractManagedChannelImplBuilder<T extends AbstractManagedChannelImplBuilder<T>>
  extends ManagedChannelBuilder<T>
{
  private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
  @VisibleForTesting
  static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(30L);
  @VisibleForTesting
  static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30L;
  @VisibleForTesting
  static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1L);
  @Nullable
  private String authorityOverride;
  @Nullable
  private CompressorRegistry compressorRegistry;
  @Nullable
  private DecompressorRegistry decompressorRegistry;
  @Nullable
  private final SocketAddress directServerAddress;
  @Nullable
  private Executor executor;
  private long idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
  private final List<ClientInterceptor> interceptors = new ArrayList();
  private LoadBalancer.Factory loadBalancerFactory;
  private int maxInboundMessageSize = 4194304;
  @Nullable
  private NameResolver.Factory nameResolverFactory;
  @Nullable
  private StatsContextFactory statsFactory;
  private final String target;
  @Nullable
  private String userAgent;
  
  protected AbstractManagedChannelImplBuilder(String paramString)
  {
    this.target = ((String)Preconditions.checkNotNull(paramString, "target"));
    this.directServerAddress = null;
  }
  
  protected AbstractManagedChannelImplBuilder(SocketAddress paramSocketAddress, String paramString)
  {
    this.target = makeTargetStringForDirectAddress(paramSocketAddress);
    this.directServerAddress = paramSocketAddress;
    this.nameResolverFactory = new DirectAddressNameResolverFactory(paramSocketAddress, paramString);
  }
  
  private static ObjectPool<? extends Executor> getExecutorPool(@Nullable Executor paramExecutor)
  {
    if (paramExecutor != null) {
      new ObjectPool()
      {
        public Executor getObject()
        {
          return AbstractManagedChannelImplBuilder.this;
        }
        
        public Executor returnObject(Object paramAnonymousObject)
        {
          return null;
        }
      };
    }
    return SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
  }
  
  @VisibleForTesting
  static String makeTargetStringForDirectAddress(SocketAddress paramSocketAddress)
  {
    try
    {
      paramSocketAddress = new URI("directaddress", "", "/" + paramSocketAddress, null).toString();
      return paramSocketAddress;
    }
    catch (URISyntaxException paramSocketAddress)
    {
      throw new RuntimeException(paramSocketAddress);
    }
  }
  
  private T thisT()
  {
    return this;
  }
  
  public ManagedChannel build()
  {
    Object localObject2 = buildTransportFactory();
    Object localObject1 = localObject2;
    if (this.authorityOverride != null) {
      localObject1 = new AuthorityOverridingTransportFactory((ClientTransportFactory)localObject2, this.authorityOverride);
    }
    NameResolver.Factory localFactory = this.nameResolverFactory;
    localObject2 = localFactory;
    if (localFactory == null) {
      localObject2 = NameResolverProvider.asFactory();
    }
    return new ManagedChannelImpl(this.target, new ExponentialBackoffPolicy.Provider(), (NameResolver.Factory)localObject2, getNameResolverParams(), (LoadBalancer.Factory)MoreObjects.firstNonNull(this.loadBalancerFactory, PickFirstBalancerFactory.getInstance()), (ClientTransportFactory)localObject1, (DecompressorRegistry)MoreObjects.firstNonNull(this.decompressorRegistry, DecompressorRegistry.getDefaultInstance()), (CompressorRegistry)MoreObjects.firstNonNull(this.compressorRegistry, CompressorRegistry.getDefaultInstance()), SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE), getExecutorPool(this.executor), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, this.idleTimeoutMillis, this.userAgent, this.interceptors, (StatsContextFactory)MoreObjects.firstNonNull(this.statsFactory, MoreObjects.firstNonNull(Stats.getStatsContextFactory(), NoopStatsContextFactory.INSTANCE)));
  }
  
  protected abstract ClientTransportFactory buildTransportFactory();
  
  protected String checkAuthority(String paramString)
  {
    return GrpcUtil.checkAuthority(paramString);
  }
  
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
  
  public final T executor(Executor paramExecutor)
  {
    this.executor = paramExecutor;
    return thisT();
  }
  
  @VisibleForTesting
  final long getIdleTimeoutMillis()
  {
    return this.idleTimeoutMillis;
  }
  
  protected Attributes getNameResolverParams()
  {
    return Attributes.EMPTY;
  }
  
  public final T idleTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (paramLong > 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool, "idle timeout is %s, but must be positive", new Object[] { Long.valueOf(paramLong) });
      if (paramTimeUnit.toDays(paramLong) < 30L) {
        break label58;
      }
    }
    label58:
    for (this.idleTimeoutMillis = -1L;; this.idleTimeoutMillis = Math.max(paramTimeUnit.toMillis(paramLong), IDLE_MODE_MIN_TIMEOUT_MILLIS))
    {
      return thisT();
      bool = false;
      break;
    }
  }
  
  public final T intercept(List<ClientInterceptor> paramList)
  {
    this.interceptors.addAll(paramList);
    return thisT();
  }
  
  public final T intercept(ClientInterceptor... paramVarArgs)
  {
    return intercept(Arrays.asList(paramVarArgs));
  }
  
  public final T loadBalancerFactory(LoadBalancer.Factory paramFactory)
  {
    if (this.directServerAddress == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "directServerAddress is set (%s), which forbids the use of LoadBalancer.Factory", new Object[] { this.directServerAddress });
      this.loadBalancerFactory = paramFactory;
      return thisT();
    }
  }
  
  protected final int maxInboundMessageSize()
  {
    return this.maxInboundMessageSize;
  }
  
  public T maxInboundMessageSize(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "negative max");
      this.maxInboundMessageSize = paramInt;
      return thisT();
    }
  }
  
  public final T nameResolverFactory(NameResolver.Factory paramFactory)
  {
    if (this.directServerAddress == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", new Object[] { this.directServerAddress });
      this.nameResolverFactory = paramFactory;
      return thisT();
    }
  }
  
  public final T overrideAuthority(String paramString)
  {
    this.authorityOverride = checkAuthority(paramString);
    return thisT();
  }
  
  @VisibleForTesting
  protected T statsContextFactory(StatsContextFactory paramStatsContextFactory)
  {
    this.statsFactory = paramStatsContextFactory;
    return thisT();
  }
  
  public final T userAgent(@Nullable String paramString)
  {
    this.userAgent = paramString;
    return thisT();
  }
  
  private static class AuthorityOverridingTransportFactory
    implements ClientTransportFactory
  {
    final String authorityOverride;
    final ClientTransportFactory factory;
    
    AuthorityOverridingTransportFactory(ClientTransportFactory paramClientTransportFactory, String paramString)
    {
      this.factory = ((ClientTransportFactory)Preconditions.checkNotNull(paramClientTransportFactory, "factory should not be null"));
      this.authorityOverride = ((String)Preconditions.checkNotNull(paramString, "authorityOverride should not be null"));
    }
    
    public void close()
    {
      this.factory.close();
    }
    
    public ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2)
    {
      return this.factory.newClientTransport(paramSocketAddress, this.authorityOverride, paramString2);
    }
  }
  
  private static class DirectAddressNameResolverFactory
    extends NameResolver.Factory
  {
    final SocketAddress address;
    final String authority;
    
    DirectAddressNameResolverFactory(SocketAddress paramSocketAddress, String paramString)
    {
      this.address = paramSocketAddress;
      this.authority = paramString;
    }
    
    public String getDefaultScheme()
    {
      return "directaddress";
    }
    
    public NameResolver newNameResolver(URI paramURI, Attributes paramAttributes)
    {
      new NameResolver()
      {
        public String getServiceAuthority()
        {
          return AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.this.authority;
        }
        
        public void shutdown() {}
        
        public void start(NameResolver.Listener paramAnonymousListener)
        {
          paramAnonymousListener.onUpdate(Collections.singletonList(ResolvedServerInfoGroup.builder().add(new ResolvedServerInfo(AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.this.address)).build()), Attributes.EMPTY);
        }
      };
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractManagedChannelImplBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */