package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzac
  extends StringPredicate
{
  private static final String ID = zzah.zzen.toString();
  
  public zzac()
  {
    super(ID);
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, zzak.zza> paramMap)
  {
    return paramString1.endsWith(paramString2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */