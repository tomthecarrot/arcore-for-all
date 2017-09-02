package com.google.android.gms.clearcut;

import android.content.Context;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract interface ClearcutLoggerApi
{
  @Deprecated
  public abstract void disconnectAsync(Object paramObject);
  
  @Deprecated
  public abstract boolean flush(Object paramObject, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> forceUpload();
  
  @Deprecated
  public abstract PendingResult<Status> forceUpload(Object paramObject);
  
  public abstract PendingResult<ExpiryTimeResult> getCollectForDebugExpiryTime();
  
  public abstract PendingResult<Status> logEvent(LogEventParcelable paramLogEventParcelable);
  
  @Deprecated
  public abstract PendingResult<Status> logEvent(Object paramObject, LogEventParcelable paramLogEventParcelable);
  
  @Deprecated
  public abstract PendingResult<Status> logEventAsync(Context paramContext, LogEventParcelable paramLogEventParcelable);
  
  @Deprecated
  public abstract PendingResult<Status> logEventAsync(Object paramObject, LogEventParcelable paramLogEventParcelable);
  
  public abstract PendingResult<ExpiryTimeResult> startCollectForDebug();
  
  public abstract PendingResult<Status> stopCollectForDebug();
  
  public static abstract interface ExpiryTimeResult
    extends Result
  {
    public abstract long getExpiryTimeMillis();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/ClearcutLoggerApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */