package com.google.instrumentation.stats;

import com.google.instrumentation.common.Provider;

public final class Stats
{
  private static final StatsContextFactory CONTEXT_FACTORY = (StatsContextFactory)Provider.newInstance("com.google.instrumentation.stats.StatsContextFactoryImpl", null);
  private static final StatsManager STATS_MANAGER = (StatsManager)Provider.newInstance("com.google.instrumentation.stats.StatsManagerImpl", null);
  
  Stats()
  {
    throw new AssertionError();
  }
  
  public static StatsContextFactory getStatsContextFactory()
  {
    return CONTEXT_FACTORY;
  }
  
  public static StatsManager getStatsManager()
  {
    return STATS_MANAGER;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */