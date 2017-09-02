package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=true)
public final class UnsignedInteger
  extends Number
  implements Comparable<UnsignedInteger>
{
  public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);
  public static final UnsignedInteger ONE;
  public static final UnsignedInteger ZERO = fromIntBits(0);
  private final int value;
  
  static
  {
    ONE = fromIntBits(1);
  }
  
  private UnsignedInteger(int paramInt)
  {
    this.value = (paramInt & 0xFFFFFFFF);
  }
  
  public static UnsignedInteger fromIntBits(int paramInt)
  {
    return new UnsignedInteger(paramInt);
  }
  
  public static UnsignedInteger valueOf(long paramLong)
  {
    if ((0xFFFFFFFF & paramLong) == paramLong) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned integer value", new Object[] { Long.valueOf(paramLong) });
      return fromIntBits((int)paramLong);
    }
  }
  
  public static UnsignedInteger valueOf(String paramString)
  {
    return valueOf(paramString, 10);
  }
  
  public static UnsignedInteger valueOf(String paramString, int paramInt)
  {
    return fromIntBits(UnsignedInts.parseUnsignedInt(paramString, paramInt));
  }
  
  public static UnsignedInteger valueOf(BigInteger paramBigInteger)
  {
    Preconditions.checkNotNull(paramBigInteger);
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 32)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned integer value", new Object[] { paramBigInteger });
      return fromIntBits(paramBigInteger.intValue());
    }
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.valueOf(longValue());
  }
  
  public int compareTo(UnsignedInteger paramUnsignedInteger)
  {
    Preconditions.checkNotNull(paramUnsignedInteger);
    return UnsignedInts.compare(this.value, paramUnsignedInteger.value);
  }
  
  public UnsignedInteger dividedBy(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(UnsignedInts.divide(this.value, ((UnsignedInteger)Preconditions.checkNotNull(paramUnsignedInteger)).value));
  }
  
  public double doubleValue()
  {
    return longValue();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof UnsignedInteger))
    {
      paramObject = (UnsignedInteger)paramObject;
      bool1 = bool2;
      if (this.value == ((UnsignedInteger)paramObject).value) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return (float)longValue();
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return UnsignedInts.toLong(this.value);
  }
  
  public UnsignedInteger minus(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(this.value - ((UnsignedInteger)Preconditions.checkNotNull(paramUnsignedInteger)).value);
  }
  
  public UnsignedInteger mod(UnsignedInteger paramUnsignedInteger)
  {
    return fromIntBits(UnsignedInts.remainder(this.value, ((UnsignedInteger)Preconditions.checkNotNull(paramUnsignedInteger)).value));
  }
  
  public UnsignedInteger plus(UnsignedInteger paramUnsignedInteger)
  {
    int i = this.value;
    return fromIntBits(((UnsignedInteger)Preconditions.checkNotNull(paramUnsignedInteger)).value + i);
  }
  
  @GwtIncompatible("Does not truncate correctly")
  public UnsignedInteger times(UnsignedInteger paramUnsignedInteger)
  {
    int i = this.value;
    return fromIntBits(((UnsignedInteger)Preconditions.checkNotNull(paramUnsignedInteger)).value * i);
  }
  
  public String toString()
  {
    return toString(10);
  }
  
  public String toString(int paramInt)
  {
    return UnsignedInts.toString(this.value, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/UnsignedInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */