package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzr;
import java.util.HashSet;
import java.util.Set;

public class zzaai
  extends zzbgg
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static Api.zza<? extends zzbgc, zzbgd> zzaOO = zzbgb.zzaiG;
  private final Context mContext;
  private final Handler mHandler;
  private final Api.zza<? extends zzbgc, zzbgd> zzaKm;
  private zzbgc zzaMV;
  private zzg zzaMp;
  private final boolean zzaOP;
  private zza zzaOQ;
  private Set<Scope> zzamH;
  
  @WorkerThread
  public zzaai(Context paramContext, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zzaKm = zzaOO;
    this.zzaOP = true;
  }
  
  @WorkerThread
  public zzaai(Context paramContext, Handler paramHandler, zzg paramzzg, Api.zza<? extends zzbgc, zzbgd> paramzza)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zzaMp = paramzzg;
    this.zzamH = paramzzg.zzzF();
    this.zzaKm = paramzza;
    this.zzaOP = false;
  }
  
  @WorkerThread
  private void zzc(zzbgq paramzzbgq)
  {
    Object localObject = paramzzbgq.zzAb();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramzzbgq.zzWi();
      paramzzbgq = ((zzaf)localObject).zzAb();
      if (!paramzzbgq.isSuccess())
      {
        localObject = String.valueOf(paramzzbgq);
        Log.wtf("SignInCoordinator", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        this.zzaOQ.zzi(paramzzbgq);
        this.zzaMV.disconnect();
        return;
      }
      this.zzaOQ.zzb(((zzaf)localObject).zzAa(), this.zzamH);
    }
    for (;;)
    {
      this.zzaMV.disconnect();
      return;
      this.zzaOQ.zzi((ConnectionResult)localObject);
    }
  }
  
  @WorkerThread
  public void onConnected(@Nullable Bundle paramBundle)
  {
    this.zzaMV.zza(this);
  }
  
  @WorkerThread
  public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    this.zzaOQ.zzi(paramConnectionResult);
  }
  
  @WorkerThread
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaMV.disconnect();
  }
  
  @WorkerThread
  public void zza(zza paramzza)
  {
    if (this.zzaMV != null) {
      this.zzaMV.disconnect();
    }
    if (this.zzaOP)
    {
      localObject = zzn.zzaw(this.mContext).zzra();
      if (localObject != null) {
        break label128;
      }
    }
    label128:
    for (Object localObject = new HashSet();; localObject = new HashSet(((GoogleSignInOptions)localObject).zzqH()))
    {
      this.zzamH = ((Set)localObject);
      this.zzaMp = new zzg(null, this.zzamH, null, 0, null, null, null, zzbgd.zzcqC);
      this.zzaMV = ((zzbgc)this.zzaKm.zza(this.mContext, this.mHandler.getLooper(), this.zzaMp, this.zzaMp.zzzL(), this, this));
      this.zzaOQ = paramzza;
      this.zzaMV.connect();
      return;
    }
  }
  
  @BinderThread
  public void zzb(final zzbgq paramzzbgq)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        zzaai.zza(zzaai.this, paramzzbgq);
      }
    });
  }
  
  public zzbgc zzyA()
  {
    return this.zzaMV;
  }
  
  public void zzyN()
  {
    this.zzaMV.disconnect();
  }
  
  @WorkerThread
  public static abstract interface zza
  {
    public abstract void zzb(zzr paramzzr, Set<Scope> paramSet);
    
    public abstract void zzi(ConnectionResult paramConnectionResult);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzaai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */