package com.google.android.gms.analytics.data;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class CustomMetrics
  extends zzf<CustomMetrics>
{
  private Map<Integer, Double> zzacM = new HashMap(4);
  
  public double getMetric(int paramInt)
  {
    return ((Double)this.zzacM.get(Integer.valueOf(paramInt))).doubleValue();
  }
  
  public Map<Integer, Double> getMetricsSet()
  {
    return Collections.unmodifiableMap(this.zzacM);
  }
  
  public void mergeTo(CustomMetrics paramCustomMetrics)
  {
    paramCustomMetrics.zzacM.putAll(this.zzacM);
  }
  
  public void setMetric(int paramInt, double paramDouble)
  {
    this.zzacM.put(Integer.valueOf(paramInt), Double.valueOf(paramDouble));
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzacM.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 6 + "metric" + str, localEntry.getValue());
    }
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/CustomMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */