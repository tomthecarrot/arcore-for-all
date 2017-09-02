package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList
  extends AbstractProtobufList<Long>
  implements Internal.LongList, RandomAccess
{
  private static final LongArrayList EMPTY_LIST = new LongArrayList();
  private long[] array;
  private int size;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  LongArrayList()
  {
    this(new long[10], 0);
  }
  
  private LongArrayList(long[] paramArrayOfLong, int paramInt)
  {
    this.array = paramArrayOfLong;
    this.size = paramInt;
  }
  
  private void addLong(int paramInt, long paramLong)
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
      this.array[paramInt] = paramLong;
      this.size += 1;
      this.modCount += 1;
      return;
      long[] arrayOfLong = new long[this.size * 3 / 2 + 1];
      System.arraycopy(this.array, 0, arrayOfLong, 0, paramInt);
      System.arraycopy(this.array, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
      this.array = arrayOfLong;
    }
  }
  
  public static LongArrayList emptyList()
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
  
  public void add(int paramInt, Long paramLong)
  {
    addLong(paramInt, paramLong.longValue());
  }
  
  public boolean addAll(Collection<? extends Long> paramCollection)
  {
    boolean bool = false;
    ensureIsMutable();
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (!(paramCollection instanceof LongArrayList)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (LongArrayList)paramCollection;
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
  
  public void addLong(long paramLong)
  {
    addLong(this.size, paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof LongArrayList)) {
        return super.equals(paramObject);
      }
      paramObject = (LongArrayList)paramObject;
      if (this.size != ((LongArrayList)paramObject).size) {
        return false;
      }
      paramObject = ((LongArrayList)paramObject).array;
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
  
  public Long get(int paramInt)
  {
    return Long.valueOf(getLong(paramInt));
  }
  
  public long getLong(int paramInt)
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
      j = j * 31 + Internal.hashLong(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.LongList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new LongArrayList(Arrays.copyOf(this.array, paramInt), this.size);
  }
  
  public Long remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long l = this.array[paramInt];
    System.arraycopy(this.array, paramInt + 1, this.array, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Long.valueOf(l);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Long.valueOf(this.array[i])))
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
  
  public Long set(int paramInt, Long paramLong)
  {
    return Long.valueOf(setLong(paramInt, paramLong.longValue()));
  }
  
  public long setLong(int paramInt, long paramLong)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long l = this.array[paramInt];
    this.array[paramInt] = paramLong;
    return l;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/LongArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */