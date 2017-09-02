package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class zzyz
{
  private final Map<zzyt<?>, Boolean> zzaMG = Collections.synchronizedMap(new WeakHashMap());
  private final Map<TaskCompletionSource<?>, Boolean> zzaMH = Collections.synchronizedMap(new WeakHashMap());
  
  private void zza(boolean paramBoolean, Status paramStatus)
  {
    Object localObject2;
    synchronized (this.zzaMG)
    {
      localObject2 = new HashMap(this.zzaMG);
    }
    synchronized (this.zzaMH)
    {
      ??? = new HashMap(this.zzaMH);
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue()))
        {
          ((zzyt)((Map.Entry)???).getKey()).zzQ(paramStatus);
          continue;
          paramStatus = finally;
          throw paramStatus;
        }
      }
    }
    ??? = ((Map)???).entrySet().iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)???).next();
      if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
        ((TaskCompletionSource)((Map.Entry)localObject2).getKey()).trySetException(new zza(paramStatus));
      }
    }
  }
  
  void zza(final zzyt<? extends Result> paramzzyt, boolean paramBoolean)
  {
    this.zzaMG.put(paramzzyt, Boolean.valueOf(paramBoolean));
    paramzzyt.zza(new PendingResult.zza()
    {
      public void zzM(Status paramAnonymousStatus)
      {
        zzyz.zza(zzyz.this).remove(paramzzyt);
      }
    });
  }
  
  <TResult> void zza(final TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    this.zzaMH.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener()
    {
      public void onComplete(@NonNull Task<TResult> paramAnonymousTask)
      {
        zzyz.zzb(zzyz.this).remove(paramTaskCompletionSource);
      }
    });
  }
  
  boolean zzxK()
  {
    return (!this.zzaMG.isEmpty()) || (!this.zzaMH.isEmpty());
  }
  
  public void zzxL()
  {
    zza(false, zzzl.zzaNQ);
  }
  
  public void zzxM()
  {
    zza(true, zzaar.zzaPd);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */