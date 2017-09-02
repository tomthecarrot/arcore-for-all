package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class ExceptionInfo
  extends zzf<ExceptionInfo>
{
  public String mDescription;
  public boolean mFatal;
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public boolean isFatal()
  {
    return this.mFatal;
  }
  
  public void mergeTo(ExceptionInfo paramExceptionInfo)
  {
    if (!TextUtils.isEmpty(this.mDescription)) {
      paramExceptionInfo.setDescription(this.mDescription);
    }
    if (this.mFatal) {
      paramExceptionInfo.setFatal(this.mFatal);
    }
  }
  
  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setFatal(boolean paramBoolean)
  {
    this.mFatal = paramBoolean;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", this.mDescription);
    localHashMap.put("fatal", Boolean.valueOf(this.mFatal));
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/ExceptionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */