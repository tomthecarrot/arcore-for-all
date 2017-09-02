package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;

@TargetApi(14)
class zzk
  implements Application.ActivityLifecycleCallbacks
{
  private boolean zzbMp;
  private DataLayer zzctf;
  
  zzk(DataLayer paramDataLayer)
  {
    this.zzctf = paramDataLayer;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.zzctf.push(DataLayer.mapOf(new Object[] { "event", "gtm.activity_started", "gtm.activity_screen_name", paramActivity.getClass().getCanonicalName() }));
  }
  
  public void onActivityStopped(Activity paramActivity) {}
  
  void zzb(Application paramApplication)
  {
    int i = Build.VERSION.SDK_INT;
    if (!this.zzbMp)
    {
      paramApplication.registerActivityLifecycleCallbacks(this);
      this.zzbMp = true;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */