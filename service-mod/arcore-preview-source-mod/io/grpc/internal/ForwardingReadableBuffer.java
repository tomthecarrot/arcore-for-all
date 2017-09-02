package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract class ForwardingReadableBuffer
  implements ReadableBuffer
{
  private final ReadableBuffer buf;
  
  public ForwardingReadableBuffer(ReadableBuffer paramReadableBuffer)
  {
    this.buf = ((ReadableBuffer)Preconditions.checkNotNull(paramReadableBuffer, "buf"));
  }
  
  public byte[] array()
  {
    return this.buf.array();
  }
  
  public int arrayOffset()
  {
    return this.buf.arrayOffset();
  }
  
  public void close()
  {
    this.buf.close();
  }
  
  public boolean hasArray()
  {
    return this.buf.hasArray();
  }
  
  public ReadableBuffer readBytes(int paramInt)
  {
    return this.buf.readBytes(paramInt);
  }
  
  public void readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    this.buf.readBytes(paramOutputStream, paramInt);
  }
  
  public void readBytes(ByteBuffer paramByteBuffer)
  {
    this.buf.readBytes(paramByteBuffer);
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buf.readBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int readInt()
  {
    return this.buf.readInt();
  }
  
  public int readUnsignedByte()
  {
    return this.buf.readUnsignedByte();
  }
  
  public int readUnsignedMedium()
  {
    return this.buf.readUnsignedMedium();
  }
  
  public int readUnsignedShort()
  {
    return this.buf.readUnsignedShort();
  }
  
  public int readableBytes()
  {
    return this.buf.readableBytes();
  }
  
  public void skipBytes(int paramInt)
  {
    this.buf.skipBytes(paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ForwardingReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */