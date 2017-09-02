package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

abstract class AbstractNavigableMap<K, V>
  extends Maps.IteratorBasedAbstractMap<K, V>
  implements NavigableMap<K, V>
{
  @Nullable
  public Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK)
  {
    return (K)Maps.keyOrNull(ceilingEntry(paramK));
  }
  
  abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();
  
  public NavigableSet<K> descendingKeySet()
  {
    return descendingMap().navigableKeySet();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return new DescendingMap(null);
  }
  
  @Nullable
  public Map.Entry<K, V> firstEntry()
  {
    return (Map.Entry)Iterators.getNext(entryIterator(), null);
  }
  
  public K firstKey()
  {
    Map.Entry localEntry = firstEntry();
    if (localEntry == null) {
      throw new NoSuchElementException();
    }
    return (K)localEntry.getKey();
  }
  
  @Nullable
  public Map.Entry<K, V> floorEntry(K paramK)
  {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK)
  {
    return (K)Maps.keyOrNull(floorEntry(paramK));
  }
  
  @Nullable
  public abstract V get(@Nullable Object paramObject);
  
  public SortedMap<K, V> headMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  @Nullable
  public Map.Entry<K, V> higherEntry(K paramK)
  {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK)
  {
    return (K)Maps.keyOrNull(higherEntry(paramK));
  }
  
  public Set<K> keySet()
  {
    return navigableKeySet();
  }
  
  @Nullable
  public Map.Entry<K, V> lastEntry()
  {
    return (Map.Entry)Iterators.getNext(descendingEntryIterator(), null);
  }
  
  public K lastKey()
  {
    Map.Entry localEntry = lastEntry();
    if (localEntry == null) {
      throw new NoSuchElementException();
    }
    return (K)localEntry.getKey();
  }
  
  @Nullable
  public Map.Entry<K, V> lowerEntry(K paramK)
  {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK)
  {
    return (K)Maps.keyOrNull(lowerEntry(paramK));
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return new Maps.NavigableKeySet(this);
  }
  
  @Nullable
  public Map.Entry<K, V> pollFirstEntry()
  {
    return (Map.Entry)Iterators.pollNext(entryIterator());
  }
  
  @Nullable
  public Map.Entry<K, V> pollLastEntry()
  {
    return (Map.Entry)Iterators.pollNext(descendingEntryIterator());
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public SortedMap<K, V> tailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  private final class DescendingMap
    extends Maps.DescendingMap<K, V>
  {
    private DescendingMap() {}
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return AbstractNavigableMap.this.descendingEntryIterator();
    }
    
    NavigableMap<K, V> forward()
    {
      return AbstractNavigableMap.this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractNavigableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */