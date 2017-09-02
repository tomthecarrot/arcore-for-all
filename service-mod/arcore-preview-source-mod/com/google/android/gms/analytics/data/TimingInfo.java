package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class TimingInfo
  extends zzf<TimingInfo>
{
  public String mCategory;
  public String mLabel;
  public long mTimeInMillis;
  public String mVariableName;
  
  public String getCategory()
  {
    return this.mCategory;
  }
  
  public String getLabel()
  {
    return this.mLabel;
  }
  
  public long getTimeInMillis()
  {
    return this.mTimeInMillis;
  }
  
  public String getVariableName()
  {
    return this.mVariableName;
  }
  
  public void mergeTo(TimingInfo paramTimingInfo)
  {
    if (!TextUtils.isEmpty(this.mVariableName)) {
      paramTimingInfo.setVariableName(this.mVariableName);
    }
    if (this.mTimeInMillis != 0L) {
      paramTimingInfo.setTimeInMillis(this.mTimeInMillis);
    }
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramTimingInfo.setCategory(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.mLabel)) {
      paramTimingInfo.setLabel(this.mLabel);
    }
  }
  
  public void setCategory(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.mLabel = paramString;
  }
  
  public void setTime(long paramLong, TimeUnit paramTimeUnit)
  {
    zzac.zzC(paramTimeUnit);
    switch (1.zzadf[paramTimeUnit.ordinal()])
    {
    default: 
      this.mTimeInMillis = paramTimeUnit.toMillis(paramLong);
      return;
    case 1: 
      if (paramLong > 0L) {}
      for (l = 500L;; l = -500L)
      {
        paramLong += l;
        break;
      }
    }
    if (paramLong > 0L) {}
    for (long l = 500000L;; l = -500000L)
    {
      paramLong += l;
      break;
    }
  }
  
  public void setTimeInMillis(long paramLong)
  {
    this.mTimeInMillis = paramLong;
  }
  
  public void setVariableName(String paramString)
  {
    this.mVariableName = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", this.mVariableName);
    localHashMap.put("timeInMillis", Long.valueOf(this.mTimeInMillis));
    localHashMap.put("category", this.mCategory);
    localHashMap.put("label", this.mLabel);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/TimingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */