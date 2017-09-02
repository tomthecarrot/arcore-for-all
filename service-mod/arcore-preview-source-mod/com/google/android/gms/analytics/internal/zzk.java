package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.data.AppInfo;
import com.google.android.gms.analytics.zzh;

public class zzk
  extends zzd
{
  private final AppInfo zzabW = new AppInfo();
  
  zzk(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  protected void onInitialize()
  {
    zznt().zzmU().mergeTo(this.zzabW);
    zzmC();
  }
  
  public void zzmC()
  {
    Object localObject = zzmG();
    String str = ((zzap)localObject).getAppName();
    if (str != null) {
      this.zzabW.setAppName(str);
    }
    localObject = ((zzap)localObject).getAppVersion();
    if (localObject != null) {
      this.zzabW.setAppVersion((String)localObject);
    }
  }
  
  public AppInfo zznX()
  {
    zznA();
    return this.zzabW;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */