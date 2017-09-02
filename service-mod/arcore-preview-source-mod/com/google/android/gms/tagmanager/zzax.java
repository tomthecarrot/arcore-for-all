package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzax
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdO.toString();
  private static final String zzcsY = zzai.zzgk.toString();
  private final Context zzqm;
  
  public zzax(Context paramContext)
  {
    super(ID, new String[0]);
    this.zzqm = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    if ((zzak.zza)paramMap.get(zzcsY) != null) {}
    for (paramMap = zzcw.zze((zzak.zza)paramMap.get(zzcsY));; paramMap = null)
    {
      paramMap = InstallReferrerUtil.getInstallReferrer(this.zzqm, paramMap);
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */