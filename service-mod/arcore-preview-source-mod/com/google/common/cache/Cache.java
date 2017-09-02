package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface Cache<K, V>
{
  public abstract ConcurrentMap<K, V> asMap();
  
  public abstract void cleanUp();
  
  public abstract V get(K paramK, Callable<? extends V> paramCallable)
    throws ExecutionException;
  
  public abstract ImmutableMap<K, V> getAllPresent(Iterable<?> paramIterable);
  
  @Nullable
  public abstract V getIfPresent(Object paramObject);
  
  public abstract void invalidate(Object paramObject);
  
  public abstract void invalidateAll();
  
  public abstract void invalidateAll(Iterable<?> paramIterable);
  
  public abstract void put(K paramK, V paramV);
  
  public abstract void putAll(Map<? extends K, ? extends V> paramMap);
  
  public abstract long size();
  
  public abstract CacheStats stats();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */