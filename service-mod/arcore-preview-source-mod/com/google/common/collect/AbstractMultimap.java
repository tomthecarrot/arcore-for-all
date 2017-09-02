package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultimap<K, V>
  implements Multimap<K, V>
{
  private transient Map<K, Collection<V>> asMap;
  private transient Collection<Map.Entry<K, V>> entries;
  private transient Set<K> keySet;
  private transient Multiset<K> keys;
  private transient Collection<V> values;
  
  public Map<K, Collection<V>> asMap()
  {
    Map localMap2 = this.asMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createAsMap();
      this.asMap = localMap1;
    }
    return localMap1;
  }
  
  public boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)asMap().get(paramObject1);
    return (paramObject1 != null) && (((Collection)paramObject1).contains(paramObject2));
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = asMap().values().iterator();
    while (localIterator.hasNext()) {
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  abstract Map<K, Collection<V>> createAsMap();
  
  Collection<Map.Entry<K, V>> createEntries()
  {
    if ((this instanceof SetMultimap)) {
      return new EntrySet(null);
    }
    return new Entries(null);
  }
  
  Set<K> createKeySet()
  {
    return new Maps.KeySet(asMap());
  }
  
  Multiset<K> createKeys()
  {
    return new Multimaps.Keys(this);
  }
  
  Collection<V> createValues()
  {
    return new Values();
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    Collection localCollection2 = this.entries;
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createEntries();
      this.entries = localCollection1;
    }
    return localCollection1;
  }
  
  abstract Iterator<Map.Entry<K, V>> entryIterator();
  
  public boolean equals(@Nullable Object paramObject)
  {
    return Multimaps.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    return asMap().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.keySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createKeySet();
      this.keySet = localSet1;
    }
    return localSet1;
  }
  
  public Multiset<K> keys()
  {
    Multiset localMultiset2 = this.keys;
    Multiset localMultiset1 = localMultiset2;
    if (localMultiset2 == null)
    {
      localMultiset1 = createKeys();
      this.keys = localMultiset1;
    }
    return localMultiset1;
  }
  
  public boolean put(@Nullable K paramK, @Nullable V paramV)
  {
    return get(paramK).add(paramV);
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
  {
    boolean bool = false;
    paramMultimap = paramMultimap.entries().iterator();
    while (paramMultimap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMultimap.next();
      bool |= put(localEntry.getKey(), localEntry.getValue());
    }
    return bool;
  }
  
  public boolean putAll(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      if ((paramIterable.isEmpty()) || (!get(paramK).addAll(paramIterable))) {}
    }
    do
    {
      return true;
      return false;
      paramIterable = paramIterable.iterator();
    } while ((paramIterable.hasNext()) && (Iterators.addAll(get(paramK), paramIterable)));
    return false;
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)asMap().get(paramObject1);
    return (paramObject1 != null) && (((Collection)paramObject1).remove(paramObject2));
  }
  
  public Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    Collection localCollection = removeAll(paramK);
    putAll(paramK, paramIterable);
    return localCollection;
  }
  
  public String toString()
  {
    return asMap().toString();
  }
  
  Iterator<V> valueIterator()
  {
    return Maps.valueIterator(entries().iterator());
  }
  
  public Collection<V> values()
  {
    Collection localCollection2 = this.values;
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createValues();
      this.values = localCollection1;
    }
    return localCollection1;
  }
  
  private class Entries
    extends Multimaps.Entries<K, V>
  {
    private Entries() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return AbstractMultimap.this.entryIterator();
    }
    
    Multimap<K, V> multimap()
    {
      return AbstractMultimap.this;
    }
  }
  
  private class EntrySet
    extends AbstractMultimap<K, V>.Entries
    implements Set<Map.Entry<K, V>>
  {
    private EntrySet()
    {
      super(null);
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
  
  class Values
    extends AbstractCollection<V>
  {
    Values() {}
    
    public void clear()
    {
      AbstractMultimap.this.clear();
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      return AbstractMultimap.this.containsValue(paramObject);
    }
    
    public Iterator<V> iterator()
    {
      return AbstractMultimap.this.valueIterator();
    }
    
    public int size()
    {
      return AbstractMultimap.this.size();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/AbstractMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */