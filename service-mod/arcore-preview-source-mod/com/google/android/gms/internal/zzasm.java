package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.reporting.OptInRequest;
import com.google.android.gms.location.reporting.Reporting;
import com.google.android.gms.location.reporting.Reporting.ReportingStateResult;
import com.google.android.gms.location.reporting.Reporting.ReportingUploadResult;
import com.google.android.gms.location.reporting.Reporting.Setting;
import com.google.android.gms.location.reporting.ReportingServices.zza;
import com.google.android.gms.location.reporting.ReportingState;
import com.google.android.gms.location.reporting.UploadRequest;
import com.google.android.gms.location.reporting.UploadRequestResult;

public class zzasm
  implements Reporting
{
  private static int zzpb(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 8;
    case 0: 
      return 0;
    case 1: 
      return 3507;
    case 2: 
    case 3: 
      return 5;
    case 4: 
      return 10;
    case 5: 
      return 3500;
    case 6: 
      return 3501;
    case 7: 
      return 3502;
    case 8: 
      return 3503;
    case 10: 
      return 3510;
    }
    return 3511;
  }
  
  private static int zzpc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 8;
    case 0: 
      return 0;
    case 2: 
      return 3505;
    case 3: 
      return 3504;
    case 4: 
      return 3500;
    case 100: 
      return 3506;
    case 5: 
      return 3508;
    }
    return 3509;
  }
  
  private static int zzpd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 8;
    case 0: 
      return 0;
    }
    return 3504;
  }
  
  public PendingResult<Status> cancelUpload(GoogleApiClient paramGoogleApiClient, final long paramLong)
  {
    paramGoogleApiClient.zzb(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        zzb(new Status(zzasm.zzpc(paramAnonymouszzasl.zzag(paramLong))));
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Reporting.ReportingStateResult> getReportingStateSafe(GoogleApiClient paramGoogleApiClient, final Account paramAccount)
  {
    paramGoogleApiClient.zza(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        paramAnonymouszzasl = paramAnonymouszzasl.zzg(paramAccount);
        zzb(new zzasm.zza(Status.zzaLc, paramAnonymouszzasl));
      }
      
      protected Reporting.ReportingStateResult zzcy(Status paramAnonymousStatus)
      {
        return new zzasm.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> reportPlace(GoogleApiClient paramGoogleApiClient, final Account paramAccount, final PlaceReport paramPlaceReport)
  {
    paramGoogleApiClient.zzb(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        zzb(new Status(zzasm.zzpd(paramAnonymouszzasl.zza(paramAccount, paramPlaceReport))));
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Reporting.ReportingUploadResult> requestUpload(GoogleApiClient paramGoogleApiClient, final UploadRequest paramUploadRequest)
  {
    paramGoogleApiClient.zzb(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        paramAnonymouszzasl = paramAnonymouszzasl.zza(paramUploadRequest);
        zzb(new zzasm.zzb(new Status(zzasm.zzpc(paramAnonymouszzasl.getResultCode())), paramAnonymouszzasl.getRequestId()));
      }
      
      public Reporting.ReportingUploadResult zzcz(Status paramAnonymousStatus)
      {
        return new zzasm.zzb(paramAnonymousStatus, -1L);
      }
    });
  }
  
  public PendingResult<Status> tryOptIn(GoogleApiClient paramGoogleApiClient, final Account paramAccount)
  {
    paramGoogleApiClient.zzb(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        zzb(new Status(zzasm.zzpb(paramAnonymouszzasl.zzh(paramAccount))));
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> tryOptInRequest(GoogleApiClient paramGoogleApiClient, final OptInRequest paramOptInRequest)
  {
    paramGoogleApiClient.zzb(new ReportingServices.zza(paramGoogleApiClient)
    {
      protected void zza(zzasl paramAnonymouszzasl)
        throws RemoteException
      {
        zzb(new Status(zzasm.zzpb(paramAnonymouszzasl.zza(paramOptInRequest))));
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  private static class zza
    implements Reporting.ReportingStateResult
  {
    private final Status zzaiT;
    private final ReportingState zzbHX;
    
    public zza(Status paramStatus, @Nullable ReportingState paramReportingState)
    {
      this.zzaiT = paramStatus;
      if (paramStatus.getStatusCode() == 0) {
        zzac.zzC(paramReportingState);
      }
      this.zzbHX = paramReportingState;
    }
    
    private void zzLb()
    {
      if (this.zzaiT.getStatusCode() != 0)
      {
        String str = String.valueOf(this.zzaiT);
        throw new IllegalStateException(String.valueOf(str).length() + 52 + "Illegal to call this method when status is failure: " + str);
      }
    }
    
    public int getDeviceTag()
    {
      zzLb();
      return this.zzbHX.getDeviceTag();
    }
    
    public int getExpectedOptInStatusCode()
    {
      zzLb();
      return zzasm.zzpb(this.zzbHX.getExpectedOptInResult());
    }
    
    public int getHistoryEnabledSetting()
    {
      zzLb();
      return this.zzbHX.getHistoryEnabled();
    }
    
    public int getReportingEnabledSetting()
    {
      zzLb();
      return this.zzbHX.getReportingEnabled();
    }
    
    public Status getStatus()
    {
      return this.zzaiT;
    }
    
    public boolean isActive()
    {
      zzLb();
      return this.zzbHX.isActive();
    }
    
    public boolean isAllowed()
    {
      zzLb();
      return this.zzbHX.isAllowed();
    }
    
    public boolean isDeferringToMaps()
    {
      zzLb();
      Log.wtf("GCoreUlr", "", new UnsupportedOperationException("This method always returns false now, and will eventually be deleted"));
      return false;
    }
    
    public boolean isHistoryEnabled()
    {
      return Reporting.Setting.isOn(getHistoryEnabledSetting());
    }
    
    public boolean isOptedIn()
    {
      zzLb();
      return this.zzbHX.isOptedIn();
    }
    
    public boolean isReportingEnabled()
    {
      return Reporting.Setting.isOn(getReportingEnabledSetting());
    }
    
    public boolean shouldOptIn()
    {
      zzLb();
      return this.zzbHX.shouldOptIn();
    }
    
    public boolean shouldOptInInsistent()
    {
      Log.wtf("GCoreUlr", "", new UnsupportedOperationException("Deprecated: please use shouldOptIn(). This method will eventually be deleted."));
      return shouldOptIn();
    }
    
    public boolean shouldOptInLenient()
    {
      Log.wtf("GCoreUlr", "", new UnsupportedOperationException("Deprecated: please use shouldOptIn(). This method will eventually be deleted."));
      return shouldOptIn();
    }
    
    public String toString()
    {
      String str1 = String.valueOf(this.zzaiT);
      String str2 = String.valueOf(this.zzbHX);
      return String.valueOf(str1).length() + 52 + String.valueOf(str2).length() + "ReportingStateResultImpl{mStatus=" + str1 + ", mReportingState=" + str2 + "}";
    }
  }
  
  private static class zzb
    implements Reporting.ReportingUploadResult
  {
    private final long zzaGe;
    private final Status zzaiT;
    
    public zzb(Status paramStatus, long paramLong)
    {
      this.zzaiT = paramStatus;
      this.zzaGe = paramLong;
    }
    
    public long getRequestId()
    {
      return this.zzaGe;
    }
    
    public Status getStatus()
    {
      return this.zzaiT;
    }
    
    public String toString()
    {
      String str = String.valueOf(this.zzaiT);
      long l = this.zzaGe;
      return String.valueOf(str).length() + 68 + "ReportingUploadResultImpl{mStatus=" + str + ", mRequestId=" + l + "}";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzasm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */