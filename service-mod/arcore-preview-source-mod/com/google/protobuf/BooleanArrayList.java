package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList
  extends AbstractProtobufList<Boolean>
  implements Internal.BooleanList, RandomAccess
{
  private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList();
  private boolean[] array;
  private int size;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  BooleanArrayList()
  {
    this(new boolean[10], 0);
  }
  
  private BooleanArrayList(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.array = paramArrayOfBoolean;
    this.size = paramInt;
  }
  
  private void addBoolean(int paramInt, boolean paramBoolean)
  {
    ensureIsMutable();
    if ((paramInt < 0) || (paramInt > this.size)) {
      throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
    }
    if (this.size < this.array.length) {
      System.arraycopy(this.array, paramInt, this.array, paramInt + 1, this.size - paramInt);
    }
    for (;;)
    {
      this.array[paramInt] = paramBoolean;
      this.size += 1;
      this.modCount += 1;
      return;
      boolean[] arrayOfBoolean = new boolean[this.size * 3 / 2 + 1];
      System.arraycopy(this.array, 0, arrayOfBoolean, 0, paramInt);
      System.arraycopy(this.array, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
      this.array = arrayOfBoolean;
    }
  }
  
  public static BooleanArrayList emptyList()
  {
    return EMPTY_LIST;
  }
  
  private void ensureIndexInRange(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size)) {
      throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
    }
  }
  
  private String makeOutOfBoundsExceptionMessage(int paramInt)
  {
    return "Index:" + paramInt + ", Size:" + this.size;
  }
  
  public void add(int paramInt, Boolean paramBoolean)
  {
    addBoolean(paramInt, paramBoolean.booleanValue());
  }
  
  public boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    boolean bool = false;
    ensureIsMutable();
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (!(paramCollection instanceof BooleanArrayList)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (BooleanArrayList)paramCollection;
    } while (paramCollection.size == 0);
    if (Integer.MAX_VALUE - this.size < paramCollection.size) {
      throw new OutOfMemoryError();
    }
    int i = this.size + paramCollection.size;
    if (i > this.array.length) {
      this.array = Arrays.copyOf(this.array, i);
    }
    System.arraycopy(paramCollection.array, 0, this.array, this.size, paramCollection.size);
    this.size = i;
    this.modCount += 1;
    return true;
  }
  
  public void addBoolean(boolean paramBoolean)
  {
    addBoolean(this.size, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof BooleanArrayList)) {
        return super.equals(paramObject);
      }
      paramObject = (BooleanArrayList)paramObject;
      if (this.size != ((BooleanArrayList)paramObject).size) {
        return false;
      }
      paramObject = ((BooleanArrayList)paramObject).array;
      int i = 0;
      while (i < this.size)
      {
        if (this.array[i] != paramObject[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public Boolean get(int paramInt)
  {
    return Boolean.valueOf(getBoolean(paramInt));
  }
  
  public boolean getBoolean(int paramInt)
  {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.size)
    {
      j = j * 31 + Internal.hashBoolean(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.BooleanList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new BooleanArrayList(Arrays.copyOf(this.array, paramInt), this.size);
  }
  
  public Boolean remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int i = this.array[paramInt];
    System.arraycopy(this.array, paramInt + 1, this.array, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Boolean.valueOf(i);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Boolean.valueOf(this.array[i])))
      {
        System.arraycopy(this.array, i + 1, this.array, i, this.size - i);
        this.size -= 1;
        this.modCount += 1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public Boolean set(int paramInt, Boolean paramBoolean)
  {
    return Boolean.valueOf(setBoolean(paramInt, paramBoolean.booleanValue()));
  }
  
  public boolean setBoolean(int paramInt, boolean paramBoolean)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int i = this.array[paramInt];
    this.array[paramInt] = paramBoolean;
    return i;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/BooleanArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */