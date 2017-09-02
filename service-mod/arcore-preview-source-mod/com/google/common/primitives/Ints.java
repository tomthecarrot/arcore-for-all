package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=true)
public final class Ints
{
  public static final int BYTES = 4;
  public static final int MAX_POWER_OF_TWO = 1073741824;
  
  public static List<Integer> asList(int... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new IntArrayAsList(paramVarArgs);
  }
  
  public static int checkedCast(long paramLong)
  {
    int i = (int)paramLong;
    if (i != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return i;
  }
  
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
  
  public static int[] concat(int[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    int[] arrayOfInt1 = new int[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      int[] arrayOfInt2 = paramVarArgs[i];
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, j, arrayOfInt2.length);
      j += arrayOfInt2.length;
      i += 1;
    }
    return arrayOfInt1;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static int[] copyOf(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, Math.min(paramArrayOfInt.length, paramInt));
    return arrayOfInt;
  }
  
  public static int[] ensureCapacity(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
      int[] arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length < paramInt1) {
        arrayOfInt = copyOf(paramArrayOfInt, paramInt1 + paramInt2);
      }
      return arrayOfInt;
      bool = false;
      break;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static int fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(4) });
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3]);
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static int fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  public static int hashCode(int paramInt)
  {
    return paramInt;
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt, 0, paramArrayOfInt.length);
  }
  
  private static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfInt[paramInt2] == paramInt1) {
        return paramInt2;
      }
      paramInt2 += 1;
    }
    return -1;
  }
  
  public static int indexOf(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Preconditions.checkNotNull(paramArrayOfInt1, "array");
    Preconditions.checkNotNull(paramArrayOfInt2, "target");
    int j;
    if (paramArrayOfInt2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfInt1.length - paramArrayOfInt2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfInt2.length) {
          break;
        }
        if (paramArrayOfInt1[(i + k)] != paramArrayOfInt2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static String join(String paramString, int... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(int[] paramArrayOfInt, int paramInt)
  {
    return lastIndexOf(paramArrayOfInt, paramInt, 0, paramArrayOfInt.length);
  }
  
  private static int lastIndexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      if (paramArrayOfInt[paramInt3] == paramInt1) {
        return paramInt3;
      }
      paramInt3 -= 1;
    }
    return -1;
  }
  
  public static Comparator<int[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static int max(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int k = j;
        if (paramVarArgs[i] > j) {
          k = paramVarArgs[i];
        }
        i += 1;
        j = k;
      }
    }
    return j;
  }
  
  public static int min(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int k = j;
        if (paramVarArgs[i] < j) {
          k = paramVarArgs[i];
        }
        i += 1;
        j = k;
      }
    }
    return j;
  }
  
  public static int saturatedCast(long paramLong)
  {
    if (paramLong > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    if (paramLong < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    return (int)paramLong;
  }
  
  @Beta
  public static Converter<String, Integer> stringConverter()
  {
    return IntConverter.INSTANCE;
  }
  
  public static int[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof IntArrayAsList))
    {
      paramCollection = ((IntArrayAsList)paramCollection).toIntArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = ((Number)Preconditions.checkNotNull(arrayOfObject[i])).intValue();
      i += 1;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static byte[] toByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString)
  {
    return tryParse(paramString, 10);
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString, int paramInt)
  {
    paramString = Longs.tryParse(paramString, paramInt);
    if ((paramString == null) || (paramString.longValue() != paramString.intValue())) {
      return null;
    }
    return Integer.valueOf(paramString.intValue());
  }
  
  @GwtCompatible
  private static class IntArrayAsList
    extends AbstractList<Integer>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final int[] array;
    final int end;
    final int start;
    
    IntArrayAsList(int[] paramArrayOfInt)
    {
      this(paramArrayOfInt, 0, paramArrayOfInt.length);
    }
    
    IntArrayAsList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfInt;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Integer)) && (Ints.indexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof IntArrayAsList)) {
          break;
        }
        paramObject = (IntArrayAsList)paramObject;
        int j = size();
        if (((IntArrayAsList)paramObject).size() != j) {
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
    
    public Integer get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Integer.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Ints.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Integer))
      {
        int i = Ints.indexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end);
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
      if ((paramObject instanceof Integer))
      {
        int i = Ints.lastIndexOf(this.array, ((Integer)paramObject).intValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Integer set(int paramInt, Integer paramInteger)
    {
      Preconditions.checkElementIndex(paramInt, size());
      int i = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Integer)Preconditions.checkNotNull(paramInteger)).intValue();
      return Integer.valueOf(i);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Integer> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new IntArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    int[] toIntArray()
    {
      int i = size();
      int[] arrayOfInt = new int[i];
      System.arraycopy(this.array, this.start, arrayOfInt, 0, i);
      return arrayOfInt;
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
  
  private static final class IntConverter
    extends Converter<String, Integer>
    implements Serializable
  {
    static final IntConverter INSTANCE = new IntConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Integer paramInteger)
    {
      return paramInteger.toString();
    }
    
    protected Integer doForward(String paramString)
    {
      return Integer.decode(paramString);
    }
    
    public String toString()
    {
      return "Ints.stringConverter()";
    }
  }
  
  private static enum LexicographicalComparator
    implements Comparator<int[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      int j = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
      int i = 0;
      while (i < j)
      {
        int k = Ints.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfInt1.length - paramArrayOfInt2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */