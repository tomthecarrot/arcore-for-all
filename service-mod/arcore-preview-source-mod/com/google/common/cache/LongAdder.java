package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible(emulated=true)
final class LongAdder
  extends Striped64
  implements Serializable, LongAddable
{
  private static final long serialVersionUID = 7249069246863182397L;
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.busy = 0;
    this.cells = null;
    this.base = paramObjectInputStream.readLong();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeLong(sum());
  }
  
  public void add(long paramLong)
  {
    Object localObject = this.cells;
    long l;
    if (localObject == null)
    {
      l = this.base;
      if (casBase(l, l + paramLong)) {}
    }
    else
    {
      boolean bool2 = true;
      int[] arrayOfInt = (int[])threadHashCode.get();
      boolean bool1 = bool2;
      if (arrayOfInt != null)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          int i = localObject.length;
          bool1 = bool2;
          if (i >= 1)
          {
            localObject = localObject[(i - 1 & arrayOfInt[0])];
            bool1 = bool2;
            if (localObject != null)
            {
              l = ((Striped64.Cell)localObject).value;
              bool1 = ((Striped64.Cell)localObject).cas(l, l + paramLong);
              if (bool1) {
                return;
              }
            }
          }
        }
      }
      retryUpdate(paramLong, arrayOfInt, bool1);
    }
  }
  
  public void decrement()
  {
    add(-1L);
  }
  
  public double doubleValue()
  {
    return sum();
  }
  
  public float floatValue()
  {
    return (float)sum();
  }
  
  final long fn(long paramLong1, long paramLong2)
  {
    return paramLong1 + paramLong2;
  }
  
  public void increment()
  {
    add(1L);
  }
  
  public int intValue()
  {
    return (int)sum();
  }
  
  public long longValue()
  {
    return sum();
  }
  
  public void reset()
  {
    internalReset(0L);
  }
  
  public long sum()
  {
    long l1 = this.base;
    Striped64.Cell[] arrayOfCell = this.cells;
    long l2 = l1;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        Striped64.Cell localCell = arrayOfCell[i];
        l2 = l1;
        if (localCell != null) {
          l2 = l1 + localCell.value;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public long sumThenReset()
  {
    long l1 = this.base;
    Striped64.Cell[] arrayOfCell = this.cells;
    this.base = 0L;
    long l2 = l1;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        Striped64.Cell localCell = arrayOfCell[i];
        l2 = l1;
        if (localCell != null)
        {
          l2 = l1 + localCell.value;
          localCell.value = 0L;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public String toString()
  {
    return Long.toString(sum());
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/LongAdder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */