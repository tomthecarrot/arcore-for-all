package io.grpc.internal;

import io.grpc.Compressor;
import io.grpc.Decompressor;
import java.io.InputStream;

public abstract interface Stream
{
  public abstract void flush();
  
  public abstract boolean isReady();
  
  public abstract void request(int paramInt);
  
  public abstract void setCompressor(Compressor paramCompressor);
  
  public abstract void setDecompressor(Decompressor paramDecompressor);
  
  public abstract void setMessageCompression(boolean paramBoolean);
  
  public abstract void writeMessage(InputStream paramInputStream);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/Stream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */