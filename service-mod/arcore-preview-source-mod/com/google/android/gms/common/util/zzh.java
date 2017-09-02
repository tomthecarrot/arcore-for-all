package com.google.android.gms.common.util;

import android.os.SystemClock;

public class zzh
  implements Clock
{
  private static zzh zzaUK = new zzh();
  
  public static Clock zzAM()
  {
    return zzaUK;
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */