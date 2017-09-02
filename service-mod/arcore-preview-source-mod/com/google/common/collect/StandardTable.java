package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable<R, C, V>
  extends AbstractTable<R, C, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  @GwtTransient
  final Map<R, Map<C, V>> backingMap;
  private transient Set<C> columnKeySet;
  private transient StandardTable<R, C, V>.ColumnMap columnMap;
  @GwtTransient
  final Supplier<? extends Map<C, V>> factory;
  private transient Map<R, Map<C, V>> rowMap;
  
  StandardTable(Map<R, Map<C, V>> paramMap, Supplier<? extends Map<C, V>> paramSupplier)
  {
    this.backingMap = paramMap;
    this.factory = paramSupplier;
  }
  
  private boolean containsMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return (paramObject3 != null) && (paramObject3.equals(get(paramObject1, paramObject2)));
  }
  
  private Map<C, V> getOrCreate(R paramR)
  {
    Map localMap2 = (Map)this.backingMap.get(paramR);
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = (Map)this.factory.get();
      this.backingMap.put(paramR, localMap1);
    }
    return localMap1;
  }
  
  private Map<R, V> removeColumn(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.backingMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = ((Map)localEntry.getValue()).remove(paramObject);
      if (localObject != null)
      {
        localLinkedHashMap.put(localEntry.getKey(), localObject);
        if (((Map)localEntry.getValue()).isEmpty()) {
          localIterator.remove();
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (containsMapping(paramObject1, paramObject2, paramObject3))
    {
      remove(paramObject1, paramObject2);
      return true;
    }
    return false;
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator()
  {
    return new CellIterator(null);
  }
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  public void clear()
  {
    this.backingMap.clear();
  }
  
  public Map<R, V> column(C paramC)
  {
    return new Column(paramC);
  }
  
  public Set<C> columnKeySet()
  {
    Set localSet = this.columnKeySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ColumnKeySet(null);
      this.columnKeySet = ((Set)localObject);
    }
    return (Set<C>)localObject;
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    ColumnMap localColumnMap2 = this.columnMap;
    ColumnMap localColumnMap1 = localColumnMap2;
    if (localColumnMap2 == null)
    {
      localColumnMap1 = new ColumnMap(null);
      this.columnMap = localColumnMap1;
    }
    return localColumnMap1;
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return (paramObject1 != null) && (paramObject2 != null) && (super.contains(paramObject1, paramObject2));
  }
  
  public boolean containsColumn(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = this.backingMap.values().iterator();
      }
    } while (!Maps.safeContainsKey((Map)localIterator.next(), paramObject));
    return true;
  }
  
  public boolean containsRow(@Nullable Object paramObject)
  {
    return (paramObject != null) && (Maps.safeContainsKey(this.backingMap, paramObject));
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return (paramObject != null) && (super.containsValue(paramObject));
  }
  
  Iterator<C> createColumnKeyIterator()
  {
    return new ColumnKeyIterator(null);
  }
  
  Map<R, Map<C, V>> createRowMap()
  {
    return new RowMap();
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    return (V)super.get(paramObject1, paramObject2);
  }
  
  public boolean isEmpty()
  {
    return this.backingMap.isEmpty();
  }
  
  public V put(R paramR, C paramC, V paramV)
  {
    Preconditions.checkNotNull(paramR);
    Preconditions.checkNotNull(paramC);
    Preconditions.checkNotNull(paramV);
    return (V)getOrCreate(paramR).put(paramC, paramV);
  }
  
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject1 != null)
    {
      if (paramObject2 != null) {
        break label19;
      }
      localObject1 = localObject2;
    }
    label19:
    Map localMap;
    do
    {
      do
      {
        return (V)localObject1;
        localMap = (Map)Maps.safeGet(this.backingMap, paramObject1);
        localObject1 = localObject2;
      } while (localMap == null);
      paramObject2 = localMap.remove(paramObject2);
      localObject1 = paramObject2;
    } while (!localMap.isEmpty());
    this.backingMap.remove(paramObject1);
    return (V)paramObject2;
  }
  
  public Map<C, V> row(R paramR)
  {
    return new Row(paramR);
  }
  
  public Set<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    Map localMap2 = this.rowMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createRowMap();
      this.rowMap = localMap1;
    }
    return localMap1;
  }
  
  public int size()
  {
    int i = 0;
    Iterator localIterator = this.backingMap.values().iterator();
    while (localIterator.hasNext()) {
      i += ((Map)localIterator.next()).size();
    }
    return i;
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  private class CellIterator
    implements Iterator<Table.Cell<R, C, V>>
  {
    Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
    Map.Entry<R, Map<C, V>> rowEntry;
    final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = StandardTable.this.backingMap.entrySet().iterator();
    
    private CellIterator() {}
    
    public boolean hasNext()
    {
      return (this.rowIterator.hasNext()) || (this.columnIterator.hasNext());
    }
    
    public Table.Cell<R, C, V> next()
    {
      if (!this.columnIterator.hasNext())
      {
        this.rowEntry = ((Map.Entry)this.rowIterator.next());
        this.columnIterator = ((Map)this.rowEntry.getValue()).entrySet().iterator();
      }
      Map.Entry localEntry = (Map.Entry)this.columnIterator.next();
      return Tables.immutableCell(this.rowEntry.getKey(), localEntry.getKey(), localEntry.getValue());
    }
    
    public void remove()
    {
      this.columnIterator.remove();
      if (((Map)this.rowEntry.getValue()).isEmpty()) {
        this.rowIterator.remove();
      }
    }
  }
  
  private class Column
    extends Maps.ViewCachingAbstractMap<R, V>
  {
    final C columnKey;
    
    Column()
    {
      Object localObject;
      this.columnKey = Preconditions.checkNotNull(localObject);
    }
    
    public boolean containsKey(Object paramObject)
    {
      return StandardTable.this.contains(paramObject, this.columnKey);
    }
    
    Set<Map.Entry<R, V>> createEntrySet()
    {
      return new EntrySet(null);
    }
    
    Set<R> createKeySet()
    {
      return new KeySet();
    }
    
    Collection<V> createValues()
    {
      return new Values();
    }
    
    public V get(Object paramObject)
    {
      return (V)StandardTable.this.get(paramObject, this.columnKey);
    }
    
    public V put(R paramR, V paramV)
    {
      return (V)StandardTable.this.put(paramR, this.columnKey, paramV);
    }
    
    public V remove(Object paramObject)
    {
      return (V)StandardTable.this.remove(paramObject, this.columnKey);
    }
    
    boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> paramPredicate)
    {
      boolean bool1 = false;
      Iterator localIterator = StandardTable.this.backingMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Map localMap = (Map)localEntry.getValue();
        Object localObject = localMap.get(this.columnKey);
        if ((localObject != null) && (paramPredicate.apply(Maps.immutableEntry(localEntry.getKey(), localObject))))
        {
          localMap.remove(this.columnKey);
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    private class EntrySet
      extends Sets.ImprovedAbstractSet<Map.Entry<R, V>>
    {
      private EntrySet() {}
      
      public void clear()
      {
        StandardTable.Column.this.removeFromColumnIf(Predicates.alwaysTrue());
      }
      
      public boolean contains(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          return StandardTable.this.containsMapping(((Map.Entry)paramObject).getKey(), StandardTable.Column.this.columnKey, ((Map.Entry)paramObject).getValue());
        }
        return false;
      }
      
      public boolean isEmpty()
      {
        return !StandardTable.this.containsColumn(StandardTable.Column.this.columnKey);
      }
      
      public Iterator<Map.Entry<R, V>> iterator()
      {
        return new StandardTable.Column.EntrySetIterator(StandardTable.Column.this, null);
      }
      
      public boolean remove(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          return StandardTable.this.removeMapping(((Map.Entry)paramObject).getKey(), StandardTable.Column.this.columnKey, ((Map.Entry)paramObject).getValue());
        }
        return false;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return StandardTable.Column.this.removeFromColumnIf(Predicates.not(Predicates.in(paramCollection)));
      }
      
      public int size()
      {
        int i = 0;
        Iterator localIterator = StandardTable.this.backingMap.values().iterator();
        while (localIterator.hasNext()) {
          if (((Map)localIterator.next()).containsKey(StandardTable.Column.this.columnKey)) {
            i += 1;
          }
        }
        return i;
      }
    }
    
    private class EntrySetIterator
      extends AbstractIterator<Map.Entry<R, V>>
    {
      final Iterator<Map.Entry<R, Map<C, V>>> iterator = StandardTable.this.backingMap.entrySet().iterator();
      
      private EntrySetIterator() {}
      
      protected Map.Entry<R, V> computeNext()
      {
        while (this.iterator.hasNext())
        {
          final Map.Entry localEntry = (Map.Entry)this.iterator.next();
          if (((Map)localEntry.getValue()).containsKey(StandardTable.Column.this.columnKey)) {
            new AbstractMapEntry()
            {
              public R getKey()
              {
                return (R)localEntry.getKey();
              }
              
              public V getValue()
              {
                return (V)((Map)localEntry.getValue()).get(this.this$2.this$1.columnKey);
              }
              
              public V setValue(V paramAnonymousV)
              {
                return (V)((Map)localEntry.getValue()).put(this.this$2.this$1.columnKey, Preconditions.checkNotNull(paramAnonymousV));
              }
            };
          }
        }
        return (Map.Entry)endOfData();
      }
    }
    
    private class KeySet
      extends Maps.KeySet<R, V>
    {
      KeySet()
      {
        super();
      }
      
      public boolean contains(Object paramObject)
      {
        return StandardTable.this.contains(paramObject, StandardTable.Column.this.columnKey);
      }
      
      public boolean remove(Object paramObject)
      {
        return StandardTable.this.remove(paramObject, StandardTable.Column.this.columnKey) != null;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return StandardTable.Column.this.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(paramCollection))));
      }
    }
    
    private class Values
      extends Maps.Values<R, V>
    {
      Values()
      {
        super();
      }
      
      public boolean remove(Object paramObject)
      {
        return (paramObject != null) && (StandardTable.Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(paramObject))));
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        return StandardTable.Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(paramCollection)));
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return StandardTable.Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(paramCollection))));
      }
    }
  }
  
  private class ColumnKeyIterator
    extends AbstractIterator<C>
  {
    Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
    final Iterator<Map<C, V>> mapIterator = StandardTable.this.backingMap.values().iterator();
    final Map<C, V> seen = (Map)StandardTable.this.factory.get();
    
    private ColumnKeyIterator() {}
    
    protected C computeNext()
    {
      for (;;)
      {
        if (this.entryIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)this.entryIterator.next();
          if (!this.seen.containsKey(localEntry.getKey()))
          {
            this.seen.put(localEntry.getKey(), localEntry.getValue());
            return (C)localEntry.getKey();
          }
        }
        else
        {
          if (!this.mapIterator.hasNext()) {
            break;
          }
          this.entryIterator = ((Map)this.mapIterator.next()).entrySet().iterator();
        }
      }
      return (C)endOfData();
    }
  }
  
  private class ColumnKeySet
    extends StandardTable<R, C, V>.TableSet<C>
  {
    private ColumnKeySet()
    {
      super(null);
    }
    
    public boolean contains(Object paramObject)
    {
      return StandardTable.this.containsColumn(paramObject);
    }
    
    public Iterator<C> iterator()
    {
      return StandardTable.this.createColumnKeyIterator();
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool2;
      if (paramObject == null)
      {
        bool2 = false;
        return bool2;
      }
      boolean bool1 = false;
      Iterator localIterator = StandardTable.this.backingMap.values().iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        Map localMap = (Map)localIterator.next();
        if (localMap.keySet().remove(paramObject))
        {
          bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      Preconditions.checkNotNull(paramCollection);
      boolean bool1 = false;
      Iterator localIterator = StandardTable.this.backingMap.values().iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (Iterators.removeAll(localMap.keySet().iterator(), paramCollection))
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Preconditions.checkNotNull(paramCollection);
      boolean bool1 = false;
      Iterator localIterator = StandardTable.this.backingMap.values().iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (localMap.keySet().retainAll(paramCollection))
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public int size()
    {
      return Iterators.size(iterator());
    }
  }
  
  private class ColumnMap
    extends Maps.ViewCachingAbstractMap<C, Map<R, V>>
  {
    private ColumnMap() {}
    
    public boolean containsKey(Object paramObject)
    {
      return StandardTable.this.containsColumn(paramObject);
    }
    
    public Set<Map.Entry<C, Map<R, V>>> createEntrySet()
    {
      return new ColumnMapEntrySet();
    }
    
    Collection<Map<R, V>> createValues()
    {
      return new ColumnMapValues();
    }
    
    public Map<R, V> get(Object paramObject)
    {
      if (StandardTable.this.containsColumn(paramObject)) {
        return StandardTable.this.column(paramObject);
      }
      return null;
    }
    
    public Set<C> keySet()
    {
      return StandardTable.this.columnKeySet();
    }
    
    public Map<R, V> remove(Object paramObject)
    {
      if (StandardTable.this.containsColumn(paramObject)) {
        return StandardTable.this.removeColumn(paramObject);
      }
      return null;
    }
    
    class ColumnMapEntrySet
      extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
    {
      ColumnMapEntrySet()
      {
        super(null);
      }
      
      public boolean contains(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          if (StandardTable.this.containsColumn(((Map.Entry)paramObject).getKey()))
          {
            Object localObject = ((Map.Entry)paramObject).getKey();
            return StandardTable.ColumnMap.this.get(localObject).equals(((Map.Entry)paramObject).getValue());
          }
        }
        return false;
      }
      
      public Iterator<Map.Entry<C, Map<R, V>>> iterator()
      {
        Maps.asMapEntryIterator(StandardTable.this.columnKeySet(), new Function()
        {
          public Map<R, V> apply(C paramAnonymousC)
          {
            return StandardTable.this.column(paramAnonymousC);
          }
        });
      }
      
      public boolean remove(Object paramObject)
      {
        if (contains(paramObject))
        {
          paramObject = (Map.Entry)paramObject;
          StandardTable.this.removeColumn(((Map.Entry)paramObject).getKey());
          return true;
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        Preconditions.checkNotNull(paramCollection);
        return Sets.removeAllImpl(this, paramCollection.iterator());
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        Preconditions.checkNotNull(paramCollection);
        boolean bool = false;
        Iterator localIterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!paramCollection.contains(Maps.immutableEntry(localObject, StandardTable.this.column(localObject))))
          {
            StandardTable.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
      
      public int size()
      {
        return StandardTable.this.columnKeySet().size();
      }
    }
    
    private class ColumnMapValues
      extends Maps.Values<C, Map<R, V>>
    {
      ColumnMapValues()
      {
        super();
      }
      
      public boolean remove(Object paramObject)
      {
        Iterator localIterator = StandardTable.ColumnMap.this.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Map)localEntry.getValue()).equals(paramObject))
          {
            StandardTable.this.removeColumn(localEntry.getKey());
            return true;
          }
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        Preconditions.checkNotNull(paramCollection);
        boolean bool = false;
        Iterator localIterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (paramCollection.contains(StandardTable.this.column(localObject)))
          {
            StandardTable.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        Preconditions.checkNotNull(paramCollection);
        boolean bool = false;
        Iterator localIterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!paramCollection.contains(StandardTable.this.column(localObject)))
          {
            StandardTable.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
    }
  }
  
  class Row
    extends Maps.IteratorBasedAbstractMap<C, V>
  {
    Map<C, V> backingRowMap;
    final R rowKey;
    
    Row()
    {
      Object localObject;
      this.rowKey = Preconditions.checkNotNull(localObject);
    }
    
    Map<C, V> backingRowMap()
    {
      if ((this.backingRowMap == null) || ((this.backingRowMap.isEmpty()) && (StandardTable.this.backingMap.containsKey(this.rowKey))))
      {
        Map localMap = computeBackingRowMap();
        this.backingRowMap = localMap;
        return localMap;
      }
      return this.backingRowMap;
    }
    
    public void clear()
    {
      Map localMap = backingRowMap();
      if (localMap != null) {
        localMap.clear();
      }
      maintainEmptyInvariant();
    }
    
    Map<C, V> computeBackingRowMap()
    {
      return (Map)StandardTable.this.backingMap.get(this.rowKey);
    }
    
    public boolean containsKey(Object paramObject)
    {
      Map localMap = backingRowMap();
      return (paramObject != null) && (localMap != null) && (Maps.safeContainsKey(localMap, paramObject));
    }
    
    Iterator<Map.Entry<C, V>> entryIterator()
    {
      Map localMap = backingRowMap();
      if (localMap == null) {
        return Iterators.emptyModifiableIterator();
      }
      new Iterator()
      {
        public boolean hasNext()
        {
          return this.val$iterator.hasNext();
        }
        
        public Map.Entry<C, V> next()
        {
          new ForwardingMapEntry()
          {
            protected Map.Entry<C, V> delegate()
            {
              return this.val$entry;
            }
            
            public boolean equals(Object paramAnonymous2Object)
            {
              return standardEquals(paramAnonymous2Object);
            }
            
            public V setValue(V paramAnonymous2V)
            {
              return (V)super.setValue(Preconditions.checkNotNull(paramAnonymous2V));
            }
          };
        }
        
        public void remove()
        {
          this.val$iterator.remove();
          StandardTable.Row.this.maintainEmptyInvariant();
        }
      };
    }
    
    public V get(Object paramObject)
    {
      Map localMap = backingRowMap();
      if ((paramObject != null) && (localMap != null)) {
        return (V)Maps.safeGet(localMap, paramObject);
      }
      return null;
    }
    
    void maintainEmptyInvariant()
    {
      if ((backingRowMap() != null) && (this.backingRowMap.isEmpty()))
      {
        StandardTable.this.backingMap.remove(this.rowKey);
        this.backingRowMap = null;
      }
    }
    
    public V put(C paramC, V paramV)
    {
      Preconditions.checkNotNull(paramC);
      Preconditions.checkNotNull(paramV);
      if ((this.backingRowMap != null) && (!this.backingRowMap.isEmpty())) {
        return (V)this.backingRowMap.put(paramC, paramV);
      }
      return (V)StandardTable.this.put(this.rowKey, paramC, paramV);
    }
    
    public V remove(Object paramObject)
    {
      Map localMap = backingRowMap();
      if (localMap == null) {
        return null;
      }
      paramObject = Maps.safeRemove(localMap, paramObject);
      maintainEmptyInvariant();
      return (V)paramObject;
    }
    
    public int size()
    {
      Map localMap = backingRowMap();
      if (localMap == null) {
        return 0;
      }
      return localMap.size();
    }
  }
  
  class RowMap
    extends Maps.ViewCachingAbstractMap<R, Map<C, V>>
  {
    RowMap() {}
    
    public boolean containsKey(Object paramObject)
    {
      return StandardTable.this.containsRow(paramObject);
    }
    
    protected Set<Map.Entry<R, Map<C, V>>> createEntrySet()
    {
      return new EntrySet();
    }
    
    public Map<C, V> get(Object paramObject)
    {
      if (StandardTable.this.containsRow(paramObject)) {
        return StandardTable.this.row(paramObject);
      }
      return null;
    }
    
    public Map<C, V> remove(Object paramObject)
    {
      if (paramObject == null) {
        return null;
      }
      return (Map)StandardTable.this.backingMap.remove(paramObject);
    }
    
    class EntrySet
      extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
    {
      EntrySet()
      {
        super(null);
      }
      
      public boolean contains(Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          bool1 = bool2;
          if (((Map.Entry)paramObject).getKey() != null)
          {
            bool1 = bool2;
            if ((((Map.Entry)paramObject).getValue() instanceof Map))
            {
              bool1 = bool2;
              if (Collections2.safeContains(StandardTable.this.backingMap.entrySet(), paramObject)) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      
      public Iterator<Map.Entry<R, Map<C, V>>> iterator()
      {
        Maps.asMapEntryIterator(StandardTable.this.backingMap.keySet(), new Function()
        {
          public Map<C, V> apply(R paramAnonymousR)
          {
            return StandardTable.this.row(paramAnonymousR);
          }
        });
      }
      
      public boolean remove(Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          bool1 = bool2;
          if (((Map.Entry)paramObject).getKey() != null)
          {
            bool1 = bool2;
            if ((((Map.Entry)paramObject).getValue() instanceof Map))
            {
              bool1 = bool2;
              if (StandardTable.this.backingMap.entrySet().remove(paramObject)) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      
      public int size()
      {
        return StandardTable.this.backingMap.size();
      }
    }
  }
  
  private abstract class TableSet<T>
    extends Sets.ImprovedAbstractSet<T>
  {
    private TableSet() {}
    
    public void clear()
    {
      StandardTable.this.backingMap.clear();
    }
    
    public boolean isEmpty()
    {
      return StandardTable.this.backingMap.isEmpty();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/StandardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */