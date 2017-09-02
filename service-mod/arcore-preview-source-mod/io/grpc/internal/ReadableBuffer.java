package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract interface ReadableBuffer
  extends Closeable
{
  public abstract byte[] array();
  
  public abstract int arrayOffset();
  
  public abstract void close();
  
  public abstract boolean hasArray();
  
  public abstract ReadableBuffer readBytes(int paramInt);
  
  public abstract void readBytes(OutputStream paramOutputStream, int paramInt)
    throws IOException;
  
  public abstract void readBytes(ByteBuffer paramByteBuffer);
  
  public abstract void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int readInt();
  
  public abstract int readUnsignedByte();
  
  public abstract int readUnsignedMedium();
  
  public abstract int readUnsignedShort();
  
  public abstract int readableBytes();
  
  public abstract void skipBytes(int paramInt);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/ReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */