package com.google.instrumentation.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class DistributionAggregation
{
  private final List<Long> bucketCounts;
  private final long count;
  private final double mean;
  private final Range range;
  private final double sum;
  private final List<Tag> tags;
  
  private DistributionAggregation(long paramLong, double paramDouble1, double paramDouble2, Range paramRange, List<Tag> paramList, @Nullable List<Long> paramList1)
  {
    this.count = paramLong;
    this.mean = paramDouble1;
    this.sum = paramDouble2;
    this.range = paramRange;
    this.tags = paramList;
    this.bucketCounts = paramList1;
  }
  
  public static final DistributionAggregation create(long paramLong, double paramDouble1, double paramDouble2, Range paramRange, List<Tag> paramList)
  {
    return new DistributionAggregation(paramLong, paramDouble1, paramDouble2, paramRange, paramList, null);
  }
  
  public static final DistributionAggregation create(long paramLong, double paramDouble1, double paramDouble2, Range paramRange, List<Tag> paramList, List<Long> paramList1)
  {
    return new DistributionAggregation(paramLong, paramDouble1, paramDouble2, paramRange, paramList, Collections.unmodifiableList(new ArrayList(paramList1)));
  }
  
  @Nullable
  public List<Long> getBucketCounts()
  {
    return this.bucketCounts;
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public double getMean()
  {
    return this.mean;
  }
  
  public Range getRange()
  {
    return this.range;
  }
  
  public double getSum()
  {
    return this.sum;
  }
  
  public final List<Tag> getTags()
  {
    return this.tags;
  }
  
  public static final class Range
  {
    private double max;
    private double min;
    
    private Range(double paramDouble1, double paramDouble2)
    {
      this.min = paramDouble1;
      this.max = paramDouble2;
    }
    
    public static final Range create(double paramDouble1, double paramDouble2)
    {
      return new Range(paramDouble1, paramDouble2);
    }
    
    public double getMax()
    {
      return this.max;
    }
    
    public double getMin()
    {
      return this.min;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/DistributionAggregation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */