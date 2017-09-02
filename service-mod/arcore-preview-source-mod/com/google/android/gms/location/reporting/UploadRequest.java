package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzask;

public class UploadRequest
  extends zza
{
  public static final Parcelable.Creator<UploadRequest> CREATOR = new zzd();
  private final String zzHY;
  private final long zzaUB;
  private final Account zzagc;
  private final long zzbHQ;
  private final long zzbHR;
  private final String zzbHS;
  
  public UploadRequest(Account paramAccount, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    this.zzagc = paramAccount;
    this.zzHY = paramString1;
    this.zzaUB = paramLong1;
    this.zzbHQ = paramLong2;
    this.zzbHR = paramLong3;
    this.zzbHS = paramString2;
  }
  
  private UploadRequest(Builder paramBuilder)
  {
    this.zzagc = Builder.zza(paramBuilder);
    this.zzHY = Builder.zzb(paramBuilder);
    this.zzaUB = Builder.zzc(paramBuilder);
    this.zzbHQ = Builder.zzd(paramBuilder);
    this.zzbHR = Builder.zze(paramBuilder);
    this.zzbHS = Builder.zzf(paramBuilder);
  }
  
  public static Builder builder(Account paramAccount, String paramString, long paramLong)
  {
    return new Builder(paramAccount, paramString, paramLong, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UploadRequest)) {
        return false;
      }
      paramObject = (UploadRequest)paramObject;
    } while ((this.zzagc.equals(((UploadRequest)paramObject).zzagc)) && (this.zzHY.equals(((UploadRequest)paramObject).zzHY)) && (zzaa.equal(Long.valueOf(this.zzaUB), Long.valueOf(((UploadRequest)paramObject).zzaUB))) && (this.zzbHQ == ((UploadRequest)paramObject).zzbHQ) && (this.zzbHR == ((UploadRequest)paramObject).zzbHR) && (zzaa.equal(this.zzbHS, ((UploadRequest)paramObject).zzbHS)));
    return false;
  }
  
  public Account getAccount()
  {
    return this.zzagc;
  }
  
  public String getAppSpecificKey()
  {
    return this.zzbHS;
  }
  
  public long getDurationMillis()
  {
    return this.zzaUB;
  }
  
  public long getMovingLatencyMillis()
  {
    return this.zzbHQ;
  }
  
  public String getReason()
  {
    return this.zzHY;
  }
  
  public long getStationaryLatencyMillis()
  {
    return this.zzbHR;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzagc, this.zzHY, Long.valueOf(this.zzaUB), Long.valueOf(this.zzbHQ), Long.valueOf(this.zzbHR), this.zzbHS });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(zzask.zzi(this.zzagc));
    String str2 = this.zzHY;
    long l1 = this.zzaUB;
    long l2 = this.zzbHQ;
    long l3 = this.zzbHR;
    String str3 = this.zzbHS;
    return String.valueOf(str1).length() + 186 + String.valueOf(str2).length() + String.valueOf(str3).length() + "UploadRequest{, mAccount=" + str1 + ", mReason='" + str2 + "'" + ", mDurationMillis=" + l1 + ", mMovingLatencyMillis=" + l2 + ", mStationaryLatencyMillis=" + l3 + ", mAppSpecificKey='" + str3 + "'" + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final String zzHY;
    private final long zzaUB;
    private final Account zzagc;
    private String zzbHS;
    private long zzbHT = Long.MAX_VALUE;
    private long zzbHU = Long.MAX_VALUE;
    
    private Builder(Account paramAccount, String paramString, long paramLong)
    {
      this.zzagc = ((Account)zzac.zzb(paramAccount, "account"));
      this.zzHY = ((String)zzac.zzb(paramString, "reason"));
      this.zzaUB = paramLong;
    }
    
    public Builder appSpecificKey(String paramString)
    {
      this.zzbHS = paramString;
      return this;
    }
    
    public UploadRequest build()
    {
      return new UploadRequest(this, null);
    }
    
    public Builder latencyMillis(long paramLong)
    {
      return movingLatencyMillis(paramLong).stationaryLatencyMillis(paramLong);
    }
    
    public Builder movingLatencyMillis(long paramLong)
    {
      this.zzbHT = paramLong;
      return this;
    }
    
    public Builder stationaryLatencyMillis(long paramLong)
    {
      this.zzbHU = paramLong;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/UploadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */