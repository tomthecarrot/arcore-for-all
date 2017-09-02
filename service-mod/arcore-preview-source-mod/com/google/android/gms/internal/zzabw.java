package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzabw
  implements ThreadFactory
{
  private final int mPriority;
  private final String zzaVk;
  private final AtomicInteger zzaVl = new AtomicInteger();
  private final ThreadFactory zzaVm = Executors.defaultThreadFactory();
  
  public zzabw(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzabw(String paramString, int paramInt)
  {
    this.zzaVk = ((String)zzac.zzb(paramString, "Name must not be null"));
    this.mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zzaVm.newThread(new zzabx(paramRunnable, this.mPriority));
    String str = this.zzaVk;
    int i = this.zzaVl.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */