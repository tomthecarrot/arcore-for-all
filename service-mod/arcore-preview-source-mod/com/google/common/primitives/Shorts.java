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
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(emulated=true)
public final class Shorts
{
  public static final int BYTES = 2;
  public static final short MAX_POWER_OF_TWO = 16384;
  
  public static List<Short> asList(short... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new ShortArrayAsList(paramVarArgs);
  }
  
  public static short checkedCast(long paramLong)
  {
    short s = (short)(int)paramLong;
    if (s != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return s;
  }
  
  public static int compare(short paramShort1, short paramShort2)
  {
    return paramShort1 - paramShort2;
  }
  
  public static short[] concat(short[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    short[] arrayOfShort1 = new short[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      short[] arrayOfShort2 = paramVarArgs[i];
      System.arraycopy(arrayOfShort2, 0, arrayOfShort1, j, arrayOfShort2.length);
      j += arrayOfShort2.length;
      i += 1;
    }
    return arrayOfShort1;
  }
  
  public static boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfShort[i] == paramShort) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static short[] copyOf(short[] paramArrayOfShort, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, Math.min(paramArrayOfShort.length, paramInt));
    return arrayOfShort;
  }
  
  public static short[] ensureCapacity(short[] paramArrayOfShort, int paramInt1, int paramInt2)
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
      short[] arrayOfShort = paramArrayOfShort;
      if (paramArrayOfShort.length < paramInt1) {
        arrayOfShort = copyOf(paramArrayOfShort, paramInt1 + paramInt2);
      }
      return arrayOfShort;
      bool = false;
      break;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static short fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(2) });
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1]);
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static short fromBytes(byte paramByte1, byte paramByte2)
  {
    return (short)(paramByte1 << 8 | paramByte2 & 0xFF);
  }
  
  public static int hashCode(short paramShort)
  {
    return paramShort;
  }
  
  public static int indexOf(short[] paramArrayOfShort, short paramShort)
  {
    return indexOf(paramArrayOfShort, paramShort, 0, paramArrayOfShort.length);
  }
  
  private static int indexOf(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfShort[paramInt1] == paramShort) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Preconditions.checkNotNull(paramArrayOfShort1, "array");
    Preconditions.checkNotNull(paramArrayOfShort2, "target");
    int j;
    if (paramArrayOfShort2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfShort1.length - paramArrayOfShort2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfShort2.length) {
          break;
        }
        if (paramArrayOfShort1[(i + k)] != paramArrayOfShort2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static String join(String paramString, short... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 6);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(short[] paramArrayOfShort, short paramShort)
  {
    return lastIndexOf(paramArrayOfShort, paramShort, 0, paramArrayOfShort.length);
  }
  
  private static int lastIndexOf(short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfShort[paramInt2] == paramShort) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<short[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static short max(short... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    short s1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      s1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        short s2 = s1;
        if (paramVarArgs[i] > s1) {
          s2 = paramVarArgs[i];
        }
        i += 1;
        s1 = s2;
      }
    }
    return s1;
  }
  
  public static short min(short... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    short s1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      s1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        short s2 = s1;
        if (paramVarArgs[i] < s1) {
          s2 = paramVarArgs[i];
        }
        i += 1;
        s1 = s2;
      }
    }
    return s1;
  }
  
  public static short saturatedCast(long paramLong)
  {
    if (paramLong > 32767L) {
      return Short.MAX_VALUE;
    }
    if (paramLong < -32768L) {
      return Short.MIN_VALUE;
    }
    return (short)(int)paramLong;
  }
  
  @Beta
  public static Converter<String, Short> stringConverter()
  {
    return ShortConverter.INSTANCE;
  }
  
  public static short[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof ShortArrayAsList))
    {
      paramCollection = ((ShortArrayAsList)paramCollection).toShortArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfShort;
      if (i >= j) {
        break;
      }
      arrayOfShort[i] = ((Number)Preconditions.checkNotNull(arrayOfObject[i])).shortValue();
      i += 1;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static byte[] toByteArray(short paramShort)
  {
    return new byte[] { (byte)(paramShort >> 8), (byte)paramShort };
  }
  
  private static enum LexicographicalComparator
    implements Comparator<short[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
    {
      int j = Math.min(paramArrayOfShort1.length, paramArrayOfShort2.length);
      int i = 0;
      while (i < j)
      {
        int k = Shorts.compare(paramArrayOfShort1[i], paramArrayOfShort2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfShort1.length - paramArrayOfShort2.length;
    }
  }
  
  @GwtCompatible
  private static class ShortArrayAsList
    extends AbstractList<Short>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final short[] array;
    final int end;
    final int start;
    
    ShortArrayAsList(short[] paramArrayOfShort)
    {
      this(paramArrayOfShort, 0, paramArrayOfShort.length);
    }
    
    ShortArrayAsList(short[] paramArrayOfShort, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfShort;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Short)) && (Shorts.indexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof ShortArrayAsList)) {
          break;
        }
        paramObject = (ShortArrayAsList)paramObject;
        int j = size();
        if (((ShortArrayAsList)paramObject).size() != j) {
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
    
    public Short get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Short.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Shorts.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Short))
      {
        int i = Shorts.indexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end);
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
      if ((paramObject instanceof Short))
      {
        int i = Shorts.lastIndexOf(this.array, ((Short)paramObject).shortValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Short set(int paramInt, Short paramShort)
    {
      Preconditions.checkElementIndex(paramInt, size());
      short s = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Short)Preconditions.checkNotNull(paramShort)).shortValue();
      return Short.valueOf(s);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Short> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new ShortArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    short[] toShortArray()
    {
      int i = size();
      short[] arrayOfShort = new short[i];
      System.arraycopy(this.array, this.start, arrayOfShort, 0, i);
      return arrayOfShort;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 6);
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
  
  private static final class ShortConverter
    extends Converter<String, Short>
    implements Serializable
  {
    static final ShortConverter INSTANCE = new ShortConverter();
    private static final long serialVersionUID = 1L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    protected String doBackward(Short paramShort)
    {
      return paramShort.toString();
    }
    
    protected Short doForward(String paramString)
    {
      return Short.decode(paramString);
    }
    
    public String toString()
    {
      return "Shorts.stringConverter()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Shorts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */