package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.data.AppInfo;
import com.google.android.gms.analytics.data.CampaignInfo;
import com.google.android.gms.analytics.data.CustomParams;
import com.google.android.gms.analytics.data.HitParams;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zze;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.zzabz;
import com.google.android.gms.internal.zzaca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzl
  extends zzd
{
  private boolean mStarted;
  private final zzj zzaej;
  private final zzah zzaek;
  private final zzag zzael;
  private final zzi zzaem;
  private long zzaen;
  private final zzu zzaeo;
  private final zzu zzaep;
  private final zzal zzaeq;
  private long zzaer;
  private boolean zzaes;
  
  protected zzl(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzac.zzC(paramzzg);
    this.zzaen = Long.MIN_VALUE;
    this.zzael = paramzzg.zzk(paramzzf);
    this.zzaej = paramzzg.zzm(paramzzf);
    this.zzaek = paramzzg.zzn(paramzzf);
    this.zzaem = paramzzg.zzo(paramzzf);
    this.zzaeq = new zzal(zznq());
    this.zzaeo = new zzu(paramzzf)
    {
      public void run()
      {
        zzl.zza(zzl.this);
      }
    };
    this.zzaep = new zzu(paramzzf)
    {
      public void run()
      {
        zzl.zzb(zzl.this);
      }
    };
  }
  
  private void zza(zzh paramzzh, CampaignInfo paramCampaignInfo)
  {
    zzac.zzC(paramzzh);
    zzac.zzC(paramCampaignInfo);
    Object localObject1 = new zza(zznp());
    ((zza)localObject1).zzbk(paramzzh.zznJ());
    ((zza)localObject1).enableAdvertisingIdCollection(paramzzh.zznK());
    localObject1 = ((zza)localObject1).zzmu();
    HitParams localHitParams = (HitParams)((zze)localObject1).zzb(HitParams.class);
    localHitParams.setHitType("data");
    localHitParams.setNonInteraction(true);
    ((zze)localObject1).zza(paramCampaignInfo);
    CustomParams localCustomParams = (CustomParams)((zze)localObject1).zzb(CustomParams.class);
    AppInfo localAppInfo = (AppInfo)((zze)localObject1).zzb(AppInfo.class);
    Iterator localIterator = paramzzh.zzfN().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        localAppInfo.setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        localAppInfo.setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        localAppInfo.setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        localAppInfo.setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localHitParams.setUserId((String)localObject2);
      } else {
        localCustomParams.set(str, (String)localObject2);
      }
    }
    zzb("Sending installation campaign to", paramzzh.zznJ(), paramCampaignInfo);
    ((zze)localObject1).zzv(zznv().zzpC());
    ((zze)localObject1).zzmL();
  }
  
  private boolean zzby(String paramString)
  {
    return zzaca.zzbp(getContext()).checkCallingOrSelfPermission(paramString) == 0;
  }
  
  private void zznY()
  {
    zzmW();
    Context localContext = zznp().getContext();
    if (!zzaj.zzao(localContext)) {
      zzbu("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    }
    do
    {
      while (!CampaignTrackingReceiver.zzao(localContext))
      {
        zzbu("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        return;
        if (!zzak.zzap(localContext)) {
          zzbv("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    } while (CampaignTrackingService.zzap(localContext));
    zzbu("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
  }
  
  private void zzoa()
  {
    zzb(new zzx()
    {
      public void zzf(Throwable paramAnonymousThrowable)
      {
        zzl.this.zzog();
      }
    });
  }
  
  private void zzob()
  {
    try
    {
      this.zzaej.zznS();
      zzog();
      this.zzaep.zzC(86400000L);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete stale hits", localSQLiteException);
      }
    }
  }
  
  private boolean zzoh()
  {
    if (this.zzaes) {}
    while (zzon() <= 0L) {
      return false;
    }
    return true;
  }
  
  private void zzoi()
  {
    zzw localzzw = zznu();
    if (!localzzw.zzpc()) {}
    long l;
    do
    {
      do
      {
        return;
      } while (localzzw.zzcJ());
      l = zznT();
    } while ((l == 0L) || (Math.abs(zznq().currentTimeMillis() - l) > zzns().zzoE()));
    zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzns().zzoD()));
    localzzw.schedule();
  }
  
  private void zzoj()
  {
    zzoi();
    long l2 = zzon();
    long l1 = zznv().zzpE();
    if (l1 != 0L)
    {
      l1 = l2 - Math.abs(zznq().currentTimeMillis() - l1);
      if (l1 <= 0L) {}
    }
    for (;;)
    {
      zza("Dispatch scheduled (ms)", Long.valueOf(l1));
      if (!this.zzaeo.zzcJ()) {
        break;
      }
      l1 = Math.max(1L, l1 + this.zzaeo.zzoZ());
      this.zzaeo.zzD(l1);
      return;
      l1 = Math.min(zzns().zzoB(), l2);
      continue;
      l1 = Math.min(zzns().zzoB(), l2);
    }
    this.zzaeo.zzC(l1);
  }
  
  private void zzok()
  {
    zzol();
    zzom();
  }
  
  private void zzol()
  {
    if (this.zzaeo.zzcJ()) {
      zzbr("All hits dispatched or no network/service. Going to power save mode");
    }
    this.zzaeo.cancel();
  }
  
  private void zzom()
  {
    zzw localzzw = zznu();
    if (localzzw.zzcJ()) {
      localzzw.cancel();
    }
  }
  
  protected void onInitialize()
  {
    this.zzaej.initialize();
    this.zzaek.initialize();
    this.zzaem.initialize();
  }
  
  protected void onServiceConnected()
  {
    zzmW();
    zzod();
  }
  
  void start()
  {
    zznA();
    if (!this.mStarted) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Analytics backend already started");
      this.mStarted = true;
      zznt().zzg(new Runnable()
      {
        public void run()
        {
          zzl.this.zznZ();
        }
      });
      return;
    }
  }
  
  public void zzB(long paramLong)
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.zzaen = l;
    zzog();
  }
  
  public void zzR(boolean paramBoolean)
  {
    zzog();
  }
  
  /* Error */
  public long zza(zzh paramzzh, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 42	com/google/android/gms/common/internal/zzac:zzC	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 445	com/google/android/gms/analytics/internal/zzl:zznA	()V
    //   9: aload_0
    //   10: invokevirtual 266	com/google/android/gms/analytics/internal/zzl:zzmW	()V
    //   13: aload_0
    //   14: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   17: invokevirtual 470	com/google/android/gms/analytics/internal/zzj:beginTransaction	()V
    //   20: aload_0
    //   21: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   24: aload_1
    //   25: invokevirtual 473	com/google/android/gms/analytics/internal/zzh:zznI	()J
    //   28: aload_1
    //   29: invokevirtual 476	com/google/android/gms/analytics/internal/zzh:getClientId	()Ljava/lang/String;
    //   32: invokevirtual 479	com/google/android/gms/analytics/internal/zzj:zza	(JLjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   39: aload_1
    //   40: invokevirtual 473	com/google/android/gms/analytics/internal/zzh:zznI	()J
    //   43: aload_1
    //   44: invokevirtual 476	com/google/android/gms/analytics/internal/zzh:getClientId	()Ljava/lang/String;
    //   47: aload_1
    //   48: invokevirtual 107	com/google/android/gms/analytics/internal/zzh:zznJ	()Ljava/lang/String;
    //   51: invokevirtual 482	com/google/android/gms/analytics/internal/zzj:zza	(JLjava/lang/String;Ljava/lang/String;)J
    //   54: lstore_3
    //   55: iload_2
    //   56: ifne +32 -> 88
    //   59: aload_1
    //   60: lload_3
    //   61: invokevirtual 485	com/google/android/gms/analytics/internal/zzh:zzw	(J)V
    //   64: aload_0
    //   65: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   68: aload_1
    //   69: invokevirtual 488	com/google/android/gms/analytics/internal/zzj:zzb	(Lcom/google/android/gms/analytics/internal/zzh;)V
    //   72: aload_0
    //   73: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   76: invokevirtual 491	com/google/android/gms/analytics/internal/zzj:setTransactionSuccessful	()V
    //   79: aload_0
    //   80: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   83: invokevirtual 494	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   86: lload_3
    //   87: lreturn
    //   88: aload_1
    //   89: lconst_1
    //   90: lload_3
    //   91: ladd
    //   92: invokevirtual 485	com/google/android/gms/analytics/internal/zzh:zzw	(J)V
    //   95: goto -31 -> 64
    //   98: astore_1
    //   99: aload_0
    //   100: ldc_w 496
    //   103: aload_1
    //   104: invokevirtual 499	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   111: invokevirtual 494	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   114: ldc2_w 500
    //   117: lreturn
    //   118: astore_1
    //   119: aload_0
    //   120: ldc_w 503
    //   123: aload_1
    //   124: invokevirtual 499	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   127: lload_3
    //   128: lreturn
    //   129: astore_1
    //   130: aload_0
    //   131: ldc_w 503
    //   134: aload_1
    //   135: invokevirtual 499	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   138: goto -24 -> 114
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 60	com/google/android/gms/analytics/internal/zzl:zzaej	Lcom/google/android/gms/analytics/internal/zzj;
    //   146: invokevirtual 494	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore 5
    //   153: aload_0
    //   154: ldc_w 503
    //   157: aload 5
    //   159: invokevirtual 499	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   162: goto -13 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	zzl
    //   0	165	1	paramzzh	zzh
    //   0	165	2	paramBoolean	boolean
    //   54	74	3	l	long
    //   151	7	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	55	98	android/database/sqlite/SQLiteException
    //   59	64	98	android/database/sqlite/SQLiteException
    //   64	79	98	android/database/sqlite/SQLiteException
    //   88	95	98	android/database/sqlite/SQLiteException
    //   79	86	118	android/database/sqlite/SQLiteException
    //   107	114	129	android/database/sqlite/SQLiteException
    //   13	55	141	finally
    //   59	64	141	finally
    //   64	79	141	finally
    //   88	95	141	finally
    //   99	107	141	finally
    //   142	149	151	android/database/sqlite/SQLiteException
  }
  
  public void zza(zzab paramzzab)
  {
    zzac.zzC(paramzzab);
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    if (this.zzaes) {
      zzbs("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
    }
    for (;;)
    {
      paramzzab = zzf(paramzzab);
      zzoc();
      if (!this.zzaem.zzb(paramzzab)) {
        break;
      }
      zzbs("Hit sent to the device AnalyticsService for delivery");
      return;
      zza("Delivering hit", paramzzab);
    }
    try
    {
      this.zzaej.zzc(paramzzab);
      zzog();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Delivery failed to save hit to a database", localSQLiteException);
      zznr().zza(paramzzab, "deliver: failed to insert hit to database");
    }
  }
  
  public void zza(zzx paramzzx, long paramLong)
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    long l1 = -1L;
    long l2 = zznv().zzpE();
    if (l2 != 0L) {
      l1 = Math.abs(zznq().currentTimeMillis() - l2);
    }
    zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    zzoc();
    try
    {
      zzoe();
      zznv().zzpF();
      zzog();
      if (paramzzx != null) {
        paramzzx.zzf(null);
      }
      if (this.zzaer != paramLong) {
        this.zzael.zzpy();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        zze("Local dispatch failed", localThrowable);
        zznv().zzpF();
        zzog();
      } while (paramzzx == null);
      paramzzx.zzf(localThrowable);
    }
  }
  
  public void zzb(zzx paramzzx)
  {
    zza(paramzzx, this.zzaer);
  }
  
  public void zzbz(String paramString)
  {
    zzac.zzdc(paramString);
    zzmW();
    CampaignInfo localCampaignInfo = zzao.zza(zznr(), paramString);
    if (localCampaignInfo == null) {
      zzd("Parsing failed. Ignoring invalid campaign data", paramString);
    }
    for (;;)
    {
      return;
      String str = zznv().zzpG();
      if (paramString.equals(str))
      {
        zzbu("Ignoring duplicate install campaign");
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        zzd("Ignoring multiple install campaigns. original, new", str, paramString);
        return;
      }
      zznv().zzbD(paramString);
      if (zznv().zzpD().zzE(zzns().zzoX()))
      {
        zzd("Campaign received too late, ignoring", localCampaignInfo);
        return;
      }
      zzb("Received installation campaign", localCampaignInfo);
      paramString = this.zzaej.zzA(0L).iterator();
      while (paramString.hasNext()) {
        zza((zzh)paramString.next(), localCampaignInfo);
      }
    }
  }
  
  protected void zzc(zzh paramzzh)
  {
    zzmW();
    zzb("Sending first hit to property", paramzzh.zznJ());
    if (zznv().zzpD().zzE(zzns().zzoX())) {}
    do
    {
      return;
      localObject = zznv().zzpG();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = zzao.zza(zznr(), (String)localObject);
    zzb("Found relevant installation campaign", localObject);
    zza(paramzzh, (CampaignInfo)localObject);
  }
  
  zzab zzf(zzab paramzzab)
  {
    if (!TextUtils.isEmpty(paramzzab.zzpt())) {}
    do
    {
      return paramzzab;
      localObject2 = zznv().zzpH().zzpK();
    } while (localObject2 == null);
    Object localObject1 = (Long)((Pair)localObject2).second;
    Object localObject2 = (String)((Pair)localObject2).first;
    localObject1 = String.valueOf(localObject1);
    localObject1 = String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + ":" + (String)localObject2;
    localObject2 = new HashMap(paramzzab.zzfN());
    ((Map)localObject2).put("_m", localObject1);
    return zzab.zza(this, paramzzab, (Map)localObject2);
  }
  
  public long zznT()
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    try
    {
      long l = this.zzaej.zznT();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Failed to get min/max hit times from local store", localSQLiteException);
    }
    return 0L;
  }
  
  protected void zznZ()
  {
    zznA();
    zznY();
    zznv().zzpC();
    if (!zzby("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzbv("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzoo();
    }
    if (!zzby("android.permission.INTERNET"))
    {
      zzbv("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzoo();
    }
    if (zzak.zzap(getContext())) {
      zzbr("AnalyticsService registered in the app manifest and enabled");
    }
    for (;;)
    {
      if ((!this.zzaes) && (!this.zzaej.isEmpty())) {
        zzoc();
      }
      zzog();
      return;
      zzbu("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
    }
  }
  
  public void zznj()
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    zzbr("Delete all hits from local store");
    try
    {
      this.zzaej.zznQ();
      this.zzaej.zznR();
      zzog();
      zzoc();
      if (this.zzaem.zznM()) {
        zzbr("Device service unavailable. Can't clear hits stored on the device service.");
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete hits from store", localSQLiteException);
      }
    }
  }
  
  public void zznm()
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    zzbr("Service disconnected");
  }
  
  void zzno()
  {
    zzmW();
    this.zzaer = zznq().currentTimeMillis();
  }
  
  protected void zzoc()
  {
    if (this.zzaes) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while ((!zzns().zzow()) || (this.zzaem.isConnected()));
        l = zzns().zzoR();
      } while (!this.zzaeq.zzE(l));
      this.zzaeq.start();
      zzbr("Connecting to service");
    } while (!this.zzaem.connect());
    zzbr("Connected to service");
    this.zzaeq.clear();
    onServiceConnected();
  }
  
  public void zzod()
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    if (!zzns().zzow()) {
      zzbu("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!this.zzaem.isConnected()) {
      zzbr("Service not connected");
    }
    while (this.zzaej.isEmpty()) {
      return;
    }
    zzbr("Dispatching local hits to device AnalyticsService");
    for (;;)
    {
      try
      {
        List localList = this.zzaej.zzy(zzns().zzoF());
        if (!localList.isEmpty()) {
          break label122;
        }
        zzog();
        return;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze("Failed to read hits from store", localSQLiteException1);
        zzok();
        return;
      }
      label103:
      Object localObject;
      localSQLiteException1.remove(localObject);
      try
      {
        this.zzaej.zzz(((zzab)localObject).zzpo());
        label122:
        if (!localSQLiteException1.isEmpty())
        {
          localObject = (zzab)localSQLiteException1.get(0);
          if (this.zzaem.zzb((zzab)localObject)) {
            break label103;
          }
          zzog();
          return;
        }
      }
      catch (SQLiteException localSQLiteException2)
      {
        zze("Failed to remove hit that was send for delivery", localSQLiteException2);
        zzok();
      }
    }
  }
  
  protected boolean zzoe()
  {
    int j = 1;
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    zzbr("Dispatching a batch of local hits");
    int i;
    if (!this.zzaem.isConnected())
    {
      i = 1;
      if (this.zzaek.isNetworkConnected()) {
        break label60;
      }
    }
    for (;;)
    {
      if ((i == 0) || (j == 0)) {
        break label65;
      }
      zzbr("No network or service available. Will retry later");
      return false;
      i = 0;
      break;
      label60:
      j = 0;
    }
    label65:
    long l3 = Math.max(zzns().zzoF(), zzns().zzoG());
    ArrayList localArrayList = new ArrayList();
    l1 = 0L;
    for (;;)
    {
      try
      {
        this.zzaej.beginTransaction();
        localArrayList.clear();
        try
        {
          localList = this.zzaej.zzy(l3);
          if (localList.isEmpty())
          {
            zzbr("Store is empty, nothing to dispatch");
            zzok();
            try
            {
              this.zzaej.setTransactionSuccessful();
              this.zzaej.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException1)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException1);
              zzok();
              return false;
            }
          }
          zza("Hits loaded from store. count", Integer.valueOf(localList.size()));
          localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (((zzab)((Iterator)localObject2).next()).zzpo() != l1) {
              continue;
            }
            zzd("Database contains successfully uploaded hit", Long.valueOf(l1), Integer.valueOf(localList.size()));
            zzok();
            try
            {
              this.zzaej.setTransactionSuccessful();
              this.zzaej.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException2)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException2);
              zzok();
              return false;
            }
          }
          zzbr("Service connected, sending hits to the service");
        }
        catch (SQLiteException localSQLiteException3)
        {
          zzd("Failed to read hits from persisted store", localSQLiteException3);
          zzok();
          try
          {
            this.zzaej.setTransactionSuccessful();
            this.zzaej.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException4)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException4);
            zzok();
            return false;
          }
          l2 = l1;
          if (!this.zzaem.isConnected()) {
            continue;
          }
        }
        l2 = l1;
        if (localList.isEmpty()) {
          continue;
        }
        localObject2 = (zzab)localList.get(0);
        if (this.zzaem.zzb((zzab)localObject2)) {
          continue;
        }
      }
      finally
      {
        long l2;
        try
        {
          List localList;
          Object localObject2;
          this.zzaej.setTransactionSuccessful();
          this.zzaej.endTransaction();
          throw ((Throwable)localObject1);
        }
        catch (SQLiteException localSQLiteException11)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException11);
          zzok();
          return false;
        }
        l1 = l2;
        continue;
      }
      l2 = l1;
      if (this.zzaek.isNetworkConnected())
      {
        localList = this.zzaek.zzt(localList);
        localObject2 = localList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          l1 = Math.max(l1, ((Long)((Iterator)localObject2).next()).longValue());
          continue;
          l1 = Math.max(l1, ((zzab)localObject2).zzpo());
          localList.remove(localObject2);
          zzb("Hit sent do device AnalyticsService for delivery", localObject2);
          try
          {
            this.zzaej.zzz(((zzab)localObject2).zzpo());
            localSQLiteException4.add(Long.valueOf(((zzab)localObject2).zzpo()));
          }
          catch (SQLiteException localSQLiteException5)
          {
            zze("Failed to remove hit that was send for delivery", localSQLiteException5);
            zzok();
            try
            {
              this.zzaej.setTransactionSuccessful();
              this.zzaej.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException6)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException6);
              zzok();
              return false;
            }
          }
        }
      }
      try
      {
        this.zzaej.zzr(localList);
        localSQLiteException6.addAll(localList);
        l2 = l1;
        boolean bool = localSQLiteException6.isEmpty();
        if (bool) {
          try
          {
            this.zzaej.setTransactionSuccessful();
            this.zzaej.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException7)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException7);
            zzok();
            return false;
          }
        }
      }
      catch (SQLiteException localSQLiteException8)
      {
        zze("Failed to remove successfully uploaded hits", localSQLiteException8);
        zzok();
        try
        {
          this.zzaej.setTransactionSuccessful();
          this.zzaej.endTransaction();
          return false;
        }
        catch (SQLiteException localSQLiteException9)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException9);
          zzok();
          return false;
        }
        try
        {
          this.zzaej.setTransactionSuccessful();
          this.zzaej.endTransaction();
          l1 = l2;
        }
        catch (SQLiteException localSQLiteException10)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException10);
          zzok();
          return false;
        }
      }
    }
  }
  
  public void zzof()
  {
    com.google.android.gms.analytics.zzh.zzmW();
    zznA();
    zzbs("Sync dispatching local hits");
    long l = this.zzaer;
    zzoc();
    try
    {
      zzoe();
      zznv().zzpF();
      zzog();
      if (this.zzaer != l) {
        this.zzael.zzpy();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      zze("Sync local dispatch failed", localThrowable);
      zzog();
    }
  }
  
  public void zzog()
  {
    zznp().zzmW();
    zznA();
    if (!zzoh())
    {
      this.zzael.unregister();
      zzok();
      return;
    }
    if (this.zzaej.isEmpty())
    {
      this.zzael.unregister();
      zzok();
      return;
    }
    if (!((Boolean)G.disableBroadcastReceiver.get()).booleanValue()) {
      this.zzael.zzpw();
    }
    for (boolean bool = this.zzael.isConnected(); bool; bool = true)
    {
      zzoj();
      return;
    }
    zzok();
    zzoi();
  }
  
  public long zzon()
  {
    long l;
    if (this.zzaen != Long.MIN_VALUE) {
      l = this.zzaen;
    }
    do
    {
      return l;
      l = zzns().zzoC();
    } while (!zzmG().zzpj());
    return zzmG().zzpY() * 1000L;
  }
  
  public void zzoo()
  {
    zznA();
    zzmW();
    this.zzaes = true;
    this.zzaem.disconnect();
    zzog();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */