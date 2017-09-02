package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsafeUtil
{
  private static final long ARRAY_BASE_OFFSET = byteArrayBaseOffset();
  private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  private static final Unsafe UNSAFE = ;
  
  static
  {
    HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
  }
  
  static long addressOffset(ByteBuffer paramByteBuffer)
  {
    return UNSAFE.getLong(paramByteBuffer, BUFFER_ADDRESS_OFFSET);
  }
  
  private static int byteArrayBaseOffset()
  {
    if (HAS_UNSAFE_ARRAY_OPERATIONS) {
      return UNSAFE.arrayBaseOffset(byte[].class);
    }
    return -1;
  }
  
  static void copyMemory(long paramLong1, long paramLong2, long paramLong3)
  {
    UNSAFE.copyMemory(paramLong1, paramLong2, paramLong3);
  }
  
  static void copyMemory(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3)
  {
    UNSAFE.copyMemory(paramArrayOfByte1, paramLong1, paramArrayOfByte2, paramLong2, paramLong3);
  }
  
  private static Field field(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  private static long fieldOffset(Field paramField)
  {
    if ((paramField == null) || (UNSAFE == null)) {
      return -1L;
    }
    return UNSAFE.objectFieldOffset(paramField);
  }
  
  static long getArrayBaseOffset()
  {
    return ARRAY_BASE_OFFSET;
  }
  
  static byte getByte(long paramLong)
  {
    return UNSAFE.getByte(paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfByte, long paramLong)
  {
    return UNSAFE.getByte(paramArrayOfByte, paramLong);
  }
  
  static long getLong(long paramLong)
  {
    return UNSAFE.getLong(paramLong);
  }
  
  static long getLong(byte[] paramArrayOfByte, long paramLong)
  {
    return UNSAFE.getLong(paramArrayOfByte, paramLong);
  }
  
  private static Unsafe getUnsafe()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction()
      {
        public Unsafe run()
          throws Exception
        {
          Object localObject2 = null;
          Field[] arrayOfField = Unsafe.class.getDeclaredFields();
          int j = arrayOfField.length;
          int i = 0;
          for (;;)
          {
            Object localObject1 = localObject2;
            if (i < j)
            {
              localObject1 = arrayOfField[i];
              ((Field)localObject1).setAccessible(true);
              localObject1 = ((Field)localObject1).get(null);
              if (Unsafe.class.isInstance(localObject1)) {
                localObject1 = (Unsafe)Unsafe.class.cast(localObject1);
              }
            }
            else
            {
              return (Unsafe)localObject1;
            }
            i += 1;
          }
        }
      });
      return localUnsafe;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  static boolean hasUnsafeArrayOperations()
  {
    return HAS_UNSAFE_ARRAY_OPERATIONS;
  }
  
  static boolean hasUnsafeByteBufferOperations()
  {
    return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  }
  
  static void putByte(long paramLong, byte paramByte)
  {
    UNSAFE.putByte(paramLong, paramByte);
  }
  
  static void putByte(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    UNSAFE.putByte(paramArrayOfByte, paramLong, paramByte);
  }
  
  private static boolean supportsUnsafeArrayOperations()
  {
    boolean bool = false;
    if (UNSAFE != null) {}
    try
    {
      Class localClass = UNSAFE.getClass();
      localClass.getMethod("arrayBaseOffset", new Class[] { Class.class });
      localClass.getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
      bool = true;
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  private static boolean supportsUnsafeByteBufferOperations()
  {
    boolean bool = false;
    if (UNSAFE != null) {}
    try
    {
      Class localClass = UNSAFE.getClass();
      localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
      localClass.getMethod("getByte", new Class[] { Long.TYPE });
      localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
      localClass.getMethod("getLong", new Class[] { Long.TYPE });
      localClass.getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
      bool = true;
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/UnsafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */