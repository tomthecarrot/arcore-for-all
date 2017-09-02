package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzao
  extends Thread
  implements zzan
{
  private static zzao zzcuG;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zzNn = false;
  private final LinkedBlockingQueue<Runnable> zzcuF = new LinkedBlockingQueue();
  private volatile zzap zzcuH;
  
  private zzao(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static zzao zzcj(Context paramContext)
  {
    if (zzcuG == null) {
      zzcuG = new zzao(paramContext);
    }
    return zzcuG;
  }
  
  private String zzh(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void run()
  {
    for (;;)
    {
      boolean bool = this.mClosed;
      try
      {
        Runnable localRunnable = (Runnable)this.zzcuF.take();
        if (!this.zzNn) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.i(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        str = String.valueOf(zzh(localThrowable));
        if (str.length() == 0) {}
      }
    }
    for (String str = "Error on Google TagManager Thread: ".concat(str);; str = new String("Error on Google TagManager Thread: "))
    {
      Log.e(str);
      Log.e("Google TagManager is shutting down.");
      this.zzNn = true;
      break;
    }
  }
  
  public void zzjP(String paramString)
  {
    zzp(paramString, System.currentTimeMillis());
  }
  
  void zzp(String paramString, final long paramLong)
  {
    zzs(new Runnable()
    {
      public void run()
      {
        if (zzao.zza(zzao.this) == null)
        {
          zzcq localzzcq = zzcq.zzYs();
          localzzcq.zza(zzao.zzb(zzao.this), jdField_this);
          zzao.zza(zzao.this, localzzcq.zzYv());
        }
        zzao.zza(zzao.this).zzg(paramLong, this.zzsr);
      }
    });
  }
  
  public void zzs(Runnable paramRunnable)
  {
    this.zzcuF.add(paramRunnable);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */