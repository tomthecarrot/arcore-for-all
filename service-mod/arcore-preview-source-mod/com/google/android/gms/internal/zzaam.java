package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzaam
  extends Fragment
  implements zzzt
{
  private static WeakHashMap<FragmentActivity, WeakReference<zzaam>> zzaOv = new WeakHashMap();
  private int zzJD = 0;
  private Map<String, zzzs> zzaOw = new ArrayMap();
  private Bundle zzauM;
  
  public static zzaam zzb(FragmentActivity paramFragmentActivity)
  {
    Object localObject = (WeakReference)zzaOv.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (zzaam)((WeakReference)localObject).get();
      if (localObject != null) {
        return (zzaam)localObject;
      }
    }
    try
    {
      zzaam localzzaam = (zzaam)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (localzzaam != null)
      {
        localObject = localzzaam;
        if (!localzzaam.isRemoving()) {}
      }
      else
      {
        localObject = new zzaam();
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment)localObject, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzaOv.put(paramFragmentActivity, new WeakReference(localObject));
      return (zzaam)localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
    }
  }
  
  private void zzb(final String paramString, @NonNull final zzzs paramzzzs)
  {
    if (this.zzJD > 0) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          zzzs localzzzs;
          if (zzaam.zza(zzaam.this) >= 1)
          {
            localzzzs = paramzzzs;
            if (zzaam.zzb(zzaam.this) == null) {
              break label101;
            }
          }
          label101:
          for (Bundle localBundle = zzaam.zzb(zzaam.this).getBundle(paramString);; localBundle = null)
          {
            localzzzs.onCreate(localBundle);
            if (zzaam.zza(zzaam.this) >= 2) {
              paramzzzs.onStart();
            }
            if (zzaam.zza(zzaam.this) >= 3) {
              paramzzzs.onStop();
            }
            if (zzaam.zza(zzaam.this) >= 4) {
              paramzzzs.onDestroy();
            }
            return;
          }
        }
      });
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzaOw.values().iterator();
    while (localIterator.hasNext()) {
      ((zzzs)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzaOw.values().iterator();
    while (localIterator.hasNext()) {
      ((zzzs)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzJD = 1;
    this.zzauM = paramBundle;
    Iterator localIterator = this.zzaOw.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzzs localzzzs = (zzzs)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {}
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());; localObject = null)
      {
        localzzzs.onCreate((Bundle)localObject);
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.zzJD = 4;
    Iterator localIterator = this.zzaOw.values().iterator();
    while (localIterator.hasNext()) {
      ((zzzs)localIterator.next()).onDestroy();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.zzaOw.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((zzzs)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.zzJD = 2;
    Iterator localIterator = this.zzaOw.values().iterator();
    while (localIterator.hasNext()) {
      ((zzzs)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.zzJD = 3;
    Iterator localIterator = this.zzaOw.values().iterator();
    while (localIterator.hasNext()) {
      ((zzzs)localIterator.next()).onStop();
    }
  }
  
  public <T extends zzzs> T zza(String paramString, Class<T> paramClass)
  {
    return (zzzs)paramClass.cast(this.zzaOw.get(paramString));
  }
  
  public void zza(String paramString, @NonNull zzzs paramzzzs)
  {
    if (!this.zzaOw.containsKey(paramString))
    {
      this.zzaOw.put(paramString, paramzzzs);
      zzb(paramString, paramzzzs);
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }
  
  public FragmentActivity zzyO()
  {
    return getActivity();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */