package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList
  extends AbstractProtobufList<Float>
  implements Internal.FloatList, RandomAccess
{
  private static final FloatArrayList EMPTY_LIST = new FloatArrayList();
  private float[] array;
  private int size;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  FloatArrayList()
  {
    this(new float[10], 0);
  }
  
  private FloatArrayList(float[] paramArrayOfFloat, int paramInt)
  {
    this.array = paramArrayOfFloat;
    this.size = paramInt;
  }
  
  private void addFloat(int paramInt, float paramFloat)
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
      this.array[paramInt] = paramFloat;
      this.size += 1;
      this.modCount += 1;
      return;
      float[] arrayOfFloat = new float[this.size * 3 / 2 + 1];
      System.arraycopy(this.array, 0, arrayOfFloat, 0, paramInt);
      System.arraycopy(this.array, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
      this.array = arrayOfFloat;
    }
  }
  
  public static FloatArrayList emptyList()
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
  
  public void add(int paramInt, Float paramFloat)
  {
    addFloat(paramInt, paramFloat.floatValue());
  }
  
  public boolean addAll(Collection<? extends Float> paramCollection)
  {
    boolean bool = false;
    ensureIsMutable();
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (!(paramCollection instanceof FloatArrayList)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (FloatArrayList)paramCollection;
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
  
  public void addFloat(float paramFloat)
  {
    addFloat(this.size, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof FloatArrayList)) {
        return super.equals(paramObject);
      }
      paramObject = (FloatArrayList)paramObject;
      if (this.size != ((FloatArrayList)paramObject).size) {
        return false;
      }
      paramObject = ((FloatArrayList)paramObject).array;
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
  
  public Float get(int paramInt)
  {
    return Float.valueOf(getFloat(paramInt));
  }
  
  public float getFloat(int paramInt)
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
      j = j * 31 + Float.floatToIntBits(this.array[i]);
      i += 1;
    }
    return j;
  }
  
  public Internal.FloatList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new FloatArrayList(Arrays.copyOf(this.array, paramInt), this.size);
  }
  
  public Float remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float f = this.array[paramInt];
    System.arraycopy(this.array, paramInt + 1, this.array, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Float.valueOf(f);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Float.valueOf(this.array[i])))
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
  
  public Float set(int paramInt, Float paramFloat)
  {
    return Float.valueOf(setFloat(paramInt, paramFloat.floatValue()));
  }
  
  public float setFloat(int paramInt, float paramFloat)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float f = this.array[paramInt];
    this.array[paramInt] = paramFloat;
    return f;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/FloatArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */