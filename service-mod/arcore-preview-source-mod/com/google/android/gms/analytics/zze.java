package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zze
{
  private final zzg zzabF;
  private boolean zzabG;
  private long zzabH;
  private long zzabI;
  private long zzabJ;
  private long zzabK;
  private long zzabL;
  private boolean zzabM;
  private final Map<Class<? extends zzf>, zzf> zzabN;
  private final List<zzi> zzabO;
  private final Clock zzvi;
  
  zze(zze paramzze)
  {
    this.zzabF = paramzze.zzabF;
    this.zzvi = paramzze.zzvi;
    this.zzabH = paramzze.zzabH;
    this.zzabI = paramzze.zzabI;
    this.zzabJ = paramzze.zzabJ;
    this.zzabK = paramzze.zzabK;
    this.zzabL = paramzze.zzabL;
    this.zzabO = new ArrayList(paramzze.zzabO);
    this.zzabN = new HashMap(paramzze.zzabN.size());
    paramzze = paramzze.zzabN.entrySet().iterator();
    while (paramzze.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzze.next();
      zzf localzzf = zzc((Class)localEntry.getKey());
      ((zzf)localEntry.getValue()).zzb(localzzf);
      this.zzabN.put((Class)localEntry.getKey(), localzzf);
    }
  }
  
  zze(zzg paramzzg, Clock paramClock)
  {
    zzac.zzC(paramzzg);
    zzac.zzC(paramClock);
    this.zzabF = paramzzg;
    this.zzvi = paramClock;
    this.zzabK = 1800000L;
    this.zzabL = 3024000000L;
    this.zzabN = new HashMap();
    this.zzabO = new ArrayList();
  }
  
  private static <T extends zzf> T zzc(Class<T> paramClass)
  {
    try
    {
      paramClass = (zzf)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
    }
  }
  
  public <T extends zzf> T zza(Class<T> paramClass)
  {
    return (zzf)this.zzabN.get(paramClass);
  }
  
  public void zza(zzf paramzzf)
  {
    zzac.zzC(paramzzf);
    Class localClass = paramzzf.getClass();
    if (localClass.getSuperclass() != zzf.class) {
      throw new IllegalArgumentException();
    }
    paramzzf.zzb(zzb(localClass));
  }
  
  public <T extends zzf> T zzb(Class<T> paramClass)
  {
    zzf localzzf2 = (zzf)this.zzabN.get(paramClass);
    zzf localzzf1 = localzzf2;
    if (localzzf2 == null)
    {
      localzzf1 = zzc(paramClass);
      this.zzabN.put(paramClass, localzzf1);
    }
    return localzzf1;
  }
  
  public zze zzmH()
  {
    return new zze(this);
  }
  
  public Collection<zzf> zzmI()
  {
    return this.zzabN.values();
  }
  
  public List<zzi> zzmJ()
  {
    return this.zzabO;
  }
  
  public long zzmK()
  {
    return this.zzabH;
  }
  
  public void zzmL()
  {
    zzmP().zze(this);
  }
  
  public boolean zzmM()
  {
    return this.zzabG;
  }
  
  void zzmN()
  {
    this.zzabJ = this.zzvi.elapsedRealtime();
    if (this.zzabI != 0L) {}
    for (this.zzabH = this.zzabI;; this.zzabH = this.zzvi.currentTimeMillis())
    {
      this.zzabG = true;
      return;
    }
  }
  
  zzg zzmO()
  {
    return this.zzabF;
  }
  
  zzh zzmP()
  {
    return this.zzabF.zzmP();
  }
  
  boolean zzmQ()
  {
    return this.zzabM;
  }
  
  void zzmR()
  {
    this.zzabM = true;
  }
  
  public void zzv(long paramLong)
  {
    this.zzabI = paramLong;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */