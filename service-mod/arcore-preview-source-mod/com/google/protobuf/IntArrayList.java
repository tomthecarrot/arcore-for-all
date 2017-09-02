package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList
  extends AbstractProtobufList<Integer>
  implements Internal.IntList, RandomAccess
{
  private static final IntArrayList EMPTY_LIST = new IntArrayList();
  private int[] array;
  private int size;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  IntArrayList()
  {
    this(new int[10], 0);
  }
  
  private IntArrayList(int[] paramArrayOfInt, int paramInt)
  {
    this.array = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void addInt(int paramInt1, int paramInt2)
  {
    ensureIsMutable();
    if ((paramInt1 < 0) || (paramInt1 > this.size)) {
      throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt1));
    }
    if (this.size < this.array.length) {
      System.arraycopy(this.array, paramInt1, this.array, paramInt1 + 1, this.size - paramInt1);
    }
    for (;;)
    {
      this.array[paramInt1] = paramInt2;
      this.size += 1;
      this.modCount += 1;
      return;
      int[] arrayOfInt = new int[this.size * 3 / 2 + 1];
      System.arraycopy(this.array, 0, arrayOfInt, 0, paramInt1);
      System.arraycopy(this.array, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
      this.array = arrayOfInt;
    }
  }
  
  public static IntArrayList emptyList()
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
  
  public void add(int paramInt, Integer paramInteger)
  {
    addInt(paramInt, paramInteger.intValue());
  }
  
  public boolean addAll(Collection<? extends Integer> paramCollection)
  {
    boolean bool = false;
    ensureIsMutable();
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (!(paramCollection instanceof IntArrayList)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (IntArrayList)paramCollection;
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
  
  public void addInt(int paramInt)
  {
    addInt(this.size, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof IntArrayList)) {
        return super.equals(paramObject);
      }
      paramObject = (IntArrayList)paramObject;
      if (this.size != ((IntArrayList)paramObject).size) {
        return false;
      }
      paramObject = ((IntArrayList)paramObject).array;
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
  
  public Integer get(int paramInt)
  {
    return Integer.valueOf(getInt(paramInt));
  }
  
  public int getInt(int paramInt)
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
      j = j * 31 + this.array[i];
      i += 1;
    }
    return j;
  }
  
  public Internal.IntList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new IntArrayList(Arrays.copyOf(this.array, paramInt), this.size);
  }
  
  public Integer remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int i = this.array[paramInt];
    System.arraycopy(this.array, paramInt + 1, this.array, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Integer.valueOf(i);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Integer.valueOf(this.array[i])))
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
  
  public Integer set(int paramInt, Integer paramInteger)
  {
    return Integer.valueOf(setInt(paramInt, paramInteger.intValue()));
  }
  
  public int setInt(int paramInt1, int paramInt2)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt1);
    int i = this.array[paramInt1];
    this.array[paramInt1] = paramInt2;
    return i;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/IntArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */