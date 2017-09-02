package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.Nullable;

class MultiReader
  extends Reader
{
  private Reader current;
  private final Iterator<? extends CharSource> it;
  
  MultiReader(Iterator<? extends CharSource> paramIterator)
    throws IOException
  {
    this.it = paramIterator;
    advance();
  }
  
  private void advance()
    throws IOException
  {
    close();
    if (this.it.hasNext()) {
      this.current = ((CharSource)this.it.next()).openStream();
    }
  }
  
  public void close()
    throws IOException
  {
    if (this.current != null) {}
    try
    {
      this.current.close();
      return;
    }
    finally
    {
      this.current = null;
    }
  }
  
  public int read(@Nullable char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    if (this.current == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.current.read(paramArrayOfChar, paramInt1, paramInt2);
      i = j;
    } while (j != -1);
    advance();
    return read(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public boolean ready()
    throws IOException
  {
    return (this.current != null) && (this.current.ready());
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    boolean bool;
    if (paramLong >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool, "n is negative");
      if (paramLong <= 0L) {}
    }
    else
    {
      for (;;)
      {
        if (this.current == null) {
          break label59;
        }
        long l = this.current.skip(paramLong);
        if (l > 0L)
        {
          return l;
          bool = false;
          break;
        }
        advance();
      }
    }
    label59:
    return 0L;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/MultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */