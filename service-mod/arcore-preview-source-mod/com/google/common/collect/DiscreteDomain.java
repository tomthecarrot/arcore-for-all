package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

@Beta
@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable>
{
  public static DiscreteDomain<BigInteger> bigIntegers()
  {
    return BigIntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Integer> integers()
  {
    return IntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Long> longs()
  {
    return LongDomain.INSTANCE;
  }
  
  public abstract long distance(C paramC1, C paramC2);
  
  public C maxValue()
  {
    throw new NoSuchElementException();
  }
  
  public C minValue()
  {
    throw new NoSuchElementException();
  }
  
  public abstract C next(C paramC);
  
  public abstract C previous(C paramC);
  
  private static final class BigIntegerDomain
    extends DiscreteDomain<BigInteger>
    implements Serializable
  {
    private static final BigIntegerDomain INSTANCE = new BigIntegerDomain();
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      return paramBigInteger2.subtract(paramBigInteger1).max(MIN_LONG).min(MAX_LONG).longValue();
    }
    
    public BigInteger next(BigInteger paramBigInteger)
    {
      return paramBigInteger.add(BigInteger.ONE);
    }
    
    public BigInteger previous(BigInteger paramBigInteger)
    {
      return paramBigInteger.subtract(BigInteger.ONE);
    }
    
    public String toString()
    {
      return "DiscreteDomain.bigIntegers()";
    }
  }
  
  private static final class IntegerDomain
    extends DiscreteDomain<Integer>
    implements Serializable
  {
    private static final IntegerDomain INSTANCE = new IntegerDomain();
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(Integer paramInteger1, Integer paramInteger2)
    {
      return paramInteger2.intValue() - paramInteger1.intValue();
    }
    
    public Integer maxValue()
    {
      return Integer.valueOf(Integer.MAX_VALUE);
    }
    
    public Integer minValue()
    {
      return Integer.valueOf(Integer.MIN_VALUE);
    }
    
    public Integer next(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == Integer.MAX_VALUE) {
        return null;
      }
      return Integer.valueOf(i + 1);
    }
    
    public Integer previous(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == Integer.MIN_VALUE) {
        return null;
      }
      return Integer.valueOf(i - 1);
    }
    
    public String toString()
    {
      return "DiscreteDomain.integers()";
    }
  }
  
  private static final class LongDomain
    extends DiscreteDomain<Long>
    implements Serializable
  {
    private static final LongDomain INSTANCE = new LongDomain();
    private static final long serialVersionUID = 0L;
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public long distance(Long paramLong1, Long paramLong2)
    {
      long l2 = paramLong2.longValue() - paramLong1.longValue();
      long l1;
      if ((paramLong2.longValue() > paramLong1.longValue()) && (l2 < 0L)) {
        l1 = Long.MAX_VALUE;
      }
      do
      {
        do
        {
          return l1;
          l1 = l2;
        } while (paramLong2.longValue() >= paramLong1.longValue());
        l1 = l2;
      } while (l2 <= 0L);
      return Long.MIN_VALUE;
    }
    
    public Long maxValue()
    {
      return Long.valueOf(Long.MAX_VALUE);
    }
    
    public Long minValue()
    {
      return Long.valueOf(Long.MIN_VALUE);
    }
    
    public Long next(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == Long.MAX_VALUE) {
        return null;
      }
      return Long.valueOf(1L + l);
    }
    
    public Long previous(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == Long.MIN_VALUE) {
        return null;
      }
      return Long.valueOf(l - 1L);
    }
    
    public String toString()
    {
      return "DiscreteDomain.longs()";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/DiscreteDomain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */