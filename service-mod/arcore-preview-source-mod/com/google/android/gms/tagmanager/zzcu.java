package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcu
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdH.toString();
  
  public zzcu()
  {
    super(ID, new String[0]);
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    return zzcw.zzab(Long.valueOf(System.currentTimeMillis()));
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */