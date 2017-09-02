package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzcn
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdF.toString();
  
  public zzcn()
  {
    super(ID, new String[0]);
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    return zzcw.zzab(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */