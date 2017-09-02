package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public final class ImmutableSortedMap<K, V>
  extends ImmutableSortedMapFauxverideShim<K, V>
  implements NavigableMap<K, V>
{
  private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
  private static final Comparator<Comparable> NATURAL_ORDER = ;
  private static final long serialVersionUID = 0L;
  private transient ImmutableSortedMap<K, V> descendingMap;
  private final transient RegularImmutableSortedSet<K> keySet;
  private final transient ImmutableList<V> valueList;
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList)
  {
    this(paramRegularImmutableSortedSet, paramImmutableList, null);
  }
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList, ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.keySet = paramRegularImmutableSortedSet;
    this.valueList = paramImmutableList;
    this.descendingMap = paramImmutableSortedMap;
  }
  
  @Beta
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    return copyOf(paramIterable, (Ordering)NATURAL_ORDER);
  }
  
  @Beta
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable, Comparator<? super K> paramComparator)
  {
    return fromEntries((Comparator)Preconditions.checkNotNull(paramComparator), false, paramIterable);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    return copyOfInternal(paramMap, (Ordering)NATURAL_ORDER);
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator)
  {
    return copyOfInternal(paramMap, (Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator)
  {
    boolean bool = false;
    Object localObject;
    if ((paramMap instanceof SortedMap))
    {
      localObject = ((SortedMap)paramMap).comparator();
      if (localObject != null) {
        break label62;
      }
      if (paramComparator != NATURAL_ORDER) {
        break label57;
      }
      bool = true;
    }
    while ((bool) && ((paramMap instanceof ImmutableSortedMap)))
    {
      localObject = (ImmutableSortedMap)paramMap;
      if (((ImmutableSortedMap)localObject).isPartialView()) {
        break;
      }
      return (ImmutableSortedMap<K, V>)localObject;
      label57:
      bool = false;
      continue;
      label62:
      bool = paramComparator.equals(localObject);
    }
    return fromEntries(paramComparator, bool, paramMap.entrySet());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> paramSortedMap)
  {
    Object localObject2 = paramSortedMap.comparator();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = NATURAL_ORDER;
    }
    if ((paramSortedMap instanceof ImmutableSortedMap))
    {
      localObject2 = (ImmutableSortedMap)paramSortedMap;
      if (!((ImmutableSortedMap)localObject2).isPartialView()) {
        return (ImmutableSortedMap<K, V>)localObject2;
      }
    }
    return fromEntries((Comparator)localObject1, true, paramSortedMap.entrySet());
  }
  
  static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> paramComparator)
  {
    if (Ordering.natural().equals(paramComparator)) {
      return of();
    }
    return new ImmutableSortedMap(ImmutableSortedSet.emptySet(paramComparator), ImmutableList.of());
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    paramIterable = (Map.Entry[])Iterables.toArray(paramIterable, EMPTY_ENTRY_ARRAY);
    return fromEntries(paramComparator, paramBoolean, paramIterable, paramIterable.length);
  }
  
  private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> paramComparator, boolean paramBoolean, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt)
  {
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      arrayOfObject1 = new Object[paramInt];
      arrayOfObject2 = new Object[paramInt];
      if (paramBoolean)
      {
        i = 0;
        while (i < paramInt)
        {
          localObject1 = paramArrayOfEntry[i].getKey();
          localObject2 = paramArrayOfEntry[i].getValue();
          CollectPreconditions.checkEntryNotNull(localObject1, localObject2);
          arrayOfObject1[i] = localObject1;
          arrayOfObject2[i] = localObject2;
          i += 1;
        }
      }
      break;
    case 0: 
      return emptyMap(paramComparator);
    case 1: 
      return of(paramComparator, paramArrayOfEntry[0].getKey(), paramArrayOfEntry[0].getValue());
    }
    Arrays.sort(paramArrayOfEntry, 0, paramInt, Ordering.from(paramComparator).onKeys());
    Object localObject1 = paramArrayOfEntry[0].getKey();
    arrayOfObject1[0] = localObject1;
    arrayOfObject2[0] = paramArrayOfEntry[0].getValue();
    int i = 1;
    if (i < paramInt)
    {
      localObject2 = paramArrayOfEntry[i].getKey();
      Object localObject3 = paramArrayOfEntry[i].getValue();
      CollectPreconditions.checkEntryNotNull(localObject2, localObject3);
      arrayOfObject1[i] = localObject2;
      arrayOfObject2[i] = localObject3;
      if (paramComparator.compare(localObject1, localObject2) != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        checkNoConflict(paramBoolean, "key", paramArrayOfEntry[(i - 1)], paramArrayOfEntry[i]);
        localObject1 = localObject2;
        i += 1;
        break;
      }
    }
    return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(arrayOfObject1), paramComparator), new RegularImmutableList(arrayOfObject2));
  }
  
  private ImmutableSortedMap<K, V> getSubMap(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 == paramInt2) {
      return emptyMap(comparator());
    }
    return new ImmutableSortedMap(this.keySet.getSubSet(paramInt1, paramInt2), this.valueList.subList(paramInt1, paramInt2));
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder()
  {
    return new Builder(Ordering.natural());
  }
  
  public static <K, V> ImmutableSortedMap<K, V> of()
  {
    return NATURAL_EMPTY_MAP;
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK, V paramV)
  {
    return of(Ordering.natural(), paramK, paramV);
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return ofEntries(new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return ofEntries(new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return ofEntries(new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return ofEntries(new ImmutableMapEntry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> paramComparator, K paramK, V paramV)
  {
    return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(paramK), (Comparator)Preconditions.checkNotNull(paramComparator)), ImmutableList.of(paramV));
  }
  
  private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(ImmutableMapEntry<K, V>... paramVarArgs)
  {
    return fromEntries(Ordering.natural(), false, paramVarArgs, paramVarArgs.length);
  }
  
  public static <K, V> Builder<K, V> orderedBy(Comparator<K> paramComparator)
  {
    return new Builder(paramComparator);
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder()
  {
    return new Builder(Ordering.natural().reverse());
  }
  
  public Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return tailMap(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK)
  {
    return (K)Maps.keyOrNull(ceilingEntry(paramK));
  }
  
  public Comparator<? super K> comparator()
  {
    return keySet().comparator();
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    new ImmutableMapEntrySet()
    {
      ImmutableList<Map.Entry<K, V>> createAsList()
      {
        new ImmutableAsList()
        {
          ImmutableCollection<Map.Entry<K, V>> delegateCollection()
          {
            return ImmutableSortedMap.1EntrySet.this;
          }
          
          public Map.Entry<K, V> get(int paramAnonymous2Int)
          {
            return Maps.immutableEntry(ImmutableSortedMap.this.keySet.asList().get(paramAnonymous2Int), ImmutableSortedMap.this.valueList.get(paramAnonymous2Int));
          }
        };
      }
      
      public UnmodifiableIterator<Map.Entry<K, V>> iterator()
      {
        return asList().iterator();
      }
      
      ImmutableMap<K, V> map()
      {
        return ImmutableSortedMap.this;
      }
    };
  }
  
  public ImmutableSortedSet<K> descendingKeySet()
  {
    return this.keySet.descendingSet();
  }
  
  public ImmutableSortedMap<K, V> descendingMap()
  {
    ImmutableSortedMap localImmutableSortedMap = this.descendingMap;
    if (localImmutableSortedMap == null)
    {
      if (isEmpty()) {
        return emptyMap(Ordering.from(comparator()).reverse());
      }
      return new ImmutableSortedMap((RegularImmutableSortedSet)this.keySet.descendingSet(), this.valueList.reverse(), this);
    }
    return localImmutableSortedMap;
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    return super.entrySet();
  }
  
  public Map.Entry<K, V> firstEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)entrySet().asList().get(0);
  }
  
  public K firstKey()
  {
    return (K)keySet().first();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK)
  {
    return headMap(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK)
  {
    return (K)Maps.keyOrNull(floorEntry(paramK));
  }
  
  public V get(@Nullable Object paramObject)
  {
    int i = this.keySet.indexOf(paramObject);
    if (i == -1) {
      return null;
    }
    return (V)this.valueList.get(i);
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK, boolean paramBoolean)
  {
    return getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(paramK), paramBoolean));
  }
  
  public Map.Entry<K, V> higherEntry(K paramK)
  {
    return tailMap(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK)
  {
    return (K)Maps.keyOrNull(higherEntry(paramK));
  }
  
  boolean isPartialView()
  {
    return (this.keySet.isPartialView()) || (this.valueList.isPartialView());
  }
  
  public ImmutableSortedSet<K> keySet()
  {
    return this.keySet;
  }
  
  public Map.Entry<K, V> lastEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)entrySet().asList().get(size() - 1);
  }
  
  public K lastKey()
  {
    return (K)keySet().last();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK)
  {
    return headMap(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK)
  {
    return (K)Maps.keyOrNull(lowerEntry(paramK));
  }
  
  public ImmutableSortedSet<K> navigableKeySet()
  {
    return this.keySet;
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.valueList.size();
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramK1);
    Preconditions.checkNotNull(paramK2);
    if (comparator().compare(paramK1, paramK2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "expected fromKey <= toKey but %s > %s", new Object[] { paramK1, paramK2 });
      return headMap(paramK2, paramBoolean2).tailMap(paramK1, paramBoolean1);
    }
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK, boolean paramBoolean)
  {
    return getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(paramK), paramBoolean), size());
  }
  
  public ImmutableCollection<V> values()
  {
    return this.valueList;
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    private final Comparator<? super K> comparator;
    
    public Builder(Comparator<? super K> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public ImmutableSortedMap<K, V> build()
    {
      switch (this.size)
      {
      default: 
        return ImmutableSortedMap.fromEntries(this.comparator, false, this.entries, this.size);
      case 0: 
        return ImmutableSortedMap.emptyMap(this.comparator);
      }
      return ImmutableSortedMap.of(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
    }
    
    @Deprecated
    @Beta
    public Builder<K, V> orderEntriesByValue(Comparator<? super V> paramComparator)
    {
      throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
    }
    
    public Builder<K, V> put(K paramK, V paramV)
    {
      super.put(paramK, paramV);
      return this;
    }
    
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      super.put(paramEntry);
      return this;
    }
    
    @Beta
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
    {
      super.putAll(paramIterable);
      return this;
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap)
    {
      super.putAll(paramMap);
      return this;
    }
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    private final Comparator<Object> comparator;
    
    SerializedForm(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
    {
      super();
      this.comparator = paramImmutableSortedMap.comparator();
    }
    
    Object readResolve()
    {
      return createMap(new ImmutableSortedMap.Builder(this.comparator));
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */