package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzaf
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdt.toString();
  private final zzcl zzcth;
  
  public zzaf(zzcl paramzzcl)
  {
    super(ID, new String[0]);
    this.zzcth = paramzzcl;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    paramMap = this.zzcth.zzYi();
    if (paramMap == null) {
      return zzcw.zzYL();
    }
    return zzcw.zzab(paramMap);
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */