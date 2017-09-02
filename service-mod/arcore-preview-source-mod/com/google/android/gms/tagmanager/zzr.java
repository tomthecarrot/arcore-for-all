package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzr
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdu.toString();
  private static final String zzctM = zzai.zzhw.toString();
  private static final String zzcta = zzai.zzfu.toString();
  private final zza zzctN;
  
  public zzr(zza paramzza)
  {
    super(ID, new String[] { zzctM });
    this.zzctN = paramzza;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    String str = zzcw.zze((zzak.zza)paramMap.get(zzctM));
    HashMap localHashMap = new HashMap();
    paramMap = (zzak.zza)paramMap.get(zzcta);
    if (paramMap != null)
    {
      paramMap = zzcw.zzj(paramMap);
      if (!(paramMap instanceof Map))
      {
        Log.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return zzcw.zzYL();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = zzcw.zzab(this.zzctN.zze(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      paramMap = String.valueOf(paramMap.getMessage());
      Log.w(String.valueOf(str).length() + 34 + String.valueOf(paramMap).length() + "Custom macro/tag " + str + " threw exception " + paramMap);
    }
    return zzcw.zzYL();
  }
  
  public boolean isCacheable()
  {
    return false;
  }
  
  public static abstract interface zza
  {
    public abstract Object zze(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */