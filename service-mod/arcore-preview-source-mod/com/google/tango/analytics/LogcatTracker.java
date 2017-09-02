package com.google.tango.analytics;

import android.util.Log;
import java.util.UUID;

class LogcatTracker
  implements TangoAnalyticsTracker
{
  private static final String TAG = LogcatTracker.class.getName();
  private String mTangoSessionID = "";
  
  public void logCounterEvent(String paramString, int paramInt)
  {
    Log.d(TAG, "Counter event    Name: " + paramString + "    Key: " + paramInt);
  }
  
  public void logCounterEvent(String paramString, long paramLong)
  {
    Log.d(TAG, "Counter event    Name: " + paramString + "    Key: " + paramLong);
  }
  
  public void logCounterEvent(String paramString, boolean paramBoolean)
  {
    Log.d(TAG, "Counter event    Name: " + paramString + "    Key: " + paramBoolean);
  }
  
  public void resetSessionId()
  {
    this.mTangoSessionID = UUID.randomUUID().toString();
  }
  
  public void sendCloudAdfTileDownloadedEvent(double paramDouble1, long paramLong1, long paramLong2, double paramDouble2)
  {
    String str = "Cloud ADF Tile Downloaded    Duration: " + paramDouble1 + "    NumBytes: " + paramLong1 + "    Tile ID: " + paramLong2 + "    Write Duration: " + paramDouble2 + "    Tango Session ID: " + this.mTangoSessionID;
    Log.d(TAG, str);
  }
  
  public void sendCloudAdfTileLoadedEvent(double paramDouble, int paramInt, long paramLong, Long[] paramArrayOfLong)
  {
    paramArrayOfLong = "Cloud ADF Tile Loaded    Duration: " + paramDouble + "    NumTiles: " + paramInt + "    NumBytes: " + paramLong + "    Tango Session ID: " + this.mTangoSessionID;
    Log.d(TAG, paramArrayOfLong);
  }
  
  public void sendCloudDownloadFailureEvent(long paramLong, int paramInt)
  {
    String str = "Cloud Download Failed    Tile ID: " + paramLong + "    Error: " + paramInt + "    Tango Session ID: " + this.mTangoSessionID;
    Log.d(TAG, str);
  }
  
  public void sendCloudReadyEvent(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    String str = "Cloud Ready    Duration1: " + paramDouble1 + "    Duration2: " + paramDouble2 + "    NumDownloaded: " + paramInt1 + "    NumLoaded: " + paramInt2 + "    Tango Session ID: " + this.mTangoSessionID;
    Log.d(TAG, str);
  }
  
  public void sendConnectEventFromString(double paramDouble, int paramInt, String paramString1, String paramString2)
  {
    Log.d(TAG, "Tango Connect    Tango Session ID: " + this.mTangoSessionID + "    Connect Config: " + paramString2 + "    Error Code: " + paramInt + "    Call Duration: " + paramDouble);
  }
  
  public void sendDisconnectEvent(double paramDouble1, double paramDouble2, String paramString)
  {
    paramString = "Tango Disconnect    Session Duration: " + paramDouble1 + "    Call Duration: " + paramDouble2 + "    Tango Session ID: " + this.mTangoSessionID + "    Api Usage: " + paramString;
    Log.d(TAG, paramString);
  }
  
  public void sendHalDebugEventFromString(String paramString, boolean paramBoolean)
  {
    Log.d(TAG, "HAL Debug Event    Payload String: " + paramString + "    Fault: " + paramBoolean);
  }
  
  public void sendLocalizationSuccessEvent(double paramDouble1, double paramDouble2)
  {
    Log.d(TAG, "Localization Success Event    Duration: " + paramDouble1 + "    Distance Walked: " + paramDouble2 + "    Tango Session ID: " + this.mTangoSessionID);
  }
  
  public void sendUserDataSegmentFirstFixEvent(long paramLong, int paramInt)
  {
    Log.d(TAG, "User Data Segment Event    Segment Size: " + paramLong + "    Status: " + paramInt);
  }
  
  public void sendVioResetEvent(double paramDouble1, double paramDouble2, int paramInt)
  {
    String str = "VIO Session Reset    Duration: " + paramDouble1 + "    Distance Walked: " + paramDouble2 + "    Reset Type: " + paramInt + "    Tango Session ID: " + this.mTangoSessionID;
    Log.d(TAG, str);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/LogcatTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */