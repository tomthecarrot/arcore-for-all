package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public final class ArrayTable<R, C, V>
  extends AbstractTable<R, C, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final V[][] array;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final ImmutableList<C> columnList;
  private transient ArrayTable<R, C, V>.ColumnMap columnMap;
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableList<R> rowList;
  private transient ArrayTable<R, C, V>.RowMap rowMap;
  
  private ArrayTable(ArrayTable<R, C, V> paramArrayTable)
  {
    this.rowList = paramArrayTable.rowList;
    this.columnList = paramArrayTable.columnList;
    this.rowKeyToIndex = paramArrayTable.rowKeyToIndex;
    this.columnKeyToIndex = paramArrayTable.columnKeyToIndex;
    Object[][] arrayOfObject = (Object[][])Array.newInstance(Object.class, new int[] { this.rowList.size(), this.columnList.size() });
    this.array = arrayOfObject;
    eraseAll();
    int i = 0;
    while (i < this.rowList.size())
    {
      System.arraycopy(paramArrayTable.array[i], 0, arrayOfObject[i], 0, paramArrayTable.array[i].length);
      i += 1;
    }
  }
  
  private ArrayTable(Table<R, C, V> paramTable)
  {
    this(paramTable.rowKeySet(), paramTable.columnKeySet());
    putAll(paramTable);
  }
  
  private ArrayTable(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1)
  {
    this.rowList = ImmutableList.copyOf(paramIterable);
    this.columnList = ImmutableList.copyOf(paramIterable1);
    if (!this.rowList.isEmpty())
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (this.columnList.isEmpty()) {
        break label126;
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.rowKeyToIndex = Maps.indexMap(this.rowList);
      this.columnKeyToIndex = Maps.indexMap(this.columnList);
      this.array = ((Object[][])Array.newInstance(Object.class, new int[] { this.rowList.size(), this.columnList.size() }));
      eraseAll();
      return;
      bool1 = false;
      break;
    }
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> paramTable)
  {
    if ((paramTable instanceof ArrayTable)) {
      return new ArrayTable((ArrayTable)paramTable);
    }
    return new ArrayTable(paramTable);
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1)
  {
    return new ArrayTable(paramIterable, paramIterable1);
  }
  
  public V at(int paramInt1, int paramInt2)
  {
    Preconditions.checkElementIndex(paramInt1, this.rowList.size());
    Preconditions.checkElementIndex(paramInt2, this.columnList.size());
    return (V)this.array[paramInt1][paramInt2];
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator()
  {
    new AbstractIndexedListIterator(size())
    {
      protected Table.Cell<R, C, V> get(final int paramAnonymousInt)
      {
        new Tables.AbstractCell()
        {
          final int columnIndex = paramAnonymousInt % ArrayTable.this.columnList.size();
          final int rowIndex = paramAnonymousInt / ArrayTable.this.columnList.size();
          
          public C getColumnKey()
          {
            return (C)ArrayTable.this.columnList.get(this.columnIndex);
          }
          
          public R getRowKey()
          {
            return (R)ArrayTable.this.rowList.get(this.rowIndex);
          }
          
          public V getValue()
          {
            return (V)ArrayTable.this.at(this.rowIndex, this.columnIndex);
          }
        };
      }
    };
  }
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<R, V> column(C paramC)
  {
    Preconditions.checkNotNull(paramC);
    paramC = (Integer)this.columnKeyToIndex.get(paramC);
    if (paramC == null) {
      return ImmutableMap.of();
    }
    return new Column(paramC.intValue());
  }
  
  public ImmutableList<C> columnKeyList()
  {
    return this.columnList;
  }
  
  public ImmutableSet<C> columnKeySet()
  {
    return this.columnKeyToIndex.keySet();
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
    return (containsRow(paramObject1)) && (containsColumn(paramObject2));
  }
  
  public boolean containsColumn(@Nullable Object paramObject)
  {
    return this.columnKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject)
  {
    return this.rowKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Object[][] arrayOfObject = this.array;
    int k = arrayOfObject.length;
    int i = 0;
    while (i < k)
    {
      Object[] arrayOfObject1 = arrayOfObject[i];
      int m = arrayOfObject1.length;
      int j = 0;
      while (j < m)
      {
        if (Objects.equal(paramObject, arrayOfObject1[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public V erase(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    return (V)set(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), null);
  }
  
  public void eraseAll()
  {
    Object[][] arrayOfObject = this.array;
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Arrays.fill(arrayOfObject[i], null);
      i += 1;
    }
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    return (V)at(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue());
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public V put(R paramR, C paramC, @Nullable V paramV)
  {
    Preconditions.checkNotNull(paramR);
    Preconditions.checkNotNull(paramC);
    Integer localInteger = (Integer)this.rowKeyToIndex.get(paramR);
    if (localInteger != null)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Row %s not in %s", new Object[] { paramR, this.rowList });
      paramR = (Integer)this.columnKeyToIndex.get(paramC);
      if (paramR == null) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Column %s not in %s", new Object[] { paramC, this.columnList });
      return (V)set(localInteger.intValue(), paramR.intValue(), paramV);
      bool = false;
      break;
    }
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    super.putAll(paramTable);
  }
  
  @Deprecated
  public V remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<C, V> row(R paramR)
  {
    Preconditions.checkNotNull(paramR);
    paramR = (Integer)this.rowKeyToIndex.get(paramR);
    if (paramR == null) {
      return ImmutableMap.of();
    }
    return new Row(paramR.intValue());
  }
  
  public ImmutableList<R> rowKeyList()
  {
    return this.rowList;
  }
  
  public ImmutableSet<R> rowKeySet()
  {
    return this.rowKeyToIndex.keySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    RowMap localRowMap2 = this.rowMap;
    RowMap localRowMap1 = localRowMap2;
    if (localRowMap2 == null)
    {
      localRowMap1 = new RowMap(null);
      this.rowMap = localRowMap1;
    }
    return localRowMap1;
  }
  
  public V set(int paramInt1, int paramInt2, @Nullable V paramV)
  {
    Preconditions.checkElementIndex(paramInt1, this.rowList.size());
    Preconditions.checkElementIndex(paramInt2, this.columnList.size());
    Object localObject = this.array[paramInt1][paramInt2];
    this.array[paramInt1][paramInt2] = paramV;
    return (V)localObject;
  }
  
  public int size()
  {
    return this.rowList.size() * this.columnList.size();
  }
  
  @GwtIncompatible("reflection")
  public V[][] toArray(Class<V> paramClass)
  {
    paramClass = (Object[][])Array.newInstance(paramClass, new int[] { this.rowList.size(), this.columnList.size() });
    int i = 0;
    while (i < this.rowList.size())
    {
      System.arraycopy(this.array[i], 0, paramClass[i], 0, this.array[i].length);
      i += 1;
    }
    return paramClass;
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  private static abstract class ArrayMap<K, V>
    extends Maps.IteratorBasedAbstractMap<K, V>
  {
    private final ImmutableMap<K, Integer> keyIndex;
    
    private ArrayMap(ImmutableMap<K, Integer> paramImmutableMap)
    {
      this.keyIndex = paramImmutableMap;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return this.keyIndex.containsKey(paramObject);
    }
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      new AbstractIndexedListIterator(size())
      {
        protected Map.Entry<K, V> get(final int paramAnonymousInt)
        {
          new AbstractMapEntry()
          {
            public K getKey()
            {
              return (K)ArrayTable.ArrayMap.this.getKey(paramAnonymousInt);
            }
            
            public V getValue()
            {
              return (V)ArrayTable.ArrayMap.this.getValue(paramAnonymousInt);
            }
            
            public V setValue(V paramAnonymous2V)
            {
              return (V)ArrayTable.ArrayMap.this.setValue(paramAnonymousInt, paramAnonymous2V);
            }
          };
        }
      };
    }
    
    public V get(@Nullable Object paramObject)
    {
      paramObject = (Integer)this.keyIndex.get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return (V)getValue(((Integer)paramObject).intValue());
    }
    
    K getKey(int paramInt)
    {
      return (K)this.keyIndex.keySet().asList().get(paramInt);
    }
    
    abstract String getKeyRole();
    
    @Nullable
    abstract V getValue(int paramInt);
    
    public boolean isEmpty()
    {
      return this.keyIndex.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return this.keyIndex.keySet();
    }
    
    public V put(K paramK, V paramV)
    {
      Integer localInteger = (Integer)this.keyIndex.get(paramK);
      if (localInteger == null) {
        throw new IllegalArgumentException(getKeyRole() + " " + paramK + " not in " + this.keyIndex.keySet());
      }
      return (V)setValue(localInteger.intValue(), paramV);
    }
    
    public V remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    @Nullable
    abstract V setValue(int paramInt, V paramV);
    
    public int size()
    {
      return this.keyIndex.size();
    }
  }
  
  private class Column
    extends ArrayTable.ArrayMap<R, V>
  {
    final int columnIndex;
    
    Column(int paramInt)
    {
      super(null);
      this.columnIndex = paramInt;
    }
    
    String getKeyRole()
    {
      return "Row";
    }
    
    V getValue(int paramInt)
    {
      return (V)ArrayTable.this.at(paramInt, this.columnIndex);
    }
    
    V setValue(int paramInt, V paramV)
    {
      return (V)ArrayTable.this.set(paramInt, this.columnIndex, paramV);
    }
  }
  
  private class ColumnMap
    extends ArrayTable.ArrayMap<C, Map<R, V>>
  {
    private ColumnMap()
    {
      super(null);
    }
    
    String getKeyRole()
    {
      return "Column";
    }
    
    Map<R, V> getValue(int paramInt)
    {
      return new ArrayTable.Column(ArrayTable.this, paramInt);
    }
    
    public Map<R, V> put(C paramC, Map<R, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    Map<R, V> setValue(int paramInt, Map<R, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class Row
    extends ArrayTable.ArrayMap<C, V>
  {
    final int rowIndex;
    
    Row(int paramInt)
    {
      super(null);
      this.rowIndex = paramInt;
    }
    
    String getKeyRole()
    {
      return "Column";
    }
    
    V getValue(int paramInt)
    {
      return (V)ArrayTable.this.at(this.rowIndex, paramInt);
    }
    
    V setValue(int paramInt, V paramV)
    {
      return (V)ArrayTable.this.set(this.rowIndex, paramInt, paramV);
    }
  }
  
  private class RowMap
    extends ArrayTable.ArrayMap<R, Map<C, V>>
  {
    private RowMap()
    {
      super(null);
    }
    
    String getKeyRole()
    {
      return "Row";
    }
    
    Map<C, V> getValue(int paramInt)
    {
      return new ArrayTable.Row(ArrayTable.this, paramInt);
    }
    
    public Map<C, V> put(R paramR, Map<C, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    Map<C, V> setValue(int paramInt, Map<C, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ArrayTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */