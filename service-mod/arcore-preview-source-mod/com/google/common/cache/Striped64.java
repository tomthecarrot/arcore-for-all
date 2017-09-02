package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64
  extends Number
{
  static final int NCPU = Runtime.getRuntime().availableProcessors();
  private static final Unsafe UNSAFE;
  private static final long baseOffset;
  private static final long busyOffset;
  static final Random rng;
  static final ThreadLocal<int[]> threadHashCode = new ThreadLocal();
  volatile transient long base;
  volatile transient int busy;
  volatile transient Cell[] cells;
  
  static
  {
    rng = new Random();
    try
    {
      UNSAFE = getUnsafe();
      baseOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("base"));
      busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
      return;
    }
    catch (Exception localException)
    {
      throw new Error(localException);
    }
  }
  
  private static Unsafe getUnsafe()
  {
    try
    {
      Unsafe localUnsafe1 = Unsafe.getUnsafe();
      return localUnsafe1;
    }
    catch (SecurityException localSecurityException)
    {
      try
      {
        Unsafe localUnsafe2 = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction()
        {
          public Unsafe run()
            throws Exception
          {
            Field[] arrayOfField = Unsafe.class.getDeclaredFields();
            int j = arrayOfField.length;
            int i = 0;
            while (i < j)
            {
              Object localObject = arrayOfField[i];
              ((Field)localObject).setAccessible(true);
              localObject = ((Field)localObject).get(null);
              if (Unsafe.class.isInstance(localObject)) {
                return (Unsafe)Unsafe.class.cast(localObject);
              }
              i += 1;
            }
            throw new NoSuchFieldError("the Unsafe");
          }
        });
        return localUnsafe2;
      }
      catch (PrivilegedActionException localPrivilegedActionException)
      {
        throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
      }
    }
  }
  
  final boolean casBase(long paramLong1, long paramLong2)
  {
    return UNSAFE.compareAndSwapLong(this, baseOffset, paramLong1, paramLong2);
  }
  
  final boolean casBusy()
  {
    return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
  }
  
  abstract long fn(long paramLong1, long paramLong2);
  
  final void internalReset(long paramLong)
  {
    Cell[] arrayOfCell = this.cells;
    this.base = paramLong;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      while (i < j)
      {
        Cell localCell = arrayOfCell[i];
        if (localCell != null) {
          localCell.value = paramLong;
        }
        i += 1;
      }
    }
  }
  
  final void retryUpdate(long paramLong, int[] paramArrayOfInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayOfInt == null)
    {
      localObject = threadHashCode;
      paramArrayOfInt = new int[1];
      ((ThreadLocal)localObject).set(paramArrayOfInt);
      i = rng.nextInt();
      if (i == 0)
      {
        i = 1;
        paramArrayOfInt[0] = i;
      }
    }
    int j;
    int k;
    int m;
    Cell[] arrayOfCell;
    for (;;)
    {
      j = 0;
      k = i;
      for (;;)
      {
        localObject = this.cells;
        if (localObject == null) {
          break label421;
        }
        m = localObject.length;
        if (m <= 0) {
          break label421;
        }
        arrayOfCell = localObject[(m - 1 & k)];
        if (arrayOfCell != null) {
          break label261;
        }
        if (this.busy != 0) {
          break;
        }
        localObject = new Cell(paramLong);
        if ((this.busy != 0) || (!casBusy())) {
          break;
        }
        m = 0;
        try
        {
          arrayOfCell = this.cells;
          i = m;
          if (arrayOfCell != null)
          {
            int n = arrayOfCell.length;
            i = m;
            if (n > 0)
            {
              n = n - 1 & k;
              i = m;
              if (arrayOfCell[n] == null)
              {
                arrayOfCell[n] = localObject;
                i = 1;
              }
            }
          }
          this.busy = 0;
          if (i != 0) {
            label189:
            return;
          }
        }
        finally
        {
          this.busy = 0;
        }
      }
      break;
      i = paramArrayOfInt[0];
    }
    int i = 0;
    boolean bool = paramBoolean;
    label261:
    long l;
    label342:
    do
    {
      do
      {
        for (;;)
        {
          j = k ^ k << 13;
          j ^= j >>> 17;
          k = j ^ j << 5;
          paramArrayOfInt[0] = k;
          j = i;
          paramBoolean = bool;
          break;
          if (!paramBoolean)
          {
            bool = true;
            i = j;
          }
          else
          {
            l = arrayOfCell.value;
            if (arrayOfCell.cas(l, fn(l, paramLong))) {
              break label189;
            }
            if ((m >= NCPU) || (this.cells != localObject))
            {
              i = 0;
              bool = paramBoolean;
            }
            else
            {
              if (j != 0) {
                break label342;
              }
              i = 1;
              bool = paramBoolean;
            }
          }
        }
        i = j;
        bool = paramBoolean;
      } while (this.busy != 0);
      i = j;
      bool = paramBoolean;
    } while (!casBusy());
    for (;;)
    {
      try
      {
        if (this.cells == localObject)
        {
          arrayOfCell = new Cell[m << 1];
          i = 0;
          break label528;
          this.cells = arrayOfCell;
        }
        this.busy = 0;
        j = 0;
        break;
      }
      finally
      {
        this.busy = 0;
      }
      label421:
      if ((this.busy == 0) && (this.cells == localObject) && (casBusy()))
      {
        i = 0;
        try
        {
          if (this.cells == localObject)
          {
            localObject = new Cell[2];
            localObject[(k & 0x1)] = new Cell(paramLong);
            this.cells = ((Cell[])localObject);
            i = 1;
          }
          this.busy = 0;
          if (i == 0) {
            break;
          }
          return;
        }
        finally
        {
          this.busy = 0;
        }
      }
      l = this.base;
      if (!casBase(l, fn(l, paramLong))) {
        break;
      }
      return;
      label528:
      while (i < m)
      {
        arrayOfCell[i] = localObject[i];
        i += 1;
      }
    }
  }
  
  static final class Cell
  {
    private static final Unsafe UNSAFE;
    private static final long valueOffset;
    volatile long p0;
    volatile long p1;
    volatile long p2;
    volatile long p3;
    volatile long p4;
    volatile long p5;
    volatile long p6;
    volatile long q0;
    volatile long q1;
    volatile long q2;
    volatile long q3;
    volatile long q4;
    volatile long q5;
    volatile long q6;
    volatile long value;
    
    static
    {
      try
      {
        UNSAFE = Striped64.access$000();
        valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField("value"));
        return;
      }
      catch (Exception localException)
      {
        throw new Error(localException);
      }
    }
    
    Cell(long paramLong)
    {
      this.value = paramLong;
    }
    
    final boolean cas(long paramLong1, long paramLong2)
    {
      return UNSAFE.compareAndSwapLong(this, valueOffset, paramLong1, paramLong2);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/Striped64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */