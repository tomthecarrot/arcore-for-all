package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzf
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzde.toString();
  private final Context mContext;
  
  public zzf(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    return zzcw.zzab(this.mContext.getPackageName());
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */