package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzcz
{
  private static zzbt<zzak.zza> zza(zzbt<zzak.zza> paramzzbt)
  {
    try
    {
      zzbt localzzbt = new zzbt(zzcw.zzab(zzkh(zzcw.zze((zzak.zza)paramzzbt.getObject()))), paramzzbt.zzXT());
      return localzzbt;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return paramzzbt;
  }
  
  private static zzbt<zzak.zza> zza(zzbt<zzak.zza> paramzzbt, int paramInt)
  {
    if (!zzl((zzak.zza)paramzzbt.getObject()))
    {
      Log.e("Escaping can only be applied to strings.");
      return paramzzbt;
    }
    switch (paramInt)
    {
    default: 
      Log.e(39 + "Unsupported Value Escaping: " + paramInt);
      return paramzzbt;
    }
    return zza(paramzzbt);
  }
  
  static zzbt<zzak.zza> zza(zzbt<zzak.zza> paramzzbt, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramzzbt = zza(paramzzbt, paramVarArgs[i]);
      i += 1;
    }
    return paramzzbt;
  }
  
  static String zzkh(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean zzl(zzak.zza paramzza)
  {
    return zzcw.zzj(paramzza) instanceof String;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */