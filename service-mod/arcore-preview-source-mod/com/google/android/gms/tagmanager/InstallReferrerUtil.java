package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class InstallReferrerUtil
{
  private static String zzcuL;
  static Map<String, String> zzcuM = new HashMap();
  
  public static void addClickReferrer(Context paramContext, String paramString)
  {
    String str = extractComponent(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      zzcuM.put(str, paramString);
      zzcr.zze(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  public static void cacheInstallReferrer(String paramString)
  {
    try
    {
      zzcuL = paramString;
      return;
    }
    finally {}
  }
  
  public static String extractComponent(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      if (paramString1.length() > 0) {
        return paramString1;
      }
      return null;
    }
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() != 0) {}
    for (paramString1 = "http://hostname/?".concat(paramString1);; paramString1 = new String("http://hostname/?")) {
      return Uri.parse(paramString1).getQueryParameter(paramString2);
    }
  }
  
  public static String getClickReferrer(Context paramContext, String paramString1, String paramString2)
  {
    String str = (String)zzcuM.get(paramString1);
    Object localObject = str;
    if (str == null)
    {
      paramContext = paramContext.getSharedPreferences("gtm_click_referrers", 0);
      if (paramContext == null) {
        break label63;
      }
    }
    label63:
    for (paramContext = paramContext.getString(paramString1, "");; paramContext = "")
    {
      zzcuM.put(paramString1, paramContext);
      localObject = paramContext;
      return extractComponent((String)localObject, paramString2);
    }
  }
  
  /* Error */
  public static String getInstallReferrer(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 52	com/google/android/gms/tagmanager/InstallReferrerUtil:zzcuL	Ljava/lang/String;
    //   3: ifnonnull +40 -> 43
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 52	com/google/android/gms/tagmanager/InstallReferrerUtil:zzcuL	Ljava/lang/String;
    //   12: ifnonnull +28 -> 40
    //   15: aload_0
    //   16: ldc 96
    //   18: iconst_0
    //   19: invokevirtual 85	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull +27 -> 51
    //   27: aload_0
    //   28: ldc 98
    //   30: ldc 87
    //   32: invokeinterface 92 3 0
    //   37: putstatic 52	com/google/android/gms/tagmanager/InstallReferrerUtil:zzcuL	Ljava/lang/String;
    //   40: ldc 2
    //   42: monitorexit
    //   43: getstatic 52	com/google/android/gms/tagmanager/InstallReferrerUtil:zzcuL	Ljava/lang/String;
    //   46: aload_1
    //   47: invokestatic 28	com/google/android/gms/tagmanager/InstallReferrerUtil:extractComponent	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: areturn
    //   51: ldc 87
    //   53: putstatic 52	com/google/android/gms/tagmanager/InstallReferrerUtil:zzcuL	Ljava/lang/String;
    //   56: goto -16 -> 40
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   0	65	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	23	59	finally
    //   27	40	59	finally
    //   40	43	59	finally
    //   51	56	59	finally
    //   60	63	59	finally
  }
  
  static void zzW(Context paramContext, String paramString)
  {
    zzcr.zze(paramContext, "gtm_install_referrer", "referrer", paramString);
    addClickReferrer(paramContext, paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/InstallReferrerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */