package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.util.HashSet;
import java.util.Set;

public class zzs
{
  private final zzf zzaaY;
  private volatile Boolean zzaeI;
  private String zzaeJ;
  private Set<Integer> zzaeK;
  
  protected zzs(zzf paramzzf)
  {
    zzac.zzC(paramzzf);
    this.zzaaY = paramzzf;
  }
  
  public int zzoA()
  {
    return ((Integer)G.maxBatchPostLength.get()).intValue();
  }
  
  public long zzoB()
  {
    return ((Long)G.initialLocalDispatchMillis.get()).longValue();
  }
  
  public long zzoC()
  {
    return ((Long)G.localDispatchIntervalMillis.get()).longValue();
  }
  
  public long zzoD()
  {
    return ((Long)G.dispatchAlarmMillis.get()).longValue();
  }
  
  public long zzoE()
  {
    return ((Long)G.maxDispatchAlarmMillis.get()).longValue();
  }
  
  public int zzoF()
  {
    return ((Integer)G.maxHitsPerDispatch.get()).intValue();
  }
  
  public int zzoG()
  {
    return ((Integer)G.maxHitsPerBatch.get()).intValue();
  }
  
  public long zzoH()
  {
    return ((Integer)G.batchRetryIntervalK.get()).intValue();
  }
  
  public String zzoI()
  {
    return (String)G.secureHost.get();
  }
  
  public String zzoJ()
  {
    return (String)G.insecureHost.get();
  }
  
  public String zzoK()
  {
    return (String)G.simplePath.get();
  }
  
  public String zzoL()
  {
    return (String)G.batchingPath.get();
  }
  
  public zzm zzoM()
  {
    return zzm.zzbA((String)G.batchingStrategyK.get());
  }
  
  public zzp zzoN()
  {
    return zzp.zzbB((String)G.compressionStrategyK.get());
  }
  
  public Set<Integer> zzoO()
  {
    String str1 = (String)G.fallbackResponsesK.get();
    String[] arrayOfString;
    HashSet localHashSet;
    int j;
    int i;
    if ((this.zzaeK == null) || (this.zzaeJ == null) || (!this.zzaeJ.equals(str1)))
    {
      arrayOfString = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = arrayOfString[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        i += 1;
        continue;
        this.zzaeJ = str1;
        this.zzaeK = localHashSet;
        return this.zzaeK;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  public long zzoP()
  {
    return ((Long)G.serviceIdleDisconnectMillis.get()).longValue();
  }
  
  public long zzoQ()
  {
    return ((Long)G.serviceConnectTimeoutMillis.get()).longValue();
  }
  
  public long zzoR()
  {
    return ((Long)G.serviceReconnectThrottleMillis.get()).longValue();
  }
  
  public int zzoS()
  {
    return ((Integer)G.maxStoredHits.get()).intValue();
  }
  
  public int zzoT()
  {
    return ((Integer)G.maxStoredPropertiesPerApp.get()).intValue();
  }
  
  public String zzoU()
  {
    return "google_analytics_v4.db";
  }
  
  public int zzoV()
  {
    return ((Integer)G.httpConnectionConnectTimeoutMillis.get()).intValue();
  }
  
  public int zzoW()
  {
    return ((Integer)G.httpConnectionReadTimeoutMillis.get()).intValue();
  }
  
  public long zzoX()
  {
    return ((Long)G.campaignsTimeLimitMillis.get()).longValue();
  }
  
  public long zzoY()
  {
    return ((Long)G.monitoringSamplePeriodMillis.get()).longValue();
  }
  
  /* Error */
  public boolean zzov()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   4: ifnonnull +119 -> 123
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   13: ifnonnull +108 -> 121
    //   16: aload_0
    //   17: getfield 26	com/google/android/gms/analytics/internal/zzs:zzaaY	Lcom/google/android/gms/analytics/internal/zzf;
    //   20: invokevirtual 211	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   23: invokevirtual 217	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: astore_3
    //   27: invokestatic 222	com/google/android/gms/common/util/zzu:zzBc	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_3
    //   32: ifnull +30 -> 62
    //   35: aload_3
    //   36: getfield 227	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +90 -> 131
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +82 -> 131
    //   52: iconst_1
    //   53: istore_1
    //   54: aload_0
    //   55: iload_1
    //   56: invokestatic 232	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   62: aload_0
    //   63: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   73: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   76: ifne +19 -> 95
    //   79: ldc -19
    //   81: aload_2
    //   82: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +10 -> 95
    //   88: aload_0
    //   89: getstatic 240	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   92: putfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   95: aload_0
    //   96: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   99: ifnonnull +22 -> 121
    //   102: aload_0
    //   103: getstatic 240	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   106: putfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   109: aload_0
    //   110: getfield 26	com/google/android/gms/analytics/internal/zzs:zzaaY	Lcom/google/android/gms/analytics/internal/zzf;
    //   113: invokevirtual 244	com/google/android/gms/analytics/internal/zzf:zznr	()Lcom/google/android/gms/analytics/internal/zzaf;
    //   116: ldc -10
    //   118: invokevirtual 252	com/google/android/gms/analytics/internal/zzaf:zzbv	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_0
    //   124: getfield 205	com/google/android/gms/analytics/internal/zzs:zzaeI	Ljava/lang/Boolean;
    //   127: invokevirtual 235	java/lang/Boolean:booleanValue	()Z
    //   130: ireturn
    //   131: iconst_0
    //   132: istore_1
    //   133: goto -79 -> 54
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	zzs
    //   53	80	1	bool	boolean
    //   30	52	2	str	String
    //   136	4	2	localObject1	Object
    //   26	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	136	finally
    //   35	40	136	finally
    //   44	52	136	finally
    //   54	62	136	finally
    //   62	79	136	finally
    //   79	95	136	finally
    //   95	121	136	finally
    //   121	123	136	finally
    //   137	139	136	finally
  }
  
  public boolean zzow()
  {
    return ((Boolean)G.serviceClientEnabled.get()).booleanValue();
  }
  
  public int zzox()
  {
    return ((Integer)G.maxGetLength.get()).intValue();
  }
  
  public int zzoy()
  {
    return ((Integer)G.maxHitLengthK.get()).intValue();
  }
  
  public int zzoz()
  {
    return ((Integer)G.maxPostLengthK.get()).intValue();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */