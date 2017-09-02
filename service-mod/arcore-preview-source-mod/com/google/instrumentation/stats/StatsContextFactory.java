package com.google.instrumentation.stats;

import java.io.IOException;
import java.io.InputStream;

public abstract class StatsContextFactory
{
  public abstract StatsContext deserialize(InputStream paramInputStream)
    throws IOException;
  
  public abstract StatsContext getDefault();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/StatsContextFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */