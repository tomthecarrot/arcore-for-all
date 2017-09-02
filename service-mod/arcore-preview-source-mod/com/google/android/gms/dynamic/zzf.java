package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzac;

public abstract class zzf<T>
{
  private final String zzbin;
  private T zzbio;
  
  protected zzf(String paramString)
  {
    this.zzbin = paramString;
  }
  
  protected final T zzbs(Context paramContext)
    throws zzf.zza
  {
    if (this.zzbio == null)
    {
      zzac.zzC(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.zzbio = zzc((IBinder)paramContext.loadClass(this.zzbin).newInstance());
      return (T)this.zzbio;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  protected abstract T zzc(IBinder paramIBinder);
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/dynamic/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */