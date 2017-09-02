package com.google.android.gms.gcm.nts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public abstract class NetworkTaskService
  extends Service
{
  public static final String PERMISSION_BIND = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  protected static final String TAG = "GcmTaskService";
  private final Set<String> zzbxl = new HashSet();
  private int zzbxm;
  
  private void zzey(String paramString)
  {
    synchronized (this.zzbxl)
    {
      this.zzbxl.remove(paramString);
      if (this.zzbxl.size() == 0) {
        stopSelf(this.zzbxm);
      }
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public abstract int onRunTask(String paramString);
  
  public int onStartCommand(Intent arg1, int paramInt1, int paramInt2)
  {
    String str;
    Parcelable localParcelable;
    if ("com.google.android.gms.gcm.nts.TASK_READY".equals(???.getAction()))
    {
      str = ???.getStringExtra("tag");
      localParcelable = ???.getParcelableExtra("callback");
      if ((localParcelable == null) || (!(localParcelable instanceof PendingCallback)))
      {
        ??? = String.valueOf(getPackageName());
        Log.e("GcmTaskService", String.valueOf(???).length() + 47 + String.valueOf(str).length() + ??? + " " + str + ": Could not process request, invalid callback.");
      }
    }
    else
    {
      return 2;
    }
    synchronized (this.zzbxl)
    {
      this.zzbxl.add(str);
      stopSelf(this.zzbxm);
      this.zzbxm = paramInt2;
      new zza(str, ((PendingCallback)localParcelable).getIBinder()).start();
      return 2;
    }
  }
  
  private class zza
    extends Thread
  {
    private final String mTag;
    private final zza zzbxU;
    
    zza(String paramString, IBinder paramIBinder)
    {
      this.mTag = paramString;
      this.zzbxU = zza.zza.zzeX(paramIBinder);
    }
    
    public void run()
    {
      int i = NetworkTaskService.this.onRunTask(this.mTag);
      try
      {
        this.zzbxU.taskFinished(i);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        String str = String.valueOf(this.mTag);
        if (str.length() != 0) {}
        for (str = "Error reporting result of operation to scheduler for ".concat(str);; str = new String("Error reporting result of operation to scheduler for "))
        {
          Log.e("GcmTaskService", str);
          return;
        }
      }
      finally
      {
        NetworkTaskService.zza(NetworkTaskService.this, this.mTag);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/nts/NetworkTaskService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */