package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzg<T extends zzg>
{
  private final zzh zzabP;
  protected final zze zzabQ;
  private final List<Object> zzabR;
  
  protected zzg(zzh paramzzh, Clock paramClock)
  {
    zzac.zzC(paramzzh);
    this.zzabP = paramzzh;
    this.zzabR = new ArrayList();
    paramzzh = new zze(this, paramClock);
    paramzzh.zzmR();
    this.zzabQ = paramzzh;
  }
  
  protected void zza(zze paramzze) {}
  
  protected void zzd(zze paramzze)
  {
    paramzze = this.zzabR.iterator();
    while (paramzze.hasNext()) {
      paramzze.next();
    }
  }
  
  protected zzh zzmP()
  {
    return this.zzabP;
  }
  
  public zze zzmS()
  {
    return this.zzabQ;
  }
  
  public List<zzi> zzmT()
  {
    return this.zzabQ.zzmJ();
  }
  
  public zze zzmu()
  {
    zze localzze = this.zzabQ.zzmH();
    zzd(localzze);
    return localzze;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */