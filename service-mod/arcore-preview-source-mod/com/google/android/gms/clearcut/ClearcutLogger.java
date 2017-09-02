package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.clearcut.internal.PlayLoggerContext;
import com.google.android.gms.clearcut.internal.zzb;
import com.google.android.gms.clearcut.internal.zzc;
import com.google.android.gms.clearcut.internal.zzi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzcgl.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class ClearcutLogger
{
  @Deprecated
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ClearcutLogger.API", zzaiG, zzaiF);
  public static final Api.zzf<zzc> zzaiF = new Api.zzf();
  public static final Api.zza<zzc, Api.ApiOptions.NoOptions> zzaiG = new Api.zza()
  {
    public zzc zzl(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzc(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private final String mPackageName;
  private final int zzaIJ;
  private String zzaIK;
  private int zzaIL = -1;
  private String zzaIM;
  private String zzaIN;
  private final boolean zzaIO;
  private int zzaIP = 0;
  private final ClearcutLoggerApi zzaIQ;
  private TimeZoneOffsetProvider zzaIR;
  private final LogSampler zzaIS;
  private final Clock zzvi;
  
  @Deprecated
  public ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this(paramContext, paramInt, paramString1, paramString2, zzb.zzaK(paramContext), zzh.zzAM(), new TimeZoneOffsetProvider());
  }
  
  @Deprecated
  public ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2, ClearcutLoggerApi paramClearcutLoggerApi, Clock paramClock, TimeZoneOffsetProvider paramTimeZoneOffsetProvider)
  {
    this(paramContext, paramInt, "", paramString1, paramString2, false, paramClearcutLoggerApi, paramClock, paramTimeZoneOffsetProvider, new zzi(paramContext));
  }
  
  public ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, ClearcutLoggerApi paramClearcutLoggerApi, Clock paramClock, TimeZoneOffsetProvider paramTimeZoneOffsetProvider)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean, paramClearcutLoggerApi, paramClock, paramTimeZoneOffsetProvider, new LogSampler()
    {
      public boolean shouldLog(String paramAnonymousString, int paramAnonymousInt)
      {
        return true;
      }
    });
  }
  
  public ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, ClearcutLoggerApi paramClearcutLoggerApi, Clock paramClock, TimeZoneOffsetProvider paramTimeZoneOffsetProvider, LogSampler paramLogSampler)
  {
    this.mPackageName = paramContext.getPackageName();
    this.zzaIJ = zzaJ(paramContext);
    this.zzaIL = paramInt;
    this.zzaIK = paramString1;
    this.zzaIM = paramString2;
    this.zzaIN = paramString3;
    this.zzaIO = paramBoolean;
    this.zzaIQ = paramClearcutLoggerApi;
    this.zzvi = paramClock;
    if (paramTimeZoneOffsetProvider != null) {}
    for (;;)
    {
      this.zzaIR = paramTimeZoneOffsetProvider;
      this.zzaIP = 0;
      this.zzaIS = paramLogSampler;
      if (this.zzaIO)
      {
        paramBoolean = bool;
        if (this.zzaIM == null) {
          paramBoolean = true;
        }
        zzac.zzb(paramBoolean, "can't be anonymous with an upload account");
      }
      return;
      paramTimeZoneOffsetProvider = new TimeZoneOffsetProvider();
    }
  }
  
  public ClearcutLogger(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, -1, paramString1, paramString2, null, false, zzb.zzaK(paramContext), zzh.zzAM(), null, new zzi(paramContext));
  }
  
  public ClearcutLogger(Context paramContext, String paramString1, String paramString2, ClearcutLoggerApi paramClearcutLoggerApi, Clock paramClock, TimeZoneOffsetProvider paramTimeZoneOffsetProvider) {}
  
  @Deprecated
  public ClearcutLogger(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, -1, paramString1, paramString2, paramString3, false, zzb.zzaK(paramContext), zzh.zzAM(), null, new zzi(paramContext));
  }
  
  @Deprecated
  public ClearcutLogger(Context paramContext, String paramString1, String paramString2, String paramString3, ClearcutLoggerApi paramClearcutLoggerApi, Clock paramClock, TimeZoneOffsetProvider paramTimeZoneOffsetProvider)
  {
    this(paramContext, -1, paramString1, paramString2, paramString3, false, paramClearcutLoggerApi, paramClock, paramTimeZoneOffsetProvider, new zzi(paramContext));
  }
  
  public static ClearcutLogger anonymousLogger(Context paramContext, String paramString)
  {
    return new ClearcutLogger(paramContext, -1, paramString, null, null, true, zzb.zzaK(paramContext), zzh.zzAM(), null, new zzi(paramContext));
  }
  
  private int zzaJ(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }
  
  private static int[] zzb(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayList.size()];
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramArrayList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static String[] zzc(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (String[])paramArrayList.toArray(new String[0]);
  }
  
  private static byte[][] zzd(ArrayList<byte[]> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    return (byte[][])paramArrayList.toArray(new byte[0][]);
  }
  
  @Deprecated
  public void disconnectAsync(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.disconnect();
  }
  
  @Deprecated
  public boolean flush(GoogleApiClient paramGoogleApiClient, long paramLong, TimeUnit paramTimeUnit)
  {
    return true;
  }
  
  public PendingResult<Status> forceUpload()
  {
    return this.zzaIQ.forceUpload();
  }
  
  @Deprecated
  public int getLogSource()
  {
    return this.zzaIL;
  }
  
  public String getLogSourceName()
  {
    return this.zzaIK;
  }
  
  @Deprecated
  public String getLoggingId()
  {
    return this.zzaIN;
  }
  
  public String getUploadAccountName()
  {
    return this.zzaIM;
  }
  
  public boolean isAnonymous()
  {
    return this.zzaIO;
  }
  
  public LogEventBuilder newEvent(MessageProducer paramMessageProducer)
  {
    return new LogEventBuilder(paramMessageProducer, null);
  }
  
  public LogEventBuilder newEvent(byte[] paramArrayOfByte)
  {
    return new LogEventBuilder(paramArrayOfByte, null);
  }
  
  public ClearcutLogger setQosTier(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4)) {}
    for (;;)
    {
      this.zzaIP = paramInt;
      return this;
      paramInt = 0;
    }
  }
  
  public ClearcutLogger setTimeZoneOffsetProvider(TimeZoneOffsetProvider paramTimeZoneOffsetProvider)
  {
    if (paramTimeZoneOffsetProvider != null) {}
    for (;;)
    {
      this.zzaIR = paramTimeZoneOffsetProvider;
      return this;
      paramTimeZoneOffsetProvider = new TimeZoneOffsetProvider();
    }
  }
  
  public class LogEventBuilder
  {
    private String zzaIK = ClearcutLogger.zzb(ClearcutLogger.this);
    private int zzaIL = ClearcutLogger.zza(ClearcutLogger.this);
    private String zzaIM = ClearcutLogger.zzc(ClearcutLogger.this);
    private String zzaIN = ClearcutLogger.zzd(ClearcutLogger.this);
    private int zzaIP = ClearcutLogger.zze(ClearcutLogger.this);
    private final ClearcutLogger.MessageProducer zzaIT;
    private ClearcutLogger.MessageProducer zzaIU;
    private ArrayList<Integer> zzaIV = null;
    private ArrayList<String> zzaIW = null;
    private ArrayList<Integer> zzaIX = null;
    private ArrayList<byte[]> zzaIY = null;
    private boolean zzaIZ = true;
    private final zzcgl.zzd zzaJa = new zzcgl.zzd();
    private boolean zzaJb = false;
    
    private LogEventBuilder(ClearcutLogger.MessageProducer paramMessageProducer)
    {
      this(null, paramMessageProducer);
    }
    
    private LogEventBuilder(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, null);
    }
    
    private LogEventBuilder(byte[] paramArrayOfByte, ClearcutLogger.MessageProducer paramMessageProducer)
    {
      this.zzaJa.GI = ClearcutLogger.zzf(ClearcutLogger.this).currentTimeMillis();
      this.zzaJa.GJ = ClearcutLogger.zzf(ClearcutLogger.this).elapsedRealtime();
      this.zzaJa.GT = ClearcutLogger.zzg(ClearcutLogger.this).getOffsetSeconds(this.zzaJa.GI);
      if (paramArrayOfByte != null) {
        this.zzaJa.GO = paramArrayOfByte;
      }
      this.zzaIT = paramMessageProducer;
    }
    
    public LogEventBuilder addExperimentIds(int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {}
      for (;;)
      {
        return this;
        if (this.zzaIX == null) {
          this.zzaIX = new ArrayList();
        }
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          this.zzaIX.add(Integer.valueOf(k));
          i += 1;
        }
      }
    }
    
    public LogEventBuilder addExperimentToken(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        return this;
      }
      if (this.zzaIY == null) {
        this.zzaIY = new ArrayList();
      }
      this.zzaIY.add(paramArrayOfByte);
      return this;
    }
    
    public LogEventBuilder addExperimentTokenAndSkipPhenotype(byte[] paramArrayOfByte)
    {
      this.zzaIZ = false;
      return addExperimentToken(paramArrayOfByte);
    }
    
    public LogEventBuilder addMendelPackage(String paramString)
    {
      if (this.zzaIW == null) {
        this.zzaIW = new ArrayList();
      }
      this.zzaIW.add(paramString);
      return this;
    }
    
    public LogEventBuilder addTestCode(int paramInt)
    {
      if (this.zzaIV == null) {
        this.zzaIV = new ArrayList();
      }
      this.zzaIV.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public LogEventParcelable getLogEventParcelable()
    {
      return new LogEventParcelable(new PlayLoggerContext(ClearcutLogger.zzi(ClearcutLogger.this), ClearcutLogger.zzj(ClearcutLogger.this), this.zzaIL, this.zzaIK, this.zzaIM, this.zzaIN, ClearcutLogger.zzh(ClearcutLogger.this), this.zzaIP), this.zzaJa, this.zzaIT, this.zzaIU, ClearcutLogger.zze(this.zzaIV), ClearcutLogger.zzf(this.zzaIW), ClearcutLogger.zze(this.zzaIX), ClearcutLogger.zzg(this.zzaIY), this.zzaIZ);
    }
    
    @Deprecated
    public PendingResult<Status> log(GoogleApiClient paramGoogleApiClient)
    {
      return logAsync();
    }
    
    public void log()
    {
      logAsync();
    }
    
    @Deprecated
    public PendingResult<Status> logAsync()
    {
      if (this.zzaJb) {
        throw new IllegalStateException("do not reuse LogEventBuilder");
      }
      this.zzaJb = true;
      LogEventParcelable localLogEventParcelable = getLogEventParcelable();
      PlayLoggerContext localPlayLoggerContext = localLogEventParcelable.playLoggerContext;
      if (ClearcutLogger.zzk(ClearcutLogger.this).shouldLog(localPlayLoggerContext.logSourceName, localPlayLoggerContext.logSource)) {
        return ClearcutLogger.zzl(ClearcutLogger.this).logEvent(localLogEventParcelable);
      }
      return PendingResults.immediatePendingResult(Status.zzaLc);
    }
    
    @Deprecated
    public PendingResult<Status> logAsync(GoogleApiClient paramGoogleApiClient)
    {
      return logAsync();
    }
    
    public LogEventBuilder setClientVisualElements(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {
        this.zzaJa.GV = paramArrayOfByte;
      }
      return this;
    }
    
    public LogEventBuilder setClientVisualElementsProducer(ClearcutLogger.MessageProducer paramMessageProducer)
    {
      this.zzaIU = paramMessageProducer;
      return this;
    }
    
    public LogEventBuilder setEventCode(int paramInt)
    {
      this.zzaJa.eventCode = paramInt;
      return this;
    }
    
    public LogEventBuilder setEventFlowId(int paramInt)
    {
      this.zzaJa.zzrh = paramInt;
      return this;
    }
    
    @Deprecated
    public LogEventBuilder setLogSource(int paramInt)
    {
      this.zzaIL = paramInt;
      return this;
    }
    
    public LogEventBuilder setLogSourceName(String paramString)
    {
      this.zzaIK = paramString;
      return this;
    }
    
    @Deprecated
    public LogEventBuilder setLoggingId(String paramString)
    {
      this.zzaIN = paramString;
      return this;
    }
    
    public LogEventBuilder setQosTier(int paramInt)
    {
      this.zzaIP = paramInt;
      return this;
    }
    
    @Deprecated
    public LogEventBuilder setTag(String paramString)
    {
      this.zzaJa.tag = paramString;
      return this;
    }
    
    public LogEventBuilder setUploadAccountName(String paramString)
    {
      if (ClearcutLogger.zzh(ClearcutLogger.this)) {
        throw new IllegalArgumentException("setUploadAccountName forbidden on anonymous logger");
      }
      this.zzaIM = paramString;
      return this;
    }
  }
  
  public static abstract interface LogSampler
  {
    public abstract boolean shouldLog(String paramString, int paramInt);
  }
  
  public static abstract interface MessageProducer
  {
    public abstract byte[] toProtoBytes();
  }
  
  public static class TimeZoneOffsetProvider
  {
    public long getOffsetSeconds(long paramLong)
    {
      return TimeZone.getDefault().getOffset(paramLong) / 1000;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/ClearcutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */