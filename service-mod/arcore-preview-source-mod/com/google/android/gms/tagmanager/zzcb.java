package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcb
  extends StringPredicate
{
  private static final String ID = zzah.zzel.toString();
  private static final String zzcvF = zzai.zzhE.toString();
  
  public zzcb()
  {
    super(ID);
  }
  
  protected boolean evaluateString(String paramString1, String paramString2, Map<String, zzak.zza> paramMap)
  {
    if (zzcw.zzi((zzak.zza)paramMap.get(zzcvF)).booleanValue()) {}
    for (int i = 66;; i = 64) {
      try
      {
        boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
        return bool;
      }
      catch (PatternSyntaxException paramString1)
      {
        return false;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */