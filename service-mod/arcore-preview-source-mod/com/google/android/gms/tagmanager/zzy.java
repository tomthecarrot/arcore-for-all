package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzy
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdn.toString();
  
  public zzy()
  {
    super(ID, new String[0]);
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    paramMap = str1;
    if (!str1.startsWith(str2))
    {
      paramMap = str1;
      if (!str2.equals("unknown")) {
        paramMap = String.valueOf(str2).length() + 1 + String.valueOf(str1).length() + str2 + " " + str1;
      }
    }
    return zzcw.zzab(paramMap);
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */