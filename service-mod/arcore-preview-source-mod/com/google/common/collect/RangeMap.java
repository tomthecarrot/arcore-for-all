package com.google.common.collect;

import com.google.common.annotations.Beta;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
public abstract interface RangeMap<K extends Comparable, V>
{
  public abstract Map<Range<K>, V> asDescendingMapOfRanges();
  
  public abstract Map<Range<K>, V> asMapOfRanges();
  
  public abstract void clear();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  @Nullable
  public abstract V get(K paramK);
  
  @Nullable
  public abstract Map.Entry<Range<K>, V> getEntry(K paramK);
  
  public abstract int hashCode();
  
  public abstract void put(Range<K> paramRange, V paramV);
  
  public abstract void putAll(RangeMap<K, V> paramRangeMap);
  
  public abstract void remove(Range<K> paramRange);
  
  public abstract Range<K> span();
  
  public abstract RangeMap<K, V> subRangeMap(Range<K> paramRange);
  
  public abstract String toString();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */