package com.google.atap.tango;

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

class LocationProvider
{
  private static final int LOCATION_FASTEST_INTERVAL_MS = 2000;
  private static final int LOCATION_INTERVAL_MS = 5000;
  private static final LocationRequest LOC_REQUEST = new LocationRequest().setInterval(5000L).setFastestInterval(2000L).setPriority(100);
  private static final String TAG = LocationProvider.class.getSimpleName();
  boolean mEnabled = false;
  private final GoogleApiClient mGoogleApiClient;
  final long mNativeLocationProvider;
  
  public LocationProvider(final Context paramContext, long paramLong)
  {
    this.mNativeLocationProvider = paramLong;
    this.mGoogleApiClient = new GoogleApiClient.Builder(paramContext).addApi(LocationServices.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        Log.d(LocationProvider.TAG, "GoogleApiClient onConnected");
        if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          Log.e(LocationProvider.TAG, "ACCESS_FINE_LOCATION permission is not granted.");
          Toast.makeText(paramContext, "TangoCore is using features that require the LOCATION permission. Please visit system settings to grant permissions to TangoCore.", 1).show();
          return;
        }
        paramAnonymousBundle = LocationServices.FusedLocationApi.getLastLocation(LocationProvider.this.mGoogleApiClient);
        LocationProvider.this.onLocationUpdate(paramAnonymousBundle);
        Log.d(LocationProvider.TAG, "Calling requestLocationUpdates()");
        try
        {
          LocationServices.FusedLocationApi.requestLocationUpdates(LocationProvider.this.mGoogleApiClient, LocationProvider.LOC_REQUEST, new LocationListener()
          {
            public void onLocationChanged(Location paramAnonymous2Location)
            {
              LocationProvider.this.onLocationUpdate(paramAnonymous2Location);
            }
          });
          return;
        }
        catch (IllegalStateException paramAnonymousBundle)
        {
          Log.d(LocationProvider.TAG, "Using mGoogleApiClient after it is disconnected.");
        }
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        Log.d(LocationProvider.TAG, "GoogleApiClient onConnectionSuspended cause=" + paramAnonymousInt);
      }
    }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        Log.d(LocationProvider.TAG, "GoogleApiClient onConnectionFailed");
      }
    }).build();
  }
  
  private native void nativeOnLocationUpdate(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, double paramDouble4);
  
  /* Error */
  private void onLocationUpdate(Location paramLocation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/google/atap/tango/LocationProvider:mEnabled	Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifeq +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: invokevirtual 118	android/location/Location:getElapsedRealtimeNanos	()J
    //   24: lstore 7
    //   26: lload 7
    //   28: ldc2_w 119
    //   31: ldiv
    //   32: l2d
    //   33: dstore_2
    //   34: lload 7
    //   36: ldc2_w 119
    //   39: lrem
    //   40: l2d
    //   41: ldc2_w 121
    //   44: ddiv
    //   45: dstore 4
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 64	com/google/atap/tango/LocationProvider:mNativeLocationProvider	J
    //   52: aload_1
    //   53: invokevirtual 126	android/location/Location:getLatitude	()D
    //   56: aload_1
    //   57: invokevirtual 129	android/location/Location:getLongitude	()D
    //   60: aload_1
    //   61: invokevirtual 132	android/location/Location:getAltitude	()D
    //   64: aload_1
    //   65: invokevirtual 136	android/location/Location:getAccuracy	()F
    //   68: dload_2
    //   69: dload 4
    //   71: dadd
    //   72: invokespecial 138	com/google/atap/tango/LocationProvider:nativeOnLocationUpdate	(JDDDFD)V
    //   75: goto -58 -> 17
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	LocationProvider
    //   0	83	1	paramLocation	Location
    //   33	36	2	d1	double
    //   45	25	4	d2	double
    //   6	3	6	bool	boolean
    //   24	11	7	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	78	finally
    //   20	75	78	finally
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.mEnabled)
        {
          this.mGoogleApiClient.connect();
          this.mEnabled = true;
        }
        return;
      }
      finally {}
      if (this.mEnabled)
      {
        this.mGoogleApiClient.disconnect();
        this.mEnabled = false;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/LocationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */