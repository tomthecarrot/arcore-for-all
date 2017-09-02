package com.google.android.gms.common.api;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.internal.zzaan;
import com.google.android.gms.internal.zzzr;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class ResultStore
{
  private static final Map<Object, ResultStore> zzaLa = new WeakHashMap();
  private static final Object zzuq = new Object();
  
  @NonNull
  public static ResultStore getInstance(@NonNull Activity paramActivity, @NonNull GoogleApiClient paramGoogleApiClient)
  {
    return zza(new zzzr(paramActivity), paramGoogleApiClient);
  }
  
  private static ResultStore zza(FragmentActivity paramFragmentActivity)
  {
    android.support.v4.app.FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      zzaan localzzaan = (zzaan)localFragmentManager.findFragmentByTag("GmsResultStoreFragment");
      paramFragmentActivity = localzzaan;
      if (localzzaan == null)
      {
        paramFragmentActivity = new zzaan();
        localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsResultStoreFragment").commit();
      }
      return paramFragmentActivity.zzyJ();
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException(String.valueOf("GmsResultStoreFragment").length() + 42 + "Fragment tag " + "GmsResultStoreFragment" + " is reserved for ResultStore.");
    }
  }
  
  private static ResultStore zza(@NonNull zzzr paramzzzr, @NonNull GoogleApiClient paramGoogleApiClient)
  {
    synchronized (zzuq)
    {
      ResultStore localResultStore2 = (ResultStore)zzaLa.get(paramzzzr.zzyH());
      ResultStore localResultStore1 = localResultStore2;
      if (localResultStore2 == null)
      {
        if (paramzzzr.zzyE())
        {
          localResultStore1 = zza(paramzzzr.zzyG());
          zzaLa.put(paramzzzr.zzyH(), localResultStore1);
        }
      }
      else
      {
        paramGoogleApiClient.zza(localResultStore1);
        return localResultStore1;
      }
      localResultStore1 = zzs(paramzzzr.zzyF());
    }
  }
  
  private static ResultStore zzs(Activity paramActivity)
  {
    android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
    try
    {
      zzzv localzzzv = (zzzv)localFragmentManager.findFragmentByTag("GmsResultStoreFragment");
      paramActivity = localzzzv;
      if (localzzzv == null)
      {
        paramActivity = new zzzv();
        localFragmentManager.beginTransaction().add(paramActivity, "GmsResultStoreFragment").commit();
      }
      return paramActivity.zzyJ();
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException(String.valueOf("GmsResultStoreFragment").length() + 42 + "Fragment tag " + "GmsResultStoreFragment" + " is reserved for ResultStore.");
    }
  }
  
  protected static void zzv(Object paramObject)
  {
    synchronized (zzuq)
    {
      zzaLa.remove(paramObject);
      return;
    }
  }
  
  public abstract boolean hasPendingResult(int paramInt);
  
  public abstract void remove(int paramInt);
  
  public abstract void setResultCallbacks(int paramInt, @NonNull ResultCallbacks<?> paramResultCallbacks);
  
  public <R extends Result> void zza(int paramInt, @NonNull PendingResult<R> paramPendingResult)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/ResultStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */