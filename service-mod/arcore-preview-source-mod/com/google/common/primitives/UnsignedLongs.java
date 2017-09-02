package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedLongs
{
  public static final long MAX_VALUE = -1L;
  private static final int[] maxSafeDigits;
  private static final long[] maxValueDivs = new long[37];
  private static final int[] maxValueMods = new int[37];
  
  static
  {
    maxSafeDigits = new int[37];
    BigInteger localBigInteger = new BigInteger("10000000000000000", 16);
    int i = 2;
    while (i <= 36)
    {
      maxValueDivs[i] = divide(-1L, i);
      maxValueMods[i] = ((int)remainder(-1L, i));
      maxSafeDigits[i] = (localBigInteger.toString(i).length() - 1);
      i += 1;
    }
  }
  
  @CheckReturnValue
  public static int compare(long paramLong1, long paramLong2)
  {
    return Longs.compare(flip(paramLong1), flip(paramLong2));
  }
  
  public static long decode(String paramString)
  {
    ParseRequest localParseRequest = ParseRequest.fromString(paramString);
    try
    {
      long l = parseUnsignedLong(localParseRequest.rawValue, localParseRequest.radix);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new NumberFormatException("Error parsing value: " + paramString);
      paramString.initCause(localNumberFormatException);
      throw paramString;
    }
  }
  
  @CheckReturnValue
  public static long divide(long paramLong1, long paramLong2)
  {
    int i = 1;
    if (paramLong2 < 0L)
    {
      if (compare(paramLong1, paramLong2) < 0) {
        return 0L;
      }
      return 1L;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 / paramLong2;
    }
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (compare(paramLong1 - l * paramLong2, paramLong2) >= 0) {}
    for (;;)
    {
      return i + l;
      i = 0;
    }
  }
  
  private static long flip(long paramLong)
  {
    return 0x8000000000000000 ^ paramLong;
  }
  
  @CheckReturnValue
  public static String join(String paramString, long... paramVarArgs)
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
  public static Comparator<long[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  @CheckReturnValue
  public static long max(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l1 = flip(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l3 = flip(paramVarArgs[i]);
        long l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
        l1 = l2;
      }
    }
    return flip(l1);
  }
  
  @CheckReturnValue
  public static long min(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l1 = flip(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l3 = flip(paramVarArgs[i]);
        long l2 = l1;
        if (l3 < l1) {
          l2 = l3;
        }
        i += 1;
        l1 = l2;
      }
    }
    return flip(l1);
  }
  
  private static boolean overflowInParse(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      if (paramLong >= maxValueDivs[paramInt2]) {
        break label29;
      }
      bool1 = false;
    }
    label29:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLong > maxValueDivs[paramInt2]);
      bool1 = bool2;
    } while (paramInt1 > maxValueMods[paramInt2]);
    return false;
  }
  
  public static long parseUnsignedLong(String paramString)
  {
    return parseUnsignedLong(paramString, 10);
  }
  
  public static long parseUnsignedLong(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() == 0) {
      throw new NumberFormatException("empty string");
    }
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new NumberFormatException("illegal radix: " + paramInt);
    }
    int j = maxSafeDigits[paramInt];
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      int k = Character.digit(paramString.charAt(i), paramInt);
      if (k == -1) {
        throw new NumberFormatException(paramString);
      }
      if ((i > j - 1) && (overflowInParse(l, k, paramInt))) {
        throw new NumberFormatException("Too large for unsigned long: " + paramString);
      }
      l = paramInt * l + k;
      i += 1;
    }
    return l;
  }
  
  @CheckReturnValue
  public static long remainder(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (compare(paramLong1, paramLong2) < 0) {
        return paramLong1;
      }
      return paramLong1 - paramLong2;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    paramLong1 -= ((paramLong1 >>> 1) / paramLong2 << 1) * paramLong2;
    if (compare(paramLong1, paramLong2) >= 0) {}
    for (;;)
    {
      return paramLong1 - paramLong2;
      paramLong2 = 0L;
    }
  }
  
  @CheckReturnValue
  public static String toString(long paramLong)
  {
    return toString(paramLong, 10);
  }
  
  @CheckReturnValue
  public static String toString(long paramLong, int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 36)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[] { Integer.valueOf(paramInt) });
      if (paramLong != 0L) {
        break;
      }
      return "0";
    }
    char[] arrayOfChar = new char[64];
    int j = arrayOfChar.length;
    int i = j;
    long l1 = paramLong;
    if (paramLong < 0L)
    {
      l1 = divide(paramLong, paramInt);
      long l2 = paramInt;
      i = j - 1;
      arrayOfChar[i] = Character.forDigit((int)(paramLong - l2 * l1), paramInt);
    }
    while (l1 > 0L)
    {
      i -= 1;
      arrayOfChar[i] = Character.forDigit((int)(l1 % paramInt), paramInt);
      l1 /= paramInt;
    }
    return new String(arrayOfChar, i, arrayOfChar.length - i);
  }
  
  static enum LexicographicalComparator
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
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
          return UnsignedLongs.compare(paramArrayOfLong1[i], paramArrayOfLong2[i]);
        }
        i += 1;
      }
      return paramArrayOfLong1.length - paramArrayOfLong2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/UnsignedLongs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */