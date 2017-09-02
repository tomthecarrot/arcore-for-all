package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Locale;
import java.util.Map;

public class LanguageMacro
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdx.toString();
  
  public LanguageMacro()
  {
    super(ID, new String[0]);
  }
  
  public static String getFunctionId()
  {
    return ID;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return zzcw.zzYL();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return zzcw.zzYL();
    }
    return zzcw.zzab(paramMap.toLowerCase());
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/LanguageMacro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */