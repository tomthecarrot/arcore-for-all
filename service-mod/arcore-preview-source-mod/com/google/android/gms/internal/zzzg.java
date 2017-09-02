package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzzg
  implements zzzi
{
  private final zzzj zzaMN;
  
  public zzzg(zzzj paramzzzj)
  {
    this.zzaMN = paramzzzj;
  }
  
  public void begin()
  {
    this.zzaMN.zzyg();
    this.zzaMN.zzaMa.zzaNu = Collections.emptySet();
  }
  
  public void connect()
  {
    this.zzaMN.zzye();
  }
  
  public boolean disconnect()
  {
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(T paramT)
  {
    this.zzaMN.zzaMa.zzaMy.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */