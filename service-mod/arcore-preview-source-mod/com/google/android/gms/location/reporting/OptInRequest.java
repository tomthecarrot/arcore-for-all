package com.google.android.gms.location.reporting;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzask;

public class OptInRequest
  extends zza
{
  public static final Parcelable.Creator<OptInRequest> CREATOR = new zzb();
  private final String mTag;
  private final Account zzagc;
  
  public OptInRequest(Account paramAccount, String paramString)
  {
    this.zzagc = paramAccount;
    this.mTag = paramString;
  }
  
  private OptInRequest(Builder paramBuilder)
  {
    this.zzagc = Builder.zza(paramBuilder);
    this.mTag = Builder.zzb(paramBuilder);
  }
  
  public static Builder builder(Account paramAccount)
  {
    return new Builder(paramAccount, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof OptInRequest)) {
        return false;
      }
      paramObject = (OptInRequest)paramObject;
    } while ((this.zzagc.equals(((OptInRequest)paramObject).zzagc)) && (zzaa.equal(this.mTag, ((OptInRequest)paramObject).mTag)));
    return false;
  }
  
  public Account getAccount()
  {
    return this.zzagc;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzagc, this.mTag });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(zzask.zzi(this.zzagc));
    String str2 = this.mTag;
    return String.valueOf(str1).length() + 34 + String.valueOf(str2).length() + "UploadRequest{, mAccount=" + str1 + ", mTag='" + str2 + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String mTag;
    private final Account zzagc;
    
    private Builder(Account paramAccount)
    {
      this.zzagc = ((Account)zzac.zzb(paramAccount, "account"));
    }
    
    public OptInRequest build()
    {
      return new OptInRequest(this, null);
    }
    
    public Builder tag(String paramString)
    {
      this.mTag = paramString;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/reporting/OptInRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */