package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzyq
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final zzyq zzaLz = new zzyq();
  private final ArrayList<zza> mListeners = new ArrayList();
  private final AtomicBoolean zzaLA = new AtomicBoolean();
  private final AtomicBoolean zzaLB = new AtomicBoolean();
  private boolean zzady = false;
  
  public static void zza(Application paramApplication)
  {
    synchronized (zzaLz)
    {
      if (!zzaLz.zzady)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzaLz);
        paramApplication.registerComponentCallbacks(zzaLz);
        zzaLz.zzady = true;
      }
      return;
    }
  }
  
  private void zzas(boolean paramBoolean)
  {
    synchronized (zzaLz)
    {
      Iterator localIterator = this.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((zza)localIterator.next()).zzas(paramBoolean);
      }
    }
  }
  
  public static zzyq zzxn()
  {
    return zzaLz;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.zzaLA.compareAndSet(true, false);
    this.zzaLB.set(true);
    if (bool) {
      zzas(false);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.zzaLA.compareAndSet(true, false);
    this.zzaLB.set(true);
    if (bool) {
      zzas(false);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.zzaLA.compareAndSet(false, true)))
    {
      this.zzaLB.set(true);
      zzas(true);
    }
  }
  
  public void zza(zza paramzza)
  {
    synchronized (zzaLz)
    {
      this.mListeners.add(paramzza);
      return;
    }
  }
  
  @TargetApi(16)
  public boolean zzar(boolean paramBoolean)
  {
    if (!this.zzaLB.get())
    {
      if (!zzt.zzAT()) {
        return paramBoolean;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!this.zzaLB.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
        this.zzaLA.set(true);
      }
    }
    paramBoolean = zzxo();
    return paramBoolean;
  }
  
  public boolean zzxo()
  {
    return this.zzaLA.get();
  }
  
  public static abstract interface zza
  {
    public abstract void zzas(boolean paramBoolean);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */