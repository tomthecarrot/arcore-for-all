package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;

final class ProtobufArrayList<E>
  extends AbstractProtobufList<E>
{
  private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList();
  private final List<E> list;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  ProtobufArrayList()
  {
    this(new ArrayList(10));
  }
  
  private ProtobufArrayList(List<E> paramList)
  {
    this.list = paramList;
  }
  
  public static <E> ProtobufArrayList<E> emptyList()
  {
    return EMPTY_LIST;
  }
  
  public void add(int paramInt, E paramE)
  {
    ensureIsMutable();
    this.list.add(paramInt, paramE);
    this.modCount += 1;
  }
  
  public E get(int paramInt)
  {
    return (E)this.list.get(paramInt);
  }
  
  public ProtobufArrayList<E> mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < size()) {
      throw new IllegalArgumentException();
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    localArrayList.addAll(this.list);
    return new ProtobufArrayList(localArrayList);
  }
  
  public E remove(int paramInt)
  {
    ensureIsMutable();
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return (E)localObject;
  }
  
  public E set(int paramInt, E paramE)
  {
    ensureIsMutable();
    paramE = this.list.set(paramInt, paramE);
    this.modCount += 1;
    return paramE;
  }
  
  public int size()
  {
    return this.list.size();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ProtobufArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */