package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;

public final class zzyp
{
  private final ArrayMap<zzyn<?>, ConnectionResult> zzaKq = new ArrayMap();
  private final TaskCompletionSource<Void> zzaLw = new TaskCompletionSource();
  private int zzaLx;
  private boolean zzaLy = false;
  
  public zzyp(Iterable<? extends zzd<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      zzd localzzd = (zzd)paramIterable.next();
      this.zzaKq.put(localzzd.getApiKey(), null);
    }
    this.zzaLx = this.zzaKq.keySet().size();
  }
  
  public Task<Void> getTask()
  {
    return this.zzaLw.getTask();
  }
  
  public void zza(zzyn<?> paramzzyn, ConnectionResult paramConnectionResult)
  {
    this.zzaKq.put(paramzzyn, paramConnectionResult);
    this.zzaLx -= 1;
    if (!paramConnectionResult.isSuccess()) {
      this.zzaLy = true;
    }
    if (this.zzaLx == 0)
    {
      if (this.zzaLy)
      {
        paramzzyn = new zzb(this.zzaKq);
        this.zzaLw.setException(paramzzyn);
      }
    }
    else {
      return;
    }
    this.zzaLw.setResult(null);
  }
  
  public Set<zzyn<?>> zzxl()
  {
    return this.zzaKq.keySet();
  }
  
  public void zzxm()
  {
    this.zzaLw.setResult(null);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */