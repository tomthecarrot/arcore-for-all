package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzp
  extends FunctionCallImplementation
{
  private static final String ID = zzah.zzdl.toString();
  private final String zzafX;
  
  public zzp(String paramString)
  {
    super(ID, new String[0]);
    this.zzafX = paramString;
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    if (this.zzafX == null) {
      return zzcw.zzYL();
    }
    return zzcw.zzab(this.zzafX);
  }
  
  public boolean isCacheable()
  {
    return true;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */