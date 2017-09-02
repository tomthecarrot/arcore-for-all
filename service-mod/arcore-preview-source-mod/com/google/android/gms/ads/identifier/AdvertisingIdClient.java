package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzct.zza;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  com.google.android.gms.common.zza zzsl;
  zzct zzsm;
  boolean zzsn;
  Object zzso = new Object();
  zza zzsp;
  final long zzsq;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean)
  {
    zzac.zzC(paramContext);
    Context localContext;
    if (paramBoolean)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null) {}
    }
    for (this.mContext = paramContext;; this.mContext = paramContext)
    {
      this.zzsn = false;
      this.zzsq = paramLong;
      return;
      paramContext = localContext;
      break;
    }
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    f2 = 0.0F;
    boolean bool2 = false;
    boolean bool3 = false;
    bool1 = bool2;
    try
    {
      localObject1 = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      f1 = f2;
      bool1 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool2;
        localObject1 = ((Context)localObject1).getSharedPreferences("google_ads_flags", 1);
        bool1 = bool2;
        bool2 = ((SharedPreferences)localObject1).getBoolean("gads:ad_id_app_context:enabled", false);
        bool1 = bool2;
        f1 = ((SharedPreferences)localObject1).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramContext.zze(false);
          Object localObject1 = paramContext.getInfo();
          paramContext.zza((Info)localObject1, bool1, f1, null);
          return (Info)localObject1;
        }
        catch (Throwable localThrowable)
        {
          float f1;
          paramContext.zza(null, bool1, f1, localThrowable);
          return null;
        }
        finally
        {
          paramContext.finish();
        }
        localException = localException;
        Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", localException);
        f1 = f2;
      }
    }
    paramContext = new AdvertisingIdClient(paramContext, -1L, bool1);
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  static zzct zza(Context paramContext, com.google.android.gms.common.zza paramzza)
    throws IOException
  {
    try
    {
      paramContext = zzct.zza.zzf(paramzza.zza(10000L, TimeUnit.MILLISECONDS));
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
  }
  
  private void zza(Info paramInfo, boolean paramBoolean, float paramFloat, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        new zza().zzt(this.zzsr);
      }
    }.start();
  }
  
  private void zzbG()
  {
    synchronized (this.zzso)
    {
      if (this.zzsp != null) {
        this.zzsp.cancel();
      }
    }
    try
    {
      this.zzsp.join();
      if (this.zzsq > 0L) {
        this.zzsp = new zza(this, this.zzsq);
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  static com.google.android.gms.common.zza zzf(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext))
      {
      case 1: 
      default: 
        throw new IOException("Google Play services not available");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    com.google.android.gms.common.zza localzza = new com.google.android.gms.common.zza();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = com.google.android.gms.common.stats.zza.zzAu().zza(paramContext, localIntent, localzza, 1);
      if (bool) {
        return localzza;
      }
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
    throw new IOException("Connection failure");
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc -8
    //   2: invokestatic 251	com/google/android/gms/common/internal/zzac:zzcV	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsl	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsn	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 236	com/google/android/gms/common/stats/zza:zzAu	()Lcom/google/android/gms/common/stats/zza;
    //   34: aload_0
    //   35: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsl	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 256	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsn	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsm	Lcom/google/android/gms/internal/zzct;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsl	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: ldc 115
    //   71: ldc_w 260
    //   74: aload_1
    //   75: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   78: pop
    //   79: goto -34 -> 45
    //   82: astore_1
    //   83: ldc 115
    //   85: ldc_w 260
    //   88: aload_1
    //   89: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   92: pop
    //   93: goto -48 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	AdvertisingIdClient
    //   63	4	1	localObject	Object
    //   68	7	1	localIllegalArgumentException	IllegalArgumentException
    //   82	7	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	79	63	finally
    //   83	93	63	finally
    //   24	45	68	java/lang/IllegalArgumentException
    //   24	45	82	java/lang/Throwable
  }
  
  /* Error */
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc -8
    //   2: invokestatic 251	com/google/android/gms/common/internal/zzac:zzcV	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsn	Z
    //   11: ifne +86 -> 97
    //   14: aload_0
    //   15: getfield 39	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzso	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 179	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsp	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 179	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsp	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: invokevirtual 269	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzbH	()Z
    //   35: ifne +24 -> 59
    //   38: new 61	java/io/IOException
    //   41: dup
    //   42: ldc_w 271
    //   45: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_0
    //   62: iconst_0
    //   63: invokevirtual 103	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	(Z)V
    //   66: aload_0
    //   67: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsn	Z
    //   70: ifne +27 -> 97
    //   73: new 61	java/io/IOException
    //   76: dup
    //   77: ldc_w 273
    //   80: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: new 61	java/io/IOException
    //   88: dup
    //   89: ldc_w 273
    //   92: aload_1
    //   93: invokespecial 276	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: aload_0
    //   98: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsl	Lcom/google/android/gms/common/zza;
    //   101: invokestatic 45	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsm	Lcom/google/android/gms/internal/zzct;
    //   109: invokestatic 45	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: new 8	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   116: dup
    //   117: aload_0
    //   118: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsm	Lcom/google/android/gms/internal/zzct;
    //   121: invokeinterface 281 1 0
    //   126: aload_0
    //   127: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzsm	Lcom/google/android/gms/internal/zzct;
    //   130: iconst_1
    //   131: invokeinterface 284 2 0
    //   136: invokespecial 287	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_0
    //   143: invokespecial 289	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzbG	()V
    //   146: aload_1
    //   147: areturn
    //   148: astore_1
    //   149: ldc 115
    //   151: ldc_w 291
    //   154: aload_1
    //   155: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: new 61	java/io/IOException
    //   162: dup
    //   163: ldc_w 293
    //   166: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AdvertisingIdClient
    //   54	6	1	localObject2	Object
    //   84	9	1	localException	Exception
    //   139	8	1	localInfo	Info
    //   148	7	1	localRemoteException	android.os.RemoteException
    //   49	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	38	49	finally
    //   38	49	49	finally
    //   50	52	49	finally
    //   59	61	49	finally
    //   7	21	54	finally
    //   52	54	54	finally
    //   55	57	54	finally
    //   61	66	54	finally
    //   66	84	54	finally
    //   85	97	54	finally
    //   97	113	54	finally
    //   113	140	54	finally
    //   140	142	54	finally
    //   149	170	54	finally
    //   61	66	84	java/lang/Exception
    //   113	140	148	android/os/RemoteException
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zze(true);
  }
  
  Uri zza(Info paramInfo, boolean paramBoolean, Throwable paramThrowable)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      str = "1";
      localBundle.putString("app_context", str);
      if (paramInfo != null) {
        if (!paramInfo.isLimitAdTrackingEnabled()) {
          break label168;
        }
      }
    }
    label168:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("limit_ad_tracking", str);
      if ((paramInfo != null) && (paramInfo.getId() != null)) {
        localBundle.putString("ad_id_size", Integer.toString(paramInfo.getId().length()));
      }
      if (paramThrowable != null) {
        localBundle.putString("error", paramThrowable.getClass().getName());
      }
      paramInfo = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
      paramThrowable = localBundle.keySet().iterator();
      while (paramThrowable.hasNext())
      {
        str = (String)paramThrowable.next();
        paramInfo.appendQueryParameter(str, localBundle.getString(str));
      }
      str = "0";
      break;
    }
    return paramInfo.build();
  }
  
  protected void zze(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzac.zzcV("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzsn) {
        finish();
      }
      this.zzsl = zzf(this.mContext);
      this.zzsm = zza(this.mContext, this.zzsl);
      this.zzsn = true;
      if (paramBoolean) {
        zzbG();
      }
      return;
    }
    finally {}
  }
  
  public static final class Info
  {
    private final String zzsw;
    private final boolean zzsx;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzsw = paramString;
      this.zzsx = paramBoolean;
    }
    
    public String getId()
    {
      return this.zzsw;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.zzsx;
    }
    
    public String toString()
    {
      String str = this.zzsw;
      boolean bool = this.zzsx;
      return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
    }
  }
  
  static class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzss;
    private long zzst;
    CountDownLatch zzsu;
    boolean zzsv;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzss = new WeakReference(paramAdvertisingIdClient);
      this.zzst = paramLong;
      this.zzsu = new CountDownLatch(1);
      this.zzsv = false;
      start();
    }
    
    private void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzss.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzsv = true;
      }
    }
    
    public void cancel()
    {
      this.zzsu.countDown();
    }
    
    public void run()
    {
      try
      {
        if (!this.zzsu.await(this.zzst, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }
    
    public boolean zzbH()
    {
      return this.zzsv;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/ads/identifier/AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */