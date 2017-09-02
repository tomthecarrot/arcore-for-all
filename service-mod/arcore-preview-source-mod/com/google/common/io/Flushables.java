package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public final class Flushables
{
  private static final Logger logger = Logger.getLogger(Flushables.class.getName());
  
  public static void flush(Flushable paramFlushable, boolean paramBoolean)
    throws IOException
  {
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException paramFlushable)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", paramFlushable);
        return;
      }
      throw paramFlushable;
    }
  }
  
  public static void flushQuietly(Flushable paramFlushable)
  {
    try
    {
      flush(paramFlushable, true);
      return;
    }
    catch (IOException paramFlushable)
    {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", paramFlushable);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/io/Flushables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */