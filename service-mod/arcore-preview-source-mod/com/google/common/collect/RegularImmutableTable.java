package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V>
  extends ImmutableTable<R, C, V>
{
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> paramIterable)
  {
    return forCellsInternal(paramIterable, null, null);
  }
  
  static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> paramList, @Nullable Comparator<? super R> paramComparator, @Nullable final Comparator<? super C> paramComparator1)
  {
    Preconditions.checkNotNull(paramList);
    if ((paramComparator != null) || (paramComparator1 != null)) {
      Collections.sort(paramList, new Comparator()
      {
        public int compare(Table.Cell<R, C, V> paramAnonymousCell1, Table.Cell<R, C, V> paramAnonymousCell2)
        {
          int j = 0;
          if (this.val$rowComparator == null) {}
          for (int i = 0; i != 0; i = this.val$rowComparator.compare(paramAnonymousCell1.getRowKey(), paramAnonymousCell2.getRowKey())) {
            return i;
          }
          if (paramComparator1 == null) {}
          for (i = j;; i = paramComparator1.compare(paramAnonymousCell1.getColumnKey(), paramAnonymousCell2.getColumnKey())) {
            return i;
          }
        }
      });
    }
    return forCellsInternal(paramList, paramComparator, paramComparator1);
  }
  
  private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> paramIterable, @Nullable Comparator<? super R> paramComparator, @Nullable Comparator<? super C> paramComparator1)
  {
    LinkedHashSet localLinkedHashSet2 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet1 = new LinkedHashSet();
    ImmutableList localImmutableList = ImmutableList.copyOf(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Table.Cell localCell = (Table.Cell)paramIterable.next();
      localLinkedHashSet2.add(localCell.getRowKey());
      localLinkedHashSet1.add(localCell.getColumnKey());
    }
    if (paramComparator == null)
    {
      paramIterable = ImmutableSet.copyOf(localLinkedHashSet2);
      if (paramComparator1 != null) {
        break label154;
      }
    }
    label154:
    for (paramComparator = ImmutableSet.copyOf(localLinkedHashSet1);; paramComparator = ImmutableSet.copyOf(Ordering.from(paramComparator1).immutableSortedCopy(localLinkedHashSet1)))
    {
      if (localImmutableList.size() <= paramIterable.size() * paramComparator.size() / 2L) {
        break label170;
      }
      return new DenseImmutableTable(localImmutableList, paramIterable, paramComparator);
      paramIterable = ImmutableSet.copyOf(Ordering.from(paramComparator).immutableSortedCopy(localLinkedHashSet2));
      break;
    }
    label170:
    return new SparseImmutableTable(localImmutableList, paramIterable, paramComparator);
  }
  
  final ImmutableSet<Table.Cell<R, C, V>> createCellSet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new CellSet(null);
  }
  
  final ImmutableCollection<V> createValues()
  {
    if (isEmpty()) {
      return ImmutableList.of();
    }
    return new Values(null);
  }
  
  abstract Table.Cell<R, C, V> getCell(int paramInt);
  
  abstract V getValue(int paramInt);
  
  private final class CellSet
    extends ImmutableSet.Indexed<Table.Cell<R, C, V>>
  {
    private CellSet() {}
    
    public boolean contains(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Table.Cell))
      {
        paramObject = (Table.Cell)paramObject;
        Object localObject = RegularImmutableTable.this.get(((Table.Cell)paramObject).getRowKey(), ((Table.Cell)paramObject).getColumnKey());
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (localObject.equals(((Table.Cell)paramObject).getValue())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    Table.Cell<R, C, V> get(int paramInt)
    {
      return RegularImmutableTable.this.getCell(paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public int size()
    {
      return RegularImmutableTable.this.size();
    }
  }
  
  private final class Values
    extends ImmutableList<V>
  {
    private Values() {}
    
    public V get(int paramInt)
    {
      return (V)RegularImmutableTable.this.getValue(paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return RegularImmutableTable.this.size();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */