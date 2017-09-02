package com.google.atap.tangocloudservice;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.atap.tangocloudstorage.CloudStorage;
import com.google.atap.tangocloudstorage.CloudStorage.UploadListener;
import com.google.atap.tangocloudstorage.CloudStorageException;
import com.google.atap.tangocloudstorage.FileUploadRequest;
import com.google.tango.cloudlib.Utils;
import java.io.File;
import java.io.FilenameFilter;

public class TangoUserDataUploadService
  extends Service
{
  private static final String DEST_BUCKET = "project-tango-user-segments-staging";
  private static final String DEST_FILE_NAME_PREFIX = "first_fix/";
  private static final String SOURCE_USER_DATA_DIRECTORY = "/data/data/com.google.tango/files/Tango/user_segments/first_fix/";
  private static final String TAG = "TangoCloudService." + TangoUserDataUploadService.class.getSimpleName();
  private static final String USER_DATA_SEGMENT_EXTENSION = ".seg";
  private CloudStorage mCloudStorage;
  private Context mContext;
  private boolean mIsStarted = false;
  private int mNumSegmentsExpected = 0;
  private int mNumSegmentsFailure = 0;
  private int mNumSegmentsSuccess = 0;
  private boolean mShowNotifications = false;
  private CloudStorage.UploadListener mUploadListener = new CloudStorage.UploadListener()
  {
    public void onFailure(FileUploadRequest paramAnonymousFileUploadRequest, CloudStorageException paramAnonymousCloudStorageException)
    {
      Log.e(TangoUserDataUploadService.TAG, "Failed to upload: " + paramAnonymousFileUploadRequest.sourceFileName + " cause: " + paramAnonymousCloudStorageException.toString());
      if (!paramAnonymousCloudStorageException.isTransient()) {
        new File(paramAnonymousFileUploadRequest.sourceFileName).delete();
      }
      TangoUserDataUploadService.access$408(TangoUserDataUploadService.this);
      TangoUserDataUploadService.this.maybePostStatusNotification();
      TangoUserDataUploadService.this.maybeResetSelf();
    }
    
    public void onProgressChanged(FileUploadRequest paramAnonymousFileUploadRequest, long paramAnonymousLong1, long paramAnonymousLong2) {}
    
    public void onSuccess(FileUploadRequest paramAnonymousFileUploadRequest)
    {
      Log.i(TangoUserDataUploadService.TAG, "Successfully uploaded: " + paramAnonymousFileUploadRequest.sourceFileName);
      new File(paramAnonymousFileUploadRequest.sourceFileName).delete();
      TangoUserDataUploadService.access$108(TangoUserDataUploadService.this);
      TangoUserDataUploadService.this.maybePostStatusNotification();
      TangoUserDataUploadService.this.maybeResetSelf();
    }
  };
  
  public static int getNumberOfUserSegments()
  {
    File[] arrayOfFile = getUserSegmentFiles();
    if (arrayOfFile == null) {
      return 0;
    }
    return arrayOfFile.length;
  }
  
  private static File[] getUserSegmentFiles()
  {
    new File("/data/data/com.google.tango/files/Tango/user_segments/first_fix/").listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(".seg");
      }
    });
  }
  
  private void maybePostStatusNotification()
  {
    if (!this.mShowNotifications) {
      return;
    }
    Object localObject = String.format("%d / %d", new Object[] { Integer.valueOf(this.mNumSegmentsSuccess + this.mNumSegmentsFailure), Integer.valueOf(this.mNumSegmentsExpected) });
    localObject = new Notification.Builder(this).setContentTitle("Tango User Segments Uploaded: " + (String)localObject).setSmallIcon(2130837532).setAutoCancel(false).build();
    ((NotificationManager)getSystemService("notification")).notify(0, (Notification)localObject);
  }
  
  private void maybeResetSelf()
  {
    if (this.mNumSegmentsSuccess + this.mNumSegmentsFailure == this.mNumSegmentsExpected)
    {
      Log.d(TAG, "Uploaded all segments. Stopping upload service.");
      restoreDefaults();
      stopSelf();
    }
  }
  
  private int queueUserSegmentsForUpload()
  {
    int k = 0;
    int j = 0;
    int i = k;
    for (;;)
    {
      try
      {
        File[] arrayOfFile = getUserSegmentFiles();
        if (arrayOfFile == null) {
          break label232;
        }
        i = k;
        Log.i(TAG, "Have " + arrayOfFile.length + " segments to upload.");
        i = k;
        int m = arrayOfFile.length;
        k = 0;
        i = j;
        if (k < m)
        {
          File localFile = arrayOfFile[k];
          i = j;
          if (localFile.getName().startsWith("~"))
          {
            i = j;
            Log.i(TAG, "Deleting temporary segment: " + localFile.getName());
            i = j;
            localFile.delete();
          }
          else
          {
            i = j;
            this.mCloudStorage.queueFileUploadRequest(new FileUploadRequest(localFile.getAbsolutePath(), "project-tango-user-segments-staging", "first_fix/" + localFile.getName()));
            j += 1;
            i = j;
            Log.i(TAG, "Queued segment upload: " + localFile.getName());
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(TAG, "Unhandled exception during user data upload: ", localException);
      }
      return i;
      label232:
      i = k;
      Log.w(TAG, "Found no user segment files.");
      i = k;
      stopSelf();
      return 0;
      k += 1;
    }
  }
  
  private void restoreDefaults()
  {
    boolean bool = false;
    this.mNumSegmentsExpected = 0;
    this.mNumSegmentsSuccess = 0;
    this.mNumSegmentsFailure = 0;
    this.mIsStarted = false;
    if ((Build.TYPE.contains("userdebug")) || (Build.TYPE.contains("eng"))) {
      bool = true;
    }
    this.mShowNotifications = bool;
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Log.d(TAG, "onCreate()");
    restoreDefaults();
    this.mContext = getApplicationContext();
    this.mCloudStorage = new CloudStorage(this.mContext, 1, Utils.getApiKey(this.mContext), this.mUploadListener);
  }
  
  public void onDestroy()
  {
    Log.d(TAG, "onDestroy()");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("TRIGGERTYPE");
    if ("CANCEL".equals(str))
    {
      Log.d(TAG, "Requesting cancel.");
      stopSelf();
      return 2;
    }
    if (this.mIsStarted)
    {
      Log.d(TAG, "Ignoring action [" + str + "] because service is already running.");
      return 2;
    }
    if ((paramIntent != null) && (!paramIntent.equals("MANUAL")) && ((!TangoCloudServiceUtil.isUnmeteredWifiConnected(this)) || (!TangoCloudServiceUtil.isCharging(this))))
    {
      Log.w(TAG, "Wi-Fi is not connected or battery is not charging. Skipping user data upload.");
      return 2;
    }
    Log.d(TAG, "Starting a new upload task.");
    restoreDefaults();
    this.mNumSegmentsExpected = queueUserSegmentsForUpload();
    if (this.mNumSegmentsExpected > 0) {
      this.mIsStarted = true;
    }
    maybePostStatusNotification();
    return 2;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudservice/TangoUserDataUploadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */