package com.google.android.gms.gcm.nts;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class GcmScheduler
{
  public static final String ACTION_TASK_EVENT = "com.google.android.gms.gcm.nts.TASK_READY";
  public static final String INTENT_PARAM_CALLBACK = "callback";
  public static final String INTENT_PARAM_TAG = "tag";
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS = 0;
  private static GcmScheduler zzbxT;
  private Context mContext;
  private final PendingIntent mPendingIntent;
  private ComponentName zzbxf;
  
  private GcmScheduler(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(), 0);
  }
  
  public static GcmScheduler get(Context paramContext)
  {
    try
    {
      if (zzbxT == null) {
        zzbxT = new GcmScheduler(paramContext);
      }
      paramContext = zzbxT;
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
    if ((str == null) || (i < GoogleCloudMessaging.zzbxs))
    {
      Log.e("GcmScheduler", 83 + "Google Play Services is not available, dropping scheduler request. code=" + i);
      return null;
    }
    Intent localIntent = new Intent("com.google.android.gms.gcm.nts.ACTION_SCHEDULE");
    localIntent.setPackage(str);
    localIntent.putExtra("app", this.mPendingIntent);
    zzv(localIntent);
    return localIntent;
  }
  
  public void cancelAllTasks()
  {
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "NTS_CANCEL_ALL");
    this.mContext.sendBroadcast(localIntent);
  }
  
  public void cancelTask(String paramString)
  {
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "NTS_CANCEL_TASK");
    if (paramString != null) {
      localIntent.putExtra("tag", paramString);
    }
    this.mContext.sendBroadcast(localIntent);
  }
  
  public void schedulePeriodicTask(long paramLong1, long paramLong2, String paramString)
  {
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "NTS_SCHEDULE_RECURRING");
    localIntent.putExtra("period_flex", paramLong2);
    localIntent.putExtra("period", paramLong1);
    if (paramString != null) {
      localIntent.putExtra("tag", paramString);
    }
    this.mContext.sendBroadcast(localIntent);
  }
  
  public void scheduleTask(long paramLong1, long paramLong2, String paramString)
  {
    Intent localIntent = zzJk();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "ACTION_SCHEDULE");
    localIntent.putExtra("window_start", paramLong1);
    localIntent.putExtra("window_end", paramLong2);
    if (paramString != null) {
      localIntent.putExtra("tag", paramString);
    }
    this.mContext.sendBroadcast(localIntent);
  }
  
  public GcmScheduler setService(Class<? extends NetworkTaskService> paramClass)
  {
    this.zzbxf = new ComponentName(this.mContext, paramClass);
    return this;
  }
  
  void zzv(Intent paramIntent)
  {
    if (this.zzbxf == null)
    {
      Object localObject1 = new Intent("com.google.android.gms.gcm.nts.TASK_READY");
      ((Intent)localObject1).setPackage(this.mContext.getPackageName());
      localObject1 = this.mContext.getPackageManager().queryIntentServices((Intent)localObject1, 0);
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        Log.e("GcmScheduler", "There is no TaskService component registered within this package. Have you extended NetworkTaskService correctly?");
        throw new IllegalArgumentException("There is no TaskService component registered within this package. Have you extended NetworkTaskService correctly?");
      }
      if (((List)localObject1).size() > 1)
      {
        localObject1 = ((List)localObject1).iterator();
        Object localObject2;
        for (paramIntent = "There are multiple TaskService components registered for this package. You must setService() to distinguish between them for your task."; ((Iterator)localObject1).hasNext(); paramIntent = String.valueOf(paramIntent).length() + 2 + String.valueOf(localObject2).length() + paramIntent + " " + (String)localObject2 + " ")
        {
          localObject2 = (ResolveInfo)((Iterator)localObject1).next();
          paramIntent = String.valueOf(paramIntent);
          localObject2 = String.valueOf(((ResolveInfo)localObject2).serviceInfo.name);
        }
        Log.e("GcmScheduler", paramIntent);
        throw new IllegalArgumentException(paramIntent);
      }
      this.zzbxf = new ComponentName(this.mContext, ((ResolveInfo)((List)localObject1).get(0)).serviceInfo.name);
    }
    paramIntent.putExtra("component", this.zzbxf);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/nts/GcmScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */