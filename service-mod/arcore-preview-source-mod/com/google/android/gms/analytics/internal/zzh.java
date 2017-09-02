package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private final Map<String, String> zzFE;
  private final String zzacQ;
  private final long zzadQ;
  private final String zzadR;
  private final boolean zzadS;
  private long zzadT;
  
  public zzh(long paramLong1, String paramString1, String paramString2, boolean paramBoolean, long paramLong2, Map<String, String> paramMap)
  {
    zzac.zzdc(paramString1);
    zzac.zzdc(paramString2);
    this.zzadQ = paramLong1;
    this.zzacQ = paramString1;
    this.zzadR = paramString2;
    this.zzadS = paramBoolean;
    this.zzadT = paramLong2;
    if (paramMap != null)
    {
      this.zzFE = new HashMap(paramMap);
      return;
    }
    this.zzFE = Collections.emptyMap();
  }
  
  public String getClientId()
  {
    return this.zzacQ;
  }
  
  public Map<String, String> zzfN()
  {
    return this.zzFE;
  }
  
  public long zznI()
  {
    return this.zzadQ;
  }
  
  public String zznJ()
  {
    return this.zzadR;
  }
  
  public boolean zznK()
  {
    return this.zzadS;
  }
  
  public long zznL()
  {
    return this.zzadT;
  }
  
  public void zzw(long paramLong)
  {
    this.zzadT = paramLong;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */