package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nullable;

class AppendableWriter
  extends Writer
{
  private boolean closed;
  private final Appendable target;
  
  AppendableWriter(Appendable paramAppendable)
  {
    this.target = ((Appendable)Preconditions.checkNotNull(paramAppendable));
  }
  
  private void checkNotClosed()
    throws IOException
  {
    if (this.closed) {
      throw new IOException("Cannot write to a closed writer.");
    }
  }
  
  public Writer append(char paramChar)
    throws IOException
  {
    checkNotClosed();
    this.target.append(paramChar);
    return this;
  }
  
  public Writer append(@Nullable CharSequence paramCharSequence)
    throws IOException
  {
    checkNotClosed();
    this.target.append(paramCharSequence);
    return this;
  }
  
  public Writer append(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    this.target.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close()
    throws IOException
  {
    this.closed = true;
    if ((this.target instanceof Closeable)) {
      ((Closeable)this.target).close();
    }
  }
  
  public void flush()
    throws IOException
  {
    checkNotClosed();
    if ((this.target instanceof Flushable)) {
      ((Flushable)this.target).flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    checkNotClosed();
    this.target.append((char)paramInt);
  }
  
  public void write(@Nullable String paramString)
    throws IOException
  {
    checkNotClosed();
    this.target.append(paramString);
  }
  
  public void write(@Nullable String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    this.target.append(paramString, paramInt1, paramInt1 + paramInt2);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    this.target.append(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/AppendableWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */