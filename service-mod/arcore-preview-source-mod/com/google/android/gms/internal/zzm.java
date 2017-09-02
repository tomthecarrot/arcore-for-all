package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzm
{
  private AtomicInteger zzW = new AtomicInteger();
  private final Map<String, Queue<zzl<?>>> zzX = new HashMap();
  private final Set<zzl<?>> zzY = new HashSet();
  private final PriorityBlockingQueue<zzl<?>> zzZ = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzl<?>> zzaa = new PriorityBlockingQueue();
  private zzh[] zzab;
  private zzc zzac;
  private List<Object> zzad = new ArrayList();
  private final zzb zzi;
  private final zzo zzj;
  private final zzg zzy;
  
  public zzm(zzb paramzzb, zzg paramzzg)
  {
    this(paramzzb, paramzzg, 4);
  }
  
  public zzm(zzb paramzzb, zzg paramzzg, int paramInt)
  {
    this(paramzzb, paramzzg, paramInt, new zzf(new Handler(Looper.getMainLooper())));
  }
  
  public zzm(zzb paramzzb, zzg paramzzg, int paramInt, zzo paramzzo)
  {
    this.zzi = paramzzb;
    this.zzy = paramzzg;
    this.zzab = new zzh[paramInt];
    this.zzj = paramzzo;
  }
  
  public int getSequenceNumber()
  {
    return this.zzW.incrementAndGet();
  }
  
  public void start()
  {
    stop();
    this.zzac = new zzc(this.zzZ, this.zzaa, this.zzi, this.zzj);
    this.zzac.start();
    int i = 0;
    while (i < this.zzab.length)
    {
      zzh localzzh = new zzh(this.zzaa, this.zzy, this.zzi, this.zzj);
      this.zzab[i] = localzzh;
      localzzh.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    if (this.zzac != null) {
      this.zzac.quit();
    }
    int i = 0;
    while (i < this.zzab.length)
    {
      if (this.zzab[i] != null) {
        this.zzab[i].quit();
      }
      i += 1;
    }
  }
  
  public <T> zzl<T> zze(zzl<T> paramzzl)
  {
    paramzzl.zza(this);
    synchronized (this.zzY)
    {
      this.zzY.add(paramzzl);
      paramzzl.zza(getSequenceNumber());
      paramzzl.zzc("add-to-queue");
      if (!paramzzl.zzn())
      {
        this.zzaa.add(paramzzl);
        return paramzzl;
      }
    }
    for (;;)
    {
      String str;
      synchronized (this.zzX)
      {
        str = paramzzl.zzg();
        if (this.zzX.containsKey(str))
        {
          Queue localQueue = (Queue)this.zzX.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramzzl);
          this.zzX.put(str, ???);
          if (zzt.DEBUG) {
            zzt.zza("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramzzl;
        }
      }
      this.zzX.put(str, null);
      this.zzZ.add(paramzzl);
    }
  }
  
  <T> void zzf(zzl<T> paramzzl)
  {
    Object localObject2;
    synchronized (this.zzY)
    {
      this.zzY.remove(paramzzl);
      synchronized (this.zzad)
      {
        localObject2 = this.zzad.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((Iterator)localObject2).next();
        }
      }
    }
    if (paramzzl.zzn()) {
      synchronized (this.zzX)
      {
        paramzzl = paramzzl.zzg();
        localObject2 = (Queue)this.zzX.remove(paramzzl);
        if (localObject2 != null)
        {
          if (zzt.DEBUG) {
            zzt.zza("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((Queue)localObject2).size()), paramzzl });
          }
          this.zzZ.addAll((Collection)localObject2);
        }
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */