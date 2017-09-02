package com.google.android.gms.tagmanager.resources.network;

import android.content.Context;
import com.google.android.gms.internal.zzbpf;
import com.google.android.gms.tagmanager.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzg
{
  private boolean mClosed;
  private String zzctL = null;
  private final ScheduledExecutorService zzcvM;
  private ScheduledFuture<?> zzcvO = null;
  
  public zzg()
  {
    this(Executors.newSingleThreadScheduledExecutor());
  }
  
  public zzg(String paramString)
  {
    this(Executors.newSingleThreadScheduledExecutor());
    this.zzctL = paramString;
  }
  
  zzg(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzcvM = paramScheduledExecutorService;
    this.mClosed = false;
  }
  
  public void zza(Context paramContext, zzbpf paramzzbpf, long paramLong, zze paramzze)
  {
    for (;;)
    {
      try
      {
        Log.v("ResourceLoaderScheduler: Loading new resource.");
        if (this.zzcvO != null) {
          return;
        }
        if (this.zzctL != null)
        {
          paramContext = new zzf(paramContext, paramzzbpf, paramzze, this.zzctL);
          this.zzcvO = this.zzcvM.schedule(paramContext, paramLong, TimeUnit.MILLISECONDS);
          return;
        }
      }
      finally {}
      paramContext = new zzf(paramContext, paramzzbpf, paramzze);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/resources/network/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */