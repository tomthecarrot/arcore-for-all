package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcx
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdU.toString();
  private static final String zzcuu = zzai.zzfH.toString();
  
  public zzcx()
  {
    super(ID, new String[] { zzcuu });
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    return zzcw.zzab(zzcw.zze((zzak.zza)paramMap.get(zzcuu)).toUpperCase());
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */