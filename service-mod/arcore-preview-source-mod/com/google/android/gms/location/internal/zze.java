package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzasn;
import com.google.android.gms.internal.zzyr.zzb;
import com.google.android.gms.internal.zzzx;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.zza;

public class zze
  implements FusedLocationProviderApi
{
  public PendingResult<Status> flushLocations(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(new zze.zzb(this));
      }
    });
  }
  
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzq(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzq(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.zzKp();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public PendingResult<Status> injectLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation, final int paramInt)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(paramLocation, paramInt);
        zzb(Status.zzaLc);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        zze.zzb localzzb = new zze.zzb(this);
        paramAnonymouszzn.zza(paramPendingIntent, localzzb);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationCallback paramLocationCallback)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzb(zzzx.zza(paramLocationCallback, LocationCallback.class.getSimpleName()), new zze.zzb(this));
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zza(zzzx.zza(paramLocationListener, LocationListener.class.getSimpleName()), new zze.zzb(this));
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        zze.zzb localzzb = new zze.zzb(this);
        paramAnonymouszzn.zza(paramLocationRequest, paramPendingIntent, localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationCallback paramLocationCallback, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        zze.zzb localzzb = new zze.zzb(this);
        paramAnonymouszzn.zzb(zzo.zzb(paramLocationRequest), zzzx.zzb(paramLocationCallback, zzasn.zzc(paramLooper), LocationCallback.class.getSimpleName()), localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    zzac.zzb(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        zze.zzb localzzb = new zze.zzb(this);
        paramAnonymouszzn.zza(paramLocationRequest, zzzx.zzb(paramLocationListener, zzasn.zzLc(), LocationListener.class.getSimpleName()), localzzb);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        zze.zzb localzzb = new zze.zzb(this);
        paramAnonymouszzn.zza(paramLocationRequest, zzzx.zzb(paramLocationListener, zzasn.zzc(paramLooper), LocationListener.class.getSimpleName()), localzzb);
      }
    });
  }
  
  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzd(paramLocation);
        zzb(Status.zzaLc);
      }
    });
  }
  
  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzn paramAnonymouszzn)
        throws RemoteException
      {
        paramAnonymouszzn.zzaQ(paramBoolean);
        zzb(Status.zzaLc);
      }
    });
  }
  
  private static abstract class zza
    extends LocationServices.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static class zzb
    extends zzi.zza
  {
    private final zzyr.zzb<Status> zzaOS;
    
    public zzb(zzyr.zzb<Status> paramzzb)
    {
      this.zzaOS = paramzzb;
    }
    
    public void zza(zzf paramzzf)
    {
      this.zzaOS.setResult(paramzzf.getStatus());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */