package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable<R, C, V>
  extends AbstractTable<R, C, V>
{
  private static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
  
  public static <R, C, V> Builder<R, C, V> builder()
  {
    return new Builder();
  }
  
  static <R, C, V> Table.Cell<R, C, V> cellOf(R paramR, C paramC, V paramV)
  {
    return Tables.immutableCell(Preconditions.checkNotNull(paramR), Preconditions.checkNotNull(paramC), Preconditions.checkNotNull(paramV));
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    if ((paramTable instanceof ImmutableTable)) {
      return (ImmutableTable)paramTable;
    }
    int i = paramTable.size();
    ImmutableSet.Builder localBuilder;
    switch (i)
    {
    default: 
      localBuilder = new ImmutableSet.Builder(i);
      paramTable = paramTable.cellSet().iterator();
    }
    while (paramTable.hasNext())
    {
      Table.Cell localCell = (Table.Cell)paramTable.next();
      localBuilder.add(cellOf(localCell.getRowKey(), localCell.getColumnKey(), localCell.getValue()));
      continue;
      return of();
      paramTable = (Table.Cell)Iterables.getOnlyElement(paramTable.cellSet());
      return of(paramTable.getRowKey(), paramTable.getColumnKey(), paramTable.getValue());
    }
    return RegularImmutableTable.forCells(localBuilder.build());
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of()
  {
    return EMPTY;
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of(R paramR, C paramC, V paramV)
  {
    return new SingletonImmutableTable(paramR, paramC, paramV);
  }
  
  final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSet<Table.Cell<R, C, V>> cellSet()
  {
    return (ImmutableSet)super.cellSet();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<R, V> column(C paramC)
  {
    Preconditions.checkNotNull(paramC);
    return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)columnMap().get(paramC), ImmutableMap.of());
  }
  
  public ImmutableSet<C> columnKeySet()
  {
    return columnMap().keySet();
  }
  
  public abstract ImmutableMap<C, Map<R, V>> columnMap();
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return get(paramObject1, paramObject2) != null;
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();
  
  abstract ImmutableCollection<V> createValues();
  
  @Deprecated
  public final V put(R paramR, C paramC, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<C, V> row(R paramR)
  {
    Preconditions.checkNotNull(paramR);
    return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)rowMap().get(paramR), ImmutableMap.of());
  }
  
  public ImmutableSet<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public abstract ImmutableMap<R, Map<C, V>> rowMap();
  
  public ImmutableCollection<V> values()
  {
    return (ImmutableCollection)super.values();
  }
  
  final Iterator<V> valuesIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public static final class Builder<R, C, V>
  {
    private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
    private Comparator<? super C> columnComparator;
    private Comparator<? super R> rowComparator;
    
    public ImmutableTable<R, C, V> build()
    {
      switch (this.cells.size())
      {
      default: 
        return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
      case 0: 
        return ImmutableTable.of();
      }
      return new SingletonImmutableTable((Table.Cell)Iterables.getOnlyElement(this.cells));
    }
    
    public Builder<R, C, V> orderColumnsBy(Comparator<? super C> paramComparator)
    {
      this.columnComparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
      return this;
    }
    
    public Builder<R, C, V> orderRowsBy(Comparator<? super R> paramComparator)
    {
      this.rowComparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
      return this;
    }
    
    public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> paramCell)
    {
      if ((paramCell instanceof Tables.ImmutableCell))
      {
        Preconditions.checkNotNull(paramCell.getRowKey());
        Preconditions.checkNotNull(paramCell.getColumnKey());
        Preconditions.checkNotNull(paramCell.getValue());
        this.cells.add(paramCell);
        return this;
      }
      put(paramCell.getRowKey(), paramCell.getColumnKey(), paramCell.getValue());
      return this;
    }
    
    public Builder<R, C, V> put(R paramR, C paramC, V paramV)
    {
      this.cells.add(ImmutableTable.cellOf(paramR, paramC, paramV));
      return this;
    }
    
    public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> paramTable)
    {
      paramTable = paramTable.cellSet().iterator();
      while (paramTable.hasNext()) {
        put((Table.Cell)paramTable.next());
      }
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */