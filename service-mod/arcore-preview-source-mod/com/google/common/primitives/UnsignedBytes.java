package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;
import sun.misc.Unsafe;

public final class UnsignedBytes
{
  public static final byte MAX_POWER_OF_TWO = -128;
  public static final byte MAX_VALUE = -1;
  private static final int UNSIGNED_MASK = 255;
  
  public static byte checkedCast(long paramLong)
  {
    if (paramLong >> 8 != 0L) {
      throw new IllegalArgumentException("Out of range: " + paramLong);
    }
    return (byte)(int)paramLong;
  }
  
  @CheckReturnValue
  public static int compare(byte paramByte1, byte paramByte2)
  {
    return toInt(paramByte1) - toInt(paramByte2);
  }
  
  @CheckReturnValue
  public static String join(String paramString, byte... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * (paramString.length() + 3));
    localStringBuilder.append(toInt(paramVarArgs[0]));
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(toString(paramVarArgs[i]));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  @CheckReturnValue
  public static Comparator<byte[]> lexicographicalComparator()
  {
    return LexicographicalComparatorHolder.BEST_COMPARATOR;
  }
  
  @VisibleForTesting
  static Comparator<byte[]> lexicographicalComparatorJavaImpl()
  {
    return UnsignedBytes.LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
  }
  
  @CheckReturnValue
  public static byte max(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = toInt(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int m = toInt(paramVarArgs[i]);
        int k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
        j = k;
      }
    }
    return (byte)j;
  }
  
  @CheckReturnValue
  public static byte min(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = toInt(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        int m = toInt(paramVarArgs[i]);
        int k = j;
        if (m < j) {
          k = m;
        }
        i += 1;
        j = k;
      }
    }
    return (byte)j;
  }
  
  @Beta
  public static byte parseUnsignedByte(String paramString)
  {
    return parseUnsignedByte(paramString, 10);
  }
  
  @Beta
  public static byte parseUnsignedByte(String paramString, int paramInt)
  {
    paramInt = Integer.parseInt((String)Preconditions.checkNotNull(paramString), paramInt);
    if (paramInt >> 8 == 0) {
      return (byte)paramInt;
    }
    throw new NumberFormatException("out of range: " + paramInt);
  }
  
  public static byte saturatedCast(long paramLong)
  {
    if (paramLong > toInt((byte)-1)) {
      return -1;
    }
    if (paramLong < 0L) {
      return 0;
    }
    return (byte)(int)paramLong;
  }
  
  @CheckReturnValue
  public static int toInt(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  @CheckReturnValue
  @Beta
  public static String toString(byte paramByte)
  {
    return toString(paramByte, 10);
  }
  
  @CheckReturnValue
  @Beta
  public static String toString(byte paramByte, int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 36)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[] { Integer.valueOf(paramInt) });
      return Integer.toString(toInt(paramByte), paramInt);
    }
  }
  
  @VisibleForTesting
  static class LexicographicalComparatorHolder
  {
    static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();
    static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
    
    static Comparator<byte[]> getBestComparator()
    {
      try
      {
        Comparator localComparator = (Comparator)Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
        return localComparator;
      }
      catch (Throwable localThrowable) {}
      return UnsignedBytes.lexicographicalComparatorJavaImpl();
    }
    
    static enum PureJavaComparator
      implements Comparator<byte[]>
    {
      INSTANCE;
      
      private PureJavaComparator() {}
      
      public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      {
        int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
        int i = 0;
        while (i < j)
        {
          int k = UnsignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
          if (k != 0) {
            return k;
          }
          i += 1;
        }
        return paramArrayOfByte1.length - paramArrayOfByte2.length;
      }
    }
    
    @VisibleForTesting
    static enum UnsafeComparator
      implements Comparator<byte[]>
    {
      static final boolean BIG_ENDIAN;
      static final int BYTE_ARRAY_BASE_OFFSET;
      static final Unsafe theUnsafe;
      
      static
      {
        $VALUES = new UnsafeComparator[] { INSTANCE };
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        theUnsafe = getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
          throw new AssertionError();
        }
      }
      
      private UnsafeComparator() {}
      
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
      
      public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      {
        int m = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
        int j = m / 8;
        int i = 0;
        while (i < j * 8)
        {
          long l1 = theUnsafe.getLong(paramArrayOfByte1, BYTE_ARRAY_BASE_OFFSET + i);
          long l2 = theUnsafe.getLong(paramArrayOfByte2, BYTE_ARRAY_BASE_OFFSET + i);
          if (l1 != l2)
          {
            if (BIG_ENDIAN)
            {
              i = UnsignedLongs.compare(l1, l2);
              return i;
            }
            i = Long.numberOfTrailingZeros(l1 ^ l2) & 0xFFFFFFF8;
            return (int)((l1 >>> i & 0xFF) - (l2 >>> i & 0xFF));
          }
          i += 8;
        }
        j *= 8;
        for (;;)
        {
          if (j >= m) {
            break label166;
          }
          int k = UnsignedBytes.compare(paramArrayOfByte1[j], paramArrayOfByte2[j]);
          i = k;
          if (k != 0) {
            break;
          }
          j += 1;
        }
        label166:
        return paramArrayOfByte1.length - paramArrayOfByte2.length;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/UnsignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */