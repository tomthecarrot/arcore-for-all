package com.google.tango.analytics;

public abstract interface TangoAnalyticsTracker
{
  public abstract void logCounterEvent(String paramString, int paramInt);
  
  public abstract void logCounterEvent(String paramString, long paramLong);
  
  public abstract void logCounterEvent(String paramString, boolean paramBoolean);
  
  public abstract void resetSessionId();
  
  public abstract void sendCloudAdfTileDownloadedEvent(double paramDouble1, long paramLong1, long paramLong2, double paramDouble2);
  
  public abstract void sendCloudAdfTileLoadedEvent(double paramDouble, int paramInt, long paramLong, Long[] paramArrayOfLong);
  
  public abstract void sendCloudDownloadFailureEvent(long paramLong, int paramInt);
  
  public abstract void sendCloudReadyEvent(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  
  public abstract void sendConnectEventFromString(double paramDouble, int paramInt, String paramString1, String paramString2);
  
  public abstract void sendDisconnectEvent(double paramDouble1, double paramDouble2, String paramString);
  
  public abstract void sendHalDebugEventFromString(String paramString, boolean paramBoolean);
  
  public abstract void sendLocalizationSuccessEvent(double paramDouble1, double paramDouble2);
  
  public abstract void sendUserDataSegmentFirstFixEvent(long paramLong, int paramInt);
  
  public abstract void sendVioResetEvent(double paramDouble1, double paramDouble2, int paramInt);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/TangoAnalyticsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */