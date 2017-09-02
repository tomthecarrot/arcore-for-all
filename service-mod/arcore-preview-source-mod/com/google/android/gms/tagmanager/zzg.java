package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzg
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdf.toString();
  private final Context mContext;
  
  public zzg(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    try
    {
      paramMap = this.mContext.getPackageManager();
      paramMap = zzcw.zzab(paramMap.getApplicationLabel(paramMap.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      Log.e("App name is not found.", paramMap);
    }
    return zzcw.zzYL();
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */