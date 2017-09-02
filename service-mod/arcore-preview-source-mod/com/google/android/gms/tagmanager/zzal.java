package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzal
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdN.toString();
  private static final String zzcuB = zzai.zzfx.toString();
  private static final String zzcuu = zzai.zzfH.toString();
  private static final String zzcuw = zzai.zzhG.toString();
  
  public zzal()
  {
    super(ID, new String[] { zzcuu });
  }
  
  private byte[] zzg(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzcuu);
    if ((localObject == null) || (localObject == zzcw.zzYL())) {
      return zzcw.zzYL();
    }
    String str = zzcw.zze((zzak.zza)localObject);
    localObject = (zzak.zza)paramMap.get(zzcuB);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (zzak.zza)paramMap.get(zzcuw);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = zzcw.zzab(Base16.encode(zzg((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        paramMap = String.valueOf(localObject);
        if (paramMap.length() == 0) {
          break label203;
        }
      }
      localObject = zzcw.zze((zzak.zza)localObject);
      break;
      paramMap = zzcw.zze(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = Base16.decode(str);
      }
      else
      {
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {}
        for (paramMap = "Hash: unknown input format: ".concat(paramMap);; paramMap = new String("Hash: unknown input format: "))
        {
          Log.e(paramMap);
          return zzcw.zzYL();
        }
      }
    }
    label203:
    for (paramMap = "Hash: unknown algorithm: ".concat(paramMap);; paramMap = new String("Hash: unknown algorithm: "))
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */