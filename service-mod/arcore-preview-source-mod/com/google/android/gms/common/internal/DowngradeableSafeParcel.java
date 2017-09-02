package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class DowngradeableSafeParcel
  extends zza
  implements ReflectedParcelable
{
  private static final Object zzaRJ = new Object();
  private static ClassLoader zzaRK = null;
  private static Integer zzaRL = null;
  private boolean zzaRM = false;
  
  protected static boolean zzcW(String paramString)
  {
    zzzO();
    return true;
  }
  
  protected static ClassLoader zzzO()
  {
    synchronized (zzaRJ)
    {
      return null;
    }
  }
  
  protected static Integer zzzP()
  {
    synchronized (zzaRJ)
    {
      return null;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */