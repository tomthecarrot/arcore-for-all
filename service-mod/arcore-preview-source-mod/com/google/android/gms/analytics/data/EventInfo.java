package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class EventInfo
  extends zzf<EventInfo>
{
  private String mAction;
  private String mCategory;
  private String mLabel;
  private long zzacO;
  
  public String getAction()
  {
    return this.mAction;
  }
  
  public String getCategory()
  {
    return this.mCategory;
  }
  
  public String getLabel()
  {
    return this.mLabel;
  }
  
  public long getValue()
  {
    return this.zzacO;
  }
  
  public void mergeTo(EventInfo paramEventInfo)
  {
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramEventInfo.setCategory(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.mAction)) {
      paramEventInfo.setAction(this.mAction);
    }
    if (!TextUtils.isEmpty(this.mLabel)) {
      paramEventInfo.setLabel(this.mLabel);
    }
    if (this.zzacO != 0L) {
      paramEventInfo.setValue(this.zzacO);
    }
  }
  
  public void setAction(String paramString)
  {
    this.mAction = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.mLabel = paramString;
  }
  
  public void setValue(long paramLong)
  {
    this.zzacO = paramLong;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", this.mCategory);
    localHashMap.put("action", this.mAction);
    localHashMap.put("label", this.mLabel);
    localHashMap.put("value", Long.valueOf(this.zzacO));
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/EventInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */