package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class TrackerProvider
{
  private Context mContext;
  private Tracker zzabo;
  private GoogleAnalytics zzabq;
  
  public TrackerProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public TrackerProvider(GoogleAnalytics paramGoogleAnalytics)
  {
    this.zzabq = paramGoogleAnalytics;
    this.zzabq.setLogger(new zza());
  }
  
  private void zzjY(String paramString)
  {
    try
    {
      if (this.zzabq == null)
      {
        this.zzabq = GoogleAnalytics.getInstance(this.mContext);
        this.zzabq.setLogger(new zza());
        this.zzabo = this.zzabq.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker getTracker(String paramString)
  {
    zzjY(paramString);
    return this.zzabo;
  }
  
  static class zza
    implements Logger
  {
    private static int zzwu(int paramInt)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        return 3;
      case 5: 
        return 2;
      case 3: 
      case 4: 
        return 1;
      }
      return 0;
    }
    
    public void error(Exception paramException)
    {
      Log.e("", paramException);
    }
    
    public void error(String paramString)
    {
      Log.e(paramString);
    }
    
    public int getLogLevel()
    {
      return zzwu(Log.getLogLevel());
    }
    
    public void info(String paramString)
    {
      Log.i(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      Log.w("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      Log.v(paramString);
    }
    
    public void warn(String paramString)
    {
      Log.w(paramString);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/TrackerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */