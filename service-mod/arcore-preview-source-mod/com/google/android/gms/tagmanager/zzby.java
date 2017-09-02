package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzby
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdB.toString();
  private static final String zzcvB = zzai.zzie.toString();
  private static final String zzcvC = zzai.zzic.toString();
  
  public zzby()
  {
    super(ID, new String[0]);
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzcvB);
    paramMap = (zzak.zza)paramMap.get(zzcvC);
    double d2;
    double d1;
    if ((localObject != null) && (localObject != zzcw.zzYL()) && (paramMap != null) && (paramMap != zzcw.zzYL()))
    {
      localObject = zzcw.zzf((zzak.zza)localObject);
      paramMap = zzcw.zzf(paramMap);
      if ((localObject != zzcw.zzYJ()) && (paramMap != zzcw.zzYJ()))
      {
        d2 = ((zzcv)localObject).doubleValue();
        d1 = paramMap.doubleValue();
        if (d2 > d1) {}
      }
    }
    for (;;)
    {
      return zzcw.zzab(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
      d1 = 2.147483647E9D;
      d2 = 0.0D;
    }
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */