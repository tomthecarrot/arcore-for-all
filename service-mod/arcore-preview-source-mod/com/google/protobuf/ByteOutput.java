package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class ByteOutput
{
  public abstract void write(byte paramByte)
    throws IOException;
  
  public abstract void write(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeLazy(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void writeLazy(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/ByteOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */