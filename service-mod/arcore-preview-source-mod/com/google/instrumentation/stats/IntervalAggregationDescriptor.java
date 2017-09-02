package com.google.instrumentation.stats;

import com.google.instrumentation.common.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IntervalAggregationDescriptor
{
  private final List<Duration> intervalSizes;
  private final int numSubIntervals;
  
  private IntervalAggregationDescriptor(int paramInt, List<Duration> paramList)
  {
    this.numSubIntervals = paramInt;
    this.intervalSizes = paramList;
  }
  
  public static IntervalAggregationDescriptor create(int paramInt, List<Duration> paramList)
  {
    if ((paramInt < 2) || (paramInt > 20)) {
      throw new IllegalArgumentException("The number of subintervals must be in the range [2, 20].");
    }
    if (paramList.isEmpty()) {
      throw new IllegalArgumentException("There must be at least one interval size.");
    }
    return new IntervalAggregationDescriptor(paramInt, Collections.unmodifiableList(new ArrayList(paramList)));
  }
  
  public static IntervalAggregationDescriptor create(List<Duration> paramList)
  {
    return create(5, paramList);
  }
  
  public List<Duration> getIntervalSizes()
  {
    return this.intervalSizes;
  }
  
  public int getNumSubIntervals()
  {
    return this.numSubIntervals;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/IntervalAggregationDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */