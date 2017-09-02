package com.google.android.gms.analytics.data;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ScreenViewInfo
  extends zzf<ScreenViewInfo>
{
  private String zzacX;
  private int zzacY;
  private int zzacZ;
  private String zzada;
  private String zzadb;
  private boolean zzadc;
  private boolean zzadd;
  private boolean zzade;
  
  public ScreenViewInfo()
  {
    this(false);
  }
  
  public ScreenViewInfo(boolean paramBoolean)
  {
    this(paramBoolean, zznd());
  }
  
  public ScreenViewInfo(boolean paramBoolean, int paramInt)
  {
    zzac.zzgb(paramInt);
    this.zzacY = paramInt;
    this.zzadd = paramBoolean;
  }
  
  static int zznd()
  {
    UUID localUUID = UUID.randomUUID();
    int i = (int)(localUUID.getLeastSignificantBits() & 0x7FFFFFFF);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = (int)(localUUID.getMostSignificantBits() & 0x7FFFFFFF);
      i = j;
    } while (j != 0);
    Log.e("GAv4", "UUID.randomUUID() returned 0.");
    return Integer.MAX_VALUE;
  }
  
  private void zzne()
  {
    if (this.zzade) {
      throw new IllegalStateException("ScreenViewInfo is immutable");
    }
  }
  
  public int getReferrerScreenId()
  {
    return this.zzacZ;
  }
  
  public String getReferrerScreenName()
  {
    return this.zzada;
  }
  
  public String getReferrerUri()
  {
    return this.zzadb;
  }
  
  public int getScreenId()
  {
    return this.zzacY;
  }
  
  public String getScreenName()
  {
    return this.zzacX;
  }
  
  public boolean isAutomatic()
  {
    return this.zzadd;
  }
  
  public boolean isInterstitial()
  {
    return this.zzadc;
  }
  
  public boolean isMutable()
  {
    return !this.zzade;
  }
  
  public void makeImmutable()
  {
    this.zzade = true;
  }
  
  public void mergeTo(ScreenViewInfo paramScreenViewInfo)
  {
    if (!TextUtils.isEmpty(this.zzacX)) {
      paramScreenViewInfo.setScreenName(this.zzacX);
    }
    if (this.zzacY != 0) {
      paramScreenViewInfo.setScreenId(this.zzacY);
    }
    if (this.zzacZ != 0) {
      paramScreenViewInfo.setReferrerScreenId(this.zzacZ);
    }
    if (!TextUtils.isEmpty(this.zzada)) {
      paramScreenViewInfo.setReferrerScreenName(this.zzada);
    }
    if (!TextUtils.isEmpty(this.zzadb)) {
      paramScreenViewInfo.setReferrerUri(this.zzadb);
    }
    if (this.zzadc) {
      paramScreenViewInfo.setInterstitial(this.zzadc);
    }
    if (this.zzadd) {
      paramScreenViewInfo.setAutomatic(this.zzadd);
    }
  }
  
  public void setAutomatic(boolean paramBoolean)
  {
    zzne();
    this.zzadd = paramBoolean;
  }
  
  public void setInterstitial(boolean paramBoolean)
  {
    zzne();
    this.zzadc = paramBoolean;
  }
  
  public void setReferrerScreenId(int paramInt)
  {
    zzne();
    this.zzacZ = paramInt;
  }
  
  public void setReferrerScreenName(String paramString)
  {
    zzne();
    this.zzada = paramString;
  }
  
  public void setReferrerUri(String paramString)
  {
    zzne();
    if (TextUtils.isEmpty(paramString))
    {
      this.zzadb = null;
      return;
    }
    this.zzadb = paramString;
  }
  
  public void setScreenId(int paramInt)
  {
    zzne();
    this.zzacY = paramInt;
  }
  
  public void setScreenName(String paramString)
  {
    zzne();
    this.zzacX = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("screenName", this.zzacX);
    localHashMap.put("interstitial", Boolean.valueOf(this.zzadc));
    localHashMap.put("automatic", Boolean.valueOf(this.zzadd));
    localHashMap.put("screenId", Integer.valueOf(this.zzacY));
    localHashMap.put("referrerScreenId", Integer.valueOf(this.zzacZ));
    localHashMap.put("referrerScreenName", this.zzada);
    localHashMap.put("referrerUri", this.zzadb);
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/ScreenViewInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */