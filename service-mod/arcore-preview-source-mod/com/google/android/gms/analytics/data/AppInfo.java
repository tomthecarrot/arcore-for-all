package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class AppInfo
  extends zzf<AppInfo>
{
  private String mAppId;
  private String zzacB;
  private String zzacC;
  private String zzacD;
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  public String getAppInstallerId()
  {
    return this.zzacD;
  }
  
  public String getAppName()
  {
    return this.zzacB;
  }
  
  public String getAppVersion()
  {
    return this.zzacC;
  }
  
  public void mergeTo(AppInfo paramAppInfo)
  {
    if (!TextUtils.isEmpty(this.zzacB)) {
      paramAppInfo.setAppName(this.zzacB);
    }
    if (!TextUtils.isEmpty(this.zzacC)) {
      paramAppInfo.setAppVersion(this.zzacC);
    }
    if (!TextUtils.isEmpty(this.mAppId)) {
      paramAppInfo.setAppId(this.mAppId);
    }
    if (!TextUtils.isEmpty(this.zzacD)) {
      paramAppInfo.setAppInstallerId(this.zzacD);
    }
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setAppInstallerId(String paramString)
  {
    this.zzacD = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.zzacB = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.zzacC = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", this.zzacB);
    localHashMap.put("appVersion", this.zzacC);
    localHashMap.put("appId", this.mAppId);
    localHashMap.put("appInstallerId", this.zzacD);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */