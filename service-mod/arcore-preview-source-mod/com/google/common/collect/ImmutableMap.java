package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableMap<K, V>
  implements Map<K, V>, Serializable
{
  static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  private transient ImmutableSet<K> keySet;
  private transient ImmutableSetMultimap<K, V> multimapView;
  private transient ImmutableCollection<V> values;
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  static void checkNoConflict(boolean paramBoolean, String paramString, Map.Entry<?, ?> paramEntry1, Map.Entry<?, ?> paramEntry2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException("Multiple entries with same " + paramString + ": " + paramEntry1 + " and " + paramEntry2);
    }
  }
  
  @Beta
  public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    paramIterable = (Map.Entry[])Iterables.toArray(paramIterable, EMPTY_ENTRY_ARRAY);
    switch (paramIterable.length)
    {
    default: 
      return RegularImmutableMap.fromEntries(paramIterable);
    case 0: 
      return of();
    }
    paramIterable = paramIterable[0];
    return of(paramIterable.getKey(), paramIterable.getValue());
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if (((paramMap instanceof ImmutableMap)) && (!(paramMap instanceof ImmutableSortedMap)))
    {
      ImmutableMap localImmutableMap = (ImmutableMap)paramMap;
      if (!localImmutableMap.isPartialView()) {
        return localImmutableMap;
      }
    }
    else if ((paramMap instanceof EnumMap))
    {
      return copyOfEnumMap((EnumMap)paramMap);
    }
    return copyOf(paramMap.entrySet());
  }
  
  private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> paramEnumMap)
  {
    paramEnumMap = new EnumMap(paramEnumMap);
    Iterator localIterator = paramEnumMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      CollectPreconditions.checkEntryNotNull(localEntry.getKey(), localEntry.getValue());
    }
    return ImmutableEnumMap.asImmutable(paramEnumMap);
  }
  
  static <K, V> ImmutableMapEntry<K, V> entryOf(K paramK, V paramV)
  {
    return new ImmutableMapEntry(paramK, paramV);
  }
  
  public static <K, V> ImmutableMap<K, V> of()
  {
    return ImmutableBiMap.of();
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK, V paramV)
  {
    return ImmutableBiMap.of(paramK, paramV);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return RegularImmutableMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return RegularImmutableMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return RegularImmutableMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return RegularImmutableMap.fromEntries(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  @Beta
  public ImmutableSetMultimap<K, V> asMultimap()
  {
    if (isEmpty()) {
      localObject = ImmutableSetMultimap.of();
    }
    ImmutableSetMultimap localImmutableSetMultimap;
    do
    {
      return (ImmutableSetMultimap<K, V>)localObject;
      localImmutableSetMultimap = this.multimapView;
      localObject = localImmutableSetMultimap;
    } while (localImmutableSetMultimap != null);
    Object localObject = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(null), size(), null);
    this.multimapView = ((ImmutableSetMultimap)localObject);
    return (ImmutableSetMultimap<K, V>)localObject;
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();
  
  ImmutableSet<K> createKeySet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new ImmutableMapKeySet(this);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    ImmutableSet localImmutableSet2 = this.entrySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createEntrySet();
      this.entrySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return Maps.equalsImpl(this, paramObject);
  }
  
  public abstract V get(@Nullable Object paramObject);
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  abstract boolean isPartialView();
  
  UnmodifiableIterator<K> keyIterator()
  {
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return this.val$entryIterator.hasNext();
      }
      
      public K next()
      {
        return (K)((Map.Entry)this.val$entryIterator.next()).getKey();
      }
    };
  }
  
  public ImmutableSet<K> keySet()
  {
    ImmutableSet localImmutableSet2 = this.keySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createKeySet();
      this.keySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  @Deprecated
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return Maps.toStringImpl(this);
  }
  
  public ImmutableCollection<V> values()
  {
    ImmutableCollection localImmutableCollection = this.values;
    Object localObject = localImmutableCollection;
    if (localImmutableCollection == null)
    {
      localObject = new ImmutableMapValues(this);
      this.values = ((ImmutableCollection)localObject);
    }
    return (ImmutableCollection<V>)localObject;
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V>
  {
    ImmutableMapEntry<K, V>[] entries;
    boolean entriesUsed;
    int size;
    Comparator<? super V> valueComparator;
    
    public Builder()
    {
      this(4);
    }
    
    Builder(int paramInt)
    {
      this.entries = new ImmutableMapEntry[paramInt];
      this.size = 0;
      this.entriesUsed = false;
    }
    
    private void ensureCapacity(int paramInt)
    {
      if (paramInt > this.entries.length)
      {
        this.entries = ((ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection.Builder.expandedCapacity(this.entries.length, paramInt)));
        this.entriesUsed = false;
      }
    }
    
    public ImmutableMap<K, V> build()
    {
      switch (this.size)
      {
      default: 
        if (this.valueComparator != null)
        {
          if (this.entriesUsed) {
            this.entries = ((ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size));
          }
          Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
        }
        if (this.size != this.entries.length) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.entriesUsed = bool;
        return RegularImmutableMap.fromEntryArray(this.size, this.entries);
        return ImmutableMap.of();
        return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
      }
    }
    
    @Beta
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> paramComparator)
    {
      if (this.valueComparator == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "valueComparator was already set");
        this.valueComparator = ((Comparator)Preconditions.checkNotNull(paramComparator, "valueComparator"));
        return this;
      }
    }
    
    public Builder<K, V> put(K paramK, V paramV)
    {
      ensureCapacity(this.size + 1);
      paramK = ImmutableMap.entryOf(paramK, paramV);
      paramV = this.entries;
      int i = this.size;
      this.size = (i + 1);
      paramV[i] = paramK;
      return this;
    }
    
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      return put(paramEntry.getKey(), paramEntry.getValue());
    }
    
    @Beta
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      if ((paramIterable instanceof Collection))
      {
        int i = this.size;
        ensureCapacity(((Collection)paramIterable).size() + i);
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        put((Map.Entry)paramIterable.next());
      }
      return this;
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap)
    {
      return putAll(paramMap.entrySet());
    }
  }
  
  static abstract class IteratorBasedImmutableMap<K, V>
    extends ImmutableMap<K, V>
  {
    ImmutableSet<Map.Entry<K, V>> createEntrySet()
    {
      new ImmutableMapEntrySet()
      {
        public UnmodifiableIterator<Map.Entry<K, V>> iterator()
        {
          return ImmutableMap.IteratorBasedImmutableMap.this.entryIterator();
        }
        
        ImmutableMap<K, V> map()
        {
          return ImmutableMap.IteratorBasedImmutableMap.this;
        }
      };
    }
    
    abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();
  }
  
  private final class MapViewOfValuesAsSingletonSets
    extends ImmutableMap.IteratorBasedImmutableMap<K, ImmutableSet<V>>
  {
    private MapViewOfValuesAsSingletonSets() {}
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return ImmutableMap.this.containsKey(paramObject);
    }
    
    UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator()
    {
      new UnmodifiableIterator()
      {
        public boolean hasNext()
        {
          return this.val$backingIterator.hasNext();
        }
        
        public Map.Entry<K, ImmutableSet<V>> next()
        {
          new AbstractMapEntry()
          {
            public K getKey()
            {
              return (K)this.val$backingEntry.getKey();
            }
            
            public ImmutableSet<V> getValue()
            {
              return ImmutableSet.of(this.val$backingEntry.getValue());
            }
          };
        }
      };
    }
    
    public ImmutableSet<V> get(@Nullable Object paramObject)
    {
      paramObject = ImmutableMap.this.get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return ImmutableSet.of(paramObject);
    }
    
    public int hashCode()
    {
      return ImmutableMap.this.hashCode();
    }
    
    boolean isHashCodeFast()
    {
      return ImmutableMap.this.isHashCodeFast();
    }
    
    boolean isPartialView()
    {
      return ImmutableMap.this.isPartialView();
    }
    
    public ImmutableSet<K> keySet()
    {
      return ImmutableMap.this.keySet();
    }
    
    public int size()
    {
      return ImmutableMap.this.size();
    }
  }
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Object[] keys;
    private final Object[] values;
    
    SerializedForm(ImmutableMap<?, ?> paramImmutableMap)
    {
      this.keys = new Object[paramImmutableMap.size()];
      this.values = new Object[paramImmutableMap.size()];
      int i = 0;
      paramImmutableMap = paramImmutableMap.entrySet().iterator();
      while (paramImmutableMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramImmutableMap.next();
        this.keys[i] = localEntry.getKey();
        this.values[i] = localEntry.getValue();
        i += 1;
      }
    }
    
    Object createMap(ImmutableMap.Builder<Object, Object> paramBuilder)
    {
      int i = 0;
      while (i < this.keys.length)
      {
        paramBuilder.put(this.keys[i], this.values[i]);
        i += 1;
      }
      return paramBuilder.build();
    }
    
    Object readResolve()
    {
      return createMap(new ImmutableMap.Builder(this.keys.length));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */