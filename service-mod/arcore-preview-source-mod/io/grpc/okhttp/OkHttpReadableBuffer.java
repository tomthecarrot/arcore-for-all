package io.grpc.okhttp;

import io.grpc.internal.AbstractReadableBuffer;
import io.grpc.internal.ReadableBuffer;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;

class OkHttpReadableBuffer
  extends AbstractReadableBuffer
{
  private final Buffer buffer;
  
  OkHttpReadableBuffer(Buffer paramBuffer)
  {
    this.buffer = paramBuffer;
  }
  
  public void close()
  {
    this.buffer.clear();
  }
  
  public ReadableBuffer readBytes(int paramInt)
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.buffer, paramInt);
    return new OkHttpReadableBuffer(localBuffer);
  }
  
  public void readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    this.buffer.writeTo(paramOutputStream, paramInt);
  }
  
  public void readBytes(ByteBuffer paramByteBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      int i = this.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i == -1) {
        throw new IndexOutOfBoundsException("EOF trying to read " + paramInt2 + " bytes");
      }
      paramInt2 -= i;
      paramInt1 += i;
    }
  }
  
  public int readUnsignedByte()
  {
    return this.buffer.readByte() & 0xFF;
  }
  
  public int readableBytes()
  {
    return (int)this.buffer.size();
  }
  
  public void skipBytes(int paramInt)
  {
    try
    {
      this.buffer.skip(paramInt);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new IndexOutOfBoundsException(localEOFException.getMessage());
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/OkHttpReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */