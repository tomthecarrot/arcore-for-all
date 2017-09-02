package com.google.instrumentation.stats;

import com.google.instrumentation.common.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ViewDescriptor
{
  private final String description;
  private final MeasurementDescriptor measurementDescriptor;
  private final String name;
  private final List<TagKey> tagKeys;
  
  private ViewDescriptor(String paramString1, String paramString2, MeasurementDescriptor paramMeasurementDescriptor, List<TagKey> paramList)
  {
    this.name = paramString1;
    this.description = paramString2;
    this.measurementDescriptor = paramMeasurementDescriptor;
    this.tagKeys = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final MeasurementDescriptor getMeasurementDescriptor()
  {
    return this.measurementDescriptor;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final List<TagKey> getTagKeys()
  {
    return this.tagKeys;
  }
  
  public abstract <T> T match(Function<DistributionViewDescriptor, T> paramFunction, Function<IntervalViewDescriptor, T> paramFunction1);
  
  public static class DistributionViewDescriptor
    extends ViewDescriptor
  {
    private final DistributionAggregationDescriptor distributionAggregationDescriptor;
    
    private DistributionViewDescriptor(String paramString1, String paramString2, MeasurementDescriptor paramMeasurementDescriptor, DistributionAggregationDescriptor paramDistributionAggregationDescriptor, List<TagKey> paramList)
    {
      super(paramString2, paramMeasurementDescriptor, paramList, null);
      this.distributionAggregationDescriptor = paramDistributionAggregationDescriptor;
    }
    
    public static DistributionViewDescriptor create(String paramString1, String paramString2, MeasurementDescriptor paramMeasurementDescriptor, DistributionAggregationDescriptor paramDistributionAggregationDescriptor, List<TagKey> paramList)
    {
      return new DistributionViewDescriptor(paramString1, paramString2, paramMeasurementDescriptor, paramDistributionAggregationDescriptor, paramList);
    }
    
    public DistributionAggregationDescriptor getDistributionAggregationDescriptor()
    {
      return this.distributionAggregationDescriptor;
    }
    
    public <T> T match(Function<DistributionViewDescriptor, T> paramFunction, Function<ViewDescriptor.IntervalViewDescriptor, T> paramFunction1)
    {
      return (T)paramFunction.apply(this);
    }
  }
  
  public static class IntervalViewDescriptor
    extends ViewDescriptor
  {
    private final IntervalAggregationDescriptor intervalAggregationDescriptor;
    
    private IntervalViewDescriptor(String paramString1, String paramString2, MeasurementDescriptor paramMeasurementDescriptor, IntervalAggregationDescriptor paramIntervalAggregationDescriptor, List<TagKey> paramList)
    {
      super(paramString2, paramMeasurementDescriptor, paramList, null);
      this.intervalAggregationDescriptor = paramIntervalAggregationDescriptor;
    }
    
    public static IntervalViewDescriptor create(String paramString1, String paramString2, MeasurementDescriptor paramMeasurementDescriptor, IntervalAggregationDescriptor paramIntervalAggregationDescriptor, List<TagKey> paramList)
    {
      return new IntervalViewDescriptor(paramString1, paramString2, paramMeasurementDescriptor, paramIntervalAggregationDescriptor, paramList);
    }
    
    public IntervalAggregationDescriptor getIntervalAggregationDescriptor()
    {
      return this.intervalAggregationDescriptor;
    }
    
    public <T> T match(Function<ViewDescriptor.DistributionViewDescriptor, T> paramFunction, Function<IntervalViewDescriptor, T> paramFunction1)
    {
      return (T)paramFunction1.apply(this);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/ViewDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */