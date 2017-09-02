package io.grpc.internal;

import com.google.instrumentation.stats.MeasurementMap;
import com.google.instrumentation.stats.StatsContext;
import com.google.instrumentation.stats.StatsContext.Builder;
import com.google.instrumentation.stats.StatsContextFactory;
import com.google.instrumentation.stats.TagKey;
import com.google.instrumentation.stats.TagValue;
import java.io.InputStream;
import java.io.OutputStream;

public final class NoopStatsContextFactory
  extends StatsContextFactory
{
  private static final StatsContext.Builder BUILDER = new NoopContextBuilder(null);
  private static final StatsContext DEFAULT_CONTEXT = new NoopStatsContext(null);
  public static final StatsContextFactory INSTANCE = new NoopStatsContextFactory();
  
  public StatsContext deserialize(InputStream paramInputStream)
  {
    return DEFAULT_CONTEXT;
  }
  
  public StatsContext getDefault()
  {
    return DEFAULT_CONTEXT;
  }
  
  private static class NoopContextBuilder
    extends StatsContext.Builder
  {
    public StatsContext build()
    {
      return NoopStatsContextFactory.DEFAULT_CONTEXT;
    }
    
    public StatsContext.Builder set(TagKey paramTagKey, TagValue paramTagValue)
    {
      return this;
    }
  }
  
  private static class NoopStatsContext
    extends StatsContext
  {
    public StatsContext.Builder builder()
    {
      return NoopStatsContextFactory.BUILDER;
    }
    
    public StatsContext record(MeasurementMap paramMeasurementMap)
    {
      return NoopStatsContextFactory.DEFAULT_CONTEXT;
    }
    
    public void serialize(OutputStream paramOutputStream) {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/NoopStatsContextFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */