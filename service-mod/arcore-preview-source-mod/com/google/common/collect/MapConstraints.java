package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints
{
  private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    paramMap = new LinkedHashMap(paramMap);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMapConstraint.checkKeyValue(localEntry.getKey(), localEntry.getValue());
    }
    return paramMap;
  }
  
  private static <K, V> Collection<V> checkValues(K paramK, Iterable<? extends V> paramIterable, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      paramMapConstraint.checkKeyValue(paramK, localIterator.next());
    }
    return paramIterable;
  }
  
  private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedAsMapEntries(paramSet, paramMapConstraint);
  }
  
  private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(Map.Entry<K, Collection<V>> paramEntry, final MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    Preconditions.checkNotNull(paramEntry);
    Preconditions.checkNotNull(paramMapConstraint);
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, Collection<V>> delegate()
      {
        return this.val$entry;
      }
      
      public Collection<V> getValue()
      {
        Constraints.constrainedTypePreservingCollection((Collection)this.val$entry.getValue(), new Constraint()
        {
          public V checkElement(V paramAnonymous2V)
          {
            MapConstraints.2.this.val$constraint.checkKeyValue(MapConstraints.2.this.getKey(), paramAnonymous2V);
            return paramAnonymous2V;
          }
        });
      }
    };
  }
  
  public static <K, V> BiMap<K, V> constrainedBiMap(BiMap<K, V> paramBiMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedBiMap(paramBiMap, null, paramMapConstraint);
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    if ((paramCollection instanceof Set)) {
      return constrainedEntrySet((Set)paramCollection, paramMapConstraint);
    }
    return new ConstrainedEntries(paramCollection, paramMapConstraint);
  }
  
  private static <K, V> Map.Entry<K, V> constrainedEntry(Map.Entry<K, V> paramEntry, final MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    Preconditions.checkNotNull(paramEntry);
    Preconditions.checkNotNull(paramMapConstraint);
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, V> delegate()
      {
        return this.val$entry;
      }
      
      public V setValue(V paramAnonymousV)
      {
        paramMapConstraint.checkKeyValue(getKey(), paramAnonymousV);
        return (V)this.val$entry.setValue(paramAnonymousV);
      }
    };
  }
  
  private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedEntrySet(paramSet, paramMapConstraint);
  }
  
  public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedListMultimap(paramListMultimap, paramMapConstraint);
  }
  
  public static <K, V> Map<K, V> constrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedMap(paramMap, paramMapConstraint);
  }
  
  public static <K, V> Multimap<K, V> constrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedMultimap(paramMultimap, paramMapConstraint);
  }
  
  public static <K, V> SetMultimap<K, V> constrainedSetMultimap(SetMultimap<K, V> paramSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedSetMultimap(paramSetMultimap, paramMapConstraint);
  }
  
  public static <K, V> SortedSetMultimap<K, V> constrainedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedSortedSetMultimap(paramSortedSetMultimap, paramMapConstraint);
  }
  
  public static MapConstraint<Object, Object> notNull()
  {
    return NotNullMapConstraint.INSTANCE;
  }
  
  static class ConstrainedAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>>
  {
    private final MapConstraint<? super K, ? super V> constraint;
    private final Set<Map.Entry<K, Collection<V>>> entries;
    
    ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramSet;
      this.constraint = paramMapConstraint;
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> delegate()
    {
      return this.entries;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return standardEquals(paramObject);
    }
    
    public int hashCode()
    {
      return standardHashCode();
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      new TransformedIterator(this.entries.iterator())
      {
        Map.Entry<K, Collection<V>> transform(Map.Entry<K, Collection<V>> paramAnonymousEntry)
        {
          return MapConstraints.constrainedAsMapEntry(paramAnonymousEntry, MapConstraints.ConstrainedAsMapEntries.this.constraint);
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      return Maps.removeEntryImpl(delegate(), paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  private static class ConstrainedAsMapValues<K, V>
    extends ForwardingCollection<Collection<V>>
  {
    final Collection<Collection<V>> delegate;
    final Set<Map.Entry<K, Collection<V>>> entrySet;
    
    ConstrainedAsMapValues(Collection<Collection<V>> paramCollection, Set<Map.Entry<K, Collection<V>>> paramSet)
    {
      this.delegate = paramCollection;
      this.entrySet = paramSet;
    }
    
    public boolean contains(Object paramObject)
    {
      return standardContains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Collection<Collection<V>> delegate()
    {
      return this.delegate;
    }
    
    public Iterator<Collection<V>> iterator()
    {
      new Iterator()
      {
        public boolean hasNext()
        {
          return this.val$iterator.hasNext();
        }
        
        public Collection<V> next()
        {
          return (Collection)((Map.Entry)this.val$iterator.next()).getValue();
        }
        
        public void remove()
        {
          this.val$iterator.remove();
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      return standardRemove(paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  private static class ConstrainedBiMap<K, V>
    extends MapConstraints.ConstrainedMap<K, V>
    implements BiMap<K, V>
  {
    volatile BiMap<V, K> inverse;
    
    ConstrainedBiMap(BiMap<K, V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
      this.inverse = paramBiMap1;
    }
    
    protected BiMap<K, V> delegate()
    {
      return (BiMap)super.delegate();
    }
    
    public V forcePut(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramK, paramV);
      return (V)delegate().forcePut(paramK, paramV);
    }
    
    public BiMap<V, K> inverse()
    {
      if (this.inverse == null) {
        this.inverse = new ConstrainedBiMap(delegate().inverse(), this, new MapConstraints.InverseConstraint(this.constraint));
      }
      return this.inverse;
    }
    
    public Set<V> values()
    {
      return delegate().values();
    }
  }
  
  private static class ConstrainedEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    final MapConstraint<? super K, ? super V> constraint;
    final Collection<Map.Entry<K, V>> entries;
    
    ConstrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramCollection;
      this.constraint = paramMapConstraint;
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Collection<Map.Entry<K, V>> delegate()
    {
      return this.entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      new TransformedIterator(this.entries.iterator())
      {
        Map.Entry<K, V> transform(Map.Entry<K, V> paramAnonymousEntry)
        {
          return MapConstraints.constrainedEntry(paramAnonymousEntry, MapConstraints.ConstrainedEntries.this.constraint);
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      return Maps.removeEntryImpl(delegate(), paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class ConstrainedEntrySet<K, V>
    extends MapConstraints.ConstrainedEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    ConstrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
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
  
  private static class ConstrainedListMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    ConstrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public List<V> get(K paramK)
    {
      return (List)super.get(paramK);
    }
    
    public List<V> removeAll(Object paramObject)
    {
      return (List)super.removeAll(paramObject);
    }
    
    public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      return (List)super.replaceValues(paramK, paramIterable);
    }
  }
  
  static class ConstrainedMap<K, V>
    extends ForwardingMap<K, V>
  {
    final MapConstraint<? super K, ? super V> constraint;
    private final Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    
    ConstrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Map)Preconditions.checkNotNull(paramMap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    protected Map<K, V> delegate()
    {
      return this.delegate;
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet2 = this.entrySet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = MapConstraints.constrainedEntrySet(this.delegate.entrySet(), this.constraint);
        this.entrySet = localSet1;
      }
      return localSet1;
    }
    
    public V put(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramK, paramV);
      return (V)this.delegate.put(paramK, paramV);
    }
    
    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      this.delegate.putAll(MapConstraints.checkMap(paramMap, this.constraint));
    }
  }
  
  private static class ConstrainedMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    transient Map<K, Collection<V>> asMap;
    final MapConstraint<? super K, ? super V> constraint;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    
    public ConstrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    public Map<K, Collection<V>> asMap()
    {
      Map localMap = this.asMap;
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new ForwardingMap()
        {
          Set<Map.Entry<K, Collection<V>>> entrySet;
          Collection<Collection<V>> values;
          
          public boolean containsValue(Object paramAnonymousObject)
          {
            return values().contains(paramAnonymousObject);
          }
          
          protected Map<K, Collection<V>> delegate()
          {
            return this.val$asMapDelegate;
          }
          
          public Set<Map.Entry<K, Collection<V>>> entrySet()
          {
            Set localSet2 = this.entrySet;
            Set localSet1 = localSet2;
            if (localSet2 == null)
            {
              localSet1 = MapConstraints.constrainedAsMapEntries(this.val$asMapDelegate.entrySet(), this.this$0.constraint);
              this.entrySet = localSet1;
            }
            return localSet1;
          }
          
          public Collection<V> get(Object paramAnonymousObject)
          {
            try
            {
              paramAnonymousObject = this.this$0.get(paramAnonymousObject);
              boolean bool = ((Collection)paramAnonymousObject).isEmpty();
              if (bool) {
                paramAnonymousObject = null;
              }
              return (Collection<V>)paramAnonymousObject;
            }
            catch (ClassCastException paramAnonymousObject) {}
            return null;
          }
          
          public Collection<Collection<V>> values()
          {
            Collection localCollection = this.values;
            Object localObject = localCollection;
            if (localCollection == null)
            {
              localObject = new MapConstraints.ConstrainedAsMapValues(delegate().values(), entrySet());
              this.values = ((Collection)localObject);
            }
            return (Collection<Collection<V>>)localObject;
          }
        };
        this.asMap = ((Map)localObject);
      }
      return (Map<K, Collection<V>>)localObject;
    }
    
    protected Multimap<K, V> delegate()
    {
      return this.delegate;
    }
    
    public Collection<Map.Entry<K, V>> entries()
    {
      Collection localCollection2 = this.entries;
      Collection localCollection1 = localCollection2;
      if (localCollection2 == null)
      {
        localCollection1 = MapConstraints.constrainedEntries(this.delegate.entries(), this.constraint);
        this.entries = localCollection1;
      }
      return localCollection1;
    }
    
    public Collection<V> get(final K paramK)
    {
      Constraints.constrainedTypePreservingCollection(this.delegate.get(paramK), new Constraint()
      {
        public V checkElement(V paramAnonymousV)
        {
          MapConstraints.ConstrainedMultimap.this.constraint.checkKeyValue(paramK, paramAnonymousV);
          return paramAnonymousV;
        }
      });
    }
    
    public boolean put(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramK, paramV);
      return this.delegate.put(paramK, paramV);
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
    
    public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      return this.delegate.putAll(paramK, MapConstraints.checkValues(paramK, paramIterable, this.constraint));
    }
    
    public Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      return this.delegate.replaceValues(paramK, MapConstraints.checkValues(paramK, paramIterable, this.constraint));
    }
  }
  
  private static class ConstrainedSetMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements SetMultimap<K, V>
  {
    ConstrainedSetMultimap(SetMultimap<K, V> paramSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
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
  }
  
  private static class ConstrainedSortedSetMultimap<K, V>
    extends MapConstraints.ConstrainedSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public SortedSet<V> get(K paramK)
    {
      return (SortedSet)super.get(paramK);
    }
    
    public SortedSet<V> removeAll(Object paramObject)
    {
      return (SortedSet)super.removeAll(paramObject);
    }
    
    public SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      return (SortedSet)super.replaceValues(paramK, paramIterable);
    }
    
    public Comparator<? super V> valueComparator()
    {
      return ((SortedSetMultimap)delegate()).valueComparator();
    }
  }
  
  private static class InverseConstraint<K, V>
    implements MapConstraint<K, V>
  {
    final MapConstraint<? super V, ? super K> constraint;
    
    public InverseConstraint(MapConstraint<? super V, ? super K> paramMapConstraint)
    {
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    public void checkKeyValue(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramV, paramK);
    }
  }
  
  private static enum NotNullMapConstraint
    implements MapConstraint<Object, Object>
  {
    INSTANCE;
    
    private NotNullMapConstraint() {}
    
    public void checkKeyValue(Object paramObject1, Object paramObject2)
    {
      Preconditions.checkNotNull(paramObject1);
      Preconditions.checkNotNull(paramObject2);
    }
    
    public String toString()
    {
      return "Not null";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/MapConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */