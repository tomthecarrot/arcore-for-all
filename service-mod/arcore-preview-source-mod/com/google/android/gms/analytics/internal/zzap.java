package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzap
  extends zzd
{
  protected boolean zzabu;
  protected String zzacB;
  protected String zzacC;
  protected int zzaeL;
  protected int zzaeX;
  protected boolean zzafO;
  protected boolean zzafP;
  
  public zzap(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private static int zzbM(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ("verbose".equals(paramString)) {
      return 0;
    }
    if ("info".equals(paramString)) {
      return 1;
    }
    if ("warning".equals(paramString)) {
      return 2;
    }
    if ("error".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  public String getAppName()
  {
    zznA();
    return this.zzacB;
  }
  
  public String getAppVersion()
  {
    zznA();
    return this.zzacC;
  }
  
  protected void onInitialize()
  {
    zzpZ();
  }
  
  void zza(zzaa paramzzaa)
  {
    zzbr("Loading global XML config values");
    String str;
    if (paramzzaa.zzpf())
    {
      str = paramzzaa.getAppName();
      this.zzacB = str;
      zzb("XML config - app name", str);
    }
    if (paramzzaa.zzpg())
    {
      str = paramzzaa.getAppVersion();
      this.zzacC = str;
      zzb("XML config - app version", str);
    }
    int i;
    if (paramzzaa.zzph())
    {
      i = zzbM(paramzzaa.zzpi());
      if (i >= 0)
      {
        this.zzaeL = i;
        zza("XML config - log level", Integer.valueOf(i));
      }
    }
    if (paramzzaa.zzpj())
    {
      i = paramzzaa.zzpk();
      this.zzaeX = i;
      this.zzafO = true;
      zzb("XML config - dispatch period (sec)", Integer.valueOf(i));
    }
    if (paramzzaa.zzpl())
    {
      boolean bool = paramzzaa.zzpm();
      this.zzabu = bool;
      this.zzafP = true;
      zzb("XML config - dry run", Boolean.valueOf(bool));
    }
  }
  
  public int zzpY()
  {
    zznA();
    return this.zzaeX;
  }
  
  protected void zzpZ()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
      if (localObject1 == null)
      {
        zzbu("Couldn't get ApplicationInfo to load global config");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject2;
      do
      {
        int i;
        do
        {
          do
          {
            for (;;)
            {
              zzd("PackageManager doesn't know about the app package", localNameNotFoundException);
              localObject2 = null;
            }
            localObject2 = ((ApplicationInfo)localObject2).metaData;
          } while (localObject2 == null);
          i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
        } while (i <= 0);
        localObject2 = (zzaa)new zzz(zznp()).zzaB(i);
      } while (localObject2 == null);
      zza((zzaa)localObject2);
    }
  }
  
  public boolean zzph()
  {
    zznA();
    return false;
  }
  
  public boolean zzpj()
  {
    zznA();
    return this.zzafO;
  }
  
  public boolean zzpl()
  {
    zznA();
    return this.zzafP;
  }
  
  public boolean zzpm()
  {
    zznA();
    return this.zzabu;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */