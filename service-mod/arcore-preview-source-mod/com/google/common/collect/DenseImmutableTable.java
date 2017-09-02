package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable<R, C, V>
  extends RegularImmutableTable<R, C, V>
{
  private final int[] columnCounts;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final ImmutableMap<C, Map<R, V>> columnMap;
  private final int[] iterationOrderColumn;
  private final int[] iterationOrderRow;
  private final int[] rowCounts;
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableMap<R, Map<C, V>> rowMap;
  private final V[][] values;
  
  DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    this.values = ((Object[][])Array.newInstance(Object.class, new int[] { paramImmutableSet.size(), paramImmutableSet1.size() }));
    this.rowKeyToIndex = Maps.indexMap(paramImmutableSet);
    this.columnKeyToIndex = Maps.indexMap(paramImmutableSet1);
    this.rowCounts = new int[this.rowKeyToIndex.size()];
    this.columnCounts = new int[this.columnKeyToIndex.size()];
    paramImmutableSet = new int[paramImmutableList.size()];
    paramImmutableSet1 = new int[paramImmutableList.size()];
    int i = 0;
    if (i < paramImmutableList.size())
    {
      Object localObject1 = (Table.Cell)paramImmutableList.get(i);
      Object localObject2 = ((Table.Cell)localObject1).getRowKey();
      Object localObject3 = ((Table.Cell)localObject1).getColumnKey();
      int j = ((Integer)this.rowKeyToIndex.get(localObject2)).intValue();
      int k = ((Integer)this.columnKeyToIndex.get(localObject3)).intValue();
      if (this.values[j][k] == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "duplicate key: (%s, %s)", new Object[] { localObject2, localObject3 });
        this.values[j][k] = ((Table.Cell)localObject1).getValue();
        localObject1 = this.rowCounts;
        localObject1[j] += 1;
        localObject1 = this.columnCounts;
        localObject1[k] += 1;
        paramImmutableSet[i] = j;
        paramImmutableSet1[i] = k;
        i += 1;
        break;
      }
    }
    this.iterationOrderRow = paramImmutableSet;
    this.iterationOrderColumn = paramImmutableSet1;
    this.rowMap = new RowMap(null);
    this.columnMap = new ColumnMap(null);
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return this.columnMap;
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    return (V)this.values[paramObject1.intValue()][paramObject2.intValue()];
  }
  
  Table.Cell<R, C, V> getCell(int paramInt)
  {
    int i = this.iterationOrderRow[paramInt];
    paramInt = this.iterationOrderColumn[paramInt];
    return cellOf(rowKeySet().asList().get(i), columnKeySet().asList().get(paramInt), this.values[i][paramInt]);
  }
  
  V getValue(int paramInt)
  {
    return (V)this.values[this.iterationOrderRow[paramInt]][this.iterationOrderColumn[paramInt]];
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return this.rowMap;
  }
  
  public int size()
  {
    return this.iterationOrderRow.length;
  }
  
  private final class Column
    extends DenseImmutableTable.ImmutableArrayMap<R, V>
  {
    private final int columnIndex;
    
    Column(int paramInt)
    {
      super();
      this.columnIndex = paramInt;
    }
    
    V getValue(int paramInt)
    {
      return (V)DenseImmutableTable.this.values[paramInt][this.columnIndex];
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
  
  private final class ColumnMap
    extends DenseImmutableTable.ImmutableArrayMap<C, Map<R, V>>
  {
    private ColumnMap()
    {
      super();
    }
    
    Map<R, V> getValue(int paramInt)
    {
      return new DenseImmutableTable.Column(DenseImmutableTable.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  private static abstract class ImmutableArrayMap<K, V>
    extends ImmutableMap.IteratorBasedImmutableMap<K, V>
  {
    private final int size;
    
    ImmutableArrayMap(int paramInt)
    {
      this.size = paramInt;
    }
    
    private boolean isFull()
    {
      return this.size == keyToIndex().size();
    }
    
    ImmutableSet<K> createKeySet()
    {
      if (isFull()) {
        return keyToIndex().keySet();
      }
      return super.createKeySet();
    }
    
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator()
    {
      new AbstractIterator()
      {
        private int index = -1;
        private final int maxIndex = DenseImmutableTable.ImmutableArrayMap.this.keyToIndex().size();
        
        protected Map.Entry<K, V> computeNext()
        {
          for (this.index += 1; this.index < this.maxIndex; this.index += 1)
          {
            Object localObject = DenseImmutableTable.ImmutableArrayMap.this.getValue(this.index);
            if (localObject != null) {
              return Maps.immutableEntry(DenseImmutableTable.ImmutableArrayMap.this.getKey(this.index), localObject);
            }
          }
          return (Map.Entry)endOfData();
        }
      };
    }
    
    public V get(@Nullable Object paramObject)
    {
      paramObject = (Integer)keyToIndex().get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return (V)getValue(((Integer)paramObject).intValue());
    }
    
    K getKey(int paramInt)
    {
      return (K)keyToIndex().keySet().asList().get(paramInt);
    }
    
    @Nullable
    abstract V getValue(int paramInt);
    
    abstract ImmutableMap<K, Integer> keyToIndex();
    
    public int size()
    {
      return this.size;
    }
  }
  
  private final class Row
    extends DenseImmutableTable.ImmutableArrayMap<C, V>
  {
    private final int rowIndex;
    
    Row(int paramInt)
    {
      super();
      this.rowIndex = paramInt;
    }
    
    V getValue(int paramInt)
    {
      return (V)DenseImmutableTable.this.values[this.rowIndex][paramInt];
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  private final class RowMap
    extends DenseImmutableTable.ImmutableArrayMap<R, Map<C, V>>
  {
    private RowMap()
    {
      super();
    }
    
    Map<C, V> getValue(int paramInt)
    {
      return new DenseImmutableTable.Row(DenseImmutableTable.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/DenseImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */