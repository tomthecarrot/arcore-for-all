package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredKeyMultimap<K, V>
  extends AbstractMultimap<K, V>
  implements FilteredMultimap<K, V>
{
  final Predicate<? super K> keyPredicate;
  final Multimap<K, V> unfiltered;
  
  FilteredKeyMultimap(Multimap<K, V> paramMultimap, Predicate<? super K> paramPredicate)
  {
    this.unfiltered = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    this.keyPredicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  public void clear()
  {
    keySet().clear();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    if (this.unfiltered.containsKey(paramObject)) {
      return this.keyPredicate.apply(paramObject);
    }
    return false;
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
  }
  
  Collection<Map.Entry<K, V>> createEntries()
  {
    return new Entries();
  }
  
  Set<K> createKeySet()
  {
    return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
  }
  
  Multiset<K> createKeys()
  {
    return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
  }
  
  Collection<V> createValues()
  {
    return new FilteredMultimapValues(this);
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public Predicate<? super Map.Entry<K, V>> entryPredicate()
  {
    return Maps.keyPredicateOnEntries(this.keyPredicate);
  }
  
  public Collection<V> get(K paramK)
  {
    if (this.keyPredicate.apply(paramK)) {
      return this.unfiltered.get(paramK);
    }
    if ((this.unfiltered instanceof SetMultimap)) {
      return new AddRejectingSet(paramK);
    }
    return new AddRejectingList(paramK);
  }
  
  public Collection<V> removeAll(Object paramObject)
  {
    if (containsKey(paramObject)) {
      return this.unfiltered.removeAll(paramObject);
    }
    return unmodifiableEmptyCollection();
  }
  
  public int size()
  {
    int i = 0;
    Iterator localIterator = asMap().values().iterator();
    while (localIterator.hasNext()) {
      i += ((Collection)localIterator.next()).size();
    }
    return i;
  }
  
  public Multimap<K, V> unfiltered()
  {
    return this.unfiltered;
  }
  
  Collection<V> unmodifiableEmptyCollection()
  {
    if ((this.unfiltered instanceof SetMultimap)) {
      return ImmutableSet.of();
    }
    return ImmutableList.of();
  }
  
  static class AddRejectingList<K, V>
    extends ForwardingList<V>
  {
    final K key;
    
    AddRejectingList(K paramK)
    {
      this.key = paramK;
    }
    
    public void add(int paramInt, V paramV)
    {
      Preconditions.checkPositionIndex(paramInt, 0);
      throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
    }
    
    public boolean add(V paramV)
    {
      add(0, paramV);
      return true;
    }
    
    public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
    {
      Preconditions.checkNotNull(paramCollection);
      Preconditions.checkPositionIndex(paramInt, 0);
      throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      addAll(0, paramCollection);
      return true;
    }
    
    protected List<V> delegate()
    {
      return Collections.emptyList();
    }
  }
  
  static class AddRejectingSet<K, V>
    extends ForwardingSet<V>
  {
    final K key;
    
    AddRejectingSet(K paramK)
    {
      this.key = paramK;
    }
    
    public boolean add(V paramV)
    {
      throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      Preconditions.checkNotNull(paramCollection);
      throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
    }
    
    protected Set<V> delegate()
    {
      return Collections.emptySet();
    }
  }
  
  class Entries
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    Entries() {}
    
    protected Collection<Map.Entry<K, V>> delegate()
    {
      return Collections2.filter(FilteredKeyMultimap.this.unfiltered.entries(), FilteredKeyMultimap.this.entryPredicate());
    }
    
    public boolean remove(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        if ((FilteredKeyMultimap.this.unfiltered.containsKey(((Map.Entry)paramObject).getKey())) && (FilteredKeyMultimap.this.keyPredicate.apply(((Map.Entry)paramObject).getKey()))) {
          return FilteredKeyMultimap.this.unfiltered.remove(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
        }
      }
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/FilteredKeyMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */