package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zzan
  implements zzq
{
  public String zzabd;
  public double zzafH = -1.0D;
  public int zzafI = -1;
  public int zzafJ = -1;
  public int zzafK = -1;
  public int zzafL = -1;
  public Map<String, String> zzafM = new HashMap();
  
  public int getSessionTimeout()
  {
    return this.zzafI;
  }
  
  public String getTrackingId()
  {
    return this.zzabd;
  }
  
  public String zzbF(String paramString)
  {
    String str = (String)this.zzafM.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean zzpP()
  {
    return this.zzabd != null;
  }
  
  public boolean zzpQ()
  {
    return this.zzafH >= 0.0D;
  }
  
  public double zzpR()
  {
    return this.zzafH;
  }
  
  public boolean zzpS()
  {
    return this.zzafI >= 0;
  }
  
  public boolean zzpT()
  {
    return this.zzafJ != -1;
  }
  
  public boolean zzpU()
  {
    return this.zzafJ == 1;
  }
  
  public boolean zzpV()
  {
    return this.zzafK != -1;
  }
  
  public boolean zzpW()
  {
    return this.zzafK == 1;
  }
  
  public boolean zzpX()
  {
    return this.zzafL == 1;
  }
  
  public String zzr(Activity paramActivity)
  {
    return zzbF(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */