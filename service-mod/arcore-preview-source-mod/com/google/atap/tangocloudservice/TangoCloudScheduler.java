package com.google.atap.tangocloudservice;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask.Builder;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TangoCloudScheduler
{
  private static final String ADF_DOWNLOAD_TAG;
  private static final int FUZZ_RANGE_SECS = (int)TimeUnit.HOURS.toSeconds(6L);
  private static final int MIN_DOWNLOAD_TASK_PERIOD_SECS;
  private static final int MIN_UPLOAD_TASK_PERIOD_SECS;
  private static final String TAG = "TangoCloudService." + TangoCloudScheduler.class.getSimpleName();
  private static final String USER_DATA_UPLOAD_TAG;
  private final Context mContext;
  
  static
  {
    ADF_DOWNLOAD_TAG = TangoCloudAdfDownloadService.class.getName();
    USER_DATA_UPLOAD_TAG = TangoUserDataUploadService.class.getName();
    MIN_DOWNLOAD_TASK_PERIOD_SECS = (int)TimeUnit.HOURS.toSeconds(6L);
    MIN_UPLOAD_TASK_PERIOD_SECS = (int)TimeUnit.HOURS.toSeconds(18L);
  }
  
  private TangoCloudScheduler(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static TangoCloudScheduler newScheduler(Context paramContext)
  {
    return new TangoCloudScheduler(paramContext);
  }
  
  public void schedule()
  {
    Log.i(TAG, "Scheduled Tango Cloud periodic updates.");
    long l1 = MIN_DOWNLOAD_TASK_PERIOD_SECS + new Random().nextInt(FUZZ_RANGE_SECS);
    long l2 = MIN_UPLOAD_TASK_PERIOD_SECS + new Random().nextInt(FUZZ_RANGE_SECS);
    GcmNetworkManager localGcmNetworkManager = GcmNetworkManager.getInstance(this.mContext);
    localGcmNetworkManager.schedule(new PeriodicTask.Builder().setTag(ADF_DOWNLOAD_TAG).setService(TangoCloudGcmTaskService.class).setPeriod(l1).setRequiresCharging(true).setRequiredNetwork(1).build());
    localGcmNetworkManager.schedule(new PeriodicTask.Builder().setTag(USER_DATA_UPLOAD_TAG).setService(TangoCloudGcmTaskService.class).setPeriod(l2).setRequiresCharging(true).setRequiredNetwork(1).build());
  }
  
  public void unschedule()
  {
    Log.i(TAG, "Unscheduled Tango Cloud periodic updates.");
    GcmNetworkManager localGcmNetworkManager = GcmNetworkManager.getInstance(this.mContext);
    localGcmNetworkManager.cancelTask(ADF_DOWNLOAD_TAG, TangoCloudGcmTaskService.class);
    localGcmNetworkManager.cancelTask(USER_DATA_UPLOAD_TAG, TangoCloudGcmTaskService.class);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudservice/TangoCloudScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */