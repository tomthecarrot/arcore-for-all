package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbh
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdQ.toString();
  private final Context mContext;
  
  public zzbh(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    paramMap = zzcd(this.mContext);
    if (paramMap == null) {
      return zzcw.zzYL();
    }
    return zzcw.zzab(paramMap);
  }
  
  public boolean isCacheable()
  {
    return true;
  }
  
  protected String zzcd(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */