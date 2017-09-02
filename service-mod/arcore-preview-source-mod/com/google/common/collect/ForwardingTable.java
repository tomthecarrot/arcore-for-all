package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public abstract class ForwardingTable<R, C, V>
  extends ForwardingObject
  implements Table<R, C, V>
{
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    return delegate().cellSet();
  }
  
  public void clear()
  {
    delegate().clear();
  }
  
  public Map<R, V> column(C paramC)
  {
    return delegate().column(paramC);
  }
  
  public Set<C> columnKeySet()
  {
    return delegate().columnKeySet();
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    return delegate().columnMap();
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return delegate().contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return delegate().containsColumn(paramObject);
  }
  
  public boolean containsRow(Object paramObject)
  {
    return delegate().containsRow(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return delegate().containsValue(paramObject);
  }
  
  protected abstract Table<R, C, V> delegate();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public V get(Object paramObject1, Object paramObject2)
  {
    return (V)delegate().get(paramObject1, paramObject2);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public V put(R paramR, C paramC, V paramV)
  {
    return (V)delegate().put(paramR, paramC, paramV);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> paramTable)
  {
    delegate().putAll(paramTable);
  }
  
  public V remove(Object paramObject1, Object paramObject2)
  {
    return (V)delegate().remove(paramObject1, paramObject2);
  }
  
  public Map<C, V> row(R paramR)
  {
    return delegate().row(paramR);
  }
  
  public Set<R> rowKeySet()
  {
    return delegate().rowKeySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    return delegate().rowMap();
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public Collection<V> values()
  {
    return delegate().values();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/ForwardingTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */