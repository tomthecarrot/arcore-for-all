package com.google.instrumentation.stats;

import java.io.IOException;
import java.io.OutputStream;

public abstract class StatsContext
{
  public abstract Builder builder();
  
  public abstract StatsContext record(MeasurementMap paramMeasurementMap);
  
  public abstract void serialize(OutputStream paramOutputStream)
    throws IOException;
  
  public final StatsContext with(TagKey paramTagKey, TagValue paramTagValue)
  {
    return builder().set(paramTagKey, paramTagValue).build();
  }
  
  public final StatsContext with(TagKey paramTagKey1, TagValue paramTagValue1, TagKey paramTagKey2, TagValue paramTagValue2)
  {
    return builder().set(paramTagKey1, paramTagValue1).set(paramTagKey2, paramTagValue2).build();
  }
  
  public final StatsContext with(TagKey paramTagKey1, TagValue paramTagValue1, TagKey paramTagKey2, TagValue paramTagValue2, TagKey paramTagKey3, TagValue paramTagValue3)
  {
    return builder().set(paramTagKey1, paramTagValue1).set(paramTagKey2, paramTagValue2).set(paramTagKey3, paramTagValue3).build();
  }
  
  public static abstract class Builder
  {
    public abstract StatsContext build();
    
    public abstract Builder set(TagKey paramTagKey, TagValue paramTagValue);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/StatsContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */