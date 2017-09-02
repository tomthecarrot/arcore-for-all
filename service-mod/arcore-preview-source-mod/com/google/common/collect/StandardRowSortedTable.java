package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable<R, C, V>
  extends StandardTable<R, C, V>
  implements RowSortedTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  StandardRowSortedTable(SortedMap<R, Map<C, V>> paramSortedMap, Supplier<? extends Map<C, V>> paramSupplier)
  {
    super(paramSortedMap, paramSupplier);
  }
  
  private SortedMap<R, Map<C, V>> sortedBackingMap()
  {
    return (SortedMap)this.backingMap;
  }
  
  SortedMap<R, Map<C, V>> createRowMap()
  {
    return new RowSortedMap(null);
  }
  
  public SortedSet<R> rowKeySet()
  {
    return (SortedSet)rowMap().keySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap()
  {
    return (SortedMap)super.rowMap();
  }
  
  private class RowSortedMap
    extends StandardTable<R, C, V>.RowMap
    implements SortedMap<R, Map<C, V>>
  {
    private RowSortedMap()
    {
      super();
    }
    
    public Comparator<? super R> comparator()
    {
      return StandardRowSortedTable.this.sortedBackingMap().comparator();
    }
    
    SortedSet<R> createKeySet()
    {
      return new Maps.SortedKeySet(this);
    }
    
    public R firstKey()
    {
      return (R)StandardRowSortedTable.this.sortedBackingMap().firstKey();
    }
    
    public SortedMap<R, Map<C, V>> headMap(R paramR)
    {
      Preconditions.checkNotNull(paramR);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(paramR), StandardRowSortedTable.this.factory).rowMap();
    }
    
    public SortedSet<R> keySet()
    {
      return (SortedSet)super.keySet();
    }
    
    public R lastKey()
    {
      return (R)StandardRowSortedTable.this.sortedBackingMap().lastKey();
    }
    
    public SortedMap<R, Map<C, V>> subMap(R paramR1, R paramR2)
    {
      Preconditions.checkNotNull(paramR1);
      Preconditions.checkNotNull(paramR2);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(paramR1, paramR2), StandardRowSortedTable.this.factory).rowMap();
    }
    
    public SortedMap<R, Map<C, V>> tailMap(R paramR)
    {
      Preconditions.checkNotNull(paramR);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(paramR), StandardRowSortedTable.this.factory).rowMap();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/StandardRowSortedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */