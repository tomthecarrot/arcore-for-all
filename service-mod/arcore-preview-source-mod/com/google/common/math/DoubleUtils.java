package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

final class DoubleUtils
{
  static final int EXPONENT_BIAS = 1023;
  static final long EXPONENT_MASK = 9218868437227405312L;
  static final long IMPLICIT_BIT = 4503599627370496L;
  private static final long ONE_BITS = Double.doubleToRawLongBits(1.0D);
  static final int SIGNIFICAND_BITS = 52;
  static final long SIGNIFICAND_MASK = 4503599627370495L;
  static final long SIGN_MASK = Long.MIN_VALUE;
  
  static double bigToDouble(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = paramBigInteger.abs();
    int j = localBigInteger.bitLength() - 1;
    if (j < 63) {
      return paramBigInteger.longValue();
    }
    if (j > 1023) {
      return paramBigInteger.signum() * Double.POSITIVE_INFINITY;
    }
    int i = j - 52 - 1;
    long l2 = localBigInteger.shiftRight(i).longValue();
    long l1 = l2 >> 1 & 0xFFFFFFFFFFFFF;
    if (((1L & l2) != 0L) && (((1L & l1) != 0L) || (localBigInteger.getLowestSetBit() < i)))
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      l1 += 1L;
    }
    label136:
    for (;;)
    {
      return Double.longBitsToDouble((j + 1023 << 52) + l1 | paramBigInteger.signum() & 0x8000000000000000);
      i = 0;
      break;
    }
  }
  
  static double ensureNonNegative(double paramDouble)
  {
    if (!Double.isNaN(paramDouble)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramDouble <= 0.0D) {
        break;
      }
      return paramDouble;
    }
    return 0.0D;
  }
  
  static long getSignificand(double paramDouble)
  {
    Preconditions.checkArgument(isFinite(paramDouble), "not a normal value");
    int i = Math.getExponent(paramDouble);
    long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFF;
    if (i == 64513) {
      return l << 1;
    }
    return 0x10000000000000 | l;
  }
  
  static boolean isFinite(double paramDouble)
  {
    return Math.getExponent(paramDouble) <= 1023;
  }
  
  static boolean isNormal(double paramDouble)
  {
    return Math.getExponent(paramDouble) >= 64514;
  }
  
  static double nextDown(double paramDouble)
  {
    return -Math.nextUp(-paramDouble);
  }
  
  static double scaleNormalize(double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    return Double.longBitsToDouble(ONE_BITS | l & 0xFFFFFFFFFFFFF);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/math/DoubleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */