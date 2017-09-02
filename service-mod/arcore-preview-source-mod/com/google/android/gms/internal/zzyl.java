package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public abstract class zzyl
{
  public final int zzahZ;
  
  public zzyl(int paramInt)
  {
    this.zzahZ = paramInt;
  }
  
  private static Status zzc(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((zzt.zzAS()) && ((paramRemoteException instanceof TransactionTooLargeException))) {
      localStringBuilder.append("TransactionTooLargeException: ");
    }
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }
  
  public abstract void zzN(@NonNull Status paramStatus);
  
  public abstract void zza(@NonNull zzyz paramzzyz, boolean paramBoolean);
  
  public abstract void zza(zzzl.zza<?> paramzza)
    throws DeadObjectException;
  
  private static abstract class zza
    extends zzyl
  {
    protected final TaskCompletionSource<Void> zzamh;
    
    public zza(int paramInt, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super();
      this.zzamh = paramTaskCompletionSource;
    }
    
    public void zzN(@NonNull Status paramStatus)
    {
      this.zzamh.trySetException(new zza(paramStatus));
    }
    
    public void zza(@NonNull zzyz paramzzyz, boolean paramBoolean) {}
    
    public final void zza(zzzl.zza<?> paramzza)
      throws DeadObjectException
    {
      try
      {
        zzb(paramzza);
        return;
      }
      catch (DeadObjectException paramzza)
      {
        zzN(zzyl.zzd(paramzza));
        throw paramzza;
      }
      catch (RemoteException paramzza)
      {
        zzN(zzyl.zzd(paramzza));
      }
    }
    
    protected abstract void zzb(zzzl.zza<?> paramzza)
      throws RemoteException;
  }
  
  public static class zzb<A extends zzyr.zza<? extends Result, Api.zzb>>
    extends zzyl
  {
    protected final A zzaLj;
    
    public zzb(int paramInt, A paramA)
    {
      super();
      this.zzaLj = paramA;
    }
    
    public void zzN(@NonNull Status paramStatus)
    {
      this.zzaLj.zzP(paramStatus);
    }
    
    public void zza(@NonNull zzyz paramzzyz, boolean paramBoolean)
    {
      paramzzyz.zza(this.zzaLj, paramBoolean);
    }
    
    public void zza(zzzl.zza<?> paramzza)
      throws DeadObjectException
    {
      this.zzaLj.zzb(paramzza.zzxG());
    }
  }
  
  public static final class zzc
    extends zzyl.zza
  {
    public final zzaac<Api.zzb, ?> zzaLk;
    public final zzaas<Api.zzb, ?> zzaLl;
    
    public zzc(zzaad paramzzaad, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super(paramTaskCompletionSource);
      this.zzaLk = paramzzaad.zzaLk;
      this.zzaLl = paramzzaad.zzaLl;
    }
    
    public void zzb(zzzl.zza<?> paramzza)
      throws RemoteException
    {
      this.zzaLk.zzb(paramzza.zzxG(), this.zzamh);
      if (this.zzaLk.zzyK() != null) {
        paramzza.zzyu().put(this.zzaLk.zzyK(), new zzaad(this.zzaLk, this.zzaLl));
      }
    }
  }
  
  public static final class zzd<TResult>
    extends zzyl
  {
    private final zzaao<Api.zzb, TResult> zzaLm;
    private final zzaak zzaLn;
    private final TaskCompletionSource<TResult> zzamh;
    
    public zzd(int paramInt, zzaao<Api.zzb, TResult> paramzzaao, TaskCompletionSource<TResult> paramTaskCompletionSource, zzaak paramzzaak)
    {
      super();
      this.zzamh = paramTaskCompletionSource;
      this.zzaLm = paramzzaao;
      this.zzaLn = paramzzaak;
    }
    
    public void zzN(@NonNull Status paramStatus)
    {
      this.zzamh.trySetException(this.zzaLn.zzO(paramStatus));
    }
    
    public void zza(@NonNull zzyz paramzzyz, boolean paramBoolean)
    {
      paramzzyz.zza(this.zzamh, paramBoolean);
    }
    
    public void zza(zzzl.zza<?> paramzza)
      throws DeadObjectException
    {
      try
      {
        this.zzaLm.zza(paramzza.zzxG(), this.zzamh);
        return;
      }
      catch (DeadObjectException paramzza)
      {
        throw paramzza;
      }
      catch (RemoteException paramzza)
      {
        zzN(zzyl.zzd(paramzza));
      }
    }
  }
  
  public static final class zze
    extends zzyl.zza
  {
    public final zzzw.zzb<?> zzaLo;
    
    public zze(zzzw.zzb<?> paramzzb, TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      super(paramTaskCompletionSource);
      this.zzaLo = paramzzb;
    }
    
    public void zzb(zzzl.zza<?> paramzza)
      throws RemoteException
    {
      zzaad localzzaad = (zzaad)paramzza.zzyu().remove(this.zzaLo);
      if (localzzaad != null)
      {
        localzzaad.zzaLl.zzc(paramzza.zzxG(), this.zzamh);
        localzzaad.zzaLk.zzyL();
        return;
      }
      Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
      this.zzamh.trySetException(new zza(Status.zzaLe));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */