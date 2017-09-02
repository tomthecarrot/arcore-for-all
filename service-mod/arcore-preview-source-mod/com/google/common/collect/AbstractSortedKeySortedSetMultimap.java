package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
abstract class AbstractSortedKeySortedSetMultimap<K, V>
  extends AbstractSortedSetMultimap<K, V>
{
  AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap);
  }
  
  public SortedMap<K, Collection<V>> asMap()
  {
    return (SortedMap)super.asMap();
  }
  
  SortedMap<K, Collection<V>> backingMap()
  {
    return (SortedMap)super.backingMap();
  }
  
  public SortedSet<K> keySet()
  {
    return (SortedSet)super.keySet();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractSortedKeySortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */