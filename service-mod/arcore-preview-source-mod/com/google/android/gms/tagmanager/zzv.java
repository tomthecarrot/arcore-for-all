package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzv
  extends TrackingTag
{
  private static final String ID = zzah.zzdS.toString();
  private static final String VALUE = zzai.zzkd.toString();
  private static final String zzcui = zzai.zzgf.toString();
  private final DataLayer zzctf;
  
  public zzv(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.zzctf = paramDataLayer;
  }
  
  private void zza(zzak.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzcw.zzYF())) {}
    do
    {
      return;
      paramzza = zzcw.zze(paramzza);
    } while (paramzza == zzcw.zzYK());
    this.zzctf.zzjH(paramzza);
  }
  
  private void zzb(zzak.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzcw.zzYF())) {}
    for (;;)
    {
      return;
      paramzza = zzcw.zzj(paramzza);
      if ((paramzza instanceof List))
      {
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          Object localObject = paramzza.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.zzctf.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void evaluateTrackingTag(Map<String, zzak.zza> paramMap)
  {
    zzb((zzak.zza)paramMap.get(VALUE));
    zza((zzak.zza)paramMap.get(zzcui));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */