package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzab
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdL.toString();
  private static final String zzcuu = zzai.zzfH.toString();
  private static final String zzcuv = zzai.zzin.toString();
  private static final String zzcuw = zzai.zzhG.toString();
  private static final String zzcux = zzai.zzix.toString();
  
  public zzab()
  {
    super(ID, new String[] { zzcuu });
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzcuu);
    if ((localObject == null) || (localObject == zzcw.zzYL())) {
      return zzcw.zzYL();
    }
    String str2 = zzcw.zze((zzak.zza)localObject);
    localObject = (zzak.zza)paramMap.get(zzcuw);
    String str1;
    label84:
    int i;
    if (localObject == null)
    {
      str1 = "text";
      localObject = (zzak.zza)paramMap.get(zzcux);
      if (localObject != null) {
        break label165;
      }
      localObject = "base16";
      int j = 2;
      paramMap = (zzak.zza)paramMap.get(zzcuv);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (zzcw.zzi(paramMap).booleanValue()) {
          i = 3;
        }
      }
    }
    for (;;)
    {
      try
      {
        if ("text".equals(str1))
        {
          paramMap = str2.getBytes();
          if (!"base16".equals(localObject)) {
            break label288;
          }
          paramMap = Base16.encode(paramMap);
          return zzcw.zzab(paramMap);
          str1 = zzcw.zze((zzak.zza)localObject);
          break;
          label165:
          localObject = zzcw.zze((zzak.zza)localObject);
          break label84;
        }
        if ("base16".equals(str1))
        {
          paramMap = Base16.decode(str2);
          continue;
        }
        if ("base64".equals(str1))
        {
          paramMap = Base64.decode(str2, i);
          continue;
        }
        if ("base64url".equals(str1))
        {
          paramMap = Base64.decode(str2, i | 0x8);
          continue;
        }
        paramMap = String.valueOf(str1);
        if (paramMap.length() != 0)
        {
          paramMap = "Encode: unknown input format: ".concat(paramMap);
          Log.e(paramMap);
          return zzcw.zzYL();
        }
        paramMap = new String("Encode: unknown input format: ");
        continue;
        if (!"base64".equals(localObject)) {
          break label307;
        }
      }
      catch (IllegalArgumentException paramMap)
      {
        Log.e("Encode: invalid input:");
        return zzcw.zzYL();
      }
      label288:
      paramMap = Base64.encodeToString(paramMap, i);
      continue;
      label307:
      if (!"base64url".equals(localObject)) {
        break label329;
      }
      paramMap = Base64.encodeToString(paramMap, i | 0x8);
    }
    label329:
    paramMap = String.valueOf(localObject);
    if (paramMap.length() != 0) {}
    for (paramMap = "Encode: unknown output format: ".concat(paramMap);; paramMap = new String("Encode: unknown output format: "))
    {
      Log.e(paramMap);
      return zzcw.zzYL();
    }
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */