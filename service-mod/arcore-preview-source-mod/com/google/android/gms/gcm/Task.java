package com.google.android.gms.gcm;

import android.app.Service;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.CallSuper;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.Set;

public abstract class Task
  implements ReflectedParcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle mExtras;
  private final String mTag;
  private final String zzbxL;
  private final boolean zzbxM;
  private final boolean zzbxN;
  private final int zzbxO;
  private final boolean zzbxP;
  private final boolean zzbxQ;
  private final RetryStrategy zzbxR;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    Log.e("Task", "Constructing a Task object using a parcel.");
    this.zzbxL = paramParcel.readString();
    this.mTag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.zzbxM = bool1;
      if (paramParcel.readInt() != 1) {
        break label93;
      }
    }
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzbxN = bool1;
      this.zzbxO = 2;
      this.zzbxP = false;
      this.zzbxQ = false;
      this.zzbxR = RetryStrategy.PRESET_EXPONENTIAL;
      this.mExtras = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Builder paramBuilder)
  {
    this.zzbxL = paramBuilder.gcmTaskService;
    this.mTag = paramBuilder.tag;
    this.zzbxM = paramBuilder.updateCurrent;
    this.zzbxN = paramBuilder.isPersisted;
    this.zzbxO = paramBuilder.requiredNetworkState;
    this.zzbxP = paramBuilder.requiresCharging;
    this.zzbxQ = false;
    this.mExtras = paramBuilder.extras;
    if (paramBuilder.retryStrategy != null) {}
    for (paramBuilder = paramBuilder.retryStrategy;; paramBuilder = RetryStrategy.PRESET_EXPONENTIAL)
    {
      this.zzbxR = paramBuilder;
      return;
    }
  }
  
  private static boolean zzO(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean));
  }
  
  public static void zzT(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject1 = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject1, 0);
      int i = ((Parcel)localObject1).dataSize();
      if (i > 10240)
      {
        ((Parcel)localObject1).recycle();
        paramBundle = String.valueOf("Extras exceeding maximum size(10240 bytes): ");
        throw new IllegalArgumentException(String.valueOf(paramBundle).length() + 11 + paramBundle + i);
      }
      ((Parcel)localObject1).recycle();
      localObject1 = paramBundle.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = paramBundle.get((String)((Iterator)localObject1).next());
        if (!zzO(localObject2)) {
          if ((localObject2 instanceof Bundle)) {
            zzT((Bundle)localObject2);
          } else {
            throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
          }
        }
      }
    }
  }
  
  public static void zza(RetryStrategy paramRetryStrategy)
  {
    if (paramRetryStrategy != null)
    {
      int i = paramRetryStrategy.getRetryPolicy();
      if ((i != 1) && (i != 0)) {
        throw new IllegalArgumentException(45 + "Must provide a valid RetryPolicy: " + i);
      }
      int j = paramRetryStrategy.getInitialBackoffSeconds();
      int k = paramRetryStrategy.getMaximumBackoffSeconds();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException(52 + "InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j)
      {
        i = paramRetryStrategy.getMaximumBackoffSeconds();
        throw new IllegalArgumentException(77 + "MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + i);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public int getRequiredNetwork()
  {
    return this.zzbxO;
  }
  
  public boolean getRequiresCharging()
  {
    return this.zzbxP;
  }
  
  public RetryStrategy getRetryStrategy()
  {
    return this.zzbxR;
  }
  
  public String getServiceName()
  {
    return this.zzbxL;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public boolean isPersisted()
  {
    return this.zzbxN;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.zzbxM;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", this.mTag);
    paramBundle.putBoolean("update_current", this.zzbxM);
    paramBundle.putBoolean("persisted", this.zzbxN);
    paramBundle.putString("service", this.zzbxL);
    paramBundle.putInt("requiredNetwork", this.zzbxO);
    paramBundle.putBoolean("requiresCharging", this.zzbxP);
    paramBundle.putBoolean("requiresIdle", false);
    paramBundle.putBundle("retryStrategy", this.zzbxR.zzS(new Bundle()));
    paramBundle.putBundle("extras", this.mExtras);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.zzbxL);
    paramParcel.writeString(this.mTag);
    if (this.zzbxM)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.zzbxN) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract class Builder
  {
    protected Bundle extras;
    protected String gcmTaskService;
    protected boolean isPersisted;
    protected int requiredNetworkState;
    protected boolean requiresCharging;
    protected RetryStrategy retryStrategy = RetryStrategy.PRESET_EXPONENTIAL;
    protected String tag;
    protected boolean updateCurrent;
    
    public abstract Task build();
    
    @CallSuper
    protected void checkConditions()
    {
      if (this.gcmTaskService != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
        GcmNetworkManager.zzet(this.tag);
        Task.zza(this.retryStrategy);
        if (this.isPersisted) {
          Task.zzT(this.extras);
        }
        return;
      }
    }
    
    public abstract Builder setExtras(Bundle paramBundle);
    
    public abstract Builder setPersisted(boolean paramBoolean);
    
    public abstract Builder setRequiredNetwork(int paramInt);
    
    public abstract Builder setRequiresCharging(boolean paramBoolean);
    
    public abstract Builder setRetryStrategy(RetryStrategy paramRetryStrategy);
    
    public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
    
    public abstract Builder setServiceUnchecked(Class<? extends Service> paramClass);
    
    public abstract Builder setTag(String paramString);
    
    public abstract Builder setUpdateCurrent(boolean paramBoolean);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */