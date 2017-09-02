package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zze
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdJ.toString();
  private static final String zzcsY = zzai.zzgk.toString();
  private static final String zzcsZ = zzai.zzgn.toString();
  private final Context zzqm;
  
  public zze(Context paramContext)
  {
    super(ID, new String[] { zzcsZ });
    this.zzqm = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzcsZ);
    if (localObject == null) {
      return zzcw.zzYL();
    }
    localObject = zzcw.zze((zzak.zza)localObject);
    paramMap = (zzak.zza)paramMap.get(zzcsY);
    if (paramMap != null) {}
    for (paramMap = zzcw.zze(paramMap);; paramMap = null)
    {
      paramMap = InstallReferrerUtil.getClickReferrer(this.zzqm, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzcw.zzab(paramMap);
    }
    return zzcw.zzYL();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */