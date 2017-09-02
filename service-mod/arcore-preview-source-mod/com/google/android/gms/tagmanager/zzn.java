package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzn
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdi.toString();
  private static final String VALUE = zzai.zzkd.toString();
  
  public zzn()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public static String zzXh()
  {
    return VALUE;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    return (zzak.zza)paramMap.get(VALUE);
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */