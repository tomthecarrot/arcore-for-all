package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.data.DeviceInfo;
import com.google.android.gms.analytics.zzh;

public class zzv
  extends zzd
{
  zzv(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  protected void onInitialize() {}
  
  public DeviceInfo zzpa()
  {
    zznA();
    return zznt().zzmV();
  }
  
  public String zzpb()
  {
    zznA();
    DeviceInfo localDeviceInfo = zzpa();
    int i = localDeviceInfo.getScreenWidth();
    int j = localDeviceInfo.getScreenHeight();
    return 23 + i + "x" + j;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */