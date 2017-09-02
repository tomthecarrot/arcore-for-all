package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeyListMultimap<K, V>
  extends FilteredKeyMultimap<K, V>
  implements ListMultimap<K, V>
{
  FilteredKeyListMultimap(ListMultimap<K, V> paramListMultimap, Predicate<? super K> paramPredicate)
  {
    super(paramListMultimap, paramPredicate);
  }
  
  public List<V> get(K paramK)
  {
    return (List)super.get(paramK);
  }
  
  public List<V> removeAll(@Nullable Object paramObject)
  {
    return (List)super.removeAll(paramObject);
  }
  
  public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    return (List)super.replaceValues(paramK, paramIterable);
  }
  
  public ListMultimap<K, V> unfiltered()
  {
    return (ListMultimap)super.unfiltered();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/FilteredKeyListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */