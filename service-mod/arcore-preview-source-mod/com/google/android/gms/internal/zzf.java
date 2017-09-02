package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zzf
  implements zzo
{
  private final Executor zzr;
  
  public zzf(final Handler paramHandler)
  {
    this.zzr = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void zza(zzl<?> paramzzl, zzn<?> paramzzn)
  {
    zza(paramzzl, paramzzn, null);
  }
  
  public void zza(zzl<?> paramzzl, zzn<?> paramzzn, Runnable paramRunnable)
  {
    paramzzl.zzr();
    paramzzl.zzc("post-response");
    this.zzr.execute(new zza(paramzzl, paramzzn, paramRunnable));
  }
  
  public void zza(zzl<?> paramzzl, zzs paramzzs)
  {
    paramzzl.zzc("post-error");
    paramzzs = zzn.zzd(paramzzs);
    this.zzr.execute(new zza(paramzzl, paramzzs, null));
  }
  
  private class zza
    implements Runnable
  {
    private final zzl zzu;
    private final zzn zzv;
    private final Runnable zzw;
    
    public zza(zzl paramzzl, zzn paramzzn, Runnable paramRunnable)
    {
      this.zzu = paramzzl;
      this.zzv = paramzzn;
      this.zzw = paramRunnable;
    }
    
    public void run()
    {
      if (this.zzv.isSuccess())
      {
        this.zzu.zza(this.zzv.result);
        if (!this.zzv.zzag) {
          break label77;
        }
        this.zzu.zzc("intermediate-response");
      }
      for (;;)
      {
        if (this.zzw != null) {
          this.zzw.run();
        }
        return;
        this.zzu.zzc(this.zzv.zzaf);
        break;
        label77:
        this.zzu.zzd("done");
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */