package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

public abstract class ForwardingLoadingCache<K, V>
  extends ForwardingCache<K, V>
  implements LoadingCache<K, V>
{
  public V apply(K paramK)
  {
    return (V)delegate().apply(paramK);
  }
  
  protected abstract LoadingCache<K, V> delegate();
  
  public V get(K paramK)
    throws ExecutionException
  {
    return (V)delegate().get(paramK);
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable)
    throws ExecutionException
  {
    return delegate().getAll(paramIterable);
  }
  
  public V getUnchecked(K paramK)
  {
    return (V)delegate().getUnchecked(paramK);
  }
  
  public void refresh(K paramK)
  {
    delegate().refresh(paramK);
  }
  
  public static abstract class SimpleForwardingLoadingCache<K, V>
    extends ForwardingLoadingCache<K, V>
  {
    private final LoadingCache<K, V> delegate;
    
    protected SimpleForwardingLoadingCache(LoadingCache<K, V> paramLoadingCache)
    {
      this.delegate = ((LoadingCache)Preconditions.checkNotNull(paramLoadingCache));
    }
    
    protected final LoadingCache<K, V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/ForwardingLoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */