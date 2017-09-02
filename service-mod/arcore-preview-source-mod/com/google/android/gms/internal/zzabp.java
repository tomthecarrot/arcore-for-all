package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzf.zza;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class zzabp
  extends zzf<zzabn>
{
  private static zzabp zzaTc;
  
  protected zzabp()
  {
    super("com.google.android.gms.common.net.SocketFactoryCreatorImpl");
  }
  
  public static zzabp zzAj()
  {
    if (zzaTc == null) {
      zzaTc = new zzabp();
    }
    return zzaTc;
  }
  
  public SSLSocketFactory zza(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, String paramString)
  {
    try
    {
      paramContext = (SSLSocketFactory)zzd.zzI(((zzabn)zzbs(paramContext)).zza(zzd.zzJ(paramContext), zzd.zzJ(paramArrayOfKeyManager), zzd.zzJ(paramArrayOfTrustManager), paramString));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (zzf.zza paramContext)
    {
      for (;;) {}
    }
  }
  
  public SSLSocketFactory zza(Context paramContext, KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, boolean paramBoolean)
  {
    try
    {
      paramContext = (SSLSocketFactory)zzd.zzI(((zzabn)zzbs(paramContext)).zza(zzd.zzJ(paramContext), zzd.zzJ(paramArrayOfKeyManager), zzd.zzJ(paramArrayOfTrustManager), paramBoolean));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (zzf.zza paramContext)
    {
      for (;;) {}
    }
  }
  
  protected zzabn zzdq(IBinder paramIBinder)
  {
    return zzabn.zza.zzdp(paramIBinder);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */