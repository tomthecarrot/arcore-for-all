package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=true)
public final class Chars
{
  public static final int BYTES = 2;
  
  public static List<Character> asList(char... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new CharArrayAsList(paramVarArgs);
  }
  
  public static char checkedCast(long paramLong)
  {
    char c = (char)(int)paramLong;
    if (c != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return c;
  }
  
  public static int compare(char paramChar1, char paramChar2)
  {
    return paramChar1 - paramChar2;
  }
  
  public static char[] concat(char[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    char[] arrayOfChar1 = new char[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      char[] arrayOfChar2 = paramVarArgs[i];
      System.arraycopy(arrayOfChar2, 0, arrayOfChar1, j, arrayOfChar2.length);
      j += arrayOfChar2.length;
      i += 1;
    }
    return arrayOfChar1;
  }
  
  public static boolean contains(char[] paramArrayOfChar, char paramChar)
  {
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfChar[i] == paramChar) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static char[] copyOf(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, Math.min(paramArrayOfChar.length, paramInt));
    return arrayOfChar;
  }
  
  public static char[] ensureCapacity(char[] paramArrayOfChar, int paramInt1, int paramInt2)
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
      char[] arrayOfChar = paramArrayOfChar;
      if (paramArrayOfChar.length < paramInt1) {
        arrayOfChar = copyOf(paramArrayOfChar, paramInt1 + paramInt2);
      }
      return arrayOfChar;
      bool = false;
      break;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static char fromByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "array too small: %s < %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(2) });
      return fromBytes(paramArrayOfByte[0], paramArrayOfByte[1]);
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static char fromBytes(byte paramByte1, byte paramByte2)
  {
    return (char)(paramByte1 << 8 | paramByte2 & 0xFF);
  }
  
  public static int hashCode(char paramChar)
  {
    return paramChar;
  }
  
  public static int indexOf(char[] paramArrayOfChar, char paramChar)
  {
    return indexOf(paramArrayOfChar, paramChar, 0, paramArrayOfChar.length);
  }
  
  private static int indexOf(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfChar[paramInt1] == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    Preconditions.checkNotNull(paramArrayOfChar1, "array");
    Preconditions.checkNotNull(paramArrayOfChar2, "target");
    int j;
    if (paramArrayOfChar2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfChar1.length - paramArrayOfChar2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfChar2.length) {
          break;
        }
        if (paramArrayOfChar1[(i + k)] != paramArrayOfChar2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static String join(String paramString, char... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    int j = paramVarArgs.length;
    if (j == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() * (j - 1) + j);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(char[] paramArrayOfChar, char paramChar)
  {
    return lastIndexOf(paramArrayOfChar, paramChar, 0, paramArrayOfChar.length);
  }
  
  private static int lastIndexOf(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfChar[paramInt2] == paramChar) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<char[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static char max(char... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    char c1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      c1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        char c2 = c1;
        if (paramVarArgs[i] > c1) {
          c2 = paramVarArgs[i];
        }
        i += 1;
        c1 = c2;
      }
    }
    return c1;
  }
  
  public static char min(char... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    char c1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      c1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        char c2 = c1;
        if (paramVarArgs[i] < c1) {
          c2 = paramVarArgs[i];
        }
        i += 1;
        c1 = c2;
      }
    }
    return c1;
  }
  
  public static char saturatedCast(long paramLong)
  {
    if (paramLong > 65535L) {
      return 65535;
    }
    if (paramLong < 0L) {
      return '\000';
    }
    return (char)(int)paramLong;
  }
  
  public static char[] toArray(Collection<Character> paramCollection)
  {
    if ((paramCollection instanceof CharArrayAsList))
    {
      paramCollection = ((CharArrayAsList)paramCollection).toCharArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfChar;
      if (i >= j) {
        break;
      }
      arrayOfChar[i] = ((Character)Preconditions.checkNotNull(arrayOfObject[i])).charValue();
      i += 1;
    }
  }
  
  @GwtIncompatible("doesn't work")
  public static byte[] toByteArray(char paramChar)
  {
    return new byte[] { (byte)(paramChar >> '\b'), (byte)paramChar };
  }
  
  @GwtCompatible
  private static class CharArrayAsList
    extends AbstractList<Character>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final char[] array;
    final int end;
    final int start;
    
    CharArrayAsList(char[] paramArrayOfChar)
    {
      this(paramArrayOfChar, 0, paramArrayOfChar.length);
    }
    
    CharArrayAsList(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfChar;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Character)) && (Chars.indexOf(this.array, ((Character)paramObject).charValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof CharArrayAsList)) {
          break;
        }
        paramObject = (CharArrayAsList)paramObject;
        int j = size();
        if (((CharArrayAsList)paramObject).size() != j) {
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
    
    public Character get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Character.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Chars.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Character))
      {
        int i = Chars.indexOf(this.array, ((Character)paramObject).charValue(), this.start, this.end);
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
      if ((paramObject instanceof Character))
      {
        int i = Chars.lastIndexOf(this.array, ((Character)paramObject).charValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Character set(int paramInt, Character paramCharacter)
    {
      Preconditions.checkElementIndex(paramInt, size());
      char c = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Character)Preconditions.checkNotNull(paramCharacter)).charValue();
      return Character.valueOf(c);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Character> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new CharArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    char[] toCharArray()
    {
      int i = size();
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.array, this.start, arrayOfChar, 0, i);
      return arrayOfChar;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 3);
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
  
  private static enum LexicographicalComparator
    implements Comparator<char[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
    {
      int j = Math.min(paramArrayOfChar1.length, paramArrayOfChar2.length);
      int i = 0;
      while (i < j)
      {
        int k = Chars.compare(paramArrayOfChar1[i], paramArrayOfChar2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfChar1.length - paramArrayOfChar2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Chars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */