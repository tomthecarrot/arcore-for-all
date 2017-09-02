package io.grpc.internal;

public abstract interface WritableBuffer
{
  public abstract int readableBytes();
  
  public abstract void release();
  
  public abstract int writableBytes();
  
  public abstract void write(byte paramByte);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/WritableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */