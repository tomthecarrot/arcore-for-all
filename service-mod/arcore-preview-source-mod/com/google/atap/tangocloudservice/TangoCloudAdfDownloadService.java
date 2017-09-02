package com.google.atap.tangocloudservice;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.atap.tango.TangoInternal;
import com.google.atap.tango.TangoService.CloudTileProgressCallback;
import java.util.concurrent.atomic.AtomicInteger;

public class TangoCloudAdfDownloadService
  extends Service
{
  private static final float LARGE_CACHING_RADIUS_METERS = 200.0F;
  private static final int LOCATION_FASTEST_INTERVAL_MS = 5000;
  private static final int LOCATION_INTERVAL_MS = 5000;
  private static final LocationRequest LOC_REQUEST = new LocationRequest().setInterval(5000L).setFastestInterval(5000L).setPriority(100);
  private static final String TAG = "TangoCloudService." + TangoCloudAdfDownloadService.class.getSimpleName();
  private Context mContext;
  private GoogleApiClient mGoogleApiClient;
  private LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      Log.d(TangoCloudAdfDownloadService.TAG, "Received: " + paramAnonymousLocation.toString());
      paramAnonymousLocation.setAccuracy(200.0F);
      TangoCloudAdfDownloadService.this.postStatusIfUserDebug("", true);
      LocationServices.FusedLocationApi.removeLocationUpdates(TangoCloudAdfDownloadService.this.mGoogleApiClient, TangoCloudAdfDownloadService.this.mLocationListener);
      TangoCloudAdfDownloadService.access$402(TangoCloudAdfDownloadService.this, new TangoCloudAdfDownloadService.CacheTilesBackgroundTask(TangoCloudAdfDownloadService.this, paramAnonymousLocation));
      TangoCloudAdfDownloadService.this.mTask.start();
    }
  };
  private final AtomicInteger mNumDesired = new AtomicInteger(0);
  private final AtomicInteger mNumDownloaded = new AtomicInteger(0);
  private boolean mShowNotifications = false;
  private boolean mStopRequested = false;
  private CacheTilesBackgroundTask mTask = null;
  
  private void postStatusIfUserDebug(String paramString, boolean paramBoolean)
  {
    if (!this.mShowNotifications) {
      return;
    }
    if (this.mNumDesired.get() == 0) {}
    for (int i = 0;; i = (int)(100.0F * this.mNumDownloaded.get() / this.mNumDesired.get()))
    {
      Object localObject = "Tango Cloud ADFs " + i + "%";
      paramString = String.format("%d cached %d desired", new Object[] { Integer.valueOf(this.mNumDownloaded.get()), Integer.valueOf(this.mNumDesired.get()) }) + paramString;
      paramString = new Notification.Builder(this).setContentTitle((CharSequence)localObject).setContentText(paramString).setSubText("").setSmallIcon(2130837531).setAutoCancel(false);
      if (paramBoolean)
      {
        localObject = new Intent(this.mContext, TangoCloudAdfDownloadService.class);
        ((Intent)localObject).setAction("CANCEL");
        paramString.addAction(2130837530, "Cancel All", PendingIntent.getService(this.mContext, 0, (Intent)localObject, 1073741824));
      }
      ((NotificationManager)getSystemService("notification")).notify(0, paramString.build());
      return;
    }
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
    this.mContext = getApplicationContext();
    if ((Build.TYPE.contains("userdebug")) || (Build.TYPE.contains("eng"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mShowNotifications = bool;
      this.mGoogleApiClient = new GoogleApiClient.Builder(this.mContext).addApi(LocationServices.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
      {
        public void onConnected(Bundle paramAnonymousBundle)
        {
          Log.d(TangoCloudAdfDownloadService.TAG, "GoogleApiClient.onConnected()");
          if (ContextCompat.checkSelfPermission(TangoCloudAdfDownloadService.this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0)
          {
            Log.e(TangoCloudAdfDownloadService.TAG, "ACCESS_FINE_LOCATION permission is not granted.");
            TangoCloudAdfDownloadService.this.stopSelf();
            return;
          }
          LocationServices.FusedLocationApi.requestLocationUpdates(TangoCloudAdfDownloadService.this.mGoogleApiClient, TangoCloudAdfDownloadService.LOC_REQUEST, TangoCloudAdfDownloadService.this.mLocationListener);
        }
        
        public void onConnectionSuspended(int paramAnonymousInt)
        {
          Log.d(TangoCloudAdfDownloadService.TAG, "GoogleApiClient.onConnectionSuspended() with cause: " + paramAnonymousInt);
          TangoCloudAdfDownloadService.this.stopSelf();
        }
      }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
      {
        public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
        {
          Log.d(TangoCloudAdfDownloadService.TAG, "GoogleApiClient.onConnectionFailed() with result: " + paramAnonymousConnectionResult.toString());
          TangoCloudAdfDownloadService.this.stopSelf();
        }
      }).build();
      return;
    }
  }
  
  public void onDestroy()
  {
    Log.d(TAG, "onDestroy()");
    if ((this.mGoogleApiClient.isConnected()) || (this.mGoogleApiClient.isConnecting())) {
      this.mGoogleApiClient.disconnect();
    }
    if ((this.mStopRequested) && (this.mTask != null))
    {
      this.mTask.cancel();
      if (this.mNumDownloaded.get() != this.mNumDesired.get()) {
        break label102;
      }
      postStatusIfUserDebug(" (Finished)", false);
    }
    for (;;)
    {
      if (this.mTask != null) {}
      try
      {
        this.mTask.join();
        super.onDestroy();
        return;
        label102:
        postStatusIfUserDebug(" (Aborted)", false);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.e(TAG, localInterruptedException.getMessage());
        }
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("TRIGGERTYPE");
    if ("CANCEL".equals(str))
    {
      Log.d(TAG, "Requesting cancel.");
      this.mStopRequested = true;
      stopSelf();
      return 2;
    }
    if ((this.mGoogleApiClient.isConnected()) || (this.mGoogleApiClient.isConnecting()))
    {
      Log.d(TAG, "Ignoring action [" + str + "] because service is already running.");
      return 2;
    }
    if ((paramIntent != null) && (!paramIntent.equals("MANUAL")) && ((!TangoCloudServiceUtil.isUnmeteredWifiConnected(this)) || (!TangoCloudServiceUtil.isCharging(this))))
    {
      Log.w(TAG, "Wi-Fi is not connected or battery is not charging. Skipping ADF downloading.");
      return 2;
    }
    this.mGoogleApiClient.connect();
    return 2;
  }
  
  private class CacheTilesBackgroundTask
    extends Thread
  {
    final Location mLocation;
    TangoInternal mTangoInternal = null;
    
    public CacheTilesBackgroundTask(Location paramLocation)
    {
      this.mLocation = paramLocation;
    }
    
    private void cacheTiles(Location paramLocation)
    {
      paramLocation = TangoInternal.constructBlocking(TangoCloudAdfDownloadService.this);
      label97:
      for (;;)
      {
        try
        {
          this.mTangoInternal = paramLocation;
          paramLocation.cacheCloudTilesForLocation(this.mLocation, new TangoService.CloudTileProgressCallback()
          {
            public void reportProgress(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              TangoCloudAdfDownloadService.this.mNumDownloaded.set(paramAnonymousInt1);
              TangoCloudAdfDownloadService.this.mNumDesired.set(paramAnonymousInt2);
              TangoCloudAdfDownloadService.this.postStatusIfUserDebug("", true);
            }
          });
          TangoCloudAdfDownloadService.this.postStatusIfUserDebug(" (Aborted)", false);
        }
        finally
        {
          try
          {
            this.mTangoInternal = null;
            if (TangoCloudAdfDownloadService.this.mNumDownloaded.get() != TangoCloudAdfDownloadService.this.mNumDesired.get()) {
              break label97;
            }
            TangoCloudAdfDownloadService.this.postStatusIfUserDebug(" (Finished)", false);
            paramLocation.disconnect();
            TangoCloudAdfDownloadService.this.stopSelf();
            return;
          }
          finally {}
          paramLocation = finally;
        }
      }
    }
    
    public void cancel()
    {
      try
      {
        if (this.mTangoInternal != null) {
          this.mTangoInternal.cancelCloudTileCaching();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void run()
    {
      cacheTiles(this.mLocation);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudservice/TangoCloudAdfDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */