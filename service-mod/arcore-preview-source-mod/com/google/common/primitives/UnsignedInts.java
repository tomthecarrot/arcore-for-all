package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedInts
{
  static final long INT_MASK = 4294967295L;
  
  @CheckReturnValue
  public static int compare(int paramInt1, int paramInt2)
  {
    return Ints.compare(flip(paramInt1), flip(paramInt2));
  }
  
  public static int decode(String paramString)
  {
    ParseRequest localParseRequest = ParseRequest.fromString(paramString);
    try
    {
      int i = parseUnsignedInt(localParseRequest.rawValue, localParseRequest.radix);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new NumberFormatException("Error parsing value: " + paramString);
      paramString.initCause(localNumberFormatException);
      throw paramString;
    }
  }
  
  @CheckReturnValue
  public static int divide(int paramInt1, int paramInt2)
  {
    return (int)(toLong(paramInt1) / toLong(paramInt2));
  }
  
  static int flip(int paramInt)
  {
    return 0x80000000 ^ paramInt;
  }
  
  @CheckReturnValue
  public static String join(String paramString, int... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
    localStringBuilder.append(toString(paramVarArgs[0]));
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(toString(paramVarArgs[i]));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  @CheckReturnValue
  public static Comparator<int[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  @CheckReturnValue
  public static int max(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = flip(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int m = flip(paramVarArgs[i]);
        int k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
        j = k;
      }
    }
    return flip(j);
  }
  
  @CheckReturnValue
  public static int min(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = flip(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int m = flip(paramVarArgs[i]);
        int k = j;
        if (m < j) {
          k = m;
        }
        i += 1;
        j = k;
      }
    }
    return flip(j);
  }
  
  public static int parseUnsignedInt(String paramString)
  {
    return parseUnsignedInt(paramString, 10);
  }
  
  public static int parseUnsignedInt(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    long l = Long.parseLong(paramString, paramInt);
    if ((0xFFFFFFFF & l) != l) {
      throw new NumberFormatException("Input " + paramString + " in base " + paramInt + " is not in the range of an unsigned integer");
    }
    return (int)l;
  }
  
  @CheckReturnValue
  public static int remainder(int paramInt1, int paramInt2)
  {
    return (int)(toLong(paramInt1) % toLong(paramInt2));
  }
  
  @CheckReturnValue
  public static long toLong(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  @CheckReturnValue
  public static String toString(int paramInt)
  {
    return toString(paramInt, 10);
  }
  
  @CheckReturnValue
  public static String toString(int paramInt1, int paramInt2)
  {
    return Long.toString(paramInt1 & 0xFFFFFFFF, paramInt2);
  }
  
  static enum LexicographicalComparator
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
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return UnsignedInts.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        }
        i += 1;
      }
      return paramArrayOfInt1.length - paramArrayOfInt2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/UnsignedInts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */