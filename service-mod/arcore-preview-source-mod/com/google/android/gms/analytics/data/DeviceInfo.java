package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class DeviceInfo
  extends zzf<DeviceInfo>
{
  public int mScreenColors;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mViewportHeight;
  public int mViewportWidth;
  private String zzacN;
  
  public String getLanguage()
  {
    return this.zzacN;
  }
  
  public int getScreenColors()
  {
    return this.mScreenColors;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }
  
  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }
  
  public int getViewportHeight()
  {
    return this.mViewportHeight;
  }
  
  public int getViewportWidth()
  {
    return this.mViewportWidth;
  }
  
  public void mergeTo(DeviceInfo paramDeviceInfo)
  {
    if (this.mScreenColors != 0) {
      paramDeviceInfo.setScreenColors(this.mScreenColors);
    }
    if (this.mScreenWidth != 0) {
      paramDeviceInfo.setScreenWidth(this.mScreenWidth);
    }
    if (this.mScreenHeight != 0) {
      paramDeviceInfo.setScreenHeight(this.mScreenHeight);
    }
    if (this.mViewportWidth != 0) {
      paramDeviceInfo.setViewportWidth(this.mViewportWidth);
    }
    if (this.mViewportHeight != 0) {
      paramDeviceInfo.setViewportHeight(this.mViewportHeight);
    }
    if (!TextUtils.isEmpty(this.zzacN)) {
      paramDeviceInfo.setLanguage(this.zzacN);
    }
  }
  
  public void setLanguage(String paramString)
  {
    this.zzacN = paramString;
  }
  
  public void setScreenColors(int paramInt)
  {
    this.mScreenColors = paramInt;
  }
  
  public void setScreenHeight(int paramInt)
  {
    this.mScreenHeight = paramInt;
  }
  
  public void setScreenWidth(int paramInt)
  {
    this.mScreenWidth = paramInt;
  }
  
  public void setViewportHeight(int paramInt)
  {
    this.mViewportHeight = paramInt;
  }
  
  public void setViewportWidth(int paramInt)
  {
    this.mViewportWidth = paramInt;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", this.zzacN);
    localHashMap.put("screenColors", Integer.valueOf(this.mScreenColors));
    localHashMap.put("screenWidth", Integer.valueOf(this.mScreenWidth));
    localHashMap.put("screenHeight", Integer.valueOf(this.mScreenHeight));
    localHashMap.put("viewportWidth", Integer.valueOf(this.mViewportWidth));
    localHashMap.put("viewportHeight", Integer.valueOf(this.mViewportHeight));
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */