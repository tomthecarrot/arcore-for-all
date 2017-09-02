package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.CheckReturnValue;

@Beta
public final class HashingInputStream
  extends FilterInputStream
{
  private final Hasher hasher;
  
  public HashingInputStream(HashFunction paramHashFunction, InputStream paramInputStream)
  {
    super((InputStream)Preconditions.checkNotNull(paramInputStream));
    this.hasher = ((Hasher)Preconditions.checkNotNull(paramHashFunction.newHasher()));
  }
  
  @CheckReturnValue
  public HashCode hash()
  {
    return this.hasher.hash();
  }
  
  public void mark(int paramInt) {}
  
  @CheckReturnValue
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      this.hasher.putByte((byte)i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 != -1) {
      this.hasher.putBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void reset()
    throws IOException
  {
    throw new IOException("reset not supported");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/hash/HashingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */