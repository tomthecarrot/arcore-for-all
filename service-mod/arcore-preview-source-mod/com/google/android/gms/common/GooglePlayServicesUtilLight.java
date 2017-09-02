package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzy;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight
{
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 10298000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean zzaKc = false;
  public static boolean zzaKd = false;
  static boolean zzaKe = false;
  private static boolean zzaKf = false;
  static final AtomicBoolean zzaKg = new AtomicBoolean();
  private static final AtomicBoolean zzaKh = new AtomicBoolean();
  
  public static void enableUsingApkIndependentContext()
  {
    zzaKh.set(true);
  }
  
  @Deprecated
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return paramContext.versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }
  
  @Deprecated
  public static int getClientVersion(Context paramContext)
  {
    zzac.zzav(true);
    return zzd.zzE(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  @Deprecated
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Object localObject = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
    try
    {
      InputStream localInputStream = paramContext.getContentResolver().openInputStream((Uri)localObject);
      try
      {
        paramContext = new Scanner(localInputStream).useDelimiter("\\A").next();
        localObject = paramContext;
        if (localInputStream != null)
        {
          localInputStream.close();
          return paramContext;
        }
      }
      catch (NoSuchElementException paramContext)
      {
        paramContext = paramContext;
        if (localInputStream == null) {
          break label97;
        }
        localInputStream.close();
        break label97;
      }
      finally
      {
        paramContext = finally;
        if (localInputStream != null) {
          localInputStream.close();
        }
        throw paramContext;
      }
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = null;
    }
    label97:
    return null;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    return (zzaQ(paramContext)) || (!zzwP());
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo;
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzaP(paramContext);
      }
      if ((!zzi.zzbh(paramContext)) && (!zzi.zzbj(paramContext)))
      {
        i = 1;
        localObject = null;
        if (i == 0) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Object localObject;
          Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
          return 9;
        }
        try
        {
          localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          paramContext = GoogleSignatureVerifier.getInstance(paramContext);
          if (i == 0) {
            break label181;
          }
          localObject = paramContext.zza((PackageInfo)localObject, zze.zzd.zzaKb);
          if (localObject != null) {
            break label152;
          }
          Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
        localThrowable = localThrowable;
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        continue;
        i = 0;
      }
    }
    label152:
    if (paramContext.zza(localPackageInfo, new zze.zza[] { localThrowable }) == null)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
      return 9;
      label181:
      if (paramContext.zza(localPackageInfo, zze.zzd.zzaKb) == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
    }
    int i = zzl.zzgw(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    if (zzl.zzgw(localPackageInfo.versionCode) < i)
    {
      i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
      int j = localPackageInfo.versionCode;
      Log.w("GooglePlayServicesUtil", 77 + "Google Play services out of date.  Requires " + i + " but found " + j);
      return 2;
    }
    ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
    paramContext = localApplicationInfo;
    if (localApplicationInfo == null) {}
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!paramContext.enabled) {
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
      return 1;
    }
    return 0;
  }
  
  @Deprecated
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return zzB(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return zzB(paramContext, "com.android.vending");
    }
    return false;
  }
  
  @Deprecated
  public static boolean isSidewinderDevice(Context paramContext)
  {
    return zzi.zzbi(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  static boolean zzB(Context paramContext, String paramString)
  {
    boolean bool = paramString.equals("com.google.android.gms");
    if (zzt.zzAZ())
    {
      localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
          return true;
        }
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool) {
        return paramString.enabled;
      }
      if (paramString.enabled)
      {
        bool = zzaR(paramContext);
        if (bool) {}
      }
      for (bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  @Deprecated
  public static void zzaO(Context paramContext)
  {
    if (zzaKg.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext.cancel(10436);
          return;
        }
      }
      catch (SecurityException paramContext) {}
    }
  }
  
  private static void zzaP(Context paramContext)
  {
    if (zzaKh.get()) {}
    int i;
    do
    {
      return;
      i = zzz.zzbd(paramContext);
      if (i == 0) {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    } while (i == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    int j = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    paramContext = String.valueOf("com.google.android.gms.version");
    throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + j + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  public static boolean zzaQ(Context paramContext)
  {
    zzaS(paramContext);
    return zzaKe;
  }
  
  @TargetApi(18)
  public static boolean zzaR(Context paramContext)
  {
    if (zzt.zzAV())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  private static void zzaS(Context paramContext)
  {
    if (!zzaKf) {
      zzaT(paramContext);
    }
  }
  
  /* Error */
  private static void zzaT(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 446	com/google/android/gms/internal/zzaca:zzbp	(Landroid/content/Context;)Lcom/google/android/gms/internal/zzabz;
    //   4: ldc 8
    //   6: bipush 64
    //   8: invokevirtual 449	com/google/android/gms/internal/zzabz:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +35 -> 48
    //   16: aload_0
    //   17: invokestatic 243	com/google/android/gms/common/GoogleSignatureVerifier:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray 264	com/google/android/gms/common/zze$zza
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 249	com/google/android/gms/common/zze$zzd:zzaKb	[Lcom/google/android/gms/common/zze$zza;
    //   30: iconst_1
    //   31: aaload
    //   32: aastore
    //   33: invokevirtual 253	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zze$zza;)Lcom/google/android/gms/common/zze$zza;
    //   36: ifnull +12 -> 48
    //   39: iconst_1
    //   40: putstatic 33	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaKe	Z
    //   43: iconst_1
    //   44: putstatic 35	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaKf	Z
    //   47: return
    //   48: iconst_0
    //   49: putstatic 33	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaKe	Z
    //   52: goto -9 -> 43
    //   55: astore_0
    //   56: ldc 74
    //   58: ldc_w 451
    //   61: aload_0
    //   62: invokestatic 453	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   65: pop
    //   66: iconst_1
    //   67: putstatic 35	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaKf	Z
    //   70: return
    //   71: astore_0
    //   72: iconst_1
    //   73: putstatic 35	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaKf	Z
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramContext	Context
    //   11	10	1	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   0	12	55	android/content/pm/PackageManager$NameNotFoundException
    //   16	43	55	android/content/pm/PackageManager$NameNotFoundException
    //   48	52	55	android/content/pm/PackageManager$NameNotFoundException
    //   0	12	71	finally
    //   16	43	71	finally
    //   48	52	71	finally
    //   56	66	71	finally
  }
  
  @Deprecated
  public static void zzau(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", 57 + "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  @TargetApi(19)
  public static boolean zzb(Context paramContext, int paramInt, String paramString)
  {
    return zzy.zzb(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    return zzy.zzf(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zzwP()
  {
    return zzi.zzAN();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */