package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible(emulated=true, serializable=true)
class RegularImmutableList<E>
  extends ImmutableList<E>
{
  static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
  private final transient Object[] array;
  private final transient int offset;
  private final transient int size;
  
  RegularImmutableList(Object[] paramArrayOfObject)
  {
    this(paramArrayOfObject, 0, paramArrayOfObject.length);
  }
  
  RegularImmutableList(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.offset = paramInt1;
    this.size = paramInt2;
    this.array = paramArrayOfObject;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.array, this.offset, paramArrayOfObject, paramInt, this.size);
    return this.size + paramInt;
  }
  
  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, this.size);
    return (E)this.array[(this.offset + paramInt)];
  }
  
  boolean isPartialView()
  {
    return this.size != this.array.length;
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return Iterators.forArray(this.array, this.offset, this.size, paramInt);
  }
  
  public int size()
  {
    return this.size;
  }
  
  ImmutableList<E> subListUnchecked(int paramInt1, int paramInt2)
  {
    return new RegularImmutableList(this.array, this.offset + paramInt1, paramInt2 - paramInt1);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/RegularImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */