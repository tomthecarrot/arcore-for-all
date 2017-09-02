package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList
  extends AbstractProtobufList<Double>
  implements Internal.DoubleList, RandomAccess
{
  private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList();
  private double[] array;
  private int size;
  
  static
  {
    EMPTY_LIST.makeImmutable();
  }
  
  DoubleArrayList()
  {
    this(new double[10], 0);
  }
  
  private DoubleArrayList(double[] paramArrayOfDouble, int paramInt)
  {
    this.array = paramArrayOfDouble;
    this.size = paramInt;
  }
  
  private void addDouble(int paramInt, double paramDouble)
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
      this.array[paramInt] = paramDouble;
      this.size += 1;
      this.modCount += 1;
      return;
      double[] arrayOfDouble = new double[this.size * 3 / 2 + 1];
      System.arraycopy(this.array, 0, arrayOfDouble, 0, paramInt);
      System.arraycopy(this.array, paramInt, arrayOfDouble, paramInt + 1, this.size - paramInt);
      this.array = arrayOfDouble;
    }
  }
  
  public static DoubleArrayList emptyList()
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
  
  public void add(int paramInt, Double paramDouble)
  {
    addDouble(paramInt, paramDouble.doubleValue());
  }
  
  public boolean addAll(Collection<? extends Double> paramCollection)
  {
    boolean bool = false;
    ensureIsMutable();
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (!(paramCollection instanceof DoubleArrayList)) {
      bool = super.addAll(paramCollection);
    }
    do
    {
      return bool;
      paramCollection = (DoubleArrayList)paramCollection;
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
  
  public void addDouble(double paramDouble)
  {
    addDouble(this.size, paramDouble);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof DoubleArrayList)) {
        return super.equals(paramObject);
      }
      paramObject = (DoubleArrayList)paramObject;
      if (this.size != ((DoubleArrayList)paramObject).size) {
        return false;
      }
      paramObject = ((DoubleArrayList)paramObject).array;
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
  
  public Double get(int paramInt)
  {
    return Double.valueOf(getDouble(paramInt));
  }
  
  public double getDouble(int paramInt)
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
      j = j * 31 + Internal.hashLong(Double.doubleToLongBits(this.array[i]));
      i += 1;
    }
    return j;
  }
  
  public Internal.DoubleList mutableCopyWithCapacity(int paramInt)
  {
    if (paramInt < this.size) {
      throw new IllegalArgumentException();
    }
    return new DoubleArrayList(Arrays.copyOf(this.array, paramInt), this.size);
  }
  
  public Double remove(int paramInt)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double d = this.array[paramInt];
    System.arraycopy(this.array, paramInt + 1, this.array, paramInt, this.size - paramInt);
    this.size -= 1;
    this.modCount += 1;
    return Double.valueOf(d);
  }
  
  public boolean remove(Object paramObject)
  {
    ensureIsMutable();
    int i = 0;
    while (i < this.size)
    {
      if (paramObject.equals(Double.valueOf(this.array[i])))
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
  
  public Double set(int paramInt, Double paramDouble)
  {
    return Double.valueOf(setDouble(paramInt, paramDouble.doubleValue()));
  }
  
  public double setDouble(int paramInt, double paramDouble)
  {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double d = this.array[paramInt];
    this.array[paramInt] = paramDouble;
    return d;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/DoubleArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */