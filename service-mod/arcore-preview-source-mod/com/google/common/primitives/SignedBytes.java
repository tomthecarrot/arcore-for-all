package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class SignedBytes
{
  public static final byte MAX_POWER_OF_TWO = 64;
  
  public static byte checkedCast(long paramLong)
  {
    byte b = (byte)(int)paramLong;
    if (b != paramLong) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return b;
  }
  
  public static int compare(byte paramByte1, byte paramByte2)
  {
    return paramByte1 - paramByte2;
  }
  
  public static String join(String paramString, byte... paramVarArgs)
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
  
  public static Comparator<byte[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static byte max(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      b1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        byte b2 = b1;
        if (paramVarArgs[i] > b1) {
          b2 = paramVarArgs[i];
        }
        i += 1;
        b1 = b2;
      }
    }
    return b1;
  }
  
  public static byte min(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      b1 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        byte b2 = b1;
        if (paramVarArgs[i] < b1) {
          b2 = paramVarArgs[i];
        }
        i += 1;
        b1 = b2;
      }
    }
    return b1;
  }
  
  public static byte saturatedCast(long paramLong)
  {
    if (paramLong > 127L) {
      return Byte.MAX_VALUE;
    }
    if (paramLong < -128L) {
      return Byte.MIN_VALUE;
    }
    return (byte)(int)paramLong;
  }
  
  private static enum LexicographicalComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
      int i = 0;
      while (i < j)
      {
        int k = SignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfByte1.length - paramArrayOfByte2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/SignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */