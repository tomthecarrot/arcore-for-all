package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.data.AppInfo;
import com.google.android.gms.analytics.data.DeviceInfo;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.common.internal.zzac;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzh
{
  private static volatile zzh zzabS;
  private final Context mContext;
  private final List<Object> zzabT;
  private final zzd zzabU;
  private final zza zzabV;
  private volatile AppInfo zzabW;
  private Thread.UncaughtExceptionHandler zzabX;
  
  zzh(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzac.zzC(paramContext);
    this.mContext = paramContext;
    this.zzabV = new zza();
    this.zzabT = new CopyOnWriteArrayList();
    this.zzabU = new zzd();
  }
  
  public static zzh zzaq(Context paramContext)
  {
    zzac.zzC(paramContext);
    if (zzabS == null) {}
    try
    {
      if (zzabS == null) {
        zzabS = new zzh(paramContext);
      }
      return zzabS;
    }
    finally {}
  }
  
  private void zzb(zze paramzze)
  {
    zzac.zzcV("deliver should be called from worker thread");
    zzac.zzb(paramzze.zzmM(), "Measurement must be submitted");
    Object localObject = paramzze.zzmJ();
    if (((List)localObject).isEmpty()) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzi localzzi = (zzi)((Iterator)localObject).next();
        Uri localUri = localzzi.zzmx();
        if (!localHashSet.contains(localUri))
        {
          localHashSet.add(localUri);
          localzzi.zzb(paramzze);
        }
      }
    }
  }
  
  public static void zzmW()
  {
    if (!(Thread.currentThread() instanceof zzc)) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void zza(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.zzabX = paramUncaughtExceptionHandler;
  }
  
  public <V> Future<V> zzc(Callable<V> paramCallable)
  {
    zzac.zzC(paramCallable);
    if ((Thread.currentThread() instanceof zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
      return paramCallable;
    }
    return this.zzabV.submit(paramCallable);
  }
  
  void zze(final zze paramzze)
  {
    if (paramzze.zzmQ()) {
      throw new IllegalStateException("Measurement prototype can't be submitted");
    }
    if (paramzze.zzmM()) {
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    paramzze = paramzze.zzmH();
    paramzze.zzmN();
    this.zzabV.execute(new Runnable()
    {
      public void run()
      {
        paramzze.zzmO().zza(paramzze);
        Iterator localIterator = zzh.zza(zzh.this).iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
        zzh.zza(zzh.this, paramzze);
      }
    });
  }
  
  public void zzg(Runnable paramRunnable)
  {
    zzac.zzC(paramRunnable);
    this.zzabV.submit(paramRunnable);
  }
  
  public AppInfo zzmU()
  {
    if (this.zzabW == null) {}
    label204:
    for (;;)
    {
      try
      {
        AppInfo localAppInfo;
        PackageManager localPackageManager;
        String str3;
        Object localObject5;
        Object localObject3;
        if (this.zzabW == null)
        {
          localAppInfo = new AppInfo();
          localPackageManager = this.mContext.getPackageManager();
          str3 = this.mContext.getPackageName();
          localAppInfo.setAppId(str3);
          localAppInfo.setAppInstallerId(localPackageManager.getInstallerPackageName(str3));
          localObject5 = null;
          localObject3 = str3;
        }
        try
        {
          PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
          localObject4 = localObject5;
          String str1 = str3;
          if (localPackageInfo != null)
          {
            localObject3 = str3;
            localObject4 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
            str1 = str3;
            localObject3 = str3;
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject3 = str3;
              str1 = ((CharSequence)localObject4).toString();
            }
            localObject3 = str1;
            localObject4 = localPackageInfo.versionName;
          }
          localAppInfo.setAppName(str1);
          localAppInfo.setAppVersion((String)localObject4);
          this.zzabW = localAppInfo;
          return this.zzabW;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject1 = String.valueOf(localObject3);
          if (((String)localObject1).length() == 0) {
            break label204;
          }
        }
        Object localObject1 = "Error retrieving package info: appName set to ".concat((String)localObject1);
        Log.e("GAv4", (String)localObject1);
        Object localObject4 = localObject5;
        localObject1 = localObject3;
        continue;
        String str2 = new String("Error retrieving package info: appName set to ");
      }
      finally {}
    }
  }
  
  public DeviceInfo zzmV()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    DeviceInfo localDeviceInfo = new DeviceInfo();
    localDeviceInfo.setLanguage(zzao.zza(Locale.getDefault()));
    localDeviceInfo.setScreenWidth(localDisplayMetrics.widthPixels);
    localDeviceInfo.setScreenHeight(localDisplayMetrics.heightPixels);
    return localDeviceInfo;
  }
  
  private class zza
    extends ThreadPoolExecutor
  {
    public zza()
    {
      super(1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
      setThreadFactory(new zzh.zzb(null));
      allowCoreThreadTimeOut(true);
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      new FutureTask(paramRunnable, paramT)
      {
        protected void setException(Throwable paramAnonymousThrowable)
        {
          Object localObject = zzh.zzb(zzh.this);
          if (localObject != null) {
            ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(Thread.currentThread(), paramAnonymousThrowable);
          }
          for (;;)
          {
            super.setException(paramAnonymousThrowable);
            return;
            if (Log.isLoggable("GAv4", 6))
            {
              localObject = String.valueOf(paramAnonymousThrowable);
              Log.e("GAv4", String.valueOf(localObject).length() + 37 + "MeasurementExecutor: job failed with " + (String)localObject);
            }
          }
        }
      };
    }
  }
  
  private static class zzb
    implements ThreadFactory
  {
    private static final AtomicInteger zzacb = new AtomicInteger();
    
    public Thread newThread(Runnable paramRunnable)
    {
      int i = zzacb.incrementAndGet();
      return new zzh.zzc(paramRunnable, 23 + "measurement-" + i);
    }
  }
  
  private static class zzc
    extends Thread
  {
    zzc(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */