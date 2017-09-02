package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.RoundingMode;

@GwtCompatible(emulated=true)
public final class IntMath
{
  @VisibleForTesting
  static final int FLOOR_SQRT_MAX_INT = 46340;
  @VisibleForTesting
  static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
  @VisibleForTesting
  static int[] biggestBinomials = { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
  private static final int[] factorials;
  @VisibleForTesting
  static final int[] halfPowersOf10;
  @VisibleForTesting
  static final byte[] maxLog10ForLeadingZeros = { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
  @VisibleForTesting
  static final int[] powersOf10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  static
  {
    halfPowersOf10 = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
    factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
  }
  
  @GwtIncompatible("need BigIntegerMath to adequately test")
  public static int binomial(int paramInt1, int paramInt2)
  {
    int j = 1;
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
      if ((i < biggestBinomials.length) && (paramInt1 <= biggestBinomials[i])) {
        break;
      }
      paramInt2 = Integer.MAX_VALUE;
      return paramInt2;
    }
    paramInt2 = j;
    long l;
    switch (i)
    {
    case 0: 
    default: 
      l = 1L;
      paramInt2 = 0;
    }
    while (paramInt2 < i)
    {
      l = l * (paramInt1 - paramInt2) / (paramInt2 + 1);
      paramInt2 += 1;
      continue;
      return paramInt1;
    }
    return (int)l;
  }
  
  public static int checkedAdd(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int checkedMultiply(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int checkedPow(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    int i;
    int k;
    switch (paramInt1)
    {
    default: 
      j = 1;
      i = paramInt2;
      do
      {
        switch (i)
        {
        default: 
          paramInt2 = j;
          if ((i & 0x1) != 0) {
            paramInt2 = checkedMultiply(j, paramInt1);
          }
          k = i >> 1;
          j = paramInt2;
          i = k;
        }
      } while (k <= 0);
      if (-46340 <= paramInt1)
      {
        i = 1;
        label113:
        if (paramInt1 > 46340) {
          break label218;
        }
      }
      break;
    }
    label218:
    for (int j = 1;; j = 0)
    {
      MathPreconditions.checkNoOverflow(j & i);
      paramInt1 *= paramInt1;
      j = paramInt2;
      i = k;
      break;
      if (paramInt2 == 0) {}
      do
      {
        return 1;
        return 0;
      } while ((paramInt2 & 0x1) == 0);
      return -1;
      if (paramInt2 < 31) {
        bool1 = true;
      }
      MathPreconditions.checkNoOverflow(bool1);
      return 1 << paramInt2;
      bool1 = bool2;
      if (paramInt2 < 32) {
        bool1 = true;
      }
      MathPreconditions.checkNoOverflow(bool1);
      if ((paramInt2 & 0x1) == 0) {
        return 1 << paramInt2;
      }
      return -1 << paramInt2;
      return j;
      return checkedMultiply(j, paramInt1);
      i = 0;
      break label113;
    }
  }
  
  public static int checkedSubtract(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    if (l == (int)l) {}
    for (boolean bool = true;; bool = false)
    {
      MathPreconditions.checkNoOverflow(bool);
      return (int)l;
    }
  }
  
  public static int divide(int paramInt1, int paramInt2, RoundingMode paramRoundingMode)
  {
    boolean bool = true;
    Preconditions.checkNotNull(paramRoundingMode);
    if (paramInt2 == 0) {
      throw new ArithmeticException("/ by zero");
    }
    int i = paramInt1 / paramInt2;
    int k = paramInt1 - paramInt2 * i;
    if (k == 0) {
      return i;
    }
    int j = (paramInt1 ^ paramInt2) >> 31 | 0x1;
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      if (k == 0) {
        MathPreconditions.checkRoundingUnnecessary(bool);
      }
    case ???: 
    case ???: 
      for (paramInt1 = 0; paramInt1 != 0; paramInt1 = 1)
      {
        return i + j;
        bool = false;
        break label117;
      }
    case ???: 
      if (j > 0) {}
      for (paramInt1 = 1;; paramInt1 = 0) {
        break;
      }
    case ???: 
      label117:
      if (j < 0) {}
      for (paramInt1 = 1;; paramInt1 = 0) {
        break;
      }
    }
    paramInt1 = Math.abs(k);
    paramInt1 -= Math.abs(paramInt2) - paramInt1;
    if (paramInt1 == 0)
    {
      if (paramRoundingMode != RoundingMode.HALF_UP)
      {
        if (paramRoundingMode != RoundingMode.HALF_EVEN) {
          break label228;
        }
        paramInt1 = 1;
        label209:
        if ((i & 0x1) == 0) {
          break label233;
        }
        paramInt2 = 1;
        label217:
        if ((paramInt2 & paramInt1) == 0) {
          break label238;
        }
      }
      label228:
      label233:
      label238:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        break;
        paramInt1 = 0;
        break label209;
        paramInt2 = 0;
        break label217;
      }
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      break;
    }
  }
  
  public static int factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt < factorials.length) {
      return factorials[paramInt];
    }
    return Integer.MAX_VALUE;
  }
  
  public static int gcd(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("a", paramInt1);
    MathPreconditions.checkNonNegative("b", paramInt2);
    if (paramInt1 == 0) {
      i = paramInt2;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 == 0);
    int j = Integer.numberOfTrailingZeros(paramInt1);
    int i = paramInt1 >> j;
    int k = Integer.numberOfTrailingZeros(paramInt2);
    paramInt1 = paramInt2 >> k;
    for (paramInt2 = i; paramInt2 != paramInt1; paramInt2 = i >> Integer.numberOfTrailingZeros(i))
    {
      i = paramInt2 - paramInt1;
      paramInt2 = i & i >> 31;
      i = i - paramInt2 - paramInt2;
      paramInt1 += paramInt2;
    }
    return paramInt2 << Math.min(j, k);
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt > 0)
    {
      i = 1;
      if ((paramInt - 1 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (paramInt = j;; paramInt = 0)
    {
      return paramInt & i;
      i = 0;
      break;
    }
  }
  
  @VisibleForTesting
  static int lessThanBranchFree(int paramInt1, int paramInt2)
  {
    return (paramInt1 - paramInt2 ^ 0xFFFFFFFF ^ 0xFFFFFFFF) >>> 31;
  }
  
  @GwtIncompatible("need BigIntegerMath to adequately test")
  public static int log10(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    int i = log10Floor(paramInt);
    int j = powersOf10[i];
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      if (paramInt != j) {
        break;
      }
    case ???: 
    case ???: 
      for (boolean bool = true;; bool = false)
      {
        MathPreconditions.checkRoundingUnnecessary(bool);
        return i;
      }
    case ???: 
    case ???: 
      return i + lessThanBranchFree(j, paramInt);
    }
    return i + lessThanBranchFree(halfPowersOf10[i], paramInt);
  }
  
  private static int log10Floor(int paramInt)
  {
    int i = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(paramInt)];
    return i - lessThanBranchFree(paramInt, powersOf10[i]);
  }
  
  public static int log2(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramInt));
    case ???: 
    case ???: 
      return 31 - Integer.numberOfLeadingZeros(paramInt);
    case ???: 
    case ???: 
      return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
    }
    int i = Integer.numberOfLeadingZeros(paramInt);
    return lessThanBranchFree(-1257966797 >>> i, paramInt) + (31 - i);
  }
  
  public static int mean(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) + ((paramInt1 ^ paramInt2) >> 1);
  }
  
  public static int mod(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new ArithmeticException("Modulus " + paramInt2 + " must be > 0");
    }
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  @GwtIncompatible("failing tests")
  public static int pow(int paramInt1, int paramInt2)
  {
    int i = 0;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    switch (paramInt1)
    {
    default: 
      i = 1;
      switch (paramInt2)
      {
      default: 
        if ((paramInt2 & 0x1) != 0) {}
        break;
      }
      break;
    }
    for (int j = 1;; j = paramInt1)
    {
      i *= j;
      paramInt1 *= paramInt1;
      paramInt2 >>= 1;
      break;
      if (paramInt2 == 0) {}
      do
      {
        return 1;
        return 0;
      } while ((paramInt2 & 0x1) == 0);
      return -1;
      paramInt1 = i;
      if (paramInt2 < 32) {
        paramInt1 = 1 << paramInt2;
      }
      return paramInt1;
      if (paramInt2 < 32)
      {
        if ((paramInt2 & 0x1) == 0) {
          return 1 << paramInt2;
        }
        return -(1 << paramInt2);
      }
      return 0;
      return i;
      return paramInt1 * i;
    }
  }
  
  @GwtIncompatible("need BigIntegerMath to adequately test")
  public static int sqrt(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramInt);
    int i = sqrtFloor(paramInt);
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      if (i * i != paramInt) {
        break;
      }
    case ???: 
    case ???: 
      for (boolean bool = true;; bool = false)
      {
        MathPreconditions.checkRoundingUnnecessary(bool);
        return i;
      }
    case ???: 
    case ???: 
      return i + lessThanBranchFree(i * i, paramInt);
    }
    return i + lessThanBranchFree(i * i + i, paramInt);
  }
  
  private static int sqrtFloor(int paramInt)
  {
    return (int)Math.sqrt(paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/math/IntMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */