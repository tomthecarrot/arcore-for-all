package com.google.tango.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger.LogEventBuilder;
import com.google.android.gms.clearcut.ClearcutLogger.MessageProducer;
import com.google.android.gms.clearcut.Counters;
import com.google.android.gms.clearcut.Counters.BooleanHistogram;
import com.google.android.gms.clearcut.Counters.IntegerHistogram;
import com.google.android.gms.clearcut.Counters.LongHistogram;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

class ClearcutTracker
  implements TangoAnalyticsTracker
{
  private static final String NON_PLAY_APP_NAME = "NON_PLAY_APP";
  private static final String TAG = ClearcutTracker.class.getName();
  private static final Set<String> WHITELISTED_COUNTER_NAMES = new HashSet(Arrays.asList(new String[] { "TangoSession.DurationMs", "TangoSession.NumVioResets", "TangoSession.NumCloudDownloads", "CloudAdf.NumBytesPerTile", "CloudAdf.DownloadDurationMs", "Localization.DistanceWalkedCm", "Localization.DurationMs", "UserDataSegment.SegmentStatus" }));
  private Counters mCounters;
  private ClearcutLogger mLogger;
  private PackageManager mPackageManager;
  private String mTangoSessionId;
  
  public ClearcutTracker(Context paramContext)
  {
    if (Boolean.valueOf(paramContext.getResources().getString(R.string.tango_clearcut_enabled)).booleanValue()) {}
    for (String str = "TANGO_CORE";; str = "INVALID_NAME_SO_NOTHING_IS_LOGGED")
    {
      this.mLogger = new ClearcutLogger(paramContext, str, null);
      this.mCounters = new Counters(this.mLogger, str + "_COUNTERS", 1000);
      this.mTangoSessionId = "";
      this.mPackageManager = paramContext.getPackageManager();
      return;
    }
  }
  
  public void logCounterEvent(String paramString, int paramInt)
  {
    if (!WHITELISTED_COUNTER_NAMES.contains(paramString)) {
      throw new IllegalArgumentException(paramString + " is not a whitelisted name!");
    }
    this.mCounters.getIntegerHistogram(paramString).increment(paramInt);
  }
  
  public void logCounterEvent(String paramString, long paramLong)
  {
    if (!WHITELISTED_COUNTER_NAMES.contains(paramString)) {
      throw new IllegalArgumentException(paramString + " is not a whitelisted name!");
    }
    this.mCounters.getLongHistogram(paramString).increment(paramLong);
  }
  
  public void logCounterEvent(String paramString, boolean paramBoolean)
  {
    if (!WHITELISTED_COUNTER_NAMES.contains(paramString)) {
      throw new IllegalArgumentException(paramString + " is not a whitelisted name!");
    }
    this.mCounters.getBooleanHistogram(paramString).increment(paramBoolean);
  }
  
  public void resetSessionId()
  {
    this.mTangoSessionId = UUID.randomUUID().toString();
  }
  
  public void sendCloudAdfTileDownloadedEvent(final double paramDouble1, long paramLong1, final long paramLong2, double paramDouble2)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getCloudAdfTileDownloadedProto(paramDouble1, paramLong2, this.val$tileID, this.val$writeDuration, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendCloudAdfTileLoadedEvent(final double paramDouble, int paramInt, final long paramLong, final Long[] paramArrayOfLong)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getCloudAdfTileLoadedProto(paramDouble, paramLong, paramArrayOfLong, this.val$tileIDs, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendCloudDownloadFailureEvent(final long paramLong, int paramInt)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getCloudDownloadFailureProto(paramLong, this.val$errorCode, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendCloudReadyEvent(final double paramDouble1, double paramDouble2, final int paramInt1, int paramInt2)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getCloudReadyProto(paramDouble1, paramInt1, this.val$numTilesDownloaded, this.val$numTilesLoaded, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendConnectEventFromString(final double paramDouble, int paramInt, final String paramString1, final String paramString2)
  {
    paramString2 = ClearcutTrackerUtil.getSessionConfigProto(paramString2);
    final boolean bool = ClearcutTrackerUtil.shouldLogAppName(this.mPackageManager, paramString1);
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        double d = paramDouble;
        int i = bool;
        if (paramString1) {}
        for (String str = paramString2;; str = "NON_PLAY_APP") {
          return ClearcutTrackerUtil.getConnectProto(d, i, str, this.val$sessionConfig, ClearcutTracker.this.mTangoSessionId).toByteArray();
        }
      }
    }).log();
  }
  
  public void sendDisconnectEvent(final double paramDouble1, double paramDouble2, final String paramString)
  {
    paramString = ClearcutTrackerUtil.getApiUsageStats(paramString);
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getDisconnectProto(paramDouble1, paramString, this.val$apiUsageStats, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendHalDebugEventFromString(final String paramString, final boolean paramBoolean)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getHalDebugStatsProto(paramString, paramBoolean, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendLocalizationSuccessEvent(final double paramDouble1, double paramDouble2)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getLocalizationSuccessProto(paramDouble1, this.val$distanceWalked, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendUserDataSegmentFirstFixEvent(final long paramLong, int paramInt)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getUserDataSegmentFirstFixProto(paramLong, this.val$status, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
  
  public void sendVioResetEvent(final double paramDouble1, double paramDouble2, final int paramInt)
  {
    this.mLogger.newEvent(new ClearcutLogger.MessageProducer()
    {
      public byte[] toProtoBytes()
      {
        return ClearcutTrackerUtil.getVioResetProto(paramDouble1, paramInt, this.val$resetType, ClearcutTracker.this.mTangoSessionId).toByteArray();
      }
    }).log();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/analytics/ClearcutTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */