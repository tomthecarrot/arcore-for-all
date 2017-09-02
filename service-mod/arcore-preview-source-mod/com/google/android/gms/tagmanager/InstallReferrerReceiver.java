package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver
  extends CampaignTrackingReceiver
{
  protected Class<? extends CampaignTrackingService> zzmy()
  {
    return InstallReferrerService.class;
  }
  
  protected void zzw(Context paramContext, String paramString)
  {
    InstallReferrerUtil.cacheInstallReferrer(paramString);
    InstallReferrerUtil.zzW(paramContext, paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/InstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */