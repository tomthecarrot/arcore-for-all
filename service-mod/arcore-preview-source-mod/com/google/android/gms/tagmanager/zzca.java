package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzca
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdR.toString();
  private static final String zzcvD = zzai.zzfH.toString();
  private static final String zzcvE = zzai.zzfI.toString();
  private static final String zzcvF = zzai.zzhE.toString();
  private static final String zzcvG = zzai.zzhx.toString();
  
  public zzca()
  {
    super(ID, new String[] { zzcvD, zzcvE });
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzcvD);
    zzak.zza localzza = (zzak.zza)paramMap.get(zzcvE);
    if ((localObject == null) || (localObject == zzcw.zzYL()) || (localzza == null) || (localzza == zzcw.zzYL())) {
      return zzcw.zzYL();
    }
    int i = 64;
    if (zzcw.zzi((zzak.zza)paramMap.get(zzcvF)).booleanValue()) {
      i = 66;
    }
    paramMap = (zzak.zza)paramMap.get(zzcvG);
    int j;
    if (paramMap != null)
    {
      paramMap = zzcw.zzg(paramMap);
      if (paramMap == zzcw.zzYG()) {
        return zzcw.zzYL();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return zzcw.zzYL();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = zzcw.zze((zzak.zza)localObject);
      localObject = zzcw.zze(localzza);
      localzza = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = localzza;
      if (((Matcher)localObject).find())
      {
        paramMap = localzza;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return zzcw.zzYL();
      }
      paramMap = zzcw.zzab(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return zzcw.zzYL();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */