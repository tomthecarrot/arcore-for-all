package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzb
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdc.toString();
  private final zza zzcsX;
  
  public zzb(Context paramContext)
  {
    this(zza.zzcb(paramContext));
  }
  
  zzb(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzcsX = paramzza;
    this.zzcsX.getAdvertiserId();
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    paramMap = this.zzcsX.getAdvertiserId();
    if (paramMap == null) {
      return zzcw.zzYL();
    }
    return zzcw.zzab(paramMap);
  }
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */