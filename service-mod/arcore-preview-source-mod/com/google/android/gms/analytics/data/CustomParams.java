package com.google.android.gms.analytics.data;

import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CustomParams
  extends zzf<CustomParams>
{
  private final Map<String, Object> zzFE = new HashMap();
  
  private String zzbn(String paramString)
  {
    zzac.zzdc(paramString);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("&")) {
        str = paramString.substring(1);
      }
    }
    zzac.zzi(str, "Name can not be empty or \"&\"");
    return str;
  }
  
  public Object get(String paramString)
  {
    paramString = zzbn(paramString);
    return this.zzFE.get(paramString);
  }
  
  public void mergeTo(CustomParams paramCustomParams)
  {
    zzac.zzC(paramCustomParams);
    paramCustomParams.zzFE.putAll(this.zzFE);
  }
  
  public Map<String, Object> params()
  {
    return Collections.unmodifiableMap(this.zzFE);
  }
  
  public void remove(String paramString)
  {
    paramString = zzbn(paramString);
    this.zzFE.remove(paramString);
  }
  
  public void set(String paramString, double paramDouble)
  {
    paramString = zzbn(paramString);
    this.zzFE.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void set(String paramString, long paramLong)
  {
    paramString = zzbn(paramString);
    this.zzFE.put(paramString, Long.valueOf(paramLong));
  }
  
  public void set(String paramString1, String paramString2)
  {
    paramString1 = zzbn(paramString1);
    this.zzFE.put(paramString1, paramString2);
  }
  
  public void set(String paramString, boolean paramBoolean)
  {
    paramString = zzbn(paramString);
    this.zzFE.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public String toString()
  {
    return zzk(this.zzFE);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/CustomParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */