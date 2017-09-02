package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaac;
import com.google.android.gms.internal.zzaao;
import com.google.android.gms.internal.zzaap;
import com.google.android.gms.internal.zzaas;
import com.google.android.gms.internal.zzasn;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.internal.zzzw;
import com.google.android.gms.internal.zzzw.zzb;
import com.google.android.gms.internal.zzzx;
import com.google.android.gms.location.internal.zzf;
import com.google.android.gms.location.internal.zzi.zza;
import com.google.android.gms.location.internal.zzn;
import com.google.android.gms.location.internal.zzo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient
  extends zzd<Api.ApiOptions.NoOptions>
{
  public FusedLocationProviderClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new zzym());
  }
  
  public FusedLocationProviderClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new zzym());
  }
  
  private Task<Void> zza(final zzzw<LocationListener> paramzzzw, final zzo paramzzo)
  {
    doRegisterEventListener(new zzaac(paramzzzw)new zzaas
    {
      protected void zzb(zzn paramAnonymouszzn, TaskCompletionSource<Void> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymousTaskCompletionSource = new FusedLocationProviderClient.zza(paramAnonymousTaskCompletionSource);
        paramAnonymouszzn.zza(paramzzo, paramzzzw, paramAnonymousTaskCompletionSource);
      }
    }, new zzaas(paramzzzw.zzyK())
    {
      protected void zzc(zzn paramAnonymouszzn, TaskCompletionSource<Void> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymouszzn.zza(zzyK(), null);
      }
    });
  }
  
  public Task<Void> flushLocations()
  {
    return zzab.zzb(LocationServices.FusedLocationApi.flushLocations(asGoogleApiClient()));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Location> getLastLocation()
  {
    doRead(new zzaao()
    {
      protected void zza(zzn paramAnonymouszzn, TaskCompletionSource<Location> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymousTaskCompletionSource.setResult(paramAnonymouszzn.getLastLocation());
      }
    });
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<LocationAvailability> getLocationAvailability()
  {
    doRead(new zzaao()
    {
      protected void zza(zzn paramAnonymouszzn, TaskCompletionSource<LocationAvailability> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymousTaskCompletionSource.setResult(paramAnonymouszzn.zzKp());
      }
    });
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> injectLocation(Location paramLocation, int paramInt)
  {
    return zzab.zzb(LocationServices.FusedLocationApi.injectLocation(asGoogleApiClient(), paramLocation, paramInt));
  }
  
  public Task<Void> removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    return zzab.zzb(LocationServices.FusedLocationApi.removeLocationUpdates(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Void> removeLocationUpdates(LocationCallback paramLocationCallback)
  {
    return doUnregisterEventListener(zzzx.zza(paramLocationCallback, LocationCallback.class.getSimpleName()));
  }
  
  public Task<Void> removeLocationUpdates(LocationListener paramLocationListener)
  {
    return doUnregisterEventListener(zzzx.zza(paramLocationListener, LocationListener.class.getSimpleName()));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    return zzab.zzb(LocationServices.FusedLocationApi.requestLocationUpdates(asGoogleApiClient(), paramLocationRequest, paramPendingIntent));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
  {
    return zza(zzo.zzb(paramLocationRequest), paramLocationCallback, paramLooper);
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    return zza(registerListener(paramLocationListener, LocationListener.class.getSimpleName()), zzo.zzb(paramLocationRequest));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    return zza(zzo.zzb(paramLocationRequest), paramLocationListener, paramLooper);
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> setMockLocation(Location paramLocation)
  {
    return zzab.zzb(LocationServices.FusedLocationApi.setMockLocation(asGoogleApiClient(), paramLocation));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> setMockMode(boolean paramBoolean)
  {
    return zzab.zzb(LocationServices.FusedLocationApi.setMockMode(asGoogleApiClient(), paramBoolean));
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> zza(final zzo paramzzo, final LocationCallback paramLocationCallback, Looper paramLooper)
  {
    paramLocationCallback = zzzx.zzb(paramLocationCallback, zzasn.zzc(paramLooper), LocationCallback.class.getSimpleName());
    doRegisterEventListener(new zzaac(paramLocationCallback)new zzaas
    {
      protected void zzb(zzn paramAnonymouszzn, TaskCompletionSource<Void> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymousTaskCompletionSource = new FusedLocationProviderClient.zza(paramAnonymousTaskCompletionSource);
        paramAnonymouszzn.zzb(paramzzo, paramLocationCallback, paramAnonymousTaskCompletionSource);
      }
    }, new zzaas(paramLocationCallback.zzyK())
    {
      protected void zzc(zzn paramAnonymouszzn, TaskCompletionSource<Void> paramAnonymousTaskCompletionSource)
        throws RemoteException
      {
        paramAnonymouszzn.zzb(zzyK(), null);
      }
    });
  }
  
  @RequiresPermission(anyOf={"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
  public Task<Void> zza(zzo paramzzo, LocationListener paramLocationListener, Looper paramLooper)
  {
    return zza(zzzx.zzb(paramLocationListener, zzasn.zzc(paramLooper), LocationListener.class.getSimpleName()), paramzzo);
  }
  
  private static class zza
    extends zzi.zza
  {
    private final TaskCompletionSource<Void> zzamh;
    
    public zza(TaskCompletionSource<Void> paramTaskCompletionSource)
    {
      this.zzamh = paramTaskCompletionSource;
    }
    
    public void zza(zzf paramzzf)
    {
      zzaap.zza(paramzzf.getStatus(), this.zzamh);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/FusedLocationProviderClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */