package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

public final class LogId
{
  private static final AtomicLong idAlloc = new AtomicLong();
  private final long id;
  private final String tag;
  
  private LogId(String paramString, long paramLong)
  {
    this.tag = paramString;
    this.id = paramLong;
  }
  
  public static LogId allocate(String paramString)
  {
    return new LogId(paramString, idAlloc.incrementAndGet());
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public String toString()
  {
    return this.tag + "-" + this.id;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/internal/LogId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */