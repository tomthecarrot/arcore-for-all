package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class zzzx
{
  private final Set<zzzw<?>> zzawc = Collections.newSetFromMap(new WeakHashMap());
  
  public static <L> zzzw.zzb<L> zza(@NonNull L paramL, @NonNull String paramString)
  {
    zzac.zzb(paramL, "Listener must not be null");
    zzac.zzb(paramString, "Listener type must not be null");
    zzac.zzi(paramString, "Listener type must not be empty");
    return new zzzw.zzb(paramL, paramString);
  }
  
  public static <L> zzzw<L> zzb(@NonNull L paramL, @NonNull Looper paramLooper, @NonNull String paramString)
  {
    zzac.zzb(paramL, "Listener must not be null");
    zzac.zzb(paramLooper, "Looper must not be null");
    zzac.zzb(paramString, "Listener type must not be null");
    return new zzzw(paramLooper, paramL, paramString);
  }
  
  public void release()
  {
    Iterator localIterator = this.zzawc.iterator();
    while (localIterator.hasNext()) {
      ((zzzw)localIterator.next()).clear();
    }
    this.zzawc.clear();
  }
  
  public <L> zzzw<L> zza(@NonNull L paramL, @NonNull Looper paramLooper, @NonNull String paramString)
  {
    paramL = zzb(paramL, paramLooper, paramString);
    this.zzawc.add(paramL);
    return paramL;
  }
  
  public <L> zzzw<L> zzb(@NonNull L paramL, Looper paramLooper)
  {
    return zza(paramL, paramLooper, "NO_TYPE");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */