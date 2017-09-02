package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzzo
{
  private static zzzo zzaOp;
  private static final Object zzuq = new Object();
  private final String mAppId;
  private final Status zzaOq;
  private final boolean zzaOr;
  private final boolean zzaOs;
  
  zzzo(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    if (i != 0) {
      if (((Resources)localObject).getInteger(i) != 0)
      {
        bool1 = true;
        if (bool1) {
          break label127;
        }
      }
    }
    label52:
    for (this.zzaOs = bool2;; this.zzaOs = false)
    {
      this.zzaOr = bool1;
      String str = zzz.zzbc(paramContext);
      localObject = str;
      if (str == null) {
        localObject = new zzam(paramContext).getString("google_app_id");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label141;
      }
      this.zzaOq = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.mAppId = null;
      return;
      bool1 = false;
      break;
      label127:
      bool2 = false;
      break label52;
    }
    label141:
    this.mAppId = ((String)localObject);
    this.zzaOq = Status.zzaLc;
  }
  
  public static Status zzaW(Context paramContext)
  {
    zzac.zzb(paramContext, "Context must not be null.");
    synchronized (zzuq)
    {
      if (zzaOp == null) {
        zzaOp = new zzzo(paramContext);
      }
      paramContext = zzaOp.zzaOq;
      return paramContext;
    }
  }
  
  private static zzzo zzcJ(String paramString)
  {
    synchronized (zzuq)
    {
      if (zzaOp == null) {
        throw new IllegalStateException(String.valueOf(paramString).length() + 34 + "Initialize must be called before " + paramString + ".");
      }
    }
    paramString = zzaOp;
    return paramString;
  }
  
  public static String zzyC()
  {
    return zzcJ("getGoogleAppId").mAppId;
  }
  
  public static boolean zzyD()
  {
    return zzcJ("isMeasurementExplicitlyDisabled").zzaOs;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */