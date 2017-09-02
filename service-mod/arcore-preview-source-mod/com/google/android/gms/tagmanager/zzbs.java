package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class zzbs
  extends Predicate
{
  public zzbs(String paramString)
  {
    super(paramString);
  }
  
  protected boolean evaluateNoDefaultValues(zzak.zza paramzza1, zzak.zza paramzza2, Map<String, zzak.zza> paramMap)
  {
    paramzza1 = zzcw.zzf(paramzza1);
    paramzza2 = zzcw.zzf(paramzza2);
    if ((paramzza1 == zzcw.zzYJ()) || (paramzza2 == zzcw.zzYJ())) {
      return false;
    }
    return zza(paramzza1, paramzza2, paramMap);
  }
  
  protected abstract boolean zza(zzcv paramzzcv1, zzcv paramzzcv2, Map<String, zzak.zza> paramMap);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */