package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;

public final class HitParams
  extends zzf<HitParams>
{
  private String zzacP;
  private String zzacQ;
  private String zzacR;
  private String zzacS;
  private boolean zzacT;
  private String zzacU;
  private boolean zzacV;
  private double zzacW;
  
  public String getAndroidAdId()
  {
    return this.zzacS;
  }
  
  public String getClientId()
  {
    return this.zzacQ;
  }
  
  public String getHitType()
  {
    return this.zzacP;
  }
  
  public double getSampleRate()
  {
    return this.zzacW;
  }
  
  public String getSessionControl()
  {
    return this.zzacU;
  }
  
  public String getUserId()
  {
    return this.zzacR;
  }
  
  public boolean isAdTargetingEnabled()
  {
    return this.zzacT;
  }
  
  public boolean isNonInteraction()
  {
    return this.zzacV;
  }
  
  public void mergeTo(HitParams paramHitParams)
  {
    if (!TextUtils.isEmpty(this.zzacP)) {
      paramHitParams.setHitType(this.zzacP);
    }
    if (!TextUtils.isEmpty(this.zzacQ)) {
      paramHitParams.setClientId(this.zzacQ);
    }
    if (!TextUtils.isEmpty(this.zzacR)) {
      paramHitParams.setUserId(this.zzacR);
    }
    if (!TextUtils.isEmpty(this.zzacS)) {
      paramHitParams.setAndroidAdId(this.zzacS);
    }
    if (this.zzacT) {
      paramHitParams.setAdTargetingEnabled(true);
    }
    if (!TextUtils.isEmpty(this.zzacU)) {
      paramHitParams.setSessionControl(this.zzacU);
    }
    if (this.zzacV) {
      paramHitParams.setNonInteraction(this.zzacV);
    }
    if (this.zzacW != 0.0D) {
      paramHitParams.setSampleRate(this.zzacW);
    }
  }
  
  public void setAdTargetingEnabled(boolean paramBoolean)
  {
    this.zzacT = paramBoolean;
  }
  
  public void setAndroidAdId(String paramString)
  {
    this.zzacS = paramString;
  }
  
  public void setClientId(String paramString)
  {
    this.zzacQ = paramString;
  }
  
  public void setHitType(String paramString)
  {
    this.zzacP = paramString;
  }
  
  public void setNonInteraction(boolean paramBoolean)
  {
    this.zzacV = paramBoolean;
  }
  
  public void setSampleRate(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 100.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Sample rate must be between 0% and 100%");
      this.zzacW = paramDouble;
      return;
    }
  }
  
  public void setSessionControl(String paramString)
  {
    this.zzacU = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.zzacR = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", this.zzacP);
    localHashMap.put("clientId", this.zzacQ);
    localHashMap.put("userId", this.zzacR);
    localHashMap.put("androidAdId", this.zzacS);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzacT));
    localHashMap.put("sessionControl", this.zzacU);
    localHashMap.put("nonInteraction", Boolean.valueOf(this.zzacV));
    localHashMap.put("sampleRate", Double.valueOf(this.zzacW));
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/HitParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */