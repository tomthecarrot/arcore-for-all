package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.List;

public class GcmNetworkManager
{
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS = 0;
  private static GcmNetworkManager zzbxe;
  private Context mContext;
  private final PendingIntent mPendingIntent;
  private ComponentName zzbxf;
  
  private GcmNetworkManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
  }
  
  public static GcmNetworkManager getInstance(Context paramContext)
  {
    try
    {
      if (zzbxe == null) {
        zzbxe = new GcmNetworkManager(paramContext.getApplicationContext());
      }
      paramContext = zzbxe;
      return paramContext;
    }
    finally {}
  }
  
  private Intent zzJk()
  {
    String str = GoogleCloudMessaging.getGcmPackage(this.mContext);
    int i = -1;
    if (str != null) {
      i = GoogleCloudMessaging.getGcmVersion(this.mContext);
    }
    if ((str == null) || (i < GoogleCloudMessaging.zzbxr))
    {
      Log.e("GcmNetworkManager", 91 + "Google Play Services is not available, dropping GcmNetworkManager request. code=" + i);
      return null;
    }
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage(str);
    localIntent.putExtra("app", this.mPendingIntent);
    localIntent.putExtra("source", 4);
    localIntent.putExtra("source_version", 10298000);
    return localIntent;
  }
  
  private void zza(String paramString, ComponentName paramComponentName)
  {
    zzet(paramString);
    zzeu(paramComponentName.getClassName());
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_TASK");
    localIntent.putExtra("tag", paramString);
    localIntent.putExtra("component", paramComponentName);
    this.mContext.sendBroadcast(localIntent);
  }
  
  private void zzc(ComponentName paramComponentName)
  {
    zzeu(paramComponentName.getClassName());
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_ALL");
    localIntent.putExtra("component", paramComponentName);
    this.mContext.sendBroadcast(localIntent);
  }
  
  static void zzet(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a valid tag.");
    }
    if (100 < paramString.length()) {
      throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
    }
  }
  
  private void zzeu(String paramString)
  {
    boolean bool2 = true;
    zzac.zzb(paramString, "GcmTaskService must not be null.");
    Object localObject = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
    ((Intent)localObject).setPackage(this.mContext.getPackageName());
    localObject = this.mContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      bool1 = true;
      zzac.zzb(bool1, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ResolveInfo)((Iterator)localObject).next()).serviceInfo.name.equals(paramString));
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, String.valueOf(paramString).length() + 119 + "The GcmTaskService class you provided " + paramString + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void cancelAllTasks(Class<? extends GcmTaskService> paramClass)
  {
    cancelAllTasksUnchecked(paramClass);
  }
  
  public void cancelAllTasksUnchecked(Class<? extends Service> paramClass)
  {
    zzc(new ComponentName(this.mContext, paramClass));
  }
  
  public void cancelTask(String paramString, Class<? extends GcmTaskService> paramClass)
  {
    cancelTaskUnchecked(paramString, paramClass);
  }
  
  public void cancelTaskUnchecked(String paramString, Class<? extends Service> paramClass)
  {
    zza(paramString, new ComponentName(this.mContext, paramClass));
  }
  
  public void schedule(Task paramTask)
  {
    zzeu(paramTask.getServiceName());
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    Bundle localBundle = localIntent.getExtras();
    localBundle.putString("scheduler_action", "SCHEDULE_TASK");
    paramTask.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    this.mContext.sendBroadcast(localIntent);
  }
  
  @Deprecated
  public void scheduleTask(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    zzJl();
    schedule((OneoffTask)((OneoffTask.Builder)((OneoffTask.Builder)new OneoffTask.Builder().zzeB(this.zzbxf.getClassName()).setExecutionWindow(paramLong1, paramLong2).setTag(paramString)).setUpdateCurrent(paramBoolean)).build());
  }
  
  @Deprecated
  public GcmNetworkManager setService(Class<? extends GcmTaskService> paramClass)
  {
    this.zzbxf = new ComponentName(this.mContext, paramClass);
    return this;
  }
  
  void zzJl()
  {
    if (this.zzbxf == null)
    {
      Object localObject1 = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
      ((Intent)localObject1).setPackage(this.mContext.getPackageName());
      localObject1 = this.mContext.getPackageManager().queryIntentServices((Intent)localObject1, 0);
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        Log.e("GcmNetworkManager", "There is no TaskService component registered within this package. Have you extended GcmTaskService correctly?");
        throw new IllegalArgumentException("There is no TaskService component registered within this package. Have you extended GcmTaskService correctly?");
      }
      if (((List)localObject1).size() > 1)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        Object localObject2;
        for (localObject1 = "There are multiple TaskService components registered for this package. You must setService() to distinguish between them for your task."; localIterator.hasNext(); localObject1 = String.valueOf(localObject1).length() + 2 + String.valueOf(localObject2).length() + (String)localObject1 + " " + (String)localObject2 + " ")
        {
          localObject2 = (ResolveInfo)localIterator.next();
          localObject1 = String.valueOf(localObject1);
          localObject2 = String.valueOf(((ResolveInfo)localObject2).serviceInfo.name);
        }
        Log.e("GcmNetworkManager", (String)localObject1);
        throw new IllegalArgumentException((String)localObject1);
      }
      this.zzbxf = new ComponentName(this.mContext, ((ResolveInfo)((List)localObject1).get(0)).serviceInfo.name);
      return;
    }
    zzeu(this.zzbxf.getClassName());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/GcmNetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */