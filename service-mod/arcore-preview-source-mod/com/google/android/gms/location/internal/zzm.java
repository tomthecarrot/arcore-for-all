package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzzw;
import com.google.android.gms.internal.zzzw.zzb;
import com.google.android.gms.internal.zzzw.zzc;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzn;
import com.google.android.gms.location.zzn.zza;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzm
{
  private final Context mContext;
  private final Map<zzzw.zzb<LocationListener>, zzb> zzavB = new HashMap();
  private ContentProviderClient zzbEJ = null;
  private boolean zzbEK = false;
  private final Map<zzzw.zzb<LocationCallback>, zza> zzbEL = new HashMap();
  private final zzv<zzk> zzbEw;
  
  public zzm(Context paramContext, zzv<zzk> paramzzv)
  {
    this.mContext = paramContext;
    this.zzbEw = paramzzv;
  }
  
  private zzb zzf(zzzw<LocationListener> paramzzzw)
  {
    synchronized (this.zzavB)
    {
      zzb localzzb2 = (zzb)this.zzavB.get(paramzzzw.zzyK());
      zzb localzzb1 = localzzb2;
      if (localzzb2 == null) {
        localzzb1 = new zzb(paramzzzw);
      }
      this.zzavB.put(paramzzzw.zzyK(), localzzb1);
      return localzzb1;
    }
  }
  
  private zza zzg(zzzw<LocationCallback> paramzzzw)
  {
    synchronized (this.zzbEL)
    {
      zza localzza2 = (zza)this.zzbEL.get(paramzzzw.zzyK());
      zza localzza1 = localzza2;
      if (localzza2 == null) {
        localzza1 = new zza(paramzzzw);
      }
      this.zzbEL.put(paramzzzw.zzyK(), localzza1);
      return localzza1;
    }
  }
  
  public Location getLastLocation()
  {
    this.zzbEw.zzzv();
    try
    {
      Location localLocation = ((zzk)this.zzbEw.zzzw()).zzeS(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    Object localObject3;
    try
    {
      synchronized (this.zzavB)
      {
        Iterator localIterator1 = this.zzavB.values().iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (zzb)localIterator1.next();
          if (localObject3 != null) {
            ((zzk)this.zzbEw.zzzw()).zza(zzq.zza((zzn)localObject3, null));
          }
        }
      }
      this.zzavB.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
    synchronized (this.zzbEL)
    {
      Iterator localIterator2 = this.zzbEL.values().iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (zza)localIterator2.next();
        if (localObject3 != null) {
          ((zzk)this.zzbEw.zzzw()).zza(zzq.zza((com.google.android.gms.location.zzm)localObject3, null));
        }
      }
    }
    this.zzbEL.clear();
  }
  
  public LocationAvailability zzKp()
  {
    this.zzbEw.zzzv();
    try
    {
      LocationAvailability localLocationAvailability = ((zzk)this.zzbEw.zzzw()).zzeT(this.mContext.getPackageName());
      return localLocationAvailability;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzKq()
  {
    if (this.zzbEK) {}
    try
    {
      zzaQ(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zza(PendingIntent paramPendingIntent, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zza(zzq.zzb(paramPendingIntent, paramzzi));
  }
  
  public void zza(Location paramLocation, int paramInt)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zza(paramLocation, paramInt);
  }
  
  public void zza(zzzw.zzb<LocationListener> paramzzb, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    zzac.zzb(paramzzb, "Invalid null listener key");
    synchronized (this.zzavB)
    {
      paramzzb = (zzb)this.zzavB.remove(paramzzb);
      if (paramzzb != null)
      {
        paramzzb.release();
        ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(paramzzb, paramzzi));
      }
      return;
    }
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(zzo.zzb(paramLocationRequest), paramPendingIntent, paramzzi));
  }
  
  public void zza(LocationRequest paramLocationRequest, zzzw<LocationListener> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    paramzzzw = zzf(paramzzzw);
    ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(zzo.zzb(paramLocationRequest), paramzzzw, paramzzi));
  }
  
  public void zza(zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zza(paramzzi);
  }
  
  public void zza(zzo paramzzo, zzzw<LocationListener> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    paramzzzw = zzf(paramzzzw);
    ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(paramzzo, paramzzzw, paramzzi));
  }
  
  public void zzaQ(boolean paramBoolean)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zzaQ(paramBoolean);
    this.zzbEK = paramBoolean;
  }
  
  public void zzb(zzzw.zzb<LocationCallback> paramzzb, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    zzac.zzb(paramzzb, "Invalid null listener key");
    synchronized (this.zzbEL)
    {
      paramzzb = (zza)this.zzbEL.remove(paramzzb);
      if (paramzzb != null)
      {
        paramzzb.release();
        ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(paramzzb, paramzzi));
      }
      return;
    }
  }
  
  public void zzb(zzo paramzzo, zzzw<LocationCallback> paramzzzw, zzi paramzzi)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    paramzzzw = zzg(paramzzzw);
    ((zzk)this.zzbEw.zzzw()).zza(zzq.zza(paramzzo, paramzzzw, paramzzi));
  }
  
  public void zzd(Location paramLocation)
    throws RemoteException
  {
    this.zzbEw.zzzv();
    ((zzk)this.zzbEw.zzzw()).zzd(paramLocation);
  }
  
  private static class zza
    extends com.google.android.gms.location.zzm.zza
  {
    private final zzzw<LocationCallback> zzaOL;
    
    zza(zzzw<LocationCallback> paramzzzw)
    {
      this.zzaOL = paramzzzw;
    }
    
    public void onLocationAvailability(final LocationAvailability paramLocationAvailability)
    {
      this.zzaOL.zza(new zzzw.zzc()
      {
        public void zza(LocationCallback paramAnonymousLocationCallback)
        {
          paramAnonymousLocationCallback.onLocationAvailability(paramLocationAvailability);
        }
        
        public void zzxO() {}
      });
    }
    
    public void onLocationResult(final LocationResult paramLocationResult)
    {
      this.zzaOL.zza(new zzzw.zzc()
      {
        public void zza(LocationCallback paramAnonymousLocationCallback)
        {
          paramAnonymousLocationCallback.onLocationResult(paramLocationResult);
        }
        
        public void zzxO() {}
      });
    }
    
    public void release()
    {
      try
      {
        this.zzaOL.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static class zzb
    extends zzn.zza
  {
    private final zzzw<LocationListener> zzaOL;
    
    zzb(zzzw<LocationListener> paramzzzw)
    {
      this.zzaOL = paramzzzw;
    }
    
    public void onLocationChanged(final Location paramLocation)
    {
      try
      {
        this.zzaOL.zza(new zzzw.zzc()
        {
          public void zza(LocationListener paramAnonymousLocationListener)
          {
            paramAnonymousLocationListener.onLocationChanged(paramLocation);
          }
          
          public void zzxO() {}
        });
        return;
      }
      finally
      {
        paramLocation = finally;
        throw paramLocation;
      }
    }
    
    public void release()
    {
      try
      {
        this.zzaOL.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/location/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */