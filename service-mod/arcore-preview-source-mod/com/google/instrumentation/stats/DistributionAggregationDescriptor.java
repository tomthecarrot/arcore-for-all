package com.google.instrumentation.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class DistributionAggregationDescriptor
{
  @Nullable
  private final List<Double> bucketBoundaries;
  
  private DistributionAggregationDescriptor(@Nullable List<Double> paramList)
  {
    this.bucketBoundaries = paramList;
  }
  
  public static DistributionAggregationDescriptor create()
  {
    return new DistributionAggregationDescriptor(null);
  }
  
  public static DistributionAggregationDescriptor create(List<Double> paramList)
  {
    return new DistributionAggregationDescriptor(Collections.unmodifiableList(new ArrayList(paramList)));
  }
  
  @Nullable
  public List<Double> getBucketBoundaries()
  {
    return this.bucketBoundaries;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/DistributionAggregationDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */