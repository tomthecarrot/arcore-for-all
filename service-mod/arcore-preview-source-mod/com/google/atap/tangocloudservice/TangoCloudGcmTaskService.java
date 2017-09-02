package com.google.atap.tangocloudservice;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

public class TangoCloudGcmTaskService
  extends GcmTaskService
{
  private static final String ACTION_GCM_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  private static final String ACTION_GCM_TASK_READY = "com.google.android.gms.gcm.ACTION_TASK_READY";
  private static final String TAG = "TangoCloudService." + TangoCloudGcmTaskService.class.getSimpleName();
  
  public int onRunTask(TaskParams paramTaskParams)
  {
    Log.d(TAG, "onRunTask()");
    try
    {
      paramTaskParams = Class.forName(paramTaskParams.getTag());
      paramTaskParams = new Intent(this, paramTaskParams);
      paramTaskParams.putExtra("TRIGGERTYPE", "SCHEDULED");
      startService(paramTaskParams);
      return 0;
    }
    catch (ClassNotFoundException paramTaskParams)
    {
      Log.e(TAG, paramTaskParams.toString());
    }
    return 2;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    Log.d(TAG, "onStartCommand()");
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(paramIntent)) {
      Log.d(TAG, "Started by GcmNetworkManager.");
    }
    while ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(paramIntent)) {
      return 2;
    }
    Log.e(TAG, "Unrecognized action [" + paramIntent + "]. Doing nothing.");
    return 2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudservice/TangoCloudGcmTaskService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */