package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class Predicate
  extends FunctionCallImplementation
{
  private static final String zzcuu = zzai.zzfH.toString();
  private static final String zzcvs = zzai.zzfI.toString();
  
  public Predicate(String paramString)
  {
    super(paramString, new String[] { zzcuu, zzcvs });
  }
  
  public static String getArg0Key()
  {
    return zzcuu;
  }
  
  public static String getArg1Key()
  {
    return zzcvs;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((zzak.zza)((Iterator)localObject).next() == zzcw.zzYL()) {
        return zzcw.zzab(Boolean.valueOf(false));
      }
    }
    localObject = (zzak.zza)paramMap.get(zzcuu);
    zzak.zza localzza = (zzak.zza)paramMap.get(zzcvs);
    if ((localObject == null) || (localzza == null)) {}
    for (boolean bool = false;; bool = evaluateNoDefaultValues((zzak.zza)localObject, localzza, paramMap)) {
      return zzcw.zzab(Boolean.valueOf(bool));
    }
  }
  
  protected abstract boolean evaluateNoDefaultValues(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap);
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */