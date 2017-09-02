package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public final class zzj
{
  private static IntentFilter zzaUQ = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static long zzaUR;
  private static float zzaUS = NaN.0F;
  
  @TargetApi(20)
  public static boolean zzb(PowerManager paramPowerManager)
  {
    if (zzt.zzAX()) {
      return paramPowerManager.isInteractive();
    }
    return paramPowerManager.isScreenOn();
  }
  
  @TargetApi(20)
  public static int zzbk(Context paramContext)
  {
    int k = 1;
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      return -1;
    }
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, zzaUQ);
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext != null) {
        break label77;
      }
      return -1;
      i = localIntent.getIntExtra("plugged", 0);
      break;
    }
    label77:
    int j;
    if (zzb(paramContext))
    {
      j = 1;
      if (i == 0) {
        break label103;
      }
    }
    label103:
    for (i = k;; i = 0)
    {
      return j << 1 | i;
      j = 0;
      break;
    }
  }
  
  /* Error */
  public static float zzbl(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
    //   6: getstatic 84	com/google/android/gms/common/util/zzj:zzaUR	J
    //   9: lsub
    //   10: ldc2_w 85
    //   13: lcmp
    //   14: ifge +21 -> 35
    //   17: getstatic 25	com/google/android/gms/common/util/zzj:zzaUS	F
    //   20: invokestatic 92	java/lang/Float:isNaN	(F)Z
    //   23: ifne +12 -> 35
    //   26: getstatic 25	com/google/android/gms/common/util/zzj:zzaUS	F
    //   29: fstore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: fload_1
    //   34: freturn
    //   35: aload_0
    //   36: invokevirtual 54	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   39: aconst_null
    //   40: getstatic 22	com/google/android/gms/common/util/zzj:zzaUQ	Landroid/content/IntentFilter;
    //   43: invokevirtual 58	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +27 -> 75
    //   51: aload_0
    //   52: ldc 94
    //   54: iconst_m1
    //   55: invokevirtual 72	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: aload_0
    //   60: ldc 96
    //   62: iconst_m1
    //   63: invokevirtual 72	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   66: istore_3
    //   67: iload_2
    //   68: i2f
    //   69: iload_3
    //   70: i2f
    //   71: fdiv
    //   72: putstatic 25	com/google/android/gms/common/util/zzj:zzaUS	F
    //   75: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
    //   78: putstatic 84	com/google/android/gms/common/util/zzj:zzaUR	J
    //   81: getstatic 25	com/google/android/gms/common/util/zzj:zzaUS	F
    //   84: fstore_1
    //   85: goto -55 -> 30
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   29	56	1	f	float
    //   58	10	2	i	int
    //   66	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   3	30	88	finally
    //   35	47	88	finally
    //   51	75	88	finally
    //   75	85	88	finally
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */