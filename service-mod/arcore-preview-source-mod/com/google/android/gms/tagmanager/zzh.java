package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzh
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdg.toString();
  private final Context mContext;
  
  public zzh(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    try
    {
      paramMap = zzcw.zzab(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramMap = String.valueOf(this.mContext.getPackageName());
      String str = String.valueOf(localNameNotFoundException.getMessage());
      Log.e(String.valueOf(paramMap).length() + 25 + String.valueOf(str).length() + "Package name " + paramMap + " not found. " + str);
    }
    return zzcw.zzYL();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */