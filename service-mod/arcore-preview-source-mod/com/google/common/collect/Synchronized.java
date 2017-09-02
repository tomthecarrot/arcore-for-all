package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Synchronized
{
  static <K, V> BiMap<K, V> biMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject)
  {
    if (((paramBiMap instanceof SynchronizedBiMap)) || ((paramBiMap instanceof ImmutableBiMap))) {
      return paramBiMap;
    }
    return new SynchronizedBiMap(paramBiMap, paramObject, null, null);
  }
  
  private static <E> Collection<E> collection(Collection<E> paramCollection, @Nullable Object paramObject)
  {
    return new SynchronizedCollection(paramCollection, paramObject, null);
  }
  
  @GwtIncompatible("Deque")
  static <E> Deque<E> deque(Deque<E> paramDeque, @Nullable Object paramObject)
  {
    return new SynchronizedDeque(paramDeque, paramObject);
  }
  
  private static <E> List<E> list(List<E> paramList, @Nullable Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return new SynchronizedRandomAccessList(paramList, paramObject);
    }
    return new SynchronizedList(paramList, paramObject);
  }
  
  static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject)
  {
    if (((paramListMultimap instanceof SynchronizedListMultimap)) || ((paramListMultimap instanceof ImmutableListMultimap))) {
      return paramListMultimap;
    }
    return new SynchronizedListMultimap(paramListMultimap, paramObject);
  }
  
  @VisibleForTesting
  static <K, V> Map<K, V> map(Map<K, V> paramMap, @Nullable Object paramObject)
  {
    return new SynchronizedMap(paramMap, paramObject);
  }
  
  static <K, V> Multimap<K, V> multimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject)
  {
    if (((paramMultimap instanceof SynchronizedMultimap)) || ((paramMultimap instanceof ImmutableMultimap))) {
      return paramMultimap;
    }
    return new SynchronizedMultimap(paramMultimap, paramObject);
  }
  
  static <E> Multiset<E> multiset(Multiset<E> paramMultiset, @Nullable Object paramObject)
  {
    if (((paramMultiset instanceof SynchronizedMultiset)) || ((paramMultiset instanceof ImmutableMultiset))) {
      return paramMultiset;
    }
    return new SynchronizedMultiset(paramMultiset, paramObject);
  }
  
  @GwtIncompatible("NavigableMap")
  static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> paramNavigableMap)
  {
    return navigableMap(paramNavigableMap, null);
  }
  
  @GwtIncompatible("NavigableMap")
  static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> paramNavigableMap, @Nullable Object paramObject)
  {
    return new SynchronizedNavigableMap(paramNavigableMap, paramObject);
  }
  
  @GwtIncompatible("NavigableSet")
  static <E> NavigableSet<E> navigableSet(NavigableSet<E> paramNavigableSet)
  {
    return navigableSet(paramNavigableSet, null);
  }
  
  @GwtIncompatible("NavigableSet")
  static <E> NavigableSet<E> navigableSet(NavigableSet<E> paramNavigableSet, @Nullable Object paramObject)
  {
    return new SynchronizedNavigableSet(paramNavigableSet, paramObject);
  }
  
  @GwtIncompatible("works but is needed only for NavigableMap")
  private static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@Nullable Map.Entry<K, V> paramEntry, @Nullable Object paramObject)
  {
    if (paramEntry == null) {
      return null;
    }
    return new SynchronizedEntry(paramEntry, paramObject);
  }
  
  static <E> Queue<E> queue(Queue<E> paramQueue, @Nullable Object paramObject)
  {
    if ((paramQueue instanceof SynchronizedQueue)) {
      return paramQueue;
    }
    return new SynchronizedQueue(paramQueue, paramObject);
  }
  
  @VisibleForTesting
  static <E> Set<E> set(Set<E> paramSet, @Nullable Object paramObject)
  {
    return new SynchronizedSet(paramSet, paramObject);
  }
  
  static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject)
  {
    if (((paramSetMultimap instanceof SynchronizedSetMultimap)) || ((paramSetMultimap instanceof ImmutableSetMultimap))) {
      return paramSetMultimap;
    }
    return new SynchronizedSetMultimap(paramSetMultimap, paramObject);
  }
  
  static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject)
  {
    return new SynchronizedSortedMap(paramSortedMap, paramObject);
  }
  
  private static <E> SortedSet<E> sortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject)
  {
    return new SynchronizedSortedSet(paramSortedSet, paramObject);
  }
  
  static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject)
  {
    if ((paramSortedSetMultimap instanceof SynchronizedSortedSetMultimap)) {
      return paramSortedSetMultimap;
    }
    return new SynchronizedSortedSetMultimap(paramSortedSetMultimap, paramObject);
  }
  
  private static <E> Collection<E> typePreservingCollection(Collection<E> paramCollection, @Nullable Object paramObject)
  {
    if ((paramCollection instanceof SortedSet)) {
      return sortedSet((SortedSet)paramCollection, paramObject);
    }
    if ((paramCollection instanceof Set)) {
      return set((Set)paramCollection, paramObject);
    }
    if ((paramCollection instanceof List)) {
      return list((List)paramCollection, paramObject);
    }
    return collection(paramCollection, paramObject);
  }
  
  private static <E> Set<E> typePreservingSet(Set<E> paramSet, @Nullable Object paramObject)
  {
    if ((paramSet instanceof SortedSet)) {
      return sortedSet((SortedSet)paramSet, paramObject);
    }
    return set(paramSet, paramObject);
  }
  
  private static class SynchronizedAsMap<K, V>
    extends Synchronized.SynchronizedMap<K, Collection<V>>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
    transient Collection<Collection<V>> asMapValues;
    
    SynchronizedAsMap(Map<K, Collection<V>> paramMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return values().contains(paramObject);
    }
    
    public Set<Map.Entry<K, Collection<V>>> entrySet()
    {
      synchronized (this.mutex)
      {
        if (this.asMapEntrySet == null) {
          this.asMapEntrySet = new Synchronized.SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
        }
        Set localSet = this.asMapEntrySet;
        return localSet;
      }
    }
    
    public Collection<V> get(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = (Collection)super.get(paramObject);
        if (paramObject == null)
        {
          paramObject = null;
          return (Collection<V>)paramObject;
        }
        paramObject = Synchronized.typePreservingCollection((Collection)paramObject, this.mutex);
      }
    }
    
    public Collection<Collection<V>> values()
    {
      synchronized (this.mutex)
      {
        if (this.asMapValues == null) {
          this.asMapValues = new Synchronized.SynchronizedAsMapValues(delegate().values(), this.mutex);
        }
        Collection localCollection = this.asMapValues;
        return localCollection;
      }
    }
  }
  
  private static class SynchronizedAsMapEntries<K, V>
    extends Synchronized.SynchronizedSet<Map.Entry<K, Collection<V>>>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public boolean contains(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = Maps.containsEntryImpl(delegate(), paramObject);
        return bool;
      }
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = Collections2.containsAllImpl(delegate(), paramCollection);
        return bool;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = Sets.equalsImpl(delegate(), paramObject);
        return bool;
      }
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      new TransformedIterator(super.iterator())
      {
        Map.Entry<K, Collection<V>> transform(final Map.Entry<K, Collection<V>> paramAnonymousEntry)
        {
          new ForwardingMapEntry()
          {
            protected Map.Entry<K, Collection<V>> delegate()
            {
              return paramAnonymousEntry;
            }
            
            public Collection<V> getValue()
            {
              return Synchronized.typePreservingCollection((Collection)paramAnonymousEntry.getValue(), Synchronized.SynchronizedAsMapEntries.this.mutex);
            }
          };
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = Maps.removeEntryImpl(delegate(), paramObject);
        return bool;
      }
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = Iterators.removeAll(delegate().iterator(), paramCollection);
        return bool;
      }
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = Iterators.retainAll(delegate().iterator(), paramCollection);
        return bool;
      }
    }
    
    public Object[] toArray()
    {
      synchronized (this.mutex)
      {
        Object[] arrayOfObject = ObjectArrays.toArrayImpl(delegate());
        return arrayOfObject;
      }
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      synchronized (this.mutex)
      {
        paramArrayOfT = ObjectArrays.toArrayImpl(delegate(), paramArrayOfT);
        return paramArrayOfT;
      }
    }
  }
  
  private static class SynchronizedAsMapValues<V>
    extends Synchronized.SynchronizedCollection<Collection<V>>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedAsMapValues(Collection<Collection<V>> paramCollection, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public Iterator<Collection<V>> iterator()
    {
      new TransformedIterator(super.iterator())
      {
        Collection<V> transform(Collection<V> paramAnonymousCollection)
        {
          return Synchronized.typePreservingCollection(paramAnonymousCollection, Synchronized.SynchronizedAsMapValues.this.mutex);
        }
      };
    }
  }
  
  @VisibleForTesting
  static class SynchronizedBiMap<K, V>
    extends Synchronized.SynchronizedMap<K, V>
    implements BiMap<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private transient BiMap<V, K> inverse;
    private transient Set<V> valueSet;
    
    private SynchronizedBiMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject, @Nullable BiMap<V, K> paramBiMap1)
    {
      super(paramObject);
      this.inverse = paramBiMap1;
    }
    
    BiMap<K, V> delegate()
    {
      return (BiMap)super.delegate();
    }
    
    public V forcePut(K paramK, V paramV)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().forcePut(paramK, paramV);
        return paramK;
      }
    }
    
    public BiMap<V, K> inverse()
    {
      synchronized (this.mutex)
      {
        if (this.inverse == null) {
          this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
        }
        BiMap localBiMap = this.inverse;
        return localBiMap;
      }
    }
    
    public Set<V> values()
    {
      synchronized (this.mutex)
      {
        if (this.valueSet == null) {
          this.valueSet = Synchronized.set(delegate().values(), this.mutex);
        }
        Set localSet = this.valueSet;
        return localSet;
      }
    }
  }
  
  @VisibleForTesting
  static class SynchronizedCollection<E>
    extends Synchronized.SynchronizedObject
    implements Collection<E>
  {
    private static final long serialVersionUID = 0L;
    
    private SynchronizedCollection(Collection<E> paramCollection, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public boolean add(E paramE)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().add(paramE);
        return bool;
      }
    }
    
    public boolean addAll(Collection<? extends E> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().addAll(paramCollection);
        return bool;
      }
    }
    
    public void clear()
    {
      synchronized (this.mutex)
      {
        delegate().clear();
        return;
      }
    }
    
    public boolean contains(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().contains(paramObject);
        return bool;
      }
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsAll(paramCollection);
        return bool;
      }
    }
    
    Collection<E> delegate()
    {
      return (Collection)super.delegate();
    }
    
    public boolean isEmpty()
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().isEmpty();
        return bool;
      }
    }
    
    public Iterator<E> iterator()
    {
      return delegate().iterator();
    }
    
    public boolean remove(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().remove(paramObject);
        return bool;
      }
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().removeAll(paramCollection);
        return bool;
      }
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().retainAll(paramCollection);
        return bool;
      }
    }
    
    public int size()
    {
      synchronized (this.mutex)
      {
        int i = delegate().size();
        return i;
      }
    }
    
    public Object[] toArray()
    {
      synchronized (this.mutex)
      {
        Object[] arrayOfObject = delegate().toArray();
        return arrayOfObject;
      }
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      synchronized (this.mutex)
      {
        paramArrayOfT = delegate().toArray(paramArrayOfT);
        return paramArrayOfT;
      }
    }
  }
  
  @GwtIncompatible("Deque")
  private static final class SynchronizedDeque<E>
    extends Synchronized.SynchronizedQueue<E>
    implements Deque<E>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedDeque(Deque<E> paramDeque, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public void addFirst(E paramE)
    {
      synchronized (this.mutex)
      {
        delegate().addFirst(paramE);
        return;
      }
    }
    
    public void addLast(E paramE)
    {
      synchronized (this.mutex)
      {
        delegate().addLast(paramE);
        return;
      }
    }
    
    Deque<E> delegate()
    {
      return (Deque)super.delegate();
    }
    
    public Iterator<E> descendingIterator()
    {
      synchronized (this.mutex)
      {
        Iterator localIterator = delegate().descendingIterator();
        return localIterator;
      }
    }
    
    public E getFirst()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().getFirst();
        return (E)localObject2;
      }
    }
    
    public E getLast()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().getLast();
        return (E)localObject2;
      }
    }
    
    public boolean offerFirst(E paramE)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().offerFirst(paramE);
        return bool;
      }
    }
    
    public boolean offerLast(E paramE)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().offerLast(paramE);
        return bool;
      }
    }
    
    public E peekFirst()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().peekFirst();
        return (E)localObject2;
      }
    }
    
    public E peekLast()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().peekLast();
        return (E)localObject2;
      }
    }
    
    public E pollFirst()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().pollFirst();
        return (E)localObject2;
      }
    }
    
    public E pollLast()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().pollLast();
        return (E)localObject2;
      }
    }
    
    public E pop()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().pop();
        return (E)localObject2;
      }
    }
    
    public void push(E paramE)
    {
      synchronized (this.mutex)
      {
        delegate().push(paramE);
        return;
      }
    }
    
    public E removeFirst()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().removeFirst();
        return (E)localObject2;
      }
    }
    
    public boolean removeFirstOccurrence(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().removeFirstOccurrence(paramObject);
        return bool;
      }
    }
    
    public E removeLast()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().removeLast();
        return (E)localObject2;
      }
    }
    
    public boolean removeLastOccurrence(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().removeLastOccurrence(paramObject);
        return bool;
      }
    }
  }
  
  @GwtIncompatible("works but is needed only for NavigableMap")
  private static class SynchronizedEntry<K, V>
    extends Synchronized.SynchronizedObject
    implements Map.Entry<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedEntry(Map.Entry<K, V> paramEntry, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    Map.Entry<K, V> delegate()
    {
      return (Map.Entry)super.delegate();
    }
    
    public boolean equals(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public K getKey()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().getKey();
        return (K)localObject2;
      }
    }
    
    public V getValue()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().getValue();
        return (V)localObject2;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
    
    public V setValue(V paramV)
    {
      synchronized (this.mutex)
      {
        paramV = delegate().setValue(paramV);
        return paramV;
      }
    }
  }
  
  private static class SynchronizedList<E>
    extends Synchronized.SynchronizedCollection<E>
    implements List<E>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedList(List<E> paramList, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public void add(int paramInt, E paramE)
    {
      synchronized (this.mutex)
      {
        delegate().add(paramInt, paramE);
        return;
      }
    }
    
    public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().addAll(paramInt, paramCollection);
        return bool;
      }
    }
    
    List<E> delegate()
    {
      return (List)super.delegate();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public E get(int paramInt)
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().get(paramInt);
        return (E)localObject2;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
    
    public int indexOf(Object paramObject)
    {
      synchronized (this.mutex)
      {
        int i = delegate().indexOf(paramObject);
        return i;
      }
    }
    
    public int lastIndexOf(Object paramObject)
    {
      synchronized (this.mutex)
      {
        int i = delegate().lastIndexOf(paramObject);
        return i;
      }
    }
    
    public ListIterator<E> listIterator()
    {
      return delegate().listIterator();
    }
    
    public ListIterator<E> listIterator(int paramInt)
    {
      return delegate().listIterator(paramInt);
    }
    
    public E remove(int paramInt)
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().remove(paramInt);
        return (E)localObject2;
      }
    }
    
    public E set(int paramInt, E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = delegate().set(paramInt, paramE);
        return paramE;
      }
    }
    
    public List<E> subList(int paramInt1, int paramInt2)
    {
      synchronized (this.mutex)
      {
        List localList = Synchronized.list(delegate().subList(paramInt1, paramInt2), this.mutex);
        return localList;
      }
    }
  }
  
  private static class SynchronizedListMultimap<K, V>
    extends Synchronized.SynchronizedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedListMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    ListMultimap<K, V> delegate()
    {
      return (ListMultimap)super.delegate();
    }
    
    public List<V> get(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.list(delegate().get(paramK), this.mutex);
        return paramK;
      }
    }
    
    public List<V> removeAll(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().removeAll(paramObject);
        return (List<V>)paramObject;
      }
    }
    
    public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().replaceValues(paramK, paramIterable);
        return paramK;
      }
    }
  }
  
  private static class SynchronizedMap<K, V>
    extends Synchronized.SynchronizedObject
    implements Map<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, V>> entrySet;
    transient Set<K> keySet;
    transient Collection<V> values;
    
    SynchronizedMap(Map<K, V> paramMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public void clear()
    {
      synchronized (this.mutex)
      {
        delegate().clear();
        return;
      }
    }
    
    public boolean containsKey(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsKey(paramObject);
        return bool;
      }
    }
    
    public boolean containsValue(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsValue(paramObject);
        return bool;
      }
    }
    
    Map<K, V> delegate()
    {
      return (Map)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      synchronized (this.mutex)
      {
        if (this.entrySet == null) {
          this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);
        }
        Set localSet = this.entrySet;
        return localSet;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public V get(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().get(paramObject);
        return (V)paramObject;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
    
    public boolean isEmpty()
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().isEmpty();
        return bool;
      }
    }
    
    public Set<K> keySet()
    {
      synchronized (this.mutex)
      {
        if (this.keySet == null) {
          this.keySet = Synchronized.set(delegate().keySet(), this.mutex);
        }
        Set localSet = this.keySet;
        return localSet;
      }
    }
    
    public V put(K paramK, V paramV)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().put(paramK, paramV);
        return paramK;
      }
    }
    
    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      synchronized (this.mutex)
      {
        delegate().putAll(paramMap);
        return;
      }
    }
    
    public V remove(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().remove(paramObject);
        return (V)paramObject;
      }
    }
    
    public int size()
    {
      synchronized (this.mutex)
      {
        int i = delegate().size();
        return i;
      }
    }
    
    public Collection<V> values()
    {
      synchronized (this.mutex)
      {
        if (this.values == null) {
          this.values = Synchronized.collection(delegate().values(), this.mutex);
        }
        Collection localCollection = this.values;
        return localCollection;
      }
    }
  }
  
  private static class SynchronizedMultimap<K, V>
    extends Synchronized.SynchronizedObject
    implements Multimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Map<K, Collection<V>> asMap;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient Multiset<K> keys;
    transient Collection<V> valuesCollection;
    
    SynchronizedMultimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public Map<K, Collection<V>> asMap()
    {
      synchronized (this.mutex)
      {
        if (this.asMap == null) {
          this.asMap = new Synchronized.SynchronizedAsMap(delegate().asMap(), this.mutex);
        }
        Map localMap = this.asMap;
        return localMap;
      }
    }
    
    public void clear()
    {
      synchronized (this.mutex)
      {
        delegate().clear();
        return;
      }
    }
    
    public boolean containsEntry(Object paramObject1, Object paramObject2)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsEntry(paramObject1, paramObject2);
        return bool;
      }
    }
    
    public boolean containsKey(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsKey(paramObject);
        return bool;
      }
    }
    
    public boolean containsValue(Object paramObject)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().containsValue(paramObject);
        return bool;
      }
    }
    
    Multimap<K, V> delegate()
    {
      return (Multimap)super.delegate();
    }
    
    public Collection<Map.Entry<K, V>> entries()
    {
      synchronized (this.mutex)
      {
        if (this.entries == null) {
          this.entries = Synchronized.typePreservingCollection(delegate().entries(), this.mutex);
        }
        Collection localCollection = this.entries;
        return localCollection;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public Collection<V> get(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.typePreservingCollection(delegate().get(paramK), this.mutex);
        return paramK;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
    
    public boolean isEmpty()
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().isEmpty();
        return bool;
      }
    }
    
    public Set<K> keySet()
    {
      synchronized (this.mutex)
      {
        if (this.keySet == null) {
          this.keySet = Synchronized.typePreservingSet(delegate().keySet(), this.mutex);
        }
        Set localSet = this.keySet;
        return localSet;
      }
    }
    
    public Multiset<K> keys()
    {
      synchronized (this.mutex)
      {
        if (this.keys == null) {
          this.keys = Synchronized.multiset(delegate().keys(), this.mutex);
        }
        Multiset localMultiset = this.keys;
        return localMultiset;
      }
    }
    
    public boolean put(K paramK, V paramV)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().put(paramK, paramV);
        return bool;
      }
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().putAll(paramMultimap);
        return bool;
      }
    }
    
    public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().putAll(paramK, paramIterable);
        return bool;
      }
    }
    
    public boolean remove(Object paramObject1, Object paramObject2)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().remove(paramObject1, paramObject2);
        return bool;
      }
    }
    
    public Collection<V> removeAll(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().removeAll(paramObject);
        return (Collection<V>)paramObject;
      }
    }
    
    public Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().replaceValues(paramK, paramIterable);
        return paramK;
      }
    }
    
    public int size()
    {
      synchronized (this.mutex)
      {
        int i = delegate().size();
        return i;
      }
    }
    
    public Collection<V> values()
    {
      synchronized (this.mutex)
      {
        if (this.valuesCollection == null) {
          this.valuesCollection = Synchronized.collection(delegate().values(), this.mutex);
        }
        Collection localCollection = this.valuesCollection;
        return localCollection;
      }
    }
  }
  
  private static class SynchronizedMultiset<E>
    extends Synchronized.SynchronizedCollection<E>
    implements Multiset<E>
  {
    private static final long serialVersionUID = 0L;
    transient Set<E> elementSet;
    transient Set<Multiset.Entry<E>> entrySet;
    
    SynchronizedMultiset(Multiset<E> paramMultiset, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public int add(E paramE, int paramInt)
    {
      synchronized (this.mutex)
      {
        paramInt = delegate().add(paramE, paramInt);
        return paramInt;
      }
    }
    
    public int count(Object paramObject)
    {
      synchronized (this.mutex)
      {
        int i = delegate().count(paramObject);
        return i;
      }
    }
    
    Multiset<E> delegate()
    {
      return (Multiset)super.delegate();
    }
    
    public Set<E> elementSet()
    {
      synchronized (this.mutex)
      {
        if (this.elementSet == null) {
          this.elementSet = Synchronized.typePreservingSet(delegate().elementSet(), this.mutex);
        }
        Set localSet = this.elementSet;
        return localSet;
      }
    }
    
    public Set<Multiset.Entry<E>> entrySet()
    {
      synchronized (this.mutex)
      {
        if (this.entrySet == null) {
          this.entrySet = Synchronized.typePreservingSet(delegate().entrySet(), this.mutex);
        }
        Set localSet = this.entrySet;
        return localSet;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
    
    public int remove(Object paramObject, int paramInt)
    {
      synchronized (this.mutex)
      {
        paramInt = delegate().remove(paramObject, paramInt);
        return paramInt;
      }
    }
    
    public int setCount(E paramE, int paramInt)
    {
      synchronized (this.mutex)
      {
        paramInt = delegate().setCount(paramE, paramInt);
        return paramInt;
      }
    }
    
    public boolean setCount(E paramE, int paramInt1, int paramInt2)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().setCount(paramE, paramInt1, paramInt2);
        return bool;
      }
    }
  }
  
  @GwtIncompatible("NavigableMap")
  @VisibleForTesting
  static class SynchronizedNavigableMap<K, V>
    extends Synchronized.SynchronizedSortedMap<K, V>
    implements NavigableMap<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient NavigableSet<K> descendingKeySet;
    transient NavigableMap<K, V> descendingMap;
    transient NavigableSet<K> navigableKeySet;
    
    SynchronizedNavigableMap(NavigableMap<K, V> paramNavigableMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public Map.Entry<K, V> ceilingEntry(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.nullableSynchronizedEntry(delegate().ceilingEntry(paramK), this.mutex);
        return paramK;
      }
    }
    
    public K ceilingKey(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().ceilingKey(paramK);
        return paramK;
      }
    }
    
    NavigableMap<K, V> delegate()
    {
      return (NavigableMap)super.delegate();
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      synchronized (this.mutex)
      {
        if (this.descendingKeySet == null)
        {
          localNavigableSet = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);
          this.descendingKeySet = localNavigableSet;
          return localNavigableSet;
        }
        NavigableSet localNavigableSet = this.descendingKeySet;
        return localNavigableSet;
      }
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      synchronized (this.mutex)
      {
        if (this.descendingMap == null)
        {
          localNavigableMap = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);
          this.descendingMap = localNavigableMap;
          return localNavigableMap;
        }
        NavigableMap localNavigableMap = this.descendingMap;
        return localNavigableMap;
      }
    }
    
    public Map.Entry<K, V> firstEntry()
    {
      synchronized (this.mutex)
      {
        Map.Entry localEntry = Synchronized.nullableSynchronizedEntry(delegate().firstEntry(), this.mutex);
        return localEntry;
      }
    }
    
    public Map.Entry<K, V> floorEntry(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.nullableSynchronizedEntry(delegate().floorEntry(paramK), this.mutex);
        return paramK;
      }
    }
    
    public K floorKey(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().floorKey(paramK);
        return paramK;
      }
    }
    
    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.navigableMap(delegate().headMap(paramK, paramBoolean), this.mutex);
        return paramK;
      }
    }
    
    public SortedMap<K, V> headMap(K paramK)
    {
      return headMap(paramK, false);
    }
    
    public Map.Entry<K, V> higherEntry(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.nullableSynchronizedEntry(delegate().higherEntry(paramK), this.mutex);
        return paramK;
      }
    }
    
    public K higherKey(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().higherKey(paramK);
        return paramK;
      }
    }
    
    public Set<K> keySet()
    {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry()
    {
      synchronized (this.mutex)
      {
        Map.Entry localEntry = Synchronized.nullableSynchronizedEntry(delegate().lastEntry(), this.mutex);
        return localEntry;
      }
    }
    
    public Map.Entry<K, V> lowerEntry(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.nullableSynchronizedEntry(delegate().lowerEntry(paramK), this.mutex);
        return paramK;
      }
    }
    
    public K lowerKey(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().lowerKey(paramK);
        return paramK;
      }
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      synchronized (this.mutex)
      {
        if (this.navigableKeySet == null)
        {
          localNavigableSet = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);
          this.navigableKeySet = localNavigableSet;
          return localNavigableSet;
        }
        NavigableSet localNavigableSet = this.navigableKeySet;
        return localNavigableSet;
      }
    }
    
    public Map.Entry<K, V> pollFirstEntry()
    {
      synchronized (this.mutex)
      {
        Map.Entry localEntry = Synchronized.nullableSynchronizedEntry(delegate().pollFirstEntry(), this.mutex);
        return localEntry;
      }
    }
    
    public Map.Entry<K, V> pollLastEntry()
    {
      synchronized (this.mutex)
      {
        Map.Entry localEntry = Synchronized.nullableSynchronizedEntry(delegate().pollLastEntry(), this.mutex);
        return localEntry;
      }
    }
    
    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      synchronized (this.mutex)
      {
        paramK1 = Synchronized.navigableMap(delegate().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2), this.mutex);
        return paramK1;
      }
    }
    
    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }
    
    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.navigableMap(delegate().tailMap(paramK, paramBoolean), this.mutex);
        return paramK;
      }
    }
    
    public SortedMap<K, V> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }
  }
  
  @GwtIncompatible("NavigableSet")
  @VisibleForTesting
  static class SynchronizedNavigableSet<E>
    extends Synchronized.SynchronizedSortedSet<E>
    implements NavigableSet<E>
  {
    private static final long serialVersionUID = 0L;
    transient NavigableSet<E> descendingSet;
    
    SynchronizedNavigableSet(NavigableSet<E> paramNavigableSet, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public E ceiling(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = delegate().ceiling(paramE);
        return paramE;
      }
    }
    
    NavigableSet<E> delegate()
    {
      return (NavigableSet)super.delegate();
    }
    
    public Iterator<E> descendingIterator()
    {
      return delegate().descendingIterator();
    }
    
    public NavigableSet<E> descendingSet()
    {
      synchronized (this.mutex)
      {
        if (this.descendingSet == null)
        {
          localNavigableSet = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);
          this.descendingSet = localNavigableSet;
          return localNavigableSet;
        }
        NavigableSet localNavigableSet = this.descendingSet;
        return localNavigableSet;
      }
    }
    
    public E floor(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = delegate().floor(paramE);
        return paramE;
      }
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      synchronized (this.mutex)
      {
        paramE = Synchronized.navigableSet(delegate().headSet(paramE, paramBoolean), this.mutex);
        return paramE;
      }
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return headSet(paramE, false);
    }
    
    public E higher(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = delegate().higher(paramE);
        return paramE;
      }
    }
    
    public E lower(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = delegate().lower(paramE);
        return paramE;
      }
    }
    
    public E pollFirst()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().pollFirst();
        return (E)localObject2;
      }
    }
    
    public E pollLast()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().pollLast();
        return (E)localObject2;
      }
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      synchronized (this.mutex)
      {
        paramE1 = Synchronized.navigableSet(delegate().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2), this.mutex);
        return paramE1;
      }
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return subSet(paramE1, true, paramE2, false);
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      synchronized (this.mutex)
      {
        paramE = Synchronized.navigableSet(delegate().tailSet(paramE, paramBoolean), this.mutex);
        return paramE;
      }
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return tailSet(paramE, true);
    }
  }
  
  static class SynchronizedObject
    implements Serializable
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    final Object delegate;
    final Object mutex;
    
    SynchronizedObject(Object paramObject1, @Nullable Object paramObject2)
    {
      this.delegate = Preconditions.checkNotNull(paramObject1);
      paramObject1 = paramObject2;
      if (paramObject2 == null) {
        paramObject1 = this;
      }
      this.mutex = paramObject1;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      synchronized (this.mutex)
      {
        paramObjectOutputStream.defaultWriteObject();
        return;
      }
    }
    
    Object delegate()
    {
      return this.delegate;
    }
    
    public String toString()
    {
      synchronized (this.mutex)
      {
        String str = this.delegate.toString();
        return str;
      }
    }
  }
  
  private static class SynchronizedQueue<E>
    extends Synchronized.SynchronizedCollection<E>
    implements Queue<E>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedQueue(Queue<E> paramQueue, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    Queue<E> delegate()
    {
      return (Queue)super.delegate();
    }
    
    public E element()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().element();
        return (E)localObject2;
      }
    }
    
    public boolean offer(E paramE)
    {
      synchronized (this.mutex)
      {
        boolean bool = delegate().offer(paramE);
        return bool;
      }
    }
    
    public E peek()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().peek();
        return (E)localObject2;
      }
    }
    
    public E poll()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().poll();
        return (E)localObject2;
      }
    }
    
    public E remove()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().remove();
        return (E)localObject2;
      }
    }
  }
  
  private static class SynchronizedRandomAccessList<E>
    extends Synchronized.SynchronizedList<E>
    implements RandomAccess
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedRandomAccessList(List<E> paramList, @Nullable Object paramObject)
    {
      super(paramObject);
    }
  }
  
  static class SynchronizedSet<E>
    extends Synchronized.SynchronizedCollection<E>
    implements Set<E>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSet(Set<E> paramSet, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    Set<E> delegate()
    {
      return (Set)super.delegate();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      synchronized (this.mutex)
      {
        boolean bool = delegate().equals(paramObject);
        return bool;
      }
    }
    
    public int hashCode()
    {
      synchronized (this.mutex)
      {
        int i = delegate().hashCode();
        return i;
      }
    }
  }
  
  private static class SynchronizedSetMultimap<K, V>
    extends Synchronized.SynchronizedMultimap<K, V>
    implements SetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, V>> entrySet;
    
    SynchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    SetMultimap<K, V> delegate()
    {
      return (SetMultimap)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      synchronized (this.mutex)
      {
        if (this.entrySet == null) {
          this.entrySet = Synchronized.set(delegate().entries(), this.mutex);
        }
        Set localSet = this.entrySet;
        return localSet;
      }
    }
    
    public Set<V> get(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.set(delegate().get(paramK), this.mutex);
        return paramK;
      }
    }
    
    public Set<V> removeAll(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().removeAll(paramObject);
        return (Set<V>)paramObject;
      }
    }
    
    public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().replaceValues(paramK, paramIterable);
        return paramK;
      }
    }
  }
  
  static class SynchronizedSortedMap<K, V>
    extends Synchronized.SynchronizedMap<K, V>
    implements SortedMap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public Comparator<? super K> comparator()
    {
      synchronized (this.mutex)
      {
        Comparator localComparator = delegate().comparator();
        return localComparator;
      }
    }
    
    SortedMap<K, V> delegate()
    {
      return (SortedMap)super.delegate();
    }
    
    public K firstKey()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().firstKey();
        return (K)localObject2;
      }
    }
    
    public SortedMap<K, V> headMap(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.sortedMap(delegate().headMap(paramK), this.mutex);
        return paramK;
      }
    }
    
    public K lastKey()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().lastKey();
        return (K)localObject2;
      }
    }
    
    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      synchronized (this.mutex)
      {
        paramK1 = Synchronized.sortedMap(delegate().subMap(paramK1, paramK2), this.mutex);
        return paramK1;
      }
    }
    
    public SortedMap<K, V> tailMap(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.sortedMap(delegate().tailMap(paramK), this.mutex);
        return paramK;
      }
    }
  }
  
  static class SynchronizedSortedSet<E>
    extends Synchronized.SynchronizedSet<E>
    implements SortedSet<E>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public Comparator<? super E> comparator()
    {
      synchronized (this.mutex)
      {
        Comparator localComparator = delegate().comparator();
        return localComparator;
      }
    }
    
    SortedSet<E> delegate()
    {
      return (SortedSet)super.delegate();
    }
    
    public E first()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().first();
        return (E)localObject2;
      }
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = Synchronized.sortedSet(delegate().headSet(paramE), this.mutex);
        return paramE;
      }
    }
    
    public E last()
    {
      synchronized (this.mutex)
      {
        Object localObject2 = delegate().last();
        return (E)localObject2;
      }
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      synchronized (this.mutex)
      {
        paramE1 = Synchronized.sortedSet(delegate().subSet(paramE1, paramE2), this.mutex);
        return paramE1;
      }
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      synchronized (this.mutex)
      {
        paramE = Synchronized.sortedSet(delegate().tailSet(paramE), this.mutex);
        return paramE;
      }
    }
  }
  
  private static class SynchronizedSortedSetMultimap<K, V>
    extends Synchronized.SynchronizedSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    SortedSetMultimap<K, V> delegate()
    {
      return (SortedSetMultimap)super.delegate();
    }
    
    public SortedSet<V> get(K paramK)
    {
      synchronized (this.mutex)
      {
        paramK = Synchronized.sortedSet(delegate().get(paramK), this.mutex);
        return paramK;
      }
    }
    
    public SortedSet<V> removeAll(Object paramObject)
    {
      synchronized (this.mutex)
      {
        paramObject = delegate().removeAll(paramObject);
        return (SortedSet<V>)paramObject;
      }
    }
    
    public SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      synchronized (this.mutex)
      {
        paramK = delegate().replaceValues(paramK, paramIterable);
        return paramK;
      }
    }
    
    public Comparator<? super V> valueComparator()
    {
      synchronized (this.mutex)
      {
        Comparator localComparator = delegate().valueComparator();
        return localComparator;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Synchronized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */