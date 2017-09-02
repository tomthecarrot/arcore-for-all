package com.google.instrumentation.stats;

import com.google.instrumentation.common.Function;
import com.google.instrumentation.common.Timestamp;
import java.util.List;

public abstract class View
{
  public abstract ViewDescriptor getViewDescriptor();
  
  public abstract <T> T match(Function<DistributionView, T> paramFunction, Function<IntervalView, T> paramFunction1);
  
  public static final class DistributionView
    extends View
  {
    private final List<DistributionAggregation> distributionAggregations;
    private final ViewDescriptor.DistributionViewDescriptor distributionViewDescriptor;
    private final Timestamp end;
    private final Timestamp start;
    
    private DistributionView(ViewDescriptor.DistributionViewDescriptor paramDistributionViewDescriptor, List<DistributionAggregation> paramList, Timestamp paramTimestamp1, Timestamp paramTimestamp2)
    {
      super();
      this.distributionViewDescriptor = paramDistributionViewDescriptor;
      this.distributionAggregations = paramList;
      this.start = paramTimestamp1;
      this.end = paramTimestamp2;
    }
    
    public static DistributionView create(ViewDescriptor.DistributionViewDescriptor paramDistributionViewDescriptor, List<DistributionAggregation> paramList, Timestamp paramTimestamp1, Timestamp paramTimestamp2)
    {
      return new DistributionView(paramDistributionViewDescriptor, paramList, paramTimestamp1, paramTimestamp2);
    }
    
    public List<DistributionAggregation> getDistributionAggregations()
    {
      return this.distributionAggregations;
    }
    
    Timestamp getEnd()
    {
      return this.end;
    }
    
    Timestamp getStart()
    {
      return this.start;
    }
    
    public ViewDescriptor.DistributionViewDescriptor getViewDescriptor()
    {
      return this.distributionViewDescriptor;
    }
    
    public <T> T match(Function<DistributionView, T> paramFunction, Function<View.IntervalView, T> paramFunction1)
    {
      return (T)paramFunction.apply(this);
    }
  }
  
  public static final class IntervalView
    extends View
  {
    private final List<IntervalAggregation> intervalAggregations;
    private final ViewDescriptor.IntervalViewDescriptor intervalViewDescriptor;
    
    private IntervalView(ViewDescriptor.IntervalViewDescriptor paramIntervalViewDescriptor, List<IntervalAggregation> paramList)
    {
      super();
      this.intervalViewDescriptor = paramIntervalViewDescriptor;
      this.intervalAggregations = paramList;
    }
    
    public static IntervalView create(ViewDescriptor.IntervalViewDescriptor paramIntervalViewDescriptor, List<IntervalAggregation> paramList)
    {
      return new IntervalView(paramIntervalViewDescriptor, paramList);
    }
    
    public List<IntervalAggregation> getIntervalAggregations()
    {
      return this.intervalAggregations;
    }
    
    public ViewDescriptor.IntervalViewDescriptor getViewDescriptor()
    {
      return this.intervalViewDescriptor;
    }
    
    public <T> T match(Function<View.DistributionView, T> paramFunction, Function<IntervalView, T> paramFunction1)
    {
      return (T)paramFunction1.apply(this);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */