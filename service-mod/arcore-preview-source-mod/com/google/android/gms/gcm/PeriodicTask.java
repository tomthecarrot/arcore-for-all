package com.google.android.gms.gcm;

import android.app.Service;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new Parcelable.Creator()
  {
    public PeriodicTask zzjf(Parcel paramAnonymousParcel)
    {
      return new PeriodicTask(paramAnonymousParcel, null);
    }
    
    public PeriodicTask[] zznd(int paramAnonymousInt)
    {
      return new PeriodicTask[paramAnonymousInt];
    }
  };
  protected long mFlexInSeconds = -1L;
  protected long mIntervalInSeconds = -1L;
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = Math.min(paramParcel.readLong(), this.mIntervalInSeconds);
  }
  
  private PeriodicTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.mIntervalInSeconds = Builder.zza(paramBuilder);
    this.mFlexInSeconds = Math.min(Builder.zzb(paramBuilder), this.mIntervalInSeconds);
  }
  
  public long getFlex()
  {
    return this.mFlexInSeconds;
  }
  
  public long getPeriod()
  {
    return this.mIntervalInSeconds;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
  }
  
  public String toString()
  {
    String str = String.valueOf(super.toString());
    long l1 = getPeriod();
    long l2 = getFlex();
    return String.valueOf(str).length() + 54 + str + " period=" + l1 + " flex=" + l2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzbxG = -1L;
    private long zzbxH = -1L;
    
    public Builder()
    {
      this.isPersisted = true;
    }
    
    public PeriodicTask build()
    {
      checkConditions();
      return new PeriodicTask(this, null);
    }
    
    protected void checkConditions()
    {
      super.checkConditions();
      if (this.zzbxG == -1L) {
        throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
      }
      if (this.zzbxG <= 0L)
      {
        long l = this.zzbxG;
        throw new IllegalArgumentException(66 + "Period set cannot be less than or equal to 0: " + l);
      }
      if (this.zzbxH == -1L) {
        this.zzbxH = (((float)this.zzbxG * 0.1F));
      }
      while (this.zzbxH <= this.zzbxG) {
        return;
      }
      this.zzbxH = this.zzbxG;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setFlex(long paramLong)
    {
      this.zzbxH = paramLong;
      return this;
    }
    
    public Builder setPeriod(long paramLong)
    {
      this.zzbxG = paramLong;
      return this;
    }
    
    public Builder setPersisted(boolean paramBoolean)
    {
      this.isPersisted = paramBoolean;
      return this;
    }
    
    public Builder setRequiredNetwork(int paramInt)
    {
      this.requiredNetworkState = paramInt;
      return this;
    }
    
    public Builder setRequiresCharging(boolean paramBoolean)
    {
      this.requiresCharging = paramBoolean;
      return this;
    }
    
    public Builder setRetryStrategy(RetryStrategy paramRetryStrategy)
    {
      this.retryStrategy = paramRetryStrategy;
      return this;
    }
    
    public Builder setService(Class<? extends GcmTaskService> paramClass)
    {
      this.gcmTaskService = paramClass.getName();
      return this;
    }
    
    public Builder setServiceUnchecked(Class<? extends Service> paramClass)
    {
      this.gcmTaskService = paramClass.getName();
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      this.tag = paramString;
      return this;
    }
    
    public Builder setUpdateCurrent(boolean paramBoolean)
    {
      this.updateCurrent = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/PeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */