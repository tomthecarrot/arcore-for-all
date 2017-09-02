package com.google.tango.cloudlib;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.tango.javacommon.FileUtils;
import java.io.IOException;

public class CloudNavigationGraphManager
{
  private static final int LOCATION_FASTEST_INTERVAL_MS = 2000;
  private static final int LOCATION_INTERVAL_MS = 5000;
  private static final LocationRequest LOC_REQUEST = new LocationRequest().setInterval(5000L).setFastestInterval(2000L).setPriority(100);
  private static final String TAG = "CloudNavigationGraphManager";
  private final String mApiKey;
  private final String mCacheDirectory;
  private final Callbacks mCallbacks;
  private final Context mContext;
  private final Object mDownloaderLock = new Object();
  private final GoogleApiClient mGoogleApiClient;
  private LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      synchronized (CloudNavigationGraphManager.this.mDownloaderLock)
      {
        if (CloudNavigationGraphManager.this.mNavigationGraphDownloader == null)
        {
          Log.w("CloudNavigationGraphManager", "Got updated location but mNavigationGraphDownloader is null; doing nothing.");
          return;
        }
        Utils.verboseDebugLog("CloudNavigationGraphManager", "Got updated location.");
        CloudNavigationGraphManager.this.mNavigationGraphDownloader.updateLocation(paramAnonymousLocation);
      }
    }
  };
  private NavigationGraphDownloader mNavigationGraphDownloader;
  private NavigationGraphDownloader.Callbacks mNavigationGraphDownloaderCallbacks = new NavigationGraphDownloader.Callbacks()
  {
    public void onNavigationGraphAvailable(String paramAnonymousString)
    {
      CloudNavigationGraphManager.this.mCallbacks.onNavigationGraphAvailable(paramAnonymousString);
      CloudNavigationGraphManager.this.mCallbacks.onDebugEvent("NavigationGraphLoaded", "");
    }
    
    public void onNetworkFailure()
    {
      CloudNavigationGraphManager.this.mCallbacks.onCloudEvent(102, 0);
      CloudNavigationGraphManager.this.mCallbacks.onDebugEvent("NavigationGraphDownloadFailure", "");
    }
  };
  
  public CloudNavigationGraphManager(Context paramContext, String paramString1, String paramString2, Callbacks paramCallbacks)
  {
    Log.d("CloudNavigationGraphManager", "onCreate()");
    this.mContext = paramContext;
    this.mCallbacks = paramCallbacks;
    this.mCacheDirectory = paramString1;
    this.mApiKey = paramString2;
    this.mGoogleApiClient = new GoogleApiClient.Builder(this.mContext).addApi(LocationServices.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        Log.i("CloudNavigationGraphManager", "GoogleApiClient connection has been connected.");
        if (ContextCompat.checkSelfPermission(CloudNavigationGraphManager.this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          Log.e("CloudNavigationGraphManager", "ACCESS_FINE_LOCATION permission is not granted.");
          Toast.makeText(CloudNavigationGraphManager.this.mContext, "TangoCore requires LOCATION permissions to use cloud ADFs. Visit system settings to grant permission.", 1).show();
          return;
        }
        Location localLocation = LocationServices.FusedLocationApi.getLastLocation(CloudNavigationGraphManager.this.mGoogleApiClient);
        paramAnonymousBundle = CloudNavigationGraphManager.this.mDownloaderLock;
        if (localLocation != null) {}
        try
        {
          if (CloudNavigationGraphManager.this.mNavigationGraphDownloader != null) {
            CloudNavigationGraphManager.this.mNavigationGraphDownloader.updateLocation(localLocation);
          }
          Log.d("CloudNavigationGraphManager", "Calling requestLocationUpdates()");
          LocationServices.FusedLocationApi.requestLocationUpdates(CloudNavigationGraphManager.this.mGoogleApiClient, CloudNavigationGraphManager.LOC_REQUEST, CloudNavigationGraphManager.this.mLocationListener);
          return;
        }
        finally {}
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        Log.d("CloudNavigationGraphManager", "GoogleApiClient connection has been suspended.");
      }
    }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        Log.i("CloudNavigationGraphManager", "GoogleApiClient connection has failed.");
      }
    }).build();
  }
  
  public static void clearCache(String paramString)
    throws IOException
  {
    FileUtils.deleteDirectoryRecursive(paramString);
  }
  
  public static boolean isCacheEmpty(String paramString)
  {
    return !FileUtils.nonEmptyDirectoryExists(paramString);
  }
  
  public boolean start()
  {
    Log.d("CloudNavigationGraphManager", "start()");
    synchronized (this.mDownloaderLock)
    {
      this.mNavigationGraphDownloader = new NavigationGraphDownloader(this.mContext, new NavigationGraphCache(this.mContext, this.mCacheDirectory), this.mApiKey, this.mNavigationGraphDownloaderCallbacks);
      this.mGoogleApiClient.connect();
      return true;
    }
  }
  
  public boolean stop()
  {
    Log.d("CloudNavigationGraphManager", "stop()");
    synchronized (this.mDownloaderLock)
    {
      this.mGoogleApiClient.disconnect();
      if (this.mNavigationGraphDownloader != null)
      {
        this.mNavigationGraphDownloader.stop();
        this.mNavigationGraphDownloader = null;
      }
      return true;
    }
  }
  
  public static abstract interface Callbacks
  {
    public abstract void onCloudEvent(int paramInt1, int paramInt2);
    
    public abstract void onDebugEvent(String paramString1, String paramString2);
    
    public abstract void onNavigationGraphAvailable(String paramString);
  }
  
  public class Event
  {
    public static final int STATUS_FAILURE = 102;
    
    public Event() {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/CloudNavigationGraphManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */