package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public abstract class CharSink
{
  public Writer openBufferedStream()
    throws IOException
  {
    Writer localWriter = openStream();
    if ((localWriter instanceof BufferedWriter)) {
      return (BufferedWriter)localWriter;
    }
    return new BufferedWriter(localWriter);
  }
  
  public abstract Writer openStream()
    throws IOException;
  
  public void write(CharSequence paramCharSequence)
    throws IOException
  {
    Preconditions.checkNotNull(paramCharSequence);
    Closer localCloser = Closer.create();
    try
    {
      Writer localWriter = (Writer)localCloser.register(openStream());
      localWriter.append(paramCharSequence);
      localWriter.flush();
      return;
    }
    catch (Throwable paramCharSequence)
    {
      throw localCloser.rethrow(paramCharSequence);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public long writeFrom(Readable paramReadable)
    throws IOException
  {
    Preconditions.checkNotNull(paramReadable);
    Closer localCloser = Closer.create();
    try
    {
      Writer localWriter = (Writer)localCloser.register(openStream());
      long l = CharStreams.copy(paramReadable, localWriter);
      localWriter.flush();
      return l;
    }
    catch (Throwable paramReadable)
    {
      throw localCloser.rethrow(paramReadable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public void writeLines(Iterable<? extends CharSequence> paramIterable)
    throws IOException
  {
    writeLines(paramIterable, System.getProperty("line.separator"));
  }
  
  public void writeLines(Iterable<? extends CharSequence> paramIterable, String paramString)
    throws IOException
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramString);
    Closer localCloser = Closer.create();
    Writer localWriter;
    try
    {
      localWriter = (Writer)localCloser.register(openBufferedStream());
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localWriter.append((CharSequence)paramIterable.next()).append(paramString);
      }
    }
    catch (Throwable paramIterable)
    {
      throw localCloser.rethrow(paramIterable);
    }
    finally
    {
      localCloser.close();
    }
    localCloser.close();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/CharSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */