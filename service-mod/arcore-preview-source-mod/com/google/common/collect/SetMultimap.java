package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface SetMultimap<K, V>
  extends Multimap<K, V>
{
  public abstract Map<K, Collection<V>> asMap();
  
  public abstract Set<Map.Entry<K, V>> entries();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract Set<V> get(@Nullable K paramK);
  
  public abstract Set<V> removeAll(@Nullable Object paramObject);
  
  public abstract Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/SetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */