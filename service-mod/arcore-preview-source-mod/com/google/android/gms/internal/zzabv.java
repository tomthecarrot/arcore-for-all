package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class zzabv
  implements Executor
{
  private final Handler mHandler;
  
  public zzabv(Looper paramLooper)
  {
    this.mHandler = new Handler(paramLooper);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */