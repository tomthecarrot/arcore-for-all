package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzay
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdP.toString();
  private static final String zzcuN = zzai.zzhL.toString();
  private static final String zzcuO = zzai.zzhP.toString();
  private static final String zzcuP = zzai.zzhf.toString();
  private static final String zzcuu = zzai.zzfH.toString();
  
  public zzay()
  {
    super(ID, new String[] { zzcuu });
  }
  
  private String zza(String paramString, zza paramzza, Set<Character> paramSet)
  {
    switch (1.zzcuQ[paramzza.ordinal()])
    {
    default: 
      return paramString;
    case 1: 
      try
      {
        paramzza = zzcz.zzkh(paramString);
        return paramzza;
      }
      catch (UnsupportedEncodingException paramzza)
      {
        Log.e("Joiner: unsupported encoding", paramzza);
        return paramString;
      }
    }
    paramString = paramString.replace("\\", "\\\\");
    paramSet = paramSet.iterator();
    if (paramSet.hasNext())
    {
      String str = ((Character)paramSet.next()).toString();
      paramzza = String.valueOf(str);
      if (paramzza.length() != 0) {}
      for (paramzza = "\\".concat(paramzza);; paramzza = new String("\\"))
      {
        paramString = paramString.replace(str, paramzza);
        break;
      }
    }
    return paramString;
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zza paramzza, Set<Character> paramSet)
  {
    paramStringBuilder.append(zza(paramString, paramzza, paramSet));
  }
  
  private void zza(Set<Character> paramSet, String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    zzak.zza localzza = (zzak.zza)paramMap.get(zzcuu);
    if (localzza == null) {
      return zzcw.zzYL();
    }
    Object localObject1 = (zzak.zza)paramMap.get(zzcuN);
    String str1;
    Object localObject2;
    if (localObject1 != null)
    {
      str1 = zzcw.zze((zzak.zza)localObject1);
      localObject1 = (zzak.zza)paramMap.get(zzcuO);
      if (localObject1 == null) {
        break label186;
      }
      localObject2 = zzcw.zze((zzak.zza)localObject1);
      label75:
      localObject1 = zza.zzcuR;
      paramMap = (zzak.zza)paramMap.get(zzcuP);
      if (paramMap == null) {
        break label432;
      }
      paramMap = zzcw.zze(paramMap);
      if (!"url".equals(paramMap)) {
        break label193;
      }
      localObject1 = zza.zzcuS;
      paramMap = null;
    }
    for (;;)
    {
      label118:
      StringBuilder localStringBuilder = new StringBuilder();
      switch (localzza.type)
      {
      default: 
        zza(localStringBuilder, zzcw.zze(localzza), (zza)localObject1, paramMap);
      }
      for (;;)
      {
        return zzcw.zzab(localStringBuilder.toString());
        str1 = "";
        break;
        label186:
        localObject2 = "=";
        break label75;
        label193:
        if ("backslash".equals(paramMap))
        {
          localObject1 = zza.zzcuT;
          paramMap = new HashSet();
          zza(paramMap, str1);
          zza(paramMap, (String)localObject2);
          paramMap.remove(Character.valueOf('\\'));
          break label118;
        }
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {}
        for (paramMap = "Joiner: unsupported escape type: ".concat(paramMap);; paramMap = new String("Joiner: unsupported escape type: "))
        {
          Log.e(paramMap);
          return zzcw.zzYL();
        }
        int j = 1;
        localObject2 = localzza.zzlt;
        int k = localObject2.length;
        int i = 0;
        while (i < k)
        {
          localzza = localObject2[i];
          if (j == 0) {
            localStringBuilder.append(str1);
          }
          zza(localStringBuilder, zzcw.zze(localzza), (zza)localObject1, paramMap);
          i += 1;
          j = 0;
        }
        i = 0;
        while (i < localzza.zzlu.length)
        {
          if (i > 0) {
            localStringBuilder.append(str1);
          }
          String str2 = zzcw.zze(localzza.zzlu[i]);
          String str3 = zzcw.zze(localzza.zzlv[i]);
          zza(localStringBuilder, str2, (zza)localObject1, paramMap);
          localStringBuilder.append((String)localObject2);
          zza(localStringBuilder, str3, (zza)localObject1, paramMap);
          i += 1;
        }
      }
      label432:
      paramMap = null;
    }
  }
  
  public boolean isCacheable()
  {
    return true;
  }
  
  private static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */