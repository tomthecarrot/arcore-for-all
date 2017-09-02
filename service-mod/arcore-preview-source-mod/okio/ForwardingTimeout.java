package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout
  extends Timeout
{
  private Timeout delegate;
  
  public ForwardingTimeout(Timeout paramTimeout)
  {
    if (paramTimeout == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = paramTimeout;
  }
  
  public Timeout clearDeadline()
  {
    return this.delegate.clearDeadline();
  }
  
  public Timeout clearTimeout()
  {
    return this.delegate.clearTimeout();
  }
  
  public long deadlineNanoTime()
  {
    return this.delegate.deadlineNanoTime();
  }
  
  public Timeout deadlineNanoTime(long paramLong)
  {
    return this.delegate.deadlineNanoTime(paramLong);
  }
  
  public final Timeout delegate()
  {
    return this.delegate;
  }
  
  public boolean hasDeadline()
  {
    return this.delegate.hasDeadline();
  }
  
  public final ForwardingTimeout setDelegate(Timeout paramTimeout)
  {
    if (paramTimeout == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = paramTimeout;
    return this;
  }
  
  public void throwIfReached()
    throws IOException
  {
    this.delegate.throwIfReached();
  }
  
  public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.timeout(paramLong, paramTimeUnit);
  }
  
  public long timeoutNanos()
  {
    return this.delegate.timeoutNanos();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/ForwardingTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */