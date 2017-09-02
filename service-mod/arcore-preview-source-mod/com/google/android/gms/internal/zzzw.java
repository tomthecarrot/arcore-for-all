package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;

public final class zzzw<L>
{
  private volatile L mListener;
  private final zza zzaOA;
  private final zzb<L> zzaOB;
  
  zzzw(@NonNull Looper paramLooper, @NonNull L paramL, @NonNull String paramString)
  {
    this.zzaOA = new zza(paramLooper);
    this.mListener = zzac.zzb(paramL, "Listener must not be null");
    this.zzaOB = new zzb(paramL, zzac.zzdc(paramString));
  }
  
  public void clear()
  {
    this.mListener = null;
  }
  
  public void zza(zzc<? super L> paramzzc)
  {
    zzac.zzb(paramzzc, "Notifier must not be null");
    paramzzc = this.zzaOA.obtainMessage(1, paramzzc);
    this.zzaOA.sendMessage(paramzzc);
  }
  
  void zzb(zzc<? super L> paramzzc)
  {
    Object localObject = this.mListener;
    if (localObject == null)
    {
      paramzzc.zzxO();
      return;
    }
    try
    {
      paramzzc.zzw(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzc.zzxO();
      throw localRuntimeException;
    }
  }
  
  public boolean zzvr()
  {
    return this.mListener != null;
  }
  
  @NonNull
  public zzb<L> zzyK()
  {
    return this.zzaOB;
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (paramMessage.what == 1) {}
      for (;;)
      {
        zzac.zzaw(bool);
        zzzw.this.zzb((zzzw.zzc)paramMessage.obj);
        return;
        bool = false;
      }
    }
  }
  
  public static final class zzb<L>
  {
    private final L mListener;
    private final String zzaOD;
    
    zzb(L paramL, String paramString)
    {
      this.mListener = paramL;
      this.zzaOD = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
      } while ((this.mListener == ((zzb)paramObject).mListener) && (this.zzaOD.equals(((zzb)paramObject).zzaOD)));
      return false;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this.mListener) * 31 + this.zzaOD.hashCode();
    }
  }
  
  public static abstract interface zzc<L>
  {
    public abstract void zzw(L paramL);
    
    public abstract void zzxO();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */