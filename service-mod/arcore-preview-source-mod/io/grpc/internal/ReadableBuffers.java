package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.KnownLength;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ReadableBuffers
{
  private static final ReadableBuffer EMPTY_BUFFER = new ByteArrayWrapper(new byte[0]);
  
  public static ReadableBuffer empty()
  {
    return EMPTY_BUFFER;
  }
  
  public static ReadableBuffer ignoreClose(ReadableBuffer paramReadableBuffer)
  {
    new ForwardingReadableBuffer(paramReadableBuffer)
    {
      public void close() {}
    };
  }
  
  public static InputStream openStream(ReadableBuffer paramReadableBuffer, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      return new BufferInputStream(paramReadableBuffer);
      paramReadableBuffer = ignoreClose(paramReadableBuffer);
    }
  }
  
  public static byte[] readArray(ReadableBuffer paramReadableBuffer)
  {
    Preconditions.checkNotNull(paramReadableBuffer, "buffer");
    int i = paramReadableBuffer.readableBytes();
    byte[] arrayOfByte = new byte[i];
    paramReadableBuffer.readBytes(arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static String readAsString(ReadableBuffer paramReadableBuffer, Charset paramCharset)
  {
    Preconditions.checkNotNull(paramCharset, "charset");
    return new String(readArray(paramReadableBuffer), paramCharset);
  }
  
  public static String readAsStringUtf8(ReadableBuffer paramReadableBuffer)
  {
    return readAsString(paramReadableBuffer, Charsets.UTF_8);
  }
  
  public static ReadableBuffer wrap(ByteBuffer paramByteBuffer)
  {
    return new ByteReadableBufferWrapper(paramByteBuffer);
  }
  
  public static ReadableBuffer wrap(byte[] paramArrayOfByte)
  {
    return new ByteArrayWrapper(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ReadableBuffer wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteArrayWrapper(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static final class BufferInputStream
    extends InputStream
    implements KnownLength
  {
    final ReadableBuffer buffer;
    
    public BufferInputStream(ReadableBuffer paramReadableBuffer)
    {
      this.buffer = ((ReadableBuffer)Preconditions.checkNotNull(paramReadableBuffer, "buffer"));
    }
    
    public int available()
      throws IOException
    {
      return this.buffer.readableBytes();
    }
    
    public int read()
    {
      if (this.buffer.readableBytes() == 0) {
        return -1;
      }
      return this.buffer.readUnsignedByte();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.buffer.readableBytes() == 0) {
        return -1;
      }
      paramInt2 = Math.min(this.buffer.readableBytes(), paramInt2);
      this.buffer.readBytes(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt2;
    }
  }
  
  private static class ByteArrayWrapper
    extends AbstractReadableBuffer
  {
    final byte[] bytes;
    final int end;
    int offset;
    
    ByteArrayWrapper(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayWrapper(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramInt1 >= 0)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "offset must be >= 0");
        if (paramInt2 < 0) {
          break label86;
        }
        bool1 = true;
        label28:
        Preconditions.checkArgument(bool1, "length must be >= 0");
        if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
          break label92;
        }
      }
      label86:
      label92:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "offset + length exceeds array boundary");
        this.bytes = ((byte[])Preconditions.checkNotNull(paramArrayOfByte, "bytes"));
        this.offset = paramInt1;
        this.end = (paramInt1 + paramInt2);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label28;
      }
    }
    
    public byte[] array()
    {
      return this.bytes;
    }
    
    public int arrayOffset()
    {
      return this.offset;
    }
    
    public boolean hasArray()
    {
      return true;
    }
    
    public ByteArrayWrapper readBytes(int paramInt)
    {
      checkReadable(paramInt);
      int i = this.offset;
      this.offset += paramInt;
      return new ByteArrayWrapper(this.bytes, i, paramInt);
    }
    
    public void readBytes(OutputStream paramOutputStream, int paramInt)
      throws IOException
    {
      checkReadable(paramInt);
      paramOutputStream.write(this.bytes, this.offset, paramInt);
      this.offset += paramInt;
    }
    
    public void readBytes(ByteBuffer paramByteBuffer)
    {
      Preconditions.checkNotNull(paramByteBuffer, "dest");
      int i = paramByteBuffer.remaining();
      checkReadable(i);
      paramByteBuffer.put(this.bytes, this.offset, i);
      this.offset += i;
    }
    
    public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      System.arraycopy(this.bytes, this.offset, paramArrayOfByte, paramInt1, paramInt2);
      this.offset += paramInt2;
    }
    
    public int readUnsignedByte()
    {
      checkReadable(1);
      byte[] arrayOfByte = this.bytes;
      int i = this.offset;
      this.offset = (i + 1);
      return arrayOfByte[i] & 0xFF;
    }
    
    public int readableBytes()
    {
      return this.end - this.offset;
    }
    
    public void skipBytes(int paramInt)
    {
      checkReadable(paramInt);
      this.offset += paramInt;
    }
  }
  
  private static class ByteReadableBufferWrapper
    extends AbstractReadableBuffer
  {
    final ByteBuffer bytes;
    
    ByteReadableBufferWrapper(ByteBuffer paramByteBuffer)
    {
      this.bytes = ((ByteBuffer)Preconditions.checkNotNull(paramByteBuffer, "bytes"));
    }
    
    public byte[] array()
    {
      return this.bytes.array();
    }
    
    public int arrayOffset()
    {
      return this.bytes.arrayOffset() + this.bytes.position();
    }
    
    public boolean hasArray()
    {
      return this.bytes.hasArray();
    }
    
    public ByteReadableBufferWrapper readBytes(int paramInt)
    {
      checkReadable(paramInt);
      ByteBuffer localByteBuffer = this.bytes.duplicate();
      localByteBuffer.limit(this.bytes.position() + paramInt);
      this.bytes.position(this.bytes.position() + paramInt);
      return new ByteReadableBufferWrapper(localByteBuffer);
    }
    
    public void readBytes(OutputStream paramOutputStream, int paramInt)
      throws IOException
    {
      checkReadable(paramInt);
      if (hasArray())
      {
        paramOutputStream.write(array(), arrayOffset(), paramInt);
        this.bytes.position(this.bytes.position() + paramInt);
        return;
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.bytes.get(arrayOfByte);
      paramOutputStream.write(arrayOfByte);
    }
    
    public void readBytes(ByteBuffer paramByteBuffer)
    {
      Preconditions.checkNotNull(paramByteBuffer, "dest");
      int i = paramByteBuffer.remaining();
      checkReadable(i);
      int j = this.bytes.limit();
      this.bytes.limit(this.bytes.position() + i);
      paramByteBuffer.put(this.bytes);
      this.bytes.limit(j);
    }
    
    public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      checkReadable(paramInt2);
      this.bytes.get(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public int readUnsignedByte()
    {
      checkReadable(1);
      return this.bytes.get() & 0xFF;
    }
    
    public int readableBytes()
    {
      return this.bytes.remaining();
    }
    
    public void skipBytes(int paramInt)
    {
      checkReadable(paramInt);
      this.bytes.position(this.bytes.position() + paramInt);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ReadableBuffers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */