package com.google.protobuf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

final class ByteBufferWriter
{
  private static final ThreadLocal<SoftReference<byte[]>> BUFFER = new ThreadLocal();
  private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5F;
  private static final int MAX_CACHED_BUFFER_SIZE = 16384;
  private static final int MIN_CACHED_BUFFER_SIZE = 1024;
  
  static void clearCachedBuffer()
  {
    BUFFER.set(null);
  }
  
  private static byte[] getBuffer()
  {
    SoftReference localSoftReference = (SoftReference)BUFFER.get();
    if (localSoftReference == null) {
      return null;
    }
    return (byte[])localSoftReference.get();
  }
  
  private static byte[] getOrCreateBuffer(int paramInt)
  {
    paramInt = Math.max(paramInt, 1024);
    byte[] arrayOfByte2 = getBuffer();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (!needToReallocate(paramInt, arrayOfByte2.length)) {}
    }
    else
    {
      arrayOfByte2 = new byte[paramInt];
      arrayOfByte1 = arrayOfByte2;
      if (paramInt <= 16384)
      {
        setBuffer(arrayOfByte2);
        arrayOfByte1 = arrayOfByte2;
      }
    }
    return arrayOfByte1;
  }
  
  private static boolean needToReallocate(int paramInt1, int paramInt2)
  {
    return (paramInt2 < paramInt1) && (paramInt2 < paramInt1 * 0.5F);
  }
  
  private static void setBuffer(byte[] paramArrayOfByte)
  {
    BUFFER.set(new SoftReference(paramArrayOfByte));
  }
  
  static void write(ByteBuffer paramByteBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramByteBuffer.position();
    for (;;)
    {
      try
      {
        if (paramByteBuffer.hasArray())
        {
          paramOutputStream.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
          return;
        }
        if ((paramOutputStream instanceof FileOutputStream))
        {
          ((FileOutputStream)paramOutputStream).getChannel().write(paramByteBuffer);
          continue;
        }
        arrayOfByte = getOrCreateBuffer(paramByteBuffer.remaining());
      }
      finally
      {
        paramByteBuffer.position(i);
      }
      byte[] arrayOfByte;
      while (paramByteBuffer.hasRemaining())
      {
        int j = Math.min(paramByteBuffer.remaining(), arrayOfByte.length);
        paramByteBuffer.get(arrayOfByte, 0, j);
        paramOutputStream.write(arrayOfByte, 0, j);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ByteBufferWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */