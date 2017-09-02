package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeySetMultimap<K, V>
  extends FilteredKeyMultimap<K, V>
  implements FilteredSetMultimap<K, V>
{
  FilteredKeySetMultimap(SetMultimap<K, V> paramSetMultimap, Predicate<? super K> paramPredicate)
  {
    super(paramSetMultimap, paramPredicate);
  }
  
  Set<Map.Entry<K, V>> createEntries()
  {
    return new EntrySet();
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return (Set)super.entries();
  }
  
  public Set<V> get(K paramK)
  {
    return (Set)super.get(paramK);
  }
  
  public Set<V> removeAll(Object paramObject)
  {
    return (Set)super.removeAll(paramObject);
  }
  
  public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    return (Set)super.replaceValues(paramK, paramIterable);
  }
  
  public SetMultimap<K, V> unfiltered()
  {
    return (SetMultimap)this.unfiltered;
  }
  
  class EntrySet
    extends FilteredKeyMultimap<K, V>.Entries
    implements Set<Map.Entry<K, V>>
  {
    EntrySet()
    {
      super();
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return Sets.equalsImpl(this, paramObject);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/FilteredKeySetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */