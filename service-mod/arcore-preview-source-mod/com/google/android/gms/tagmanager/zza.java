package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import java.io.IOException;

public class zza
{
  private static Object zzcsU = new Object();
  private static zza zzcsV;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread zzWP;
  private volatile AdvertisingIdClient.Info zzadk;
  private volatile long zzcsO = 900000L;
  private volatile long zzcsP = 30000L;
  private volatile long zzcsQ;
  private volatile long zzcsR;
  private final Object zzcsS = new Object();
  private zza zzcsT = new zza()
  {
    public AdvertisingIdClient.Info zzXf()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza.zza(zza.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.w("IllegalStateException getting Advertising Id Info", localIllegalStateException);
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        Log.w("GooglePlayServicesRepairableException getting Advertising Id Info", localGooglePlayServicesRepairableException);
        return null;
      }
      catch (IOException localIOException)
      {
        Log.w("IOException getting Ad Id Info", localIOException);
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        Log.w("GooglePlayServicesNotAvailableException getting Advertising Id Info", localGooglePlayServicesNotAvailableException);
        return null;
      }
      catch (Exception localException)
      {
        Log.w("Unknown exception. Could not get the Advertising Id Info.", localException);
      }
      return null;
    }
  };
  private final Clock zzvi;
  
  private zza(Context paramContext)
  {
    this(paramContext, null, zzh.zzAM());
  }
  
  public zza(Context paramContext, zza paramzza, Clock paramClock)
  {
    this.zzvi = paramClock;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (paramzza != null) {
        this.zzcsT = paramzza;
      }
      this.zzcsQ = this.zzvi.currentTimeMillis();
      this.zzWP = new Thread(new Runnable()
      {
        public void run()
        {
          zza.zzb(zza.this);
        }
      });
      return;
    }
  }
  
  /* Error */
  private void zzXb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 100	com/google/android/gms/tagmanager/zza:zzXc	()V
    //   6: aload_0
    //   7: ldc2_w 101
    //   10: invokevirtual 106	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: goto -9 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	zza
    //   16	4	1	localObject	Object
    //   21	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   13	15	16	finally
    //   17	19	16	finally
    //   2	13	21	java/lang/InterruptedException
  }
  
  private void zzXc()
  {
    if (this.zzvi.currentTimeMillis() - this.zzcsQ > this.zzcsP) {}
    synchronized (this.zzcsS)
    {
      this.zzcsS.notify();
      this.zzcsQ = this.zzvi.currentTimeMillis();
      return;
    }
  }
  
  private void zzXd()
  {
    if (this.zzvi.currentTimeMillis() - this.zzcsR > 3600000L) {
      this.zzadk = null;
    }
  }
  
  /* Error */
  private void zzXe()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 123	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 61	com/google/android/gms/tagmanager/zza:mClosed	Z
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 68	com/google/android/gms/tagmanager/zza:zzcsT	Lcom/google/android/gms/tagmanager/zza$zza;
    //   14: invokeinterface 127 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +26 -> 47
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 116	com/google/android/gms/tagmanager/zza:zzadk	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 70	com/google/android/gms/tagmanager/zza:zzvi	Lcom/google/android/gms/common/util/Clock;
    //   34: invokeinterface 84 1 0
    //   39: putfield 112	com/google/android/gms/tagmanager/zza:zzcsR	J
    //   42: ldc -127
    //   44: invokestatic 135	com/google/android/gms/tagmanager/Log:i	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 63	com/google/android/gms/tagmanager/zza:zzcsS	Ljava/lang/Object;
    //   59: astore_2
    //   60: aload_2
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 63	com/google/android/gms/tagmanager/zza:zzcsS	Ljava/lang/Object;
    //   66: aload_0
    //   67: getfield 55	com/google/android/gms/tagmanager/zza:zzcsO	J
    //   70: invokevirtual 106	java/lang/Object:wait	(J)V
    //   73: aload_2
    //   74: monitorexit
    //   75: goto -70 -> 5
    //   78: astore_3
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    //   83: astore_2
    //   84: ldc -116
    //   86: invokestatic 135	com/google/android/gms/tagmanager/Log:i	(Ljava/lang/String;)V
    //   89: goto -84 -> 5
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	zza
    //   9	1	1	bool	boolean
    //   83	1	2	localInterruptedException	InterruptedException
    //   92	4	2	localObject2	Object
    //   78	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	75	78	finally
    //   79	81	78	finally
    //   55	62	83	java/lang/InterruptedException
    //   81	83	83	java/lang/InterruptedException
    //   49	55	92	finally
    //   93	95	92	finally
  }
  
  public static zza zzcb(Context paramContext)
  {
    if (zzcsV == null) {}
    synchronized (zzcsU)
    {
      if (zzcsV == null)
      {
        zzcsV = new zza(paramContext);
        zzcsV.start();
      }
      return zzcsV;
    }
  }
  
  public String getAdvertiserId()
  {
    if (this.zzadk == null) {
      zzXb();
    }
    for (;;)
    {
      zzXd();
      if (this.zzadk != null) {
        break;
      }
      return null;
      zzXc();
    }
    return this.zzadk.getId();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    if (this.zzadk == null) {
      zzXb();
    }
    for (;;)
    {
      zzXd();
      if (this.zzadk != null) {
        break;
      }
      return true;
      zzXc();
    }
    return this.zzadk.isLimitAdTrackingEnabled();
  }
  
  public void start()
  {
    this.zzWP.start();
  }
  
  public static abstract interface zza
  {
    public abstract AdvertisingIdClient.Info zzXf();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */