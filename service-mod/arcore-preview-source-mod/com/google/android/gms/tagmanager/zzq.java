package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzq
  extends StringPredicate
{
  private static final String ID = zzah.zzeo.toString();
  
  public zzq()
  {
    super(ID);
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, zzak.zza> paramMap)
  {
    return paramString1.contains(paramString2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */