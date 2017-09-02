package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated=true)
public final class DoubleMath
{
  private static final double LN_2 = Math.log(2.0D);
  @VisibleForTesting
  static final int MAX_FACTORIAL = 170;
  private static final double MAX_INT_AS_DOUBLE = 2.147483647E9D;
  private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18D;
  private static final double MIN_INT_AS_DOUBLE = -2.147483648E9D;
  private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18D;
  @VisibleForTesting
  static final double[] everySixteenthFactorial = { 1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 4.7147236359920616E284D };
  
  @GwtIncompatible("com.google.common.math.DoubleUtils")
  private static double checkFinite(double paramDouble)
  {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return paramDouble;
  }
  
  public static double factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt > 170) {
      return Double.POSITIVE_INFINITY;
    }
    double d = 1.0D;
    int i = (paramInt & 0xFFFFFFF0) + 1;
    while (i <= paramInt)
    {
      d *= i;
      i += 1;
    }
    return everySixteenthFactorial[(paramInt >> 4)] * d;
  }
  
  public static int fuzzyCompare(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (fuzzyEquals(paramDouble1, paramDouble2, paramDouble3)) {
      return 0;
    }
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    return Booleans.compare(Double.isNaN(paramDouble1), Double.isNaN(paramDouble2));
  }
  
  public static boolean fuzzyEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    MathPreconditions.checkNonNegative("tolerance", paramDouble3);
    return (Math.copySign(paramDouble1 - paramDouble2, 1.0D) <= paramDouble3) || (paramDouble1 == paramDouble2) || ((Double.isNaN(paramDouble1)) && (Double.isNaN(paramDouble2)));
  }
  
  @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
  public static boolean isMathematicalInteger(double paramDouble)
  {
    return (DoubleUtils.isFinite(paramDouble)) && ((paramDouble == 0.0D) || (52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(paramDouble)) <= Math.getExponent(paramDouble)));
  }
  
  @GwtIncompatible("com.google.common.math.DoubleUtils")
  public static boolean isPowerOfTwo(double paramDouble)
  {
    return (paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble)) && (LongMath.isPowerOfTwo(DoubleUtils.getSignificand(paramDouble)));
  }
  
  public static double log2(double paramDouble)
  {
    return Math.log(paramDouble) / LN_2;
  }
  
  @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
  public static int log2(double paramDouble, RoundingMode paramRoundingMode)
  {
    int m = 1;
    int j = 1;
    boolean bool;
    int k;
    if ((paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble)))
    {
      bool = true;
      Preconditions.checkArgument(bool, "x must be positive and finite");
      k = Math.getExponent(paramDouble);
      if (DoubleUtils.isNormal(paramDouble)) {
        break label65;
      }
      j = log2(4.503599627370496E15D * paramDouble, paramRoundingMode) - 52;
    }
    label65:
    do
    {
      return j;
      bool = false;
      break;
      switch (paramRoundingMode)
      {
      default: 
        throw new AssertionError();
      case ???: 
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramDouble));
      case ???: 
        i = 0;
        j = k;
      }
    } while (i == 0);
    return k + 1;
    if (!isPowerOfTwo(paramDouble)) {}
    for (int i = 1;; i = 0) {
      break;
    }
    if (k < 0)
    {
      i = 1;
      label174:
      if (isPowerOfTwo(paramDouble)) {
        break label194;
      }
    }
    for (;;)
    {
      i &= j;
      break;
      i = 0;
      break label174;
      label194:
      j = 0;
    }
    if (k >= 0)
    {
      i = 1;
      label207:
      if (isPowerOfTwo(paramDouble)) {
        break label231;
      }
    }
    label231:
    for (j = m;; j = 0)
    {
      i &= j;
      break;
      i = 0;
      break label207;
    }
    paramDouble = DoubleUtils.scaleNormalize(paramDouble);
    if (paramDouble * paramDouble > 2.0D) {}
    for (i = 1;; i = 0) {
      break;
    }
  }
  
  @GwtIncompatible("com.google.common.math.DoubleUtils")
  public static double mean(Iterable<? extends Number> paramIterable)
  {
    return mean(paramIterable.iterator());
  }
  
  @GwtIncompatible("com.google.common.math.DoubleUtils")
  public static double mean(Iterator<? extends Number> paramIterator)
  {
    Preconditions.checkArgument(paramIterator.hasNext(), "Cannot take mean of 0 values");
    long l = 1L;
    double d2;
    for (double d1 = checkFinite(((Number)paramIterator.next()).doubleValue()); paramIterator.hasNext(); d1 += (d2 - d1) / l)
    {
      d2 = checkFinite(((Number)paramIterator.next()).doubleValue());
      l += 1L;
    }
    return d1;
  }
  
  @GwtIncompatible("com.google.common.math.DoubleUtils")
  public static double mean(double... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      long l = 1L;
      d = checkFinite(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        checkFinite(paramVarArgs[i]);
        l += 1L;
        d += (paramVarArgs[i] - d) / l;
        i += 1;
      }
    }
    return d;
  }
  
  public static double mean(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      l = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        l += paramVarArgs[i];
        i += 1;
      }
    }
    return l / paramVarArgs.length;
  }
  
  public static double mean(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
      long l = 1L;
      d = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        l += 1L;
        d += (paramVarArgs[i] - d) / l;
        i += 1;
      }
    }
    return d;
  }
  
  @GwtIncompatible("#isMathematicalInteger, com.google.common.math.DoubleUtils")
  static double roundIntermediate(double paramDouble, RoundingMode paramRoundingMode)
  {
    if (!DoubleUtils.isFinite(paramDouble)) {
      throw new ArithmeticException("input is infinite or NaN");
    }
    switch (paramRoundingMode)
    {
    default: 
      throw new AssertionError();
    case ???: 
      MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(paramDouble));
    }
    double d;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramDouble;
          } while ((paramDouble >= 0.0D) || (isMathematicalInteger(paramDouble)));
          return paramDouble - 1.0D;
        } while ((paramDouble <= 0.0D) || (isMathematicalInteger(paramDouble)));
        return paramDouble + 1.0D;
      } while (isMathematicalInteger(paramDouble));
      return paramDouble + Math.copySign(1.0D, paramDouble);
      return Math.rint(paramDouble);
      d = Math.rint(paramDouble);
      if (Math.abs(paramDouble - d) == 0.5D) {
        return paramDouble + Math.copySign(0.5D, paramDouble);
      }
      return d;
      d = Math.rint(paramDouble);
    } while (Math.abs(paramDouble - d) == 0.5D);
    return d;
  }
  
  @GwtIncompatible("#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
  public static BigInteger roundToBigInteger(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (-9.223372036854776E18D - paramDouble < 1.0D)
    {
      i = 1;
      if (paramDouble >= 9.223372036854776E18D) {
        break label49;
      }
      label29:
      if ((j & i) == 0) {
        break label55;
      }
      paramRoundingMode = BigInteger.valueOf(paramDouble);
    }
    label49:
    label55:
    BigInteger localBigInteger;
    do
    {
      return paramRoundingMode;
      i = 0;
      break;
      j = 0;
      break label29;
      i = Math.getExponent(paramDouble);
      localBigInteger = BigInteger.valueOf(DoubleUtils.getSignificand(paramDouble)).shiftLeft(i - 52);
      paramRoundingMode = localBigInteger;
    } while (paramDouble >= 0.0D);
    return localBigInteger.negate();
  }
  
  @GwtIncompatible("#roundIntermediate")
  public static int roundToInt(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (paramDouble > -2.147483649E9D)
    {
      i = 1;
      if (paramDouble >= 2.147483648E9D) {
        break label42;
      }
    }
    for (;;)
    {
      MathPreconditions.checkInRange(j & i);
      return (int)paramDouble;
      i = 0;
      break;
      label42:
      j = 0;
    }
  }
  
  @GwtIncompatible("#roundIntermediate")
  public static long roundToLong(double paramDouble, RoundingMode paramRoundingMode)
  {
    int j = 1;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i;
    if (-9.223372036854776E18D - paramDouble < 1.0D)
    {
      i = 1;
      if (paramDouble >= 9.223372036854776E18D) {
        break label44;
      }
    }
    for (;;)
    {
      MathPreconditions.checkInRange(j & i);
      return paramDouble;
      i = 0;
      break;
      label44:
      j = 0;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/math/DoubleMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */