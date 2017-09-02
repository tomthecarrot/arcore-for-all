package com.google.android.gms.analytics.data;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class CustomDimensions
  extends zzf<CustomDimensions>
{
  private Map<Integer, String> zzacL = new HashMap(4);
  
  public String getDimension(int paramInt)
  {
    return (String)this.zzacL.get(Integer.valueOf(paramInt));
  }
  
  public Map<Integer, String> getDimensionsSet()
  {
    return Collections.unmodifiableMap(this.zzacL);
  }
  
  public void mergeTo(CustomDimensions paramCustomDimensions)
  {
    paramCustomDimensions.zzacL.putAll(this.zzacL);
  }
  
  public void setDimension(int paramInt, String paramString)
  {
    this.zzacL.put(Integer.valueOf(paramInt), paramString);
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzacL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 9 + "dimension" + str, localEntry.getValue());
    }
    return zzk(localHashMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/data/CustomDimensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */