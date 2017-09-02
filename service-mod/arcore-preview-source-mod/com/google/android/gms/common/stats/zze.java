package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzj;
import java.util.Arrays;
import java.util.List;

public class zze
{
  private static zze zzaUC = new zze();
  private static Boolean zzaUD;
  
  public static zze zzAH()
  {
    return zzaUC;
  }
  
  private static boolean zzbf(Context paramContext)
  {
    if (zzaUD == null) {
      zzaUD = Boolean.valueOf(false);
    }
    return zzaUD.booleanValue();
  }
  
  public void zza(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    zza(paramContext, paramIntent, paramString1, paramString2, paramString3, paramInt, Arrays.asList(new String[] { paramString4 }));
  }
  
  public void zza(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList)
  {
    zza(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 7, paramString1, paramString2, paramString3, paramInt, paramList);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzbf(paramContext)) {}
    long l;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        paramContext = String.valueOf(paramString1);
        if (paramContext.length() != 0) {}
        for (paramContext = "missing wakeLock key. ".concat(paramContext);; paramContext = new String("missing wakeLock key. "))
        {
          Log.e("WakeLockTracker", paramContext);
          return;
        }
      }
      l = System.currentTimeMillis();
    } while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, zzc.zzH(paramList), paramString1, SystemClock.elapsedRealtime(), zzj.zzbk(paramContext), paramString3, zzc.zzde(paramContext.getPackageName()), zzj.zzbl(paramContext), paramLong, paramString4);
    try
    {
      paramContext.startService(new Intent().setComponent(zzb.zzaUh).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (Exception paramContext)
    {
      Log.wtf("WakeLockTracker", paramContext);
    }
  }
  
  public void zze(Context paramContext, Intent paramIntent)
  {
    zza(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, null, 0, null);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/stats/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */