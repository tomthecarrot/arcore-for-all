package com.google.tango.analytics;

import android.content.Context;
import android.util.Log;

public class TangoAnalyticsUtil
{
  private static final String TAG = TangoAnalyticsUtil.class.getName();
  
  public static TangoAnalyticsTracker getClearcutTracker(Context paramContext)
  {
    try
    {
      paramContext = new ClearcutTracker(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "Exception encountered while creating ClearcutTracker! Will create NoopTracker.", paramContext);
    }
    return new NoopTracker();
  }
  
  public static TangoAnalyticsTracker getLogcatTracker()
  {
    return new LogcatTracker();
  }
  
  public static TangoAnalyticsTracker getNullTracker()
  {
    return new NoopTracker();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/TangoAnalyticsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */