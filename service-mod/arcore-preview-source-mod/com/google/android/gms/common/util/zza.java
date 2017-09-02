package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zza<E>
  extends AbstractSet<E>
{
  private final ArrayMap<E, E> zzaUE;
  
  public zza()
  {
    this.zzaUE = new ArrayMap();
  }
  
  public zza(int paramInt)
  {
    this.zzaUE = new ArrayMap(paramInt);
  }
  
  public zza(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (this.zzaUE.containsKey(paramE)) {
      return false;
    }
    this.zzaUE.put(paramE, paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zza)) {
      return zza((zza)paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.zzaUE.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.zzaUE.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return this.zzaUE.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    if (!this.zzaUE.containsKey(paramObject)) {
      return false;
    }
    this.zzaUE.remove(paramObject);
    return true;
  }
  
  public int size()
  {
    return this.zzaUE.size();
  }
  
  public boolean zza(zza<? extends E> paramzza)
  {
    int i = size();
    this.zzaUE.putAll(paramzza.zzaUE);
    return size() > i;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/util/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */