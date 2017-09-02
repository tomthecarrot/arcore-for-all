package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public abstract class zzn
{
  private static final Object zzaSe = new Object();
  private static zzn zzaSf;
  
  public static zzn zzbb(Context paramContext)
  {
    synchronized (zzaSe)
    {
      if (zzaSf == null) {
        zzaSf = new zzo(paramContext.getApplicationContext());
      }
      return zzaSf;
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  protected abstract boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  public boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return zza(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  protected abstract void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  public void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    zzb(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  protected static final class zza
  {
    private final String mAction;
    private final String zzaSg;
    private final ComponentName zzauU;
    
    public zza(ComponentName paramComponentName)
    {
      this.mAction = null;
      this.zzaSg = null;
      this.zzauU = ((ComponentName)zzac.zzC(paramComponentName));
    }
    
    public zza(String paramString)
    {
      this.mAction = zzac.zzdc(paramString);
      this.zzaSg = "com.google.android.gms";
      this.zzauU = null;
    }
    
    public zza(String paramString1, String paramString2)
    {
      this.mAction = zzac.zzdc(paramString1);
      this.zzaSg = zzac.zzdc(paramString2);
      this.zzauU = null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzaa.equal(this.mAction, ((zza)paramObject).mAction)) && (zzaa.equal(this.zzauU, ((zza)paramObject).zzauU)));
      return false;
    }
    
    public ComponentName getComponentName()
    {
      return this.zzauU;
    }
    
    public String getPackage()
    {
      return this.zzaSg;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { this.mAction, this.zzauU });
    }
    
    public String toString()
    {
      if (this.mAction == null) {
        return this.zzauU.flattenToString();
      }
      return this.mAction;
    }
    
    public Intent zzzT()
    {
      if (this.mAction != null) {
        return new Intent(this.mAction).setPackage(this.zzaSg);
      }
      return new Intent().setComponent(this.zzauU);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */