package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

abstract class zzu
{
  private static volatile Handler zzaeM;
  private final zzf zzadx;
  private volatile long zzaeN;
  private final Runnable zzw;
  
  zzu(zzf paramzzf)
  {
    zzac.zzC(paramzzf);
    this.zzadx = paramzzf;
    this.zzw = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zzu.zza(zzu.this).zznt().zzg(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zzu.this.zzcJ();
          zzu.zza(zzu.this, 0L);
        } while (!bool);
        zzu.this.run();
      }
    };
  }
  
  private Handler getHandler()
  {
    if (zzaeM != null) {
      return zzaeM;
    }
    try
    {
      if (zzaeM == null) {
        zzaeM = new Handler(this.zzadx.getContext().getMainLooper());
      }
      Handler localHandler = zzaeM;
      return localHandler;
    }
    finally {}
  }
  
  public void cancel()
  {
    this.zzaeN = 0L;
    getHandler().removeCallbacks(this.zzw);
  }
  
  public abstract void run();
  
  public void zzC(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzaeN = this.zzadx.zznq().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzw, paramLong)) {
        this.zzadx.zznr().zze("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public void zzD(long paramLong)
  {
    long l = 0L;
    if (!zzcJ()) {
      return;
    }
    if (paramLong < 0L)
    {
      cancel();
      return;
    }
    paramLong -= Math.abs(this.zzadx.zznq().currentTimeMillis() - this.zzaeN);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      getHandler().removeCallbacks(this.zzw);
      if (getHandler().postDelayed(this.zzw, paramLong)) {
        break;
      }
      this.zzadx.zznr().zze("Failed to adjust delayed post. time", Long.valueOf(paramLong));
      return;
    }
  }
  
  public boolean zzcJ()
  {
    return this.zzaeN != 0L;
  }
  
  public long zzoZ()
  {
    if (this.zzaeN == 0L) {
      return 0L;
    }
    return Math.abs(this.zzadx.zznq().currentTimeMillis() - this.zzaeN);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */