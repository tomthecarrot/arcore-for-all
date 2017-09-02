package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api.zzg;

public class zzal<T extends IInterface>
  extends zzl<T>
{
  private final Api.zzg<T> zzaSL;
  
  public Api.zzg<T> zzAh()
  {
    return this.zzaSL;
  }
  
  protected String zzeJ()
  {
    return this.zzaSL.zzeJ();
  }
  
  protected String zzeK()
  {
    return this.zzaSL.zzeK();
  }
  
  protected T zzh(IBinder paramIBinder)
  {
    return this.zzaSL.zzh(paramIBinder);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */