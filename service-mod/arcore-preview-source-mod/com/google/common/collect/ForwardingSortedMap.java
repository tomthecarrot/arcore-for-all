package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V>
  extends ForwardingMap<K, V>
  implements SortedMap<K, V>
{
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null) {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
    return localComparator.compare(paramObject1, paramObject2);
  }
  
  public Comparator<? super K> comparator()
  {
    return delegate().comparator();
  }
  
  protected abstract SortedMap<K, V> delegate();
  
  public K firstKey()
  {
    return (K)delegate().firstKey();
  }
  
  public SortedMap<K, V> headMap(K paramK)
  {
    return delegate().headMap(paramK);
  }
  
  public K lastKey()
  {
    return (K)delegate().lastKey();
  }
  
  @Beta
  protected boolean standardContainsKey(@Nullable Object paramObject)
  {
    boolean bool = false;
    try
    {
      int i = unsafeCompare(tailMap(paramObject).firstKey(), paramObject);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    catch (NoSuchElementException paramObject)
    {
      return false;
    }
    catch (NullPointerException paramObject) {}
    return false;
  }
  
  @Beta
  protected SortedMap<K, V> standardSubMap(K paramK1, K paramK2)
  {
    if (unsafeCompare(paramK1, paramK2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "fromKey must be <= toKey");
      return tailMap(paramK1).headMap(paramK2);
    }
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return delegate().subMap(paramK1, paramK2);
  }
  
  public SortedMap<K, V> tailMap(K paramK)
  {
    return delegate().tailMap(paramK);
  }
  
  @Beta
  protected class StandardKeySet
    extends Maps.SortedKeySet<K, V>
  {
    public StandardKeySet()
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */