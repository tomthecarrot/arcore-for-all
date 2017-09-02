package io.grpc.internal;

public abstract class AbstractReadableBuffer
  implements ReadableBuffer
{
  public byte[] array()
  {
    throw new UnsupportedOperationException();
  }
  
  public int arrayOffset()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final void checkReadable(int paramInt)
  {
    if (readableBytes() < paramInt) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public void close() {}
  
  public boolean hasArray()
  {
    return false;
  }
  
  public final int readInt()
  {
    checkReadable(4);
    return readUnsignedByte() << 24 | readUnsignedByte() << 16 | readUnsignedByte() << 8 | readUnsignedByte();
  }
  
  public final int readUnsignedMedium()
  {
    checkReadable(3);
    return readUnsignedByte() << 16 | readUnsignedByte() << 8 | readUnsignedByte();
  }
  
  public final int readUnsignedShort()
  {
    checkReadable(2);
    return readUnsignedByte() << 8 | readUnsignedByte();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/AbstractReadableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */