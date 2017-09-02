package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

public class BooleanResult
  implements Result
{
  private final boolean zzaKx;
  private final Status zzaiT;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.zzaiT = ((Status)zzac.zzb(paramStatus, "Status must not be null"));
    this.zzaKx = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((this.zzaiT.equals(((BooleanResult)paramObject).zzaiT)) && (this.zzaKx == ((BooleanResult)paramObject).zzaKx));
    return false;
  }
  
  public Status getStatus()
  {
    return this.zzaiT;
  }
  
  public boolean getValue()
  {
    return this.zzaKx;
  }
  
  public final int hashCode()
  {
    int j = this.zzaiT.hashCode();
    if (this.zzaKx) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */