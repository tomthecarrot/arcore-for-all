package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface zzzq
{
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @Nullable
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract <A extends Api.zzb, R extends Result, T extends zzyr.zza<R, A>> T zza(@NonNull T paramT);
  
  public abstract boolean zza(zzaah paramzzaah);
  
  public abstract <A extends Api.zzb, T extends zzyr.zza<? extends Result, A>> T zzb(@NonNull T paramT);
  
  public abstract void zzxa();
  
  public abstract void zzxy();
  
  public static abstract interface zza
  {
    public abstract void zzc(ConnectionResult paramConnectionResult);
    
    public abstract void zzf(int paramInt, boolean paramBoolean);
    
    public abstract void zzu(Bundle paramBundle);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */