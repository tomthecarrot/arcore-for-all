package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class CountingInputStream
  extends FilterInputStream
{
  private long count;
  private long mark = -1L;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super((InputStream)Preconditions.checkNotNull(paramInputStream));
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.mark = this.count;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      this.count += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.count += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (!this.in.markSupported()) {
        throw new IOException("Mark not supported");
      }
    }
    finally {}
    if (this.mark == -1L) {
      throw new IOException("Mark not set");
    }
    this.in.reset();
    this.count = this.mark;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = this.in.skip(paramLong);
    this.count += paramLong;
    return paramLong;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/CountingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */