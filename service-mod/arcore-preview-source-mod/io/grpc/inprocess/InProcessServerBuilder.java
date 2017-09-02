package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import com.google.instrumentation.stats.StatsContextFactory;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.NoopStatsContextFactory;
import java.io.File;

public final class InProcessServerBuilder
  extends AbstractServerImplBuilder<InProcessServerBuilder>
{
  private final String name;
  
  private InProcessServerBuilder(String paramString)
  {
    this.name = ((String)Preconditions.checkNotNull(paramString, "name"));
    super.statsContextFactory(NoopStatsContextFactory.INSTANCE);
  }
  
  public static InProcessServerBuilder forName(String paramString)
  {
    return new InProcessServerBuilder(paramString);
  }
  
  protected InProcessServer buildTransportServer()
  {
    return new InProcessServer(this.name);
  }
  
  public InProcessServerBuilder statsContextFactory(StatsContextFactory paramStatsContextFactory)
  {
    return this;
  }
  
  public InProcessServerBuilder useTransportSecurity(File paramFile1, File paramFile2)
  {
    throw new UnsupportedOperationException("TLS not supported in InProcessServer");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/inprocess/InProcessServerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */