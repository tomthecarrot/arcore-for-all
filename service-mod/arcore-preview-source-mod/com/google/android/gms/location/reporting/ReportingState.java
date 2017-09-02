package com.google.android.gms.location.reporting;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzask;

public class ReportingState
  extends zza
{
  public static final Parcelable.Creator<ReportingState> CREATOR = new zzc();
  private final boolean mActive;
  private final int zzbHJ;
  private final int zzbHK;
  private final boolean zzbHL;
  private final int zzbHM;
  private final int zzbHN;
  private final Integer zzbHO;
  private final boolean zzbHP;
  
  @Deprecated
  public ReportingState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4, @Nullable Integer paramInteger)
  {
    this(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramInt4, paramInteger, true);
  }
  
  public ReportingState(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4, @Nullable Integer paramInteger, boolean paramBoolean3)
  {
    this.zzbHJ = paramInt1;
    this.zzbHK = paramInt2;
    this.zzbHL = paramBoolean1;
    this.mActive = paramBoolean2;
    this.zzbHM = paramInt3;
    this.zzbHN = paramInt4;
    this.zzbHO = paramInteger;
    this.zzbHP = paramBoolean3;
  }
  
  public boolean canAccessSettings()
  {
    return this.zzbHP;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ReportingState)) {}
    do
    {
      return false;
      paramObject = (ReportingState)paramObject;
    } while ((this.zzbHJ != ((ReportingState)paramObject).zzbHJ) || (this.zzbHK != ((ReportingState)paramObject).zzbHK) || (this.zzbHL != ((ReportingState)paramObject).zzbHL) || (this.mActive != ((ReportingState)paramObject).mActive) || (this.zzbHM != ((ReportingState)paramObject).zzbHM) || (this.zzbHN != ((ReportingState)paramObject).zzbHN) || (!zzaa.equal(this.zzbHO, ((ReportingState)paramObject).zzbHO)) || (this.zzbHP != ((ReportingState)paramObject).zzbHP));
    return true;
  }
  
  public int getDeviceTag()
  {
    if (this.zzbHO == null) {
      throw new SecurityException("Device tag restricted to approved apps");
    }
    return this.zzbHO.intValue();
  }
  
  public int getExpectedOptInResult()
  {
    return OptInResult.sanitize(this.zzbHM);
  }
  
  public int getHistoryEnabled()
  {
    return Setting.sanitize(this.zzbHK);
  }
  
  public int getReportingEnabled()
  {
    return Setting.sanitize(this.zzbHJ);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzbHJ), Integer.valueOf(this.zzbHK), Boolean.valueOf(this.zzbHL), Boolean.valueOf(this.mActive), Integer.valueOf(this.zzbHM), Integer.valueOf(this.zzbHN), this.zzbHO, Boolean.valueOf(this.zzbHP) });
  }
  
  public boolean isActive()
  {
    return this.mActive;
  }
  
  public boolean isAllowed()
  {
    return this.zzbHL;
  }
  
  public boolean isAmbiguous()
  {
    return (this.zzbHJ == -2) || (this.zzbHK == -2);
  }
  
  @Deprecated
  public boolean isDeferringToMaps()
  {
    return false;
  }
  
  public boolean isOptedIn()
  {
    return (Reporting.Setting.isOn(this.zzbHJ)) && (Reporting.Setting.isOn(this.zzbHK));
  }
  
  public boolean shouldOptIn()
  {
    return (!isOptedIn()) && (getExpectedOptInResult() == 0);
  }
  
  @Deprecated
  public boolean shouldOptInInsistent()
  {
    return shouldOptIn();
  }
  
  @Deprecated
  public boolean shouldOptInLenient()
  {
    return shouldOptIn();
  }
  
  public String toString()
  {
    if (this.zzbHO != null) {}
    for (String str = zzask.zzh(this.zzbHO);; str = "(hidden-from-unauthorized-caller)")
    {
      int i = this.zzbHJ;
      int j = this.zzbHK;
      boolean bool1 = this.zzbHL;
      boolean bool2 = this.mActive;
      int k = this.zzbHM;
      int m = this.zzbHN;
      boolean bool3 = this.zzbHP;
      return String.valueOf(str).length() + 235 + "ReportingState{mReportingEnabled=" + i + ", mHistoryEnabled=" + j + ", mAllowed=" + bool1 + ", mActive=" + bool2 + ", mExpectedOptInResult=" + k + ", mExpectedOptInResultAssumingLocationEnabled=" + m + ", mDeviceTag=" + str + ", mCanAccessSettings=" + bool3 + "}";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  int zzKZ()
  {
    return OptInResult.sanitize(this.zzbHN);
  }
  
  Integer zzLa()
  {
    return this.zzbHO;
  }
  
  @Deprecated
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
      Log.wtf("GCoreUlr", "", new UnsupportedOperationException("ReportingState.Setting is deprecated and will eventually be deleted. Use Reporting.Setting, ReportingStateRestult.isActive(), or ReportingStateRestult.isOptedIn()."));
      return Reporting.Setting.isOff(paramInt);
    }
    
    public static boolean isOn(int paramInt)
    {
      Log.wtf("GCoreUlr", "", new UnsupportedOperationException("ReportingState.Setting is deprecated and will eventually be deleted. Use Reporting.Setting, ReportingStateRestult.isActive(), or ReportingStateRestult.isOptedIn()."));
      return Reporting.Setting.isOn(paramInt);
    }
    
    public static int sanitize(int paramInt)
    {
      return Reporting.Setting.sanitize(paramInt);
    }
    
    public static String toString(int paramInt)
    {
      return Reporting.Setting.toString(paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/ReportingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */