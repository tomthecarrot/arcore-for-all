package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzc
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdd.toString();
  private final zza zzcsX;
  
  public zzc(Context paramContext)
  {
    this(zza.zzcb(paramContext));
  }
  
  zzc(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzcsX = paramzza;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    if (!this.zzcsX.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return zzcw.zzab(Boolean.valueOf(bool));
    }
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */