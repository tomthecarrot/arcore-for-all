package com.google.android.gms.gcm;

import android.os.Bundle;
import android.support.annotation.IntRange;
import com.google.android.gms.common.internal.zzac;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RetryStrategy
{
  public static final int MINIMUM_LINEAR_INITIAL_BACKOFF_SECONDS = 10;
  public static final RetryStrategy PRESET_EXPONENTIAL = new RetryStrategy(0, 30, 3600);
  public static final RetryStrategy PRESET_LINEAR = new RetryStrategy(1, 30, 3600);
  public static final int RETRY_POLICY_EXPONENTIAL = 0;
  public static final int RETRY_POLICY_LINEAR = 1;
  private final int zzbxI;
  private final int zzbxJ;
  private final int zzbxK;
  
  private RetryStrategy(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzbxI = paramInt1;
    this.zzbxJ = paramInt2;
    this.zzbxK = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof RetryStrategy)) {
        return false;
      }
      paramObject = (RetryStrategy)paramObject;
    } while ((((RetryStrategy)paramObject).zzbxI == this.zzbxI) && (((RetryStrategy)paramObject).zzbxJ == this.zzbxJ) && (((RetryStrategy)paramObject).zzbxK == this.zzbxK));
    return false;
  }
  
  public int getInitialBackoffSeconds()
  {
    return this.zzbxJ;
  }
  
  public int getMaximumBackoffSeconds()
  {
    return this.zzbxK;
  }
  
  public int getRetryPolicy()
  {
    return this.zzbxI;
  }
  
  public int hashCode()
  {
    return ((this.zzbxI + 1 ^ 0xF4243) * 1000003 ^ this.zzbxJ) * 1000003 ^ this.zzbxK;
  }
  
  public String toString()
  {
    int i = this.zzbxI;
    int j = this.zzbxJ;
    int k = this.zzbxK;
    return 74 + "policy=" + i + " initial_backoff=" + j + " maximum_backoff=" + k;
  }
  
  public Bundle zzS(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", this.zzbxI);
    paramBundle.putInt("initial_backoff_seconds", this.zzbxJ);
    paramBundle.putInt("maximum_backoff_seconds", this.zzbxK);
    return paramBundle;
  }
  
  public static class Builder
  {
    private int zzbxI;
    private int zzbxJ;
    private int zzbxK;
    
    private void checkConditions()
    {
      boolean bool2 = true;
      if ((this.zzbxI == 0) || (this.zzbxI == 1))
      {
        bool1 = true;
        zzac.zzb(bool1, "Must provide a valid RetryPolicy.");
        if (this.zzbxI != 0) {
          break label77;
        }
        if (this.zzbxJ <= 0) {
          break label72;
        }
        bool1 = true;
        label41:
        zzac.zzb(bool1, "RETRY_POLICY_EXPONENTIAL must have a positive initialBackoffSeconds.");
        if (this.zzbxK <= this.zzbxJ) {
          break label102;
        }
      }
      label72:
      label77:
      label102:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzac.zzb(bool1, "MaximumBackoffSeconds must be greater than InitialBackoffSeconds.");
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label41;
        if (this.zzbxJ >= 10) {}
        for (bool1 = true;; bool1 = false)
        {
          zzac.zzb(bool1, "RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
          break;
        }
      }
    }
    
    public RetryStrategy build()
    {
      checkConditions();
      return new RetryStrategy(this.zzbxI, this.zzbxJ, this.zzbxK, null);
    }
    
    public Builder setInitialBackoffSeconds(@IntRange(from=1L) int paramInt)
    {
      this.zzbxJ = paramInt;
      return this;
    }
    
    public Builder setMaximumBackoffSeconds(@IntRange(from=1L) int paramInt)
    {
      this.zzbxK = paramInt;
      return this;
    }
    
    public Builder setRetryPolicy(int paramInt)
    {
      this.zzbxI = paramInt;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RetryPolicy {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/RetryStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */