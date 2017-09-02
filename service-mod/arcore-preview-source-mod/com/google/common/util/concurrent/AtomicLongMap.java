package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap<K>
{
  private transient Map<K, Long> asMap;
  private final ConcurrentHashMap<K, AtomicLong> map;
  
  private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> paramConcurrentHashMap)
  {
    this.map = ((ConcurrentHashMap)Preconditions.checkNotNull(paramConcurrentHashMap));
  }
  
  public static <K> AtomicLongMap<K> create()
  {
    return new AtomicLongMap(new ConcurrentHashMap());
  }
  
  public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> paramMap)
  {
    AtomicLongMap localAtomicLongMap = create();
    localAtomicLongMap.putAll(paramMap);
    return localAtomicLongMap;
  }
  
  private Map<K, Long> createAsMap()
  {
    Collections.unmodifiableMap(Maps.transformValues(this.map, new Function()
    {
      public Long apply(AtomicLong paramAnonymousAtomicLong)
      {
        return Long.valueOf(paramAnonymousAtomicLong.get());
      }
    }));
  }
  
  public long addAndGet(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return paramLong;
      }
    }
    long l1;
    long l2;
    do
    {
      l1 = localAtomicLong1.get();
      if (l1 == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return paramLong;
      }
      l2 = l1 + paramLong;
    } while (!localAtomicLong1.compareAndSet(l1, l2));
    return l2;
  }
  
  public Map<K, Long> asMap()
  {
    Map localMap2 = this.asMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createAsMap();
      this.asMap = localMap1;
    }
    return localMap1;
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public long decrementAndGet(K paramK)
  {
    return addAndGet(paramK, -1L);
  }
  
  public long get(K paramK)
  {
    paramK = (AtomicLong)this.map.get(paramK);
    if (paramK == null) {
      return 0L;
    }
    return paramK.get();
  }
  
  public long getAndAdd(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong1.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong1.compareAndSet(l, l + paramLong));
    return l;
  }
  
  public long getAndDecrement(K paramK)
  {
    return getAndAdd(paramK, -1L);
  }
  
  public long getAndIncrement(K paramK)
  {
    return getAndAdd(paramK, 1L);
  }
  
  public long incrementAndGet(K paramK)
  {
    return addAndGet(paramK, 1L);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public long put(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong1.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong1.compareAndSet(l, paramLong));
    return l;
  }
  
  public void putAll(Map<? extends K, ? extends Long> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
    }
  }
  
  long putIfAbsent(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong1;
    do
    {
      AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
      localAtomicLong1 = localAtomicLong2;
      long l1;
      if (localAtomicLong2 == null)
      {
        localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        localAtomicLong1 = localAtomicLong2;
        if (localAtomicLong2 == null) {
          l1 = 0L;
        }
      }
      long l2;
      do
      {
        return l1;
        l2 = localAtomicLong1.get();
        l1 = l2;
      } while (l2 != 0L);
    } while (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong)));
    return 0L;
  }
  
  public long remove(K paramK)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {
      return 0L;
    }
    long l;
    do
    {
      l = localAtomicLong.get();
    } while ((l != 0L) && (!localAtomicLong.compareAndSet(l, 0L)));
    this.map.remove(paramK, localAtomicLong);
    return l;
  }
  
  boolean remove(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {}
    long l;
    do
    {
      return false;
      l = localAtomicLong.get();
    } while ((l != paramLong) || ((l != 0L) && (!localAtomicLong.compareAndSet(l, 0L))));
    this.map.remove(paramK, localAtomicLong);
    return true;
  }
  
  public void removeAllZeros()
  {
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AtomicLong localAtomicLong = (AtomicLong)((Map.Entry)localIterator.next()).getValue();
      if ((localAtomicLong != null) && (localAtomicLong.get() == 0L)) {
        localIterator.remove();
      }
    }
  }
  
  boolean replace(K paramK, long paramLong1, long paramLong2)
  {
    boolean bool = false;
    if (paramLong1 == 0L) {
      if (putIfAbsent(paramK, paramLong2) == 0L) {
        bool = true;
      }
    }
    do
    {
      return bool;
      paramK = (AtomicLong)this.map.get(paramK);
    } while (paramK == null);
    return paramK.compareAndSet(paramLong1, paramLong2);
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public long sum()
  {
    long l = 0L;
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      l += ((AtomicLong)localIterator.next()).get();
    }
    return l;
  }
  
  public String toString()
  {
    return this.map.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/util/concurrent/AtomicLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */