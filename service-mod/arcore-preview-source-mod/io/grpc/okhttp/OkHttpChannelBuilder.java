package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.ConnectionSpec.Builder;
import com.squareup.okhttp.TlsVersion;
import io.grpc.Attributes;
import io.grpc.Attributes.Builder;
import io.grpc.NameResolver.Factory;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.SharedResourceHolder.Resource;
import io.grpc.okhttp.internal.Platform;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpChannelBuilder
  extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder>
{
  public static final ConnectionSpec DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(new CipherSuite[] { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 }).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
  private static final SharedResourceHolder.Resource<ExecutorService> SHARED_EXECUTOR = new SharedResourceHolder.Resource()
  {
    public void close(ExecutorService paramAnonymousExecutorService)
    {
      paramAnonymousExecutorService.shutdown();
    }
    
    public ExecutorService create()
    {
      return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
    }
  };
  private ConnectionSpec connectionSpec = DEFAULT_CONNECTION_SPEC;
  private boolean enableKeepAlive;
  private long keepAliveDelayNanos;
  private long keepAliveTimeoutNanos;
  private NegotiationType negotiationType = NegotiationType.TLS;
  private SSLSocketFactory sslSocketFactory;
  private Executor transportExecutor;
  
  private OkHttpChannelBuilder(String paramString)
  {
    super(paramString);
  }
  
  protected OkHttpChannelBuilder(String paramString, int paramInt)
  {
    this(GrpcUtil.authorityFromHostAndPort(paramString, paramInt));
  }
  
  public static OkHttpChannelBuilder forAddress(String paramString, int paramInt)
  {
    return new OkHttpChannelBuilder(paramString, paramInt);
  }
  
  public static OkHttpChannelBuilder forTarget(String paramString)
  {
    return new OkHttpChannelBuilder(paramString);
  }
  
  protected final ClientTransportFactory buildTransportFactory()
  {
    return new OkHttpTransportFactory(this.transportExecutor, createSocketFactory(), this.connectionSpec, maxInboundMessageSize(), this.enableKeepAlive, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos, null);
  }
  
  public final OkHttpChannelBuilder connectionSpec(ConnectionSpec paramConnectionSpec)
  {
    Preconditions.checkArgument(paramConnectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
    this.connectionSpec = paramConnectionSpec;
    return this;
  }
  
  @Nullable
  @VisibleForTesting
  SSLSocketFactory createSocketFactory()
  {
    switch (this.negotiationType)
    {
    default: 
      throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
    case ???: 
      try
      {
        if (this.sslSocketFactory == null) {
          this.sslSocketFactory = SSLContext.getInstance("Default", Platform.get().getProvider()).getSocketFactory();
        }
        SSLSocketFactory localSSLSocketFactory = this.sslSocketFactory;
        return localSSLSocketFactory;
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        throw new RuntimeException("TLS Provider failure", localGeneralSecurityException);
      }
    }
    return null;
  }
  
  public final OkHttpChannelBuilder enableKeepAlive(boolean paramBoolean)
  {
    this.enableKeepAlive = paramBoolean;
    if (paramBoolean)
    {
      this.keepAliveDelayNanos = GrpcUtil.DEFAULT_KEEPALIVE_DELAY_NANOS;
      this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    }
    return this;
  }
  
  public final OkHttpChannelBuilder enableKeepAlive(boolean paramBoolean, long paramLong1, TimeUnit paramTimeUnit1, long paramLong2, TimeUnit paramTimeUnit2)
  {
    this.enableKeepAlive = paramBoolean;
    if (paramBoolean)
    {
      this.keepAliveDelayNanos = paramTimeUnit1.toNanos(paramLong1);
      this.keepAliveTimeoutNanos = paramTimeUnit2.toNanos(paramLong2);
    }
    return this;
  }
  
  protected Attributes getNameResolverParams()
  {
    switch (this.negotiationType)
    {
    default: 
      throw new AssertionError(this.negotiationType + " not handled");
    }
    for (int i = 80;; i = 443) {
      return Attributes.newBuilder().set(NameResolver.Factory.PARAMS_DEFAULT_PORT, Integer.valueOf(i)).build();
    }
  }
  
  public final OkHttpChannelBuilder negotiationType(NegotiationType paramNegotiationType)
  {
    this.negotiationType = ((NegotiationType)Preconditions.checkNotNull(paramNegotiationType, "type"));
    return this;
  }
  
  public final OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.sslSocketFactory = paramSSLSocketFactory;
    negotiationType(NegotiationType.TLS);
    return this;
  }
  
  public final OkHttpChannelBuilder transportExecutor(@Nullable Executor paramExecutor)
  {
    this.transportExecutor = paramExecutor;
    return this;
  }
  
  public final OkHttpChannelBuilder usePlaintext(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      negotiationType(NegotiationType.PLAINTEXT);
      return this;
    }
    throw new IllegalArgumentException("Plaintext negotiation not currently supported");
  }
  
  static final class OkHttpTransportFactory
    implements ClientTransportFactory
  {
    private boolean closed;
    private final ConnectionSpec connectionSpec;
    private boolean enableKeepAlive;
    private final Executor executor;
    private long keepAliveDelayNanos;
    private long keepAliveTimeoutNanos;
    private final int maxMessageSize;
    @Nullable
    private final SSLSocketFactory socketFactory;
    private final boolean usingSharedExecutor;
    
    private OkHttpTransportFactory(Executor paramExecutor, @Nullable SSLSocketFactory paramSSLSocketFactory, ConnectionSpec paramConnectionSpec, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.socketFactory = paramSSLSocketFactory;
      this.connectionSpec = paramConnectionSpec;
      this.maxMessageSize = paramInt;
      this.enableKeepAlive = paramBoolean;
      this.keepAliveDelayNanos = paramLong1;
      this.keepAliveTimeoutNanos = paramLong2;
      if (paramExecutor == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.usingSharedExecutor = paramBoolean;
        if (!this.usingSharedExecutor) {
          break;
        }
        this.executor = ((Executor)SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR));
        return;
      }
      this.executor = paramExecutor;
    }
    
    public void close()
    {
      if (this.closed) {}
      do
      {
        return;
        this.closed = true;
      } while (!this.usingSharedExecutor);
      SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, (ExecutorService)this.executor);
    }
    
    public ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2)
    {
      if (this.closed) {
        throw new IllegalStateException("The transport factory is closed.");
      }
      Object localObject = null;
      String str = System.getenv("GRPC_PROXY_EXP");
      if (str != null)
      {
        localObject = str.split(":", 2);
        int i = 80;
        if (localObject.length > 1) {
          i = Integer.parseInt(localObject[1]);
        }
        localObject = new InetSocketAddress(localObject[0], i);
      }
      paramSocketAddress = new OkHttpClientTransport((InetSocketAddress)paramSocketAddress, paramString1, paramString2, this.executor, this.socketFactory, Utils.convertSpec(this.connectionSpec), this.maxMessageSize, (InetSocketAddress)localObject, null, null);
      if (this.enableKeepAlive) {
        paramSocketAddress.enableKeepAlive(true, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos);
      }
      return paramSocketAddress;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */