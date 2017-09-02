package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public class zza
  extends zzr.zza
{
  int zzsy;
  
  public static Account zza(zzr paramzzr)
  {
    Account localAccount = null;
    long l;
    if (paramzzr != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramzzr.getAccount();
      return localAccount;
    }
    catch (RemoteException paramzzr)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    throw new NullPointerException();
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.zzsy) {
      return null;
    }
    if (GooglePlayServicesUtilLight.zzf(null, i))
    {
      this.zzsy = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */