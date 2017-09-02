package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.internal.zzac;

public class GoogleAnalytics
{
  private static GoogleAnalytics zzcuA;
  private final Context mContext;
  
  GoogleAnalytics(Context paramContext)
  {
    zzac.zzb(paramContext, "context cannot be null.");
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (zzcuA == null) {
        zzcuA = new GoogleAnalytics(paramContext);
      }
      paramContext = zzcuA;
      return paramContext;
    }
    finally {}
  }
  
  public GoogleAnalytics setAutoActivityTracking(boolean paramBoolean)
  {
    TagManager localTagManager = zzXG();
    if (paramBoolean) {}
    for (String str = "1";; str = "")
    {
      localTagManager.getDataLayer().push("gtm.enable_auto_activity_tracking", str);
      return this;
    }
  }
  
  public GoogleAnalytics setTrackingId(String paramString)
  {
    zzXG().getDataLayer().push("gtm.analytics.tracking_id", paramString);
    return this;
  }
  
  protected TagManager zzXG()
  {
    return TagManager.getInstance(this.mContext);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */