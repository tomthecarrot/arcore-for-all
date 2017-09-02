package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible(emulated=true)
public final class BigIntegerMath
{
  private static final double LN_10 = Math.log(10.0D);
  private static final double LN_2 = Math.log(2.0D);
  @VisibleForTesting
  static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
  @VisibleForTesting
  static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
  
  public static BigInteger binomial(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    if (paramInt2 <= paramInt1) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "k (%s) > n (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      i = paramInt2;
      if (paramInt2 > paramInt1 >> 1) {
        i = paramInt1 - paramInt2;
      }
      if ((i >= LongMath.biggestBinomials.length) || (paramInt1 > LongMath.biggestBinomials[i])) {
        break;
      }
      return BigInteger.valueOf(LongMath.binomial(paramInt1, i));
    }
    BigInteger localBigInteger = BigInteger.ONE;
    long l1 = paramInt1;
    long l2 = 1L;
    int j = LongMath.log2(paramInt1, RoundingMode.CEILING);
    paramInt2 = j;
    int k = 1;
    if (k < i)
    {
      int m = paramInt1 - k;
      int n = k + 1;
      if (paramInt2 + j >= 63)
      {
        localBigInteger = localBigInteger.multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
        l1 = m;
        l2 = n;
        paramInt2 = j;
      }
      for (;;)
      {
        k += 1;
        break;
        l1 *= m;
        l2 *= n;
        paramInt2 += j;
      }
    }
    return localBigInteger.multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
  }
  
  @GwtIncompatible("TODO")
  public static BigInteger divide(BigInteger paramBigInteger1, BigInteger paramBigInteger2, RoundingMode paramRoundingMode)
  {
    return new BigDecimal(paramBigInteger1).divide(new BigDecimal(paramBigInteger2), 0, paramRoundingMode).toBigIntegerExact();
  }
  
  public static BigInteger factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt < LongMath.factorials.length) {
      return BigInteger.valueOf(LongMath.factorials[paramInt]);
    }
    ArrayList localArrayList = new ArrayList(IntMath.divide(IntMath.log2(paramInt, RoundingMode.CEILING) * paramInt, 64, RoundingMode.CEILING));
    int k = LongMath.factorials.length;
    long l1 = LongMath.factorials[(k - 1)];
    int j = Long.numberOfTrailingZeros(l1);
    l1 >>= j;
    int i = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
    int m = LongMath.log2(k, RoundingMode.FLOOR) + 1;
    int n = 1 << m - 1;
    long l2 = k;
    while (l2 <= paramInt)
    {
      int i1 = m;
      k = n;
      if ((n & l2) != 0L)
      {
        k = n << 1;
        i1 = m + 1;
      }
      m = Long.numberOfTrailingZeros(l2);
      j += m;
      long l3 = l1;
      if (i1 - m + i >= 64)
      {
        localArrayList.add(BigInteger.valueOf(l1));
        l3 = 1L;
      }
      l1 = l3 * (l2 >> m);
      i = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
      l2 += 1L;
      m = i1;
      n = k;
    }
    if (l1 > 1L) {
      localArrayList.add(BigInteger.valueOf(l1));
    }
    return listProduct(localArrayList).shiftLeft(j);
  }
  
  @GwtIncompatible("TODO")
  static boolean fitsInLong(BigInteger paramBigInteger)
  {
    return paramBigInteger.bitLength() <= 63;
  }
  
  public static boolean isPowerOfTwo(BigInteger paramBigInteger)
  {
    Preconditions.checkNotNull(paramBigInteger);
    return (paramBigInteger.signum() > 0) && (paramBigInteger.getLowestSetBit() == paramBigInteger.bitLength() - 1);
  }
  
  static BigInteger listProduct(List<BigInteger> paramList)
  {
    return listProduct(paramList, 0, paramList.size());
  }
  
  static BigInteger listProduct(List<BigInteger> paramList, int paramInt1, int paramInt2)
  {
    switch (paramInt2 - paramInt1)
    {
    default: 
      int i = paramInt2 + paramInt1 >>> 1;
      return listProduct(paramList, paramInt1, i).multiply(listProduct(paramList, i, paramInt2));
    case 0: 
      return BigInteger.ONE;
    case 1: 
      return (BigInteger)paramList.get(paramInt1);
    case 2: 
      return ((BigInteger)paramList.get(paramInt1)).multiply((BigInteger)paramList.get(paramInt1 + 1));
    }
    return ((BigInteger)paramList.get(paramInt1)).multiply((BigInteger)paramList.get(paramInt1 + 1)).multiply((BigInteger)paramList.get(paramInt1 + 2));
  }
  
  @GwtIncompatible("TODO")
  public static int log10(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramBigInteger);
    int i;
    if (fitsInLong(paramBigInteger)) {
      i = LongMath.log10(paramBigInteger.longValue(), paramRoundingMode);
    }
    Object localObject2;
    int k;
    do
    {
      do
      {
        return i;
        int j = (int)(log2(paramBigInteger, RoundingMode.FLOOR) * LN_2 / LN_10);
        localObject2 = BigInteger.TEN.pow(j);
        k = ((BigInteger)localObject2).compareTo(paramBigInteger);
        Object localObject1;
        int m;
        if (k > 0)
        {
          do
          {
            k = j - 1;
            localObject1 = ((BigInteger)localObject2).divide(BigInteger.TEN);
            m = ((BigInteger)localObject1).compareTo(paramBigInteger);
            j = k;
            localObject2 = localObject1;
          } while (m > 0);
          localObject2 = localObject1;
          i = k;
        }
        switch (paramRoundingMode)
        {
        case ???: 
        case ???: 
        default: 
          throw new AssertionError();
          localObject1 = BigInteger.TEN.multiply((BigInteger)localObject2);
          i = ((BigInteger)localObject1).compareTo(paramBigInteger);
          for (;;)
          {
            m = k;
            k = j;
            if (i > 0) {
              break;
            }
            j += 1;
            BigInteger localBigInteger = BigInteger.TEN.multiply((BigInteger)localObject1);
            m = localBigInteger.compareTo(paramBigInteger);
            k = i;
            localObject2 = localObject1;
            i = m;
            localObject1 = localBigInteger;
          }
        case ???: 
          if (m == 0) {}
          for (boolean bool = true;; bool = false)
          {
            MathPreconditions.checkRoundingUnnecessary(bool);
            return k;
          }
        case ???: 
        case ???: 
          i = k;
        }
      } while (((BigInteger)localObject2).equals(paramBigInteger));
      return k + 1;
      i = k;
    } while (paramBigInteger.pow(2).compareTo(((BigInteger)localObject2).pow(2).multiply(BigInteger.TEN)) <= 0);
    return k + 1;
  }
  
  public static int log2(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", (BigInteger)Preconditions.checkNotNull(paramBigInteger));
    int i = paramBigInteger.bitLength() - 1;
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramBigInteger));
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (isPowerOfTwo(paramBigInteger));
        return i + 1;
        if (i >= 256) {
          break;
        }
      } while (paramBigInteger.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - i)) <= 0);
      return i + 1;
    } while (paramBigInteger.pow(2).bitLength() - 1 < i * 2 + 1);
    return i + 1;
  }
  
  @GwtIncompatible("TODO")
  public static BigInteger sqrt(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramBigInteger);
    Object localObject;
    if (fitsInLong(paramBigInteger)) {
      localObject = BigInteger.valueOf(LongMath.sqrt(paramBigInteger.longValue(), paramRoundingMode));
    }
    BigInteger localBigInteger;
    do
    {
      return (BigInteger)localObject;
      localBigInteger = sqrtFloor(paramBigInteger);
      localObject = localBigInteger;
      switch (paramRoundingMode)
      {
      case ???: 
      case ???: 
      default: 
        throw new AssertionError();
      case ???: 
        MathPreconditions.checkRoundingUnnecessary(localBigInteger.pow(2).equals(paramBigInteger));
        return localBigInteger;
      case ???: 
      case ???: 
        int i = localBigInteger.intValue();
        if ((i * i == paramBigInteger.intValue()) && (localBigInteger.pow(2).equals(paramBigInteger))) {}
        for (i = 1;; i = 0)
        {
          localObject = localBigInteger;
          if (i != 0) {
            break;
          }
          return localBigInteger.add(BigInteger.ONE);
        }
      }
      localObject = localBigInteger;
    } while (localBigInteger.pow(2).add(localBigInteger).compareTo(paramBigInteger) >= 0);
    return localBigInteger.add(BigInteger.ONE);
  }
  
  @GwtIncompatible("TODO")
  private static BigInteger sqrtApproxWithDoubles(BigInteger paramBigInteger)
  {
    return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(paramBigInteger)), RoundingMode.HALF_EVEN);
  }
  
  @GwtIncompatible("TODO")
  private static BigInteger sqrtFloor(BigInteger paramBigInteger)
  {
    int i = log2(paramBigInteger, RoundingMode.FLOOR);
    if (i < 1023) {}
    BigInteger localBigInteger2;
    BigInteger localBigInteger1;
    for (Object localObject = sqrtApproxWithDoubles(paramBigInteger);; localObject = sqrtApproxWithDoubles(paramBigInteger.shiftRight(i)).shiftLeft(i >> 1))
    {
      localBigInteger2 = ((BigInteger)localObject).add(paramBigInteger.divide((BigInteger)localObject)).shiftRight(1);
      localBigInteger1 = localBigInteger2;
      if (!((BigInteger)localObject).equals(localBigInteger2)) {
        break;
      }
      return (BigInteger)localObject;
      i = i - 52 & 0xFFFFFFFE;
    }
    do
    {
      localObject = localBigInteger1;
      localBigInteger2 = ((BigInteger)localObject).add(paramBigInteger.divide((BigInteger)localObject)).shiftRight(1);
      localBigInteger1 = localBigInteger2;
    } while (localBigInteger2.compareTo((BigInteger)localObject) < 0);
    return (BigInteger)localObject;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/math/BigIntegerMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */