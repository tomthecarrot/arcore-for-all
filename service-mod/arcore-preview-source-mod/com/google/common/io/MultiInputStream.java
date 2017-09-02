package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

final class MultiInputStream
  extends InputStream
{
  private InputStream in;
  private Iterator<? extends ByteSource> it;
  
  public MultiInputStream(Iterator<? extends ByteSource> paramIterator)
    throws IOException
  {
    this.it = ((Iterator)Preconditions.checkNotNull(paramIterator));
    advance();
  }
  
  private void advance()
    throws IOException
  {
    close();
    if (this.it.hasNext()) {
      this.in = ((ByteSource)this.it.next()).openStream();
    }
  }
  
  public int available()
    throws IOException
  {
    if (this.in == null) {
      return 0;
    }
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    if (this.in != null) {}
    try
    {
      this.in.close();
      return;
    }
    finally
    {
      this.in = null;
    }
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i;
    if (this.in == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.in.read();
      i = j;
    } while (j != -1);
    advance();
    return read();
  }
  
  public int read(@Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    if (this.in == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      i = j;
    } while (j != -1);
    advance();
    return read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l1;
    if ((this.in == null) || (paramLong <= 0L)) {
      l1 = 0L;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.in.skip(paramLong);
      l1 = l2;
    } while (l2 != 0L);
    if (read() == -1) {
      return 0L;
    }
    return 1L + this.in.skip(paramLong - 1L);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/MultiInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */