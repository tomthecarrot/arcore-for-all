package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public abstract class Ticker
{
  private static final Ticker SYSTEM_TICKER = new Ticker()
  {
    public long read()
    {
      return Platform.systemNanoTime();
    }
  };
  
  @CheckReturnValue
  public static Ticker systemTicker()
  {
    return SYSTEM_TICKER;
  }
  
  public abstract long read();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Ticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */