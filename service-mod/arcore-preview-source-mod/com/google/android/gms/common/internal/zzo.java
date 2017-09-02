package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzo
  extends zzn
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zzn.zza, zza> zzaSh = new HashMap();
  private final zza zzaSi;
  private final long zzaSj;
  private final long zzaSk;
  private final Context zzwB;
  
  zzo(Context paramContext)
  {
    this.zzwB = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.zzaSi = zza.zzAu();
    this.zzaSj = 5000L;
    this.zzaSk = 300000L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      synchronized (this.zzaSh)
      {
        paramMessage = (zzn.zza)paramMessage.obj;
        ??? = (zza)this.zzaSh.get(paramMessage);
        if ((??? != null) && (((zza)???).zzzU()))
        {
          if (((zza)???).isBound()) {
            ((zza)???).zzcZ("GmsClientSupervisor");
          }
          this.zzaSh.remove(paramMessage);
        }
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.zzaSh)
      {
        zzn.zza localzza1 = (zzn.zza)paramMessage.obj;
        zza localzza = (zza)this.zzaSh.get(localzza1);
        if ((localzza != null) && (localzza.getState() == 3))
        {
          paramMessage = String.valueOf(localzza1);
          Log.wtf("GmsClientSupervisor", String.valueOf(paramMessage).length() + 47 + "Timeout waiting for ServiceConnection callback " + paramMessage, new Exception());
          ??? = localzza.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localzza1.getComponentName();
          }
          if (paramMessage == null)
          {
            paramMessage = new ComponentName(localzza1.getPackage(), "unknown");
            localzza.onServiceDisconnected(paramMessage);
          }
        }
        else
        {
          return true;
        }
      }
    }
  }
  
  protected boolean zza(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zza localzza;
      synchronized (this.zzaSh)
      {
        localzza = (zza)this.zzaSh.get(paramzza);
        if (localzza == null)
        {
          localzza = new zza(paramzza);
          localzza.zza(paramServiceConnection, paramString);
          localzza.zzcY(paramString);
          this.zzaSh.put(paramzza, localzza);
          paramzza = localzza;
          boolean bool = paramzza.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, paramzza);
        if (localzza.zza(paramServiceConnection))
        {
          paramzza = String.valueOf(paramzza);
          throw new IllegalStateException(String.valueOf(paramzza).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzza.zza(paramServiceConnection, paramString);
      switch (localzza.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzza.getComponentName(), localzza.getBinder());
        paramzza = localzza;
        break;
      case 2: 
        localzza.zzcY(paramString);
        paramzza = localzza;
        break;
      default: 
        paramzza = localzza;
      }
    }
  }
  
  protected void zzb(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zza localzza;
    synchronized (this.zzaSh)
    {
      localzza = (zza)this.zzaSh.get(paramzza);
      if (localzza == null)
      {
        paramzza = String.valueOf(paramzza);
        throw new IllegalStateException(String.valueOf(paramzza).length() + 50 + "Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzza.zza(paramServiceConnection))
    {
      paramzza = String.valueOf(paramzza);
      throw new IllegalStateException(String.valueOf(paramzza).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzza.zzb(paramServiceConnection, paramString);
    if (localzza.zzzU())
    {
      paramzza = this.mHandler.obtainMessage(0, paramzza);
      this.mHandler.sendMessageDelayed(paramzza, this.zzaSj);
    }
  }
  
  private final class zza
    implements ServiceConnection
  {
    private int mState;
    private final Set<ServiceConnection> zzaSl;
    private boolean zzaSm;
    private final zzn.zza zzaSn;
    private ComponentName zzauU;
    private IBinder zzsA;
    
    public zza(zzn.zza paramzza)
    {
      this.zzaSn = paramzza;
      this.zzaSl = new HashSet();
      this.mState = 2;
    }
    
    public IBinder getBinder()
    {
      return this.zzsA;
    }
    
    public ComponentName getComponentName()
    {
      return this.zzauU;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.zzaSm;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      synchronized (zzo.zza(zzo.this))
      {
        zzo.zzb(zzo.this).removeMessages(1, this.zzaSn);
        this.zzsA = paramIBinder;
        this.zzauU = paramComponentName;
        Iterator localIterator = this.zzaSl.iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
      }
      this.mState = 1;
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (zzo.zza(zzo.this))
      {
        zzo.zzb(zzo.this).removeMessages(1, this.zzaSn);
        this.zzsA = null;
        this.zzauU = paramComponentName;
        Iterator localIterator = this.zzaSl.iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
      }
      this.mState = 2;
    }
    
    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzo.zzd(zzo.this).zza(zzo.zzc(zzo.this), paramServiceConnection, paramString, this.zzaSn.zzzT());
      this.zzaSl.add(paramServiceConnection);
    }
    
    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return this.zzaSl.contains(paramServiceConnection);
    }
    
    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzo.zzd(zzo.this).zzb(zzo.zzc(zzo.this), paramServiceConnection);
      this.zzaSl.remove(paramServiceConnection);
    }
    
    public void zzcY(String paramString)
    {
      this.mState = 3;
      this.zzaSm = zzo.zzd(zzo.this).zza(zzo.zzc(zzo.this), paramString, this.zzaSn.zzzT(), this, 129);
      if (this.zzaSm)
      {
        paramString = zzo.zzb(zzo.this).obtainMessage(1, this.zzaSn);
        zzo.zzb(zzo.this).sendMessageDelayed(paramString, zzo.zze(zzo.this));
        return;
      }
      this.mState = 2;
      try
      {
        zzo.zzd(zzo.this).zza(zzo.zzc(zzo.this), this);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public void zzcZ(String paramString)
    {
      zzo.zzb(zzo.this).removeMessages(1, this.zzaSn);
      zzo.zzd(zzo.this).zza(zzo.zzc(zzo.this), this);
      this.zzaSm = false;
      this.mState = 2;
    }
    
    public boolean zzzU()
    {
      return this.zzaSl.isEmpty();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */