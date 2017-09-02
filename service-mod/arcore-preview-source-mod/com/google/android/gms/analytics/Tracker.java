package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.data.AppInfo;
import com.google.android.gms.analytics.data.DeviceInfo;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzap;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Tracker
  extends zzd
{
  private final Map<String, String> zzFE = new HashMap();
  private boolean zzaci;
  private final Map<String, String> zzacj = new HashMap();
  private final zzad zzack;
  private final zza zzacl;
  private ExceptionReporter zzacm;
  private zzan zzacn;
  
  Tracker(zzf paramzzf, String paramString, zzad paramzzad)
  {
    super(paramzzf);
    if (paramString != null) {
      this.zzFE.put("&tid", paramString);
    }
    this.zzFE.put("useSecure", "1");
    this.zzFE.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    if (paramzzad == null) {}
    for (this.zzack = new zzad("tracking", zznq());; this.zzack = paramzzad)
    {
      this.zzacl = new zza(paramzzf);
      return;
    }
  }
  
  private static boolean zza(Map.Entry<String, String> paramEntry)
  {
    String str = (String)paramEntry.getKey();
    paramEntry.getValue();
    return (str.startsWith("&")) && (str.length() >= 2);
  }
  
  private static String zzb(Map.Entry<String, String> paramEntry)
  {
    if (!zza(paramEntry)) {
      return null;
    }
    return ((String)paramEntry.getKey()).substring(1);
  }
  
  private static void zzb(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzac.zzC(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if (str != null) {
          paramMap2.put(str, (String)localEntry.getValue());
        }
      }
    }
  }
  
  private static void zzc(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzac.zzC(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if ((str != null) && (!paramMap2.containsKey(str))) {
          paramMap2.put(str, (String)localEntry.getValue());
        }
      }
    }
  }
  
  private boolean zzmY()
  {
    return this.zzacm != null;
  }
  
  static String zzq(Activity paramActivity)
  {
    zzac.zzC(paramActivity);
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      return null;
      paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    } while (TextUtils.isEmpty(paramActivity));
    return paramActivity;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzaci = paramBoolean;
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.zzacl.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (zzmY() == paramBoolean) {
          return;
        }
        if (paramBoolean)
        {
          Context localContext = getContext();
          this.zzacm = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), localContext);
          Thread.setDefaultUncaughtExceptionHandler(this.zzacm);
          zzbr("Uncaught exceptions will be reported to Google Analytics");
          return;
        }
      }
      finally {}
      Thread.setDefaultUncaughtExceptionHandler(this.zzacm.zzmB());
      zzbr("Uncaught exceptions will not be reported to Google Analytics");
    }
  }
  
  public String get(String paramString)
  {
    zznA();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.zzFE.containsKey(paramString)) {
        return (String)this.zzFE.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return zzao.zza(Locale.getDefault());
      }
      if (paramString.equals("&cid")) {
        return zznw().zzop();
      }
      if (paramString.equals("&sr")) {
        return zznz().zzpb();
      }
      if (paramString.equals("&aid")) {
        return zzny().zznX().getAppId();
      }
      if (paramString.equals("&an")) {
        return zzny().zznX().getAppName();
      }
      if (paramString.equals("&av")) {
        return zzny().zznX().getAppVersion();
      }
    } while (!paramString.equals("&aiid"));
    return zzny().zznX().getAppInstallerId();
  }
  
  public String getClientId()
  {
    return get("&cid");
  }
  
  public String getHitId()
  {
    return get("&a");
  }
  
  public String getTrackingId()
  {
    return get("&tid");
  }
  
  protected void onInitialize()
  {
    this.zzacl.initialize();
    String str = zzmG().getAppName();
    if (str != null) {
      set("&an", str);
    }
    str = zzmG().getAppVersion();
    if (str != null) {
      set("&av", str);
    }
  }
  
  public void send(final Map<String, String> paramMap)
  {
    final long l = zznq().currentTimeMillis();
    if (zzmA().getAppOptOut())
    {
      zzbs("AppOptOut is set to true. Not sending Google Analytics hit");
      return;
    }
    boolean bool1 = zzmA().isDryRunEnabled();
    final HashMap localHashMap = new HashMap();
    zzb(this.zzFE, localHashMap);
    zzb(paramMap, localHashMap);
    final boolean bool2 = zzao.zzg((String)this.zzFE.get("useSecure"), true);
    zzc(this.zzacj, localHashMap);
    this.zzacj.clear();
    paramMap = (String)localHashMap.get("t");
    if (TextUtils.isEmpty(paramMap))
    {
      zznr().zzg(localHashMap, "Missing hit type parameter");
      return;
    }
    final String str = (String)localHashMap.get("tid");
    if (TextUtils.isEmpty(str))
    {
      zznr().zzg(localHashMap, "Missing tracking id parameter");
      return;
    }
    final boolean bool3 = zzmZ();
    try
    {
      if (("screenview".equalsIgnoreCase(paramMap)) || ("pageview".equalsIgnoreCase(paramMap)) || ("appview".equalsIgnoreCase(paramMap)) || (TextUtils.isEmpty(paramMap)))
      {
        int j = Integer.parseInt((String)this.zzFE.get("&a")) + 1;
        int i = j;
        if (j >= Integer.MAX_VALUE) {
          i = 1;
        }
        this.zzFE.put("&a", Integer.toString(i));
      }
      zznt().zzg(new Runnable()
      {
        public void run()
        {
          boolean bool = true;
          if (Tracker.zza(Tracker.this).zzna()) {
            localHashMap.put("sc", "start");
          }
          zzao.zzd(localHashMap, "cid", Tracker.this.zzmA().getClientId());
          Object localObject = (String)localHashMap.get("sf");
          if (localObject != null)
          {
            double d = zzao.zza((String)localObject, 100.0D);
            if (zzao.zza(d, (String)localHashMap.get("cid")))
            {
              Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
              return;
            }
          }
          localObject = Tracker.zzb(Tracker.this);
          if (bool3)
          {
            zzao.zzb(localHashMap, "ate", ((zza)localObject).isAdTargetingEnabled());
            zzao.zzc(localHashMap, "adid", ((zza)localObject).zznf());
            localObject = Tracker.zzc(Tracker.this).zznX();
            zzao.zzc(localHashMap, "an", ((AppInfo)localObject).getAppName());
            zzao.zzc(localHashMap, "av", ((AppInfo)localObject).getAppVersion());
            zzao.zzc(localHashMap, "aid", ((AppInfo)localObject).getAppId());
            zzao.zzc(localHashMap, "aiid", ((AppInfo)localObject).getAppInstallerId());
            localHashMap.put("v", "1");
            localHashMap.put("_v", zze.zzadz);
            zzao.zzc(localHashMap, "ul", Tracker.zzd(Tracker.this).zzpa().getLanguage());
            zzao.zzc(localHashMap, "sr", Tracker.zze(Tracker.this).zzpb());
            if ((!paramMap.equals("transaction")) && (!paramMap.equals("item"))) {
              break label383;
            }
          }
          label383:
          for (int i = 1;; i = 0)
          {
            if ((i != 0) || (Tracker.zzf(Tracker.this).zzpu())) {
              break label388;
            }
            Tracker.zzg(Tracker.this).zzg(localHashMap, "Too many hits sent too quickly, rate limiting invoked");
            return;
            localHashMap.remove("ate");
            localHashMap.remove("adid");
            break;
          }
          label388:
          long l2 = zzao.zzbH((String)localHashMap.get("ht"));
          long l1 = l2;
          if (l2 == 0L) {
            l1 = l;
          }
          if (bool2)
          {
            localObject = new zzab(Tracker.this, localHashMap, l1, str);
            Tracker.zzh(Tracker.this).zzc("Dry run enabled. Would have sent hit", localObject);
            return;
          }
          localObject = (String)localHashMap.get("cid");
          HashMap localHashMap = new HashMap();
          zzao.zza(localHashMap, "uid", localHashMap);
          zzao.zza(localHashMap, "an", localHashMap);
          zzao.zza(localHashMap, "aid", localHashMap);
          zzao.zza(localHashMap, "av", localHashMap);
          zzao.zza(localHashMap, "aiid", localHashMap);
          String str = this.zzacu;
          if (!TextUtils.isEmpty((CharSequence)localHashMap.get("adid"))) {}
          for (;;)
          {
            localObject = new com.google.android.gms.analytics.internal.zzh(0L, (String)localObject, str, bool, 0L, localHashMap);
            l2 = Tracker.zzi(Tracker.this).zza((com.google.android.gms.analytics.internal.zzh)localObject);
            localHashMap.put("_s", String.valueOf(l2));
            localObject = new zzab(Tracker.this, localHashMap, l1, str);
            Tracker.zzj(Tracker.this).zza((zzab)localObject);
            return;
            bool = false;
          }
        }
      });
      return;
    }
    finally {}
  }
  
  public void set(String paramString1, String paramString2)
  {
    zzac.zzb(paramString1, "Key should be non-null");
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.zzFE.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", zzao.zzS(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.isOpaque())) {}
    do
    {
      return;
      paramUri = paramUri.getQueryParameter("referrer");
    } while (TextUtils.isEmpty(paramUri));
    paramUri = String.valueOf(paramUri);
    if (paramUri.length() != 0) {}
    for (paramUri = "http://hostname/?".concat(paramUri);; paramUri = new String("http://hostname/?"))
    {
      paramUri = Uri.parse(paramUri);
      String str = paramUri.getQueryParameter("utm_id");
      if (str != null) {
        this.zzacj.put("&ci", str);
      }
      str = paramUri.getQueryParameter("anid");
      if (str != null) {
        this.zzacj.put("&anid", str);
      }
      str = paramUri.getQueryParameter("utm_campaign");
      if (str != null) {
        this.zzacj.put("&cn", str);
      }
      str = paramUri.getQueryParameter("utm_content");
      if (str != null) {
        this.zzacj.put("&cc", str);
      }
      str = paramUri.getQueryParameter("utm_medium");
      if (str != null) {
        this.zzacj.put("&cm", str);
      }
      str = paramUri.getQueryParameter("utm_source");
      if (str != null) {
        this.zzacj.put("&cs", str);
      }
      str = paramUri.getQueryParameter("utm_term");
      if (str != null) {
        this.zzacj.put("&ck", str);
      }
      str = paramUri.getQueryParameter("dclid");
      if (str != null) {
        this.zzacj.put("&dclid", str);
      }
      str = paramUri.getQueryParameter("gclid");
      if (str != null) {
        this.zzacj.put("&gclid", str);
      }
      paramUri = paramUri.getQueryParameter("aclid");
      if (paramUri == null) {
        break;
      }
      this.zzacj.put("&aclid", paramUri);
      return;
    }
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      zzbu("Invalid width or height. The values should be non-negative.");
      return;
    }
    set("&sr", 23 + paramInt1 + "x" + paramInt2);
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.zzacl.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", zzao.zzS(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  void zza(zzan paramzzan)
  {
    zzbr("Loading Tracker config values");
    this.zzacn = paramzzan;
    if (this.zzacn.zzpP())
    {
      paramzzan = this.zzacn.getTrackingId();
      set("&tid", paramzzan);
      zza("trackingId loaded", paramzzan);
    }
    if (this.zzacn.zzpQ())
    {
      paramzzan = Double.toString(this.zzacn.zzpR());
      set("&sf", paramzzan);
      zza("Sample frequency loaded", paramzzan);
    }
    if (this.zzacn.zzpS())
    {
      int i = this.zzacn.getSessionTimeout();
      setSessionTimeout(i);
      zza("Session timeout loaded", Integer.valueOf(i));
    }
    boolean bool;
    if (this.zzacn.zzpT())
    {
      bool = this.zzacn.zzpU();
      enableAutoActivityTracking(bool);
      zza("Auto activity tracking loaded", Boolean.valueOf(bool));
    }
    if (this.zzacn.zzpV())
    {
      bool = this.zzacn.zzpW();
      if (bool) {
        set("&aip", "1");
      }
      zza("Anonymize ip loaded", Boolean.valueOf(bool));
    }
    enableExceptionReporting(this.zzacn.zzpX());
  }
  
  boolean zzmZ()
  {
    return this.zzaci;
  }
  
  private class zza
    extends zzd
    implements GoogleAnalytics.zza
  {
    private long zzacA;
    private boolean zzacw;
    private int zzacx;
    private long zzacy = -1L;
    private boolean zzacz;
    
    protected zza(zzf paramzzf)
    {
      super();
    }
    
    private void zznb()
    {
      if ((this.zzacy >= 0L) || (this.zzacw))
      {
        zzmA().zza(Tracker.zza(Tracker.this));
        return;
      }
      zzmA().zzb(Tracker.zza(Tracker.this));
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.zzacw = paramBoolean;
      zznb();
    }
    
    protected void onInitialize() {}
    
    public void setSessionTimeout(long paramLong)
    {
      this.zzacy = paramLong;
      zznb();
    }
    
    public boolean zzna()
    {
      try
      {
        boolean bool = this.zzacz;
        this.zzacz = false;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean zznc()
    {
      return zznq().elapsedRealtime() >= this.zzacA + Math.max(1000L, this.zzacy);
    }
    
    public void zzo(Activity paramActivity)
    {
      if ((this.zzacx == 0) && (zznc())) {
        this.zzacz = true;
      }
      this.zzacx += 1;
      HashMap localHashMap;
      Tracker localTracker;
      if (this.zzacw)
      {
        localObject = paramActivity.getIntent();
        if (localObject != null) {
          Tracker.this.setCampaignParamsOnNextHit(((Intent)localObject).getData());
        }
        localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        localTracker = Tracker.this;
        if (Tracker.zzk(Tracker.this) == null) {
          break label159;
        }
      }
      label159:
      for (Object localObject = Tracker.zzk(Tracker.this).zzr(paramActivity);; localObject = paramActivity.getClass().getCanonicalName())
      {
        localTracker.set("&cd", (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&dr")))
        {
          paramActivity = Tracker.zzq(paramActivity);
          if (!TextUtils.isEmpty(paramActivity)) {
            localHashMap.put("&dr", paramActivity);
          }
        }
        Tracker.this.send(localHashMap);
        return;
      }
    }
    
    public void zzp(Activity paramActivity)
    {
      this.zzacx -= 1;
      this.zzacx = Math.max(0, this.zzacx);
      if (this.zzacx == 0) {
        this.zzacA = zznq().elapsedRealtime();
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */