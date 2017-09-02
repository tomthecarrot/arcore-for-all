package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class AbstractProtobufList<E>
  extends AbstractList<E>
  implements Internal.ProtobufList<E>
{
  protected static final int DEFAULT_CAPACITY = 10;
  private boolean isMutable = true;
  
  public void add(int paramInt, E paramE)
  {
    ensureIsMutable();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    ensureIsMutable();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    ensureIsMutable();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    ensureIsMutable();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    ensureIsMutable();
    super.clear();
  }
  
  protected void ensureIsMutable()
  {
    if (!this.isMutable) {
      throw new UnsupportedOperationException();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      if (!(paramObject instanceof RandomAccess)) {
        return super.equals(paramObject);
      }
      paramObject = (List)paramObject;
      int j = size();
      if (j != ((List)paramObject).size()) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (!get(i).equals(((List)paramObject).get(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isModifiable()
  {
    return this.isMutable;
  }
  
  public final void makeImmutable()
  {
    this.isMutable = false;
  }
  
  public E remove(int paramInt)
  {
    ensureIsMutable();
    return (E)super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    ensureIsMutable();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    ensureIsMutable();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    ensureIsMutable();
    return (E)super.set(paramInt, paramE);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/AbstractProtobufList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */