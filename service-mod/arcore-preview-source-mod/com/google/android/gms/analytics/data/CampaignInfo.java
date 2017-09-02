package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class CampaignInfo
  extends zzf<CampaignInfo>
{
  private String mName;
  private String zzFK;
  private String zzGK;
  private String zzacE;
  private String zzacF;
  private String zzacG;
  private String zzacH;
  private String zzacI;
  private String zzacJ;
  private String zzacK;
  
  public String getAclid()
  {
    return this.zzacK;
  }
  
  public String getAdNetworkId()
  {
    return this.zzacH;
  }
  
  public String getContent()
  {
    return this.zzFK;
  }
  
  public String getDclid()
  {
    return this.zzacJ;
  }
  
  public String getGclid()
  {
    return this.zzacI;
  }
  
  public String getId()
  {
    return this.zzGK;
  }
  
  public String getKeyword()
  {
    return this.zzacG;
  }
  
  public String getMedium()
  {
    return this.zzacF;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSource()
  {
    return this.zzacE;
  }
  
  public void mergeTo(CampaignInfo paramCampaignInfo)
  {
    if (!TextUtils.isEmpty(this.mName)) {
      paramCampaignInfo.setName(this.mName);
    }
    if (!TextUtils.isEmpty(this.zzacE)) {
      paramCampaignInfo.setSource(this.zzacE);
    }
    if (!TextUtils.isEmpty(this.zzacF)) {
      paramCampaignInfo.setMedium(this.zzacF);
    }
    if (!TextUtils.isEmpty(this.zzacG)) {
      paramCampaignInfo.setKeyword(this.zzacG);
    }
    if (!TextUtils.isEmpty(this.zzFK)) {
      paramCampaignInfo.setContent(this.zzFK);
    }
    if (!TextUtils.isEmpty(this.zzGK)) {
      paramCampaignInfo.setId(this.zzGK);
    }
    if (!TextUtils.isEmpty(this.zzacH)) {
      paramCampaignInfo.setAdNetworkId(this.zzacH);
    }
    if (!TextUtils.isEmpty(this.zzacI)) {
      paramCampaignInfo.setGclid(this.zzacI);
    }
    if (!TextUtils.isEmpty(this.zzacJ)) {
      paramCampaignInfo.setDclid(this.zzacJ);
    }
    if (!TextUtils.isEmpty(this.zzacK)) {
      paramCampaignInfo.setAclid(this.zzacK);
    }
  }
  
  public void setAclid(String paramString)
  {
    this.zzacK = paramString;
  }
  
  public void setAdNetworkId(String paramString)
  {
    this.zzacH = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.zzFK = paramString;
  }
  
  public void setDclid(String paramString)
  {
    this.zzacJ = paramString;
  }
  
  public void setGclid(String paramString)
  {
    this.zzacI = paramString;
  }
  
  public void setId(String paramString)
  {
    this.zzGK = paramString;
  }
  
  public void setKeyword(String paramString)
  {
    this.zzacG = paramString;
  }
  
  public void setMedium(String paramString)
  {
    this.zzacF = paramString;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setSource(String paramString)
  {
    this.zzacE = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", this.mName);
    localHashMap.put("source", this.zzacE);
    localHashMap.put("medium", this.zzacF);
    localHashMap.put("keyword", this.zzacG);
    localHashMap.put("content", this.zzFK);
    localHashMap.put("id", this.zzGK);
    localHashMap.put("adNetworkId", this.zzacH);
    localHashMap.put("gclid", this.zzacI);
    localHashMap.put("dclid", this.zzacJ);
    localHashMap.put("aclid", this.zzacK);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/CampaignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */