package com.google.tango.analytics;

class NoopTracker
  implements TangoAnalyticsTracker
{
  private static final String TAG = NoopTracker.class.getName();
  
  public void logCounterEvent(String paramString, int paramInt) {}
  
  public void logCounterEvent(String paramString, long paramLong) {}
  
  public void logCounterEvent(String paramString, boolean paramBoolean) {}
  
  public void resetSessionId() {}
  
  public void sendCloudAdfTileDownloadedEvent(double paramDouble1, long paramLong1, long paramLong2, double paramDouble2) {}
  
  public void sendCloudAdfTileLoadedEvent(double paramDouble, int paramInt, long paramLong, Long[] paramArrayOfLong) {}
  
  public void sendCloudDownloadFailureEvent(long paramLong, int paramInt) {}
  
  public void sendCloudReadyEvent(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2) {}
  
  public void sendConnectEventFromString(double paramDouble, int paramInt, String paramString1, String paramString2) {}
  
  public void sendDisconnectEvent(double paramDouble1, double paramDouble2, String paramString) {}
  
  public void sendHalDebugEventFromString(String paramString, boolean paramBoolean) {}
  
  public void sendLocalizationSuccessEvent(double paramDouble1, double paramDouble2) {}
  
  public void sendUserDataSegmentFirstFixEvent(long paramLong, int paramInt) {}
  
  public void sendVioResetEvent(double paramDouble1, double paramDouble2, int paramInt) {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/NoopTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */