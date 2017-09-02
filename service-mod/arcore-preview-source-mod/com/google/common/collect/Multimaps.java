package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Multimaps
{
  @Beta
  public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> paramListMultimap)
  {
    return paramListMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> paramMultimap)
  {
    return paramMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> paramSetMultimap)
  {
    return paramSetMultimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> paramSortedSetMultimap)
  {
    return paramSortedSetMultimap.asMap();
  }
  
  static boolean equalsImpl(Multimap<?, ?> paramMultimap, @Nullable Object paramObject)
  {
    if (paramObject == paramMultimap) {
      return true;
    }
    if ((paramObject instanceof Multimap))
    {
      paramObject = (Multimap)paramObject;
      return paramMultimap.asMap().equals(((Multimap)paramObject).asMap());
    }
    return false;
  }
  
  @CheckReturnValue
  public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> paramMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    if ((paramMultimap instanceof SetMultimap)) {
      return filterEntries((SetMultimap)paramMultimap, paramPredicate);
    }
    if ((paramMultimap instanceof FilteredMultimap)) {
      return filterFiltered((FilteredMultimap)paramMultimap, paramPredicate);
    }
    return new FilteredEntryMultimap((Multimap)Preconditions.checkNotNull(paramMultimap), paramPredicate);
  }
  
  @CheckReturnValue
  public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> paramSetMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    if ((paramSetMultimap instanceof FilteredSetMultimap)) {
      return filterFiltered((FilteredSetMultimap)paramSetMultimap, paramPredicate);
    }
    return new FilteredEntrySetMultimap((SetMultimap)Preconditions.checkNotNull(paramSetMultimap), paramPredicate);
  }
  
  private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> paramFilteredMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    paramPredicate = Predicates.and(paramFilteredMultimap.entryPredicate(), paramPredicate);
    return new FilteredEntryMultimap(paramFilteredMultimap.unfiltered(), paramPredicate);
  }
  
  private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> paramFilteredSetMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    paramPredicate = Predicates.and(paramFilteredSetMultimap.entryPredicate(), paramPredicate);
    return new FilteredEntrySetMultimap(paramFilteredSetMultimap.unfiltered(), paramPredicate);
  }
  
  @CheckReturnValue
  public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> paramListMultimap, Predicate<? super K> paramPredicate)
  {
    if ((paramListMultimap instanceof FilteredKeyListMultimap))
    {
      paramListMultimap = (FilteredKeyListMultimap)paramListMultimap;
      return new FilteredKeyListMultimap(paramListMultimap.unfiltered(), Predicates.and(paramListMultimap.keyPredicate, paramPredicate));
    }
    return new FilteredKeyListMultimap(paramListMultimap, paramPredicate);
  }
  
  @CheckReturnValue
  public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> paramMultimap, Predicate<? super K> paramPredicate)
  {
    if ((paramMultimap instanceof SetMultimap)) {
      return filterKeys((SetMultimap)paramMultimap, paramPredicate);
    }
    if ((paramMultimap instanceof ListMultimap)) {
      return filterKeys((ListMultimap)paramMultimap, paramPredicate);
    }
    if ((paramMultimap instanceof FilteredKeyMultimap))
    {
      paramMultimap = (FilteredKeyMultimap)paramMultimap;
      return new FilteredKeyMultimap(paramMultimap.unfiltered, Predicates.and(paramMultimap.keyPredicate, paramPredicate));
    }
    if ((paramMultimap instanceof FilteredMultimap)) {
      return filterFiltered((FilteredMultimap)paramMultimap, Maps.keyPredicateOnEntries(paramPredicate));
    }
    return new FilteredKeyMultimap(paramMultimap, paramPredicate);
  }
  
  @CheckReturnValue
  public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> paramSetMultimap, Predicate<? super K> paramPredicate)
  {
    if ((paramSetMultimap instanceof FilteredKeySetMultimap))
    {
      paramSetMultimap = (FilteredKeySetMultimap)paramSetMultimap;
      return new FilteredKeySetMultimap(paramSetMultimap.unfiltered(), Predicates.and(paramSetMultimap.keyPredicate, paramPredicate));
    }
    if ((paramSetMultimap instanceof FilteredSetMultimap)) {
      return filterFiltered((FilteredSetMultimap)paramSetMultimap, Maps.keyPredicateOnEntries(paramPredicate));
    }
    return new FilteredKeySetMultimap(paramSetMultimap, paramPredicate);
  }
  
  @CheckReturnValue
  public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> paramMultimap, Predicate<? super V> paramPredicate)
  {
    return filterEntries(paramMultimap, Maps.valuePredicateOnEntries(paramPredicate));
  }
  
  @CheckReturnValue
  public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> paramSetMultimap, Predicate<? super V> paramPredicate)
  {
    return filterEntries(paramSetMultimap, Maps.valuePredicateOnEntries(paramPredicate));
  }
  
  public static <K, V> SetMultimap<K, V> forMap(Map<K, V> paramMap)
  {
    return new MapMultimap(paramMap);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> paramIterable, Function<? super V, K> paramFunction)
  {
    return index(paramIterable.iterator(), paramFunction);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> paramIterator, Function<? super V, K> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    ImmutableListMultimap.Builder localBuilder = ImmutableListMultimap.builder();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      Preconditions.checkNotNull(localObject, paramIterator);
      localBuilder.put(paramFunction.apply(localObject), localObject);
    }
    return localBuilder.build();
  }
  
  public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> paramMultimap, M paramM)
  {
    Preconditions.checkNotNull(paramM);
    paramMultimap = paramMultimap.entries().iterator();
    while (paramMultimap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMultimap.next();
      paramM.put(localEntry.getValue(), localEntry.getKey());
    }
    return paramM;
  }
  
  public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends List<V>> paramSupplier)
  {
    return new CustomListMultimap(paramMap, paramSupplier);
  }
  
  public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier)
  {
    return new CustomMultimap(paramMap, paramSupplier);
  }
  
  public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier)
  {
    return new CustomSetMultimap(paramMap, paramSupplier);
  }
  
  public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier)
  {
    return new CustomSortedSetMultimap(paramMap, paramSupplier);
  }
  
  public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> paramListMultimap)
  {
    return Synchronized.listMultimap(paramListMultimap, null);
  }
  
  public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> paramMultimap)
  {
    return Synchronized.multimap(paramMultimap, null);
  }
  
  public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap)
  {
    return Synchronized.setMultimap(paramSetMultimap, null);
  }
  
  public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap)
  {
    return Synchronized.sortedSetMultimap(paramSortedSetMultimap, null);
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    return new TransformedEntriesListMultimap(paramListMultimap, paramEntryTransformer);
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    return new TransformedEntriesMultimap(paramMultimap, paramEntryTransformer);
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> paramListMultimap, Function<? super V1, V2> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return transformEntries(paramListMultimap, Maps.asEntryTransformer(paramFunction));
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> paramMultimap, Function<? super V1, V2> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return transformEntries(paramMultimap, Maps.asEntryTransformer(paramFunction));
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection)
  {
    if ((paramCollection instanceof Set)) {
      return Maps.unmodifiableEntrySet((Set)paramCollection);
    }
    return new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(paramCollection));
  }
  
  @Deprecated
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> paramImmutableListMultimap)
  {
    return (ListMultimap)Preconditions.checkNotNull(paramImmutableListMultimap);
  }
  
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> paramListMultimap)
  {
    if (((paramListMultimap instanceof UnmodifiableListMultimap)) || ((paramListMultimap instanceof ImmutableListMultimap))) {
      return paramListMultimap;
    }
    return new UnmodifiableListMultimap(paramListMultimap);
  }
  
  @Deprecated
  public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> paramImmutableMultimap)
  {
    return (Multimap)Preconditions.checkNotNull(paramImmutableMultimap);
  }
  
  public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> paramMultimap)
  {
    if (((paramMultimap instanceof UnmodifiableMultimap)) || ((paramMultimap instanceof ImmutableMultimap))) {
      return paramMultimap;
    }
    return new UnmodifiableMultimap(paramMultimap);
  }
  
  @Deprecated
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> paramImmutableSetMultimap)
  {
    return (SetMultimap)Preconditions.checkNotNull(paramImmutableSetMultimap);
  }
  
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap)
  {
    if (((paramSetMultimap instanceof UnmodifiableSetMultimap)) || ((paramSetMultimap instanceof ImmutableSetMultimap))) {
      return paramSetMultimap;
    }
    return new UnmodifiableSetMultimap(paramSetMultimap);
  }
  
  public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap)
  {
    if ((paramSortedSetMultimap instanceof UnmodifiableSortedSetMultimap)) {
      return paramSortedSetMultimap;
    }
    return new UnmodifiableSortedSetMultimap(paramSortedSetMultimap);
  }
  
  private static <V> Collection<V> unmodifiableValueCollection(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return Collections.unmodifiableSortedSet((SortedSet)paramCollection);
    }
    if ((paramCollection instanceof Set)) {
      return Collections.unmodifiableSet((Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return Collections.unmodifiableList((List)paramCollection);
    }
    return Collections.unmodifiableCollection(paramCollection);
  }
  
  static final class AsMap<K, V>
    extends Maps.ViewCachingAbstractMap<K, Collection<V>>
  {
    @Weak
    private final Multimap<K, V> multimap;
    
    AsMap(Multimap<K, V> paramMultimap)
    {
      this.multimap = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    }
    
    public void clear()
    {
      this.multimap.clear();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.multimap.containsKey(paramObject);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> createEntrySet()
    {
      return new EntrySet();
    }
    
    public Collection<V> get(Object paramObject)
    {
      if (containsKey(paramObject)) {
        return this.multimap.get(paramObject);
      }
      return null;
    }
    
    public boolean isEmpty()
    {
      return this.multimap.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return this.multimap.keySet();
    }
    
    public Collection<V> remove(Object paramObject)
    {
      if (containsKey(paramObject)) {
        return this.multimap.removeAll(paramObject);
      }
      return null;
    }
    
    void removeValuesForKey(Object paramObject)
    {
      this.multimap.keySet().remove(paramObject);
    }
    
    public int size()
    {
      return this.multimap.keySet().size();
    }
    
    class EntrySet
      extends Maps.EntrySet<K, Collection<V>>
    {
      EntrySet() {}
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        Maps.asMapEntryIterator(Multimaps.AsMap.this.multimap.keySet(), new Function()
        {
          public Collection<V> apply(K paramAnonymousK)
          {
            return Multimaps.AsMap.this.multimap.get(paramAnonymousK);
          }
        });
      }
      
      Map<K, Collection<V>> map()
      {
        return Multimaps.AsMap.this;
      }
      
      public boolean remove(Object paramObject)
      {
        if (!contains(paramObject)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        Multimaps.AsMap.this.removeValuesForKey(((Map.Entry)paramObject).getKey());
        return true;
      }
    }
  }
  
  private static class CustomListMultimap<K, V>
    extends AbstractListMultimap<K, V>
  {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends List<V>> factory;
    
    CustomListMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends List<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.factory = ((Supplier)paramObjectInputStream.readObject());
      setMap((Map)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(this.factory);
      paramObjectOutputStream.writeObject(backingMap());
    }
    
    protected List<V> createCollection()
    {
      return (List)this.factory.get();
    }
  }
  
  private static class CustomMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V>
  {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends Collection<V>> factory;
    
    CustomMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.factory = ((Supplier)paramObjectInputStream.readObject());
      setMap((Map)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(this.factory);
      paramObjectOutputStream.writeObject(backingMap());
    }
    
    protected Collection<V> createCollection()
    {
      return (Collection)this.factory.get();
    }
  }
  
  private static class CustomSetMultimap<K, V>
    extends AbstractSetMultimap<K, V>
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends Set<V>> factory;
    
    CustomSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.factory = ((Supplier)paramObjectInputStream.readObject());
      setMap((Map)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(this.factory);
      paramObjectOutputStream.writeObject(backingMap());
    }
    
    protected Set<V> createCollection()
    {
      return (Set)this.factory.get();
    }
  }
  
  private static class CustomSortedSetMultimap<K, V>
    extends AbstractSortedSetMultimap<K, V>
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends SortedSet<V>> factory;
    transient Comparator<? super V> valueComparator;
    
    CustomSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      this.valueComparator = ((SortedSet)paramSupplier.get()).comparator();
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      this.factory = ((Supplier)paramObjectInputStream.readObject());
      this.valueComparator = ((SortedSet)this.factory.get()).comparator();
      setMap((Map)paramObjectInputStream.readObject());
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(this.factory);
      paramObjectOutputStream.writeObject(backingMap());
    }
    
    protected SortedSet<V> createCollection()
    {
      return (SortedSet)this.factory.get();
    }
    
    public Comparator<? super V> valueComparator()
    {
      return this.valueComparator;
    }
  }
  
  static abstract class Entries<K, V>
    extends AbstractCollection<Map.Entry<K, V>>
  {
    public void clear()
    {
      multimap().clear();
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return multimap().containsEntry(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
      }
      return false;
    }
    
    abstract Multimap<K, V> multimap();
    
    public boolean remove(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return multimap().remove(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
      }
      return false;
    }
    
    public int size()
    {
      return multimap().size();
    }
  }
  
  static class Keys<K, V>
    extends AbstractMultiset<K>
  {
    @Weak
    final Multimap<K, V> multimap;
    
    Keys(Multimap<K, V> paramMultimap)
    {
      this.multimap = paramMultimap;
    }
    
    public void clear()
    {
      this.multimap.clear();
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      return this.multimap.containsKey(paramObject);
    }
    
    public int count(@Nullable Object paramObject)
    {
      paramObject = (Collection)Maps.safeGet(this.multimap.asMap(), paramObject);
      if (paramObject == null) {
        return 0;
      }
      return ((Collection)paramObject).size();
    }
    
    Set<Multiset.Entry<K>> createEntrySet()
    {
      return new KeysEntrySet();
    }
    
    int distinctElements()
    {
      return this.multimap.asMap().size();
    }
    
    public Set<K> elementSet()
    {
      return this.multimap.keySet();
    }
    
    Iterator<Multiset.Entry<K>> entryIterator()
    {
      new TransformedIterator(this.multimap.asMap().entrySet().iterator())
      {
        Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> paramAnonymousEntry)
        {
          new Multisets.AbstractEntry()
          {
            public int getCount()
            {
              return ((Collection)paramAnonymousEntry.getValue()).size();
            }
            
            public K getElement()
            {
              return (K)paramAnonymousEntry.getKey();
            }
          };
        }
      };
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(this.multimap.entries().iterator());
    }
    
    public int remove(@Nullable Object paramObject, int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "occurrences");
      int i;
      if (paramInt == 0)
      {
        i = count(paramObject);
        return i;
      }
      paramObject = (Collection)Maps.safeGet(this.multimap.asMap(), paramObject);
      if (paramObject == null) {
        return 0;
      }
      int k = ((Collection)paramObject).size();
      if (paramInt >= k)
      {
        ((Collection)paramObject).clear();
        return k;
      }
      paramObject = ((Collection)paramObject).iterator();
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramInt) {
          break;
        }
        ((Iterator)paramObject).next();
        ((Iterator)paramObject).remove();
        j += 1;
      }
    }
    
    class KeysEntrySet
      extends Multisets.EntrySet<K>
    {
      KeysEntrySet() {}
      
      public boolean contains(@Nullable Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof Multiset.Entry))
        {
          paramObject = (Multiset.Entry)paramObject;
          Collection localCollection = (Collection)Multimaps.Keys.this.multimap.asMap().get(((Multiset.Entry)paramObject).getElement());
          bool1 = bool2;
          if (localCollection != null)
          {
            bool1 = bool2;
            if (localCollection.size() == ((Multiset.Entry)paramObject).getCount()) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      
      public boolean isEmpty()
      {
        return Multimaps.Keys.this.multimap.isEmpty();
      }
      
      public Iterator<Multiset.Entry<K>> iterator()
      {
        return Multimaps.Keys.this.entryIterator();
      }
      
      Multiset<K> multiset()
      {
        return Multimaps.Keys.this;
      }
      
      public boolean remove(@Nullable Object paramObject)
      {
        if ((paramObject instanceof Multiset.Entry))
        {
          paramObject = (Multiset.Entry)paramObject;
          Collection localCollection = (Collection)Multimaps.Keys.this.multimap.asMap().get(((Multiset.Entry)paramObject).getElement());
          if ((localCollection != null) && (localCollection.size() == ((Multiset.Entry)paramObject).getCount()))
          {
            localCollection.clear();
            return true;
          }
        }
        return false;
      }
      
      public int size()
      {
        return Multimaps.Keys.this.distinctElements();
      }
    }
  }
  
  private static class MapMultimap<K, V>
    extends AbstractMultimap<K, V>
    implements SetMultimap<K, V>, Serializable
  {
    private static final long serialVersionUID = 7845222491160860175L;
    final Map<K, V> map;
    
    MapMultimap(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }
    
    public void clear()
    {
      this.map.clear();
    }
    
    public boolean containsEntry(Object paramObject1, Object paramObject2)
    {
      return this.map.entrySet().contains(Maps.immutableEntry(paramObject1, paramObject2));
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.map.containsKey(paramObject);
    }
    
    public boolean containsValue(Object paramObject)
    {
      return this.map.containsValue(paramObject);
    }
    
    Map<K, Collection<V>> createAsMap()
    {
      return new Multimaps.AsMap(this);
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      return this.map.entrySet();
    }
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return this.map.entrySet().iterator();
    }
    
    public Set<V> get(final K paramK)
    {
      new Sets.ImprovedAbstractSet()
      {
        public Iterator<V> iterator()
        {
          new Iterator()
          {
            int i;
            
            public boolean hasNext()
            {
              return (this.i == 0) && (Multimaps.MapMultimap.this.map.containsKey(Multimaps.MapMultimap.1.this.val$key));
            }
            
            public V next()
            {
              if (!hasNext()) {
                throw new NoSuchElementException();
              }
              this.i += 1;
              return (V)Multimaps.MapMultimap.this.map.get(Multimaps.MapMultimap.1.this.val$key);
            }
            
            public void remove()
            {
              boolean bool = true;
              if (this.i == 1) {}
              for (;;)
              {
                CollectPreconditions.checkRemove(bool);
                this.i = -1;
                Multimaps.MapMultimap.this.map.remove(Multimaps.MapMultimap.1.this.val$key);
                return;
                bool = false;
              }
            }
          };
        }
        
        public int size()
        {
          if (Multimaps.MapMultimap.this.map.containsKey(paramK)) {
            return 1;
          }
          return 0;
        }
      };
    }
    
    public int hashCode()
    {
      return this.map.hashCode();
    }
    
    public Set<K> keySet()
    {
      return this.map.keySet();
    }
    
    public boolean put(K paramK, V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object paramObject1, Object paramObject2)
    {
      return this.map.entrySet().remove(Maps.immutableEntry(paramObject1, paramObject2));
    }
    
    public Set<V> removeAll(Object paramObject)
    {
      HashSet localHashSet = new HashSet(2);
      if (!this.map.containsKey(paramObject)) {
        return localHashSet;
      }
      localHashSet.add(this.map.remove(paramObject));
      return localHashSet;
    }
    
    public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return this.map.size();
    }
    
    public Collection<V> values()
    {
      return this.map.values();
    }
  }
  
  private static final class TransformedEntriesListMultimap<K, V1, V2>
    extends Multimaps.TransformedEntriesMultimap<K, V1, V2>
    implements ListMultimap<K, V2>
  {
    TransformedEntriesListMultimap(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      super(paramEntryTransformer);
    }
    
    public List<V2> get(K paramK)
    {
      return transform(paramK, this.fromMultimap.get(paramK));
    }
    
    public List<V2> removeAll(Object paramObject)
    {
      return transform(paramObject, this.fromMultimap.removeAll(paramObject));
    }
    
    public List<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    List<V2> transform(K paramK, Collection<V1> paramCollection)
    {
      return Lists.transform((List)paramCollection, Maps.asValueToValueFunction(this.transformer, paramK));
    }
  }
  
  private static class TransformedEntriesMultimap<K, V1, V2>
    extends AbstractMultimap<K, V2>
  {
    final Multimap<K, V1> fromMultimap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    TransformedEntriesMultimap(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      this.fromMultimap = ((Multimap)Preconditions.checkNotNull(paramMultimap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
    }
    
    public void clear()
    {
      this.fromMultimap.clear();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.fromMultimap.containsKey(paramObject);
    }
    
    Map<K, Collection<V2>> createAsMap()
    {
      Maps.transformEntries(this.fromMultimap.asMap(), new Maps.EntryTransformer()
      {
        public Collection<V2> transformEntry(K paramAnonymousK, Collection<V1> paramAnonymousCollection)
        {
          return Multimaps.TransformedEntriesMultimap.this.transform(paramAnonymousK, paramAnonymousCollection);
        }
      });
    }
    
    Collection<V2> createValues()
    {
      return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
    }
    
    Iterator<Map.Entry<K, V2>> entryIterator()
    {
      return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }
    
    public Collection<V2> get(K paramK)
    {
      return transform(paramK, this.fromMultimap.get(paramK));
    }
    
    public boolean isEmpty()
    {
      return this.fromMultimap.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return this.fromMultimap.keySet();
    }
    
    public Multiset<K> keys()
    {
      return this.fromMultimap.keys();
    }
    
    public boolean put(K paramK, V2 paramV2)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V2> paramMultimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K paramK, Iterable<? extends V2> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object paramObject1, Object paramObject2)
    {
      return get(paramObject1).remove(paramObject2);
    }
    
    public Collection<V2> removeAll(Object paramObject)
    {
      return transform(paramObject, this.fromMultimap.removeAll(paramObject));
    }
    
    public Collection<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return this.fromMultimap.size();
    }
    
    Collection<V2> transform(K paramK, Collection<V1> paramCollection)
    {
      paramK = Maps.asValueToValueFunction(this.transformer, paramK);
      if ((paramCollection instanceof List)) {
        return Lists.transform((List)paramCollection, paramK);
      }
      return Collections2.transform(paramCollection, paramK);
    }
  }
  
  private static class UnmodifiableListMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements ListMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableListMultimap(ListMultimap<K, V> paramListMultimap)
    {
      super();
    }
    
    public ListMultimap<K, V> delegate()
    {
      return (ListMultimap)super.delegate();
    }
    
    public List<V> get(K paramK)
    {
      return Collections.unmodifiableList(delegate().get(paramK));
    }
    
    public List<V> removeAll(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient Multiset<K> keys;
    transient Map<K, Collection<V>> map;
    transient Collection<V> values;
    
    UnmodifiableMultimap(Multimap<K, V> paramMultimap)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    }
    
    public Map<K, Collection<V>> asMap()
    {
      Map localMap2 = this.map;
      Map localMap1 = localMap2;
      if (localMap2 == null)
      {
        localMap1 = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new Function()
        {
          public Collection<V> apply(Collection<V> paramAnonymousCollection)
          {
            return Multimaps.unmodifiableValueCollection(paramAnonymousCollection);
          }
        }));
        this.map = localMap1;
      }
      return localMap1;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
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
        localCollection1 = Multimaps.unmodifiableEntries(this.delegate.entries());
        this.entries = localCollection1;
      }
      return localCollection1;
    }
    
    public Collection<V> get(K paramK)
    {
      return Multimaps.unmodifiableValueCollection(this.delegate.get(paramK));
    }
    
    public Set<K> keySet()
    {
      Set localSet2 = this.keySet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = Collections.unmodifiableSet(this.delegate.keySet());
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
        localMultiset1 = Multisets.unmodifiableMultiset(this.delegate.keys());
        this.keys = localMultiset1;
      }
      return localMultiset1;
    }
    
    public boolean put(K paramK, V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object paramObject1, Object paramObject2)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> removeAll(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> values()
    {
      Collection localCollection2 = this.values;
      Collection localCollection1 = localCollection2;
      if (localCollection2 == null)
      {
        localCollection1 = Collections.unmodifiableCollection(this.delegate.values());
        this.values = localCollection1;
      }
      return localCollection1;
    }
  }
  
  private static class UnmodifiableSetMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements SetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap)
    {
      super();
    }
    
    public SetMultimap<K, V> delegate()
    {
      return (SetMultimap)super.delegate();
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      return Maps.unmodifiableEntrySet(delegate().entries());
    }
    
    public Set<V> get(K paramK)
    {
      return Collections.unmodifiableSet(delegate().get(paramK));
    }
    
    public Set<V> removeAll(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableSortedSetMultimap<K, V>
    extends Multimaps.UnmodifiableSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap)
    {
      super();
    }
    
    public SortedSetMultimap<K, V> delegate()
    {
      return (SortedSetMultimap)super.delegate();
    }
    
    public SortedSet<V> get(K paramK)
    {
      return Collections.unmodifiableSortedSet(delegate().get(paramK));
    }
    
    public SortedSet<V> removeAll(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      throw new UnsupportedOperationException();
    }
    
    public Comparator<? super V> valueComparator()
    {
      return delegate().valueComparator();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/Multimaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */