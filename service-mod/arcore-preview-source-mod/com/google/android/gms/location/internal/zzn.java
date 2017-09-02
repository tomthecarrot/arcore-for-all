package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaaj;
import com.google.android.gms.internal.zzyr.zzb;
import com.google.android.gms.internal.zzzw;
import com.google.android.gms.internal.zzzw.zzb;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zzv;

public class zzn
  extends zzb
{
  private final zzm zzbEO = new zzm(paramContext, this.zzbEw);
  
  public zzn(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, zzg.zzaZ(paramContext));
  }
  
  public zzn(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzg paramzzg)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzg);
  }
  
  public void disconnect()
  {
    synchronized (this.zzbEO)
    {
      boolean bool = isConnected();
      if (bool) {}
      try
      {
        this.zzbEO.removeAllListeners();
        this.zzbEO.zzKq();
        super.disconnect();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
    }
  }
  
  public Location getLastLocation()
  {
    return this.zzbEO.getLastLocation();
  }
  
  public LocationAvailability zzKp()
  {
    return this.zzbEO.zzKp();
  }
  
  public ActivityRecognitionResult zzKr()
    throws RemoteException
  {
    zzzv();
    return ((zzk)zzzw()).zzeR(getContext().getPackageName());
  }
  
  public void zza(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzzv();
    zzac.zzC(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "detectionIntervalMillis must be >= 0");
      ((zzk)zzzw()).zza(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void zza(PendingIntent paramPendingIntent, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzaaj(paramzzb);
    ((zzk)zzzw()).zzb(paramPendingIntent, paramzzb);
  }
  
  public void zza(PendingIntent paramPendingIntent, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEO.zza(paramPendingIntent, paramzzi);
  }
  
  public void zza(Location paramLocation, int paramInt)
    throws RemoteException
  {
    this.zzbEO.zza(paramLocation, paramInt);
  }
  
  public void zza(zzzw.zzb<LocationListener> paramzzb, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEO.zza(paramzzb, paramzzi);
  }
  
  public void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramGeofencingRequest, "geofencingRequest can't be null.");
    zzac.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zza(paramzzb);
    ((zzk)zzzw()).zza(paramGeofencingRequest, paramPendingIntent, paramzzb);
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEO.zza(paramLocationRequest, paramPendingIntent, paramzzi);
  }
  
  public void zza(LocationRequest paramLocationRequest, zzzw<LocationListener> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    synchronized (this.zzbEO)
    {
      this.zzbEO.zza(paramLocationRequest, paramzzzw, paramzzi);
      return;
    }
  }
  
  public void zza(LocationSettingsRequest paramLocationSettingsRequest, zzyr.zzb<LocationSettingsResult> paramzzb, String paramString)
    throws RemoteException
  {
    boolean bool2 = true;
    zzzv();
    if (paramLocationSettingsRequest != null)
    {
      bool1 = true;
      zzac.zzb(bool1, "locationSettingsRequest can't be null nor empty.");
      if (paramzzb == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, "listener can't be null.");
      paramzzb = new zzc(paramzzb);
      ((zzk)zzzw()).zza(paramLocationSettingsRequest, paramzzb, paramString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void zza(zzi paramzzi)
    throws RemoteException
  {
    this.zzbEO.zza(paramzzi);
  }
  
  public void zza(zzo paramzzo, zzzw<LocationListener> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    synchronized (this.zzbEO)
    {
      this.zzbEO.zza(paramzzo, paramzzzw, paramzzi);
      return;
    }
  }
  
  public void zza(zzv paramzzv, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramzzv, "removeGeofencingRequest can't be null.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzb(paramzzb);
    ((zzk)zzzw()).zza(paramzzv, paramzzb);
  }
  
  public void zzaQ(boolean paramBoolean)
    throws RemoteException
  {
    this.zzbEO.zzaQ(paramBoolean);
  }
  
  public void zzb(PendingIntent paramPendingIntent, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzaaj(paramzzb);
    ((zzk)zzzw()).zzc(paramPendingIntent, paramzzb);
  }
  
  public void zzb(zzzw.zzb<LocationCallback> paramzzb, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEO.zzb(paramzzb, paramzzi);
  }
  
  public void zzb(zzo paramzzo, zzzw<LocationCallback> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    synchronized (this.zzbEO)
    {
      this.zzbEO.zzb(paramzzo, paramzzzw, paramzzi);
      return;
    }
  }
  
  public void zzc(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzzv();
    zzac.zzC(paramPendingIntent);
    ((zzk)zzzw()).zzc(paramPendingIntent);
  }
  
  public void zzc(PendingIntent paramPendingIntent, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzaaj(paramzzb);
    ((zzk)zzzw()).zzd(paramPendingIntent, paramzzb);
  }
  
  public void zzd(PendingIntent paramPendingIntent, zzyr.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzzv();
    zzac.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzac.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzaaj(paramzzb);
    ((zzk)zzzw()).zze(paramPendingIntent, paramzzb);
  }
  
  public void zzd(Location paramLocation)
    throws RemoteException
  {
    this.zzbEO.zzd(paramLocation);
  }
  
  private static final class zza
    extends zzj.zza
  {
    private zzyr.zzb<Status> zzbEP;
    
    public zza(zzyr.zzb<Status> paramzzb)
    {
      this.zzbEP = paramzzb;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      if (this.zzbEP == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      paramArrayOfString = LocationStatusCodes.zzoe(LocationStatusCodes.zzod(paramInt));
      this.zzbEP.setResult(paramArrayOfString);
      this.zzbEP = null;
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
  }
  
  private static final class zzb
    extends zzj.zza
  {
    private zzyr.zzb<Status> zzbEP;
    
    public zzb(zzyr.zzb<Status> paramzzb)
    {
      this.zzbEP = paramzzb;
    }
    
    private void zzol(int paramInt)
    {
      if (this.zzbEP == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
        return;
      }
      Status localStatus = LocationStatusCodes.zzoe(LocationStatusCodes.zzod(paramInt));
      this.zzbEP.setResult(localStatus);
      this.zzbEP = null;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      zzol(paramInt);
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      zzol(paramInt);
    }
  }
  
  private static final class zzc
    extends zzl.zza
  {
    private zzyr.zzb<LocationSettingsResult> zzbEP;
    
    public zzc(zzyr.zzb<LocationSettingsResult> paramzzb)
    {
      if (paramzzb != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "listener can't be null.");
        this.zzbEP = paramzzb;
        return;
      }
    }
    
    public void zza(LocationSettingsResult paramLocationSettingsResult)
      throws RemoteException
    {
      this.zzbEP.setResult(paramLocationSettingsResult);
      this.zzbEP = null;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */