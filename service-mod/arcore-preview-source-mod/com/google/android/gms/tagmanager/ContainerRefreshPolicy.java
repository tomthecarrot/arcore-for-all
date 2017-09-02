package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.zzac;
import java.util.Random;

public class ContainerRefreshPolicy
{
  @VisibleForTesting
  public static final int FIRST_ERROR_COUNTER_PENALTY = 3;
  @VisibleForTesting
  public static final int MAX_LOAD_COUNTERS = 10;
  @VisibleForTesting
  public static final String SHARED_PREFERENCES_PREFIX = "_gtmContainerRefreshPolicy_";
  private final Context mContext;
  private final Random zzAp;
  private final String zzcaK;
  
  public ContainerRefreshPolicy(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new Random());
  }
  
  @VisibleForTesting
  ContainerRefreshPolicy(Context paramContext, String paramString, Random paramRandom)
  {
    this.mContext = ((Context)zzac.zzC(paramContext));
    this.zzcaK = ((String)zzac.zzC(paramString));
    this.zzAp = paramRandom;
  }
  
  private SharedPreferences zzXq()
  {
    Context localContext = this.mContext;
    String str1 = String.valueOf("_gtmContainerRefreshPolicy_");
    String str2 = String.valueOf(this.zzcaK);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1)) {
      return localContext.getSharedPreferences(str1, 0);
    }
  }
  
  private long zzm(long paramLong1, long paramLong2)
  {
    SharedPreferences localSharedPreferences = zzXq();
    long l1 = Math.max(0L, localSharedPreferences.getLong("FORBIDDEN_COUNT", 0L));
    long l2 = Math.max(0L, localSharedPreferences.getLong("SUCCESSFUL_COUNT", 0L));
    paramLong2 = ((float)l1 / (float)(l2 + l1 + 1L) * (float)(paramLong2 - paramLong1));
    float f = this.zzAp.nextFloat();
    return ((float)(paramLong2 + paramLong1) * f);
  }
  
  public long getRefreshPeriodMilliseconds()
  {
    return 43200000L + zzm(7200000L, 259200000L);
  }
  
  public long getRetryPeriodMilliseconds()
  {
    return 3600000L + zzm(600000L, 86400000L);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void reportContainerForbiddenError()
  {
    Object localObject = zzXq();
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (l1 == 0L) {}
    for (l1 = 3L;; l1 = Math.min(10L, 1L + l1))
    {
      l2 = Math.max(0L, Math.min(l2, 10L - l1));
      ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
      ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
      zzcr.zza((SharedPreferences.Editor)localObject);
      return;
    }
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void reportContainerSuccessfulLoad()
  {
    Object localObject = zzXq();
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    l2 = Math.min(10L, l2 + 1L);
    l1 = Math.max(0L, Math.min(l1, 10L - l2));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
    ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
    zzcr.zza((SharedPreferences.Editor)localObject);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/ContainerRefreshPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */