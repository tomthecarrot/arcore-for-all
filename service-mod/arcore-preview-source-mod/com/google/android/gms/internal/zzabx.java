package com.google.android.gms.internal;

import android.os.Process;

class zzabx
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzw;
  
  public zzabx(Runnable paramRunnable, int paramInt)
  {
    this.zzw = paramRunnable;
    this.mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(this.mPriority);
    this.zzw.run();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */