package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

abstract class AbstractNonStreamingHashFunction
  implements HashFunction
{
  public HashCode hashBytes(byte[] paramArrayOfByte)
  {
    return hashBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public HashCode hashInt(int paramInt)
  {
    return newHasher(4).putInt(paramInt).hash();
  }
  
  public HashCode hashLong(long paramLong)
  {
    return newHasher(8).putLong(paramLong).hash();
  }
  
  public <T> HashCode hashObject(T paramT, Funnel<? super T> paramFunnel)
  {
    return newHasher().putObject(paramT, paramFunnel).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence, Charset paramCharset)
  {
    return hashBytes(paramCharSequence.toString().getBytes(paramCharset));
  }
  
  public HashCode hashUnencodedChars(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    Hasher localHasher = newHasher(j * 2);
    int i = 0;
    while (i < j)
    {
      localHasher.putChar(paramCharSequence.charAt(i));
      i += 1;
    }
    return localHasher.hash();
  }
  
  public Hasher newHasher()
  {
    return new BufferingHasher(32);
  }
  
  public Hasher newHasher(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new BufferingHasher(paramInt);
    }
  }
  
  private final class BufferingHasher
    extends AbstractHasher
  {
    static final int BOTTOM_BYTE = 255;
    final AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream stream;
    
    BufferingHasher(int paramInt)
    {
      this.stream = new AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(paramInt);
    }
    
    public HashCode hash()
    {
      return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
    }
    
    public Hasher putByte(byte paramByte)
    {
      this.stream.write(paramByte);
      return this;
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte)
    {
      try
      {
        this.stream.write(paramArrayOfByte);
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.stream.write(paramArrayOfByte, paramInt1, paramInt2);
      return this;
    }
    
    public Hasher putChar(char paramChar)
    {
      this.stream.write(paramChar & 0xFF);
      this.stream.write(paramChar >>> '\b' & 0xFF);
      return this;
    }
    
    public Hasher putInt(int paramInt)
    {
      this.stream.write(paramInt & 0xFF);
      this.stream.write(paramInt >>> 8 & 0xFF);
      this.stream.write(paramInt >>> 16 & 0xFF);
      this.stream.write(paramInt >>> 24 & 0xFF);
      return this;
    }
    
    public Hasher putLong(long paramLong)
    {
      int i = 0;
      while (i < 64)
      {
        this.stream.write((byte)(int)(paramLong >>> i & 0xFF));
        i += 8;
      }
      return this;
    }
    
    public <T> Hasher putObject(T paramT, Funnel<? super T> paramFunnel)
    {
      paramFunnel.funnel(paramT, this);
      return this;
    }
    
    public Hasher putShort(short paramShort)
    {
      this.stream.write(paramShort & 0xFF);
      this.stream.write(paramShort >>> 8 & 0xFF);
      return this;
    }
  }
  
  private static final class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    ExposedByteArrayOutputStream(int paramInt)
    {
      super();
    }
    
    byte[] byteArray()
    {
      return this.buf;
    }
    
    int length()
    {
      return this.count;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/AbstractNonStreamingHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */