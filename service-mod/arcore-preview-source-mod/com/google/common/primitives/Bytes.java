package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Bytes
{
  public static List<Byte> asList(byte... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new ByteArrayAsList(paramVarArgs);
  }
  
  public static byte[] concat(byte[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public static boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfByte[i] == paramByte) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt));
    return arrayOfByte;
  }
  
  public static byte[] ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Invalid minLength: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt2 < 0) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid padding: %s", new Object[] { Integer.valueOf(paramInt2) });
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length < paramInt1) {
        arrayOfByte = copyOf(paramArrayOfByte, paramInt1 + paramInt2);
      }
      return arrayOfByte;
      bool = false;
      break;
    }
  }
  
  public static int hashCode(byte paramByte)
  {
    return paramByte;
  }
  
  public static int indexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return indexOf(paramArrayOfByte, paramByte, 0, paramArrayOfByte.length);
  }
  
  private static int indexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] == paramByte) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1, "array");
    Preconditions.checkNotNull(paramArrayOfByte2, "target");
    int j;
    if (paramArrayOfByte2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfByte1.length - paramArrayOfByte2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfByte2.length) {
          break;
        }
        if (paramArrayOfByte1[(i + k)] != paramArrayOfByte2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return lastIndexOf(paramArrayOfByte, paramByte, 0, paramArrayOfByte.length);
  }
  
  private static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfByte[paramInt2] == paramByte) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static byte[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof ByteArrayAsList))
    {
      paramCollection = ((ByteArrayAsList)paramCollection).toByteArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[i] = ((Number)Preconditions.checkNotNull(arrayOfObject[i])).byteValue();
      i += 1;
    }
  }
  
  @GwtCompatible
  private static class ByteArrayAsList
    extends AbstractList<Byte>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final byte[] array;
    final int end;
    final int start;
    
    ByteArrayAsList(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayAsList(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfByte;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Byte)) && (Bytes.indexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof ByteArrayAsList)) {
          break;
        }
        paramObject = (ByteArrayAsList)paramObject;
        int j = size();
        if (((ByteArrayAsList)paramObject).size() != j) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (this.array[(this.start + i)] != paramObject.array[(paramObject.start + i)]) {
            return false;
          }
          i += 1;
        }
      }
      return super.equals(paramObject);
    }
    
    public Byte get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Byte.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Bytes.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Byte))
      {
        int i = Bytes.indexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      if ((paramObject instanceof Byte))
      {
        int i = Bytes.lastIndexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Byte set(int paramInt, Byte paramByte)
    {
      Preconditions.checkElementIndex(paramInt, size());
      byte b = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Byte)Preconditions.checkNotNull(paramByte)).byteValue();
      return Byte.valueOf(b);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Byte> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new ByteArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    byte[] toByteArray()
    {
      int i = size();
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.array, this.start, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 5);
      localStringBuilder.append('[').append(this.array[this.start]);
      int i = this.start + 1;
      while (i < this.end)
      {
        localStringBuilder.append(", ").append(this.array[i]);
        i += 1;
      }
      return ']';
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Bytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */