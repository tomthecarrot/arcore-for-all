package com.google.instrumentation.stats;

import com.google.instrumentation.common.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IntervalAggregation
{
  private final List<Interval> intervals;
  private final List<Tag> tags;
  
  private IntervalAggregation(List<Tag> paramList, List<Interval> paramList1)
  {
    this.tags = paramList;
    this.intervals = Collections.unmodifiableList(new ArrayList(paramList1));
  }
  
  public static final IntervalAggregation create(List<Tag> paramList, List<Interval> paramList1)
  {
    return new IntervalAggregation(paramList, paramList1);
  }
  
  public List<Interval> getIntervals()
  {
    return this.intervals;
  }
  
  public final List<Tag> getTags()
  {
    return this.tags;
  }
  
  public static final class Interval
  {
    private final double count;
    private final Duration intervalSize;
    private final double sum;
    
    private Interval(Duration paramDuration, double paramDouble1, double paramDouble2)
    {
      this.intervalSize = paramDuration;
      this.count = paramDouble1;
      this.sum = paramDouble2;
    }
    
    public static Interval create(Duration paramDuration, double paramDouble1, double paramDouble2)
    {
      return new Interval(paramDuration, paramDouble1, paramDouble2);
    }
    
    public double getCount()
    {
      return this.count;
    }
    
    public Duration getIntervalSize()
    {
      return this.intervalSize;
    }
    
    public double getSum()
    {
      return this.sum;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/IntervalAggregation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */