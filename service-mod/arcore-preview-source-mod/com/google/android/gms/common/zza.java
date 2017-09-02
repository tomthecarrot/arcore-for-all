package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza
  implements ServiceConnection
{
  boolean zzaJM = false;
  private final BlockingQueue<IBinder> zzaJN = new LinkedBlockingQueue();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzaJN.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public IBinder zza(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    zzac.zzcV("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (this.zzaJM) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.zzaJM = true;
    paramTimeUnit = (IBinder)this.zzaJN.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null) {
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    return paramTimeUnit;
  }
  
  public IBinder zzwK()
    throws InterruptedException
  {
    zzac.zzcV("BlockingServiceConnection.getService() called on main thread");
    if (this.zzaJM) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.zzaJM = true;
    return (IBinder)this.zzaJN.take();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */