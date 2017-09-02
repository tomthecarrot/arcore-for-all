package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb
  extends zzd
{
  private final zzl zzadp;
  
  public zzb(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzac.zzC(paramzzg);
    this.zzadp = paramzzg.zzj(paramzzf);
  }
  
  protected void onInitialize()
  {
    this.zzadp.initialize();
  }
  
  void onServiceConnected()
  {
    zzmW();
    this.zzadp.onServiceConnected();
  }
  
  public void setLocalDispatchPeriod(final int paramInt)
  {
    zznA();
    zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzB(paramInt * 1000L);
      }
    });
  }
  
  public void start()
  {
    this.zzadp.start();
  }
  
  public void zzR(final boolean paramBoolean)
  {
    zza("Network connectivity status changed", Boolean.valueOf(paramBoolean));
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzR(paramBoolean);
      }
    });
  }
  
  public long zza(zzh paramzzh)
  {
    zznA();
    zzac.zzC(paramzzh);
    zzmW();
    long l = this.zzadp.zza(paramzzh, true);
    if (l == 0L) {
      this.zzadp.zzc(paramzzh);
    }
    return l;
  }
  
  public void zza(final zzab paramzzab)
  {
    zzac.zzC(paramzzab);
    zznA();
    zzb("Hit delivery requested", paramzzab);
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zza(paramzzab);
      }
    });
  }
  
  public void zza(final zzx paramzzx)
  {
    zznA();
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzb(paramzzx);
      }
    });
  }
  
  public void zza(final String paramString, final Runnable paramRunnable)
  {
    zzac.zzi(paramString, "campaign param can't be empty");
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzbz(paramString);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
  }
  
  public void zznj()
  {
    zznA();
    zznt().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zznj();
      }
    });
  }
  
  public void zznk()
  {
    zznA();
    Context localContext = getContext();
    if ((zzaj.zzao(localContext)) && (zzak.zzap(localContext)))
    {
      Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localIntent.setComponent(new ComponentName(localContext, "com.google.android.gms.analytics.AnalyticsService"));
      localContext.startService(localIntent);
      return;
    }
    zza(null);
  }
  
  public boolean zznl()
  {
    zznA();
    Future localFuture = zznt().zzc(new Callable()
    {
      public Void zzbj()
        throws Exception
      {
        zzb.zza(zzb.this).zzof();
        return null;
      }
    });
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzd("syncDispatchLocalHits interrupted", localInterruptedException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      zze("syncDispatchLocalHits failed", localExecutionException);
      return false;
    }
    catch (TimeoutException localTimeoutException)
    {
      zzd("syncDispatchLocalHits timed out", localTimeoutException);
    }
    return false;
  }
  
  public void zznm()
  {
    zznA();
    com.google.android.gms.analytics.zzh.zzmW();
    this.zzadp.zznm();
  }
  
  public void zznn()
  {
    zzbr("Radio powered up");
    zznk();
  }
  
  void zzno()
  {
    zzmW();
    this.zzadp.zzno();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */