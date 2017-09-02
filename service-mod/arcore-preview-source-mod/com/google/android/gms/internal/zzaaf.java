package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzaaf
{
  private static final ExecutorService zzaNP = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzabw("GAC_Transform"));
  
  public static ExecutorService zzyh()
  {
    return zzaNP;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */