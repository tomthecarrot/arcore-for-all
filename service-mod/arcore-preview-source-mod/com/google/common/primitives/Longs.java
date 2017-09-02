package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Longs
{
  public static final int BYTES = 8;
  public static final long MAX_POWER_OF_TWO = 4611686018427387904L;
  private static final byte[] asciiDigits = ;
  
  public static List<Long> asList(long... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new LongArrayAsList(paramVarArgs);
  }
  
  public static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  public static long[] concat(long[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    long[] arrayOfLong1 = new long[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      long[] arrayOfLong2 = paramVarArgs[i];
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, j, arrayOfLong2.length);
      j += arrayOfLong2.length;
      i += 1;
    }
    return arrayOfLong1;
  }
  
  public static boolean contains(long[] paramArrayOfLong, long paramLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfLong[i] == paramLong) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static long[] copyOf(long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, Math.min(paramArrayOfLong.length, paramInt));
    return arrayOfLong;
  }
  
  private static byte[] createAsciiDigits()
  {
    byte[] arrayOfByte = new byte[''];
    Arrays.fill(arrayOfByte, (byte)-1);
    int i = 0;
    while (i <= 9)
    {
      arrayOfByte[(i + 48)] = ((byte)i);
      i += 1;
    }
    i = 0;
    while (i <= 26)
    {
      arrayOfByte[(i + 65)] = ((byte)(i + 10));
      arrayOfByte[(i + 97)] = ((byte)(i + 10));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static int digit(char paramChar)
  {
    if (paramChar < '') {
      return asciiDigits[paramChar];
    }
    return -1;
  }
  
  public static long[] ensureCapacity(long[] paramArrayOfLong, int paramInt1, int paramInt2)
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
      long[] arrayOfLong = paramArrayOfLong;
      if (paramArrayOfLong.length < paramInt1) {
        arrayOfLong = copyOf(paramArrayOfLong, paramInt1 + paramInt2);
      }
      return arrayOfLong;
      bool = false;
      break;
    }
  }
  
  public static long fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(8) });
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3], paramArrayOfByte[4], paramArrayOfByte[5], paramArrayOfByte[6], paramArrayOfByte[7]);
    }
  }
  
  public static long fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    return (paramByte1 & 0xFF) << 56 | (paramByte2 & 0xFF) << 48 | (paramByte3 & 0xFF) << 40 | (paramByte4 & 0xFF) << 32 | (paramByte5 & 0xFF) << 24 | (paramByte6 & 0xFF) << 16 | (paramByte7 & 0xFF) << 8 | paramByte8 & 0xFF;
  }
  
  public static int hashCode(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  public static int indexOf(long[] paramArrayOfLong, long paramLong)
  {
    return indexOf(paramArrayOfLong, paramLong, 0, paramArrayOfLong.length);
  }
  
  private static int indexOf(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfLong[paramInt1] == paramLong) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Preconditions.checkNotNull(paramArrayOfLong1, "array");
    Preconditions.checkNotNull(paramArrayOfLong2, "target");
    int j;
    if (paramArrayOfLong2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfLong1.length - paramArrayOfLong2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfLong2.length) {
          break;
        }
        if (paramArrayOfLong1[(i + k)] != paramArrayOfLong2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static String join(String paramString, long... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 10);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(long[] paramArrayOfLong, long paramLong)
  {
    return lastIndexOf(paramArrayOfLong, paramLong, 0, paramArrayOfLong.length);
  }
  
  private static int lastIndexOf(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfLong[paramInt2] == paramLong) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<long[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static long max(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l2 = l1;
        if (paramVarArgs[i] > l1) {
          l2 = paramVarArgs[i];
        }
        i += 1;
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long min(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l2 = l1;
        if (paramVarArgs[i] < l1) {
          l2 = paramVarArgs[i];
        }
        i += 1;
        l1 = l2;
      }
    }
    return l1;
  }
  
  @Beta
  public static Converter<String, Long> stringConverter()
  {
    return LongConverter.INSTANCE;
  }
  
  public static long[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof LongArrayAsList))
    {
      paramCollection = ((LongArrayAsList)paramCollection).toLongArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    long[] arrayOfLong = new long[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfLong;
      if (i >= j) {
        break;
      }
      arrayOfLong[i] = ((Number)Preconditions.checkNotNull(arrayOfObject[i])).longValue();
      i += 1;
    }
  }
  
  public static byte[] toByteArray(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 7;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i -= 1;
    }
    return arrayOfByte;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Long tryParse(String paramString)
  {
    return tryParse(paramString, 10);
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Long tryParse(String paramString, int paramInt)
  {
    int j = 1;
    if (((String)Preconditions.checkNotNull(paramString)).isEmpty()) {
      return null;
    }
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + paramInt);
    }
    int i;
    if (paramString.charAt(0) == '-')
    {
      i = 1;
      if (i == 0) {
        break label86;
      }
    }
    for (;;)
    {
      if (j != paramString.length()) {
        break label91;
      }
      return null;
      i = 0;
      break;
      label86:
      j = 0;
    }
    label91:
    int k = digit(paramString.charAt(j));
    if ((k < 0) || (k >= paramInt)) {
      return null;
    }
    long l1 = -k;
    long l2 = Long.MIN_VALUE / paramInt;
    j += 1;
    while (j < paramString.length())
    {
      k = digit(paramString.charAt(j));
      if ((k < 0) || (k >= paramInt) || (l1 < l2)) {
        return null;
      }
      l1 *= paramInt;
      if (l1 < k - Long.MIN_VALUE) {
        return null;
      }
      l1 -= k;
      j += 1;
    }
    if (i != 0) {
      return Long.valueOf(l1);
    }
    if (l1 == Long.MIN_VALUE) {
      return null;
    }
    return Long.valueOf(-l1);
  }
  
  private static enum LexicographicalComparator
    implements Comparator<long[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      int j = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
      int i = 0;
      while (i < j)
      {
        int k = Longs.compare(paramArrayOfLong1[i], paramArrayOfLong2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfLong1.length - paramArrayOfLong2.length;
    }
  }
  
  @GwtCompatible
  private static class LongArrayAsList
    extends AbstractList<Long>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final long[] array;
    final int end;
    final int start;
    
    LongArrayAsList(long[] paramArrayOfLong)
    {
      this(paramArrayOfLong, 0, paramArrayOfLong.length);
    }
    
    LongArrayAsList(long[] paramArrayOfLong, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfLong;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Long)) && (Longs.indexOf(this.array, ((Long)paramObject).longValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof LongArrayAsList)) {
          break;
        }
        paramObject = (LongArrayAsList)paramObject;
        int j = size();
        if (((LongArrayAsList)paramObject).size() != j) {
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
    
    public Long get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Long.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Longs.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Long))
      {
        int i = Longs.indexOf(this.array, ((Long)paramObject).longValue(), this.start, this.end);
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
      if ((paramObject instanceof Long))
      {
        int i = Longs.lastIndexOf(this.array, ((Long)paramObject).longValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Long set(int paramInt, Long paramLong)
    {
      Preconditions.checkElementIndex(paramInt, size());
      long l = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Long)Preconditions.checkNotNull(paramLong)).longValue();
      return Long.valueOf(l);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Long> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new LongArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    long[] toLongArray()
    {
      int i = size();
      long[] arrayOfLong = new long[i];
      System.arraycopy(this.array, this.start, arrayOfLong, 0, i);
      return arrayOfLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 10);
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
  
  private static final class LongConverter
    extends Converter<String, Long>
    implements Serializable
  {
    static final LongConverter INSTANCE = new LongConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Long paramLong)
    {
      return paramLong.toString();
    }
    
    protected Long doForward(String paramString)
    {
      return Long.decode(paramString);
    }
    
    public String toString()
    {
      return "Longs.stringConverter()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Longs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */