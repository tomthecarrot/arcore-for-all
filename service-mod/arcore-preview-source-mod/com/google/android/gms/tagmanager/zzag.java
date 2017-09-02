package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zzc;
import com.google.android.gms.internal.zzaj.zzd;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzag
{
  private static void zza(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    paramzzd = paramzzd.zzkz;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      paramDataLayer.zzjH(zzcw.zze(paramzzd[i]));
      i += 1;
    }
  }
  
  public static void zza(DataLayer paramDataLayer, zzaj.zzi paramzzi)
  {
    if (paramzzi.zzlo == null)
    {
      Log.w("supplemental missing experimentSupplemental");
      return;
    }
    zza(paramDataLayer, paramzzi.zzlo);
    zzb(paramDataLayer, paramzzi.zzlo);
    zzc(paramDataLayer, paramzzi.zzlo);
  }
  
  private static void zzb(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    paramzzd = paramzzd.zzky;
    int j = paramzzd.length;
    int i = 0;
    while (i < j)
    {
      Map localMap = zzc(paramzzd[i]);
      if (localMap != null) {
        paramDataLayer.push(localMap);
      }
      i += 1;
    }
  }
  
  private static Map<String, Object> zzc(zzak.zza paramzza)
  {
    paramzza = zzcw.zzj(paramzza);
    if (!(paramzza instanceof Map))
    {
      paramzza = String.valueOf(paramzza);
      Log.w(String.valueOf(paramzza).length() + 36 + "value: " + paramzza + " is not a map value, ignored.");
      return null;
    }
    return (Map)paramzza;
  }
  
  private static void zzc(DataLayer paramDataLayer, zzaj.zzd paramzzd)
  {
    zzaj.zzc[] arrayOfzzc = paramzzd.zzkA;
    int j = arrayOfzzc.length;
    int i = 0;
    while (i < j)
    {
      zzaj.zzc localzzc = arrayOfzzc[i];
      if (localzzc.zzaA == null)
      {
        Log.w("GaExperimentRandom: No key");
        i += 1;
      }
      else
      {
        Object localObject = paramDataLayer.get(localzzc.zzaA);
        if (!(localObject instanceof Number))
        {
          paramzzd = null;
          label64:
          long l1 = localzzc.zzku;
          long l2 = localzzc.zzkv;
          if ((!localzzc.zzkw) || (paramzzd == null) || (paramzzd.longValue() < l1) || (paramzzd.longValue() > l2))
          {
            if (l1 > l2) {
              break label237;
            }
            localObject = Long.valueOf(Math.round(Math.random() * (l2 - l1) + l1));
          }
          paramDataLayer.zzjH(localzzc.zzaA);
          paramzzd = paramDataLayer.zzr(localzzc.zzaA, localObject);
          if (localzzc.zzkx > 0L)
          {
            if (paramzzd.containsKey("gtm")) {
              break label245;
            }
            paramzzd.put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(localzzc.zzkx) }));
          }
        }
        for (;;)
        {
          paramDataLayer.push(paramzzd);
          break;
          paramzzd = Long.valueOf(((Number)localObject).longValue());
          break label64;
          label237:
          Log.w("GaExperimentRandom: random range invalid");
          break;
          label245:
          localObject = paramzzd.get("gtm");
          if ((localObject instanceof Map)) {
            ((Map)localObject).put("lifetime", Long.valueOf(localzzc.zzkx));
          } else {
            Log.w("GaExperimentRandom: gtm not a map");
          }
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */