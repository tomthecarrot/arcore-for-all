package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.NoopStatsContextFactory;
import java.net.SocketAddress;

public class InProcessChannelBuilder
  extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder>
{
  private final String name;
  
  private InProcessChannelBuilder(String paramString)
  {
    super(new InProcessSocketAddress(paramString), "localhost");
    this.name = ((String)Preconditions.checkNotNull(paramString, "name"));
    super.statsContextFactory(NoopStatsContextFactory.INSTANCE);
  }
  
  public static InProcessChannelBuilder forName(String paramString)
  {
    return new InProcessChannelBuilder(paramString);
  }
  
  protected ClientTransportFactory buildTransportFactory()
  {
    return new InProcessClientTransportFactory(this.name, null);
  }
  
  public final InProcessChannelBuilder maxInboundMessageSize(int paramInt)
  {
    return (InProcessChannelBuilder)super.maxInboundMessageSize(paramInt);
  }
  
  public InProcessChannelBuilder statsContextFactory(StatsContextFactory paramStatsContextFactory)
  {
    return this;
  }
  
  public InProcessChannelBuilder usePlaintext(boolean paramBoolean)
  {
    return this;
  }
  
  static final class InProcessClientTransportFactory
    implements ClientTransportFactory
  {
    private boolean closed;
    private final String name;
    
    private InProcessClientTransportFactory(String paramString)
    {
      this.name = paramString;
    }
    
    public void close()
    {
      this.closed = true;
    }
    
    public ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, String paramString2)
    {
      if (this.closed) {
        throw new IllegalStateException("The transport factory is closed.");
      }
      return new InProcessTransport(this.name, paramString1);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/inprocess/InProcessChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */