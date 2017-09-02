package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class FunctionCallImplementation
{
  private final Set<String> zzcuy;
  private final String zzcuz;
  
  public FunctionCallImplementation(String paramString, String... paramVarArgs)
  {
    this.zzcuz = paramString;
    this.zzcuy = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.zzcuy.add(paramString);
      i += 1;
    }
  }
  
  public static String getFunctionKey()
  {
    return "function";
  }
  
  public abstract zzak.zza evaluate(Map<String, zzak.zza> paramMap);
  
  public String getInstanceFunctionId()
  {
    return this.zzcuz;
  }
  
  public Set<String> getRequiredKeys()
  {
    return this.zzcuy;
  }
  
  public abstract boolean isCacheable();
  
  boolean zzf(Set<String> paramSet)
  {
    return paramSet.containsAll(this.zzcuy);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/FunctionCallImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */