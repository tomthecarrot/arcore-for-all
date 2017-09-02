package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class StringPredicate
  extends Predicate
{
  public StringPredicate(String paramString)
  {
    super(paramString);
  }
  
  protected boolean evaluateNoDefaultValues(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap)
  {
    paramzza1 = zzcw.zze(paramzza1);
    paramzza2 = zzcw.zze(paramzza2);
    if ((paramzza1 == zzcw.zzYK()) || (paramzza2 == zzcw.zzYK())) {
      return false;
    }
    return evaluateString(paramzza1, paramzza2, paramMap);
  }
  
  protected abstract boolean evaluateString(String paramString1, String paramString2, Map<String, zzak.zza> paramMap);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/StringPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */