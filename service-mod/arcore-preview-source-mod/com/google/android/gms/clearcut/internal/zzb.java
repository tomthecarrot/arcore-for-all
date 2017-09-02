package com.google.android.gms.clearcut.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger.MessageProducer;
import com.google.android.gms.clearcut.ClearcutLoggerApi;
import com.google.android.gms.clearcut.ClearcutLoggerApi.ExpiryTimeResult;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.internal.zzcgg;
import com.google.android.gms.internal.zzcgl.zzd;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.internal.zzyr.zza;
import java.util.concurrent.TimeUnit;

public class zzb
  extends zzd<Api.ApiOptions.NoOptions>
  implements ClearcutLoggerApi
{
  zzb(@NonNull Context paramContext)
  {
    super(paramContext, ClearcutLogger.API, null, new zzym());
  }
  
  static void zza(LogEventParcelable paramLogEventParcelable)
  {
    if ((paramLogEventParcelable.extensionProducer != null) && (paramLogEventParcelable.logEvent.GO.length == 0)) {
      paramLogEventParcelable.logEvent.GO = paramLogEventParcelable.extensionProducer.toProtoBytes();
    }
    if ((paramLogEventParcelable.clientVisualElementsProducer != null) && (paramLogEventParcelable.logEvent.GV.length == 0)) {
      paramLogEventParcelable.logEvent.GV = paramLogEventParcelable.clientVisualElementsProducer.toProtoBytes();
    }
    paramLogEventParcelable.logEventBytes = zzcgg.zzf(paramLogEventParcelable.logEvent);
  }
  
  public static ClearcutLoggerApi zzaK(@NonNull Context paramContext)
  {
    return new zzb(paramContext);
  }
  
  @Deprecated
  public void disconnectAsync(Object paramObject) {}
  
  @Deprecated
  public boolean flush(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
  {
    return true;
  }
  
  public PendingResult<Status> forceUpload()
  {
    return doBestEffortWrite(new zzb(asGoogleApiClient()));
  }
  
  @Deprecated
  public PendingResult<Status> forceUpload(Object paramObject)
  {
    return forceUpload();
  }
  
  public PendingResult<ClearcutLoggerApi.ExpiryTimeResult> getCollectForDebugExpiryTime()
  {
    return doRead(new zzc(asGoogleApiClient()));
  }
  
  public PendingResult<Status> logEvent(LogEventParcelable paramLogEventParcelable)
  {
    return doBestEffortWrite(new zzd(paramLogEventParcelable, asGoogleApiClient()));
  }
  
  @Deprecated
  public PendingResult<Status> logEvent(Object paramObject, LogEventParcelable paramLogEventParcelable)
  {
    return logEvent(paramLogEventParcelable);
  }
  
  @Deprecated
  public PendingResult<Status> logEventAsync(Context paramContext, LogEventParcelable paramLogEventParcelable)
  {
    return logEvent(paramLogEventParcelable);
  }
  
  @Deprecated
  public PendingResult<Status> logEventAsync(Object paramObject, LogEventParcelable paramLogEventParcelable)
  {
    return logEvent(paramLogEventParcelable);
  }
  
  public PendingResult<ClearcutLoggerApi.ExpiryTimeResult> startCollectForDebug()
  {
    return doBestEffortWrite(new zze(asGoogleApiClient()));
  }
  
  public PendingResult<Status> stopCollectForDebug()
  {
    return doBestEffortWrite(new zzf(asGoogleApiClient()));
  }
  
  static class zza
    extends zzg.zza
  {
    public void zzI(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzJ(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzK(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zza(Status paramStatus, long paramLong)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzb(Status paramStatus, long paramLong)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class zzb
    extends zzyr.zza<Status, zzc>
  {
    zzb(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected void zza(zzc paramzzc)
      throws RemoteException
    {
      paramzzc.zza(new zzb.zza()
      {
        public void zzJ(Status paramAnonymousStatus)
        {
          zzb.zzb.this.zzb(paramAnonymousStatus);
        }
      });
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  static final class zzc
    extends zzyr.zza<ClearcutLoggerApi.ExpiryTimeResult, zzc>
  {
    zzc(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected ClearcutLoggerApi.ExpiryTimeResult zzL(final Status paramStatus)
    {
      new ClearcutLoggerApi.ExpiryTimeResult()
      {
        public long getExpiryTimeMillis()
        {
          return 0L;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
    
    protected void zza(zzc paramzzc)
      throws RemoteException
    {
      paramzzc.zzd(new zzb.zza()
      {
        public void zzb(final Status paramAnonymousStatus, final long paramAnonymousLong)
        {
          zzb.zzc.this.zzb(new ClearcutLoggerApi.ExpiryTimeResult()
          {
            public long getExpiryTimeMillis()
            {
              return paramAnonymousLong;
            }
            
            public Status getStatus()
            {
              return paramAnonymousStatus;
            }
          });
        }
      });
    }
  }
  
  static final class zzd
    extends zzyr.zza<Status, zzc>
  {
    private final LogEventParcelable zzaJD;
    
    zzd(LogEventParcelable paramLogEventParcelable, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
      this.zzaJD = paramLogEventParcelable;
    }
    
    protected void zza(zzc paramzzc)
      throws RemoteException
    {
      zzb.zza local1 = new zzb.zza()
      {
        public void zzI(Status paramAnonymousStatus)
        {
          zzb.zzd.this.zzb(paramAnonymousStatus);
        }
      };
      try
      {
        zzb.zza(this.zzaJD);
        paramzzc.zza(local1, this.zzaJD);
        return;
      }
      catch (RuntimeException paramzzc)
      {
        Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", paramzzc);
        zzP(new Status(10, "MessageProducer"));
      }
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  static final class zze
    extends zzyr.zza<ClearcutLoggerApi.ExpiryTimeResult, zzc>
  {
    zze(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected ClearcutLoggerApi.ExpiryTimeResult zzL(final Status paramStatus)
    {
      new ClearcutLoggerApi.ExpiryTimeResult()
      {
        public long getExpiryTimeMillis()
        {
          return 0L;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
    
    protected void zza(zzc paramzzc)
      throws RemoteException
    {
      paramzzc.zzb(new zzb.zza()
      {
        public void zza(final Status paramAnonymousStatus, final long paramAnonymousLong)
        {
          zzb.zze.this.zzb(new ClearcutLoggerApi.ExpiryTimeResult()
          {
            public long getExpiryTimeMillis()
            {
              return paramAnonymousLong;
            }
            
            public Status getStatus()
            {
              return paramAnonymousStatus;
            }
          });
        }
      });
    }
  }
  
  static final class zzf
    extends zzyr.zza<Status, zzc>
  {
    zzf(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected void zza(zzc paramzzc)
      throws RemoteException
    {
      paramzzc.zzc(new zzb.zza()
      {
        public void zzK(Status paramAnonymousStatus)
        {
          zzb.zzf.this.zzb(paramAnonymousStatus);
        }
      });
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */