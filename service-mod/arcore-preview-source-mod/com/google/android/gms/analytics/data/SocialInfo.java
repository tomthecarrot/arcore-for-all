package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class SocialInfo
  extends zzf<SocialInfo>
{
  public String mAction;
  public String mNetwork;
  public String mTarget;
  
  public String getAction()
  {
    return this.mAction;
  }
  
  public String getNetwork()
  {
    return this.mNetwork;
  }
  
  public String getTarget()
  {
    return this.mTarget;
  }
  
  public void mergeTo(SocialInfo paramSocialInfo)
  {
    if (!TextUtils.isEmpty(this.mNetwork)) {
      paramSocialInfo.setNetwork(this.mNetwork);
    }
    if (!TextUtils.isEmpty(this.mAction)) {
      paramSocialInfo.setAction(this.mAction);
    }
    if (!TextUtils.isEmpty(this.mTarget)) {
      paramSocialInfo.setTarget(this.mTarget);
    }
  }
  
  public void setAction(String paramString)
  {
    this.mAction = paramString;
  }
  
  public void setNetwork(String paramString)
  {
    this.mNetwork = paramString;
  }
  
  public void setTarget(String paramString)
  {
    this.mTarget = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", this.mNetwork);
    localHashMap.put("action", this.mAction);
    localHashMap.put("target", this.mTarget);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/SocialInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */