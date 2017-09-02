package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Attributes.Builder;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class CallCredentialsApplyingTransportFactory
  implements ClientTransportFactory
{
  private final Executor appExecutor;
  private final ClientTransportFactory delegate;
  
  CallCredentialsApplyingTransportFactory(ClientTransportFactory paramClientTransportFactory, Executor paramExecutor)
  {
    this.delegate = ((ClientTransportFactory)Preconditions.checkNotNull(paramClientTransportFactory, "delegate"));
    this.appExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor, "appExecutor"));
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2)
  {
    return new CallCredentialsApplyingTransport(this.delegate.newClientTransport(paramSocketAddress, paramString1, paramString2), paramString1);
  }
  
  private class CallCredentialsApplyingTransport
    extends ForwardingConnectionClientTransport
  {
    private final String authority;
    private final ConnectionClientTransport delegate;
    
    CallCredentialsApplyingTransport(ConnectionClientTransport paramConnectionClientTransport, String paramString)
    {
      this.delegate = ((ConnectionClientTransport)Preconditions.checkNotNull(paramConnectionClientTransport, "delegate"));
      this.authority = ((String)Preconditions.checkNotNull(paramString, "authority"));
    }
    
    protected ConnectionClientTransport delegate()
    {
      return this.delegate;
    }
    
    public ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions, StatsTraceContext paramStatsTraceContext)
    {
      CallCredentials localCallCredentials = paramCallOptions.getCredentials();
      if (localCallCredentials != null)
      {
        paramMetadata = new MetadataApplierImpl(this.delegate, paramMethodDescriptor, paramMetadata, paramCallOptions, paramStatsTraceContext);
        paramStatsTraceContext = Attributes.newBuilder().set(CallCredentials.ATTR_AUTHORITY, this.authority).set(CallCredentials.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).setAll(this.delegate.getAttributes());
        if (paramCallOptions.getAuthority() != null) {
          paramStatsTraceContext.set(CallCredentials.ATTR_AUTHORITY, paramCallOptions.getAuthority());
        }
        localCallCredentials.applyRequestMetadata(paramMethodDescriptor, paramStatsTraceContext.build(), (Executor)MoreObjects.firstNonNull(paramCallOptions.getExecutor(), CallCredentialsApplyingTransportFactory.this.appExecutor), paramMetadata);
        return paramMetadata.returnStream();
      }
      return this.delegate.newStream(paramMethodDescriptor, paramMetadata, paramCallOptions, paramStatsTraceContext);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/CallCredentialsApplyingTransportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */