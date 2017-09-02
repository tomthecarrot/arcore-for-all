package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzze
  implements zzzi
{
  private final zzzj zzaMN;
  private boolean zzaMO = false;
  
  public zzze(zzzj paramzzzj)
  {
    this.zzaMN = paramzzzj;
  }
  
  private <A extends Api.zzb> void zze(zzyr.zza<? extends Result, A> paramzza)
    throws DeadObjectException
  {
    this.zzaMN.zzaMa.zzaNz.zzb(paramzza);
    Api.zze localzze = this.zzaMN.zzaMa.zzc(paramzza.zzwS());
    if ((!localzze.isConnected()) && (this.zzaMN.zzaNI.containsKey(paramzza.zzwS())))
    {
      paramzza.zzP(new Status(17));
      return;
    }
    Object localObject = localzze;
    if ((localzze instanceof zzal)) {
      localObject = ((zzal)localzze).zzAh();
    }
    paramzza.zzb((Api.zzb)localObject);
  }
  
  public void begin() {}
  
  public void connect()
  {
    if (this.zzaMO)
    {
      this.zzaMO = false;
      this.zzaMN.zza(new zzzj.zza(this)
      {
        public void zzxQ()
        {
          zzze.zza(zzze.this).zzaNM.zzu(null);
        }
      });
    }
  }
  
  public boolean disconnect()
  {
    if (this.zzaMO) {
      return false;
    }
    if (this.zzaMN.zzaMa.zzyc())
    {
      this.zzaMO = true;
      Iterator localIterator = this.zzaMN.zzaMa.zzaNy.iterator();
      while (localIterator.hasNext()) {
        ((zzaaq)localIterator.next()).zzyQ();
      }
      return false;
    }
    this.zzaMN.zzh(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaMN.zzh(null);
    this.zzaMN.zzaNM.zzf(paramInt, this.zzaMO);
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zze(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.zzaMN.zza(new zzzj.zza(this)
      {
        public void zzxQ()
        {
          zzze.this.onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
  
  void zzxP()
  {
    if (this.zzaMO)
    {
      this.zzaMO = false;
      this.zzaMN.zzaMa.zzaNz.release();
      disconnect();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */