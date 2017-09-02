package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzi
{
  private static Boolean zzaUL;
  private static Boolean zzaUM;
  private static Boolean zzaUN;
  private static Boolean zzaUO;
  private static Boolean zzaUP;
  
  public static boolean zzAN()
  {
    boolean bool = GooglePlayServicesUtilLight.zzaKc;
    return "user".equals(Build.TYPE);
  }
  
  public static boolean zzb(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {
      return false;
    }
    if (zzaUL == null) {
      if ((paramResources.getConfiguration().screenLayout & 0xF) <= 3) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (zzc(paramResources))) {
        bool = true;
      }
      zzaUL = Boolean.valueOf(bool);
      return zzaUL.booleanValue();
    }
  }
  
  @TargetApi(20)
  public static boolean zzbg(Context paramContext)
  {
    if (zzaUN == null) {
      if ((!zzt.zzAX()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaUN = Boolean.valueOf(bool);
      return zzaUN.booleanValue();
    }
  }
  
  @TargetApi(24)
  public static boolean zzbh(Context paramContext)
  {
    return ((!zzt.isAtLeastN()) || (zzbi(paramContext))) && (zzbg(paramContext));
  }
  
  @TargetApi(21)
  public static boolean zzbi(Context paramContext)
  {
    if (zzaUO == null) {
      if ((!zzt.zzAZ()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      zzaUO = Boolean.valueOf(bool);
      return zzaUO.booleanValue();
    }
  }
  
  public static boolean zzbj(Context paramContext)
  {
    if (zzaUP == null) {
      zzaUP = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
    }
    return zzaUP.booleanValue();
  }
  
  private static boolean zzc(Resources paramResources)
  {
    if (zzaUM == null)
    {
      paramResources = paramResources.getConfiguration();
      if (((paramResources.screenLayout & 0xF) > 3) || (paramResources.smallestScreenWidthDp < 600)) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      zzaUM = Boolean.valueOf(bool);
      return zzaUM.booleanValue();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */