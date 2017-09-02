package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzt
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdk.toString();
  private static final String NAME = zzai.zzig.toString();
  private static final String zzctY = zzai.zzgL.toString();
  private final DataLayer zzctf;
  
  public zzt(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.zzctf = paramDataLayer;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    Object localObject = this.zzctf.get(zzcw.zze((zzak.zza)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzak.zza)paramMap.get(zzctY);
      if (paramMap != null) {
        return paramMap;
      }
      return zzcw.zzYL();
    }
    return zzcw.zzab(localObject);
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */