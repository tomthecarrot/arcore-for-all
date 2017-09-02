package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;

class zzal
{
  private long zzLe;
  private final Clock zzvi;
  
  public zzal(Clock paramClock)
  {
    zzac.zzC(paramClock);
    this.zzvi = paramClock;
  }
  
  public zzal(Clock paramClock, long paramLong)
  {
    zzac.zzC(paramClock);
    this.zzvi = paramClock;
    this.zzLe = paramLong;
  }
  
  public void clear()
  {
    this.zzLe = 0L;
  }
  
  public void start()
  {
    this.zzLe = this.zzvi.elapsedRealtime();
  }
  
  public boolean zzE(long paramLong)
  {
    if (this.zzLe == 0L) {}
    while (this.zzvi.elapsedRealtime() - this.zzLe > paramLong) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */