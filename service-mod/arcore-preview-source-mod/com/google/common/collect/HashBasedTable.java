package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class HashBasedTable<R, C, V>
  extends StandardTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  HashBasedTable(Map<R, Map<C, V>> paramMap, Factory<C, V> paramFactory)
  {
    super(paramMap, paramFactory);
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create()
  {
    return new HashBasedTable(new HashMap(), new Factory(0));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(int paramInt1, int paramInt2)
  {
    CollectPreconditions.checkNonnegative(paramInt2, "expectedCellsPerRow");
    return new HashBasedTable(Maps.newHashMapWithExpectedSize(paramInt1), new Factory(paramInt2));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    HashBasedTable localHashBasedTable = create();
    localHashBasedTable.putAll(paramTable);
    return localHashBasedTable;
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return super.contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(@Nullable Object paramObject)
  {
    return super.containsColumn(paramObject);
  }
  
  public boolean containsRow(@Nullable Object paramObject)
  {
    return super.containsRow(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return super.containsValue(paramObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return (V)super.get(paramObject1, paramObject2);
  }
  
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return (V)super.remove(paramObject1, paramObject2);
  }
  
  private static class Factory<C, V>
    implements Supplier<Map<C, V>>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final int expectedSize;
    
    Factory(int paramInt)
    {
      this.expectedSize = paramInt;
    }
    
    public Map<C, V> get()
    {
      return Maps.newHashMapWithExpectedSize(this.expectedSize);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/HashBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */