package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class GcmTaskService
  extends Service
{
  public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
  public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  private final Set<String> zzbxl = new HashSet();
  private int zzbxm;
  private ExecutorService zzqo;
  
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
  
  private void zzna(int paramInt)
  {
    synchronized (this.zzbxl)
    {
      this.zzbxm = paramInt;
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
  
  @CallSuper
  public void onCreate()
  {
    super.onCreate();
    this.zzqo = zzJn();
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    List localList = this.zzqo.shutdownNow();
    if (!localList.isEmpty())
    {
      int i = localList.size();
      Log.e("GcmTaskService", 79 + "Shutting down, but not all tasks are finished executing. Remaining: " + i);
    }
  }
  
  public void onInitializeTasks() {}
  
  public abstract int onRunTask(TaskParams paramTaskParams);
  
  @CallSuper
  public int onStartCommand(Intent arg1, int paramInt1, int paramInt2)
  {
    if (??? == null)
    {
      zzna(paramInt2);
      return 2;
    }
    for (;;)
    {
      try
      {
        ???.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        String str = ???.getAction();
        if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(str))
        {
          str = ???.getStringExtra("tag");
          Object localObject2 = ???.getParcelableExtra("callback");
          Bundle localBundle = (Bundle)???.getParcelableExtra("extras");
          ArrayList localArrayList = ???.getParcelableArrayListExtra("triggered_uris");
          if ((localObject2 == null) || (!(localObject2 instanceof PendingCallback)))
          {
            ??? = String.valueOf(getPackageName());
            Log.e("GcmTaskService", String.valueOf(???).length() + 47 + String.valueOf(str).length() + ??? + " " + str + ": Could not process request, invalid callback.");
            return 2;
          }
          synchronized (this.zzbxl)
          {
            if (!this.zzbxl.add(str))
            {
              localObject2 = String.valueOf(getPackageName());
              Log.w("GcmTaskService", String.valueOf(localObject2).length() + 44 + String.valueOf(str).length() + (String)localObject2 + " " + str + ": Task already running, won't start another");
              return 2;
            }
            ??? = new zza(str, ((PendingCallback)localObject2).getIBinder(), localBundle, localArrayList);
            this.zzqo.execute(???);
            return 2;
          }
        }
        if (!"com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(localObject1)) {
          break label322;
        }
      }
      finally
      {
        zzna(paramInt2);
      }
      onInitializeTasks();
      continue;
      label322:
      Log.e("GcmTaskService", String.valueOf(localObject1).length() + 37 + "Unknown action received " + (String)localObject1 + ", terminating");
    }
  }
  
  protected ExecutorService zzJn()
  {
    Executors.newFixedThreadPool(2, new ThreadFactory()
    {
      private final AtomicInteger zzbxn = new AtomicInteger(1);
      
      public Thread newThread(@NonNull Runnable paramAnonymousRunnable)
      {
        int i = this.zzbxn.getAndIncrement();
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, 20 + "gcm-task#" + i);
        paramAnonymousRunnable.setPriority(4);
        return paramAnonymousRunnable;
      }
    });
  }
  
  private class zza
    implements Runnable
  {
    private final Bundle mExtras;
    private final String mTag;
    private final INetworkTaskCallback zzbxo;
    private final List<Uri> zzbxp;
    
    zza(IBinder paramIBinder, Bundle paramBundle, List<Uri> paramList)
    {
      this.mTag = paramIBinder;
      this.zzbxo = INetworkTaskCallback.Stub.asInterface(paramBundle);
      this.mExtras = paramList;
      List localList;
      this.zzbxp = localList;
    }
    
    public void run()
    {
      TaskParams localTaskParams = new TaskParams(this.mTag, this.mExtras, this.zzbxp);
      int i = GcmTaskService.this.onRunTask(localTaskParams);
      try
      {
        this.zzbxo.taskFinished(i);
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
        GcmTaskService.zza(GcmTaskService.this, this.mTag);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/GcmTaskService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */