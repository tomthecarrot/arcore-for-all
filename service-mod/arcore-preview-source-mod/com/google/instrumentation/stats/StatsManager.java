package com.google.instrumentation.stats;

public abstract class StatsManager
{
  public abstract View getView(ViewDescriptor paramViewDescriptor);
  
  public abstract void registerView(ViewDescriptor paramViewDescriptor);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/StatsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */