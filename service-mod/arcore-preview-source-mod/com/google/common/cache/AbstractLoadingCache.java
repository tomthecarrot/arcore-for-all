package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public abstract class AbstractLoadingCache<K, V>
  extends AbstractCache<K, V>
  implements LoadingCache<K, V>
{
  public final V apply(K paramK)
  {
    return (V)getUnchecked(paramK);
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable)
    throws ExecutionException
  {
    LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, get(localObject));
      }
    }
    return ImmutableMap.copyOf(localLinkedHashMap);
  }
  
  public V getUnchecked(K paramK)
  {
    try
    {
      paramK = get(paramK);
      return paramK;
    }
    catch (ExecutionException paramK)
    {
      throw new UncheckedExecutionException(paramK.getCause());
    }
  }
  
  public void refresh(K paramK)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/AbstractLoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */