package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.places.PlaceReport;
import java.util.ArrayList;

public abstract interface Reporting
{
  public static final String DELETE_OPERATION_ACTION = "com.google.android.gms.location.reporting.DELETE_OPERATION";
  public static final String SETTINGS_CHANGED = "com.google.android.gms.location.reporting.SETTINGS_CHANGED";
  
  public abstract PendingResult<Status> cancelUpload(GoogleApiClient paramGoogleApiClient, long paramLong);
  
  public abstract PendingResult<ReportingStateResult> getReportingStateSafe(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  public abstract PendingResult<Status> reportPlace(GoogleApiClient paramGoogleApiClient, Account paramAccount, PlaceReport paramPlaceReport);
  
  public abstract PendingResult<ReportingUploadResult> requestUpload(GoogleApiClient paramGoogleApiClient, UploadRequest paramUploadRequest);
  
  public abstract PendingResult<Status> tryOptIn(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  public abstract PendingResult<Status> tryOptInRequest(GoogleApiClient paramGoogleApiClient, OptInRequest paramOptInRequest);
  
  public static final class DeletionHelper
  {
    public static ArrayList<Deletion> extractDeletions(Intent paramIntent)
    {
      zzac.zzaw("com.google.android.gms.location.reporting.DELETE_OPERATION".equals(paramIntent.getAction()));
      if (!paramIntent.hasExtra("deletions")) {
        return null;
      }
      return paramIntent.getParcelableArrayListExtra("deletions");
    }
  }
  
  public static abstract interface ReportingStateResult
    extends Result
  {
    public abstract int getDeviceTag();
    
    public abstract int getExpectedOptInStatusCode();
    
    public abstract int getHistoryEnabledSetting();
    
    public abstract int getReportingEnabledSetting();
    
    public abstract boolean isActive();
    
    public abstract boolean isAllowed();
    
    @Deprecated
    public abstract boolean isDeferringToMaps();
    
    public abstract boolean isHistoryEnabled();
    
    public abstract boolean isOptedIn();
    
    public abstract boolean isReportingEnabled();
    
    public abstract boolean shouldOptIn();
    
    @Deprecated
    public abstract boolean shouldOptInInsistent();
    
    @Deprecated
    public abstract boolean shouldOptInLenient();
    
    public abstract String toString();
  }
  
  public static abstract interface ReportingUploadResult
    extends Result
  {
    public abstract long getRequestId();
    
    public abstract String toString();
  }
  
  public static final class Setting
  {
    @Deprecated
    public static final int AMBIGUOUS = -2;
    public static final int OFF = -1;
    public static final int ON = 1;
    public static final int UNDEFINED = 0;
    public static final int UNKNOWN_OFF = -3;
    public static final int UNKNOWN_ON = 99;
    
    public static boolean isOff(int paramInt)
    {
      return paramInt < 0;
    }
    
    public static boolean isOn(int paramInt)
    {
      return paramInt > 0;
    }
    
    public static int sanitize(int paramInt)
    {
      int i = paramInt;
      switch (paramInt)
      {
      default: 
        if (!isOn(paramInt)) {
          break;
        }
      }
      for (paramInt = 99;; paramInt = -3)
      {
        i = paramInt;
        return i;
      }
    }
    
    public static String toString(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "Unknown";
      case 0: 
        return "Undefined";
      case -2: 
        return "Ambiguous";
      case -1: 
        return "Off";
      }
      return "On";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/Reporting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */