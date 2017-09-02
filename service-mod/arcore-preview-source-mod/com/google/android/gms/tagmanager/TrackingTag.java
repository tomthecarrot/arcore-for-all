package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

abstract class TrackingTag
  extends FunctionCallImplementation
{
  public TrackingTag(String paramString, String... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public zzak.zza evaluate(Map<String, zzak.zza> paramMap)
  {
    evaluateTrackingTag(paramMap);
    return zzcw.zzYL();
  }
  
  public abstract void evaluateTrackingTag(Map<String, zzak.zza> paramMap);
  
  public boolean isCacheable()
  {
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/TrackingTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */