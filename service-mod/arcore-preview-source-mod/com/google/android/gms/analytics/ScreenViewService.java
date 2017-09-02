package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.data.ScreenViewInfo;
import com.google.android.gms.analytics.internal.ActivityLifecycleTracker;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.List;

public class ScreenViewService
{
  private static final OnScreenViewListener[] zzacc = new OnScreenViewListener[0];
  private static ScreenViewService zzacd;
  private ScreenViewInfo zzace;
  private final List<OnScreenViewListener> zzacf;
  private ActivityLifecycleTracker zzacg;
  private final Application zzxl;
  
  private ScreenViewService(Application paramApplication)
  {
    zzac.zzC(paramApplication);
    this.zzxl = paramApplication;
    this.zzacf = new ArrayList();
  }
  
  public static ScreenViewService getInstance(Context paramContext)
  {
    zzac.zzC(paramContext);
    paramContext = paramContext.getApplicationContext();
    if ((paramContext instanceof ContextWrapper)) {
      if ((paramContext instanceof Application)) {
        paramContext = (Application)paramContext;
      }
    }
    for (;;)
    {
      zzac.zzC(paramContext);
      try
      {
        if (zzacd == null) {
          zzacd = new ScreenViewService(paramContext);
        }
        paramContext = zzacd;
        return paramContext;
      }
      finally {}
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == paramContext)
      {
        Log.e("com.google.android.gms.analytics.ScreenViewService", "Invalid context provided. AutoScreenViewTracking not possible.");
        paramContext = null;
      }
      else
      {
        paramContext = localContext;
        break;
        paramContext = null;
      }
    }
  }
  
  private OnScreenViewListener[] zzmX()
  {
    synchronized (this.zzacf)
    {
      if (this.zzacf.isEmpty())
      {
        arrayOfOnScreenViewListener = zzacc;
        return arrayOfOnScreenViewListener;
      }
      OnScreenViewListener[] arrayOfOnScreenViewListener = (OnScreenViewListener[])this.zzacf.toArray(new OnScreenViewListener[this.zzacf.size()]);
      return arrayOfOnScreenViewListener;
    }
  }
  
  public void addScreenViewListener(OnScreenViewListener paramOnScreenViewListener)
  {
    zzac.zzC(paramOnScreenViewListener);
    synchronized (this.zzacf)
    {
      this.zzacf.remove(paramOnScreenViewListener);
      this.zzacf.add(paramOnScreenViewListener);
      return;
    }
  }
  
  @TargetApi(14)
  public void enableAutoScreenViewTracking(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (isAutoTrackingEnabled() == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      this.zzacg = new ActivityLifecycleTracker(this);
      this.zzxl.registerActivityLifecycleCallbacks(this.zzacg);
      return;
    }
    this.zzxl.unregisterActivityLifecycleCallbacks(this.zzacg);
    this.zzacg = null;
  }
  
  public ScreenViewInfo getCurrentScreenView()
  {
    return this.zzace;
  }
  
  public boolean isAutoTrackingEnabled()
  {
    return this.zzacg != null;
  }
  
  public void removeScreenViewListener(OnScreenViewListener paramOnScreenViewListener)
  {
    synchronized (this.zzacf)
    {
      this.zzacf.remove(paramOnScreenViewListener);
      return;
    }
  }
  
  public void startScreenView(ScreenViewInfo paramScreenViewInfo)
  {
    startScreenView(paramScreenViewInfo, null);
  }
  
  public void startScreenView(ScreenViewInfo paramScreenViewInfo, Activity paramActivity)
  {
    int j = 0;
    zzac.zzC(paramScreenViewInfo);
    OnScreenViewListener[] arrayOfOnScreenViewListener = null;
    int i;
    if (paramScreenViewInfo.isMutable())
    {
      if ((paramActivity instanceof ScreenNameProvider)) {
        ((ScreenNameProvider)paramActivity).onScreenViewInfoRequested(paramScreenViewInfo);
      }
      if (this.zzace != null)
      {
        paramScreenViewInfo.setReferrerScreenId(this.zzace.getScreenId());
        paramScreenViewInfo.setReferrerScreenName(this.zzace.getScreenName());
      }
      arrayOfOnScreenViewListener = zzmX();
      i = 0;
      while (i < arrayOfOnScreenViewListener.length)
      {
        arrayOfOnScreenViewListener[i].onScreenViewStarting(paramScreenViewInfo, paramActivity);
        i += 1;
      }
      paramScreenViewInfo.makeImmutable();
      if (!TextUtils.isEmpty(paramScreenViewInfo.getScreenName())) {}
    }
    for (;;)
    {
      return;
      if ((this.zzace != null) && (this.zzace.getScreenId() == paramScreenViewInfo.getScreenId()))
      {
        this.zzace = paramScreenViewInfo;
        return;
      }
      stopScreenView();
      this.zzace = paramScreenViewInfo;
      paramActivity = arrayOfOnScreenViewListener;
      i = j;
      if (arrayOfOnScreenViewListener == null)
      {
        paramActivity = zzmX();
        i = j;
      }
      while (i < paramActivity.length)
      {
        paramActivity[i].onScreenViewStarted(paramScreenViewInfo);
        i += 1;
      }
    }
  }
  
  public void startScreenView(String paramString)
  {
    zzac.zzdc(paramString);
    ScreenViewInfo localScreenViewInfo = new ScreenViewInfo(false);
    localScreenViewInfo.setScreenName(paramString);
    startScreenView(localScreenViewInfo, null);
  }
  
  public void stopScreenView()
  {
    this.zzace = null;
  }
  
  public static abstract interface OnScreenViewListener
  {
    public abstract void onScreenViewStarted(ScreenViewInfo paramScreenViewInfo);
    
    public abstract void onScreenViewStarting(ScreenViewInfo paramScreenViewInfo, Activity paramActivity);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/ScreenViewService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */