package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredMultimapValues<K, V>
  extends AbstractCollection<V>
{
  @Weak
  private final FilteredMultimap<K, V> multimap;
  
  FilteredMultimapValues(FilteredMultimap<K, V> paramFilteredMultimap)
  {
    this.multimap = ((FilteredMultimap)Preconditions.checkNotNull(paramFilteredMultimap));
  }
  
  public void clear()
  {
    this.multimap.clear();
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return this.multimap.containsValue(paramObject);
  }
  
  public Iterator<V> iterator()
  {
    return Maps.valueIterator(this.multimap.entries().iterator());
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    Predicate localPredicate = this.multimap.entryPredicate();
    Iterator localIterator = this.multimap.unfiltered().entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localPredicate.apply(localEntry)) && (Objects.equal(localEntry.getValue(), paramObject)))
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.in(paramCollection))));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(paramCollection)))));
  }
  
  public int size()
  {
    return this.multimap.size();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/FilteredMultimapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */