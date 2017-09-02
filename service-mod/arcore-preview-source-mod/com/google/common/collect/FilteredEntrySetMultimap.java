package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
final class FilteredEntrySetMultimap<K, V>
  extends FilteredEntryMultimap<K, V>
  implements FilteredSetMultimap<K, V>
{
  FilteredEntrySetMultimap(SetMultimap<K, V> paramSetMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    super(paramSetMultimap, paramPredicate);
  }
  
  Set<Map.Entry<K, V>> createEntries()
  {
    return Sets.filter(unfiltered().entries(), entryPredicate());
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
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/FilteredEntrySetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */