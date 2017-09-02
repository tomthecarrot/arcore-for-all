package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated=true)
final class LongAddables
{
  private static final Supplier<LongAddable> SUPPLIER;
  
  static
  {
    try
    {
      new LongAdder();
      Supplier local1 = new Supplier()
      {
        public LongAddable get()
        {
          return new LongAdder();
        }
      };
      SUPPLIER = local1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Supplier local2 = new Supplier()
        {
          public LongAddable get()
          {
            return new LongAddables.PureJavaLongAddable(null);
          }
        };
      }
    }
  }
  
  public static LongAddable create()
  {
    return (LongAddable)SUPPLIER.get();
  }
  
  private static final class PureJavaLongAddable
    extends AtomicLong
    implements LongAddable
  {
    public void add(long paramLong)
    {
      getAndAdd(paramLong);
    }
    
    public void increment()
    {
      getAndIncrement();
    }
    
    public long sum()
    {
      return get();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/LongAddables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */