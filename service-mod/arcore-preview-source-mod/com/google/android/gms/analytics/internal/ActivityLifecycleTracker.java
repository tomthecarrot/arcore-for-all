package com.google.android.gms.analytics.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.ScreenViewService;
import com.google.android.gms.analytics.data.ScreenViewInfo;
import com.google.android.gms.common.internal.zzac;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public final class ActivityLifecycleTracker
  implements Application.ActivityLifecycleCallbacks
{
  private final ScreenViewService zzadh;
  private final Map<Activity, ScreenViewInfo> zzadi;
  
  public ActivityLifecycleTracker(ScreenViewService paramScreenViewService)
  {
    zzac.zzC(paramScreenViewService);
    this.zzadh = paramScreenViewService;
    this.zzadi = new HashMap();
  }
  
  public Map<Activity, ScreenViewInfo> getActivityScreenMap()
  {
    return this.zzadi;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("com.google.android.gms.measurement.screen_view");
    } while (paramBundle == null);
    int i = paramBundle.getInt("id");
    if (i <= 0)
    {
      Log.w("GAv4", "Invalid screenId in saved activity state");
      return;
    }
    paramActivity = zzb(paramActivity, i);
    paramActivity.setScreenName(paramBundle.getString("name"));
    paramActivity.setReferrerScreenId(paramBundle.getInt("referrer_id"));
    paramActivity.setReferrerScreenName(paramBundle.getString("referrer_name"));
    paramActivity.setInterstitial(paramBundle.getBoolean("interstitial"));
    paramActivity.makeImmutable();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    this.zzadi.remove(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramActivity = (ScreenViewInfo)this.zzadi.get(paramActivity);
    } while (paramActivity == null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramActivity.getScreenId());
    localBundle.putString("name", paramActivity.getScreenName());
    localBundle.putInt("referrer_id", paramActivity.getReferrerScreenId());
    localBundle.putString("referrer_name", paramActivity.getReferrerScreenName());
    localBundle.putBoolean("interstitial", paramActivity.isInterstitial());
    paramBundle.putBundle("com.google.android.gms.measurement.screen_view", localBundle);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    ScreenViewInfo localScreenViewInfo = zzb(paramActivity, 0);
    this.zzadh.startScreenView(localScreenViewInfo, paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
  
  ScreenViewInfo zzb(Activity paramActivity, int paramInt)
  {
    zzac.zzC(paramActivity);
    ScreenViewInfo localScreenViewInfo2 = (ScreenViewInfo)this.zzadi.get(paramActivity);
    ScreenViewInfo localScreenViewInfo1 = localScreenViewInfo2;
    if (localScreenViewInfo2 == null) {
      if (paramInt != 0) {
        break label66;
      }
    }
    label66:
    for (localScreenViewInfo1 = new ScreenViewInfo(true);; localScreenViewInfo1 = new ScreenViewInfo(true, paramInt))
    {
      localScreenViewInfo1.setScreenName(paramActivity.getClass().getCanonicalName());
      this.zzadi.put(paramActivity, localScreenViewInfo1);
      return localScreenViewInfo1;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/ActivityLifecycleTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */