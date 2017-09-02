package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public final class UnsignedLong
  extends Number
  implements Comparable<UnsignedLong>, Serializable
{
  public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1L);
  public static final UnsignedLong ONE;
  private static final long UNSIGNED_MASK = Long.MAX_VALUE;
  public static final UnsignedLong ZERO = new UnsignedLong(0L);
  private final long value;
  
  static
  {
    ONE = new UnsignedLong(1L);
  }
  
  private UnsignedLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public static UnsignedLong fromLongBits(long paramLong)
  {
    return new UnsignedLong(paramLong);
  }
  
  public static UnsignedLong valueOf(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", new Object[] { Long.valueOf(paramLong) });
      return fromLongBits(paramLong);
    }
  }
  
  public static UnsignedLong valueOf(String paramString)
  {
    return valueOf(paramString, 10);
  }
  
  public static UnsignedLong valueOf(String paramString, int paramInt)
  {
    return fromLongBits(UnsignedLongs.parseUnsignedLong(paramString, paramInt));
  }
  
  public static UnsignedLong valueOf(BigInteger paramBigInteger)
  {
    Preconditions.checkNotNull(paramBigInteger);
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 64)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", new Object[] { paramBigInteger });
      return fromLongBits(paramBigInteger.longValue());
    }
  }
  
  public BigInteger bigIntegerValue()
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(this.value & 0x7FFFFFFFFFFFFFFF);
    BigInteger localBigInteger1 = localBigInteger2;
    if (this.value < 0L) {
      localBigInteger1 = localBigInteger2.setBit(63);
    }
    return localBigInteger1;
  }
  
  public int compareTo(UnsignedLong paramUnsignedLong)
  {
    Preconditions.checkNotNull(paramUnsignedLong);
    return UnsignedLongs.compare(this.value, paramUnsignedLong.value);
  }
  
  @CheckReturnValue
  public UnsignedLong dividedBy(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  public double doubleValue()
  {
    double d2 = this.value & 0x7FFFFFFFFFFFFFFF;
    double d1 = d2;
    if (this.value < 0L) {
      d1 = d2 + 9.223372036854776E18D;
    }
    return d1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof UnsignedLong))
    {
      paramObject = (UnsignedLong)paramObject;
      bool1 = bool2;
      if (this.value == ((UnsignedLong)paramObject).value) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    float f2 = (float)(this.value & 0x7FFFFFFFFFFFFFFF);
    float f1 = f2;
    if (this.value < 0L) {
      f1 = f2 + 9.223372E18F;
    }
    return f1;
  }
  
  public int hashCode()
  {
    return Longs.hashCode(this.value);
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  @CheckReturnValue
  public UnsignedLong minus(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(this.value - ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value);
  }
  
  @CheckReturnValue
  public UnsignedLong mod(UnsignedLong paramUnsignedLong)
  {
    return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  @CheckReturnValue
  public UnsignedLong plus(UnsignedLong paramUnsignedLong)
  {
    long l = this.value;
    return fromLongBits(((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value + l);
  }
  
  @CheckReturnValue
  public UnsignedLong times(UnsignedLong paramUnsignedLong)
  {
    long l = this.value;
    return fromLongBits(((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value * l);
  }
  
  public String toString()
  {
    return UnsignedLongs.toString(this.value);
  }
  
  public String toString(int paramInt)
  {
    return UnsignedLongs.toString(this.value, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/UnsignedLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */