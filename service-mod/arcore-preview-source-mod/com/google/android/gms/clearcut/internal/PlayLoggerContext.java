package com.google.android.gms.clearcut.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class PlayLoggerContext
  extends zza
{
  public static final Parcelable.Creator<PlayLoggerContext> CREATOR = new zzj();
  public final boolean isAnonymous;
  public final boolean logAndroidId;
  public final int logSource;
  public final String logSourceName;
  public final String loggingId;
  public final String packageName;
  public final int packageVersionCode;
  public final int qosTier;
  public final String uploadAccountName;
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.packageName = ((String)zzac.zzC(paramString1));
    this.packageVersionCode = paramInt1;
    this.logSource = paramInt2;
    this.logSourceName = paramString2;
    this.uploadAccountName = paramString3;
    this.loggingId = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.logAndroidId = bool;
      this.isAnonymous = paramBoolean;
      this.qosTier = paramInt3;
      return;
    }
  }
  
  @Deprecated
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.packageName = ((String)zzac.zzC(paramString1));
    this.packageVersionCode = paramInt1;
    this.logSource = paramInt2;
    this.logSourceName = null;
    this.uploadAccountName = paramString2;
    this.loggingId = paramString3;
    this.logAndroidId = paramBoolean;
    this.isAnonymous = false;
    this.qosTier = 0;
  }
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt3)
  {
    this.packageName = paramString1;
    this.packageVersionCode = paramInt1;
    this.logSource = paramInt2;
    this.uploadAccountName = paramString2;
    this.loggingId = paramString3;
    this.logAndroidId = paramBoolean1;
    this.logSourceName = paramString4;
    this.isAnonymous = paramBoolean2;
    this.qosTier = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      paramObject = (PlayLoggerContext)paramObject;
    } while ((this.packageName.equals(((PlayLoggerContext)paramObject).packageName)) && (this.packageVersionCode == ((PlayLoggerContext)paramObject).packageVersionCode) && (this.logSource == ((PlayLoggerContext)paramObject).logSource) && (zzaa.equal(this.logSourceName, ((PlayLoggerContext)paramObject).logSourceName)) && (zzaa.equal(this.uploadAccountName, ((PlayLoggerContext)paramObject).uploadAccountName)) && (zzaa.equal(this.loggingId, ((PlayLoggerContext)paramObject).loggingId)) && (this.logAndroidId == ((PlayLoggerContext)paramObject).logAndroidId) && (this.isAnonymous == ((PlayLoggerContext)paramObject).isAnonymous) && (this.qosTier == ((PlayLoggerContext)paramObject).qosTier));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.packageName, Integer.valueOf(this.packageVersionCode), Integer.valueOf(this.logSource), this.logSourceName, this.uploadAccountName, this.loggingId, Boolean.valueOf(this.logAndroidId), Boolean.valueOf(this.isAnonymous), Integer.valueOf(this.qosTier) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(this.packageVersionCode).append(',');
    localStringBuilder.append("logSource=").append(this.logSource).append(',');
    localStringBuilder.append("logSourceName=").append(this.logSourceName).append(',');
    localStringBuilder.append("uploadAccount=").append(this.uploadAccountName).append(',');
    localStringBuilder.append("loggingId=").append(this.loggingId).append(',');
    localStringBuilder.append("logAndroidId=").append(this.logAndroidId).append(',');
    localStringBuilder.append("isAnonymous=").append(this.isAnonymous).append(',');
    localStringBuilder.append("qosTier=").append(this.qosTier);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/internal/PlayLoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */